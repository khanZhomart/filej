package com.filej.commands;

import static org.junit.Assert.assertThrows;

import com.filej.commands.filecommands.WriteFileCommand;

import org.junit.Test;

public class WriteFileCommandTest {

    @Test
    public void should_ThrowIllegalArgumentException_When_FilenameIsNull() {
        Command command = new WriteFileCommand(false, "test", null);

        assertThrows(
            IllegalArgumentException.class,
            () -> {
                command.run();
            }
        );
    }

    @Test
    public void should_ThrowIllegalArgumentException_When_FileIsInvalid() {
        Command command = new WriteFileCommand(false, "test", "test-file.txt");
        
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                command.run();
            }
        );
    }
}
