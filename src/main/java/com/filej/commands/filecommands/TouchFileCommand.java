package com.filej.commands.filecommands;

import java.io.File;
import java.io.IOException;

public class TouchFileCommand extends FileCommand {

    public TouchFileCommand(boolean verbose, String filename) {
        super(verbose, filename);
    }

    @Overridec
    public void run() throws Exception {
        String path = this.stateController.getRealPath();

        try {
            File file = new File(path + filename);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }    
}
