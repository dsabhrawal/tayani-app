package com.tayani.app.ui.forms;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tayani.app.dao.OurFirmDao;
import com.tayani.app.entities.OurFirm;
import com.tayani.app.main.TayaniUI;
import com.tayani.app.util.DateUtility;
import com.tayani.app.util.UIConstants;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;

@SpringView(name = OurFirmForm.VIEW_NAME)
public class OurFirmForm extends GridLayout implements View {

	public static final String VIEW_NAME = "our-firm-form";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The logger object
	 */
	private static final Logger logger = LoggerFactory.getLogger(OurFirmForm.class);

	@Autowired
	private OurFirmDao ourFirmDao;

	@Autowired
	private TayaniMenu tayaniMenu;

	private Button save, delete, cancel, newFirm;
	private Grid ourFirmGrid;
	private TextField nameOfFirm, owner;
	private DateField dateOfIncorporation;
	private FormLayout form;
	private HorizontalLayout hForm;
	/**
	 * It is purely used to check whether form is in edit mode or in new data
	 * entry mode
	 */
	private boolean isFormInEditMode;

	private BeanItemContainer<OurFirm> bic;

	@PostConstruct
	public void init() {

		bic = new BeanItemContainer<OurFirm>(OurFirm.class);
		createUIElements();
		buildLayout();

	}

	public void buildLayout() {

		this.setColumns(5);
		this.setRows(7);

		this.addComponent(tayaniMenu, 0, 0, 4, 0);

		this.addComponent(newFirm, 3, 1, 4, 1);
		this.setComponentAlignment(newFirm, Alignment.MIDDLE_CENTER);

		this.addComponent(ourFirmGrid, 0, 1, 2, 6);
		this.addComponent(form, 3, 2, 4, 6);

	}

	public void createUIElements() {

		//tayaniMenu.setWidth(WidthUtil.FULL);

		newFirm = new Button("New Firm");
		newFirm.setIcon(FontAwesome.PLUS);
		newFirm.addClickListener(this::newFirm);
		newFirm.setWidth(UIConstants.WIDTH_FULL);

		ourFirmGrid = new Grid();
		ourFirmGrid.setSelectionMode(SelectionMode.SINGLE);
		ourFirmGrid.addSelectionListener(this::select);

		form = new FormLayout();
		form.setVisible(false);

		nameOfFirm = new TextField("Name of the Firm");
		form.addComponent(nameOfFirm);

		owner = new TextField("Owner");
		form.addComponent(owner);

		dateOfIncorporation = new DateField("Date of Incorporation");
		form.addComponent(dateOfIncorporation);

		hForm = new HorizontalLayout();

		save = new Button("Save");
		save.setIcon(FontAwesome.SAVE);
		save.addClickListener(this::save);
		hForm.addComponent(save);

		cancel = new Button("Cancel");
		cancel.setIcon(FontAwesome.BAN);
		cancel.addClickListener(this::cancel);
		hForm.addComponent(cancel);

		delete = new Button("Delete");
		delete.setIcon(FontAwesome.TRASH);
		delete.addClickListener(this::delete);
		delete.setEnabled(false);
		
		hForm.addComponent(delete);

		form.addComponent(hForm);

		isFormInEditMode = false;

		configureFormElements();

	}

	public void select(SelectionEvent event) {

		// 1: Get the object
		BeanItem<OurFirm> ourFirmItem = bic.getItem(ourFirmGrid.getSelectedRow());
		OurFirm oF = ourFirmItem.getBean();

		// 2: Populate it in the fields
		nameOfFirm.setValue(oF.getOurFirmName());
		owner.setValue(oF.getOwner());
		dateOfIncorporation.setValue(DateUtility.convertLocalDateToUtilDate(oF.getDateOfIncorporation()));

		// 3: Make the fields visible
		form.setVisible(true);
		delete.setEnabled(true);
		isFormInEditMode = true;

	}

	public void delete(Button.ClickEvent event) {

		// 1: Get the object
		BeanItem<OurFirm> ourFirmItem = bic.getItem(ourFirmGrid.getSelectedRow());
		OurFirm oF = ourFirmItem.getBean();

		// 2: Delete it from the dao
		ourFirmDao.removeOurFirm(oF.getId());

		// Refresh the data in grid
		bic.removeAllItems();
		bic.addAll(ourFirmDao.listOurFirms());

		// 3: Clearing all the input fields
		nameOfFirm.clear();
		owner.clear();
		dateOfIncorporation.clear();

	}

	public void save(Button.ClickEvent event) {
		try {

			if (isFormInEditMode) {
				// We are editing old data

				logger.info(isFormInEditMode + "");

				// Get the object
				BeanItem<OurFirm> ourFirmItem = bic.getItem(ourFirmGrid.getSelectedRow());

				// Remove older objects
				bic.removeItem(ourFirmItem);
				ourFirmDao.removeOurFirm(ourFirmItem.getBean().getId());

				// Get the details of new object
				OurFirm newOurFirm = buildOurFirmObject();

				// Commit the fields from UI to DAO
				ourFirmDao.addOurFirm(newOurFirm);

				// Refresh the data in grid
				bic.removeAllItems();
				bic.addAll(ourFirmDao.listOurFirms());

				Notification.show("Saved " + newOurFirm.toString(), Type.TRAY_NOTIFICATION);

				isFormInEditMode = false;
				clearAllFields();

			} else {

				logger.info(isFormInEditMode + "");

				// We are adding new data
				OurFirm newOurFirm = buildOurFirmObject();

				// Commit the fields from UI to DAO
				ourFirmDao.addOurFirm(newOurFirm);

				// Refresh the data in grid
				bic.removeAllItems();
				bic.addAll(ourFirmDao.listOurFirms());

				Notification.show("Saved " + newOurFirm.toString(), Type.TRAY_NOTIFICATION);
				clearAllFields();

			}

		} catch (Exception e) {
			logger.warn("Problem Occured while saving. Details = " + e.getMessage());
			Notification.show("Problem Occured while saving. Details = " + e.getMessage(), Type.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}

	public void newFirm(Button.ClickEvent event) {

		form.setVisible(true);
		delete.setEnabled(false);

	}

	public void cancel(Button.ClickEvent event) {

		clearAllFields();
	
		form.setVisible(false);
		isFormInEditMode = false;

		Notification.show("(Edit/Update/New Addition) Cancelled", Type.TRAY_NOTIFICATION);

	}

	public void clearAllFields() {
		nameOfFirm.clear();
		owner.clear();
		dateOfIncorporation.clear();
	}

	private OurFirm buildOurFirmObject() {

		String nameOfFirmStr = nameOfFirm.getValue();
		String ownerStr = owner.getValue();

		// Step 1: Get the java.util.Date
		Date utilDate = (Date) dateOfIncorporation.getConvertedValue();

		// Step 2: Convert into java.time.LocalDate
		LocalDate dateOfIncorporationDate = DateUtility.convertUtilDateToLocalDate(utilDate);

		OurFirm ourFirm = new OurFirm(nameOfFirmStr, ownerStr, dateOfIncorporationDate);

		logger.debug(ourFirm.toString());

		return ourFirm;
	}

	private void configureFormElements() {

		// Adding Data to our Grid
		bic.addAll(ourFirmDao.listOurFirms());
		ourFirmGrid.setContainerDataSource(bic);

		// ourFirmGrid.setColumnOrder("our_firm_name", "owner",
		// "dateOfIncorporation");
		ourFirmGrid.removeColumn("id");
	}

	@Override
	public TayaniUI getUI() {
		return (TayaniUI) super.getUI();
	}

	/**
	 * @param ourFirmDao
	 *            the ourFirmDao to set
	 */
	public void setOurFirmDao(OurFirmDao ourFirmDao) {
		this.ourFirmDao = ourFirmDao;

	}

	/**
	 * @param tayaniMenu
	 *            the tayaniMenu to set
	 */
	public void setTayaniMenu(TayaniMenu tayaniMenu) {
		this.tayaniMenu = tayaniMenu;
	}

	@Override
	public void enter(ViewChangeEvent event) {

		// TODO Add proper code here

	}

}
