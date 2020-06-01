package com.github.richygreat.aaum.user.controller;

import com.github.richygreat.aaum.model.PageResultDto;
import com.github.richygreat.aaum.user.model.UserModel;
import com.github.richygreat.aaum.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody @Valid UserModel userModel) {
        log.info("createUser: Entering userModel: {}", userModel);
        return ResponseEntity.ok(userService.createUser(userModel));
    }

    @GetMapping
    public ResponseEntity<PageResultDto<UserModel>> listUsers(@RequestParam("page") Integer page,
                                                              @RequestParam("size") Integer size) {
        log.info("listUsers: Entering page: {} size: {}", page, size);
        return ResponseEntity.ok(userService.listUsers(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> readUser(@PathVariable("id") String id) {
        log.info("readUser: Entering id: {}", id);
        return ResponseEntity.ok(userService.readUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable("id") String id,
                                                @RequestBody @Valid UserModel userModel) {
        log.info("updateUser: Entering userModel: {}", userModel);
        return ResponseEntity.ok(userService.updateUser(id, userModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        log.info("deleteUser: Entering id: {}", id);
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
