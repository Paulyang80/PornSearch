import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

public class WordCounter {
	private String urlStr;
	private String content;

	public WordCounter(String urlStr) {
		this.urlStr = "http://www.google.com/search?q="+urlStr+"&oe=utf8&num=10";
	}

	private String fetchContent() throws IOException {

		String retVal = "";

		URL u = new URL(urlStr);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);

		String line = null;

		while ((line = bufReader.readLine()) != null) {

			retVal = retVal + line + "\n";

		}

		return retVal;

	}

	public int countKeyword(String keyword) throws IOException {
		if (content == null) {
			content = fetchContent();
		}

		// To do a case-insensitive search, we turn the whole content and keyword into
		// upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();

		int retVal = 0;
		// Calculates appearances of keyword
		int position = content.indexOf(keyword);

		while (position != -1) {
			retVal++;
			position = content.indexOf(keyword, position + 1);
		}

		return retVal;
	}

}