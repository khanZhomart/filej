package com.filej.commands.dircommands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.filej.commands.Command;

public class ListContentCommand extends DirCommand {
    private static final ListContentCommand INSTANCE = new ListContentCommand();

    public static Command getInstance(boolean v, String dn) {
        verbose = v;
        dirname = dn;
        return INSTANCE;
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
