package com.filej.commands;

import static org.junit.Assert.assertThrows;

import com.filej.commands.filecommands.DeleteFileCommand;
import com.filej.commands.filecommands.TouchFileCommand;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TouchCommandTest {
    private static final Logger logger = LoggerFactory.getLogger(TouchCommandTest.class);
    private Command command;
    private final String testFile = "test.txt";

    @Before
    public void init() {
        command = TouchFileCommand.getInstance(false, testFile);

        try {
            command.run();
            logger.info("created " + testFile + " file.");
        } catch (Exception e) {
            logger.warn(testFile + " file was already created. Skipping...");
        }
    }

    @Test
    public void Should_ReturnIllegalArgumentException_When_ProvidedFilenameExists() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                command = TouchFileCommand.getInstance(false, testFile);
                logger.warn("trying to create duplicate file " + testFile + "...");
                command.run();
            }
        );
    }

    @After
    public void after() {
        command = DeleteFileCommand.getInstance(false, true, testFile);
        
        try {
            command.run();
            logger.info("deleted file " + testFile);
        } catch (Exception e) {
            logger.error("something gone wrong...");
        }
    }
}
