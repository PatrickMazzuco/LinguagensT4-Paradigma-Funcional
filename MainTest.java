import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void init() {
        main = new Main();
    }

    //O teste cria um arquivo com fragmentos e um com palavras, e as verifica.
    @org.junit.jupiter.api.Test
    void readVerifyWrite1() throws IOException {
        String[] words = {"casa", "carro", "mercado", "computador", "taco"};
        String[] frags = {"ca", "rro", "do", "me", "co", "s", "a", "ta"};

        //Cria novo arquivo de palavras
        File testWords = new File(System.getProperty("user.dir") + "\\testWords.txt");
        BufferedWriter bww = new BufferedWriter(new FileWriter(testWords));

        for (String s : words) {
            bww.write(s+"\n");
        }
        bww.close();


        //Cria novo arquivo de fragmentos
        File testFrags = new File(System.getProperty("user.dir") + "\\testFrags.txt");
        BufferedWriter bwf = new BufferedWriter(new FileWriter(testFrags));

        for (String s : frags) {
            bwf.write(s+"\n");
        }
        bwf.close();

        main.readVerifyWrite(testWords.getPath(), testFrags.getPath(), "testOutput.txt");

        File testOutput = new File(System.getProperty("user.dir") + "\\testOutput.txt");
        BufferedReader brt = new BufferedReader(new FileReader(testOutput));

        if (!brt.readLine().matches("casa") || !brt.readLine().matches("carro") || !brt.readLine().matches("taco")) {
            fail("");
        }
        testFrags.deleteOnExit();
        testWords.deleteOnExit();
        testOutput.delete();
    }

    //Nenhuma palavra verificavel
    @org.junit.jupiter.api.Test
    void readVerifyWrite2() throws IOException {
        String[] words = {"casa", "carro", "mercado", "computador", "taco"};
        String[] frags = {"cam", "ro", "do", "me", "co", "s", "a", "tar"};

        //Cria novo arquivo de palavras
        File testWords = new File(System.getProperty("user.dir") + "\\testWords.txt");
        BufferedWriter bww = new BufferedWriter(new FileWriter(testWords));

        for (String s : words) {
            bww.write(s+"\n");
        }
        bww.close();


        //Cria novo arquivo de fragmentos
        File testFrags = new File(System.getProperty("user.dir") + "\\testFrags.txt");
        BufferedWriter bwf = new BufferedWriter(new FileWriter(testFrags));

        for (String s : frags) {
            bwf.write(s+"\n");
        }
        bwf.close();

        main.readVerifyWrite(testWords.getPath(), testFrags.getPath(), "testOutput.txt");

        File testOutput = new File(System.getProperty("user.dir") + "\\testOutput.txt");
        BufferedReader brt = new BufferedReader(new FileReader(testOutput));

        if (brt.readLine() != null) {
            fail("");
        }
        testFrags.deleteOnExit();
        testWords.deleteOnExit();
        testOutput.delete();
    }

    //Contem palavra em branco.
    @org.junit.jupiter.api.Test
    void readVerifyWrite3() throws IOException {
        String[] words = {"", "casa", "carro", "mercado", "computador", "taco"};
        String[] frags = {"ca", "rro", "do", "me", "co", "s", "a", "ta"};

        //Cria novo arquivo de palavras
        File testWords = new File(System.getProperty("user.dir") + "\\testWords.txt");
        BufferedWriter bww = new BufferedWriter(new FileWriter(testWords));

        for (String s : words) {
            bww.write(s+"\n");
        }
        bww.close();


        //Cria novo arquivo de fragmentos
        File testFrags = new File(System.getProperty("user.dir") + "\\testFrags.txt");
        BufferedWriter bwf = new BufferedWriter(new FileWriter(testFrags));

        for (String s : frags) {
            bwf.write(s+"\n");
        }
        bwf.close();

        main.readVerifyWrite(testWords.getPath(), testFrags.getPath(), "testOutput.txt");

        File testOutput = new File(System.getProperty("user.dir") + "\\testOutput.txt");
        BufferedReader brt = new BufferedReader(new FileReader(testOutput));

        if (!brt.readLine().matches("") || !brt.readLine().matches("casa") || !brt.readLine().matches("carro")) {
            fail("");
        }
        testFrags.deleteOnExit();
        testWords.deleteOnExit();
        testOutput.delete();
    }

    //Contem mais de uma maneira de formar algumas palavras
    @org.junit.jupiter.api.Test
    void readVerifyWrite4() throws IOException {
        String[] words = {"casa", "carro", "mercado", "computador", "taco"};
        String[] frags = {"ca", "rro", "do", "me", "co", "s", "a", "ta", "c", "a", "r", "o"};

        //Cria novo arquivo de palavras
        File testWords = new File(System.getProperty("user.dir") + "\\testWords.txt");
        BufferedWriter bww = new BufferedWriter(new FileWriter(testWords));

        for (String s : words) {
            bww.write(s+"\n");
        }
        bww.close();


        //Cria novo arquivo de fragmentos
        File testFrags = new File(System.getProperty("user.dir") + "\\testFrags.txt");
        BufferedWriter bwf = new BufferedWriter(new FileWriter(testFrags));

        for (String s : frags) {
            bwf.write(s+"\n");
        }
        bwf.close();

        main.readVerifyWrite(testWords.getPath(), testFrags.getPath(), "testOutput.txt");

        File testOutput = new File(System.getProperty("user.dir") + "\\testOutput.txt");
        BufferedReader brt = new BufferedReader(new FileReader(testOutput));

        if (!brt.readLine().matches("casa") || !brt.readLine().matches("carro") || !brt.readLine().matches("mercado")) {
            fail("");
        }
        testFrags.deleteOnExit();
        testWords.deleteOnExit();
        testOutput.delete();
    }

    @org.junit.jupiter.api.Test
    void readVerifyWrite5() throws IOException {
        String[] words = {"você", "ginásio", "casa", "carro", "mercado", "computador", "taco"};
        String[] frags = {"ca", "rro", "do", "me", "co", "s", "a", "ta", "vo", "ce", "gin", "io"};

        //Cria novo arquivo de palavras
        File testWords = new File(System.getProperty("user.dir") + "\\testWords.txt");
        BufferedWriter bww = new BufferedWriter(new FileWriter(testWords));

        for (String s : words) {
            bww.write(s+"\n");
        }
        bww.close();


        //Cria novo arquivo de fragmentos
        File testFrags = new File(System.getProperty("user.dir") + "\\testFrags.txt");
        BufferedWriter bwf = new BufferedWriter(new FileWriter(testFrags));

        for (String s : frags) {
            bwf.write(s+"\n");
        }
        bwf.close();

        main.readVerifyWrite(testWords.getPath(), testFrags.getPath(), "testOutput.txt");

        File testOutput = new File(System.getProperty("user.dir") + "\\testOutput.txt");
        BufferedReader brt = new BufferedReader(new FileReader(testOutput));

        if (!brt.readLine().matches("você") || !brt.readLine().matches("ginásio") || !brt.readLine().matches("casa")) {
            fail("");
        }
        testFrags.deleteOnExit();
        testWords.deleteOnExit();
        testOutput.delete();
    }
}