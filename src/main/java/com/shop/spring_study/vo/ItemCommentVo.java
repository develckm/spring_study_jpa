package com.shop.spring_study.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
Field          | Type         | Null | Key
---------------+--------------+------+----
comment_num    | int          | NO   | PRI
title          | varchar(255) | YES  |    
contents       | varchar(255) | YES  |    
img            | varchar(255) | YES  |    
post_time      | timestamp    | YES  |    
delivery_grade | tinyint      | NO   |    
item_grade     | tinyint      | NO   |    
seller_grade   | tinyint      | NO   |    
item_num       | int          | NO   | MUL
member_id      | varchar(255) | NO   | MUL
state          | tinyint      | NO   |    */
@Entity
@Table(name = "item_comment")
public class ItemCommentVo {
	@Id
	@Column(name = "comment_num")
	private int commentNum;  
	private String title;        
	private String contents;     
	private String img;
	@Column(name = "post_time")
	private Date postTime;
	@Column(name = "delivery_grade")
	private byte deliveryGrad;
	@Column(name = "item_grade")
	private byte itemGrade;   
	@Column(name = "seller_grade")
	private byte sellerGrade; 
	@Column(name = "item_num")
	private int itemNum;     
	@Column(name = "member_id")
	private String memberId;    
	private byte state;
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public byte getDeliveryGrad() {
		return deliveryGrad;
	}
	public void setDeliveryGrad(byte deliveryGrad) {
		this.deliveryGrad = deliveryGrad;
	}
	public byte getItemGrade() {
		return itemGrade;
	}
	public void setItemGrade(byte itemGrade) {
		this.itemGrade = itemGrade;
	}
	public byte getSellerGrade() {
		return sellerGrade;
	}
	public void setSellerGrade(byte sellerGrade) {
		this.sellerGrade = sellerGrade;
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
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ItemCommentVo [commentNum=" + commentNum + ", title=" + title + ", contents=" + contents + ", img="
				+ img + ", postTime=" + postTime + ", deliveryGrad=" + deliveryGrad + ", itemGrade=" + itemGrade
				+ ", sellerGrade=" + sellerGrade + ", itemNum=" + itemNum + ", memberId=" + memberId + ", state="
				+ state + "]";
	}  
	
}
