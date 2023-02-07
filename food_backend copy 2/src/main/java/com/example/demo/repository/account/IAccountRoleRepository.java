package com.example.demo.repository.account;

import com.example.demo.model.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRoleRepository extends JpaRepository<AccountRole, Integer> {
    @Modifying
    @Query(value = " insert into account_role (account_id, role_id) values" +
            " ( :accountRoleId, :roleId ) ", nativeQuery = true)
    void saveAccountRole(@Param("accountRoleId") Integer accountRoleId,
                         @Param("roleId") Integer roleId);
}
