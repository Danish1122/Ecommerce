package com.vidantu.ecommerce.biz.client.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vidantu.ecommerce.biz.client.IUserConfigurationClient;
import com.vidantu.ecommerce.biz.logic.InventryBizLogic;
import com.vidantu.ecommerce.entity.AccountEntity;
import com.vidantu.ecommerce.entity.InventryEntity;
import com.vidantu.ecommerce.entity.OrderEntity;
import com.vidantu.ecommerce.exceptions.DatabaseException;
import com.vidantu.ecommerce.exceptions.UserConfigurationClientException;
import com.vidantu.ecommerce.exceptions.UserConfigurationException;
import com.vidantu.ecommerce.helper.CommonHelper;
import com.vidantu.ecommerce.jpa.repositry.AccountRepositry;
import com.vidantu.ecommerce.jpa.repositry.InventryRepositry;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class UserConfigurationClientImpl implements IUserConfigurationClient {

	@Autowired(required = true)
	@Setter
	private SessionFactory sessionFactory;

	@Autowired
	private InventryRepositry inventryRepositry;

	@Autowired
	private InventryBizLogic inventryBizLogic;

	@Autowired
	private AccountRepositry accountRepositry;

	@Autowired
	private CommonHelper commonHelper;

	@Override
	public void processAllOrders(AccountEntity accountEntity)
			throws DatabaseException, UserConfigurationClientException, UserConfigurationException {

		try {

			accountEntity = inventryBizLogic.checkInventoriesAvailability(accountEntity);
			if (accountEntity.getOrderEntities() != null && !accountEntity.getOrderEntities().isEmpty())
				accountRepositry.save(accountEntity);

		} catch (Exception e) {

			log.info("processAllOrders", e);
		}

	}

	@Override
	public void saveInventryDetails(InventryEntity inventryEntity)
			throws DatabaseException, UserConfigurationClientException, UserConfigurationException {

		try {
			InventryEntity newInventryEntity = commonHelper.setInventryObject(inventryEntity);
			inventryRepositry.save(newInventryEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<InventryEntity> checkInventryAvailability(InventryEntity inventryEntity)
			throws DatabaseException, UserConfigurationClientException, UserConfigurationException {

		try (Session session = sessionFactory.openSession()) {
			@SuppressWarnings("rawtypes")
			TypedQuery query = session.getNamedQuery("findEmployeeByName");
			query.setParameter("inventryId", inventryEntity.getInventryId());
			query.setParameter("availability", inventryEntity.getAvailability());

			@SuppressWarnings("unchecked")
			List<InventryEntity> inventryEntitiesList = query.getResultList();
			return inventryEntitiesList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
