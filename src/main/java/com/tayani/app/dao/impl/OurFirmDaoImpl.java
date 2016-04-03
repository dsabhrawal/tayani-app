package com.tayani.app.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tayani.app.dao.OurFirmDao;
import com.tayani.app.entities.OurFirm;

@Repository
@Transactional
public class OurFirmDaoImpl implements OurFirmDao {

	private static final Logger logger = LoggerFactory.getLogger(OurFirmDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addOurFirm(OurFirm ourFirm) {

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(ourFirm);
		logger.info("New Firm Saved Successfully. Details = " + ourFirm.toString());

	}

	@Override
	public void updateOurFirm(OurFirm ourFirm) {

		Session session = this.sessionFactory.getCurrentSession();
		session.update(ourFirm);
		logger.info("Existing Our Firm saved successfully. Details = " + ourFirm.toString());

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OurFirm> listOurFirms() {

		Session session = this.sessionFactory.getCurrentSession();

		List<OurFirm> ourFirmList = session.createQuery("from OurFirm").list();
		for (OurFirm ourFirm : ourFirmList) {
			logger.info(ourFirm.toString());
		}
		return ourFirmList;

	}

	@Override
	public OurFirm getOurFirmById(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		OurFirm ourFirm = (OurFirm) session.load(OurFirm.class, new Integer(id));
		logger.info("Our firm loaded successfully. Details = " + ourFirm.toString());
		return ourFirm;

	}

	@Override
	public void removeOurFirm(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		OurFirm ourFirm = (OurFirm) session.load(OurFirm.class, new Integer(id));
		if (null != ourFirm) {
			session.delete(ourFirm);
			logger.info("Delete Successfully. Details =" + ourFirm.toString());
		}else {
			// TODO: Write error handling code here
		}
		
	}

	@Override
	public void removeSessionFactory() {
		// TODO Auto-generated method stub
		
	}

}
