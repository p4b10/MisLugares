package com.example.mislugares;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListCategorias extends ListActivity {
	
	private CategoriasAdapter categoriasAdaptador;
	Bundle extras=new Bundle();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_list_categorias);
				registerForContextMenu(super.getListView());

				//Se crea un nuevo adaptador propio
				categoriasAdaptador = new CategoriasAdapter(this);
				setListAdapter(categoriasAdaptador);
	}
	/**
	 * Hace que cargue una activity al presionar sobre un item del ListActivity
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Categoria itemCategoria = (Categoria) getListAdapter().getItem(position);
		Bundle extras = itemCategoria.getBundle();
		extras.putBoolean("añadir", false);
		lanzarEditCategoria(extras);
	}
	/**
	 * El botoncito de la dichosa cruz que nunca funcion�. Es un ImageButton
	 * Y este es el m�todo del OnClick
	 * @param v
	 */
	public void imageButtonAddCategoriaOnClick(View v){
		Bundle extras = new Bundle();
		extras.putBoolean("add", true);
		lanzarEditCategoria(extras);
		
	}
	
	/**
	 * Al volver a esta actividad son risas y carga todo.
	 */
	@Override
	public void onRestart(){
		super.onRestart();
		categoriasAdaptador.cargarDatosDesdeBd();
		categoriasAdaptador.notifyDataSetChanged();
	}
	
	/**
	 * M�todo que hace un intent para llamar a la clase EditCategor�a.
	 * @param extras
	 */
	private void lanzarEditCategoria(Bundle extras) {
			//Lanza un Intent de EditCategorias en ese Intent metemos el Bunble definido
			//en el onListItemClick y luego inicia la actividad
		Intent i = new Intent(this, EditLugarActivity.class);
		i.putExtras(extras);
		startActivityForResult(i, 1234);
	}
	
	
	
	
	/**
	 * Comprueba el resultado del startActivityForResult que a saber que co�o
	 * comprueba y que co�o hace porque lo explico mal y muy por encima.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1234 && resultCode == RESULT_OK) {
			String resultado = data.getExtras().getString("resultado");
			Toast.makeText(getBaseContext(), resultado, Toast.LENGTH_LONG)
					.show();
			}
		}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_categorias, menu);
		return true;
	}

	
	/**
	 * Esto no se cuando carajo lo selecciona pero si el
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.add_lugar) {//MIRAR DE DONDE SALE ESTE ADD_LUGAR
			extras.clear();
			extras.putBoolean("add", true);
			lanzarEditCategoria(extras);
			return true;
		}
		return super.onOptionsItemSelected(item);
		/*
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
}
}