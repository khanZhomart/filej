package com.filej.complexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeclarativeStyleTest {
    private static final Logger logger = LoggerFactory.getLogger(DeclarativeStyleTest.class);
    private List<String> elements = new ArrayList<>(
        Arrays.asList(
            "root", "home", "src", "logs", "bin", "data", "assets", "temp", "system", "folder",
            "abcd", "fdsfs", "daskdas", "logsss", "binsbi", "dataaadata", "assetssas", "temporary", "systematic", "folders2"
            )
    );

    @Test
    public void Compute_Declaratively_ExecutionTime() {
        String path = elements.stream()
            .reduce("", (result, element) -> result + "\\" + element);

        logger.info("Created declaratively: " + path);
    }
}
