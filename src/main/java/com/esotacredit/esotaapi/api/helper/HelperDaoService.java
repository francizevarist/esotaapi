package com.esotacredit.esotaapi.api.helper;

import com.esotacredit.esotaapi.api.helper.datamodel.CountryResponseBody;
import com.esotacredit.esotaapi.api.helper.datamodel.LocalLocationBody;
import com.esotacredit.esotaapi.api.helper.datamodel.LocalLocationResponseBody;
import com.esotacredit.esotaapi.api.helper.datamodel.PaymentTypeResponseBody;
import com.esotacredit.esotaapi.api.helper.datamodel.model.Country;
import com.esotacredit.esotaapi.api.helper.datamodel.model.LocalLocation;
import com.esotacredit.esotaapi.api.helper.datamodel.model.PaymentType;
import com.esotacredit.esotaapi.api.helper.datamodel.object.CountryBody;
import com.esotacredit.esotaapi.database.DatabaseConfiguration;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class HelperDaoService {

    public CountryResponseBody countryList(CountryBody countryBody){

        List<Country> countryList = new ArrayList<>();

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get all country
            String query_getCountries = "SELECT *FROM  country WHERE country_name LIKE '"+countryBody.getCountryName()+"%'";

            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(query_getCountries);

            while(rs.next()){
                Country item = new Country(rs.getInt("id"),rs.getString("country_name"),rs.getString("country_code"),rs.getString("currency_id"));
                countryList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new CountryResponseBody(countryList);
    }


    public LocalLocationResponseBody localLocationList(LocalLocationBody localLocationBody){
        List<LocalLocation> localLocationList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get all country
            String query_getLocalLocations = "SELECT *FROM  locations WHERE country_id = '"+localLocationBody.getCountryId()+"' AND location_name like '"+localLocationBody.getTypedName()+"%'";

            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(query_getLocalLocations);

            while(rs.next()){
                LocalLocation item = new LocalLocation(rs.getInt("id"),rs.getString("location_name"),rs.getInt("country_id"),rs.getString("delivery_time"),rs.getString("delivery_fee"));
                localLocationList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new LocalLocationResponseBody(localLocationList);
    }


    public PaymentTypeResponseBody getPaymentTypes(){

        List<PaymentType> paymentTypeList = new ArrayList<>();

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get all country
            String query_getCountries = "SELECT *FROM  payment_types";

            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(query_getCountries);

            while(rs.next()){
                PaymentType item = new PaymentType(rs.getInt("id"),rs.getString("type_name"),rs.getString("type_code"));
                paymentTypeList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new PaymentTypeResponseBody(paymentTypeList);
    }

}
