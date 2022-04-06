package com.filej.commands.filecommands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

import com.filej.utils.constants.Colors;

public class ReadFileCommand extends FileCommand {

    public ReadFileCommand(boolean verbose, String filename) {
        super(verbose, filename);
        this.path = this.stateController.getRealPath() + filename;
    }

    //test
    @Override
    public void run() {
        try {
            String content = readFileContent();
            System.out.println(Colors.ANSI_YELLOW + filename + Colors.ANSI_RESET + "\n" + content);
        } catch (FileNotFoundException e) { 
            System.out.println(e.getMessage());
        }
    }

    public String readFileContent() throws FileNotFoundException {
        FileReader file = new FileReader(this.path);
        BufferedReader reader = new BufferedReader(file);

        return reader.lines()
            .collect(Collectors.joining(System.lineSeparator()));
    }
}
