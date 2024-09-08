package com.ceva.spring6.simple_abstraction_sample.proxies;

import com.ceva.spring6.simple_abstraction_sample.models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
 * CommentNotificationProxy cuenta con dos beans EmailCommentNotificationProxy y CommentPushNotificacionProxy
 * spring necesita saber cual de estos dos beans debe injectar. Con la anotacion @Primary le decimos a spring que el bean
 * CommentPushNotificacionProxy es la implementacion por defecto que debe injectar.
 */
@Qualifier("PUSH")
@Component
@Primary // marcamos esta implementacion como la injeccion de dependencia por defecto.
public class CommentPushNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment " + comment.getText());
    }
}
