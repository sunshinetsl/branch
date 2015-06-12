package com.dragon.entity;

// Generated 2015-6-4 14:41:35 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TUserInfo generated by hbm2java
 */
@Entity
@Table(name = "t_user_info", catalog = "dragon")
public class UserInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8365465661959402850L;
	private Integer id;
	private String nickName;
	private String email;
	private String mobile;
	private String passWord;
	private String account;
	private String cardType;
	private String cardNo;
	private String sex;
	private String statusCode;
	private Date createTime;
	private Date updateTime;
	private String headPortraitNormal;
	private String headPortraitThumb;

	public UserInfo() {
	}

	public UserInfo(String nickName, String email, String mobile,
			String passWord, String account, String cardType, String cardNo,
			String sex, String statusCode, Date createTime, Date updateTime,
			String headPortraitNormal, String headPortraitThumb) {
		this.nickName = nickName;
		this.email = email;
		this.mobile = mobile;
		this.passWord = passWord;
		this.account = account;
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.sex = sex;
		this.statusCode = statusCode;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.headPortraitNormal = headPortraitNormal;
		this.headPortraitThumb = headPortraitThumb;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "nick_name", length = 45)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobile", length = 45)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "pass_word", length = 45)
	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "account", length = 45)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "card_type", length = 45)
	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Column(name = "card_no", length = 45)
	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Column(name = "sex", length = 45)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "status_code", length = 45)
	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "update_time", length = 10)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "head_portrait_normal", length = 45)
	public String getHeadPortraitNormal() {
		return this.headPortraitNormal;
	}

	public void setHeadPortraitNormal(String headPortraitNormal) {
		this.headPortraitNormal = headPortraitNormal;
	}

	@Column(name = "head_portrait_thumb", length = 45)
	public String getHeadPortraitThumb() {
		return this.headPortraitThumb;
	}

	public void setHeadPortraitThumb(String headPortraitThumb) {
		this.headPortraitThumb = headPortraitThumb;
	}

}
