package com.filej.commands.filecommands;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DeleteFileCommand extends FileCommand {
    private final Scanner scan = new Scanner(System.in);
    private boolean force;

    public DeleteFileCommand(boolean verbose, boolean force, String filename) {
        super(verbose, filename);
        this.force = force;
    }

    @Override
    public void run() throws Exception {
        if (!fileExists())
            throw new NoSuchElementException("error: file does not exist.");

        if (!force)
            if (!confirmed())
                return;

        if (verbose)
            System.out.println("deleting " + filename + "...");

        File file = new File(this.stateController.getRealPath() + filename);

        file.delete();
    }

    public boolean force() {
        return this.force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    private boolean fileExists() {
        File file = new File(this.stateController.getRealPath() + filename);
        return file.exists();
    }

    private boolean confirmed() {
        System.out.print("prompt: are you sure you want to delete " + filename + "? (y/n): ");

        String answer = scan.next();

        return answer.toLowerCase().equals("y");
    }
}
