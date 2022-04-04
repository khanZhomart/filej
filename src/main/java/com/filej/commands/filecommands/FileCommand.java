package com.filej.commands.filecommands;

import com.filej.commands.Command;
import com.filej.controllers.StateController;

public abstract class FileCommand implements Command {
    protected static final StateController stateController = new StateController();
    protected static boolean verbose;
    protected static String path;
    protected static String filename;

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
}
