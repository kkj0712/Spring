package com.example.demo5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo5.model.Member;
import com.example.demo5.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService{
	
	private final MemberRepository memberRepository;
	
	public void save(Member member) {
		memberRepository.save(member);
	}
	
	public List<Member> list() {
		return memberRepository.findAll();
	}
	
	public Member detail(Long id) {
		return memberRepository.findById(id)
			.orElseThrow(()->{
				return new IllegalArgumentException("글 상세보기 실패");
			});
	}
	
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
}
