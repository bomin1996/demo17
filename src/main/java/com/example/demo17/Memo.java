package com.example.demo17;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "memos")
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    // 생성자, Getter, Setter 생략
}
