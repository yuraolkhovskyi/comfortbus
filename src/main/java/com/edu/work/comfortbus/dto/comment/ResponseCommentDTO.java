package com.edu.work.comfortbus.dto.comment;

import com.edu.work.comfortbus.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCommentDTO {

    private Long id;
    private String content;
    private UserEntity user;

    public ResponseCommentDTO(String content, UserEntity user) {
        this.content = content;
        this.user = user;
    }
}
