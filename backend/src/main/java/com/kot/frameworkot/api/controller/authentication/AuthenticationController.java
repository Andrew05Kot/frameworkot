package com.kot.frameworkot.api.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kot.frameworkot.api.common.ServiceAPIUrl;
import com.kot.frameworkot.api.service.authentication.AuthenticationAPIService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = AuthenticationController.BASE_URL)
public class AuthenticationController {

    public static final String BASE_URL = ServiceAPIUrl.V1_PATH + "/auth";

    @Autowired
    private AuthenticationAPIService authenticationAPIService;

    @ApiOperation(value = "Get long lived authentication token")
    @GetMapping
    public ResponseEntity<String> authenticate(
            @ApiParam(name = "token", value = "Short lived token used to get a new long lived token")
            @RequestParam String token) {
        String longLivedToken = authenticationAPIService.authenticate(token);
        return new ResponseEntity<>(String.format("{\"token\" : \"%s\"}", longLivedToken), HttpStatus.OK);
    }
}