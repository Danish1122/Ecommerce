package com.vidantu.ecommerce.jpa.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vidantu.ecommerce.entity.AccountEntity;

@Repository
public interface AccountRepositry  extends JpaRepository<AccountEntity, Long>{

}
