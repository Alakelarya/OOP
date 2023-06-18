package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;


public class Translation {

    public static ArrayList<String> readSentenceForTranslate(String sentence) {
        ArrayList<String> sentenceForTranslate = new ArrayList<>();
        String[] words = sentence.split("[\s\\p{Punct}]");
        for (int i = 0; i < words.length; i++) {

            sentenceForTranslate.add(words[i]);
        }
        return sentenceForTranslate;
    }

    public static HashMap<String, String> readDictionary(String path) {

        HashMap<String, String> dictionary = new LinkedHashMap<>();
        Pattern pattern1 = Pattern.compile(".+?(?=\\|)");
        Pattern pattern2 = Pattern.compile("(?<=\\|).*");

        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                dictionary.put(scanner.findWithinHorizon(pattern1, 72), scanner.findWithinHorizon(pattern2, 72));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't read!");
        }

        return dictionary;
    }

    public static ArrayList<String> translateSentence(ArrayList<String> sentence, HashMap<String, String> dictionary) {

        ArrayList<String> translation = new ArrayList<>(sentence.size());
        for (int i = 0; i < sentence.size(); i++) translation.add(null);

        translation = findExpression(sentence, dictionary, translation);
        for (int i = 0; i < sentence.size(); i++) {

            String temp = sentence.get(i);
            temp = temp.toLowerCase();

            if (sentence.get(i) == " ") {
                continue;
            } else if (dictionary.get(temp) == null) {
                translation.set(i, temp);
            } else if (dictionary.get(temp).contains(",")) {
                temp = findWordLonger(dictionary.get(temp));
                translation.set(i, temp);
            } else {
                translation.set(i, dictionary.get(temp));
            }

        }

        for (int i = 0; i < translation.size(); i++) translation.removeIf(n -> (n == null | n == " "));

        return translation;
    }

    static ArrayList<String> findExpression(ArrayList<String> sentence, HashMap<String, String> dictionary, ArrayList<String> translation) {
        String temp;
        for (int i = 0; i < translation.size() - 1; i++) {
            temp = (sentence.get(i) + " " + sentence.get(i + 1));
            if (dictionary.get(temp) != null) {
                translation.set(sentence.indexOf(sentence.get(i)), dictionary.get(temp));
                sentence.set(i, " ");
                sentence.set(i + 1, " ");
            }
        }
        return translation;
    }


    static String findWordLonger(String translation) {
        int len = 0;
        String[] words = translation.split(",");
        for (int i = 0; i < words.length; i++) {
            if (len < words[i].length()) {
                translation = words[i];
            }
        }
        return translation;
    }
}
