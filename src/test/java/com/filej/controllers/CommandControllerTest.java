package com.filej.controllers;

import org.junit.Assert;

import com.filej.utils.models.Input;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(CommandControllerTest.class);
    private CommandController commandController = new CommandController();
    private String commandName = "test";
    private Input input;

    @Before
    public void init() {
        logger.info("receiving invalid command " + "'" + commandName + "'");
        input = new Input.Builder()
            .command(commandName)
            .args(new String[] {"test"})
            .build();
    }

    @Test
    public void should_ReturnIllegalArgumentException_When_InvalidCommandProvided() {
        Assert.assertThrows(
            "exception was thrown",
            IllegalArgumentException.class,
            () -> {
                logger.warn("trying to pass invalid command to controller...");
                commandController.defineType(input);
            }
        );
    }
}
