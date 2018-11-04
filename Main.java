import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //private String[] words = {"casa", "asa", "bolsa", "carro", "caco", "caça", "acaso", "rosa", "morro", "caso", "CARRO"};
    //private String[] frags = {"a", "a", "c", "s", "ca", "sa", "r", "rro", "bol", "o"};

    //Metodo verifica se a string word pode ser verificada utilizando os fragmentos do array frags.
    public boolean verifWord(String word, String[] frags) {
        word = word.toLowerCase();
        String frag;
        for (int i = 0; i < frags.length; i++) {
            frag = frags[i];
            if (word.length() != 0) {
                if (word.startsWith(frag)) {
                    if (verifWord(word.substring(frag.length()), frags)) return true;
                }
            } else return true;
        }
        return false;
    }

    //
    public void readVerifyWrite(String wordsFile, String fragFile, String output) throws IOException{
        File words = new File(wordsFile);
        File frags = new File(fragFile);
        File out = new File(words.getParent() + "\\output.txt");

        List<String> frg = new ArrayList<String>();
        String[] fragArray;

        BufferedReader wordsIn = new BufferedReader(new FileReader(words));
        BufferedReader fragsIn = new BufferedReader(new FileReader(frags));
        BufferedWriter wordsOut = new BufferedWriter(new FileWriter(out));

        String in;
        while ((in = fragsIn.readLine()) != null) {
            frg.add(in);
        }
        fragArray = frg.toArray(new String[frg.size()]);
        fragsIn.close();

        while ((in = wordsIn.readLine()) != null) {
            if (verifWord(in, fragArray)) {
                wordsOut.write(in + "\n");
            }
        }
        wordsIn.close();
        wordsOut.close();

    }

}
