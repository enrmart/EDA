/*
 * Esta practica ha sido hecha por Enrique Martin Calvo
 */


package es.uva.inf.eda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;



public class Funcionalidades{
	
	public void seleccion(Map<Integer, Integer> pesos, Red datos,ArrayList<Red> red, int porcentaje) {
		 int cont=0;
		 double por;
		 double sumapor=0;
		 Set<Integer> keys = pesos.keySet();
	     for (Integer key : keys) {
	        	por=((double)pesos.get(key)/datos.getn())*100;
	        	sumapor=por+sumapor;
				if(sumapor>=porcentaje || sumapor>=100) {
					cont++;
					datos.setCont(cont);
					break;
				}
				cont++;
				}
	     	datos.setCont(cont);
	     }
 
	  public void nuevasrelaciones(DisjointSet gru, Red datos,ArrayList<Red> red,ArrayList<String>relnew) {
		  	int pos=0;
		  	int cont=datos.getCont();
			String linea;
			int num1;
			int num2;
			Object[] keys=gru.getMap().keySet().toArray();
			while(pos<cont-1) {
				gru.union((int)keys[pos], (int)keys[pos+1]);
				num1=(int)keys[pos];
				num2=(int)keys[pos+1];
				linea=num1+" "+num2;
				relnew.add(linea);
				pos++;
			}	
	  }
		public void escritura(ArrayList<String>relnew,String extra, Red datos) {
			FileWriter fw=null;
			int pos=0;
			PrintWriter pw;
			int cont=datos.getCont();
			try {
		        fw= new FileWriter("extra.txt");
		        pw=new PrintWriter(fw);
		        while(pos<cont-1) {
		        	pw.println(relnew.get(pos));
					pos++;
		        }
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}	
		public Map<Integer,Integer> ordenar_gru(DisjointSet gru) {
			Map<Integer,Integer> pesos= gru.getMappes();
			final Map<Integer, Integer> sortedpesos = pesos.entrySet().stream().sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
			return sortedpesos;
		}






		public DisjointSet conjunto(ArrayList<Red> red) {
			HashMap <Integer,Integer> usr=new HashMap<>();
			for(int i=0;i<red.size();i++) {
				if(!usr.containsKey(red.get(i).getnum1())) {
					usr.put(red.get(i).getnum1(),null);
				}
				if(!usr.containsKey(red.get(i).getnum2())) {
					usr.put(red.get(i).getnum2(),null);
				}
			}
			DisjointSet conj = new DisjointSet();
			usr.forEach((k,v) ->conj.makeSet(k));
			for(int i=0;i<red.size();i++) {
				conj.union(red.get(i).getnum1(),red.get(i).getnum2());
			}
			
			return conj;
		}
		
		
		





	
	
}
