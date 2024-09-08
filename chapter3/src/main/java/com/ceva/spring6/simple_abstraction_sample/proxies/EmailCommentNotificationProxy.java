package com.ceva.spring6.simple_abstraction_sample.proxies;

import com.ceva.spring6.simple_abstraction_sample.models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("EMAIL")
@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment " + comment.getText());
    }
}
