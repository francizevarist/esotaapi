package com.esotacredit.esotaapi.api.helper;

import com.esotacredit.esotaapi.api.helper.datamodel.CountryResponse;
import com.esotacredit.esotaapi.api.helper.datamodel.LocalLocationBody;
import com.esotacredit.esotaapi.api.helper.datamodel.LocalLocationResponse;
import com.esotacredit.esotaapi.api.helper.datamodel.PaymentTypeResponse;
import com.esotacredit.esotaapi.api.helper.datamodel.object.CountryBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HelperResource {

    @Autowired
    HelperDaoService service;

    @PostMapping("/country")
    CountryResponse countryList(@RequestBody CountryBody countryBody){
        return new CountryResponse(service.countryList(countryBody));
    }

    @PostMapping("/locallocation")
    LocalLocationResponse localLocationList(@RequestBody LocalLocationBody localLocationBody){
        return new LocalLocationResponse(service.localLocationList(localLocationBody));
    }

    @GetMapping("/paymenttypes")
    PaymentTypeResponse getPaymentTypes(){
        return new PaymentTypeResponse(service.getPaymentTypes());
    }

}
