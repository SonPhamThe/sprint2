package com.example.demo.repository.food;

import com.example.demo.repository.model.food.ImgUrlFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IImgFoodRepository extends JpaRepository<ImgUrlFood, Integer> {
    @Query(value = "select * from img_url_food where food_id=:id", nativeQuery = true)
    List<ImgUrlFood> listImgFood(@Param("id") int id);

    @Modifying
    @Query(value = "INSERT INTO img_url_food (url,food_id) VALUES (:url, :food_id)", nativeQuery = true)
    void createImgFood(@Param("url") String url,
                          @Param("food_id") int id);
}
