package recursive_problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Language {

    // Solving the AABBB Language problem, where a language is made up of words consisting
    // only of two symbols: "aa" and "bbb".

    // Using recursion to determine the number of possible words of a given length, and all
    // the possible words of a given length in this language.

    public static int count(int n) {
        if (n < 2) {return 0;}
        else if (n == 2) {return 1;}
        else if (n == 3) {return 1;}

        return count(n - 2) + count(n - 3);
    }

    public static Set<String> validWords(int n) throws TooManyWordsException {
        if (n < 2) {return new HashSet<String>();}
        else if (n == 2) {return new HashSet<String>(List.of(new String[]{"aa"}));}
        else if (n == 3) {return new HashSet<String>(List.of(new String[]{"bbb"}));}
        else if (n > 30) {throw new TooManyWordsException("Too many possible words.");}

        Set<String> n_2 = validWords(n - 2);
        Set<String> n_3 = validWords(n - 3);

        Set<String> combinedSet = new HashSet<>();

        for (String word: n_2) {
            combinedSet.add(word + "aa");
        }

        for (String word: n_3) {
            combinedSet.add(word + "bbb");
        }

        return combinedSet;
    }
}
