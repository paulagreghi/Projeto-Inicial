package com.example.ana.projetoinicial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AjudaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        TextView textAluno = (TextView) findViewById(R.id.textViewAluno);
        TextView textRa = (TextView) findViewById(R.id.textViewRa);
        TextView textCurso = (TextView) findViewById(R.id.textViewCurso);

    }

    public void voltar(View view){
        finish();
    }
}
