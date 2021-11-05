package recursive_problems;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int n = 9;

        System.out.println(Language.count(n));

        try {
            Set<String> possibleWords = Language.validWords(n);
            for (String word : possibleWords) {
                System.out.printf("%s, ", word);
            }

        } catch (TooManyWordsException tmwe) {
            System.out.println(tmwe);
        }

    }

}

