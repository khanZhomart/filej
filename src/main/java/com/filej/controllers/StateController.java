package com.filej.controllers;

import com.filej.states.TreeState;

public class StateController {
    private final TreeState state = TreeState.INSTANCE;

    public void pushToPath(String path) {
        state.addPath(path);
    }

    public void popFromPath() {
        state.popPath();
    }

    public String getPseudoPath() {
        return state.toString();
    }

    public String getRealPath() {
        return state.getRealPath();
    }
}
