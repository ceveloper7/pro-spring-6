package com.ceva.spring6.simple_abstraction_sample.proxies;

import com.ceva.spring6.simple_abstraction_sample.models.Comment;

public interface CommentNotificationProxy {
    public void sendComment(Comment comment);
}
