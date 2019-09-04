package com.esotacredit.esotaapi.api.ecommerce.products.productdetails;

import com.esotacredit.esotaapi.api.ecommerce.products.datamodel.ProductResponseBody;

public class ProductDetailsResponse {
    ProductDetailsResponseBody productDetails;

    public ProductDetailsResponse(ProductDetailsResponseBody productDetails) {
        this.productDetails = productDetails;
    }

    public ProductDetailsResponseBody getProductDetails() {
        return productDetails;
    }
}
