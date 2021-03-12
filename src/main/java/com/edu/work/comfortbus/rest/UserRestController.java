package com.edu.work.comfortbus.rest;

import com.edu.work.comfortbus.dto.user.ResponseUserDTO;
import com.edu.work.comfortbus.domain.UserEntity;
import com.edu.work.comfortbus.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api//user")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserEntity save(@RequestBody final UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ResponseUserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/get/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserEntity findUserById(@PathVariable final Long userId) {
        return userService.findById(userId);
    }

    @PatchMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public UserEntity update(@RequestBody final UserEntity userEntity) {
        return userService.update(userEntity);
    }

    @DeleteMapping(value = "/delete/{userId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Long delete(@PathVariable final Long userId) {
        return userService.delete(userId);
    }


}
