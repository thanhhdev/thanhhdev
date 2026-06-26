package com.lab.services;

import com.lab.model.Comment;
import com.lab.proxies.CommentNotificationProxy;
import com.lab.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    // Constructor Injection: final fields -> immutable -> thread-safe
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy notificationProxy;

    // Two CommentRepository beans exist (DB + File). @Qualifier picks the one
    // whose bean name is "DBCommentRepository" (default name keeps the leading
    // uppercase pair). Single constructor -> @Autowired is optional.
    public CommentService(
            @Qualifier("DBCommentRepository") CommentRepository commentRepository,
            CommentNotificationProxy notificationProxy) {
        this.commentRepository = commentRepository;
        this.notificationProxy = notificationProxy;
        System.out.println("[INIT] CommentService created!");
    }

    public void publishComment(Comment comment) {
        System.out.println("\n>> Publishing: " + comment);
        commentRepository.storeComment(comment);
        notificationProxy.sendNotification(comment);
        System.out.println(">> Done!\n");
    }
}
