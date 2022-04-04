package com.filej.commands.dircommands;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import com.filej.commands.Command;
import com.filej.utils.CommonUtil;

public class DeleteDirCommand extends DirCommand {
    private static final DeleteDirCommand INSTANCE = new DeleteDirCommand();

    private static boolean force;

    public static Command getInstance(boolean v, boolean f, String dn) {
        verbose = v;
        force = f;
        dirname = dn;
        path = stateController.getRealPath() + dirname;
        return INSTANCE;
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
