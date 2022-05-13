package com.shop.spring_study.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
// null 허용으로 해놨기 때문에 sub는 기본형인 int가 아닌 참조형인 Integer를 사용해야함.
public class CategoryVo {
	@Id
	@Column(name="cate_num")
	private int cateNum;
	private String name;
	@Column(insertable = false, updatable = false)
	private Integer sub;
	public int getCateNum() {
		return cateNum;
	}
	public void setCateNum(int cateNum) {
		this.cateNum = cateNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSub() {
		return sub;
	}
	public void setSub(Integer sub) {
		this.sub = sub;
	}
	@Override
	public String toString() {
		return "CategoryVo [cateNum=" + cateNum + ", name=" + name + ", sub=" + sub + "]";
	}

}
