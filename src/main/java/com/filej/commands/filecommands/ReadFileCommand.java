package com.filej.commands.filecommands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

import com.filej.commands.Command;
import com.filej.utils.constants.Colors;

public class ReadFileCommand extends FileCommand {
    private static final ReadFileCommand INSTANCE = new ReadFileCommand();

    private BufferedReader reader;

    public static Command getInstance(boolean v, String fn) {
        verbose = v;
        filename = fn;
        path = stateController.getRealPath() + filename;
        return INSTANCE;
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
