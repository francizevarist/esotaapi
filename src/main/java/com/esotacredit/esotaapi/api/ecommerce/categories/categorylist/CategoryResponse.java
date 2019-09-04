package com.esotacredit.esotaapi.api.ecommerce.categories.categorylist;

import com.esotacredit.esotaapi.api.ecommerce.categories.object.Category;

import java.util.List;

public class CategoryResponse {
    private List<Category> categories;

    public CategoryResponse() {}

    public CategoryResponse(CategoryResponseBody categories) {
        this.categories = categories.getCategoryList();
    }

    public List<Category> getCategories() {
        return categories;
    }
}
