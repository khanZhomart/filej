package com.filej.commands.dircommands;

import com.filej.commands.Command;
import com.filej.controllers.StateController;

public abstract class DirCommand implements Command {
    protected StateController stateController = new StateController();
    protected boolean verbose;
    protected String path;
    protected String dirname;

    public DirCommand(boolean verbose, String dirname) {
        this.verbose = verbose;
        this.dirname = dirname;
    }

    public boolean verbose() {
        return this.verbose;
    }

    public String getDir() {
        return this.dirname;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void setDir(String dirname) {
        this.dirname = dirname;
    }
}
