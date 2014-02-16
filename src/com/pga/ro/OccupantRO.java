package com.pga.ro;

import com.pga.eo.OccupantEO;

public class OccupantRO {

	private int occupantId;
	private int bedId;
	private String name;
	private long mobile;
	private String company;
	private String college;
	private String idCard;
	private long idNum;
	private String image;
	private String address;
	private String city;
	private String email;

	public OccupantRO(OccupantEO occupant) {
		super();
		this.occupantId = occupant.getOccupantId();
//		this.bedId = occupant.getBedId();
		this.name = occupant.getName();
		this.mobile = occupant.getMobile();
		this.company = occupant.getCompany();
		this.college = occupant.getCollege();
		this.idCard = occupant.getIdCard();
		this.image = occupant.getImage();
		this.address = occupant.getAddress();
		this.city = occupant.getCity();
	}

	public OccupantRO(int occupantId, int bedId, String name, int mobile,
			String company, String college, String idCard, String image,
			String address, String city) {
		super();
		this.occupantId = occupantId;
		this.bedId = bedId;
		this.name = name;
		this.mobile = mobile;
		this.company = company;
		this.college = college;
		this.idCard = idCard;
		this.image = image;
		this.address = address;
		this.city = city;
	}
	
	public OccupantRO( int bedId, String name, int mobile,
			String company, String college, String idCard, String image,
			String address, String city) {
		super();
		this.bedId = bedId;
		this.name = name;
		this.mobile = mobile;
		this.company = company;
		this.college = college;
		this.idCard = idCard;
		this.image = image;
		this.address = address;
		this.city = city;
	}

	public OccupantEO getEntityObject() {
		OccupantEO occupant = new OccupantEO();
		occupant.setOccupantId(occupantId);
//		occupant.setBedId(bedId);
		occupant.setName(name);
		occupant.setMobile(mobile);
		occupant.setCompany(company);
		occupant.setCollege(college);
		occupant.setIdCard(idCard);
		occupant.setImage(image);
		occupant.setAddress(address);
		occupant.setCity(city);
		return occupant;
	}

	public int getOccupantId() {
		return occupantId;
	}

	public void setOccupantId(int occupantId) {
		this.occupantId = occupantId;
	}

	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public long getIdNum() {
		return idNum;
	}

	public void setIdNum(long idNum) {
		this.idNum = idNum;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "OccupantRO [occupantId=" + occupantId + ", bedId=" + bedId
				+ ", name=" + name + ", mobile=" + mobile + ", company="
				+ company + ", college=" + college + ", idCard=" + idCard
				+ ", image=" + image + ", address=" + address + ", city="
				+ city + "]";
	}
	
	

	
}
