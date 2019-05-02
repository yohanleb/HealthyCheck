package com.yohan.healthycheck.model;

public class APIResponse {
    private String code;
    private String status_verbose;
    private Integer status;
    private Product product;

    public String getCode() {
        return code;
    }

    public String getStatus_verbose() {
        return status_verbose;
    }

    public Integer getStatus() {
        return status;
    }

    public Product getProduct() {
        return product;
    }
}
