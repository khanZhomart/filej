package com.filej.commands.dircommands;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import com.filej.commands.Command;
import com.filej.utils.CommonUtil;

public class DeleteDirCommand extends DirCommand {
    private static volatile DeleteDirCommand instance;

    private boolean force;

    public static Command getInstance() {
        DeleteDirCommand localInstance = instance;

        if (localInstance == null) {
            synchronized (DeleteDirCommand.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new DeleteDirCommand();
                }
            }
        }

        return localInstance;
    }

    public Command acceptArgs(boolean verbose, boolean force, String dirname) {
        this.verbose = verbose;
        this.force = force;
        this.dirname = dirname;
        this.path = stateController.getRealPath() + dirname;

        return instance;
    }    

    @Override
    public void run() throws NoSuchElementException {
        if (!CommonUtil.elementExists(path)) {
            throw new NoSuchElementException("error: directory does not exist");
        } 

        if (!this.getForce()) {
            if (!CommonUtil.confirmed(dirname))
                return;
        }

        if (this.getVerbose())
            System.out.println("deleting " + dirname + "...");

        File dir = new File(path);
        File[] content = dir.listFiles();

        if (content != null)
            Stream.of(content)
                .map((file) -> file.delete())
                .close();

        dir.delete();
    }

    public boolean getForce() {
        return force;
    }

    public void setForce(boolean f) {
        force = f;
    }
}
