package com.filej.states;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeState {
    private static TreeState instance;

    private List<String> currentPath;
    private String realPath;

    private TreeState() {
        this.currentPath = new ArrayList<>(Arrays.asList("root")); // вынести в статичный блок инициализацию значений
        this.realPath = "src\\main\\java\\com\\~\\root\\";
    }   // вынести значения в конфиг файл

    public static TreeState getInstance() {
        if (instance == null)   // сделать потокобезопасным
            instance = new TreeState();

        return instance;
    }

    // написать тест с положительным и негативным сценарием
    public List<String> getCurrentPath() {
        return new ArrayList<>(currentPath);
    }

    public String getRealPath() {
        return realPath;
    }

    public void setCurrentPath(List<String> currentPath) {
        this.currentPath = currentPath;
    } 

    // тест 
    public void addPath(String path) {
        currentPath.add(path);
        realPath = realPath.concat(path + "\\");
    }


    // test
    public void popPath() {
        realPath = realPath.replace(currentPath.get(currentPath.size() - 1) + "\\", "");
        currentPath.remove(currentPath.size() - 1);
    }

    // тест с сравнением временем выполнения декларативного и императивного решения (10 элементов)
    public String toString() {
        return currentPath.stream()
            .reduce("", (result, element) -> result + "\\" + element);
    }
}
