package com.ceva.spring6.simple_abstraction_sample.repositories;

import com.ceva.spring6.simple_abstraction_sample.models.Comment;

/*
 * Las interfaces son abstractas, nunca se usan anotaciones spring en interfaces o clases abstractas porque estas
 * no se pueden instanciar.
 * Las anotaciones de estereotipo se aplican sobre clases, las cuales se pueden instanciar y agregar al contexto de spring.
 */
public interface CommentRepository {
    public void storeComment(Comment comment);
}
