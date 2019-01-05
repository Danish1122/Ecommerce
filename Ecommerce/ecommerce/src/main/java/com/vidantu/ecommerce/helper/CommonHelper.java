package com.vidantu.ecommerce.helper;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.vidantu.ecommerce.entity.InventryEntity;

@Component
public class CommonHelper {

	public InventryEntity setInventryObject(InventryEntity inventryEntity) {

		Timestamp createdDate = new Timestamp(System.currentTimeMillis());
		inventryEntity.setCreatedDate(createdDate);
		inventryEntity.setLastModifiedDate(createdDate);
		inventryEntity.setCreatedUserId(1);
		inventryEntity.setLastModifiedUserId(1);
		return inventryEntity;
	}

	public InventryEntity updateStockInventry(InventryEntity inventryEntity) {

		Timestamp createdDate = new Timestamp(System.currentTimeMillis());

		if (inventryEntity.getStock() == 1) {
			inventryEntity.setStock(0);
			inventryEntity.setAvailability(false);
		} else {
			int lastStock = inventryEntity.getStock();
			inventryEntity.setStock(lastStock - 1);
			inventryEntity.setAvailability(true);
		}
		inventryEntity.setCreatedDate(createdDate);
		inventryEntity.setLastModifiedDate(createdDate);
		inventryEntity.setCreatedUserId(1);
		inventryEntity.setLastModifiedUserId(1);
		return inventryEntity;
	}
}
