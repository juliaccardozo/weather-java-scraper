package data;

public enum Cidade {
    PATO_BRANCO(1325, "patobranco-pr"),
    SAO_PAULO(558, "saopaulo-sp");

    private int id;
    private String nome;

    Cidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
