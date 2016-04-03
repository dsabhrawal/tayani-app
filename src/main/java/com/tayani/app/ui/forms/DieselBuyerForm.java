package com.tayani.app.ui.forms;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tayani.app.dao.DieselBuyerDao;
import com.tayani.app.entities.DieselBuyer;
import com.tayani.app.util.StringUtility;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;

@SpringView(name = DieselBuyerForm.VIEW_NAME)
public class DieselBuyerForm extends GridLayout implements View {

	public static final String VIEW_NAME = "diesel-buyer-form";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The logger object
	 */
	private static final Logger logger = LoggerFactory.getLogger(DieselBuyerForm.class);

	@Autowired
	private TayaniMenu tayaniMenu;

	@Autowired
	private DieselBuyerDao dieselBuyerDao;

	private Grid dieselBuyerGrid;
	private OptionGroup formModeGroup;
	private TextField id, name;
	private HorizontalLayout textLayout, buttonLayout;
	private Button save, cancel, delete;

	private int formMode, viewMode = 1, editMode = 2, addMode = 3;

	private BeanItemContainer<DieselBuyer> bic;

	@PostConstruct
	public void init() {

		bic = new BeanItemContainer<DieselBuyer>(DieselBuyer.class);
		createUIElements();
		buildLayout();

		// Initially Form should be in "View" Mode
		formMode = viewMode;
		prepareForm(formMode);

	}

	public void createUIElements() {

		// A single-select radio button group
		formModeGroup = new OptionGroup("Action to perform");

		// Pass item ids to be used in constructing Item objects on our behalf.
		formModeGroup.addItems(viewMode, editMode, addMode);

		// Specify a textual label
		formModeGroup.setItemCaption(viewMode, "View List of Diesel Buyers");
		formModeGroup.setItemCaption(editMode, "Edit Existing Diesel Buyer");
		formModeGroup.setItemCaption(addMode, "Add New Diesel Buyer");
	 
		// Specify which radio button is selected by default.
		formModeGroup.setValue(viewMode);

		// If multi-select mode is true then it becomes a check box
		formModeGroup.setMultiSelect(false);
		formModeGroup.addValueChangeListener(this::determineFormMode);
		formModeGroup.addStyleName("horizontal");

		id = new TextField("Id");
		// this component will always remain disabled, because we don't want
		// users to change it
		id.setEnabled(false);

		name = new TextField("Name");

		// Adding text fields to HLayout
		textLayout = new HorizontalLayout();
		textLayout.addComponent(id);
		textLayout.addComponent(name);
		textLayout.setEnabled(false);

		cancel = new Button("Cancel");
		cancel.setIcon(FontAwesome.BAN);
		cancel.addClickListener(this::cancel);

		delete = new Button("Delete");
		delete.setIcon(FontAwesome.TRASH);
		delete.addClickListener(this::delete);
		delete.setEnabled(false);

		save = new Button("Save");
		save.setIcon(FontAwesome.SAVE);
		save.addClickListener(this::save);

		// Adding buttons to HLayout
		buttonLayout = new HorizontalLayout();
		buttonLayout.addComponent(cancel);
		buttonLayout.addComponent(delete);
		buttonLayout.addComponent(save);

		dieselBuyerGrid = new Grid();
		dieselBuyerGrid.addSelectionListener(this::select);

		// Adding Data to our Grid
		bic.addAll(dieselBuyerDao.listAllDieselBuyers());
		dieselBuyerGrid.setContainerDataSource(bic);

	}

	/**
	 * This method will set proper UI elements at proper place in the grid
	 */
	public void buildLayout() {

		this.setColumns(2);
		this.setRows(6);

		this.addComponent(tayaniMenu, 0, 0, 1, 0);

		this.addComponent(formModeGroup, 0, 1, 1, 1);

		this.addComponent(textLayout, 0, 2, 1, 3);
		this.addComponent(buttonLayout, 0, 4, 1, 4);

		this.addComponent(dieselBuyerGrid, 0, 5, 1, 5);

	}

	private void select(SelectionEvent event) {

		// 1: Get the object BeanItem<OurFirm> ourFirmItem =

		BeanItem<DieselBuyer> dieselBuyerItem = bic.getItem(dieselBuyerGrid.getSelectedRow());
		DieselBuyer dB = dieselBuyerItem.getBean();

		// 2: Populate it in the fields
		id.setValue(dB.getId() + StringUtility.emptyString);
		name.setValue(dB.getName());

	}

	private void determineFormMode(Property.ValueChangeEvent event) {

		formMode = (int) event.getProperty().getValue();
		prepareForm(formMode);

	}

	private void prepareForm(int formMode) {

		logger.debug("Form mode = " + formMode);

		switch (formMode) {
		case 1: // Form is in view data mode
			dieselBuyerGrid.setSelectionMode(SelectionMode.NONE);
			textLayout.setEnabled(false);
			delete.setEnabled(false);
			save.setEnabled(false);
			cancel.setEnabled(false);
			id.setInputPrompt(StringUtility.emptyString);
			break;

		case 2: // Form is in edit existing data mode

			textLayout.setEnabled(true);
			delete.setEnabled(true);
			save.setEnabled(true);
			cancel.setEnabled(false);
			dieselBuyerGrid.setSelectionMode(SelectionMode.SINGLE);
			break;

		case 3: // Form is in add new data mode
			textLayout.setEnabled(true);
			delete.setEnabled(false);
			save.setEnabled(true);
			cancel.setEnabled(true);
			dieselBuyerGrid.setSelectionMode(SelectionMode.NONE);
			
			clearAllFields();
			id.setInputPrompt("Auto-Generated");

			break;

		}

	}

	private void save(Button.ClickEvent event) {
		
		DieselBuyer dB = null;

		switch (formMode) {
		case 2: // Form is in Edit Mode

			//1: Get the object
			BeanItem<DieselBuyer> dieselBuyerItem = bic.getItem(dieselBuyerGrid.getSelectedRow());
			// 2: Get old Object 
			dB = dieselBuyerItem.getBean();
			
			//3: Set the new details 
			dB.setName(name.getValue());
			
			//4: Commit the fields from UI to DAO
			dieselBuyerDao.updateDieselBuyer(dB);

			break;

		case 3: // Form is in Add mode
			
			//1:  We are adding new data
			dB = new DieselBuyer(name.getValue());

			//2: Commit the fields from UI to DAO
			dieselBuyerDao.addDieselBuyer(dB);

			break;
		}

		// Refresh the data in grid
		bic.removeAllItems();
		bic.addAll(dieselBuyerDao.listAllDieselBuyers());

		Notification.show("Saved " + dB.toString(), Type.TRAY_NOTIFICATION);
		clearAllFields();

	}

	private void cancel(Button.ClickEvent event) {
		clearAllFields();
	}

	private void delete(Button.ClickEvent event) {
		// 1: Get the object
		BeanItem<DieselBuyer> dieselBuyerItem = bic.getItem(dieselBuyerGrid.getSelectedRow());
		DieselBuyer dB = dieselBuyerItem.getBean();

		// 2: Delete it from the dao
		dieselBuyerDao.removeDieselBuyer(dB.getId());

		// Refresh the data in grid
		bic.removeAllItems();
		bic.addAll(dieselBuyerDao.listAllDieselBuyers());

		// 3: Clearing all the input fields
		id.clear();
		name.clear();

	}

	private void clearAllFields() {
		id.clear();
		name.clear();

	}

	/**
	 * @param tayaniMenu
	 *            the tayaniMenu to set
	 */
	public void setTayaniMenu(TayaniMenu tayaniMenu) {
		this.tayaniMenu = tayaniMenu;
	}

	/**
	 * @param dieselbuyerDao
	 *            the dieselbuyerDao to set
	 */
	public void setDieselbuyerDao(DieselBuyerDao dieselBuyerDao) {
		this.dieselBuyerDao = dieselBuyerDao;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}

/*
 * The optiongroup logic has been adopted from example given in following URL:
 * http://stackoverflow.com/questions/26352420/how-to-make-a-pair-of-radio-buttons-in-vaadin-7-to-represent-true-false-values-b
 */
