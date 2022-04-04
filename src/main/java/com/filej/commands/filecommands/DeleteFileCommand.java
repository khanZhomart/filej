package com.filej.commands.filecommands;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import com.filej.commands.Command;
import com.filej.utils.FileUtil;

public class DeleteFileCommand extends FileCommand {
    private static final DeleteFileCommand INSTANCE = new DeleteFileCommand(); 

    private static boolean force;

    public static Command getInstance(boolean v, boolean f, String fn) {
        verbose = v;
        force = f;
        filename = fn;
        path = stateController.getRealPath() + filename;
        return INSTANCE;
    }

    @Override
    public void run() throws IOException, NullPointerException {
        if (!FileUtil.fileExists(path)) {
            throw new NoSuchElementException("error: file does not exist.");
        }

        if (!force) {
            if (!FileUtil.confirmed(filename)) {
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
