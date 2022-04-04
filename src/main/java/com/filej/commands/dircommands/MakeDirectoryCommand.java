package com.filej.commands.dircommands;

import java.io.File;

import com.filej.commands.Command;

public class MakeDirectoryCommand extends DirCommand {
    private static volatile MakeDirectoryCommand instance;

    public static Command getInstance() {
        MakeDirectoryCommand localInstance = instance;

        if (localInstance == null) {
            synchronized (MakeDirectoryCommand.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new MakeDirectoryCommand();
                }
            }
        }

        return localInstance;
    }

    public Command acceptArgs(boolean v, String dn) {
        verbose = v;
        dirname = dn;
        path = stateController.getRealPath() + dirname;

        return instance;
    }

    @Override
    public void run() throws NullPointerException {
        File dir = new File(path);
        dir.mkdir();
    }
}
