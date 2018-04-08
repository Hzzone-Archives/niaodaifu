package cn.hzzone.dachuang.model;

import java.util.ArrayList;
import java.util.List;

public class OrderDetail extends Order {
    public void setOrder_items(List<Order_item> order_items) {
        this.order_items = order_items;
    }

    public List<Order_item> getOrder_items() {
        return order_items;
    }

    private List<Order_item> order_items = new ArrayList<>();

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {

        return address;
    }

    public OrderDetail(Order order, List<Order_item> order_items, Address address) {
        this.setOpenId(order.getOpenId());
        this.setOrderId(order.getOrderId());
        this.setOrderTime(order.getOrderTime());
        this.setAddressId(order.getAddressId());
        this.order_items = order_items;
        this.address = address;
        this.order_items = order_items;
        this.address = address;
    }

    private Address address;

}
