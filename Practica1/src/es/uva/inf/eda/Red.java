/*
 * Esta practica ha sido hecha por Enrique Martin Calvo
 */



package es.uva.inf.eda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Red {
	private int num1;
	private int num2;
	private int n;
	private int m;
	private int cont;
	
public Red() {
	this.num1=0;
	this.num2=0;
}
public Red(int num1, int num2) {
	this.num1=num1;
	this.num2=num2;
}
public Red(String data) {
	parseData(data);
}
private void parseData(String data) {
	String[] split = data.split(" ");
	num1 = Integer.parseInt(split[0]);
	num2 = Integer.parseInt(split[1]);
}

public void setnum1(int b) {
	num1=b;
}
public void setnum2(int a) {
	num2=a;
}
public int getnum1() {
	return num1;
}
public int getnum2() {
	return num2;
}
public void setn(int b) {
	n=b;
}
public void setm(int a) {
	m=a;
}
public int getn() {
	return n;
}
public int getm() {
	return m;
}


public void setCont(int a) {
	cont=a;
}
public int getCont() {
	return cont;
}

public ArrayList<Red> leeExtra(String extra, Red datos,ArrayList<Red>red) {
	FileReader f;
	BufferedReader b;
	ArrayList <Red>redv;
	try {
		f = new FileReader(extra);
		b = new BufferedReader(f);
		redv = new ArrayList<>(red);
		String line;
		while((line=b.readLine())!=null) {
			redv.add(new Red(line));
		}
		b.close();
		return redv;
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
}

	
	
public ArrayList<Red> leeArchivo(String nombre,	Red datos) {
		File archivo= new File(nombre);
		FileReader f;
		BufferedReader b;
		ArrayList <Red>redv ;
		try {
			f = new FileReader(archivo);
			b = new BufferedReader(f);
			datos.setn(Integer.parseInt(b.readLine()));
			datos.setm(Integer.parseInt(b.readLine()));
			redv = new ArrayList<>();
			String line;
			while((line=b.readLine())!=null) {
				redv.add(new Red(line));
			}
			b.close();
			return redv;
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	
	}
}






