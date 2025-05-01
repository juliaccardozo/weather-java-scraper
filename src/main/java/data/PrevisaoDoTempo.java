package data;

public class PrevisaoDoTempo {
    private String cidade;
    private String minima;
    private String maxima;
    private int dia;
    private String diaDaSemana;
    private String descricaoDoClima;

    public PrevisaoDoTempo() {
        this.cidade = "";
        this.minima = "";
        this.maxima = "";
        this.dia = 0;
        this.diaDaSemana = "";
        this.descricaoDoClima = "";
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMinima() {
        return minima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }

    public String getMaxima() {
        return maxima;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getDescricaoDoClima() {
        return descricaoDoClima;
    }

    public void setDescricaoDoClima(String descricaoDoClima) {
        this.descricaoDoClima = descricaoDoClima;
    }

    @Override
    public String toString() {
        return "Dia: " + dia + " (" + diaDaSemana + ")\n" +
                "Temperatura mínima: " + minima + "C\n" +
                "Temperatura máxima: " + maxima + "C\n" +
                "Descrição do clima: " + descricaoDoClima + "\n";
    }

}
