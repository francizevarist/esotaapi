package com.esotacredit.esotaapi.api.verification;


import com.esotacredit.esotaapi.api.verification.datamodel.UserInformationBody;
import com.esotacredit.esotaapi.api.verification.datamodel.UserInformationResponse;
import com.esotacredit.esotaapi.api.verification.datamodel.VerificationBody;
import com.esotacredit.esotaapi.api.verification.datamodel.VerificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class VerificationResource {

    @Autowired
    VerificationDaoService service;

    @PostMapping("/verify")
    VerificationResponse verifyUser(@RequestBody VerificationBody verificationBody){
        return new VerificationResponse(service.verifyUser(verificationBody));
    }

    @PostMapping("/userinformation")
    UserInformationResponse userInformation(@RequestBody UserInformationBody userInformationBody){
        return new UserInformationResponse(service.userInformation(userInformationBody));
    }

}
