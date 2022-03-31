package com.filej.commands.dircommands;

import java.io.File;

public class MakeDirectoryCommand extends DirCommand {

    public MakeDirectoryCommand(boolean verbose, String dirname) {
        super(verbose, dirname);
        this.path = this.stateController.getRealPath() + dirname;
    }

    @Override
    public void run() throws NullPointerException {
        File dir = new File(this.path);
        dir.mkdir();
    }
}
