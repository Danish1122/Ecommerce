package com.vidantu.ecommerce.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidantu.ecommerce.biz.client.IUserConfigurationClient;
import com.vidantu.ecommerce.constants.WebContants;
import com.vidantu.ecommerce.entity.AccountEntity;
import com.vidantu.ecommerce.entity.InventryEntity;

@RestController
@RequestMapping("/user/v1")
public class UserConfigurationController {

	@Autowired
	private IUserConfigurationClient userConfigurationClient;

	@PostMapping(value = "/inventry/info", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveInventryDetails(@RequestBody InventryEntity inventryEntity, HttpServletResponse servletResponse) {
		int httpStatus = HttpStatus.OK.value();
		try {
			
			
			userConfigurationClient.saveInventryDetails(inventryEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@PostMapping(value = WebContants.SAVE_ORDER_DETAILS, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveOrderDetails(@RequestBody AccountEntity accountEntity, HttpServletResponse servletResponse) {
		int httpStatus = HttpStatus.OK.value();
		try {

			userConfigurationClient.processAllOrders(accountEntity);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
