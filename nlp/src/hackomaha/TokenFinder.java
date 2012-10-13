package hackomaha;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.util.*;

public class TokenFinder {
    private final NameFinderME nameFinder;
    private SentenceDetector sentenceDetector;

    private TokenFinder(TokenNameFinderModel model) {
        nameFinder = new NameFinderME(model);
        sentenceDetector = new SentenceDetector();
    }

    @Deprecated
    public Set<String> findNames(String phrase) throws Exception {
        HashSet<String> names = new HashSet<String>();
        for (String sentence : sentenceDetector.getSentences(phrase)) {
            handleSentence(names, sentence);
        }
        return names;
    }

    private void handleSentence(HashSet<String> names, String sentence) {
        String[] words = sentence.split(" ");
        Span[] spans = nameFinder.find(words);
        for (Span span : spans) {
            names.add(addPhrase(words, span));
        }
    }

    private String addPhrase(String[] words, Span span) {
        String val = "";
        for (int i = span.getStart(); i < span.getEnd(); i++) {
            val += words[i] + " " ;
        }
        return val.trim();
    }

    public static TokenFinder nameFinder() {
        return new TokenFinder(Builder.tokenNameFinderModel("resources/en-ner-person.bin"));
    }

    public static TokenFinder orgFinder() {
        return new TokenFinder(Builder.tokenNameFinderModel("resources/en-ner-organization.bin"));
    }
}
