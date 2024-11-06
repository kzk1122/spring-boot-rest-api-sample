package jp.co.jam.restapi.model.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthCheckResponse {

    private String message;

}
