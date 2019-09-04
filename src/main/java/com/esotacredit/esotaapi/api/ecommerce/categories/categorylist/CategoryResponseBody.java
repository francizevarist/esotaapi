package com.esotacredit.esotaapi.api.ecommerce.categories.categorylist;

import com.esotacredit.esotaapi.api.ecommerce.categories.object.Category;

import java.util.List;

public class CategoryResponseBody {
    private List<Category> categoryList;

    public CategoryResponseBody() {}

    public CategoryResponseBody(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
