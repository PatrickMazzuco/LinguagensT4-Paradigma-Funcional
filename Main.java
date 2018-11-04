import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //Metodo verifica se a string word pode ser verificada utilizando os fragmentos do array frags.
    private boolean verifWord(String word, String[] frags) {
        word = word.toLowerCase();
        word = removeAccent(word);
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
    public void readVerifyWrite(String wordsFile, String fragFile, String output) throws IOException {
        File words = new File(wordsFile);
        File frags = new File(fragFile);


        List<String> frg = new ArrayList<String>();
        String[] fragArray;

        BufferedReader wordsIn = new BufferedReader(new FileReader(words));
        BufferedReader fragsIn = new BufferedReader(new FileReader(frags));


        String in;
        while ((in = fragsIn.readLine()) != null) {
            frg.add(in);
        }
        fragArray = frg.toArray(new String[frg.size()]);
        fragsIn.close();

        File out = new File(words.getParent() + "\\" + output);
        BufferedWriter wordsOut = new BufferedWriter(new FileWriter(out));

        while ((in = wordsIn.readLine()) != null) {
            if (verifWord(in, fragArray)) {
                wordsOut.write(in + "\n");
            }
        }
        wordsIn.close();
        wordsOut.close();

    }


    //Metodo para remover o acento de palavras (todas letras minusculas)
    private String removeAccent(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if ((int) c[i] >= 224 && (int) c[i] <= 229) c[i] = 'a';
            else if ((int) c[i] >= 232 && (int) c[i] <= 235) c[i] = 'e';
            else if ((int) c[i] >= 236 && (int) c[i] <= 239) c[i] = 'i';
            else if ((int) c[i] >= 240 && (int) c[i] <= 246) c[i] = 'o';
            else if ((int) c[i] >= 249 && (int) c[i] <= 252) c[i] = 'u';
        }
        s = String.valueOf(c);
        return s;


    }
}