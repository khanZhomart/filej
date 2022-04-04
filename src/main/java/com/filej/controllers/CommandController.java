package com.filej.controllers;

import com.filej.commands.Command;
import com.filej.commands.dircommands.*;
import com.filej.commands.filecommands.*;
import com.filej.commands.utilcommands.HelpCommand;
import com.filej.commands.utilcommands.PwdCommand;
import com.filej.utils.constants.Commands;
import com.filej.utils.models.Input;

public class CommandController {
    
    public Command defineType(Input input) throws IllegalArgumentException {
        switch (input.getCommand()) {
            case Commands.MAKE_DIR:
                return MakeDirectoryCommand.getInstance()
                    .acceptArgs(input.verbose(), input.getTarget());

            case Commands.CHANGE_DIR: 
                return ChangeDirectoryCommand.getInstance()
                    .acceptArgs(input.verbose(), input.getTarget());

            case Commands.LIST_CONTENT_DIR:
                return ListContentCommand.getInstance()
                    .acceptArgs(input.verbose(), input.getTarget());

            case Commands.DELETE_DIR:
                return DeleteDirCommand.getInstance()
                    .acceptArgs(input.verbose(), input.force(), input.getTarget());

            case Commands.TOUCH_FILE:
                return TouchFileCommand.getInstance()
                    .acceptArgs(input.verbose(), input.getTarget());

            case Commands.WRITE_FILE:
                return WriteFileCommand.getInstance()
                    .acceptArgs(input.verbose(), input.getTarget());

            case Commands.READ_FILE:
                return ReadFileCommand.getInstance()
                    .acceptArgs(input.verbose(), input.getTarget());

            case Commands.DELETE_FILE:
                return DeleteFileCommand.getInstance()
                    .acceptArgs(input.verbose(), input.force(), input.getTarget());

            case Commands.PWD:
                return PwdCommand.getInstance();

            case Commands.HELP:
                return HelpCommand.getInstance();

            default:
                throw new IllegalArgumentException("error: invalid command, type \"help\" to see the list of available commands.");
        }
    }
}
