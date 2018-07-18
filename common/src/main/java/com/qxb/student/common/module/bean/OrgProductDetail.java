package com.qxb.student.common.module.bean;

public class OrgProductDetail{
  private int owner_id;
  private String title;
  private String name;
  private String summary;
  private String logo;
  private String address;
  private String content;
  private String publish_time;
  private int is_regist;
  private String share_url;

  public int getOwner_id() {
    return this.owner_id;
  }

  public void setOwner_id(int owner_id) {
    this.owner_id = owner_id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSummary() {
    return this.summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getIs_regist() {
    return this.is_regist;
  }

  public void setIs_regist(int is_regist) {
    this.is_regist = is_regist;
  }

  public String getLogo() {
    return this.logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public String getShare_url() {
    return share_url;
  }

  public String getTitle() {
	return title;
  }
	
  public void setTitle(String title) {
	this.title = title;
  }

	public String getPublish_time() {
		return publish_time;
	}
	
	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}
}