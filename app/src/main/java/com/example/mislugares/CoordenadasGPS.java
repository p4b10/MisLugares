package com.example.mislugares;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

public class CoordenadasGPS {
	private LocationManager manejador;
	private Activity activity;
	Location localizacion;
	String proveedor;
	
	public CoordenadasGPS(Activity activity){
		super();
		this.activity=activity;
		
		/*
		 * Aqui con criteria estás eligiendo los criterios de elección de los proveedores
		 * */
		manejador=(LocationManager)activity.getSystemService(proveedor);
		if(manejador==null){
			localizacion=null;
		}
		
	if(!manejador.isProviderEnabled(LocationManager.GPS_PROVIDER)){	
		localizacion=null;
		}else
		{
		Criteria criteria=new Criteria();
		proveedor=manejador.getBestProvider(criteria, true);
		localizacion = manejador.getLastKnownLocation(proveedor);
		}
	}

}
