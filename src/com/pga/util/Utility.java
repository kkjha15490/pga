package com.pga.util;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utility {

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pgajpa");
//		System.out.println("factory" +factory);
		EntityManager em = factory.createEntityManager();
//		System.out.println("entity object" +em);
		return em;
	}
	
	public static boolean isNull(String s) {
		if(s == null || s.equals("")) {
			return true;
		}
		return false;
	}
	
	public static Timestamp getTimestampForDeltaDays(int daysAfter) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DAY_OF_MONTH, daysAfter);
		Timestamp date = new Timestamp(calendar.getTimeInMillis());
		return date;
	}
}
