package com.edu.work.comfortbus.service;

import com.edu.work.comfortbus.domain.CommentEntity;
import com.edu.work.comfortbus.dto.comment.RequestCommentDTO;
import com.edu.work.comfortbus.dto.comment.ResponseCommentDTO;

import java.util.List;

public interface CommentService {

    ResponseCommentDTO save(final RequestCommentDTO requestCommentDTO);

    CommentEntity findById(final Long busId);

    List<CommentEntity> findAll();

    ResponseCommentDTO update(final RequestCommentDTO commentEntityForUpdate);

    Long delete(final Long commentId);

}
