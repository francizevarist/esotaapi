package com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart;

public class UpdateCartBody {
    private int userId;
    private int productId;
    private int updateQuantity;
    public UpdateCartBody() {}

    public UpdateCartBody(int userId, int productId, int updateQuantity) {
        this.userId = userId;
        this.productId = productId;
        this.updateQuantity = updateQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUpdateQuantity() {
        return updateQuantity;
    }

    public void setUpdateQuantity(int updateQuantity) {
        this.updateQuantity = updateQuantity;
    }
}
