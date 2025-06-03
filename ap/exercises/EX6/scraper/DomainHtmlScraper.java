package ap.exercises.EX6.scraper;

import ap.exercises.EX6.scraper.fetcher.HtmlFetcher;
import ap.exercises.EX6.scraper.parser.HtmlParser;
import ap.exercises.EX6.scraper.store.HtmlFileManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//public class DomainHtmlScraper {
//    private String domainAddress;
//    private Queue<String> queue;
//
//    private HtmlFileManager htmlFileManager;
//
//    public DomainHtmlScraper(String domainAddress, String savePath) {
//        this.domainAddress = domainAddress;
//        this.queue = new LinkedList<>();
//        this.htmlFileManager=new HtmlFileManager(savePath);
//    }

//    public void start() throws IOException {
//        List<String> htmlLines = HtmlFetcher.fetchHtml(domainAddress);
//        this.htmlFileManager.save(htmlLines);
//
//        List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
//        queue.addAll(new HashSet<>(urls));
//        int counter=1;
//
//        while (!queue.isEmpty()){
//            String url = queue.remove();
//            counter++;
//            try {
//                htmlLines = HtmlFetcher.fetchHtml(domainAddress);
//                this.htmlFileManager.save(htmlLines);
//
//                urls = HtmlParser.getAllUrlsFromList(htmlLines);
//                queue.addAll(new HashSet<>(urls));
//            }
//            catch (Exception e){
//                System.out.println("ERROR: "+url+"\t -> "+e.getMessage());
//            }
//            System.out.println("["+counter+"] "+url+" fetch and saved (queue size:"+queue.size()+").");
//        }
//        System.out.println("Operation complete");
//    }
public class DomainHtmlScraper {
    private String domainAddress;
    private Queue<String> queue;
    private Set<String> visitedUrls;
    private HtmlFileManager htmlFileManager;
    private PrintWriter imageLinkWriter;

    public DomainHtmlScraper(String domainAddress, String savePath) throws IOException {
        this.domainAddress = domainAddress;
        this.queue = new LinkedList<>();
        this.visitedUrls = new HashSet<>();
        this.htmlFileManager = new HtmlFileManager(savePath);
        this.imageLinkWriter = new PrintWriter("image_links.txt"); // فایل خروجی لینک تصاویر
    }

    public void start() throws IOException {
        fetchAndSave(domainAddress);

        while (!queue.isEmpty()) {
            String url = queue.remove();
            if (visitedUrls.contains(url)) continue;

            visitedUrls.add(url);
            fetchAndSave(url);
        }

        imageLinkWriter.close();
        System.out.println("Operation complete");
    }

    private void fetchAndSave(String url) {
        try {
            List<String> htmlLines = HtmlFetcher.fetchHtml(url);
            htmlFileManager.save(htmlLines);

            List<String> imageUrls = HtmlParser.getImageUrlsFromHtmlLines(htmlLines);
            for (String imageUrl : imageUrls) {
                imageLinkWriter.println(imageUrl);
            }

            List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
            for (String newUrl : urls) {
                if (!visitedUrls.contains(newUrl)) {
                    queue.add(newUrl);
                }
            }

            System.out.println("Fetched: " + url + " (queue size: " + queue.size() + ")");
        } catch (Exception e) {
            System.out.println("ERROR: " + url + "\t -> " + e.getMessage());
        }
    }
}


