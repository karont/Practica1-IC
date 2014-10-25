import Controlador.Controlador;
import Modelo.Mapa;
import Modelo.Nodo;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controlador controlador = new Controlador();
		int m = 10;
		int n = 10;
		Mapa mapa = new Mapa(m,n);
		
		mapa.setSalida(new Nodo(1,1));
		mapa.setMeta(new Nodo(7,8));
		
		
	
		
		
		for(int i=0; i<m;i++){
			for(int j=0; j<n;j++){
				System.out.print(mapa.getCasilla(new Nodo(i, j)));
			}
			System.out.println();
		}
	}

}
