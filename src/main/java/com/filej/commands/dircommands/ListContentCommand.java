package com.filej.commands.dircommands;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ListContentCommand extends DirCommand {

    public ListContentCommand(boolean verbose, String dirname) {
        super(verbose, dirname);
    }

    @Override
    public void run() throws Exception {
        Files.list(
                Paths.get(stateController.getRealPath() + (dirname.equals(".") ? "" : "\\" + dirname))
            )
            .forEach((element) -> System.out.println(element.getFileName()));
    }
}
