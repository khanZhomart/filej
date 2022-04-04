package com.filej.commands.dircommands;

import com.filej.commands.Command;
import com.filej.controllers.StateController;

public abstract class DirCommand implements Command {
    protected static final StateController stateController = new StateController();
    
    protected boolean verbose;
    protected String path;
    protected String dirname;

    public boolean getVerbose() {
        return verbose;
    }

    public String getDir() {
        return dirname;
    }

    public void setVerbose(boolean v) {
        verbose = v;
    }

    public void setDirname(String dn) {
        dirname = dn;
    }

    @Override
    public Command acceptArgs(boolean verbose, String target) {
        return null;
    }

    @Override
    public Command acceptArgs(boolean verbose, boolean force, String target) {
        return null;
    }

    @Override
    public Command acceptArgs(boolean verbose, String content, String target) {
        return null;
    }
}
