import data.PrevisaoDoTempo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportarCsv {
    private static final String FILE_PATH = "previsoes.csv";

    public static void salvar(PrevisaoDoTempo previsao) {
        boolean arquivoExiste = new File(FILE_PATH).exists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            if (!arquivoExiste) {
                writer.println("Cidade,Data,Temperatura Mínima,Temperatura Máxima,Descricao");
            }

            writer.printf("%s,%d,%s,%s,%s %n",
                    previsao.getCidade(),
                    previsao.getDia(),
                    previsao.getMinima(),
                    previsao.getMaxima(),
                    previsao.getDescricaoDoClima());

        } catch (IOException e) {
            System.out.println("Erro ao salvar no CSV: " + e.getMessage());
        }
    }
}
