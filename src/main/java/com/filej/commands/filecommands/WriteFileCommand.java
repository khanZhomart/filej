package com.filej.commands.filecommands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.filej.utils.CommonUtil;

public class WriteFileCommand extends FileCommand {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
    private String content;

    public WriteFileCommand(boolean verbose, String filename) {
        super(verbose, filename);
        this.path = this.stateController.getRealPath() + filename;
    }

    public WriteFileCommand(boolean verbose, String content, String filename) {
        super(verbose, filename);
        this.content = content;
        this.path = this.stateController.getRealPath() + filename;
    }

    //test
    @Override
    public void run() throws Exception {
        FileWriter file = new FileWriter(this.path);
        BufferedWriter writer = new BufferedWriter(file);

        try {
            if (!CommonUtil.elementExists(this.path)) {
                throw new FileNotFoundException();
            }

            if (content == null) {
                content = getContentToWrite();
            }
    
            writer.write(content);
    
            System.out.println("writer: successfully wrote to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
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