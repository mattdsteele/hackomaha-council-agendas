package hackomaha;

import opennlp.tools.sentdetect.SentenceDetectorME;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SentenceDetectorTest {

    @Test()
    public void testSentence() {
        String phrase = " This is the first sentence. This, however, is the second sentence! And the third? ";
        String[] sentences = new SentenceDetector().getSentences(phrase);

        assertEquals(3, sentences.length);
        assertEquals(sentences[0], "This is the first sentence.");
        assertEquals(sentences[1], "This, however, is the second sentence!");
        assertEquals(sentences[2], "And the third?");
    }
}
