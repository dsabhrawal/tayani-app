package com.tayani.app.ui.forms;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tayani.app.util.UIConstants;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

public final class TayaniMenu extends GridLayout {

	/**
	 * */
	private static final long serialVersionUID = 1L;

	/**
	 * The logger object
	 */
	private static final Logger logger = LoggerFactory.getLogger(TayaniMenu.class);

	/**
	 * This is required for navigation between different views
	 */
	@Autowired
	private SpringViewProvider viewProvider;

	private MenuBar menu;
	private MenuItem ourFirmForm, transporters, dieselBuyers;
	private MenuItem master, settings;
	private Navigator navigator;

	@PostConstruct
	private void init() {

		configureUI();

	}

	private void configureUI() {
		menu = new MenuBar();
		master = menu.addItem("Master Data", null);
		master.setIcon(FontAwesome.TABLE);

		ourFirmForm = master.addItem("Our Firms", ourFirm);
		transporters = master.addItem("Transporters", menuCommand);
		dieselBuyers = master.addItem("Diesel Buyers", dieselBuyersAction);
		

		settings = menu.addItem("Settings", null);
		settings.setIcon(FontAwesome.GEAR);

		this.setWidth(UIConstants.WIDTH_FULL);

		this.addComponent(menu);
	}

	private final Command menuCommand = new Command() {
		@Override
		public void menuSelected(final MenuItem selectedItem) {
			Notification.show("Action " + selectedItem.getText(), Type.TRAY_NOTIFICATION);
		}
	};

	private final Command ourFirm = new Command() {
		@Override
		public void menuSelected(final MenuItem selectedItem) {
			getUI().getNavigator().navigateTo(OurFirmForm.VIEW_NAME);

		}

	};
	
	
	private final Command dieselBuyersAction = new Command(){
		@Override
		public void menuSelected(final MenuItem selectedItem) {
			getUI().getNavigator().navigateTo(DieselBuyerForm.VIEW_NAME);
		}
	};

	/**
	 * @param viewProvider
	 *            the viewProvider to set
	 */
	public void setViewProvider(SpringViewProvider viewProvider) {
		this.viewProvider = viewProvider;
	}

}
