package com.filej.utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static boolean clearFile(String path) throws IOException {
        new FileWriter(path, false).close();
        return true;
    }
}
