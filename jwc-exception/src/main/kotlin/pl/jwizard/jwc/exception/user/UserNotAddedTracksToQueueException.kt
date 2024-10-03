/*
 * Copyright (c) 2024 by JWizard
 * Originally developed by Miłosz Gilga <https://miloszgilga.pl>
 */
package pl.jwizard.jwc.exception.user

import pl.jwizard.jwc.core.i18n.source.I18nExceptionSource
import pl.jwizard.jwc.core.jda.command.CommandBaseContext
import pl.jwizard.jwc.exception.CommandPipelineExceptionHandler

/**
 * Exception thrown when an attempt is made to perform an action on tracks from a user who has not added any tracks to
 * the queue.
 *
 * @param commandBaseContext the context of the command where the exception occurred.
 * @param userId the ID of the user who attempted to perform the action without having added tracks to the queue.
 * @author Miłosz Gilga
 */
class UserNotAddedTracksToQueueException(
	commandBaseContext: CommandBaseContext,
	userId: Long,
) : CommandPipelineExceptionHandler(
	commandBaseContext,
	i18nExceptionSource = I18nExceptionSource.USER_NOT_ADDED_TRACKS_TO_QUEUE,
	logMessage = "Attempt to perform action on tracks from user: \"$userId\" which not added any track in queue.",
)
