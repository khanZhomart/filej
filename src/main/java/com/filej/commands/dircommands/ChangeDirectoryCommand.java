package com.filej.commands.dircommands;

import java.io.File;
import java.util.NoSuchElementException;

public class ChangeDirectoryCommand extends DirCommand {

    public ChangeDirectoryCommand(boolean verbose, String dirname) {
        super(verbose, dirname);
    }

    @Override
    public void run() throws Exception {
        if (!exists())
            throw new NoSuchElementException("Directory does not exist");

        if (dirname.equals(".."))
            this.stateController.popFromPath();
        else
            this.stateController.pushToPath(dirname);
    }

    private boolean exists() {
        File file = new File(this.stateController.getRealPath() + dirname);
        return file.exists();
    }
}
