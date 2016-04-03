package com.tayani.app.dao.mockimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tayani.app.dao.DieselBuyerDao;
import com.tayani.app.entities.DieselBuyer;

public class DieselBuyerDaoMockImpl implements DieselBuyerDao {

	private static final Logger logger = LoggerFactory.getLogger(DieselBuyerDaoMockImpl.class);

	private List<DieselBuyer> dieselBuyerList;

	@Override
	public void addDieselBuyer(DieselBuyer dieselBuyer) {

		logger.debug("Before adding Our earlier list is:");
		printList();

		int size = dieselBuyerList.size();
		dieselBuyer.setId(size);
		dieselBuyerList.add(size++, dieselBuyer);

		logger.debug(" After adding Our new list is:");
		printList();

	}

	/**
	 * Constructor
	 */
	public DieselBuyerDaoMockImpl() {

		dieselBuyerList = new ArrayList<DieselBuyer>(5);

		for (int i = 0; i <= 30; i++) {
			DieselBuyer a1 = new DieselBuyer(i, "DB" + i);
			dieselBuyerList.add(i, a1);
			logger.debug(a1.toString());

		}

	}

	private void printList() {

		logger.debug(dieselBuyerList.toString());
	}

	@Override
	public void updateDieselBuyer(DieselBuyer dieselBuyer) {

		logger.debug("Before updating Our earlier list is:");
		printList();

		// 1: Get index in list
		int index = dieselBuyer.getId();

		// 2: Remove the current object in the list
		DieselBuyer dB = dieselBuyerList.get(index);
		dieselBuyerList.remove(dB);

		// 3: Add new object at same position
		dieselBuyerList.add(index, dieselBuyer);

		logger.debug("After updating Our new list is:");
		printList();

	}

	@Override
	public List<DieselBuyer> listAllDieselBuyers() {
		return dieselBuyerList;
	}

	@Override
	public DieselBuyer getDieselBuyerById(int id) {
		DieselBuyer dB = dieselBuyerList.get(id);
		return dB;
	}

	@Override
	public void removeDieselBuyer(int id) {

		logger.info("Our earlier list is:");
		printList();

		DieselBuyer dB = dieselBuyerList.get(id);
		dieselBuyerList.remove(dB);

		logger.info("Removed " + dB.toString());

		int i = 0;

		for (DieselBuyer dieselBuyer : dieselBuyerList) {
			dieselBuyer.setId(i);
			i++;
		}

		logger.info("Our new list is:");
		printList();

	}

	@Override
	public void setSessionFactory(SessionFactory sf) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSessionFactory() {
		// TODO Auto-generated method stub

	}

}
