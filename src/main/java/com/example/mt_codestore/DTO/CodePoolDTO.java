package com.example.mt_codestore.DTO;

import java.util.List;

public class CodePoolDTO {
    private long orderId;
    private String productGTIN;
    private List<String> codes;

    public CodePoolDTO() {
    }

    public CodePoolDTO(long orderId, String productGTIN, List<String> codes) {
        this.orderId = orderId;
        this.productGTIN = productGTIN;
        this.codes = codes;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getProductGTIN() {
        return productGTIN;
    }

    public void setProductGTIN(String productGTIN) {
        this.productGTIN = productGTIN;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }
}
