package com.esotacredit.esotaapi.api.ecommerce.searching;

import com.esotacredit.esotaapi.api.ecommerce.products.objects.Product;

import java.util.List;

public class SearchingResponse {
    private List<Product> seachResult;

    public SearchingResponse() {}

    public SearchingResponse(SearchingResponseBody seachResult) {
        this.seachResult = seachResult.getSearchResult();
    }

    public List<Product> getSeachResult() {
        return seachResult;
    }
}
