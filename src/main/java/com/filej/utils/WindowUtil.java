package com.filej.utils;

import com.filej.utils.constants.Colors;

public class WindowUtil {
    

    public static void clearWindow() {
        System.out.println(Colors.ANSI_CLS);
    }

    public static void displayPath(String path) {
        System.out.print(Colors.ANSI_YELLOW + path + Colors.ANSI_RESET + "> ");
    }

    public static void startNewLine() {
        System.out.println();
    }
}
