package com.filej.commands.dircommands;

public class DeleteDirCommand extends DirCommand {
    private boolean force;

    public DeleteDirCommand(boolean verbose, boolean force, String dirname) {
        super(verbose, dirname);
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