package com.filej.commands;

import java.io.File;

import com.filej.commands.dircommands.*;
import com.filej.commands.filecommands.*;

public class CommandController {
    
    public Command defineType(String[] args) throws IllegalArgumentException {
        switch (args[0]) {
            case "md": 
                return new MakeDirectoryCommand(false, new File(args[2]));

            case "cd": 
                return new ChangeDirectoryCommand(false, new File(args[2]));

            case "list":
                return new ListContentCommand(false, new File(args[2]));

            case "touch":
                return new TouchFileCommand(false, new File(args[2]));

            case "write":
                return new WriteFileCommand(false, new File(args[2]));

            case "read":
                return new ReadFileCommand(false, new File(args[2]));

            case "del":
                return new DeleteFileCommand(false, false, new File(args[2]));

            case "rmd":
                return new DeleteDirCommand(false, false, new File(args[2]));

            default:
                throw new IllegalArgumentException("Invalid command, type \"help\" to see the list of available commands.");
        }
    }
}
