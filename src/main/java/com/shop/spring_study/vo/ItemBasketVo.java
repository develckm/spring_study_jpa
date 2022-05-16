package com.shop.spring_study.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 Field      | Type        
-----------+-------------
basket_num | int         
item_num   | int         
member_id  | varchar(255)
count      | int          
 * */
@Entity
@Table(name = "item_basket",
		uniqueConstraints = {@UniqueConstraint(columnNames = {"item_num","member_id"}) })
public class ItemBasketVo {
	@Id
	@Column(name = "basket_num")
	private int basketNum;
	@Column(name = "item_num")
	private int itemNum;
	@Column(name = "member_id")
	private String memberId;
	private int count;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_num",insertable = false, updatable = false)
	private ItemVo item;
	
	public ItemVo getItem() {
		return item;
	}
	public void setItem(ItemVo item) {
		this.item = item;
	}
	public int getBasketNum() {
		return basketNum;
	}
	public void setBasketNum(int basketNum) {
		this.basketNum = basketNum;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ItemBasketVo [basketNum=" + basketNum + ", itemNum=" + itemNum + ", memberId=" + memberId + ", count="
				+ count + ", item=" + item + "]";
	}

}
