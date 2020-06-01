package com.github.richygreat.aaum.user.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("user")
public class UserDocument {
    @Id
    private String username;
    private String password;
    private List<String> roles;
}
