package com.vidantu.ecommerce.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_order", schema = "db_ecommerce")
public class OrderEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="delivery_date")
	private Timestamp deliveryDate;
	
	
	@NotEmpty
	@Column(name="created_date")
	@JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss aa")
	@CreatedDate
	private Timestamp createdDate;
	
	@NotEmpty
	@Column(name="last_modified_date")
	@LastModifiedDate
	@JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss aa")
	private Timestamp lastModifiedDate;
	
	@NotEmpty
	@Column(name="created_user_id")
	@CreatedBy
	private Integer createdUserId;
	
	@NotEmpty
	@Column(name="last_modified_user_id")
	@LastModifiedBy
	private Integer lastModifiedUserId;
	
	@Column(name="inventry_id")
	private Long inventryId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderEntity")
	private List<InventryEntity> listOfInventies;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false, insertable = false, updatable = false)
	private AccountEntity accountEntity;
	
	
	
	
	
	
	
	
	

}
