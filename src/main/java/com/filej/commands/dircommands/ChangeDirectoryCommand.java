package com.filej.commands.dircommands;

import java.io.File;

public class ChangeDirectoryCommand extends DirCommand {

    public ChangeDirectoryCommand(boolean verbose, String dirname) {
        super(verbose, dirname);
    }

    @Override
    public void run() throws Exception {
        if (dirname.equals(".."))
            this.stateController.popFromPath();
        else
            this.stateController.pushToPath(dirname);
    }
}
