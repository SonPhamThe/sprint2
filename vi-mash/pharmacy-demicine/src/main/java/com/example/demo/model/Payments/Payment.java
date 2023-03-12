package com.example.demo.model.Payments;

import com.example.demo.model.order.Orders;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean shippingDescription;

    private Boolean paymentStatus;

    private Boolean deleteStatus;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    public Payment() {
    }

    public Payment(Integer id, Boolean shippingDescription, Boolean paymentStatus, Boolean deleteStatus, Orders order) {
        this.id = id;
        this.shippingDescription = shippingDescription;
        this.paymentStatus = paymentStatus;
        this.deleteStatus = deleteStatus;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getShippingDescription() {
        return shippingDescription;
    }

    public void setShippingDescription(Boolean shippingDescription) {
        this.shippingDescription = shippingDescription;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
