package com.tayani.app.ui.forms;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = TransportersForm.VIEW_NAME)
public class TransportersForm extends VerticalLayout implements View {

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(TransportersForm.class);

    public static final String VIEW_NAME = "transporters-form";
	
    @PostConstruct
    public void init(){
    	
    	 addComponent(new Label("This is a transporters-form"));
    }
    
    
	@Override
	public void enter(ViewChangeEvent event) {
		
		
		
	}
	
	

}
