package model;

public class Agendamento {
    private Barber barbeiro;
    private String data;
    private String hora;
    private double precoBase = 35.00;


    public double calcularPrecoFinal() {
        if (barbeiro != null) {
            if (barbeiro.getNome().contains("Rafael")) {
                return 50.00;
            }
        }
        return precoBase;
    }


    public void setBarbeiro(Barber barbeiro) {
        this.barbeiro = barbeiro;
    }
    public Barber getBarbeiro() {
        return barbeiro;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getHora() {
        return hora;
    }
}
