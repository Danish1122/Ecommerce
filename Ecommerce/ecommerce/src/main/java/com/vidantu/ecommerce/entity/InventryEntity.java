package com.vidantu.ecommerce.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQueries({
		@NamedQuery(name = "checkAvailbityById", query = "FROM InventryEntity ie where ie.inventryId=:inventryId and ie.availability=:availability") })
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_inventry", schema = "db_ecommerce")
public class InventryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventry_id")
	private Long inventryId;

	private String name;

	private Integer stock;

	private Double price;

	private Boolean availability;

	@Column(name = "created_date")
	@JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss aa")
	@CreatedDate
	private Timestamp createdDate;

	@Column(name = "last_modified_date")
	@LastModifiedDate
	@JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss aa")
	private Timestamp lastModifiedDate;

	@Column(name = "created_user_id")
	@CreatedBy
	private Integer createdUserId;

	@Column(name = "last_modified_user_id")
	@LastModifiedBy
	private Integer lastModifiedUserId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "inventry_id", referencedColumnName = "inventry_id", nullable = false, insertable = false, updatable = false)
	private OrderEntity orderEntity;

}
