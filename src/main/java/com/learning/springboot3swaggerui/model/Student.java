package com.learning.springboot3swaggerui.model;

import com.learning.springboot3swaggerui.model.constants.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String email;
    private Gender gender;
    private String major;
}
