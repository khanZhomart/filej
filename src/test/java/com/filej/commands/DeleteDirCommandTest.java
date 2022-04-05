package com.filej.commands;

import com.filej.commands.dircommands.DeleteDirCommand;
import com.filej.commands.dircommands.MakeDirectoryCommand;

import org.junit.Before;
import org.junit.Test;

public class DeleteDirCommandTest {
    private String dirname = "testfolder";
    private Command command;

    @Before
    public void init() {
        command = new MakeDirectoryCommand(false, dirname);

        try {
            command.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_DeleteDirectory() {
        command = new DeleteDirCommand(false, true, dirname);

        try {
            command.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
