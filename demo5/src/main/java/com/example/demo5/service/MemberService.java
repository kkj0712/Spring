package com.example.demo5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo5.model.Member;
import com.example.demo5.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService{
	
	private final MemberRepository memberRepository;
	
	@Transactional
	public void save(Member member) {
		memberRepository.save(member);
	}
	
	@Transactional
	public Page<Member> list(Pageable pageable) {
		return memberRepository.findAll(pageable);
	}
	
	@Transactional
	public Member detail(Long id) {
		return memberRepository.findById(id)
			.orElseThrow(()->{
				return new IllegalArgumentException("글 상세보기 실패");
			});
	}
	
	//수정
	@Transactional
	public void update(Member member) {
		Member me=memberRepository.findById(member.getId())
				.orElseThrow(()->{
					return new IllegalArgumentException("찾기 실패: 아이디 없음");
				});
		//bean객체의 값을 바꾼다.
		//jpa는 개게를 만들면 영속성 컨텍스트에 들어감. 1차 캐시에 쌓이는 것이지 DB에 바로 처리되는게 아니다. 트랜잭션이 시작해서 commit 명령어가 실행될때 DB에서 처리.
		//원래 jpa에선 강제적으로 flush()라는 명령어를 실행하면 db내용이 바뀜. spring data jpa는 @Transactional이라는 어노테이션을 사용하면 알아서 commit됨.
		//트랜잭션을 어디까지 적용할까? 서비스 단계에서 처리. read권한만 부여해서 컨트롤러에선 read만 가능하게. (OSIV Open Session In View) 
		me.setAddr(member.getAddr());
		me.setName(member.getName());
		me.setEmail(member.getEmail());
		me.setMemo(member.getMemo());
		me.setPassword(member.getPassword());
	}
	
	@Transactional
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
}
