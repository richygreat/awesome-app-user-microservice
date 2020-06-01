package com.github.richygreat.aaum.user.mapper;

import com.github.richygreat.aaum.user.document.UserDocument;
import com.github.richygreat.aaum.user.model.UserModel;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserModel toModel(UserDocument userDocument);

    UserDocument toDocument(UserModel userModel);
}
