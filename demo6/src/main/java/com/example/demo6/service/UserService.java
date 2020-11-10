package com.example.demo6.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo6.model.StarterUser;
import com.example.demo6.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	@Transactional
	public void save(StarterUser user) {
		userRepository.save(user);
	}
	
	@Transactional
	public String id_Check(String userid) {
		if(userRepository.findByUserid(userid)==0) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	@Transactional
	public Page<StarterUser> list(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	
	@Transactional
	public StarterUser detail(Long unum) {
		return userRepository.findById(unum)
				.orElseThrow(()->{
					return new IllegalArgumentException("회원정보 불러오기 실패");
				});
	}
	
	@Transactional
	public void update(StarterUser user) {
		StarterUser su=userRepository.findById(user.getUnum())
			.orElseThrow(()->{
				return new IllegalArgumentException("업데이트 실패");
			});
		su.setAddr(user.getAddr());
		su.setMemo(user.getMemo());
		su.setName(user.getName());
		su.setPassword(user.getPassword());
	}
	
	@Transactional
	public void delete(Long unum) {
		userRepository.deleteById(unum);
	}
}
