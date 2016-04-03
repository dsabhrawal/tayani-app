package com.tayani.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tayani.app.dao.DieselBuyerDao;
import com.tayani.app.entities.DieselBuyer;


@Repository
@Transactional
public class DieselBuyerDaoImpl implements DieselBuyerDao {

	private static final Logger logger = LoggerFactory.getLogger(DieselBuyerDaoImpl.class);

	private SessionFactory sessionFactory;

	
	@Override
	public void addDieselBuyer(DieselBuyer dieselBuyer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(dieselBuyer);
		logger.info("New Diesel Buyer Saved Successfully. Details = " + dieselBuyer.toString());

	}

	@Override
	public void updateDieselBuyer(DieselBuyer dieselBuyer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(dieselBuyer);
		logger.debug("Diesel Buyer Details update successfully. Details = " + dieselBuyer.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DieselBuyer> listAllDieselBuyers() {
		Session session = this.sessionFactory.getCurrentSession();

		List<DieselBuyer> dieselBuyerList = session.createQuery("from DieselBuyer").list();
		for (DieselBuyer dieselBuyer : dieselBuyerList) {
			logger.debug(dieselBuyer.toString());
		}
		return dieselBuyerList;
	}

	@Override
	public DieselBuyer getDieselBuyerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DieselBuyer dieselBuyer = (DieselBuyer) session.load(DieselBuyer.class, new Integer(id));
		logger.debug("DieselBuyer details received successfully. Details = " + dieselBuyer.toString());
		return dieselBuyer;
	}

	@Override
	public void removeDieselBuyer(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		DieselBuyer dieselBuyer = (DieselBuyer) session.load(DieselBuyer.class, new Integer(id));
		if (null != dieselBuyer) {
			session.delete(dieselBuyer);
			logger.debug("Delete Completed Successfully. Details of deleted Diesel Buyer=" + dieselBuyer.toString());
		} else {
			// TODO: Write error handling code here
		}

	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void removeSessionFactory() {
		// TODO Auto-generated method stub

	}

}
