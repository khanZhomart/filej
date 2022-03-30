package com.filej.commands;

import com.filej.utils.constants.Colors;

public class HelpCommand implements Command {

    @Override
    public void run() throws Exception {
        String message = "> available commands:" + Colors.ANSI_YELLOW + 
            "\nmd" + Colors.ANSI_RESET + " - change directory" +
            "\n" + Colors.ANSI_YELLOW + "cd" + Colors.ANSI_RESET + " - move to a directory" +
            "\n" + Colors.ANSI_YELLOW + "list . | <dirname>" + Colors.ANSI_RESET + " - list directory content" +
            "\n" + Colors.ANSI_YELLOW + "rmd <dirname>" + Colors.ANSI_RESET + " - remove a directory" +
            "\n" + Colors.ANSI_YELLOW + "touch <filename>" + Colors.ANSI_RESET + " - create a file";

        System.out.println(message);
    }
    
}
