package com.filej.commands.filecommands;

import java.io.File;

import com.filej.commands.Command;

public abstract class FileCommand implements Command {
    protected boolean verbose;
    protected File file;

    public FileCommand(boolean verbose, File file) {
        this.verbose = verbose;
        this.file = file;
    }

    public boolean verbose() {
        return this.verbose;
    }

    public File getFile() {
        return this.file;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void setFile(File file){
        this.file = file;
    }
}
