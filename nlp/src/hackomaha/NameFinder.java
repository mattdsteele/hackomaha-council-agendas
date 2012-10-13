package hackomaha;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.util.*;

public class NameFinder {
    public Set<String> findNames(String[] tokens) throws Exception {
        HashSet<String> names = new HashSet<String>();
        TokenNameFinderModel model = Builder.tokenNameFinderModel("resources/en-ner-person.bin");
        NameFinderME nameFinder = new NameFinderME(model);
        Span[] spans = nameFinder.find(tokens);
        for (Span span : spans) {
            String val = "";
            for (int i = span.getStart(); i < span.getEnd(); i++) {
                val += tokens[i] + " " ;
            }
            names.add(val.trim());
        }
        return names;
    }
}
