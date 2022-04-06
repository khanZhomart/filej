package com.filej.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {
    private static final Scanner scan = new Scanner(System.in);

    public static boolean clearFile(String path) throws IOException {
        new FileWriter(path, false).close();
        return true;
    }

    public static boolean confirmed(String filename) {
        System.out.print("prompt: are you sure you want to delete " + filename + "? (y/n): ");
        String answer = scan.next();
        return answer.toLowerCase().equals("y");
    }
}
