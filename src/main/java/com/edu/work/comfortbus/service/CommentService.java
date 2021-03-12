package com.edu.work.comfortbus.service;

import com.edu.work.comfortbus.exception.ExceptionConstants;
import com.edu.work.comfortbus.domain.CommentEntity;
import com.edu.work.comfortbus.domain.UserEntity;
import com.edu.work.comfortbus.dto.comment.RequestCommentDTO;
import com.edu.work.comfortbus.dto.comment.ResponseCommentDTO;
import com.edu.work.comfortbus.exception.SystemException;
import com.edu.work.comfortbus.exception.code.ServiceErrorCode;
import com.edu.work.comfortbus.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    //create
    public ResponseCommentDTO save(final RequestCommentDTO requestCommentDTO) {

        final UserEntity userEntity = userService.findById(requestCommentDTO.getUserId());

        final var commentEntity = new CommentEntity();

        commentEntity.setContent(requestCommentDTO.getContent());
        commentEntity.setUser(userEntity);

        final CommentEntity save = commentRepository.save(commentEntity);
        return new ResponseCommentDTO(save.getContent(), userEntity);
    }

    //read
    public List<CommentEntity> findAll() {
        return commentRepository.findAll();
    }

    public CommentEntity findById(final Long busId) {
        Optional<CommentEntity> comment = commentRepository.findById(busId);
        if (comment.isEmpty()) {
            throw new SystemException(ExceptionConstants.BAD_REQUEST_MESSAGE, ServiceErrorCode.BAD_REQUEST);
        }
        return comment.get();
    }

    //update
    public ResponseCommentDTO update(final RequestCommentDTO commentEntityForUpdate) {
        if (Objects.isNull(commentEntityForUpdate.getId())) {
            return save(commentEntityForUpdate);
        }

        commentEntityForUpdate.setId(findById(commentEntityForUpdate.getId()).getId());

        return save(commentEntityForUpdate);
    }

    //delete
    public Long delete(final Long commentId) {
        commentRepository.deleteById(commentId);
        return commentId;
    }

}
