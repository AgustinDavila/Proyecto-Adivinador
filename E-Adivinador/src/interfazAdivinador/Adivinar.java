package interfazAdivinador;

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
		String numero = (numeroLista[0] + "" + numeroLista[1] + "" + numeroLista[2] + "" + numeroLista[3]);
		
		return numeroLista;
	}	
	
	
	public int[] intentoAdivinar(String lista,String numPersonaje) {
		
		int respuesta[] = new int[2];
		
		for(int i=0;i<numPersonaje.length();i++) {
			for(int a=0;a<lista.length();a++) {
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

	
	

