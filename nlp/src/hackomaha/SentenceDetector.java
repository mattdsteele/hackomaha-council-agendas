package hackomaha;

import opennlp.tools.sentdetect.SentenceDetectorME;

public class SentenceDetector {
    private SentenceDetectorME detector;

    public SentenceDetector() {
        detector = new SentenceDetectorME(Builder.sentenceModel("resources/en-sent.bin"));
    }

    public String[] getSentences(String phrase) {
        return detector.sentDetect(phrase);
    }
}
