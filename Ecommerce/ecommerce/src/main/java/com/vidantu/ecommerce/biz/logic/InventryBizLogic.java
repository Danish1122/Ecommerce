package com.vidantu.ecommerce.biz.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vidantu.ecommerce.biz.client.IUserConfigurationClient;
import com.vidantu.ecommerce.entity.AccountEntity;
import com.vidantu.ecommerce.entity.InventryEntity;
import com.vidantu.ecommerce.entity.OrderEntity;
import com.vidantu.ecommerce.helper.CommonHelper;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class InventryBizLogic {

	@Autowired
	private IUserConfigurationClient userConfigurationClient;

	@Autowired
	private CommonHelper commonHelper;

	// this will help us to check all the orders
	public AccountEntity checkInventoriesAvailability(AccountEntity accountEntity) {

		List<OrderEntity> outOfStockOrders = new ArrayList<>();
		List<OrderEntity> orderEntityList = accountEntity.getOrderEntities();
		for (OrderEntity orderEntity : orderEntityList) {
			List<InventryEntity> inventryEntitiesList = orderEntity.getListOfInventies();
			for (InventryEntity inventryEntity : inventryEntitiesList) {
				Boolean isAvailble = this.isInventryAvailable(inventryEntity);
				if (!isAvailble) {
					outOfStockOrders.add(orderEntity);
				}
			}
		}
		orderEntityList.removeAll(outOfStockOrders);
		accountEntity.setOrderEntities(orderEntityList);

		return accountEntity;
	}

	// return
	public Boolean isInventryAvailable(InventryEntity inventryEntity) {

		try {
			List<InventryEntity> inventryEntitiesList = userConfigurationClient
					.checkInventryAvailability(inventryEntity);

			if (inventryEntitiesList != null && !inventryEntitiesList.isEmpty() && inventryEntitiesList.size() == 1) {
				InventryEntity newInventryObject = inventryEntitiesList.get(0);
				newInventryObject = commonHelper.updateStockInventry(newInventryObject);
				userConfigurationClient.saveInventryDetails(newInventryObject);
				return true;
			}
		} catch (Exception e) {
			log.error("isInventryAvailable Method Exception Occured!!",e);
		}

		return false;
	}
	
	
	

}
