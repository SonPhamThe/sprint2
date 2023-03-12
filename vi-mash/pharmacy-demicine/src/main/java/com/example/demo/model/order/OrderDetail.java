package com.example.demo.model.order;

import com.example.demo.model.medicine.Medicine;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    private Boolean deleteStatus;

    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders orders;

    public OrderDetail() {
    }

    public OrderDetail(Integer id, Integer quantity, Boolean deleteStatus, Medicine medicine, Orders orders) {
        this.id = id;
        this.quantity = quantity;
        this.deleteStatus = deleteStatus;
        this.medicine = medicine;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
