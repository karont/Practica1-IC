import Controlador.Controlador;
import Modelo.Logica;
import Modelo.Mapa;
import Modelo.Nodo;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Controlador controlador = new Controlador();
//		controlador.arrancaaplicacion();
	/*********** PRUEBAS*****************/
		int m = 6;
		int n = 6;
		Mapa mapa = new Mapa(m,n);
		Logica logica = new Logica(mapa, new Nodo(5,0), new Nodo(3,5));
	
		mapa.setObstaculo(new Nodo(5,1));
		mapa.setObstaculo(new Nodo(4,1));
		mapa.setObstaculo(new Nodo(3,1));
		mapa.setObstaculo(new Nodo(2,1));
		mapa.setObstaculo(new Nodo(0,0));
		mapa.setObstaculo(new Nodo(2,3));
		mapa.setObstaculo(new Nodo(0,2));
		
		
	
		System.out.print("  ");
		for(int j=0; j<n;j++){
			System.out.print(j+ " ");
		}
		System.out.println();
		
		for(int i=0; i<m;i++){
			System.out.print(i + " ");
			
			for(int j=0; j<n;j++){
				
				if (i == 5 && j == 0){
					System.out.print("s" + " ");
				}
				
				else if (i == 3 && j == 5){
					System.out.print("m" + " ");
				}
				else if(mapa.getCasilla(new Nodo(i,j)).abierto == true)
					System.out.print(0 + " ");
				
				else 
					System.out.print(1+ " ");
				
			}
			System.out.println();
		}
		/**********************************************/
	}

}
