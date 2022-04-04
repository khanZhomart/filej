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
            command = MakeDirectoryCommand.getInstance()
                .acceptArgs(false, dirname);

            logger.info("Created directory " + dirname);
            command.run();

            command = ChangeDirectoryCommand.getInstance()
                .acceptArgs(false, dirname);

            logger.info("Changed directory to " + dirname);
            command.run();

            command = TouchFileCommand.getInstance()
                .acceptArgs(false, filename);

            logger.info("Created file " + filename);
            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void Should_WriteToFileAndReadFrom() {
        try {
            command = WriteFileCommand.getInstance()
                .acceptArgs(false, content, filename);

            logger.info("Writing '" + content + "' to " + dirname + "/" + filename);
            command.run();

            command = ReadFileCommand.getInstance()
                .acceptArgs(false, filename);

            logger.info("Reading from " + filename);
            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }   
    }

    @After
    public void after() {
        try {
            command = DeleteFileCommand.getInstance()
                .acceptArgs(false, true, filename);

            command.run();

            command = ChangeDirectoryCommand.getInstance()
                .acceptArgs(false, "..");

            command.run();

            command = DeleteDirCommand.getInstance()
                .acceptArgs(false, true, dirname);

            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }   
    }
}
