package com.filej.commands.filecommands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.filej.commands.Command;

public class WriteFileCommand extends FileCommand {
    private static final WriteFileCommand INSTANCE = new WriteFileCommand();

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
    private BufferedWriter writer;

    public static Command getInstance(boolean v, String fn) {
        verbose = v;
        filename = fn;
        path = stateController.getRealPath() + filename;
        return INSTANCE;
    }

    //test
    @Override
    public void run() throws Exception {
        FileWriter file = new FileWriter(path);
        writer = new BufferedWriter(file);

        String content = getContentToWrite();

        writer.write(content);
        writer.close();

        System.out.println("writer: successfully wrote to " + filename);
    }

    private String getContentToWrite() {
        StringBuilder content = new StringBuilder();
        String line = "";

        try {
            while(!line.equals(":quit")) {
                if (!line.isEmpty()) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
                
                System.out.print("> ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return content.toString();
    }
}