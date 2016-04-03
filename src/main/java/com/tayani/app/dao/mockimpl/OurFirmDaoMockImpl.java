package com.tayani.app.dao.mockimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tayani.app.dao.OurFirmDao;
import com.tayani.app.entities.OurFirm;

@Repository
@Transactional
public class OurFirmDaoMockImpl implements OurFirmDao {

	private static final Logger logger = LoggerFactory.getLogger(OurFirmDaoMockImpl.class);

	private List<OurFirm> ourFirmList;

	@Override
	public void addOurFirm(OurFirm ourFirm) {

		logger.debug("Before adding Our earlier list is:");
		printList();

		int size = ourFirmList.size();
		ourFirm.setId(size);
		ourFirmList.add(size++, ourFirm);

		logger.debug(" After adding Our new list is:");
		printList();

	}

	@Override
	public void updateOurFirm(OurFirm ourFirm) {

		logger.debug("Before updating Our earlier list is:");
		printList();

		// 1: Get index in list
		int index = ourFirm.getId();

		// 2: Remove the current object in the list
		OurFirm oF = ourFirmList.get(index);
		ourFirmList.remove(oF);

		// 3: Add new object at same position
		ourFirmList.add(index, ourFirm);

		logger.debug("After updating Our new list is:");
		printList();

	}

	@Override
	public List<OurFirm> listOurFirms() {

		return ourFirmList;

	}

	@Override
	public OurFirm getOurFirmById(int id) {

		OurFirm oF = ourFirmList.get(id);
		return oF;
	}

	@Override
	public void removeOurFirm(int id) {

		logger.info("Our earlier list is:");
		printList();

		OurFirm oF = ourFirmList.get(id);
		ourFirmList.remove(oF);
		logger.info("Removed " + oF.toString());

		int i = 0;

		for (OurFirm ourFirm : ourFirmList) {
			ourFirm.setId(i);
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

	/**
	 * Constructor
	 */
	public OurFirmDaoMockImpl() {

		ourFirmList = new ArrayList<OurFirm>(5);

		logger.debug(ourFirmList.size() + "");

		for (int i = 0; i <= 3; i++) {

			OurFirm a1 = new OurFirm("A" + i, "O" + i, LocalDate.now());
			a1.setId(i);
			ourFirmList.add(i, a1);
			logger.debug(a1.toString());

		}

	}

	private void printList() {

		logger.info(ourFirmList.toString());
	}

}
