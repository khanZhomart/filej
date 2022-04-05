package com.filej.commands;

import com.filej.commands.dircommands.ChangeDirectoryCommand;
import com.filej.commands.dircommands.DeleteDirCommand;
import com.filej.commands.dircommands.MakeDirectoryCommand;
import com.filej.commands.filecommands.DeleteFileCommand;
import com.filej.commands.filecommands.ReadFileCommand;
import com.filej.commands.filecommands.TouchFileCommand;
import com.filej.commands.filecommands.WriteFileCommand;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadAndWriteCommandTest {
    private static final Logger logger = LoggerFactory.getLogger(ReadAndWriteCommandTest.class);

    private static final String dirname = "logs";
    private static final String filename = "log.txt";

    private Command command;
    private String content = "hello, world!";

    @Before
    public void init()  {
        try {
            command = new MakeDirectoryCommand(false, dirname);
            command.run();

            command = new ChangeDirectoryCommand(false, dirname);
            command.run();

            command = new TouchFileCommand(false, filename);
            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void Should_WriteToFileAndReadFrom() {
        try {
            command = new WriteFileCommand(false, content, filename);
            command.run();

            command = new ReadFileCommand(false, filename);
            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }   
    }

    @After
    public void after() {
        try {
            command = new DeleteFileCommand(false, true, filename);
            command.run();

            command = new ChangeDirectoryCommand(false, "..");
            command.run();

            command = new DeleteDirCommand(false, true, dirname);
            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }   
    }
}
