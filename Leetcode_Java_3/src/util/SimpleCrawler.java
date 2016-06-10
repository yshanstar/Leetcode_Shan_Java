package util;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SimpleCrawler {
	private Queue<String> urlsNeedToParse;
	private Set<String> urlsParsed;

	public SimpleCrawler(String rootUrl) {
		this.urlsNeedToParse = new LinkedList<String>();
		this.urlsParsed = new HashSet<String>();
		init(rootUrl);
	}

	public void start() {
		while (!urlsNeedToParse.isEmpty()) {
			String url = this.urlsNeedToParse.poll();
			if (!urlsParsed.contains(url)) {
				crawl(url);
			}
		}
	}

	private void init(String rootUrl) {
		this.urlsNeedToParse.offer(rootUrl);
	}

	private void crawl(String url) {
		try {
			this.urlsParsed.add(url);
			Document doc = Jsoup.connect(url).get();

			if (doc.text().contains("research")) {
				System.out.println(url);
			}

			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if (link.attr("href").contains("mit.edu"))
					this.urlsNeedToParse.offer(link.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SimpleCrawler crawler = new SimpleCrawler("http://www.mit.edu/");
		crawler.start();
	}
}
