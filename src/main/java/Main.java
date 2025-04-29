import data.Cidade;
import data.PrevisaoDoTempo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import scraper.Scraper;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        List<PrevisaoDoTempo> previsoes = Scraper.extrairPrevisoes(Cidade.PATO_BRANCO.getId(), Cidade.PATO_BRANCO.getNome());

        for (PrevisaoDoTempo previsao : Objects.requireNonNull(previsoes)) {
            System.out.println(previsao.toString());
        }
    }
}