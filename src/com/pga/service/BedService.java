package com.pga.service;

import javax.persistence.EntityManager;

import com.pga.dao.BedDAO;
import com.pga.ro.BedPriceHistoryRO;
import com.pga.ro.BedRO;
import com.pga.ro.PriceRO;
import com.pga.util.Utility;

public class BedService {
	
	public static BedRO createBed(BedRO bed) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bed = BedDAO.createBed(em,bed);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bed;
	}
	
	public static BedRO getBedById(int bedId) {
		EntityManager em = null;
		BedRO bed = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bed = BedDAO.getBedById(em,bedId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bed;
	}
	
	public static BedRO getVaccantBed(int pgId) {
		EntityManager em = null;
		BedRO bed = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bed = BedDAO. getVaccantBed(em,pgId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bed;
	}
	
	public static PriceRO createPrice(PriceRO price) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			price = BedDAO.createPrice(em,price);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return price;
	}
	
	public static PriceRO getPriceById(int  priceId) {
		EntityManager em = null;
		PriceRO price = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			price = BedDAO.getPriceById(em,priceId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return price;
	}
	
	public static BedPriceHistoryRO createBedPriceHistory(BedPriceHistoryRO bedPriceHistory) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bedPriceHistory = BedDAO.createBedPriceHistory(em,bedPriceHistory);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bedPriceHistory;
	}
	
	
	public static BedPriceHistoryRO getBedPriceHistoryById(int bedPriceHistoryId) {
		EntityManager em = null;
		BedPriceHistoryRO bedPriceHistory = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			bedPriceHistory = BedDAO.getBedPriceHistoryById(em,bedPriceHistoryId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return bedPriceHistory;
	}
}
