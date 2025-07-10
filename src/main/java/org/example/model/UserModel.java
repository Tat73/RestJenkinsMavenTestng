package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {

    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
