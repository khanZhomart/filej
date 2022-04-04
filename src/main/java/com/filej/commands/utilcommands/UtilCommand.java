package com.filej.commands.utilcommands;

import com.filej.commands.Command;
import com.filej.controllers.StateController;

public abstract class UtilCommand implements Command {
    protected static final StateController stateController = new StateController();
}
