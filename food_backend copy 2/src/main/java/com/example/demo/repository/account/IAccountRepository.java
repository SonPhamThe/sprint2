package com.example.demo.repository.account;

import com.example.demo.repository.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query(
            value = " select account.id, " +
                    "   account.password, " +
                    "   account.username, " +
                    "   account.enabled" +
                    " from account where username = :username ",
            nativeQuery = true
    )
    Account findAccountByUsername(@Param("username") String username);
}
