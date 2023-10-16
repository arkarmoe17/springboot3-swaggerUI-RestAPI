package com.learning.springboot3swaggerui.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.springboot3swaggerui.model.constants.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
}
