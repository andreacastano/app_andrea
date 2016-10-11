package com.yolimaandrea.app_andrea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private String nombre,correo;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== R.id.menu_Perfil){
            Intent intent=new Intent( MainActivity.this, PerfilActivity.class );
            intent.putExtra("nombre",nombre);
            intent.putExtra("correo",correo);
            startActivity( intent );
        }

        return super.onOptionsItemSelected( item );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras=getIntent().getExtras();
        nombre= extras.getString("nombre");
        correo= extras.getString("email");

    }
}
