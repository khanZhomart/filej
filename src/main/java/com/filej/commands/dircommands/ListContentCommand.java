package com.filej.commands.dircommands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.filej.commands.Command;

public class ListContentCommand extends DirCommand {
    private static volatile ListContentCommand instance;

    public static Command getInstance() {
        ListContentCommand localInstance = instance;

        if (localInstance == null) {
            synchronized (ListContentCommand.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new ListContentCommand();
                }
            }
        }

        return localInstance;
    }

    public Command acceptArgs(boolean verbose, String dirname) {
        this.verbose = verbose;
        this.dirname = dirname;

        return instance;
    }

    @Override
    public void run() throws InvalidPathException, IOException {
        Path dirPath;

        if (dirname.equals(".")) {
            dirPath = Paths.get(stateController.getRealPath());
        } else {
            dirPath = Paths.get(stateController.getRealPath() + "\\" + dirname);
        }

        Files.list(dirPath)
            .forEach((element) -> System.out.println(element.getFileName()));
    }
}
