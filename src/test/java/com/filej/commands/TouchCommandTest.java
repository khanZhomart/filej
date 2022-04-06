package com.filej.commands;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.filej.commands.filecommands.DeleteFileCommand;
import com.filej.commands.filecommands.TouchFileCommand;
import com.filej.controllers.StateController;
import com.filej.utils.CommonUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TouchCommandTest {
    private static final Logger logger = LoggerFactory.getLogger(TouchCommandTest.class);
    private static final StateController stateController = new StateController();

    private Command command;
    private final String filename = "test.txt";

    @Before
    public void init() {
        command = new TouchFileCommand(false, filename);

        try {
            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void should_CreateFile() {
        assertTrue(CommonUtil.elementExists(stateController.getRealPath() + filename));
    }

    @Test
    public void should_ReturnIllegalArgumentException_When_ProvidedFilenameExists() {
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                command = new TouchFileCommand(false, filename);
                command.run();
            }
        );
    }

    @After
    public void after() {
        command = new DeleteFileCommand(false, true, filename);
        
        try {
            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
