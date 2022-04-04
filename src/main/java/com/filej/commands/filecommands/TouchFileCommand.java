package com.filej.commands.filecommands;

import java.io.File;
import java.io.IOException;

import com.filej.commands.Command;
import com.filej.utils.CommonUtil;

public class TouchFileCommand extends FileCommand {
    private static volatile TouchFileCommand instance;

    public static Command getInstance() {
        TouchFileCommand localInstance = instance;

        if (localInstance == null) {
            synchronized (TouchFileCommand.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new TouchFileCommand();
                }
            }
        }

        return localInstance;
    }

    public Command acceptArgs(boolean verbose, String filename) {
        this.verbose = verbose;
        this.filename = filename;
        this.path = stateController.getRealPath() + filename;

        return instance;
    }

    @Override
    public void run() throws IOException, IllegalArgumentException {
        if (CommonUtil.elementExists(path)) {
            throw new IllegalArgumentException("error: provided file already exists");
        }

        File file = new File(path);
        file.createNewFile();
    }    
}
