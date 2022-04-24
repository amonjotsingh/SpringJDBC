package com.example.pragra23apr.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private Instant createDate;
    private Instant updateDate;
}
