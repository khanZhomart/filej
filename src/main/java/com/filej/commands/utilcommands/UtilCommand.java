package com.filej.commands.utilcommands;

import com.filej.commands.Command;
import com.filej.controllers.StateController;

public abstract class UtilCommand implements Command {
    protected static final StateController stateController = new StateController();

    @Override
    public Command acceptArgs(boolean verbose, String target) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Command acceptArgs(boolean verbose, boolean force, String target) {
        // TODO Auto-generated method stub
        return null;
    }
}
