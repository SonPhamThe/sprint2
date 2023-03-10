package com.example.demo.repository.user;

import com.example.demo.model.user.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IUserTypeRepository extends JpaRepository<UserType, Integer> {
}
