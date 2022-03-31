package com.filej.commands.dircommands;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class DeleteDirCommand extends DirCommand {
    private final Scanner scan = new Scanner(System.in);
    private boolean force;

    public DeleteDirCommand(boolean verbose, boolean force, String dirname) {
        super(verbose, dirname);
        this.force = force;
    }

    @Override
    public void run() throws Exception {
        if (!directoryExists())
            throw new NoSuchElementException("error: directory does not exist");

        if (!force)
            if (!confirmed())
                return;

        if (verbose)
            System.out.println("deleting " + dirname + "...");

        File dir = new File(this.stateController.getRealPath() + dirname);
        File[] content = dir.listFiles();

        if (content != null)
            Stream.of(content)
                .map((file) -> file.delete())
                .close();

        dir.delete();
    }

    public boolean force() {
        return this.force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    private boolean directoryExists() {
        File file = new File(this.stateController.getRealPath() + dirname);
        return file.exists();
    }

    private boolean confirmed() {
        System.out.print("prompt: are you sure you want to delete " + dirname + "? (y/n): ");

        String answer = scan.next();

        return answer.toLowerCase().equals("y");
    }
}
