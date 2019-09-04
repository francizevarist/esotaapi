package com.esotacredit.esotaapi.api.ecommerce.searching;

import com.esotacredit.esotaapi.api.ecommerce.products.objects.Product;

import java.util.List;

public class SearchingResponseBody {
    private List<Product> searchResult;
    public SearchingResponseBody() {}

    public SearchingResponseBody(List<Product> searchResult) {
        this.searchResult = searchResult;
    }

    public List<Product> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Product> searchResult) {
        this.searchResult = searchResult;
    }
}
