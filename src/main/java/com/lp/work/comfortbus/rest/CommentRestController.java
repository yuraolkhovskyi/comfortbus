package com.lp.work.comfortbus.rest;

import com.lp.work.comfortbus.entity.CommentEntity;
import com.lp.work.comfortbus.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
@AllArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    @PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CommentEntity save(@RequestBody final CommentEntity commentEntity) {
        return commentService.save(commentEntity);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CommentEntity> findAll() {
        return commentService.findAll();
    }

    @GetMapping(value = "/get/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public CommentEntity findCommentById(@PathVariable final Long commentId) {
        return commentService.findById(commentId);
    }

    @PatchMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public CommentEntity update(@RequestBody final CommentEntity comment) {
        return commentService.update(comment);
    }

    @DeleteMapping(value = "/delete/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Long delete(@PathVariable final Long commentId) {
        return commentService.delete(commentId);
    }

}
