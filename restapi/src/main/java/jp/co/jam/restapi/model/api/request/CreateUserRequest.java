package jp.co.jam.restapi.model.api.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jp.co.jam.restapi.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserRequest {

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

    public static UserDTO toDTO(CreateUserRequest request) {
        return new UserDTO(null, request.getUserName(), request.getUserId(), request.getEmail(), request.getCreateDate());
    }
}
