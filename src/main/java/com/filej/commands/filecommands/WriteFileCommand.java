package com.filej.commands.filecommands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    public void run() throws IllegalArgumentException, IOException {
        if (validateFilename(this.filename)) 
            throw new IllegalArgumentException("error: filename can not be null.");
        
        if (!CommonUtil.elementExists(this.path)) {
            throw new IllegalArgumentException("error: invalid file");
        }

        writeToFile(this.path, this.filename);
    }

    private void writeToFile(String path, String filename) throws IOException {
        FileWriter file = new FileWriter(path);
        BufferedWriter writer = new BufferedWriter(file);

        try {
            content = getContentToWrite();
            writer.write(content);
            System.out.println("writer: successfully wrote to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
    }

    private boolean validateFilename(String filename) {
        return filename == null || filename.isEmpty();
    }

    public String getContentToWrite() {
        StringBuilder content = new StringBuilder();
        String line = "";

        try {
            while(!line.equals(":quit")) {
                appendLine(line, content);

                System.out.print("> ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return content.toString();
    }

    private void appendLine(String line, StringBuilder content) {
        if (!line.isEmpty()) {
            content.append(line);
            content.append(System.lineSeparator());
        }
    }
}