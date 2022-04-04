package com.filej.commands.dircommands;

import com.filej.commands.Command;
import com.filej.controllers.StateController;

public abstract class DirCommand implements Command {
    protected static final StateController stateController = new StateController();
    protected static boolean verbose;
    protected static String path;
    protected static String dirname;

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
}
