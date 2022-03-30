package com.filej.utils.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commands {
    public static final String MAKE_DIR = "md";
    public static final String CHANGE_DIR = "cd";
    public static final String LIST_CONTENT_DIR = "list";
    public static final String DELETE_DIR = "rmd";
    public static final String TOUCH_FILE = "touch";
    public static final String WRITE_FILE = "write";
    public static final String READ_FILE = "read";
    public static final String DELETE_FILE = "del";
    public static final String PWD = "pwd";
    public static final String HELP = "help";

    public static class Options {
        public static final List<String> VERBOSE = new ArrayList<>(Arrays.asList("-v", "--verbose"));
        public static final List<String> FORCE = new ArrayList<>(Arrays.asList("-f", "--force"));
    }
}
