package com.shop.spring_study.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;
// Entity를 설정해야 jpa가 db와 세트로 인지한다.
// Table=member
//id             | varchar(255)
//pw             | varchar(255)
//phone          | varchar(255)
//email          | varchar(255)
//name           | varchar(255)
//address        | varchar(255)
//address_detail | varchar(255)
//signup_time    | datetime
//birth          | date
//grade          | tinyint(4)
@Entity
@Table(name="member")
public class MemberVo {
	@Id
	private String id;          
	private String pw;             
	private String phone;          
	private String email;          
	private String name;           
	private String address;
	@Column(name="address_detail")
	private String addressDetail; 
	@Column(name="signup_time",nullable=true, insertable= false, updatable= false)
	private	Date signupTime;
 // new simepleDateFomat("yyyy-MM-dd").parse("1986-05-24");
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;          
	private byte grade;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id",insertable = false,updatable = false)
	private List <ItemBasketVo> itemBasket; 
	
	@Formula(value = "(SELECT COUNT(b.count) FROM item_basket b WHERE b.member_id=id)")//subquery
	Integer basketCount;
	
	@Formula(value = "(SELECT SUM(b.count) FROM item_basket b WHERE b.member_id=id)")
	Integer basketCountSum;

	
	public Integer getBasketCountSum() {
		return basketCountSum;
	}
	public void setBasketCountSum(Integer basketCountSum) {
		this.basketCountSum = basketCountSum;
	}
	public Integer getBasketCount() {
		return basketCount;
	}
	public void setBasketCount(Integer basketCount) {
		this.basketCount = basketCount;
	}
	public List<ItemBasketVo> getItemBasket() {
		return itemBasket;
	}
	public void setItemBasket(List<ItemBasketVo> itemBasket) {
		this.itemBasket = itemBasket;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public Date getSignupTime() {
		return signupTime;
	}
	public void setSignupTime(Date signupTime) {
		this.signupTime = signupTime;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public byte getGrade() {
		return grade;
	}
	public void setGrade(byte grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pw=" + pw + ", phone=" + phone + ", email=" + email + ", name=" + name
				+ ", address=" + address + ", addressDetail=" + addressDetail + ", signupTime=" + signupTime
				+ ", birth=" + birth + ", grade=" + grade + ", itemBasket=" + itemBasket + ", basketCount="
				+ basketCount + ", basketCountSum=" + basketCountSum + "]";
	}
	
}
