package com.example.helloworld.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    public Long id;
    public String title;
    public String content;

}