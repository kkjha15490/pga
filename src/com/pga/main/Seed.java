package com.pga.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pga.dao.OccupantBedDAO;
import com.pga.eo.AccountEO;
import com.pga.eo.BedEO;
import com.pga.eo.BedPriceHistoryEO;
import com.pga.eo.LogEO;
import com.pga.eo.OccupantBedEO;
import com.pga.eo.OccupantEO;
import com.pga.eo.OccupantHistoryEO;
import com.pga.eo.PgEO;
import com.pga.eo.PriceEO;
import com.pga.eo.RoomEO;
import com.pga.eo.UserEO;

public class Seed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pgajpa");
		EntityManager em = factory.createEntityManager();

		try {
			EntityTransaction entr = em.getTransaction();
			entr.begin();
					
			initialize(em);
			
			entr.commit();
		} finally {
			em.close();
			factory.close();
		}
		
		


}
	
	private static void initialize(EntityManager em) {
		PgEO pg = createPg(em, "Srinivas", "Btm 2nd Stage");
		OccupantEO occupant1 = createOccupant(em, "Kamal", 93929929, "IBM", "IIT", "PAN", null, "suncity", "Bangalore", "kk@gmail.com",pg.getPgId());
		OccupantEO occupant2 = createOccupant(em, "Ashu", 93929966, "IBM", "VIT", "Licence", null, "suncity", "Patna", "ashu@gmail.com",pg.getPgId());
		OccupantEO occupant3 = createOccupant(em, "montu", 93929977, "IBM", "VTU", "voter", null, "suncity", "Bangalore", "montu@gmail.com",pg.getPgId());
		OccupantEO occupant4 = createOccupant(em, "tushant", 93929955, "IBM", "IIT", "PAN", null, "suncity", "sarjapur", "tushant@gmail.com",pg.getPgId());
		OccupantEO occupant5 = createOccupant(em, "quershi", 93929944, "IBM", "BPUT", "licence", null, "suncity", "mugalsarai", "quershi@gmail.com",pg.getPgId());
		OccupantEO occupant6 = createOccupant(em, "faizan", 93929933, "IBM", "VTU", "PAN", null, "suncity", "Bangalore", "faizan@gmail.com",pg.getPgId());
		OccupantEO occupant7 = createOccupant(em, "pal", 93929922, "IBM", "VTU", "voter", null, "suncity", "darbhanga", "pal@gmail.com",pg.getPgId());
		OccupantEO occupant8 = createOccupant(em, "ram", 93929911, "IBM", "IIT", "PAN", null, "suncity", "Bangalore", "ram@gmail.com",pg.getPgId());
		UserEO user = createUser(em, pg, "U1", "admin", "u112");
		LogEO log = createLog(em, "jhsjfhkljf", "mannual",pg);
		RoomEO room1 = createRoom(em, "R1", pg);
		RoomEO room2 = createRoom(em, "R2", pg);
		RoomEO room3 = createRoom(em, "R3", pg);
		RoomEO room4 = createRoom(em, "R4", pg);
		BedEO bed1 = createBed(em , pg.getPgId(),room1.getRoomId(),occupant1.getOccupantId());
		BedEO bed2 = createBed(em , pg.getPgId(),room1.getRoomId(),occupant2.getOccupantId());
		BedEO bed3 = createBed(em , pg.getPgId(),room1.getRoomId(),occupant3.getOccupantId());
		BedEO bed4 = createBed(em , pg.getPgId(),room1.getRoomId(),occupant4.getOccupantId());
		BedEO bed5 = createBed(em , pg.getPgId(),room2.getRoomId(),occupant5.getOccupantId());
		BedEO bed6 = createBed(em , pg.getPgId(),room2.getRoomId(),occupant6.getOccupantId());
		BedEO bed7 = createBed(em , pg.getPgId(),room4.getRoomId(),occupant7.getOccupantId());
		BedEO bed8 = createBed(em , pg.getPgId(),room4.getRoomId(),occupant8.getOccupantId());
		List<BedEO> list = new ArrayList<BedEO>();
		list.add(bed1);
		list.add(bed2);
		list.add(bed3);
		list.add(bed4);
		list.add(bed5);
		list.add(bed6);
		list.add(bed7);
		list.add(bed8);
		PriceEO price1 = createPrice(em, 4000, "monthly", pg.getPgId(), list);
		PriceEO price2 = createPrice(em, 250, "daily", pg.getPgId(), list);
		PriceEO price3 = createPrice(em, 1000, "weekly", pg.getPgId(), list);
		BedPriceHistoryEO bedPriceHistory = createBedPriceHistory(em, 1, 1);
		
//		OccupantBedEO occupantBed = createOccupantBed(em, occupant, bed, price.getPriceId());
//		AccountEO account = createAccount(em,  1000, 2000, 6, "j",occupant);
		OccupantHistoryEO history1 = createHistory(em,pg.getPgId(),room1.getRoomId(),bed1.getBedId(), occupant1.getOccupantId());
		OccupantHistoryEO history2 = createHistory(em,pg.getPgId(),room1.getRoomId(),bed2.getBedId(), occupant2.getOccupantId());
		OccupantHistoryEO history3 = createHistory(em,pg.getPgId(),room1.getRoomId(),bed3.getBedId(), occupant3.getOccupantId());
		OccupantHistoryEO history4 = createHistory(em,pg.getPgId(),room1.getRoomId(),bed4.getBedId(), occupant4.getOccupantId());
		OccupantHistoryEO history5 = createHistory(em,pg.getPgId(),room2.getRoomId(),bed5.getBedId(), occupant5.getOccupantId());
		OccupantHistoryEO history6 = createHistory(em,pg.getPgId(),room2.getRoomId(),bed6.getBedId(), occupant6.getOccupantId());
		OccupantHistoryEO history7 = createHistory(em,pg.getPgId(),room4.getRoomId(),bed7.getBedId(), occupant7.getOccupantId());
		OccupantHistoryEO history8 = createHistory(em,pg.getPgId(),room4.getRoomId(),bed8.getBedId(), occupant8.getOccupantId());
		
		
	}
	
	private static PgEO createPg(EntityManager em, String name, String address) {
		PgEO pg = new PgEO();
		pg.setName(name);
		pg.setAddress(address);
		em.persist(pg);
		em.flush();
		return pg;
	}
	
	private static RoomEO createRoom(EntityManager em, String name, PgEO pg) {
		RoomEO room = new RoomEO();
		room.setName(name);
		room.setPgId(1);
		Calendar cal = Calendar.getInstance();
		room.setDateCreated(cal.getTime());
		room.setPgId(pg.getPgId());
		em.persist(room);
		em.flush();
		return room;
	}
	
	private static BedEO createBed(EntityManager em ,int pgId,int roomId,int occupantId ) {
		BedEO bed = new BedEO();
		Calendar cal = Calendar.getInstance();
		bed.setDateCreated(cal.getTime());
		bed.setRoomId(roomId);
		bed.setPgId(pgId);
		bed.setOccupantId(occupantId);
		em.persist(bed);
		em.flush();
		return bed;
	}
	
	private static UserEO createUser(EntityManager em, PgEO pg, String name, String role, String password) {
		UserEO user = new UserEO();
		user.setPgId(pg.getPgId());
		user.setName(name);
		user.setRole(role);
		user.setPassword(password);
		em.persist(user);
		em.flush();
		return user;
	}
	
	private static PriceEO createPrice(EntityManager em, int priceValue, String occurance, 
			int pgId, List<BedEO> bedList) {
		PriceEO price = new PriceEO();
		price.setPrice(priceValue);
		price.setOccurance(occurance);
		price.setBedList(bedList);
		price.setPgId(pgId);
		em.persist(price);
		em.flush();
		return price;
	}
	
	private static BedPriceHistoryEO createBedPriceHistory(EntityManager em , int bedId,int priceId) {
		BedPriceHistoryEO bedPriceHistory = new BedPriceHistoryEO();
		Calendar cal = Calendar.getInstance();
		bedPriceHistory.setEffectiveFrom(cal.getTime());
		bedPriceHistory.setEffectiveTo(cal.getTime());
		bedPriceHistory.setBedId(bedId);
		bedPriceHistory.setPriceId(priceId);
		em.persist(bedPriceHistory);
		em.flush();
		return bedPriceHistory;
		
		
	}
	private static OccupantEO createOccupant(EntityManager em, String name,
			int mobile, String company, String college, String idCard,
			String image, String address, String city, String email,int pgId) {
		OccupantEO occupant = new OccupantEO();
		occupant.setName(name);
		occupant.setMobile(mobile);
		occupant.setCompany(company);
		occupant.setCollege(college);
		occupant.setIdCard(idCard);
		occupant.setImage(image);
		occupant.setAddress(address);
		occupant.setCity(city);
		occupant.setEmail(email);
		occupant.setPgId(pgId);
//		occupant.setOccupantBed(occupantBed);
		em.persist(occupant);
		em.flush();
		return occupant;
	}
	private static OccupantBedEO createOccupantBed(EntityManager em, OccupantEO occupant,BedEO bed,int priceId){
		OccupantBedEO occupantBed = new OccupantBedEO();
		occupantBed.setBedId(bed.getBedId());
		occupantBed.setPriceId(priceId);
		occupantBed.setOccupantId(occupant.getOccupantId());
		occupantBed.setBed(bed);
		occupantBed.setOccupant(occupant);
		em.persist(occupantBed);
		em.flush();
		return occupantBed;
	}

	private static LogEO createLog(EntityManager em, String logTxt, String type, PgEO pg) {
		LogEO log = new LogEO();
		log.setLog(logTxt);
		Calendar cal = Calendar.getInstance();
		log.setDateCreated(cal.getTime());
		log.setType(type);
		log.setPgId(pg.getPgId());
		em.persist(log);
		em.flush();
		return log;
	}
	
	private static AccountEO createAccount(EntityManager em, int dues, int payment,int pgId, String notification, int occupantId) {
		AccountEO account = new AccountEO();
		Calendar cal = Calendar.getInstance();
		account.setFromDate(cal.getTime());
		account.setToDate(cal.getTime());
		account.setPaymentDate(cal.getTime());
		account.setDues(dues);
		account.setPayment(payment);
		account.setNotification(notification);
		account.setOccupantId(occupantId);
		em.persist(account);
		em.flush();
		return account;
	}
	
	private static OccupantHistoryEO createHistory(EntityManager em,int roomId,int bedId,int pgId,int occupantId) {
		OccupantHistoryEO history = new OccupantHistoryEO();
		Calendar cal = Calendar.getInstance();
		history.setEntryDate(cal.getTime());
		history.setBedId(bedId);
		history.setRoomId(roomId);
		history.setPgId(pgId);
		history.setOccupantId(occupantId);
		em.persist(history);
		em.flush();
		return history;
	}
	
}
