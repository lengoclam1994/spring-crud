package com.crud.springcrud.repository;

import com.crud.springcrud.entity.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @EntityGraph(value = "Item.roles")
    Account findByUsername(String username);
}
