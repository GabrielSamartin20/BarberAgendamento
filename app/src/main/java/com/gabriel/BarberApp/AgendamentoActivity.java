package com.gabriel.BarberApp;


import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import Singleton.GerenciarDados;
import model.Agendamento;
import model.Barber;

public class AgendamentoActivity extends AppCompatActivity {
    private TextView tvBarbeiroSelecionado;
    private TextView tvDataSelecionada;
    private Button btnSelecionarData;
    private Button btnConfirmar;


    private Button botaoHoraSelecionado = null;
    private String dataFormatada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_agendamento);

        tvBarbeiroSelecionado = findViewById(R.id.tv_barbeiro_selecionado);
        tvDataSelecionada = findViewById(R.id.tv_data_selecionada);
        btnSelecionarData = findViewById(R.id.btn_selecionar_data);
        btnConfirmar = findViewById(R.id.btn_confirmar);


        carregarDadosDoSingleton();

        configurarSeletorDeData();

        configurarGridDeHorarios();


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Agendamento agendamento = GerenciarDados.getInstance().getAgendamentoAtual();

                if (agendamento.getData() == null || agendamento.getHora() == null) {
                    Toast.makeText(AgendamentoActivity.this, "Por favor, escolha data E horário.", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(AgendamentoActivity.this, "Pronto para confirmar!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }



    private void carregarDadosDoSingleton() {
        Agendamento agendamento = GerenciarDados.getInstance().getAgendamentoAtual();
        Barber barbeiro = agendamento.getBarbeiro();
        if (barbeiro != null) {
            tvBarbeiroSelecionado.setText("Profissional: " + barbeiro.getNome());
        }
    }

    private void configurarSeletorDeData() {
        btnSelecionarData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendario = Calendar.getInstance();
                int ano = calendario.get(Calendar.YEAR);
                int mes = calendario.get(Calendar.MONTH);
                int dia = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AgendamentoActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int anoSelecionado, int mesSelecionado, int diaSelecionado) {
                                dataFormatada = diaSelecionado + "/" + (mesSelecionado + 1) + "/" + anoSelecionado;


                                GerenciarDados.getInstance().getAgendamentoAtual().setData(dataFormatada);


                                tvDataSelecionada.setText("Data escolhida: " + dataFormatada);
                            }
                        }, ano, mes, dia);


                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });
    }

    private void configurarGridDeHorarios() {

        Button btn9 = findViewById(R.id.btn_horario_1);
        Button btn10 = findViewById(R.id.btn_horario_2);
        Button btn11 = findViewById(R.id.btn_horario_3);
        Button btn14 = findViewById(R.id.btn_horario_4);
        Button btn15 = findViewById(R.id.btn_horario_5);
        Button btn16 = findViewById(R.id.btn_horario_6);


        View.OnClickListener listenerHorario = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button btnClicado = (Button) v;

                String hora = btnClicado.getText().toString();

               GerenciarDados.getInstance().getAgendamentoAtual().setHora(hora);


                if (botaoHoraSelecionado != null) {

                    botaoHoraSelecionado.setBackgroundColor(Color.parseColor("#FF6200EE"));
                }

                btnClicado.setBackgroundColor(Color.parseColor("#FF4CAF50"));


                botaoHoraSelecionado = btnClicado;
            }
        };


        btn9.setOnClickListener(listenerHorario);
        btn10.setOnClickListener(listenerHorario);
        btn11.setOnClickListener(listenerHorario);
        btn14.setOnClickListener(listenerHorario);
        btn15.setOnClickListener(listenerHorario);
        btn16.setOnClickListener(listenerHorario);
    }
}