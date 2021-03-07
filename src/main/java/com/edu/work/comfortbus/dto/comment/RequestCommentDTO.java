package com.edu.work.comfortbus.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCommentDTO {

    private Long id;
    private String content;
    private Long userId;


}
