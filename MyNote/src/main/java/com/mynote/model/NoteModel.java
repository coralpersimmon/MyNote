package com.mynote.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteModel {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;
}
