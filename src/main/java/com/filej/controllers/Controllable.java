package com.filej.controllers;

public interface Controllable {
    void pushToPath(String path);
    void popFromPath();
    String getPseudoPath();
    String getRealPath();
}
