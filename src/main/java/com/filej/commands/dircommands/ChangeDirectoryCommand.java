package com.filej.commands.dircommands;

import java.util.NoSuchElementException;

import com.filej.commands.Command;
import com.filej.utils.CommonUtil;

public class ChangeDirectoryCommand extends DirCommand {
    private static volatile ChangeDirectoryCommand instance;

    public static Command getInstance() {
        ChangeDirectoryCommand localInstance = instance;

        if (localInstance == null) {
            synchronized (ChangeDirectoryCommand.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new ChangeDirectoryCommand();
                }
            }
        }

        return localInstance;
    }

    public Command acceptArgs(boolean verbose, String dirname) {
        this.verbose = verbose;
        this.dirname = dirname;
        this.path = stateController.getRealPath() + dirname;

        return instance;
    }

    @Override
    public void run() throws NoSuchElementException {
        if (!CommonUtil.elementExists(path)) {
            throw new NoSuchElementException("error: directory does not exist");
        }
        
        if (dirname.equals("..")) {
            stateController.popFromPath();
        } else {
            stateController.pushToPath(dirname);
        }
    }
}
