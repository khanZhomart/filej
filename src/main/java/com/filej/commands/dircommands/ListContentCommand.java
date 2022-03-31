package com.filej.commands.dircommands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListContentCommand extends DirCommand {

    public ListContentCommand(boolean verbose, String dirname) {
        super(verbose, dirname);
        this.path = this.stateController.getRealPath() + dirname;
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
