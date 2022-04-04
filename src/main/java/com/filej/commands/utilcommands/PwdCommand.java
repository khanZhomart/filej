package com.filej.commands.utilcommands;

import com.filej.commands.Command;

public class PwdCommand extends UtilCommand {
    private static volatile PwdCommand instance;

    public static Command getInstance() {
        PwdCommand localInstance = instance;

        if (localInstance == null) {
            synchronized (PwdCommand.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new PwdCommand();
                }
            }
        }

        return localInstance;
    }
    
    @Override
    public void run() throws Exception {
        System.out.println("real_path: " + stateController.getRealPath() + "\npseudo_path: " + stateController.getPseudoPath());        
    }
}
