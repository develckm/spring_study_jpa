package com.shop.spring_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shop.spring_study.vo.ItemBasketVo;

//@Repository db 객체를 관리하는 컨테이너 
public interface ItemBasketRepository extends JpaRepository<ItemBasketVo, Integer>{

	//SELECT * FROM ITEM_BASKET WHERE member_id=?
	public Iterable<ItemBasketVo> findByMemberId(String memberId);
	
	//unique 값으로 검사하면 오직 1개만 나온다.
	//SELECT * FROM ITEM_BASKET WHERE member_id=? and item_num=?
	public ItemBasketVo findByItemNumAndMemberId(int itemNum,String memberId);
	
	//없으면 0이 아니라 null이 나와서 참조형으로 return 
	public Integer countByMemberId(String memberId);
	
	@Query("SELECT SUM(basket.count) FROM ItemBasketVo basket WHERE basket.memberId=?1")
	public Integer sumCountByMemberId(String memberId);
	
}
