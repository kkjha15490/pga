package com.pga.main;

import java.util.Calendar;
import java.util.Date;

import com.pga.dao.PgDAO;
import com.pga.ro.AccountRO;
import com.pga.ro.BedPriceHistoryRO;
import com.pga.ro.BedRO;
import com.pga.ro.LogRO;
import com.pga.ro.OccupantHistoryRO;
import com.pga.ro.OccupantRO;
import com.pga.ro.PgRO;
import com.pga.ro.PriceRO;
import com.pga.ro.RoomRO;
import com.pga.ro.UserRO;
import com.pga.service.BedService;
import com.pga.service.OccupantService;
import com.pga.service.PgService;
import com.pga.service.RoomService;

public class PgController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		createPg("s1", "add1");
////		login("sadKLJLKD ", "kamal");
//		createUser(1,"kk","admin" ,"jha");
//		PgDAO.getUserByName(em, "gyan");
//		createLog( "jhsjfhkljf",1, "mannual");
//		getPgByName("s1");
//		getPgById(1);
//		getUserById(1);
//		getLogById(1);
//		getRoomById(1);
//		getPriceById(1);
//		getBedPriceHistoryById(1);
//		getBedById(1);
//		getOccupantById(1);
//		getAccountById(1);
//		getOccupantHistoryById(1);
//		getOccupantByName("kamal");
		getOccupantHistory(2);
//		getOccupantAccountDetails(2);

//		getVaccantBed(2);
		
	}
	
	private static void createPg(String name, String address) {
		PgRO pg = new PgRO(name, address);
		pg = PgService.createPG(pg);
		System.out.println(pg);
	}
//	private static void getPgByName(String name) {
//		PgRO pg = new PgRO(name);
//		pg = PgService.getPgByName(name);
//		System.out.println(pg);
//	}
	private static void getPgById(int pgId) {
		PgRO pg = null;
		pg = PgService.getPgById(pgId);
		System.out.println(pg);
	}
	private static void getUserById(int userId) {
		UserRO user = null;
		user = PgService.getUserById(userId);
		System.out.println(user);
	}
	
	private static void getLogById(int logId) {
		LogRO log = null;
		log = PgService.getLogById(logId);
		System.out.println(log);
	}
	
	private static void getRoomById(int roomId) {
		RoomRO room = null;
		room = RoomService.getRoomById(roomId);
		System.out.println(room);
	}
	
	private static void getPriceById(int priceId) {
		PriceRO price = null;
		price = BedService.getPriceById(priceId);
		System.out.println(price);
	}
	
	private static void getBedPriceHistoryById(int bedPriceHistoryId) {
		BedPriceHistoryRO bedPriceHistory = null;
		bedPriceHistory = BedService.getBedPriceHistoryById(bedPriceHistoryId);
		System.out.println(bedPriceHistory);
	}
	
	private static void getBedById(int bedId) {
		BedRO bed = null;
		bed = BedService.getBedById(bedId);
		System.out.println(bed);
	}
	
	private static void getVaccantBed(int pgId) {
		BedRO bed = null;
		bed = BedService.getVaccantBed(pgId);
		System.out.println(bed);
	}
	
	private static void getOccupantById(int occupantId) {
		OccupantRO occupant = null;
		occupant = OccupantService.getOccupantById(occupantId);
		System.out.println(occupant);
	}
	
	private static void getOccupantByName(String name) {
		OccupantRO occupant = null;
		occupant = OccupantService.getOccupantByName(name);
		System.out.println(occupant);
	}
	private static void getOccupantHistory(int occupantId) {
		OccupantHistoryRO occupantHistory = null;
		occupantHistory = OccupantService.getOccupantHistory(occupantId);
		System.out.println(occupantHistory);
	}
	
//	private static void getVaccantBed(int pgId) {
//		OccupantHistoryRO occupantHistory = null;
//		occupantHistory = OccupantService.getVaccantBed(pgId);
//		System.out.println(occupantHistory);
//	}
	
	private static void getAccountById(int accountId) {
		AccountRO account = null;
		account = OccupantService.getAccountById(accountId);
		System.out.println(account);
	}
	
	private static void getOccupantAccountDetails(int occupantId) {
		AccountRO account = null;
		account = OccupantService.getOccupantAccountDetails(occupantId);
		System.out.println(account);
	}
	
	private static void getOccupantHistoryById(int occupantHistoryId) {
		OccupantHistoryRO occupantHistory = null;
		occupantHistory = OccupantService.getOccupantHistoryById(occupantHistoryId);
		System.out.println(occupantHistory);
	}
	
	private static void createUser(int pgId ,String name, String role, String password) {
		UserRO user = new UserRO(pgId,name,role, password);
		user = PgService.createUser(user);
		System.out.println(user);
	}
	private static void createLog(String log, int pgId, String type, Date dateCreated) {
		LogRO logro = new LogRO(log,pgId,type,dateCreated);
		logro = PgService.createLog(logro);
		System.out.println(logro);
	}
	
	
	
	private static void login(String name , String password){
		UserRO userro = new UserRO();
		userro.setName(name);
		userro.setPassword(password);
		boolean user = PgService.login(userro);
		System.out.println(user);
	}
}
