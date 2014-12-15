package com.example.mislugares;

import java.util.Vector;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CopyOfListLugaresAdapter extends BaseAdapter {

	private final Activity activity;
	private final Vector<String> lista;

	/**
	 * @param activity
	 * @param lista
	 */
	public CopyOfListLugaresAdapter(Activity activity, Vector<String> lista) {
		super();
		this.activity = activity;
		this.lista = lista;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lista.elementAt(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = activity.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_lista, null, true);
		TextView textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
		//TextView textViewInfo = (TextView) view.findViewById(R.id.textViewInfo);
		textViewTitulo.setText(lista.elementAt(position));
		//Pendiente textViewUrl

		return view;
	}
}
