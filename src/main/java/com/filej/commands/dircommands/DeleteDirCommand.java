package com.filej.commands.dircommands;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DeleteDirCommand extends DirCommand {
    private final Scanner scan = new Scanner(System.in);
    private boolean force;

    public DeleteDirCommand(boolean verbose, boolean force, String dirname) {
        super(verbose, dirname);
        this.force = force;
        this.path = this.stateController.getRealPath() + dirname;
    }

    @Override
    public void run() throws NoSuchElementException {
        if (!directoryExists()) {
            throw new NoSuchElementException("error: directory does not exist");
        } 

        if (!force) {
            if (!confirmed())
                return;
        }

        if (verbose)
            System.out.println("deleting " + dirname + "...");

        File dir = new File(this.path);
        File[] content = dir.listFiles();

        if (content != null) {
            for (File file : content) {
                file.delete();
            }
        }

        dir.delete();
    }

    public boolean force() {
        return this.force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    private boolean directoryExists() {
        File file = new File(this.path);
        return file.exists();
    }

    private boolean confirmed() {
        System.out.print("prompt: are you sure you want to delete " + dirname + "? (y/n): ");
        String answer = scan.next();
        return answer.toLowerCase().equals("y");
    }
}
