package scraper;

import data.PrevisaoDoTempo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Scraper {
    private static final String BASE_URL = "https://www.climatempo.com.br/previsao-do-tempo/15-dias/cidade/";

    public static List<PrevisaoDoTempo> extrairPrevisoes(int idCidade, String nomeCidade) {
        List<PrevisaoDoTempo> previsoes = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(BASE_URL + idCidade + "/" + nomeCidade).get();

            Element blocoPrincipal = doc.getElementById("first-block-of-days");

            Element tituloCidade = blocoPrincipal.selectFirst("h1");

            if (tituloCidade != null) {
                System.out.println(tituloCidade.text());

            } else {
                System.out.println("Título não encontrado!");
            }

            Elements divLista = doc.select("div[data-visualization-content=list]");
            Elements secoesDias = divLista.select("section.accordion-card");

            for (Element secao : secoesDias) {
                PrevisaoDoTempo previsaoDoTempo = new PrevisaoDoTempo();

                previsaoDoTempo.setCidade(tituloCidade.ownText().replaceFirst("^Previsão para 15 dias\\s*", ""));

                Element data = secao.selectFirst(".date-inside-circle");
                if (data != null) {
                    int numeroDia = Integer.parseInt(data.ownText().trim());
                    String diaSemana = data.selectFirst(".weekday").text();

                    previsaoDoTempo.setDia(numeroDia);
                    previsaoDoTempo.setDiaDaSemana(diaSemana);
                }

                Element imgMinima = secao.selectFirst("img[alt='Temperatura mínima']");
                if (imgMinima != null) {
                    Element spanMinima = imgMinima.parent().selectFirst("span");
                    if (spanMinima != null) {
                        previsaoDoTempo.setMinima(spanMinima.ownText().trim());
                    }
                }
                Element imgMaxima = secao.selectFirst("img[alt='Temperatura máxima']");
                if (imgMaxima != null) {
                    Element spanMaxima = imgMaxima.parent().selectFirst("span");
                    if (spanMaxima != null) {
                        previsaoDoTempo.setMaxima(spanMaxima.ownText().trim());
                    }
                }

                Element descricao = secao.selectFirst("p");
                previsaoDoTempo.setDescricaoDoClima(descricao.ownText().trim());
                previsoes.add(previsaoDoTempo);
            }

            return previsoes;
        } catch (Exception e) {
            System.out.println("Houve um erro!");
            System.out.println(e.getMessage());
        }

        return null;
    }
}
