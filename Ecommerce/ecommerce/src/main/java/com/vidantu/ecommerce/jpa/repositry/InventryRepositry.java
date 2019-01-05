package com.vidantu.ecommerce.jpa.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vidantu.ecommerce.entity.InventryEntity;

@Repository
public interface InventryRepositry extends JpaRepository<InventryEntity, Long> {

}
