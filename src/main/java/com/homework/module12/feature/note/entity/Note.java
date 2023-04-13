package com.homework.module12.feature.note.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Note {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;
    String title;
    String content;

    public Note (String title, String content){
        this.title = title;
        this.content = content;
    }
}
