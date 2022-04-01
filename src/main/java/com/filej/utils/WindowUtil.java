package com.filej.utils;

import com.filej.controllers.StateController;
import com.filej.utils.constants.Colors;

public class WindowUtil {
    private static final StateController stateController = new StateController();

    public static void showTitle() {
        System.out.println("*** fileJ, v0.1 ***\n");
    }

    public static void clearWindow() {
        System.out.println(Colors.ANSI_CLS);
    }

    public static void displayPath() {
        System.out.print(Colors.ANSI_YELLOW + stateController.getPseudoPath() + Colors.ANSI_RESET + "> ");
    }

    public static void startNewLine() {
        System.out.println();
    }
}
