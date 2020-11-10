package com.example.demo6.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
public class StarterBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String title;
	private String content;
	private String writer;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="regdate")
	private Date regdate;
	
	private Long hitcount;
	
	@PrePersist
	public void prePersist() {
		this.hitcount= this.hitcount==null? 0:this.hitcount;
	}
	private String password;
	private Long replycnt;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("board") //누구의 properties인지 적어주고 아니면 @JsonIgnore만 적기
	//fk가 있는 객체를 참조하겠다는 뜻인데 여기에 연결된 board를 무시한다. comment만 select식으로 조회, 참조하겠다. 객체는 테이블의 외래키처럼 자동으로 양방향 관계를 맺지 못함. 
	//이 어노테이션이 없으면 무한반복처럼 에러발생 가능성있음.
	private List<StarterComment> comments;
}
