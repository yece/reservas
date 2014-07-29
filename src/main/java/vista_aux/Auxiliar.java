package com.example.vista_aux;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

public class Auxiliar {
	
	//LABEL DE BIENVENIDA
	
	
	//MENSAJE DE ERROR
	public Label labelError(String mensaje){
		Label error = new Label(""+mensaje+"<span></span>",ContentMode.HTML);
        error.addStyleName("error");
        error.setSizeUndefined();
        error.addStyleName("light");
//         Add animation
        error.addStyleName("v-animate-reveal");
        return error;
	}
	
	
}
