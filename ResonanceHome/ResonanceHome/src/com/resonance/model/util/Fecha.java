package com.resonance.model.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
private int dia;
private int mes;
private int anio;
public int getMes() {
	return mes;
}
public int getAnio() {
	return anio;
}
public Fecha(int dia, int mes, int anio) {
	this.dia = dia;
	this.mes = mes;
	this.anio = anio;
}


public void anadirDia()
{
	String oldDate = toString();  
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar c = Calendar.getInstance();

	   //Setting the date to the given date
	   try {
		c.setTime(sdf.parse(oldDate));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	c.add(Calendar.DAY_OF_MONTH, 1);  
	dia = c.get(Calendar.DAY_OF_MONTH);
	mes = c.get(Calendar.MONTH)+1;
	anio = c.get(Calendar.YEAR);
}

public boolean isMayor(Date date)
{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date d=null;
	try {
		d = sdf.parse(toString());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if( d.compareTo(date)>0)
	{
		return true;
	}
	return false;
}

	public static Date convertirFecha(Fecha fecha) {
		String oldDate = fecha.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();

		// Setting the date to the given date
		try {
			c.setTime(sdf.parse(oldDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c.getTime();
	}

@Override
public String toString()
{
	String diaAux=dia+"", mesAux=mes+"";
	if((dia+"").length() ==1)
	diaAux ="0" + dia;
	if((mes+"").length() ==1)
	mesAux ="0" + mes;
	
	return anio +"-" + mesAux + "-" + diaAux;
}

	/**
	 * @return the dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

}
