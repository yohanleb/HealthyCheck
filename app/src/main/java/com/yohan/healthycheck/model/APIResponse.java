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

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus_verbose(String status_verbose) {
        this.status_verbose = status_verbose;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
