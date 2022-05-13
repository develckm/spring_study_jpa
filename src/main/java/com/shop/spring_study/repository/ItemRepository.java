package com.shop.spring_study.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shop.spring_study.vo.ItemVo;

public interface ItemRepository extends CrudRepository<ItemVo, Integer>{
	@Query(value = "SELECT item,mem,cate FROM ItemVo item "
			+ "LEFT JOIN MemberVo mem ON item.memberId =mem.id "
			+ "LEFT JOIN CategoryVo cate ON item.cateNum=cate.cateNum")
	
	public Iterable<Object[]> findAllWithCategoryWithMember();
	//ItemVo.member <=사용되지 않는다. 
	//Iteralble<Object[ItemVo,MemberVo,CetegoryVo]>
	
	//sub query Join 이 아니라 진짜 join 을 하고 싶다면 @EntityGraph를 작성해야한다.
	@EntityGraph(attributePaths = {"member","category"})
	public Iterable<ItemVo> findAllByOrderByPostTime(); 
}
