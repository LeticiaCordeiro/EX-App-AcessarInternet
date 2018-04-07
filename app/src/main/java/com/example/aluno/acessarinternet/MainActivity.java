package com.example.aluno.acessarinternet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button botao = (Button)findViewById(R.id.botaoNavegar);
        botao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText campoEndereco = (EditText)findViewById(R.id.campoEndereco);
        String endereco = campoEndereco.getText().toString();

        if(!endereco.startsWith("https://") && !endereco.startsWith("http://")){
            endereco = "http://" + endereco;
        }

        Uri u = Uri.parse(endereco);

        Intent intencao = new Intent(Intent.ACTION_VIEW,u);

        startActivity(intencao);
    }
}
