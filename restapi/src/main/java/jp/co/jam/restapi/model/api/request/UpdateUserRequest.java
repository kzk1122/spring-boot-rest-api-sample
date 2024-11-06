package jp.co.jam.restapi.model.api.request;

import jp.co.jam.restapi.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

// アップデートしたい項目だけ送るため、Not nullのチェックはしない
@Data
@AllArgsConstructor
public class UpdateUserRequest {

    private String userName;

    private String userId;

    private String email;

    public static UserDTO toDTO(UpdateUserRequest request) {
        return new UserDTO(null, request.getUserName(), request.getUserId(), request.getEmail(), null);
    }
}
