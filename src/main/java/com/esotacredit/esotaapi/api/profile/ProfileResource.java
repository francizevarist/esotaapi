package com.esotacredit.esotaapi.api.profile;


import com.esotacredit.esotaapi.api.profile.credithistory.CreditBody;
import com.esotacredit.esotaapi.api.profile.credithistory.CreditResponse;
import com.esotacredit.esotaapi.api.profile.credithistory.CreditResponseBody;
import com.esotacredit.esotaapi.api.profile.withdraw.WithdrawBody;
import com.esotacredit.esotaapi.api.profile.withdraw.WithdrawResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProfileResource {

    @Autowired
    ProfileDaoService service;

    @PostMapping("/creditlist")
    public CreditResponse getCredits(@RequestBody CreditBody creditBody){
        return new CreditResponse(service.getCreditList(creditBody));
    }

    @PostMapping("/withdraw")
    public WithdrawResponse withdrawCredit(@RequestBody WithdrawBody withdrawBody){
        return new WithdrawResponse(service.drawCredit(withdrawBody));
    }

}
