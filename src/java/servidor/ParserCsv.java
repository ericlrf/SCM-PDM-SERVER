package servidor;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Date;
import java.util.List;

/**
 * Classe Java responsavel por tratar os dados nos arquivos ".csv" baixados no
 * site do BCB
 */
public class ParserCsv {

    public static String json;
    private String filePathCotacao;
    private String filePathMoedas;
    private FileReader fileReaderCotacao;
    private FileReader fileReaderMoedas;
    private final CSVReader csvReaderCotacao;
    private final CSVReader csvReaderMoedas;
    private final List<String[]> allRowsCotacao;
    private final List<String[]> allRowsMoedas;

    /**
     * Construtor da classe, responsavel por inicializar o carregamento dos
     * arquivos ".csv"
     *
     * @throws java.io.FileNotFoundException
     */
    public ParserCsv() throws FileNotFoundException, IOException {
        atualizarCsv();
        abrirCsv();
        csvReaderCotacao = new CSVReader(fileReaderCotacao, ';', '"', 0);
        csvReaderMoedas = new CSVReader(fileReaderMoedas, ';', '"', 0);
        allRowsCotacao = csvReaderCotacao.readAll();
        allRowsMoedas = csvReaderMoedas.readAll();
        csvToJson();
    }

    /**
     * Metodo utiliza a data e hora do Sistema para carregar o arquivo com os
     * dados mais atualizado pelo PTAX
     */
    private void atualizarCsv() {
//        Date currentTime = new Date(System.currentTimeMillis());
//        String dataHoje = currentTime.getDate();
//        filePathCotacao = dataHoje.concat(".csv");
        filePathCotacao = "arquivosBCB/20151009.csv";
        filePathMoedas = "arquivosBCB/M20151013.csv";
    }

    private void abrirCsv() throws FileNotFoundException {
        this.fileReaderCotacao = new FileReader(filePathCotacao);
        this.fileReaderMoedas = new FileReader(filePathMoedas);
    }

    private void csvToJson() {
        json = "";
        for (String[] rowCotacao : allRowsCotacao) {
            for (String columnCotacao : rowCotacao) {
                json = json.concat(columnCotacao);
            }
        }
    }

    /**
     * metodo toString facultativo, usado apenas para testar localmente
     */
    private void csvToString() {
        String dadosCotacao = "";
        String dadosMoedas = "";
        for (String[] rowCotacao : allRowsCotacao) {
            for (String columnCotacao : rowCotacao) {
                dadosCotacao = dadosCotacao.concat(columnCotacao);
                dadosCotacao = dadosCotacao.concat("\n");
            }
            dadosCotacao = dadosCotacao.concat("----------\n");
        }
        for (String[] rowMoedas : allRowsMoedas) {
            for (String columnMoedas : rowMoedas) {
                dadosMoedas = dadosMoedas.concat(columnMoedas);
                dadosMoedas = dadosMoedas.concat("\n");
            }
            dadosMoedas = dadosMoedas.concat("----------\n");
        }
        System.out.print(dadosCotacao);
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
        System.out.print(dadosMoedas);
    }

    /**
     * metodo Main facultativo, usado apenas para testar localmente
     *
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ParserCsv parserCsv = new ParserCsv();
        parserCsv.csvToString();
//        System.out.println(ParserCsv.json);
    }
}
