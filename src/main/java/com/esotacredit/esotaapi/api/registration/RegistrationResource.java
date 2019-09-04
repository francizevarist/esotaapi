package com.esotacredit.esotaapi.api.registration;

import com.esotacredit.esotaapi.api.registration.datamodel.RegistrationBody;
import com.esotacredit.esotaapi.api.registration.datamodel.RegistrationResponse;
import com.esotacredit.esotaapi.api.registration.edit.editname.EditNameBody;
import com.esotacredit.esotaapi.api.registration.edit.editname.EditNameResponse;
import com.esotacredit.esotaapi.api.registration.edit.editnumber.EditPhoneNumberBody;
import com.esotacredit.esotaapi.api.registration.edit.editnumber.EditPhoneNumberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RegistrationResource {

    @Autowired
    RegistrationDaoService service;

    @PostMapping("/registration")
    RegistrationResponse createUser(@RequestBody RegistrationBody registrationBody){
        return new RegistrationResponse(service.createUser(registrationBody));
    }

    @PostMapping("/editname")
    EditNameResponse editName(@RequestBody EditNameBody editNameBody){
        return new EditNameResponse(service.editName(editNameBody));
    }

    @PostMapping("/editphonenumber")
    EditPhoneNumberResponse editPhoneNumber(@RequestBody EditPhoneNumberBody editPhoneNumberBody){
        return new EditPhoneNumberResponse(service.editPhoneNumber(editPhoneNumberBody));
    }

}
