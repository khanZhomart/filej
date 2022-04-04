package com.filej.commands.dircommands;

import java.io.File;
import java.util.NoSuchElementException;

import com.filej.commands.Command;

public class ChangeDirectoryCommand extends DirCommand {
    private static final ChangeDirectoryCommand INSTANCE = new ChangeDirectoryCommand();

    public static Command getInstance(boolean v, String dn) {
        verbose = v;
        dirname = dn;
        return INSTANCE;
    }

    @Override
    public void run() throws NoSuchElementException {
        if (!directoryExists()) {
            throw new NoSuchElementException("error: directory does not exist");
        }
        
        if (dirname.equals("..")) {
            stateController.popFromPath();
        } else {
            stateController.pushToPath(dirname);
        }
    }

    private boolean directoryExists() {
        File file = new File(path);
        return file.exists();
    }
}
