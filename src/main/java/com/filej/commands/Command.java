package com.filej.commands;

public interface Command {
    void run() throws Exception;

    Command acceptArgs(boolean verbose, String target);
    Command acceptArgs(boolean verbose, String content, String target);
    Command acceptArgs(boolean verbose, boolean force, String target);
}