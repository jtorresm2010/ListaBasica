package com.example.juan.listabasica;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MiLista extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_lista);

        registrarEventos();

        ArrayList<String> myArrayList=
                new ArrayList<String>();
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.add("D");
        myArrayList.add("E");

        String[] myStringArray={"A","B","C"};
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(this,R.layout.mylayout,R.id.textView,myArrayList);

        ListView myList=
                (ListView) findViewById(R.id.miLista1);


        myList.setAdapter(myAdapter);

        myAdapter.add("new data");







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mi_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) findViewById(R.id.miLista);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                /// Obtiene el valor de la casilla elegida
                String itemSeleccionado = adapterView.getItemAtPosition(i).toString();

                // muestra un mensaje
                Toast.makeText(getApplicationContext(), "Haz hecho click en " + itemSeleccionado, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
