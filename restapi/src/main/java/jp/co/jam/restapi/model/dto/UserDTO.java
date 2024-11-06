package jp.co.jam.restapi.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jp.co.jam.restapi.model.entity.UserEntity;
import jp.co.jam.restapi.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String userId;

    @NotNull
    private String email;

    // yyyy/mm/dd形式
    @Pattern(regexp="^(19|20)\\d{2}/(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])$")
    private String createDate;

    // UserEntityをUserDTOに変換する
    public static UserDTO of(UserEntity entity) {
        return new UserDTO(entity.getId(), entity.getUserName(), entity.getUserId(), entity.getEmail(), DateUtil.formatDate(entity.getCreateDate()));
    }

    // UserEntityのListをUserDTOのListに変換する
    public static List<UserDTO> toList(List<UserEntity> entityList) {
        return entityList.stream().map(UserDTO::of).collect(Collectors.toList());
    }
}

