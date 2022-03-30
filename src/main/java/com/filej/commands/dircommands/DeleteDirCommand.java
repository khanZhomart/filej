package com.filej.commands.dircommands;

import java.io.File;

public class DeleteDirCommand extends DirCommand {
    private boolean force;

    public DeleteDirCommand(boolean verbose, boolean force, File dir) {
        super(verbose, dir);
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
