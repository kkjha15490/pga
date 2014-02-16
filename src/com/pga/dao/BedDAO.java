package com.pga.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.pga.eo.BedEO;
import com.pga.eo.BedPriceHistoryEO;
import com.pga.eo.OccupantHistoryEO;
import com.pga.eo.PriceEO;
import com.pga.eo.RoomEO;
import com.pga.ro.BedPriceHistoryRO;
import com.pga.ro.BedRO;
import com.pga.ro.OccupantHistoryRO;
import com.pga.ro.PriceRO;
import com.pga.ro.RoomRO;

public class BedDAO {

	public static BedRO createBed(EntityManager em, BedRO bed) {
		BedEO bedeo = bed.getEntityObject();
		em.persist(bedeo);
		bedeo.setBedId(bed.getBedId());
		return bed;
	}

	public static void deleteBed(EntityManager em, int bedId) {
		BedEO bedeo = em.find(BedEO.class, bedId);
		em.remove(bedeo);
	}

	public static BedRO getBedById(EntityManager em, int bedId) {
		BedEO bedeo = em.find(BedEO.class, bedId);
		BedRO bed = null;
		if(bedeo!= null){
			bed = new BedRO(bedeo);
		}
		return bed;
	}
	
	

	public static PriceRO createPrice(EntityManager em, PriceRO price) {
		PriceEO priceeo = price.getEntityObject();
		em.persist(priceeo);
		priceeo.setPriceId(priceeo.getPriceId());
		return price;
	}

	public static void deletePrice(EntityManager em, int priceId) {
		PriceEO priceeo = em.find(PriceEO.class, priceId);
		em.remove(priceeo);
	}

	public static PriceRO getPriceById(EntityManager em, int priceId) {
		PriceEO priceeo = em.find(PriceEO.class, priceId);
		PriceRO price = null;
		if(priceeo!= null){
			price = new PriceRO(priceeo);
		}
		return price;
	}
	
	public static BedRO getBedInPg(EntityManager em) {
		BedRO bed = null;
		TypedQuery<BedEO> query = em.createNamedQuery("FIND_NO_OF_BED",
				BedEO.class);
		List<BedEO> results = query.getResultList();
		if (results != null && results.size() > 0) {
			bed = new BedRO(results.get(0));
			System.out.println(bed);
		}
		return bed;
	}
	
	
	public static BedRO getVaccantBed(EntityManager em, int pgId) {
		BedRO bed = null;
		TypedQuery<BedEO> query = em.createNamedQuery("GET_VACCANT_BED", BedEO.class);
		query.setParameter("pgId", pgId);
		List<BedEO> results = query.getResultList();
		if(results!=null){
		for (BedEO bedeo : results) {
			bed = new BedRO(bedeo);
			}
		}
		return bed;
	}
	public static BedPriceHistoryRO createBedPriceHistory(EntityManager em ,BedPriceHistoryRO bedPriceHistory) {
		BedPriceHistoryEO bedPriceHistoryeo = bedPriceHistory.getEntityObject();
		Calendar cal = Calendar.getInstance();
		bedPriceHistoryeo.setEffectiveFrom(cal.getTime());
		bedPriceHistoryeo.setEffectiveTo(cal.getTime());
		em.persist(bedPriceHistoryeo);
		em.flush();
		return bedPriceHistory;

	}

	public static BedPriceHistoryRO getBedPriceHistoryById(EntityManager em,int bedPriceId) {
		BedPriceHistoryEO bedPriceHistoryeo = em.find(BedPriceHistoryEO.class,bedPriceId);
		 BedPriceHistoryRO bedPriceHistory = null;
		 if(bedPriceHistoryeo!= null){
			 bedPriceHistory = new BedPriceHistoryRO(bedPriceHistoryeo);
		 }
		return bedPriceHistory;
	}

	public static void deleteBedPriceHistory(EntityManager em, int bedPriceId) {
		BedPriceHistoryEO bedPriceHistory = em.find(BedPriceHistoryEO.class,
				bedPriceId);
		em.remove(bedPriceHistory);
	}

}

public static void foo() {
	system.out.println("Hello World");
}

