package com.filej.commands.filecommands;

import java.io.File;
import java.io.IOException;

public class TouchFileCommand extends FileCommand {

    public TouchFileCommand(boolean verbose, String filename) {
        super(verbose, filename);
        this.path = this.stateController.getRealPath() + filename;
    }

    @Override
    public void run() throws Exception {
        try {
            File file = new File(this.path);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }    
}
