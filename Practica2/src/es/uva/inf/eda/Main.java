/*
 * Esta practica ha sido hecha por Enrique Martin Calvo
 */


package es.uva.inf.eda;
import java.util.Scanner;
import java.util.Set;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main{
	
	public static void main(String[] args) {
		
		 Funcionalidades practica=new Funcionalidades();
		 Red datos=new Red();//datos relaciones
		 Red relaciones=new Red();
		 DisjointSet gru; 
		 ArrayList<String>relnew=new ArrayList<>();
		 
		 Scanner teclado= new Scanner(System.in);
		 System.out.print("Introduzca el archivo que desea leer:");
		 String nombre =teclado.nextLine();
		 
		 /*
		  * Fase1
		  */
		 
		 ArrayList<Red> red =relaciones.leeArchivo(nombre,datos);//comprueba si existen los archivos 

		 
		 System.out.print("Si existe un fichero extra, introduzca su nombre, si no pulse Enter:");
		 String extra =teclado.nextLine();
		 if (extra.length()!=0) {
			 red=relaciones.leeExtra(extra,datos, red); 
		 }
		 
		 System.out.print("Porcentaje de usuarios que tiene que superar el grafo maximo:");
		 int porcentaje=teclado.nextInt();
		 
		 System.out.println(datos.getn()+" usuarios,"+ datos.getm() +" relaciones");
		 
		 /*
		  * Fase 2
		  */
		 double inicio=System.currentTimeMillis();
		 gru=practica.conjunto(red);
		 double finaliz=System.currentTimeMillis();
		 double tiempogrumos=(double)(finaliz-inicio)/1000;
		 System.out.println("El tiempo de crear la lista de grumos es:"+tiempogrumos);
		 
		 /*
		  * Fase3
		  */
		  inicio=System.currentTimeMillis();
		 Map<Integer,Integer> pesos= gru.getMappes();
		 pesos=practica.ordenar_gru(gru);
		 practica.seleccion(pesos,datos,red,porcentaje);
		 practica.nuevasrelaciones(gru, datos, red, relnew);
		 finaliz=System.currentTimeMillis();
		 double tiempord=(double)(finaliz-inicio)/1000;
		 System.out.println("El tiempo de ordenacion y seleccion es:"+tiempord);
		 
		 
		 if(datos.getCont()==0) {
			 System.out.println("No hay nodos que unir");
		 }
		 
		 System.out.println("Existen "+gru.getMappes().keySet().toArray().length+" grumos.");
		 System.out.println("Es necesario modificar los "+datos.getCont()+" mayores grumos");
		 /*
		  * Fase4
		  */
		 int grumo=1;
		 Object[] keys = pesos.keySet().toArray();
	     for (int key=0;key<datos.getCont();key++) {
	        	System.out.println("#"+grumo+":"+pesos.get((int)keys[key])+" usuarios "+"("+((double)pesos.get((int)keys[key])/datos.getn())*100+"%)");
	        	grumo++;
		 }
	     if(datos.getCont()!=0) {
	    	 practica.escritura(relnew,extra,datos);
			 System.out.println("Las relaciones nuevas son :");
			for(int i=0;i<datos.getCont()-1;i++) {
				 System.out.println(relnew.get(i));
			 }
		 }
	    
	}

	
	
	







	


	





	


}

