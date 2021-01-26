package com.lp.work.comfortbus.service;

import com.lp.work.comfortbus.entity.CommentEntity;
import com.lp.work.comfortbus.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    //create
    public CommentEntity save(final CommentEntity comment) {
        return commentRepository.save(comment);
    }

    //read
    public List<CommentEntity> findAll() {
        return commentRepository.findAll();
    }

    public CommentEntity findById(final Long busId) {
        Optional<CommentEntity> comment = commentRepository.findById(busId);
        if (comment.isEmpty()) {
            throw new RuntimeException("There is no comment with such id:" + busId);
        }
        return comment.get();
    }

    //update
    public CommentEntity update(final CommentEntity commentEntityForUpdate) {
        if (Objects.isNull(commentEntityForUpdate.getId())) {
            save(commentEntityForUpdate);
        }

        final CommentEntity comment = findById(commentEntityForUpdate.getId());

        comment.setContent(commentEntityForUpdate.getContent());
        comment.setUser(commentEntityForUpdate.getUser());

        return save(comment);
    }

    //delete
    public Long delete(final Long commentId) {
        commentRepository.deleteById(commentId);
        return commentId;
    }

}
