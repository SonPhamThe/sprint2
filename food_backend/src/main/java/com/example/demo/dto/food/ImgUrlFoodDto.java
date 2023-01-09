package com.example.demo.dto.food;

public class ImgUrlFoodDto {
    private Integer id;
    private String url;
    private Integer food;

    public ImgUrlFoodDto() {
    }

    public ImgUrlFoodDto(Integer id, String url, Integer food) {
        this.id = id;
        this.url = url;
        this.food = food;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }
}
