package com.kg.common.utils;

import cn.hutool.json.JSONUtil;
import com.coze.openapi.client.chat.*;
import com.coze.openapi.client.chat.model.ChatPoll;
import com.coze.openapi.client.connversations.message.model.Message;
import com.coze.openapi.service.auth.TokenAuth;
import com.coze.openapi.service.service.CozeAPI;
import com.kg.common.BusinessException;
import com.kg.common.KnowledgePoints;

import java.util.Collections;

/**
 * @author ggstudy11
 * @date Created in 2025/4/30 14:39
 * @description CozeAPI工具类封装
 */
public class CozeUtil {
    private static final String Token = "pat_pwsvMJqcq9uW4xVnwHQb0ypDfVGbruu1eOS6H9uwJVKYwDhPdBxtHQ7AtMvWRy18";
    private static final String BLOG_BOT_ID = "7498763513574899739";
    private static final String COZE_API_BASE = "https://api.coze.cn/v3/chat/";
    /* we dont care the concrete ID because only chat once*/
    private static final String USER_ID = "123456";
    public static KnowledgePoints blogChat(String msg) {

        TokenAuth authCli = new TokenAuth(Token);

        // Init the Coze client through the access_token.
        CozeAPI coze =
                new CozeAPI.Builder()
                        .baseURL(COZE_API_BASE)
                        .auth(authCli)
                        .readTimeout(10000)
                        .build();

        /*
         * Step one, create chat
         * Call the coze.chat().create() method to create a chat. The create method is a non-streaming
         * chat and will return a Chat class. Developers should periodically check the status of the
         * chat and handle them separately according to different states.
         * */
        CreateChatReq req =
                CreateChatReq.builder()
                        .botID(BLOG_BOT_ID)
                        .userID(USER_ID)
                        .messages(Collections.singletonList(Message.buildUserQuestionText(msg)))
                        .build();
        /*
         * Step two, poll the result of chat
         * Assume the development allows at most one chat to run for 10 seconds. If it exceeds 10 seconds,
         * the chat will be cancelled.
         * And when the chat status is not completed, poll the status of the chat once every second.
         * After the chat is completed, retrieve all messages in the chat.
         * */
        try {
            ChatPoll chat3 = coze.chat().createAndPoll(req);
            String jsonStr = chat3.getMessages().get(chat3.getMessages().size() - 2).getContent();
            return JSONUtil.toBean(jsonStr, KnowledgePoints.class);
        } catch (Exception e) {
            throw new BusinessException("CozeAPI调用失败");
        }
    }
}
