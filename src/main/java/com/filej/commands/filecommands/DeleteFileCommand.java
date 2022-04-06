package com.filej.commands.filecommands;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import com.filej.utils.CommonUtil;

public class DeleteFileCommand extends FileCommand {
    private boolean force;

    public DeleteFileCommand(boolean verbose, boolean force, String filename) {
        super(verbose, filename);
        this.force = force;
        this.path = this.stateController.getRealPath() + filename;
    }

    @Override
    public void run() throws IOException, NullPointerException {
        if (!CommonUtil.elementExists(this.path)) {
            throw new NoSuchElementException("error: file does not exist.");
        }

        if (!force) {
            if (!CommonUtil.confirmed(filename)) {
                return;
            }
        }

        if (verbose) {
            System.out.println("deleting " + filename + "...");
        }

        File file = new File(this.path);
        file.delete();
    }

    public boolean force() {
        return this.force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }
}
