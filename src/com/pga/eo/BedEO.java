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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BED")
@NamedQueries({
	    @NamedQuery(name = "GET_VACCANT_BED", query = "SELECT b FROM BedEO b where b.pgId = :pgId AND b.occupantId IS NULL AND b.dateDeleted IS NULL"),
		@NamedQuery(name = "FIND_NO_OF_BED", query = "SELECT bed FROM BedEO bed where bed.dateDeleted IS NULL"),
		@NamedQuery(name = "FIND_BED_BY_PRICE", query = "SELECT bed FROM BedEO bed where bed.priceList > :price_List") })
public class BedEO {

	private int bedId;
	private int pgId;
	private int occupantId;
	private int roomId;
	private Date dateCreated;
	private Date dateDeleted;
	private RoomEO room;
	private OccupantBedEO occupantBed;
	private List<PriceEO> priceList;

	@ManyToMany(mappedBy = "bedList", fetch = FetchType.LAZY)
	public List<PriceEO> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<PriceEO> priceList) {
		this.priceList = priceList;
	}

	@Id
	// signifies the primary key
	@Column(name = "BED_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getBedId() {
		return bedId;
	}

	public void setBedId(int bedId) {
		this.bedId = bedId;
	}

	@Column(name = "OCCUPANT_ID")
	public int getOccupantId() {
		return occupantId;
	}

	public void setOccupantId(int occupantId) {
		this.occupantId = occupantId;
	}

	@Column(name = "PG_ID")
	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	@Column(name = "ROOM_ID")
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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

	@ManyToOne(optional = false)
	@JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID", insertable = false, updatable = false)
	public RoomEO getRoom() {
		return room;
	}

	public void setRoom(RoomEO room) {
		this.room = room;
	}
	
	@OneToOne(mappedBy = "bed", targetEntity = OccupantBedEO.class, fetch = FetchType.EAGER)
	public OccupantBedEO getOccupantBed() {
		return occupantBed;
	}

	public void setOccupantBed(OccupantBedEO occupantBed) {
		this.occupantBed = occupantBed;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BedEO [bedId=" + bedId).append(",pgId=" + pgId)
				.append(", occupantId=" + occupantId)
				.append(", roomId=" + roomId)
				.append(", dateCreated=" + dateCreated)
				.append(", dateDeleted=" + dateDeleted).append("\n");
		if (this.getPriceList() != null) {
			int index = 1;
			for (PriceEO price : this.getPriceList()) {
				sb.append("PRICELIST " + index++).append("-\n").append(price)
						.append("\n");
			}
		}

		return sb.toString();
	}

}
