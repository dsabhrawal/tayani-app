package com.tayani.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.tayani.app.entities.OurFirm;

public interface OurFirmDao extends TayaniMasterDao{
	 
	public void addOurFirm(OurFirm ourFirm);

	public void updateOurFirm(OurFirm ourFirm);

	public List<OurFirm> listOurFirms();

	public OurFirm getOurFirmById(int id);

	public void removeOurFirm(int id);
	
	public void setSessionFactory(SessionFactory sf);

	public void removeSessionFactory();
	

}
