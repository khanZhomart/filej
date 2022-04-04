package com.filej.commands.dircommands;

import java.io.File;

import com.filej.commands.Command;

public class MakeDirectoryCommand extends DirCommand {
    private static final MakeDirectoryCommand INSTANCE = new MakeDirectoryCommand();

    public static Command getInstance(boolean v, String dn) {
        verbose = v;
        dirname = dn;
        path = stateController.getRealPath() + dirname;
        return INSTANCE;
    }

    @Override
    public void run() throws NullPointerException {
        File dir = new File(path);
        dir.mkdir();
    }
}
