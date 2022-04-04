package com.filej.commands.filecommands;

import com.filej.commands.Command;
import com.filej.controllers.StateController;

public abstract class FileCommand implements Command {
    protected static final StateController stateController = new StateController();

    protected boolean verbose;
    protected String path;
    protected String filename;

    public boolean verbose() {
        return verbose;
    }

    public String getFile() {
        return filename;
    }

    public void setVerbose(boolean v) {
        verbose = v;
    }

    public void setFilename(String fn){
        filename = fn;
    }

    @Override
    public Command acceptArgs(boolean verbose, String target) {
        return null;
    }

    @Override
    public Command acceptArgs(boolean verbose, boolean force, String target) {
        return null;
    }
}
