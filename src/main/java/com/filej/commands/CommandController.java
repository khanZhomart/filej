package com.filej.commands;

import java.io.File;

import com.filej.commands.dircommands.*;
import com.filej.commands.filecommands.*;
import com.filej.utils.constants.Commands;

public class CommandController {
    
    public Command defineType(String[] args) throws IllegalArgumentException {
        switch (args[0]) {
            case Commands.MAKE_DIR: 
                return new MakeDirectoryCommand(false, new File(args[2]));

            case Commands.CHANGE_DIR: 
                return new ChangeDirectoryCommand(false, new File(args[2]));

            case Commands.LIST_CONTENT_DIR:
                return new ListContentCommand(false, new File(args[2]));

            case Commands.DELETE_DIR:
                return new DeleteDirCommand(false, false, new File(args[2]));

            case Commands.TOUCH_FILE:
                return new TouchFileCommand(false, new File(args[2]));

            case Commands.WRITE_FILE:
                return new WriteFileCommand(false, new File(args[2]));

            case Commands.READ_FILE:
                return new ReadFileCommand(false, new File(args[2]));

            case Commands.DELETE_FILE:
                return new DeleteFileCommand(false, false, new File(args[2]));

            default:
                throw new IllegalArgumentException("Invalid command, type \"help\" to see the list of available commands.");
        }
    }
}
