package com.github.richygreat.aaum.user.service;

import com.github.richygreat.aaum.model.PageResultDto;
import com.github.richygreat.aaum.user.document.UserDocument;
import com.github.richygreat.aaum.user.mapper.UserMapper;
import com.github.richygreat.aaum.user.model.UserModel;
import com.github.richygreat.aaum.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Transactional
    public UserModel createUser(UserModel userModel) {
        userModel.setId(null);
        return userMapper.toModel(userRepository.save(userMapper.toDocument(userModel)));
    }

    @Transactional
    public PageResultDto<UserModel> listUsers(Integer page, Integer size) {
        Page<UserDocument> userDocumentPage = userRepository.findAll(PageRequest.of(page, size));
        return new PageResultDto<>(userDocumentPage.getTotalPages(), page, userDocumentPage.getContent()
                .stream().map(userMapper::toModel).collect(Collectors.toList()));
    }

    @Transactional
    public UserModel readUser(String id) {
        return userRepository.findById(id).map(userMapper::toModel)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
    }

    @Transactional
    public UserModel updateUser(String id, UserModel userModel) {
        userModel.setId(id);
        return userRepository.findById(id).map(
                userDocument -> userMapper.toModel(userRepository.save(userMapper.toDocument(userModel))))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found"));
    }

    @Transactional
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
