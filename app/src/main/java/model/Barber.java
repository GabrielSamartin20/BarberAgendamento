package model;

public class Barber {

        private String nome;
        private String especialidade;
        private int fotoId;

       
        public Barber(String nome, String especialidade, int fotoId) {
            this.nome = nome;
            this.especialidade = especialidade;
            this.fotoId = fotoId;
        }

    public String getNome() {

            return nome;
    }

    public void setNome(String nome) {

            this.nome = nome;
    }

    public String getEspecialidade() {

            return especialidade;
    }

    public void setEspecialidade(String especialidade) {

            this.especialidade = especialidade;
    }

    public int getFotoId() {
            return fotoId;
    }

    public void setFotoId(int fotoId) {
        this.fotoId = fotoId;
    }
}
