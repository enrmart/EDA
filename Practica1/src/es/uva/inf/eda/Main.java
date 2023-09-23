/*
 * Esta practica ha sido hecha por Enrique Martin Calvo
 */


package es.uva.inf.eda;
import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main{
	
	public static void main(String[] args) {
		
		 Nodo practica=new Nodo();
		 Red datos=new Red();//datos relaciones
		 Red relaciones=new Red();
		 ArrayList <String> relnew= new ArrayList<>();
		 
		 int n;//numero de usuarios
		 int m;//numero de relaciones
		 
		 ArrayList <Integer>usr = new ArrayList<>();
		 ArrayList <ArrayList<Integer>> gru =new ArrayList<>();
		
		 
		 Scanner teclado= new Scanner(System.in);
		 System.out.print("Introduzca el archivo que desea leer:");
		 String nombre =teclado.nextLine();
		 
		 /*
		  * Fase1
		  */
		 
		 long inicio=System.currentTimeMillis();
		 ArrayList<Red> red =relaciones.leeArchivo(nombre,datos);//comprueba si existen los archivos 
		 long finaliz=System.currentTimeMillis();
		 double tiempored=(double)(finaliz-inicio)/1000;
		 System.out.println("El tiempo de lectura de fichero es:"+tiempored);
		 
		 
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
		
		 inicio=System.currentTimeMillis();
		 usr=practica.genera_usr(red);
		 finaliz=System.currentTimeMillis();
		 double tiempousuar=(double)(finaliz-inicio)/1000;
		 System.out.println("El tiempo de crear la lista de usuarios es:"+tiempousuar);
		 
		 
		 /*
		  * Fase3
		  */
		 
		 
		 
		 inicio=System.currentTimeMillis();
		 gru=practica.obten_grumos(usr,red);
		 finaliz=System.currentTimeMillis();
		 double tiempogrumos=(double)(finaliz-inicio)/1000;
		 System.out.println("El tiempo de crear la lista de grumos es:"+tiempogrumos);
		 
		 
		 /*
		  * Fase4 
		  */
		 
		 
		 inicio=System.currentTimeMillis();
		 practica.ordenar_gru(gru);
		 practica.seleccion(gru,datos,red,porcentaje,relnew,extra);
		 
		 if(datos.getCont()==0) {
			 System.out.println("No hay nodos que unir");
		 }
		 
		 finaliz=System.currentTimeMillis();
		 double tiempord=(double)(finaliz-inicio)/1000;
		 System.out.println("El tiempo de ordenacion y seleccion es:"+tiempord);
		 
		 System.out.println("Existen "+gru.size()+" grumos.");
		 System.out.println("Es necesario modificar los "+datos.getCont()+" mayores grumos");
		 for(int i=0;i<datos.getCont();i++) {
			 System.out.println("#"+i+":"+gru.get(i).size()+" usuarios "+"("+((double)gru.get(i).size()/datos.getn())*100+"%)");
		 }
		 if(datos.getCont()!=0) {
			 System.out.println("Las relaciones nuevas son :");
			 for(int i=0;i<datos.getCont()-1;i++) {
				 System.out.println(relnew.get(i));
			 }
		 } 
		
	}

	
	
	







	


	





	


}

