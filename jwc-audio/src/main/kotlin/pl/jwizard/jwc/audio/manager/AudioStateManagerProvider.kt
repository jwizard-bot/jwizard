/*
 * Copyright (c) 2024 by JWizard
 * Originally developed by Miłosz Gilga <https://miloszgilga.pl>
 */
package pl.jwizard.jwc.audio.manager

import pl.jwizard.jwc.audio.scheduler.AudioScheduleHandler
import pl.jwizard.jwc.audio.scheduler.QueueTrackScheduleHandler
import pl.jwizard.jwc.audio.scheduler.RadioStreamScheduleHandler
import pl.jwizard.jwc.core.audio.AudioContentType
import pl.jwizard.jwc.core.audio.spi.AudioStateManager
import pl.jwizard.jwc.core.audio.spi.QueueTrackScheduler
import pl.jwizard.jwc.core.audio.spi.RadioStreamScheduler
import pl.jwizard.jwc.core.jda.command.CommandBaseContext
import pl.jwizard.jwc.core.jda.command.TFutureResponse
import pl.jwizard.jwl.radio.RadioStation

/**
 * Manages the state of audio playback in a guild, providing scheduling for queued tracks and radio streams. This class
 * is responsible for switching between audio types and ensuring the correct scheduler is used for each type.
 *
 * @property musicManager Manages the guild's audio player and track scheduler.
 * @property derivedContext The base command context, containing information about the current command execution.
 * @property derivedFuture The future response object to handle command responses asynchronously.
 * @author Miłosz Gilga
 */
class AudioStateManagerProvider(
	private val musicManager: GuildMusicManager,
	private val derivedContext: CommandBaseContext,
	private val derivedFuture: TFutureResponse,
) : AudioStateManager {

	override val audioScheduler get() = audioScheduleHandler
	override val queueTrackScheduler get() = audioScheduler as QueueTrackScheduler
	override val radioStreamScheduler get() = audioScheduler as RadioStreamScheduler

	/**
	 * The current type of audio content being played (either queued tracks or radio streams).
	 */
	private var audioType = AudioContentType.QUEUE_TRACK

	/**
	 * The handler responsible for managing the current audio playback, either for queued tracks or radio streams.
	 */
	private var audioScheduleHandler: AudioScheduleHandler = QueueTrackScheduleHandler(musicManager)

	/**
	 * The context of the current command, used to maintain information related to the ongoing operation.
	 */
	var context = derivedContext
		private set

	/**
	 * The future response object to be updated with command responses asynchronously.
	 */
	var future = derivedFuture
		private set

	/**
	 * Switches the audio state to queued tracks and updates the scheduler to handle track queues.
	 *
	 * @param context The context of the command requesting the switch.
	 */
	fun setToQueueTrack(context: CommandBaseContext) {
		updateState(AudioContentType.QUEUE_TRACK, context)
		if (audioScheduleHandler !is QueueTrackScheduleHandler) {
			audioScheduleHandler = QueueTrackScheduleHandler(musicManager)
		}
	}

	/**
	 * Switches the audio state to a radio stream and updates the scheduler to handle radio streaming.
	 *
	 * @param context The context of the command requesting the switch.
	 * @param radioStation Current selected [RadioStation] property.
	 */
	fun setToStream(context: CommandBaseContext, radioStation: RadioStation) {
		updateState(AudioContentType.STREAM, context)
		audioScheduleHandler = RadioStreamScheduleHandler(musicManager, radioStation)
	}

	/**
	 * Updates the future response and context for the current operation.
	 *
	 * @param future The new future response object.
	 * @param context The context of the command.
	 */
	fun updateFutureResponseAndContext(future: TFutureResponse, context: CommandBaseContext) {
		this.future = future
		this.context = context
	}

	/**
	 * Checks if the current audio content type matches the specified type.
	 *
	 * @param audioType The type of audio content to check against.
	 * @return True if the current audio type matches the specified type, false otherwise.
	 */
	override fun isDeclaredAudioContentType(audioType: AudioContentType) = this.audioType == audioType

	/**
	 * Updates the internal state with the new audio content type and command context.
	 *
	 * @param audioType The new audio content type to switch to.
	 * @param context The command context to be associated with the new state.
	 */
	private fun updateState(audioType: AudioContentType, context: CommandBaseContext) {
		this.audioType = audioType
		this.context = context
	}
}
