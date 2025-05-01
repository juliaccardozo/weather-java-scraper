import data.Cidade;
import data.PrevisaoDoTempo;
import scraper.Scraper;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Previsão do Tempo =====");
        System.out.println("Selecione a cidade:");
        System.out.println("1 - Pato Branco/PR");
        System.out.println("2 - Dois Vizinhos/PR");
        System.out.println("3 - São Paulo/SP");
        System.out.println("4 - Alfredo Chaves/ES");
        System.out.print("Digite o número da cidade: ");

        int opcao = sc.nextInt();
        sc.nextLine();

        Cidade cidade = Cidade.fromOpcao(opcao);

        if (cidade == null) {
            System.out.println("Opção inválida. Encerrando.");
            return;
        }

        System.out.println("Buscando previsão para: " + cidade + "...");

        List<PrevisaoDoTempo> previsoes = Scraper.extrairPrevisoes(cidade.getId(), cidade.getNome());

        for (PrevisaoDoTempo previsao : Objects.requireNonNull(previsoes)) {
            System.out.println(previsao.toString());
        }

        for (PrevisaoDoTempo previsao : Objects.requireNonNull(previsoes)) {
            ExportarCsv.salvar(previsao);
        }
        System.out.println("Um arquivo com essas previsões foi exportado!");

    }
}