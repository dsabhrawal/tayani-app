package com.tayani.app.dao;

import java.util.List;
import org.hibernate.SessionFactory;

import com.tayani.app.entities.DieselBuyer;

public interface DieselBuyerDao extends TayaniMasterDao{
	 
	public void addDieselBuyer(DieselBuyer dieselBuyer);

	public void updateDieselBuyer(DieselBuyer dieselBuyer);

	public List<DieselBuyer> listAllDieselBuyers();

	public DieselBuyer getDieselBuyerById(int id);

	public void removeDieselBuyer(int id);
	
	public void setSessionFactory(SessionFactory sf);

	public void removeSessionFactory();
	

}
