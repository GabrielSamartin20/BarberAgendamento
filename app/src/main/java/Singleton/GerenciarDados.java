package Singleton;

public class GerenciarDados {

        private static GerenciarDados instance = null;


        private String nomeDoBarbeiro;
        private String dataSelecionada;
        private String horaSelecionada;


        private GerenciarDados() {

        }

        public static GerenciarDados getInstance() {
            if (instance == null) {
                instance = new GerenciarDados();
            }
            return instance;
        }


        public String getNomeDoBarbeiro() {
            return nomeDoBarbeiro;
        }

        public void setNomeDoBarbeiro(String nomeDoBarbeiro) {
            this.nomeDoBarbeiro = nomeDoBarbeiro;
        }

        public String getDataSelecionada() {
            return dataSelecionada;
        }

        public void setDataSelecionada(String dataSelecionada) {
            this.dataSelecionada = dataSelecionada;
        }

        public String getHoraSelecionada() {
            return horaSelecionada;
        }

        public void setHoraSelecionada(String horaSelecionada) {
            this.horaSelecionada = horaSelecionada;
        }
    }

