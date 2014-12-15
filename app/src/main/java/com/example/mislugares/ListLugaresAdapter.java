package com.example.mislugares;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.SQLException;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListLugaresAdapter extends BaseAdapter {

	private final Activity activity;
	private Vector<Lugar> lista;
	private LugaresDb lugaresDb;

	Resources res;
	TypedArray drawableIconosLugares;
	List<String> valoresIconosLugares;

	/**
	 * Constructor que cre un ListLugares adapter a
	 * partir de una Activity que se le mande. Creamos 
	 * un nuevo Vector del tipo Lugar y actualizamos desde
	 * el ID asi como también cargamos iconos.
	 * 
	 * @param activity
	 * @param lista
	 */
	public ListLugaresAdapter(Activity activity) {
		super();
		this.activity = activity;
		this.lista = new Vector<Lugar>();
		actualizarDesdeBd();

		// Cargar recursos iconos MIRAR LA DIFERENCIA
		res = activity.getResources();
		
		//Crea un TypedArray (?) a partir de la lista de las 
		//referencias de iconos en el XML.
		drawableIconosLugares = res
				.obtainTypedArray(R.array.drawable_iconos_lugares);
		
		//Crea una lista de Strings a partir de los nombres en la
		//lista de items de iconos lugares
		valoresIconosLugares = Arrays.asList(res
				.getStringArray(R.array.valores_iconos_lugares));
		
		
	}

	/**
	 * Crea un nuevo objeto de la base de datos LugaresDb
	 * Pilla la lista de esta clase y carga los lugares en
	 * la BD
	 * @throws SQLException
	 */
	public void actualizarDesdeBd() throws SQLException {
		lugaresDb = new LugaresDb(activity);
		this.lista = lugaresDb.cargarLugaresDesdeBD();
	}

	
	@Override
	/**
	 * Arroja un int con el tama�o de la lista
	 */
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	/**
	 * Arroja un objeto Lugar de la lista
	 * en la posici�n que le pasamos como
	 * par�metro.
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lista.elementAt(position);
	}
	/**
	 * Arroja la Id de un objeto en la 
	 * posici�n que le pasemos como par�metro
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		Lugar lugar = (Lugar) getItem(position);
		return lugar.getId();
	}
	
	
	/**
	 * Devuelve una vista para cada objeto de la lista en la
	 * que veremos el objeto sus datos y su icono.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = activity.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_lista, null, true);
		ImageView imgViewIcono = (ImageView) view.findViewById(R.id.icono);
		TextView textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
		TextView textViewInfo = (TextView) view.findViewById(R.id.textViewInfo);

		Lugar lugar = lista.elementAt(position);
		textViewTitulo.setText(lugar.getNombre());
		textViewInfo.setText(lugar.toString());

		Drawable icon = obtenDrawableIcon(lugar.getCategoria().getIcon());
		imgViewIcono.setImageDrawable(icon);

		return view;
	}

	/**
	 * Arroja un objeto Drawable (una imagen o algo as� almacenada
	 * en la carpeta hom�nima) a partir de su ruta dada en String.
	 * @param icon
	 * @return
	 */
	public Drawable obtenDrawableIcon(String icon) {
		// Busca la posici�n en el array de rutas de imagenes
		// Que tenga la posici�n de la referencia de icon
		int posicion = valoresIconosLugares.indexOf(icon);
		// -1 si no existe lo ponemos a 0 (icono ND: No Definido)
		if (posicion == -1)
			posicion = 0;
		//Retorna la imagen (Drawable) en esa posici�n
		return drawableIconosLugares.getDrawable(posicion);
	}

}
