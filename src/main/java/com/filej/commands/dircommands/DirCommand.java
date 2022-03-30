package com.filej.commands.dircommands;

import java.io.File;

import com.filej.commands.Command;

public abstract class DirCommand implements Command {
    protected boolean verbose;
    protected File dir;

    public DirCommand(boolean verbose, File dir) {
        this.verbose = verbose;
        this.dir = dir;
    }

    public boolean verbose() {
        return this.verbose;
    }

    public File getDir() {
        return this.dir;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void setDir(File dir) {
        this.dir = dir;
    }
}
