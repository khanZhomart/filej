package com.filej.controllers;

import org.junit.Assert;

import com.filej.commands.Command;
import com.filej.commands.dircommands.ChangeDirectoryCommand;
import com.filej.utils.models.Input;

import org.junit.Test;

public class CommandControllerTest {
    private CommandController commandController = new CommandController();
    private String commandName = "test";
    private Input input;

    @Test
    public void should_ReturnIllegalArgumentException_When_InvalidCommandProvided() {
        input = new Input.Builder()
            .command(commandName)
            .args(new String[] {"test"})
            .build();

        Assert.assertThrows(
            "exception was thrown",
            IllegalArgumentException.class,
            () -> {
                commandController.defineType(input);
            }
        );
    }

    @Test
    public void should_ReturnChangeDirectoryCommandInstance_When_CdProvided() {
        input = new Input.Builder()
            .command("cd")
            .args(new String[] {"cd", "folder"})
            .build();
        
        Command command = commandController.defineType(input);

        Assert.assertEquals(command.getClass(), ChangeDirectoryCommand.class);
    }
}
