package com.gabriel.BarberApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import Singleton.GerenciarDados;
import model.Agendamento;

public class ConfirmacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        TextView tvProfissional = findViewById(R.id.tv_resumo_profissional);
        TextView tvData = findViewById(R.id.tv_resumo_data);
        TextView tvHora = findViewById(R.id.tv_resumo_hora);
        TextView tvPreco = findViewById(R.id.tv_resumo_preco);
        Button btnVoltar = findViewById(R.id.btn_voltar_inicio);


        Agendamento agendamento = GerenciarDados.getInstance().getAgendamentoAtual();


        if (agendamento != null) {
            tvProfissional.setText("Profissional: " + agendamento.getBarbeiro().getNome());
            tvData.setText("Data: " + agendamento.getData());
            tvHora.setText("Hora: " + agendamento.getHora());


            String precoFinal = String.format("Preço: R$ %.2f", agendamento.calcularPrecoFinal());
            tvPreco.setText(precoFinal);
        }


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GerenciarDados.getInstance().resetarAgendamento();


                Intent intent = new Intent(ConfirmacaoActivity.this, MainActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}