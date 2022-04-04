package com.filej.commands.filecommands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.filej.commands.Command;

public class WriteFileCommand extends FileCommand {
    private static volatile WriteFileCommand instance;

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
    private BufferedWriter writer;
    private String content;

    public static Command getInstance() {
        WriteFileCommand localInstance = instance;

        if (localInstance == null) {
            synchronized (WriteFileCommand.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new WriteFileCommand();
                }
            }
        }

        return localInstance;
    }

    public WriteFileCommand acceptArgs(boolean verbose, String content, String filename) {
        this.verbose = verbose;
        this.content = content;
        this.filename = filename;
        this.path = stateController.getRealPath() + filename;

        return instance;
    }

    public Command acceptArgs(boolean verbose, String filename) {
        this.verbose = verbose;
        this.filename = filename;
        this.path = stateController.getRealPath() + filename;

        return instance;
    }

    //test
    @Override
    public void run() throws Exception {
        FileWriter file = new FileWriter(path);
        writer = new BufferedWriter(file);

        if (content == null) {
            content = getContentToWrite();
        }

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