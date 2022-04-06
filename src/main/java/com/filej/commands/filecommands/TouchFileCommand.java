package com.filej.commands.filecommands;

import java.io.File;
import java.io.IOException;

import com.filej.utils.CommonUtil;

public class TouchFileCommand extends FileCommand {

    public TouchFileCommand(boolean verbose, String filename) {
        super(verbose, filename);
        this.path = this.stateController.getRealPath() + filename;
    }

    @Override
    public void run() throws IOException, IllegalArgumentException {
        if (CommonUtil.elementExists(this.path))
            throw new IllegalArgumentException("error: provided file already exists");

        File file = new File(this.path);
        file.createNewFile();
    }    
}
