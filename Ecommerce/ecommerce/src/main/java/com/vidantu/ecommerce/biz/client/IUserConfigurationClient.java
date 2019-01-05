package com.vidantu.ecommerce.biz.client;

import java.util.List;

import com.vidantu.ecommerce.entity.AccountEntity;
import com.vidantu.ecommerce.entity.InventryEntity;
import com.vidantu.ecommerce.exceptions.DatabaseException;
import com.vidantu.ecommerce.exceptions.UserConfigurationClientException;
import com.vidantu.ecommerce.exceptions.UserConfigurationException;

public interface IUserConfigurationClient {
	
	
	void processAllOrders(AccountEntity accountEntity) throws DatabaseException,UserConfigurationClientException,UserConfigurationException;
	
	
	void saveInventryDetails(InventryEntity inventryEntity) throws DatabaseException,UserConfigurationClientException,UserConfigurationException;
	
	
	List<InventryEntity> checkInventryAvailability(InventryEntity inventryEntity) throws DatabaseException,UserConfigurationClientException,UserConfigurationException;
	
}
