package com.ceva.spring6.simple_abstraction_sample.repositories;

import com.ceva.spring6.simple_abstraction_sample.models.Comment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*
 * La anotacion @Component es muy generica. Mientras que la anotacion @Repository indica la responsabilidad que tiene un objeto
 * de implementar los casos de uso para menejar el almacenamiento de informacion, es por ello que en lugar de usar @Component
 * empleamos @Repository
 */
@Repository
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment " + comment.getText());
    }
}
