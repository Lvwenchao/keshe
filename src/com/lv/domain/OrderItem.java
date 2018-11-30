package com.lv.domain;

/**
 * @author:
 * @data: 2018/11/19 13:02
 * @description:
 * @Version: 1.0
 **/
public class OrderItem {
    private Order order;
    private Product p;
    private int buynum;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }
}
