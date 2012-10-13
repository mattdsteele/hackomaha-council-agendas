package hackomaha;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AddressFinder {
    public static void main(String[] args) throws Exception {
        FileInputStream location = new FileInputStream("resources/en-ner-location.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(location);
        NameFinderME nameFinder = new NameFinderME(model);
        String[] tokens = {
                "Pierre", "Morgan", "is", "61", "yesars", "old", ".",
                "1500", "N", "49th", "St", ",", "Omaha", ",", "NE", "68104"};
        Span[] spans = nameFinder.find(tokens);
        for (Span span : spans) {
            System.out.println("Start: " + tokens[span.getStart()]);
            System.out.println("End: " + tokens[span.getEnd()]);
        }
    }
}
