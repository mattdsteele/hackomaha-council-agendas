package hackomaha;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Builder {
	private static String EXCEPTION_MESSAGE = "Checked exceptions blow";
	private static InputStream inputStream = null;

	public static POSModel posModel(String filepath) {
		try {
			inputStream = new FileInputStream("resources/en-pos-maxent.bin");
			return new POSModel(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		} finally {
			closeIfNeeded();
		}
	}

	public static TokenNameFinderModel tokenNameFinderModel(String filepath) {
		try {
			inputStream = new FileInputStream(filepath);
			return new TokenNameFinderModel(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		} finally {
			closeIfNeeded();
		}
	}

	public static NameFinderME nameFinder() {
		return new NameFinderME(
				Builder.tokenNameFinderModel("resources/en-ner-person.bin"));
	}

	public static NameFinderME orgFinder() {
		return new NameFinderME(
				Builder.tokenNameFinderModel("resources/en-ner-organization.bin"));
	}

	public static SentenceModel sentenceModel(String filepath) {
		try {
			inputStream = new FileInputStream(filepath);
			return new SentenceModel(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		} finally {
			closeIfNeeded();
		}
	}

	public static SentenceDetectorME sentenceDetector() {
		return new SentenceDetectorME(
				Builder.sentenceModel("resources/en-sent.bin"));
	}

	public static TokenizerME tokenizer() {
		return new TokenizerME(Builder.tokenizerModel("resources/en-token.bin"));
	}

	public static TokenizerModel tokenizerModel(String filepath) {
		try {
			inputStream = new FileInputStream(filepath);
			return new TokenizerModel(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		} finally {
			closeIfNeeded();
		}
	}

	private static void closeIfNeeded() {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
			}
		}
	}

}
