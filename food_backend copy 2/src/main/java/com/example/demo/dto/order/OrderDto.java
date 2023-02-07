package com.example.demo.dto.order;

public class OrderDto {
    private int idFood;
    private int idUser;
    private int quantity;

    public OrderDto() {
    }

    public OrderDto(int idFood, int idUser, int quantity) {
        this.idFood = idFood;
        this.idUser = idUser;
        this.quantity = quantity;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
