package com.filej.controllers;

import com.filej.commands.Command;
import com.filej.commands.HelpCommand;
import com.filej.commands.dircommands.*;
import com.filej.commands.filecommands.*;
import com.filej.utils.constants.Commands;
import com.filej.utils.models.Input;

public class CommandController {
    
    public Command defineType(Input input) throws IllegalArgumentException {
        switch (input.getCommand()) {
            case Commands.MAKE_DIR: 
                return new MakeDirectoryCommand(input.verbose(), input.getTarget());

            case Commands.CHANGE_DIR: 
                return new ChangeDirectoryCommand(input.verbose(), input.getTarget());

            case Commands.LIST_CONTENT_DIR:
                return new ListContentCommand(input.verbose(), input.getTarget());

            case Commands.DELETE_DIR:
                return new DeleteDirCommand(input.verbose(), false, input.getTarget());

            case Commands.TOUCH_FILE:
                return new TouchFileCommand(false, null);

            case Commands.WRITE_FILE:
                return new WriteFileCommand(false, null);

            case Commands.READ_FILE:
                return new ReadFileCommand(false, null);

            case Commands.DELETE_FILE:
                return new DeleteFileCommand(false, false, null);

            case Commands.HELP:
                return new HelpCommand();

            default:
                throw new IllegalArgumentException("Invalid command, type \"help\" to see the list of available commands.");
        }
    }
}
