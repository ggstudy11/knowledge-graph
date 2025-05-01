package com.kg.graph;

import org.junit.jupiter.api.Test;
import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 9:00
 * @description
 */
@SpringBootTest
public class ConnectTest {

    @Autowired
    private Driver driver;

    @Test public void connectTest() {
        driver.verifyConnectivity();
    }
}
