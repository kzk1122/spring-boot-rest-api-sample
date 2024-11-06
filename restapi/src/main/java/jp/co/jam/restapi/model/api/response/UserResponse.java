package jp.co.jam.restapi.model.api.response;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jp.co.jam.restapi.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String userId;

    @NotNull
    private String email;

    @NotNull
    // yyyy/mm/dd形式
    @Pattern(regexp="^(19|20)\\d{2}/(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])$")
    private String createDate;

    // UserDTOからUserResponseを作成する
    public static UserResponse of(UserDTO dto) {
        return new UserResponse(dto.getId(), dto.getUserName(), dto.getUserId(), dto.getEmail(), dto.getCreateDate());
    }

    // UserDTOのListからUserResponseのListを作成する
    public static List<UserResponse> toList(List<UserDTO> dtoList) {
        return dtoList.stream().map(UserResponse::of).collect(Collectors.toList());
    }
}
