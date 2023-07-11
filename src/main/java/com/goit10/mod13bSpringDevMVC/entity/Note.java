package com.goit10.mod13bSpringDevMVC.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Note {
    private Long id;
    private String title;
    private String content;
}