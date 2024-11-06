package jp.co.jam.restapi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotNull;
import jp.co.jam.restapi.exception.UserNotFoundException;
import jp.co.jam.restapi.model.dto.UserDTO;
import jp.co.jam.restapi.model.entity.UserEntity;
import jp.co.jam.restapi.repository.UserRepository;
import jp.co.jam.restapi.util.DateUtil;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(@NotNull UserDTO user) throws Exception {

        // DB登録用にEntity作成
        UserEntity entity = new UserEntity();
        entity.setUserName(user.getUserName());
        entity.setUserId(user.getUserId());
        entity.setEmail(user.getEmail());
        entity.setCreateDate(DateUtil.convertStringToDate(user.getCreateDate()));
        entity.setUpdateDate(new Date());

        UserEntity createUser = userRepository.save(entity);

        return UserDTO.of(createUser);
    }

    @Override
    public List<UserDTO> getUsers() {
        return UserDTO.toList(userRepository.findAll());
    }

    @Override
    public UserDTO getUser(@NotNull Long id) throws Exception {
        return UserDTO.of(findById(id));
    }

    @Override
    public void deleteUser(@NotNull Long id) throws Exception {
        // ユーザーの存在チェック
        findById(id);

        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateUser(@NotNull Long id, UserDTO dto) throws Exception {
        // 現在のユーザー情報取得
        UserEntity user = findById(id);

        // 更新がある項目を上書きする
        user.setUserName(dto.getUserName() == null ? user.getUserName() : dto.getUserName());
        user.setUserId(dto.getUserId() == null ? user.getUserId() : dto.getUserId());
        user.setEmail(dto.getEmail() == null ? user.getEmail() : dto.getEmail());
        user.setUpdateDate(new Date());

        // ユーザー情報更新
        UserEntity updateUser = userRepository.save(user);

        return UserDTO.of(updateUser);
    }

    private UserEntity findById(@NotNull Long id) throws Exception {

        Optional<UserEntity> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        return optionalUser.get();
    }
}
