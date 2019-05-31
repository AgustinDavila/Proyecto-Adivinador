package interfazPensador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Adivinar {

	int numeroLista[];
	int[] listaInicial;
	ArrayList<int[]> listasRestantes = new ArrayList<>();
	boolean primeraVez = true;
	
	public int[] elegirnum4(){
		
		int	longitud=4;
		int	max=9;
		int	indicenum=0;
			numeroLista = new int[longitud];
		int num;
		boolean contiene;
			
		
		while(indicenum<longitud){
			
			if(indicenum == 0) {
				
				num = (int)(Math.random()* max + 1);	
				numeroLista[indicenum] = num;
				indicenum++;
				
			}else {
				
				num = (int)(Math.random()*(max+1));
				contiene = false;
				for(int i=0;i<numeroLista.length && !contiene;i++) {
					
					if(num==numeroLista[i]){
						contiene = true;
					}
				}
					if(!contiene) {
						numeroLista[indicenum++] = num;
					}
			}
		}			
		
			System.out.println("El numero elegido es " + numeroLista[0] + numeroLista[1] + numeroLista[2] + numeroLista[3] );
			
			listaInicial = numeroLista;
			
			return numeroLista;
			
		}
	
	public int[] PcAdivina(int numBien, int numRegular)throws ManejadorExcepciones{
		
		System.out.println("Entro al método para adivinar");
		
		numeroLista = new int[4];
		

        int[] listaAdivinar = new int[4];
        int respBien = numBien;
        int respRegular = numRegular;
        
        if(primeraVez) {
        
        	System.out.println("Entro por primera vez");
	        for (int a = 1; a < 10; a++) {
	            for (int b = 0; b < 10; b++) {
	                if (a == b) {
	                    continue;
	                }
	                for (int c = 0; c < 10; c++) {
	                    if ((a == c || b == c)) {
	                        continue;
	                    }
	                    for (int d = 0; d < 10; d++) {
	                        if ((a != d && b != d && c != d)) {
	                            listaAdivinar[0] = a;
	                            listaAdivinar[1] = b;
	                            listaAdivinar[2] = c;
	                            listaAdivinar[3] = d;
	                            int[] respuesta = intentoAdivinar(listaInicial , listaAdivinar);
	                            if (respuesta[0] == respBien && respuesta[1] == respRegular) {
	                            	listasRestantes.add(listaAdivinar.clone());
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        
	        primeraVez = false;
	        return listasRestantes.get(0);
        
        }else {
        	
        	System.out.println("Entro por x vez");
	        ArrayList<int[]> listasSiguientes = new ArrayList<>();
	        for (int i = 0; i < listasRestantes.size(); i++) {
	        	int[] listaRestante = listasRestantes.get(i);
	            int[] respuesta = intentoAdivinar(listaRestante , listasRestantes.get(0));
	            if (respuesta[0] == respBien && respuesta[1] == respRegular) {
	            	listasSiguientes.add(listaRestante);
	            }

	        }
	        
		    listasRestantes = listasSiguientes;
        } 
	        
	    if(listasRestantes.size() == 0) {
	        	
	    	throw new ManejadorExcepciones();
	        	
	    }

        return listasRestantes.get(0);
        
	    
        	
	}

	public static String transformarLista(int[] lista) {
    	
    	String listaString;
    	
    	listaString = (lista[0] + "" + lista[1] + "" + lista[2] + "" + lista[3]);
    	
    	return listaString;
    }
    
    public static int[] intentoAdivinar(int[] listaAnt, int[] listaNue) {
		
		int respuesta[] = new int[2];
		String listaAnterior = transformarLista(listaAnt);
		String listaNueva = transformarLista(listaNue);		

		
		for(int i=0;i<listaNueva.length();i++) {
			for(int a=0;a<listaAnterior.length();a++) {
				if(listaNueva.charAt(i) == listaAnterior.charAt(a)){
					if(i==a) {
						respuesta[0]= respuesta[0] + 1;
					}else {
						respuesta[1]= respuesta[1] + 1;
					}
				}
			}
		}

	return respuesta;
		
	}

	
}
