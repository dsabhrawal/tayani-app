package com.tayani.app.ui.forms;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tayani.app.model.authentication.UserData;
import com.tayani.app.util.UIConstants;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = WelcomePage.VIEW_NAME)
public class WelcomePage extends VerticalLayout implements View {

	/**
	 * serial version used in serialization and deserialization.
	 */
	private static final long serialVersionUID = 1L;

	public static final String VIEW_NAME = "welcome-page";

	// Adding the logger
	private static final Logger logger = LoggerFactory.getLogger(WelcomePage.class);

	@Autowired
	private TayaniMenu tayaniMenu;

	private Label welcomeLabel;

	@PostConstruct
	private void init() throws IOException {

		this.setWidth(UIConstants.WIDTH_FULL);
		this.addComponent(tayaniMenu);

		welcomeLabel = new Label("Welcome to the Application ");
		this.addComponent(welcomeLabel);

		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

		FileResource resource = new FileResource(new File(basepath + "/WEB-INF/images/welcome.jpg"));

		Image welcomeImage = new Image("Welcome", resource);

		this.addComponent(welcomeImage);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

		VaadinSession session = getUI().getSession();
		logger.debug(session.toString());

		UserData uD = getSession().getAttribute(UserData.class);
		logger.debug(uD.toString());

		this.welcomeLabel.setCaption("Welcome : " + uD.getName());
	}

	@Override
	public void attach() {

	}

	/**
	 * @param tayaniMenu
	 *            the tayaniMenu to set
	 */
	public void setTayaniMenu(TayaniMenu tayaniMenu) {
		this.tayaniMenu = tayaniMenu;
	}

}
