package com.ceva.spring6.simple_abstraction_sample;

import com.ceva.spring6.simple_abstraction_sample.Config.ProjectConfiguration;
import com.ceva.spring6.simple_abstraction_sample.models.Comment;
import com.ceva.spring6.simple_abstraction_sample.proxies.EmailCommentNotificationProxy;
import com.ceva.spring6.simple_abstraction_sample.repositories.DBCommentRepository;
import com.ceva.spring6.simple_abstraction_sample.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Carlos V.");
        comment.setText("Testing comment app");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

        // creamos instancias de las dependencias.
//        var commentRepository = new DBCommentRepository();
//        var commentNotificationProxy = new EmailCommentNotificationProxy();
//
//        var commentService = new CommentService(commentRepository, commentNotificationProxy);
//
//        var comment = new Comment();
//        comment.setAuthor("John Doe");
//        comment.setText("Demo text");
//
//        commentService.publishComment(comment);
    }
}
