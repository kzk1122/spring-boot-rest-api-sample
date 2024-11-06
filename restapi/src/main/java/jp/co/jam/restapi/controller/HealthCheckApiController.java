package jp.co.jam.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.jam.restapi.model.api.response.HealthCheckResponse;


@RestController
@RequestMapping("/api")
public class HealthCheckApiController {

    // ヘルスチェックAPI
    @GetMapping("/health")
    public ResponseEntity<HealthCheckResponse> getSample() {
        return new ResponseEntity<HealthCheckResponse>(new HealthCheckResponse("api call success!!!"), HttpStatus.OK);
    }

}
