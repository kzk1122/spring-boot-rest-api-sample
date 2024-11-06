package jp.co.jam.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotNull;
import jp.co.jam.restapi.model.dto.UserDTO;

@Service
public interface UserService {

    UserDTO createUser(@NotNull UserDTO user) throws Exception;

    List<UserDTO> getUsers();

    UserDTO getUser(@NotNull Long id) throws Exception;

    UserDTO updateUser(@NotNull Long id, UserDTO dto) throws Exception;

    void deleteUser(@NotNull Long id) throws Exception;
}
