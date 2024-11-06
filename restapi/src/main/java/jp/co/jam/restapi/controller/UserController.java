package jp.co.jam.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jam.restapi.model.api.request.CreateUserRequest;
import jp.co.jam.restapi.model.api.request.UpdateUserRequest;
import jp.co.jam.restapi.model.api.response.UserResponse;
import jp.co.jam.restapi.model.dto.UserDTO;
import jp.co.jam.restapi.service.UserService;




@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> postMethodName(@Validated @RequestBody CreateUserRequest user) throws Exception {

        UserDTO createdUser = userService.createUser(CreateUserRequest.toDTO(user));
        
        return new ResponseEntity<UserResponse>(UserResponse.of(createdUser), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {

        List<UserDTO> users = userService.getUsers();

        return new ResponseEntity<List<UserResponse>>(UserResponse.toList(users), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) throws Exception {

        UserDTO user = userService.getUser(id);

        return new ResponseEntity<UserResponse>(UserResponse.of(user), HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest user, @PathVariable Long id) throws Exception {

        UserDTO dto = UpdateUserRequest.toDTO(user);

        UserDTO updateUser = userService.updateUser(id, dto);

        return new ResponseEntity<UserResponse>(UserResponse.of(updateUser), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) throws Exception {

        userService.deleteUser(id);

        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}