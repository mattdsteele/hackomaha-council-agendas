package hackomaha;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.util.*;

public class NameFinder {
    private final NameFinderME nameFinder;

    public NameFinder() {
        TokenNameFinderModel model = Builder.tokenNameFinderModel("resources/en-ner-person.bin");
        nameFinder = new NameFinderME(model);
    }

    public Set<String> findNames(String[] sentence) throws Exception {
        HashSet<String> names = new HashSet<String>();
        Span[] spans = nameFinder.find(sentence);
        for (Span span : spans) {
            String val = "";
            for (int i = span.getStart(); i < span.getEnd(); i++) {
                val += sentence[i] + " " ;
            }
            names.add(val.trim());
        }
        return names;
    }
}
