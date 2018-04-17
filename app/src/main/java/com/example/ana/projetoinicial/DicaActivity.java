package com.example.ana.projetoinicial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DicaActivity extends AppCompatActivity {

    public static final String OCUPACAO = "OCUPACAO";
    public static final String NOME = "NOME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dica);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            String  nome        = bundle.getString(NOME, "");
            int     id          = bundle.getInt(OCUPACAO, -1);
            String saida  = "";
            switch(id){
                case R.id.radioEmpregado:
                    saida = getResources().getString(R.string.mensagem1);
                    break;
                case R.id.radioDesempregado:
                    saida = getResources().getString(R.string.mensagem2);
                    break;
                case R.id.radioProcura:
                    saida = getResources().getString(R.string.mensagem3);
                    break;
                    default:

            }
            TextView textMsg = findViewById(R.id.textMsg);
            textMsg.setText(saida + " " + nome + "!");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AjudaActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void voltar(View view){
        finish();
    }
}
