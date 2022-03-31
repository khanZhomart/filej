package com.filej.commands.filecommands;

import com.filej.commands.Command;
import com.filej.controllers.StateController;

public abstract class FileCommand implements Command {
    protected StateController stateController = new StateController();
    protected boolean verbose;
    protected String path;
    protected String filename;

    public FileCommand(boolean verbose, String filename) {
        this.verbose = verbose;
        this.filename = filename;
    }

    public boolean verbose() {
        return this.verbose;
    }

    public String getFile() {
        return this.filename;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void setFile(String filename){
        this.filename = filename;
    }
}
