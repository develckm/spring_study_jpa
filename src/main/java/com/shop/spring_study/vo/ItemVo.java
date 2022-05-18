package com.shop.spring_study.vo;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

// jpa의 필드를 낙타표기법을 사용해야 메소드로 쿼리를 제작할 수 있다.
@Entity
@Table(name="item")
public class ItemVo {
	@Id
	@Column(name="item_num")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer itemNum;
	 private String name;
	 private String title;
	 private int count;
	 private int price;
	 private String color;
	 @Column(name="main_img")
	 private String mainImg;
	 @Column(name="detail_img")
	 private String detailImg;
	 @Column(name="model_num")
	 private String modelNum;
	 @Column(name="member_id")
	 private String memberId; //(member.member_id)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 @Column(name="post_time", insertable =false,updatable = false)
	 private Date postTime;

	 //'2022-05-19T14:23'
	 @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	 @Column(name="sale_time")
	 private Date saleTime;
	 @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	 @Column(name="sale_end_time")
	 private Date saleEndTime;
	 private byte state;
	 @Column(name="cate_num")
	 private int cateNum; //(category.cate_num)
	 //FetchType.LAZY :1.view에서 사용할 때만 서브쿼리로 조인 ,2@query에서 해당 엔터티를 사용할 때 
	 @OneToOne(fetch = FetchType.LAZY) 
	 @JoinColumn(name="member_id", insertable=false, updatable=false)
	 private MemberVo member;
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="cate_num", insertable=false, updatable=false)
//	 select item.cate_num, category.name from item left join category on item.cate_num=category.cate_num;
	 private CategoryVo category;
	 
	 @OneToMany//fetch = FetchType.LAZY default
	 @JoinColumn(name = "item_num", insertable=false, updatable=false)
	 private List<ItemCommentVo> itemComment;
	 //subquery 작성법
	 @Formula(value = "(SELECT COUNT(c.comment_num) FROM item_comment c WHERE c.item_num=item_num)")
	 private Integer itemCommentCount;
	 
	  
	public Integer getItemCommentCount() {
		return itemCommentCount;
	}
	public void setItemCommentCount(Integer itemCommentCount) {
		this.itemCommentCount = itemCommentCount;
	}
	public List<ItemCommentVo> getItemComment() {
		return itemComment;
	}
	public void setItemComment(List<ItemCommentVo> itemComment) {
		this.itemComment = itemComment;
	}
	public MemberVo getMember() {
		return member;
	}
	public void setMember(MemberVo member) {
		this.member = member;
	}
	public CategoryVo getCategory() {
		return category;
	}
	public void setCategory(CategoryVo category) {
		this.category = category;
	}
	public Integer getItemNum() {
		return itemNum;
	}
	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMainImg() {
		return mainImg;
	}
	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}
	public String getDetailImg() {
		return detailImg;
	}
	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}
	public String getModelNum() {
		return modelNum;
	}
	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public Date getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}
	public Date getSaleEndTime() {
		return saleEndTime;
	}
	public void setSaleEndTime(Date saleEndTime) {
		this.saleEndTime = saleEndTime;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	public int getCateNum() {
		return cateNum;
	}
	public void setCateNum(int cateNum) {
		this.cateNum = cateNum;
	}
	public String toString() {
		return "ItemVo [itemNum=" + itemNum + ", name=" + name + ", title=" + title + ", count=" + count + ", price="
				+ price + ", color=" + color + ", mainImg=" + mainImg + ", detailImg=" + detailImg + ", modelNum="
				+ modelNum + ", memberId=" + memberId + ", postTime=" + postTime + ", saleTime=" + saleTime
				+ ", saleEndTime=" + saleEndTime + ", state=" + state + ", cateNum=" + cateNum + "]";
	}
}
