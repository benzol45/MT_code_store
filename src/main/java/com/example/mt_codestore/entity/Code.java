package com.example.mt_codestore.entity;

public class Code {
    private long id;
    private String markCode;
    private String productGTIN;
    private long orderId;
    private String orderUUID;
    private boolean sentForPrint;
    private boolean sentForApply;
    private boolean applied;
    private boolean sale;

    public Code() {
    }

    public Code(long id, String markCode, String productGTIN, long orderId, String orderUUID, boolean sentForPrint, boolean sentForApply, boolean applied, boolean sale) {
        this.id = id;
        this.markCode = markCode;
        this.productGTIN = productGTIN;
        this.orderId = orderId;
        this.orderUUID = orderUUID;
        this.sentForPrint = sentForPrint;
        this.sentForApply = sentForApply;
        this.applied = applied;
        this.sale = sale;
    }

    public Code(String markCode, String productGTIN, long orderId, String orderUUID, boolean sentForPrint, boolean sentForApply, boolean applied, boolean sale) {
        this.markCode = markCode;
        this.productGTIN = productGTIN;
        this.orderId = orderId;
        this.orderUUID = orderUUID;
        this.sentForPrint = sentForPrint;
        this.sentForApply = sentForApply;
        this.applied = applied;
        this.sale = sale;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarkCode() {
        return markCode;
    }

    public void setMarkCode(String markCode) {
        this.markCode = markCode;
    }

    public String getProductGTIN() {
        return productGTIN;
    }

    public void setProductGTIN(String productGTIN) {
        this.productGTIN = productGTIN;
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

    public boolean isSentForPrint() {
        return sentForPrint;
    }

    public void setSentForPrint(boolean sentForPrint) {
        this.sentForPrint = sentForPrint;
    }

    public boolean isSentForApply() {
        return sentForApply;
    }

    public void setSentForApply(boolean sentForApply) {
        this.sentForApply = sentForApply;
    }

    public boolean isApplied() {
        return applied;
    }

    public void setApplied(boolean applied) {
        this.applied = applied;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
