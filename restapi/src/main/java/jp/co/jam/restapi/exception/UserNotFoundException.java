package jp.co.jam.restapi.exception;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

// ユーザーが存在しない場合の例外クラス
@Getter
public class UserNotFoundException extends Exception {
    
    private ErrorMessage errorMessage;

    public UserNotFoundException(@NotNull String message) {
        super(message);
        this.errorMessage = new ErrorMessage(message);
    }

}