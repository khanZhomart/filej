package com.filej.states;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TreeState {
    INSTANCE;

    private static List<String> pseudoPath;
    private static String realPath;

    static {
        pseudoPath = new ArrayList<>(Arrays.asList("root"));
        realPath = "src\\main\\java\\com\\~\\root\\";
    }

    // написать тест с положительным и негативным сценарием
    public List<String> getCurrentPath() {
        return new ArrayList<>(pseudoPath);
    }

    public String getRealPath() {
        return realPath;
    }

    public void setPseudoPath(List<String> payload) {
        pseudoPath = payload;
    } 

    // тест 
    public void addPath(String path) {
        pseudoPath.add(path);
        realPath = realPath.concat(path + "\\");
    }


    // test
    public void popPath() {
        realPath = realPath.replace(pseudoPath.get(pseudoPath.size() - 1) + "\\", "");
        pseudoPath.remove(pseudoPath.size() - 1);
    }

    // тест с сравнением временем выполнения декларативного и императивного решения (10 элементов)
    public String toString() {
        return pseudoPath.stream()
            .reduce("", (result, element) -> result + "\\" + element);
    }
}
