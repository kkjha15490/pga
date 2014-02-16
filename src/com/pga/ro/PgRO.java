package com.pga.ro;

import com.pga.eo.PgEO;

public class PgRO {
	private int pgId;
	private String name;
	private String address;

	public PgRO(PgEO pg) {
		super();
		this.pgId = pg.getPgId();
		this.name = pg.getName();
		this.address = pg.getAddress();
	}

	public PgRO(int pgId, String name, String address) {
		super();
		this.pgId = pgId;
		this.name = name;
		this.address = address;
	}
	
	public PgRO(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	

	public PgEO getEntityObject() {
		PgEO pg = new PgEO();
		pg.setPgId(pgId);
		pg.setName(name);
		pg.setAddress(address);
		return pg;
	}
	public PgRO(){
		
	}

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
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

	@Override
	public String toString() {
		return "PgRO [pgId=" + pgId + ", name=" + name + ", address=" + address
				+ "]";
	}
	
	

}
