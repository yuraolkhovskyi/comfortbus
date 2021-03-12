package com.edu.work.comfortbus.rest;

import com.edu.work.comfortbus.dto.comment.RequestCommentDTO;
import com.edu.work.comfortbus.dto.comment.ResponseCommentDTO;
import com.edu.work.comfortbus.domain.CommentEntity;
import com.edu.work.comfortbus.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/comment")
@AllArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    @PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseCommentDTO save(@RequestBody final RequestCommentDTO requestCommentDTO) {
        return commentService.save(requestCommentDTO);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CommentEntity> findAll() {
        return List.of(
                new CommentEntity(1L, "content", null),
                new CommentEntity(2L, "content1", null),
                new CommentEntity(3L, "content2", null),
                new CommentEntity(4L, "content3", null)
        );
//        return commentService.findAll();
    }

    @GetMapping(value = "/get/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public CommentEntity findCommentById(@PathVariable final Long commentId) {
        return commentService.findById(commentId);
    }

    @PatchMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseCommentDTO update(@RequestBody final RequestCommentDTO requestCommentDTO) {
        return commentService.update(requestCommentDTO);
    }

    @DeleteMapping(value = "/delete/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Long delete(@PathVariable final Long commentId) {
        return commentService.delete(commentId);
    }

}
