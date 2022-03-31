package com.filej.utils.models;

import com.filej.utils.constants.Commands;

public class Input {
    private String command;
    private boolean verbose;
    private boolean force;
    private String target;

    private Input(Builder builder) {
        this.command = builder.command;
        this.verbose = builder.verbose;
        this.force = builder.force;
        this.target = builder.target;
    }

    public String getCommand() {
        return this.command;
    }

    public boolean verbose() {
        return this.verbose;
    }

    public boolean force() {
        return this.force;
    }

    public String getTarget() {
        return this.target;
    }

    public static class Builder {
        private String command;
        private boolean verbose;
        private boolean force;
        private String target;

        public Builder command(String command) {
            this.command = command;
            return this;
        }

        public Builder args(String args[]) {
            if (Commands.Options.containsVerbose(args))
                this.verbose = true;

            if (Commands.Options.containsForce(args))
                this.force = true;

            this.target = args[args.length - 1];

            return this;
        }

        public Input build() {
            return new Input(this);
        }
    }
}
