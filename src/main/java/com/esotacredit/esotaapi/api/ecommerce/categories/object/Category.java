package com.esotacredit.esotaapi.api.ecommerce.categories.object;

import java.util.List;

public class Category {

    private int id;
    private String categoryName;
    private String tagline;
    private String categoryIconUrl;
    private List<CategoryProduct> categoryProductList;

    public Category() {}

    public Category(int id, String categoryName, String tagline, String categoryIconUrl, List<CategoryProduct> categoryProductList) {
        this.id = id;
        this.categoryName = categoryName;
        this.tagline = tagline;
        this.categoryIconUrl = categoryIconUrl;
        this.categoryProductList = categoryProductList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getCategoryIconUrl() {
        return categoryIconUrl;
    }

    public void setCategoryIconUrl(String categoryIconUrl) {
        this.categoryIconUrl = categoryIconUrl;
    }

    public List<CategoryProduct> getCategoryProductList() {
        return categoryProductList;
    }

    public void setCategoryProductList(List<CategoryProduct> categoryProductList) {
        this.categoryProductList = categoryProductList;
    }
}
