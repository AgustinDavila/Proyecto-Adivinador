package interfazAdivinador;

import java.util.Random;

public class Adivinar implements MetodoAdivinador{
		
	int numeroLista[];

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
		String numero = "" + numeroLista[0] + "" + numeroLista[1] + "" + numeroLista[2] + "" + numeroLista[3];
		int numero2 = Integer.parseInt(numero);
		System.out.println(numero2 + " jaja");
		
		return numeroLista;
	}	
	
	
	public int[] intentoAdivinar(String lista,String numPersonaje) {
		
		int respuesta[] = new int[2];
		
		for(int i=0;i<numPersonaje.length();i++) {
			System.out.println("Primero agarro " + numPersonaje.charAt(i));
			for(int a=0;a<lista.length();a++) {
				System.out.println("Segundo agarro " + lista.charAt(a));
				if(numPersonaje.charAt(i) == lista.charAt(a)){
					if(i==a) {
						respuesta[0]= respuesta[0] + 1;
					}else {
						respuesta[1]= respuesta[1] + 1;
					}
				}
			}
		}
		
		System.out.println("Entonces me muestra" + respuesta[0] + " y tmb " + respuesta[1]);

		return respuesta;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

	
	

