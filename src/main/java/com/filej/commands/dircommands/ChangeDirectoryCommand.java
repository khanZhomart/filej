package com.filej.commands.dircommands;

import java.io.File;

public class ChangeDirectoryCommand extends DirCommand {

    public ChangeDirectoryCommand(boolean verbose, File dir) {
        super(verbose, dir);
    }

    @Override
    public void run() throws Exception {
        
    }
}
