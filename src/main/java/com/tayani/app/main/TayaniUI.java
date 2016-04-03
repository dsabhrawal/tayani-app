package com.tayani.app.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tayani.app.model.authentication.UserData;
import com.tayani.app.model.authentication.UserRole;
import com.tayani.app.ui.forms.DieselBuyerForm;
import com.tayani.app.util.UIConstants;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@VaadinSessionScope
/*
 * TODO: Using the broadest scope available. Understand scope concept in vaadin
 * and use it properly.
 */

@Theme("valo")
public class TayaniUI extends UI {

	// Adding the logger
	private static final Logger logger = LoggerFactory.getLogger(TayaniUI.class);

	private static final long serialVersionUID = -8650159967328998190L;

	private UserData user;

	/**
	 * This is required for navigation between different views
	 */
	@Autowired
	private SpringViewProvider viewProvider;

	@Override
	protected void init(VaadinRequest request) {

		configureComponents();
		buildLayout();

		/**
		 * Start Test - In final code each user will have their own UserData
		 * Objects. We just creating a dummy object for now
		 */
		UserData uD = new UserData("Aditya Rajurkar", "00145", UserRole.Admin);
		this.getSession().setAttribute(UserData.class, uD);

		/** Stop Test */

	}

	private void configureComponents() {

	}

	/*
	 * Robust layouts.
	 *
	 * Layouts are components that contain other components. HorizontalLayout
	 * contains TextField and Button. It is wrapped with a Grid into
	 * VerticalLayout for the left side of the screen. Allow user to resize the
	 * components with a SplitPanel.
	 *
	 * In addition to programmatically building layout in Java, you may also
	 * choose to setup layout declaratively with Vaadin Designer, CSS and HTML.
	 */
	private void buildLayout() {

		VerticalLayout mainLayout = new VerticalLayout();

		mainLayout.setWidth(UIConstants.WIDTH_FULL);

		Navigator navigator = new Navigator(this, mainLayout);
		navigator.addProvider(viewProvider);

		navigator.navigateTo(DieselBuyerForm.VIEW_NAME);

		// navigator.navigateTo(OurFirmForm.VIEW_NAME);

		setContent(mainLayout);
	}

	/**
	 * @param viewProvider
	 *            the viewProvider to set
	 */
	public void setViewProvider(SpringViewProvider viewProvider) {
		this.viewProvider = viewProvider;
	}

	/**
	 * @return the user
	 */
	public UserData getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserData user) {
		this.user = user;
	}

}
