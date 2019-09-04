package com.esotacredit.esotaapi.api.login;

import com.esotacredit.esotaapi.api.login.datamodel.LoginBody;
import com.esotacredit.esotaapi.api.login.datamodel.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginResource {

    @Autowired
    LoginDaoService service;

    @PostMapping("/login")
    LoginResponse loginToAccount(@RequestBody LoginBody loginBody){
        return new LoginResponse(service.login(loginBody));
    }

}
