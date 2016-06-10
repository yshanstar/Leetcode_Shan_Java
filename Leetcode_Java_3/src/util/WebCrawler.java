package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {
	public static void main(String a[]) {
		System.out.println("Starting Main Thread...");
		MyCrawler myCrawler = new MyCrawler("http://www.mit.edu/");
		Thread t1 = new Thread(myCrawler);
		Thread t2 = new Thread(myCrawler);
		t1.start();
		t2.start();
		System.out.println("End of Main Thread...");
	}
}

class MyCrawler implements Runnable {

	private static Queue<String> taskTable;
	private static Set<String> pageTable;
	private static String rootUrl;

	public MyCrawler(String url) {
		MyCrawler.rootUrl = url;
		MyCrawler.taskTable = new LinkedList<String>();
		MyCrawler.pageTable = new HashSet<String>();

		MyCrawler.taskTable.add(rootUrl);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			String task = null;
			synchronized (taskTable) {
				if (!taskTable.isEmpty()) {
					task = taskTable.poll();
				}
			}

			if (task == null || task.isEmpty()) {
				try {
					System.out.println("No Activate task, Sleep");
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Thread: " + Thread.currentThread().getId() + " with: " + task);

				boolean processed = false;
				synchronized (pageTable) {
					processed = !pageTable.add(task);
				}

				if (!processed) {
					List<String> taskList = crawl(task);

					// wait for 1 second for task to crawl the webpage to avoid
					// bind
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}

					if (taskList.size() != 0) {
						synchronized (taskTable) {
							taskTable.addAll(taskList);
						}
					}
				}
			}
		}
	}

	private List<String> crawl(String url) {
		List<String> taskLists = new ArrayList<String>();
		try {

			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if (link.attr("href").contains("mit.edu"))
					taskLists.add(link.attr("abs:href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return taskLists;
	}
}
