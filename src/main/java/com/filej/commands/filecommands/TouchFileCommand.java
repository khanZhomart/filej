package com.filej.commands.filecommands;

import java.io.File;
import java.io.IOException;

import com.filej.commands.Command;
import com.filej.utils.FileUtil;

public class TouchFileCommand extends FileCommand {
    private static final TouchFileCommand INSTANCE = new TouchFileCommand();

    public static Command getInstance(boolean v, String fn) {
        verbose = v;
        filename = fn;
        path = stateController.getRealPath() + filename;
        return INSTANCE;
    }

    @Override
    public void run() throws IOException, IllegalArgumentException {
        if (FileUtil.fileExists(path)) {
            throw new IllegalArgumentException("error: provided file already exists");
        }

        File file = new File(path);
        file.createNewFile();
    }    
}
