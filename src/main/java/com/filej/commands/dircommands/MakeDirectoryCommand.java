package com.filej.commands.dircommands;

import java.io.File;

public class MakeDirectoryCommand extends DirCommand {

    public MakeDirectoryCommand(boolean verbose, String dirname) {
        super(verbose, dirname);
    }

    @Override
    public void run() throws Exception {
        String path = this.stateController.getRealPath();

        try {
            File dir = new File(path + dirname);
            dir.mkdir();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
