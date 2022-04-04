package com.filej.complexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImperativeStyleTest {
    private static final Logger logger = LoggerFactory.getLogger(ImperativeStyleTest.class);
    private List<String> elements = new ArrayList<>(
        Arrays.asList(
            "root", "home", "src", "logs", "bin", "data", "assets", "temp", "system", "folder",
            "abcd", "fdsfs", "daskdas", "logsss", "binsbi", "dataaadata", "assetssas", "temporary", "systematic", "folders2"
        )
    );

    @Test
    public void Compute_Imperatively_ExecutionTime() {
        StringBuilder path = new StringBuilder();

        for (String element : elements) {
            path.append("\\");
            path.append(element);
        }

        logger.info("Created imperatively: " + path.toString());
    }
}
