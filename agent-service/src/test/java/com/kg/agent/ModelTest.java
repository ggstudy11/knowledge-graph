package com.kg.agent;

import cn.hutool.json.JSONUtil;
import com.kg.agent.model.Recommendation;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModelTest {
    
    @Autowired
    private ChatClient chatClient;

 

    @Test public void modelTest() {
        String content = chatClient.prompt().user("Java record关键字").call().content();
        new Recommendation(content);
    }
}
