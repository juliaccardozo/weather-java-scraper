package scraper;

import data.Cidade;
import data.PrevisaoDoTempo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScraperTest {

    @Test
    @DisplayName("Testando busca de dados do Scraper")
    public void testextrairPrevisoes() throws IOException {
        Path path = Paths.get("src/test/resources/mock");
        String htmlMock = Files.readString(path);
        Document doc = Jsoup.parse(htmlMock);

        List<PrevisaoDoTempo> previsoes = Scraper.extrairPrevisoes(Cidade.PATO_BRANCO.getId(), Cidade.PATO_BRANCO.getNome());

        assertNotNull(previsoes);
        assertEquals(15, previsoes.size());

        PrevisaoDoTempo p = previsoes.get(0);
        assertEquals("Pato Branco - PR", p.getCidade());
        assertEquals(1, p.getDia());
        assertEquals("qui", p.getDiaDaSemana());
        assertEquals("12°", p.getMinima());
        assertEquals("23°", p.getMaxima());
        assertEquals("A previsão do tempo para quinta-feira é de Dia ensolarado, com nevoeiro ao amanhecer. As nuvens aumentam à noite.", p.getDescricaoDoClima());

    }
}
