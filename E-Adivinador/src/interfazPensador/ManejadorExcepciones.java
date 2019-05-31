package interfazPensador;

import java.io.*;

import javax.swing.JOptionPane;

import principal.UI_Principal;

public class ManejadorExcepciones extends Exception {
	
	public ManejadorExcepciones(){
		
		JOptionPane.showMessageDialog(null,"Se ha equivocado en la respuesta, por favor comience de nuevo.");
		
		UI_Principal ui_princ = new UI_Principal();
		ui_princ.setVisible(true);
		ui_princ.setLocationRelativeTo(null);

	}
	
	public ManejadorExcepciones(String a){
		
		super(a);
				
	}
	

}
