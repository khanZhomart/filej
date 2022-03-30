package com.filej.commands.filecommands;

import java.io.File;

public class DeleteFileCommand extends FileCommand {
    private boolean force;

    public DeleteFileCommand(boolean verbose, boolean force, File file) {
        super(verbose, file);
        this.force = force;
    }

    @Override
    public void run() throws Exception {
        
    }

    public boolean force() {
        return this.force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }
}
