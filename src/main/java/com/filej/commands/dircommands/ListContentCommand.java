package com.filej.commands.dircommands;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ListContentCommand extends DirCommand {

    public ListContentCommand(boolean verbose, String dirname) {
        super(verbose, dirname);
    }

    @Override
    public void run() throws Exception {
        if (dirname.equals("."))
            Files.list(Paths.get(stateController.getRealPath()))
                .map(element -> element.toString().replace("src\\main\\java\\com\\", ""))
                .forEach(System.out::println);
        else
            Files.list(Paths.get(stateController.getRealPath() + "\\" + dirname))
                .map(element -> element.toString().replace("src\\main\\java\\com\\", ""))
                .forEach(System.out::println);
    }
}
