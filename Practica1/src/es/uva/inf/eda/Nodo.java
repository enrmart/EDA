/*
 * Esta practica ha sido hecha por Enrique Martin Calvo
 */


package es.uva.inf.eda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Nodo{
	
	public void seleccion(ArrayList<ArrayList<Integer>> gru, Red datos,ArrayList<Red> red, int porcentaje,ArrayList <String> relnew,String extra) {
		int pos=0;
		Red newrel= new Red();
		String linea;
		 FileWriter fw=null;
		 PrintWriter pw;
		 int cont=0;
		 double porc=((double)gru.get(0).size()/datos.getn())*100;
		 if(porc<porcentaje) {
			 double sumapor=0;
			 for(int i=0;i<gru.size() && sumapor<porcentaje;i++) {
				 sumapor=sumapor+((double)gru.get(i).size()/datos.getn())*100;
				cont++;
			}
		 }
		try {
	        fw= new FileWriter("extra.txt");
	        pw=new PrintWriter(fw);
			while(pos<cont-1) {
				newrel.setnum1(gru.get(pos).get(1));
				newrel.setnum2(gru.get(pos+1).get(0));
				red.add(newrel);
				pos++;
				String num1=String.valueOf(newrel.getnum1());
				String num2=String.valueOf(newrel.getnum2());
				linea=num1+" "+num2;
				relnew.add(linea);
				pw.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			datos.setCont(cont);
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
		
		
		public ArrayList<Integer> genera_usr(ArrayList<Red>red) {
			ArrayList<Integer> usuarios=new ArrayList<>();
			for(int i=0;i<red.size();i++) {
				if(!usuarios.contains(red.get(i).getnum1())) {
					usuarios.add(red.get(i).getnum1());
				}
				if(!usuarios.contains(red.get(i).getnum2())) {
					usuarios.add(red.get(i).getnum2());
				}
			}
		
			return usuarios;
		}

		
		
	
		public ArrayList<ArrayList<Integer>> obten_grumos(ArrayList<Integer> usr,ArrayList<Red> red) {
			ArrayList<ArrayList<Integer>>grumos=new ArrayList<>();
			ArrayList<Integer>asig=new ArrayList<>();
			ArrayList<Integer>grumo=new ArrayList<>();
			for(int i=0;i<usr.size();i++) {
				if(!asig.contains(usr.get(i))) {
					grumo=uber_amigos(red,usr.get(i),grumo);
					ArrayList<Integer>copia=new ArrayList<>(grumo);
					grumos.add(copia);
					for(int j=0;j<grumo.size();j++) {
						asig.add(grumo.get(j));
					}
					grumo.clear();
				}	
			}
			return grumos;
		}
				
		public ArrayList<Integer>uber_amigos(ArrayList<Red> red, int pivote,ArrayList<Integer>grumo) {
			for(int j=0;j<red.size();j++) {
				if(red.get(j).getnum1()==pivote) {
					if(!grumo.contains(red.get(j).getnum2())) {
						grumo.add(red.get(j).getnum2());
						uber_amigos(red,red.get(j).getnum2(),grumo);
					}
				}else if(red.get(j).getnum2()==pivote){
					if(!grumo.contains(red.get(j).getnum1())) {
						grumo.add(red.get(j).getnum1());
						uber_amigos(red,red.get(j).getnum1(),grumo);
					}
				}
			}		
			return grumo;
		}



		public void ordenar_gru(ArrayList<ArrayList<Integer>> gru) {
			gru.sort(Comparator.comparing(ArrayList<Integer>::size).reversed());
		}
		
		
		





	
	
}
