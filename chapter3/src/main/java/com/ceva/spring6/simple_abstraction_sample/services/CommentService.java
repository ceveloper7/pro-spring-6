package com.ceva.spring6.simple_abstraction_sample.services;

import com.ceva.spring6.simple_abstraction_sample.models.Comment;
import com.ceva.spring6.simple_abstraction_sample.proxies.CommentNotificationProxy;
import com.ceva.spring6.simple_abstraction_sample.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
 * Cuando se carga el contexto, spring crear instancias de las clases con anotacion de estereotipo y las agrega al contexto.
 * @Component le dice al spring que cree una instancia de la clase y agregue una instancia como un bean al contexto
 * @Service marca a una clase como la responsable de implementar un caso de uso en nuestro ejemplo el caso de uso es la
 * publicacion de un comentario es por ello que marcamos a la clase CommentService como un @Service y no como @Component que es
 * una anotacion generica.
 */
//@Component
@Service
public class CommentService {
    /*
     * Spring nota que los atributos de instancia de esta clase son de tipo interfaz por lo tanto buscara en su contexto
     * bean creados con clases que implementen estas interfaces
     * En este caso utilizamos constructor dependency injection que es la mas utilizada pero para poder usar otra implementacion como
     * field dependency injection tendriamos que quitar la palabra final y agregar la anotacion @Autowired a las dos variables
     * de instancia de clase.
     * @Autowired
     * private CommentRepository commentRepository
     */
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    /*
     * Dado que tenemos un solo constructor en la clase agregar la anotacion Autowired es opciona.
     * La linea @Qualifier("PUSH") le dice a spring que la implementacion que debe injectar es CommentPushNotificationProxy
     */
    @Autowired
    public CommentService(CommentRepository commentRepository,
                          @Qualifier("PUSH")
                          CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
