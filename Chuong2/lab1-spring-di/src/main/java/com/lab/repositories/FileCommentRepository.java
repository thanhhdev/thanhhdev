package com.lab.repositories;

import com.lab.model.Comment;
import org.springframework.stereotype.Repository;

// Second implementation of the same type. With two beans of type
// CommentRepository, Spring needs @Qualifier (see CommentService) to know
// which one to inject -- otherwise NoUniqueBeanDefinitionException.
@Repository
public class FileCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("  [File] Storing: " + comment);
    }
}
