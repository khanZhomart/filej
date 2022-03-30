package com.filej.states;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeState {
    private static TreeState instance;

    private List<String> currentPath;
    private String realPath;

    private TreeState() {
        this.currentPath = new ArrayList<>(Arrays.asList("root"));
        this.realPath = "src\\main\\java\\com\\~\\root\\";
    }

    public static TreeState getInstance() {
        if (instance == null)
            instance = new TreeState();

        return instance;
    }

    public List<String> getCurrentPath() {
        return new ArrayList<>(currentPath);
    }

    public String getRealPath() {
        return realPath;
    }

    public void addPath(String path) {
        currentPath.add(path);
        realPath = realPath.concat(path + "\\");
    }

    public void popPath() {
        realPath = realPath.replace(currentPath.get(currentPath.size() - 1) + "\\", "");
        currentPath.remove(currentPath.size() - 1);
    }

    public void setCurrentPath(List<String> currentPath) {
        this.currentPath = currentPath;
    } 

    public String toString() {
        return currentPath.stream()
            .reduce("", (result, element) -> result + "\\" + element);
    }
}
