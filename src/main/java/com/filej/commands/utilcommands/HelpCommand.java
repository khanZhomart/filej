package com.filej.commands.utilcommands;

import com.filej.commands.Command;
import com.filej.utils.constants.Colors;

public class HelpCommand implements Command {

    @Override
    public void run() throws Exception {
        String message = "> available commands:" + Colors.ANSI_YELLOW + 
            "\nmd" + Colors.ANSI_RESET + " - create a directory" +
            "\n" + Colors.ANSI_YELLOW + "cd .. | <dirname>" + Colors.ANSI_RESET + " - change directory" +
            "\n" + Colors.ANSI_YELLOW + "list . | <dirname>" + Colors.ANSI_RESET + " - list directory content" +
            "\n" + Colors.ANSI_YELLOW + "rmd [flags: -v --verbose, -f --force] <dirname>" + Colors.ANSI_RESET + " - remove a directory" +
            "\n" + Colors.ANSI_YELLOW + "touch <filename>" + Colors.ANSI_RESET + " - create a file" +
            "\n" + Colors.ANSI_YELLOW + "read <filename>" + Colors.ANSI_RESET + " - read from a file" +
            "\n" + Colors.ANSI_YELLOW + "write <filename>" + Colors.ANSI_RESET + " - write to a file" +
            "\n" + Colors.ANSI_YELLOW + "del [flags: -v --verbose, -f --force] <filename>" + Colors.ANSI_RESET + " - delete a file";

        System.out.println(message);
    }
    
}
