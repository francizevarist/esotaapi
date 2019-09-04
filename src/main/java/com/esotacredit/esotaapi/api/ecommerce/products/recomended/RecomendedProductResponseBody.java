package com.esotacredit.esotaapi.api.ecommerce.products.recomended;

import com.esotacredit.esotaapi.api.ecommerce.products.objects.Product;

import java.util.List;

public class RecomendedProductResponseBody {
    private List<Product> productList;

    public RecomendedProductResponseBody(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
