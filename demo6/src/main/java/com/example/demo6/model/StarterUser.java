package com.example.demo6.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class StarterUser {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long unum;
	private String userid;
	private String password;
	private String name;
	private String addr;
	private String memo;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reg_date")
	private Date reg_date;
}
