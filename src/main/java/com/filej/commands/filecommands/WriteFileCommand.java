package com.filej.commands.filecommands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteFileCommand extends FileCommand {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
    private String content;
    private BufferedWriter writer;

    public WriteFileCommand(boolean verbose, String filename) {
        super(verbose, filename);
        this.path = this.stateController.getRealPath() + filename;
    }

    public WriteFileCommand(boolean verbose, String content, String filename) {
        super(verbose, filename);
        this.path = this.stateController.getRealPath() + filename;
    }

    //test
    @Override
    public void run() throws Exception {
        FileWriter file = new FileWriter(this.path);
        writer = new BufferedWriter(file);

        if (content == null) {
            content = getContentToWrite();
        }

        writer.write(content);
        writer.close();

        System.out.println("writer: successfully wrote to " + filename);
    }

    public String getContentToWrite() {
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