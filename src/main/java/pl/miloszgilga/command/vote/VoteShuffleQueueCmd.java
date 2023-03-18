/*
 * Copyright (c) 2023 by MILOSZ GILGA <http://miloszgilga.pl>
 *
 * File name: VoteShuffleQueueCmd.java
 * Last modified: 18/03/2023, 09:26
 * Project name: jwizard-discord-bot
 *
 * Licensed under the MIT license; you may not use this file except in compliance with the License.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * THE ABOVE COPYRIGHT NOTICE AND THIS PERMISSION NOTICE SHALL BE INCLUDED IN ALL
 * COPIES OR SUBSTANTIAL PORTIONS OF THE SOFTWARE.
 */

package pl.miloszgilga.command.vote;

import pl.miloszgilga.BotCommand;
import pl.miloszgilga.audioplayer.PlayerManager;
import pl.miloszgilga.dto.CommandEventWrapper;
import pl.miloszgilga.embed.EmbedMessageBuilder;
import pl.miloszgilga.command.AbstractVoteMusicCommand;
import pl.miloszgilga.core.configuration.BotConfiguration;
import pl.miloszgilga.core.loader.JDAInjectableCommandLazyService;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@JDAInjectableCommandLazyService
public class VoteShuffleQueueCmd extends AbstractVoteMusicCommand {

    VoteShuffleQueueCmd(BotConfiguration config, PlayerManager playerManager, EmbedMessageBuilder embedBuilder) {
        super(BotCommand.VOTE_SHUFFLE_QUEUE, config, playerManager, embedBuilder);
        super.inSameChannelWithBot = true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void doExecuteVoteMusicCommand(CommandEventWrapper event) {

    }
}
