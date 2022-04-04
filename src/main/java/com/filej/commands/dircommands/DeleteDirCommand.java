package com.filej.commands.dircommands;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

import com.filej.commands.Command;

public class DeleteDirCommand extends DirCommand {
    private static final DeleteDirCommand INSTANCE = new DeleteDirCommand();

    private final Scanner scan = new Scanner(System.in);
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
        if (!directoryExists()) {
            throw new NoSuchElementException("error: directory does not exist");
        } 

        if (!this.getForce()) {
            if (!confirmed())
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
        return this.force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    private boolean directoryExists() {
        File file = new File(path);
        return file.exists();
    }

    private boolean confirmed() {
        System.out.print("prompt: are you sure you want to delete " + dirname + "? (y/n): ");
        String answer = scan.next();
        return answer.toLowerCase().equals("y");
    }
}
