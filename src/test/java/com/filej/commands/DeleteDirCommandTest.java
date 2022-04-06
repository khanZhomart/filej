package com.filej.commands;

import static org.junit.Assert.assertFalse;

import com.filej.commands.dircommands.DeleteDirCommand;
import com.filej.commands.dircommands.MakeDirectoryCommand;
import com.filej.controllers.StateController;
import com.filej.utils.CommonUtil;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteDirCommandTest {
    private static final Logger logger = LoggerFactory.getLogger(DeleteDirCommandTest.class);
    private static final StateController stateController = new StateController();

    private String dirname = "testfolder";
    private Command command;

    @Before
    public void init() {
        command = new MakeDirectoryCommand(false, dirname);

        try {
            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void should_DeleteDirectory() {
        command = new DeleteDirCommand(false, true, dirname);

        try {
            command.run();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        assertFalse(CommonUtil.elementExists(stateController.getRealPath() + dirname));
    }
}
