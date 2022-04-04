package com.filej.utils;

import java.io.File;
import java.util.Scanner;

public class CommonUtil {
    private static final Scanner scan = new Scanner(System.in);

    public static boolean elementExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static boolean confirmed(String filename) {
        System.out.print("prompt: are you sure you want to delete " + filename + "? (y/n): ");
        String answer = scan.next();
        return answer.toLowerCase().equals("y");
    }
}
