package com.example.mislugares;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditCategoriaActivity extends Activity {

	private TextView editTextNombre;//almacenar el nombre
	private Spinner spinnerIconos;
	private Categoria categoria;
	private boolean anhadir;
	SpinnerCatAdapter spinnerAdaptador;
	List<String> valoresIconosCategorias;
	Resources res;
	
	/**
	 * Al iniciar la activity se buscan las variables de los elementos visuales.
	 * 	1.-Se crea un objeto categoría con el que trabajaremos
	 * 	2.-Se crea un nuevo bundle donde meteremos los datos del objeto a trabajar
	 * 	3.-Metemos en el bunble los datos que pasamos en el intent al llamar a esta
	 *     activity desde ListCategoria.
	 * 	4.-De esos extras pillamos el booleano que indica si añadimos o modificamos
	 * 	5.-Si NO es verdadero modificamos, para ello le pasamos el bundle al objeto 
	 * 	   creado en esta clase.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//mitico
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_categoria);
		editTextNombre=(TextView) findViewById(R.id.edito_nombre_cat);
		spinnerIconos=(Spinner) findViewById(R.id.spinner_icon);
		//hay que focellarle y en lazarlo al adapter
		spinnerAdaptador = new SpinnerCatAdapter(this);
		spinnerIconos.setAdapter(spinnerAdaptador);
		res = this.getResources();
		valoresIconosCategorias = Arrays.asList(res.getStringArray(R.array.valores_iconos_lugares));
		
		//*res = this.getResources();
		//*valoresIconosCategorias = (List<String>) Arrays.asList(res.getStringArray(R.array.valores_iconos_lugares));
		
		//*categoria = new Categoria();//Creamos nuevo objeto
		//Bundle extras = new Bundle();//un nuevo cajón de sastre para recibir los del intent
		//(extras = getIntent().getExtras();//metemos en el bundle el bundle que viene de ListCategorias
		//añadir = extras.getBoolean("añadir");//Adquirimos el valor de una variable del bundle.
		//if (añadir) {
			//Toast.makeText(getBaseContext(), "AñADIR CATEGORIA", Toast.LENGTH_LONG).show();
			// lugarEdit.setValoresIniciales();
		//} else {
			//Toast.makeText(getBaseContext(), extras.getString(Lugar.C_NOMBRE),
				//	Toast.LENGTH_LONG).show();
			//categoria.setBundle(extras);//Toma los valores del bundle que viene de ListCategorias. 
			//En list categorias se pasa un bundle que es el del objeto al cual se le añade el boolean
			//añadir. Hay que hacer para ello un método get "bundle" en la clase de

		//}
	}
	
	/*public int posicionIcono(String s){
	    int c=0;
	    int posicion=0;
	    boolean existe=false;
		for(String a:iconos){
			if(s.equalsIgnoreCase(a)){
				existe=true;
				posicion=c;
			}
			
			c++;
		}
		if (!existe){
			posicion=0;
		}
		
		return posicion;
		
	}*/
	
	/*private void establecerValoresEditar() {
		// TODO Auto-generated method stub
		editTextNombre.setText(categoria.getNombre());

		int position = 0;
		//if (!a�adir) {
			iconos = categoriasAdaptador.obtenerIconos();
			position=posicionIcono(Categoria.C_ICON);
		//}
		spinnerIconos.setSelection();

	}*/
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.edit_categoria, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void buttonGuardarOnClick(View v) {
		// TODO Auto-generated method stub
		
		String a=editTextNombre.getText().toString();
		String b=valoresIconosCategorias.get(spinnerIconos.getSelectedItemPosition());
		categoria=new Categoria();
		//if(a�adir){
			
			categoria.setNombre(a);
			categoria.setCategoria(b);
			
			LugaresDb modificar=new LugaresDb(this);
			try{
			modificar.createCategoria(categoria);
			}catch(Exception error){
				Toast.makeText(this, "Imposible guardar los datos"+error.getStackTrace().toString(),Toast.LENGTH_LONG).show();
			}
			Toast.makeText(this, "Datos Guardados Correctamente", Toast.LENGTH_LONG).show() ;
			finish();
		//}
		/*else{
		LugaresDb guardar= new LugaresDb(this);//se crea un objeto de la base de datos para poder utilizar sus métodos.
		try{
		guardar.updateCategoria(categoria); //pasas el contenido de la categoria a ese objeto de BBDD
		}catch(Exception error){
			Toast.makeText(this, "Imposible guardar los datos"+error.getStackTrace().toString(), Toast.LENGTH_LONG).show();
		}
		Toast.makeText(this, "Datos Guardados Correctamente", Toast.LENGTH_LONG).show();
		finish();
		}*/
	}
	
	/*
	 * if(add){
		String a=editTextNombre.getText().toString();
		int b=(spinnerCategoria.getSelectedItemPosition());
		String c=editTextDireccion.getText().toString();
		String d=editTextTelefono.getText().toString();
		String e=editTextUrl.getText().toString();
		String f=editTextComentario.getText().toString();
		
		lugarEdit.setNombre(a);
		lugarEdit.setCategoria((Categoria)categoriasAdapter.getItem(b));
		lugarEdit.setDireccion(c);
		lugarEdit.setTelefono(d);
		lugarEdit.setUrl(e);
		lugarEdit.setComentario(f);
		
		LugaresDb modificar=new LugaresDb(this);
		try{
		modificar.createLugar(lugarEdit);
		}catch(Exception error){
			Toast.makeText(this, "Imposible guardar los datos"+error.getStackTrace().toString(),Toast.LENGTH_LONG).show();
		}
		Toast.makeText(this, "Datos Guardados Correctamente", Toast.LENGTH_LONG).show() ;
		finish();
	}
	else{
	LugaresDb guardar= new LugaresDb(this);//se crea un objeto de la base de datos para poder utilizar sus métodos.
	try{
	guardar.updateLugar(lugarEdit); //pasas el contenido del lugar a ese objeto de BBDD
	}catch(Exception error){
		Toast.makeText(this, "Imposible guardar los datos"+error.getStackTrace().toString(), Toast.LENGTH_LONG).show();
	}
	Toast.makeText(this, "Datos Guardados Correctamente", Toast.LENGTH_LONG).show();
	finish();
	}
	 * */

}

