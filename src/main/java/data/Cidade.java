package data;

public enum Cidade {
    PATO_BRANCO(1325, "patobranco-pr"),
    DOIS_VIZINHOS(1309, "doisvizinhos-pr"),
    ALFREDO_CHAVES(3367, "alfredochaves-es"),
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

    public static Cidade fromOpcao(int opcao) {
        return switch (opcao) {
            case 1 -> PATO_BRANCO;
            case 2 -> DOIS_VIZINHOS;
            case 3 -> SAO_PAULO;
            case 4 -> ALFREDO_CHAVES;
            default -> null;
        };
    }
}
