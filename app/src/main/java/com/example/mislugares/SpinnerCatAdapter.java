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

public class SpinnerCatAdapter extends BaseAdapter{
		//private ArrayList<String> iconos;
		private Activity activity;
		Resources res;
		TypedArray drawableIconosCategorias;
		List<String> valoresIconosCategorias;

		/**
		 * @param activity
		 *
		 */
		public SpinnerCatAdapter(Activity activity) {
			super();
			this.activity = activity;
			
			//this.iconos=obtenerIconos();
		
			res = activity.getResources();
			drawableIconosCategorias = res.obtainTypedArray(R.array.drawable_iconos_lugares);
			
			valoresIconosCategorias = Arrays.asList(res.getStringArray(R.array.valores_iconos_lugares));
			
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return valoresIconosCategorias.size();
		}
		/**
		 * Metodo freestyle para obtener un arrayList con los campos del icono
		 * Este campo guarda el valor de referencia del icono.
		 * @return
		 */
		/*public ArrayList<String> obtenerIconos(){
			ArrayList<String> iconos = new ArrayList<String>();
			for (Categoria c:lista){
				iconos.add(c.getIcon().toString());
			}
			
			return iconos;
		}*/

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return valoresIconosCategorias.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			String valor = getItem(position);
			return valoresIconosCategorias.indexOf(valor);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inflater = activity.getLayoutInflater();
			View view = inflater.inflate(R.layout.icono_cat, null, true);
			String icono = valoresIconosCategorias.get(position);
			TextView text =(TextView) view.findViewById(R.id.textView1);
			text.setText(icono);
			ImageView imgViewIcono =(ImageView) view.findViewById(R.id.imageView1);
			Drawable icon = obtenDrawableIcon(icono);
			imgViewIcono.setImageDrawable(icon);
			
	        return view;
			
		}
		
		
		public Drawable obtenDrawableIcon(String icon) {
			// Busca la posici�n en el array de rutas de imagenes
			// Que tenga la posici�n de la referencia de icon
			int posicion = valoresIconosCategorias.indexOf(icon);
			// -1 si no existe lo ponemos a 0 (icono ND: No Definido)
			if (posicion == -1)
				posicion = 0;
			//Retorna la imagen (Drawable) en esa posici�n
			return drawableIconosCategorias.getDrawable(posicion);
			}
	
}
