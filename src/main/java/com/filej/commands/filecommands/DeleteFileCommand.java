package com.filej.commands.filecommands;

public class DeleteFileCommand extends FileCommand {
    private boolean force;

    public DeleteFileCommand(boolean verbose, boolean force, String filename) {
        super(verbose, filename);
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
