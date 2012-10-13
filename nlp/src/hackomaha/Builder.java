package hackomaha;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.sentdetect.SentenceModel;

public class Builder {

	private static InputStream inputStream = null;

	public static POSModel posModel(String filepath) {
		try {
			inputStream = new FileInputStream("resources/en-pos-maxent.bin");
			return new POSModel(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Checked exceptions blow", e);
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
			throw new RuntimeException("Checked exceptions blow", e);
		} finally {
			closeIfNeeded();
		}
	}

	public static SentenceModel sentenceModel(String filepath) {
		try {
			inputStream = new FileInputStream(filepath);
			return new SentenceModel(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Checked exceptions blow", e);
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
