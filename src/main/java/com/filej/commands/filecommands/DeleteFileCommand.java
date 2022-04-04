package com.filej.commands.filecommands;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import com.filej.commands.Command;
import com.filej.utils.CommonUtil;
import com.filej.utils.FileUtil;

public class DeleteFileCommand extends FileCommand {
    private static volatile DeleteFileCommand instance;

    private boolean force;

    public static Command getInstance() {
        DeleteFileCommand localInstance = instance;

        if (localInstance == null) {
            synchronized (DeleteFileCommand.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new DeleteFileCommand();
                }
            }
        }

        return localInstance;
    }

    public Command acceptArgs(boolean verbose, boolean force, String filename) {
        this.verbose = verbose;
        this.force = force;
        this.filename = filename;
        this.path = stateController.getRealPath() + filename;

        return instance;
    }

    @Override
    public void run() throws IOException, NullPointerException {
        if (!CommonUtil.elementExists(path)) {
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

        File file = new File(path);
        FileUtil.clearFile(path);
        file.delete();
    }

    public boolean force() {
        return force;
    }

    public void setForce(boolean f) {
        force = f;
    }
}
