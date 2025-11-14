package Singleton;

import com.gabriel.BarberApp.AgendamentoActivity;
import model.Agendamento;

public class GerenciarDados {

    private static GerenciarDados instance = null;
    private Agendamento agendamentoAtual;

    private GerenciarDados() {
        agendamentoAtual = new Agendamento();
    }

    public static GerenciarDados getInstance() {
        if (instance == null) {
            instance = new GerenciarDados();
        }
        return instance;
    }


    public Agendamento getAgendamentoAtual() {
        return agendamentoAtual;
    }


}