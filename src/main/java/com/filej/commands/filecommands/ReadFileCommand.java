package com.filej.commands.filecommands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

import com.filej.commands.Command;
import com.filej.utils.constants.Colors;

public class ReadFileCommand extends FileCommand {
    private static volatile ReadFileCommand instance;

    private BufferedReader reader;

    public static Command getInstance() {
        ReadFileCommand localInstance = instance;

        if (localInstance == null) {
            synchronized (ReadFileCommand.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new ReadFileCommand();
                }
            }
        }

        return localInstance;
    }

    public Command acceptArgs(boolean v, String fn) {
        verbose = v;
        filename = fn;
        path = stateController.getRealPath() + filename;

        return instance;
    }

    //test
    @Override
    public void run() throws FileNotFoundException {
        String content = readFileContent();
        System.out.println(Colors.ANSI_YELLOW + filename + Colors.ANSI_RESET + "\n" + content);
    }

    public String readFileContent() throws FileNotFoundException {
        FileReader file = new FileReader(path);
        reader = new BufferedReader(file);

        return reader.lines()
            .collect(Collectors.joining(System.lineSeparator()));
    }
}
