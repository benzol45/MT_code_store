package com.example.mt_codestore.DTO;

import java.util.List;

public class CodePoolFromGIS_DTO {
    private long orderId;
    private String orderUUID;
    private String productGTIN;
    private List<String> markCodes;

    public CodePoolFromGIS_DTO() {
    }

    public CodePoolFromGIS_DTO(long orderId, String orderUUID, String productGTIN, List<String> markCodes) {
        this.orderId = orderId;
        this.orderUUID = orderUUID;
        this.productGTIN = productGTIN;
        this.markCodes = markCodes;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderUUID() {
        return orderUUID;
    }

    public void setOrderUUID(String orderUUID) {
        this.orderUUID = orderUUID;
    }

    public String getProductGTIN() {
        return productGTIN;
    }

    public void setProductGTIN(String productGTIN) {
        this.productGTIN = productGTIN;
    }

    public List<String> getMarkCodes() {
        return markCodes;
    }

    public void setMarkCodes(List<String> markCodes) {
        this.markCodes = markCodes;
    }
}
