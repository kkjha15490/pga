package com.pga.service;

import javax.persistence.EntityManager;

import com.pga.dao.RoomDAO;
import com.pga.ro.RoomRO;
import com.pga.util.Utility;

public class RoomService {
	
	public static RoomRO createRoom(RoomRO room) {
		EntityManager em = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			room = RoomDAO.createRoom(em,room);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return room;
	}
	
	public static RoomRO getRoomById(int roomId) {
		EntityManager em = null;
		RoomRO room = null;
		try {
			em = Utility.getEntityManager();
			em.getTransaction().begin();
			room = RoomDAO.getRoomById(em,roomId);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return room;
	}


}
