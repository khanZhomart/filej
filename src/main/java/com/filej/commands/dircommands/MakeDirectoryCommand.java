package com.filej.commands.dircommands;

import java.io.File;

import com.filej.utils.CommonUtil;

public class MakeDirectoryCommand extends DirCommand {

    public MakeDirectoryCommand(boolean verbose, String dirname) {
        super(verbose, dirname);
        this.path = this.stateController.getRealPath() + dirname;
    }

    @Override
    public void run() throws IllegalArgumentException {
        if (CommonUtil.elementExists(this.path)) {
            throw new IllegalArgumentException("error: provided dirname is already existing.");
        }

        File dir = new File(this.path);
        dir.mkdir();
    }
}
