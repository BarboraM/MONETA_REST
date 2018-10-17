package moneta.uloha.rest;

import org.springframework.stereotype.Service;

@Service
public class RestService {

    public String transform(String text) {

        text = text.replaceAll("\\s{2,}", " ");

        char[] textChars = text.toCharArray();

        int[] pattern = createPattern(textChars);

        char[] revTextChars = reverseLetters(textChars);

        revTextChars = applyPattern(revTextChars, pattern);

        String result = String.valueOf(revTextChars);
        return result;
    }

    char[] applyPattern(char[] textChars, int[] pattern){
        for (int i = 0; i < textChars.length; i++) {
            if(pattern[i] == 1){
                textChars[i] = Character.toUpperCase(textChars[i]);
            } else {
                textChars[i] = Character.toLowerCase(textChars[i]);
            }
        }
        return textChars;
    }

    char[] reverseLetters(char[] textChars) {
        char[] revTextChars = new char[textChars.length];

        char letter;
        for(int i = 0; i< textChars.length; i++) {
            letter = textChars[i];
            revTextChars[revTextChars.length-1-i] = letter;
        }
        return revTextChars;
    }

    int[] createPattern(char[] textChars){
        char letter;
        int[] pattern = new int[textChars.length];
        for (int i = 0; i < textChars.length; i++) {
            letter = textChars[i];
            if(checkVowel(letter)) {
                pattern[i] = 1;
            } else {
                pattern[i] = 0;
            }
        }
        return pattern;
    }

    private boolean checkVowel(char letter){
        boolean isVowel = false;
        String vowelList = "AEIOUaeiouáéíóúůě";
        if(vowelList.indexOf(letter) != -1) {
            isVowel = true;
        }
        return isVowel;
    }
}

