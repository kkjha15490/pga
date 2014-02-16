package com.pga.eo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ROOM")
@NamedQueries({
@NamedQuery(name = "FIND_ROOM_BY_NAME", query = "SELECT room FROM RoomEO room where room.name = :name"),
@NamedQuery(name = "FIND_ROOM_IN_PG", query = "SELECT room FROM RoomEO room where room.dateDeleted IS NULL"),
@NamedQuery(name = "FIND_RECENT_ROOM", query = "SELECT room FROM RoomEO room where room.dateCreated = :date_Created")
})
public class RoomEO {

	private int roomId;
	private int pgId;
	private String name;
	private Date dateCreated;
	private Date dateDeleted;
	private List<BedEO> bedList;
	private PgEO pg;

	@Id
	// signifies the primary key
	@Column(name = "ROOM_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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

	@Column(name = "DATE_CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name = "DATE_DELETED")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateDeleted() {
		return dateDeleted;
	}

	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}

	@OneToMany(mappedBy = "room", targetEntity = BedEO.class, fetch = FetchType.LAZY)
	public List<BedEO> getBedList() {
		return bedList;
	}

	public void setBedList(List<BedEO> bedList) {
		this.bedList = bedList;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "PG_ID", referencedColumnName = "PG_ID", insertable = false, updatable = false)
	public PgEO getPg() {
		return pg;
	}

	public void setPg(PgEO pg) {
		this.pg = pg;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("RoomEO [roomId=" + roomId)
				.append(", pgId=" + pgId)
				.append(", name=" + name)
				.append(", dateCreated=" + dateCreated)
				.append(", dateDeleted=" + dateDeleted).append("\n");
		if (this.getBedList() != null) {
			int index = 1;
			for (BedEO bed : this.getBedList()) {
				sb.append("BedEO " + index++).append("-\n").append(bed)
						.append("\n");
			}
		}

		return sb.toString();
	}

}
