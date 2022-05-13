package com.shop.spring_study.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shop.spring_study.vo.MemberVo;

// CrudRepository를 상속하는 인터페이스를 생성해야 JAP가 query를 작성할 수 있다.
public interface MemberRepository extends CrudRepository<MemberVo, String>{
//	함수명이 질의로 작성가능
//	return type이 Collection이면 복수의 select 
	public List<MemberVo> findAllByOrderByIdAsc();
	public MemberVo findByIdAndPw(String id, String pw);
//	nativeQuery 비권장(JPQL로 할 수 없을때, 특정db에만 동작한다)
//	@Query(value = "select * from member where email=?1", nativeQuery=true)
//	public Optional<MemberVo> selectJPQLBEmail(String email);

//	Jpal은 vo entity를 이용해서 쿼리를 작성한다.(db 마다 쿼리 생성)
//	@Query(value = "select mem from MemberVo mem where mem.email=:email")
//	public Optional<MemberVo> selectJPQLBEmail(@Param(value="email") String email);
	
	public Optional<MemberVo> findByEmail(String email);	
	public Optional<MemberVo> findByPhone(String phone); // 받아오는 객체를 형변환을 바로해준다.
}
