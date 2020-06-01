package com.github.richygreat.aaum.user.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UserModel {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private List<String> roles;
}
