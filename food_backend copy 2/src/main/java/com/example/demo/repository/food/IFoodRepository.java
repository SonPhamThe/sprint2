package com.example.demo.repository.food;

import com.example.demo.repository.model.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IFoodRepository extends JpaRepository<Food, Integer> {
    @Query(value = "select * from food_restaurant.food where food.name Like %:name%", nativeQuery = true, countQuery = "select count(*) from food_restaurant")
    List<Food> showAllFood(@Param("name") String name);
}
