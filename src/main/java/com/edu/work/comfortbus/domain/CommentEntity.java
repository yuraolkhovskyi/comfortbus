package com.edu.work.comfortbus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    @Override
    public String toString() {
        return "CommentEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
