package com.example.ana.projetoinicial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    private EditText editTextNome;
    private RadioGroup groupFuncao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        editTextNome = (EditText)findViewById(R.id.editTextNome);
        groupFuncao = (RadioGroup)findViewById(R.id.groupFuncao);
        recuperar();
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

    @Override
    protected void onPause(){
        super.onPause();
        persistir();
    }

    public void enviarDados(View view){

        Intent intent = new Intent(this, DicaActivity.class);
        intent.putExtra(DicaActivity.NOME,
                editTextNome.getText().toString());
        String nome = editTextNome.getText().toString();

        int id = groupFuncao.getCheckedRadioButtonId();
        if (nome.matches("")){
            Toast.makeText(this, R.string.mensagemValidaNome, Toast.LENGTH_SHORT).show();
        }else{
            if (id == -1) {
                Toast.makeText(this, R.string.mensagemValidaOpcao, Toast.LENGTH_SHORT).show();
            } else {
                intent.putExtra(DicaActivity.OCUPACAO, id);
                startActivity(intent);
            }
        }
    }

    public void limpar(View view) {
        editTextNome.setText(null);
        groupFuncao.clearCheck();
    }

    public void persistir(){
       SharedPreferences shared;
       shared = getSharedPreferences("dados", Context.MODE_PRIVATE);
       SharedPreferences.Editor editor = shared.edit();
        editor.putString("nome", editTextNome.getText().toString());
        editor.putInt("Ocupacao", groupFuncao.getCheckedRadioButtonId());
        editor.commit();
    }

    public void recuperar(){
        SharedPreferences shared;
        shared = getSharedPreferences("dados", Context.MODE_PRIVATE);
        editTextNome.setText(shared.getString("nome", ""));
        groupFuncao.check(shared.getInt("Ocupacao", -1));
    }
}
