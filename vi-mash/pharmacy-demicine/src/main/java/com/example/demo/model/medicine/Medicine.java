package com.example.demo.model.medicine;

import com.example.demo.model.order.OrderDetail;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private Double price;

    private String Avatar;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleteStatus;

    @OneToMany(mappedBy = "medicine")
    private Set<ImageMedicine> imageMedicines;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryMedicine categoryMedicine;

    @OneToMany(mappedBy = "medicine")
    private Set<OrderDetail> orderDetails;

    @OneToOne(mappedBy = "medicine")
    private DescribeMedicine describeMedicine;

    @OneToOne(mappedBy = "medicine")
    private InfoMedicine infoMedicine;

    @ManyToOne
    @JoinColumn(name = "trade_mark_id", referencedColumnName = "id")
    private TradeMark tradeMark;

    public Medicine() {
    }

    public Medicine(Integer id, String name, String description, Double price, String avatar, Boolean deleteStatus, Set<ImageMedicine> imageMedicines, CategoryMedicine categoryMedicine, Set<OrderDetail> orderDetails, DescribeMedicine describeMedicine, InfoMedicine infoMedicine, TradeMark tradeMark) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        Avatar = avatar;
        this.deleteStatus = deleteStatus;
        this.imageMedicines = imageMedicines;
        this.categoryMedicine = categoryMedicine;
        this.orderDetails = orderDetails;
        this.describeMedicine = describeMedicine;
        this.infoMedicine = infoMedicine;
        this.tradeMark = tradeMark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<ImageMedicine> getImageMedicines() {
        return imageMedicines;
    }

    public void setImageMedicines(Set<ImageMedicine> imageMedicines) {
        this.imageMedicines = imageMedicines;
    }

    public CategoryMedicine getCategoryMedicine() {
        return categoryMedicine;
    }

    public void setCategoryMedicine(CategoryMedicine categoryMedicine) {
        this.categoryMedicine = categoryMedicine;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public DescribeMedicine getDescribeMedicine() {
        return describeMedicine;
    }

    public void setDescribeMedicine(DescribeMedicine describeMedicine) {
        this.describeMedicine = describeMedicine;
    }

    public InfoMedicine getInfoMedicine() {
        return infoMedicine;
    }

    public void setInfoMedicine(InfoMedicine infoMedicine) {
        this.infoMedicine = infoMedicine;
    }

    public TradeMark getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(TradeMark tradeMark) {
        this.tradeMark = tradeMark;
    }
}
