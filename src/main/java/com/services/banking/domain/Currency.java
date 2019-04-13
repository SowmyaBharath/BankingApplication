package com.services.banking.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Currency implements Serializable{
	
	@Id
	@GeneratedValue
	private Long currencyId;
	
	@Column(name = "CURRENCY_CODE",length = 3)
	private String currencyCode;
		

}
