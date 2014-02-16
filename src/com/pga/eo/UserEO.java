package com.pga.eo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@NamedQueries({
@NamedQuery(name = "FIND_USER_BY_NAME", query = "SELECT user FROM UserEO user where user.name = :name"),
@NamedQuery(name = "FIND_USER_BY_ROLE", query = "SELECT user FROM UserEO user where user.role = :role")
})
public class UserEO {
	
    private int userId;
    private int pgId;
	private String name;
	private String role;
	private String password;
	private PgEO pg;
	
	@Id //signifies the primary key
    @Column(name = "USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "PG_ID")
	public int getPgId() {
		return pgId;
	}
	public void setPgId(int pgId) {
		this.pgId = pgId;
	}
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "ROLE")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne(optional=false)
	@JoinColumn(name="PG_ID",referencedColumnName="PG_ID", insertable=false, updatable=false)
	public PgEO getPg() {
		return pg;
	}
	public void setPg(PgEO pg) {
		this.pg = pg;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("UserEO [userId=" + userId).append( ", pgId=" + pgId).append(", name=" + name)
				.append(", role=" + role).append( ", password=" + password  + "]").append("\n");
	return sb.toString();
	}
	
    
	
    

}
