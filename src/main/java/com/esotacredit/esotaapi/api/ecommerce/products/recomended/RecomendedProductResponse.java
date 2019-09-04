package com.esotacredit.esotaapi.api.ecommerce.products.recomended;

import com.esotacredit.esotaapi.api.ecommerce.products.objects.Product;

import java.util.List;

public class RecomendedProductResponse {
    private List<Product> recomendedProducts;

    public RecomendedProductResponse() {}

    public RecomendedProductResponse(RecomendedProductResponseBody recomendedProducts) {
        this.recomendedProducts = recomendedProducts.getProductList();
    }

    public List<Product> getRecomendedProducts() {
        return recomendedProducts;
    }

}
