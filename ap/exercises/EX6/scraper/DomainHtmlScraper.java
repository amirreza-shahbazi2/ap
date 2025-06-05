package ap.exercises.EX6.scraper;

import ap.exercises.EX6.scraper.fetcher.HtmlFetcher;
import ap.exercises.EX6.scraper.parser.HtmlParser;
import ap.exercises.EX6.scraper.store.HtmlFileManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
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
//        this.htmlFileManager = new HtmlFileManager(savePath);
//    }
//
//    public void start() throws IOException {
//        List<String> htmlLines = HtmlFetcher.fetchHtml(domainAddress);
//        this.htmlFileManager.save(htmlLines);
//
//        List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
//        queue.addAll(new HashSet<>(urls));
//        int counter = 1;
//
//        while (!queue.isEmpty()) {
//            String url = queue.remove();
//            counter++;
//            try {
//                htmlLines = HtmlFetcher.fetchHtml(domainAddress);
//                this.htmlFileManager.save(htmlLines);
//
//                urls = HtmlParser.getAllUrlsFromList(htmlLines);
//                queue.addAll(new HashSet<>(urls));
//            } catch (Exception e) {
//                System.out.println("ERROR: " + url + "\t -> " + e.getMessage());
//            }
//            System.out.println("[" + counter + "] " + url + " fetch and saved (queue size:" + queue.size() + ").");
//        }
//        System.out.println("Operation complete");
//    }
//}
public class DomainHtmlScraper {
    private String domainAddress;
    private String domainHost;
    private Queue<String> queue;
    private Set<String> visitedUrls;
    private PrintWriter imageLinkWriter;
    private String saveDirectory;

    public DomainHtmlScraper(String domainAddress, String saveDirectory) throws IOException {
        this.domainAddress = domainAddress;
        this.saveDirectory = saveDirectory;
        this.queue = new LinkedList<>();
        this.visitedUrls = new HashSet<>();
        this.imageLinkWriter = new PrintWriter(Path.of(saveDirectory, "image_links.txt").toString());


        URL urlObj = new URL(domainAddress);
        this.domainHost = urlObj.getHost().toLowerCase();
    }

    public void start() throws IOException {
        enqueueUrl(domainAddress);

        while (!queue.isEmpty()) {
            String currentUrl = queue.remove();
            if (visitedUrls.contains(currentUrl)) continue;
            visitedUrls.add(currentUrl);

            fetchAndSave(currentUrl);
        }

        imageLinkWriter.close();
        System.out.println("Operation complete");
    }

    private void enqueueUrl(String rawUrl) {
        try {
            URL normalized = normalizeUrl(rawUrl);
            if (normalized != null) {
                String urlStr = normalized.toString();
                if (isSameDomain(normalized.getHost())) {
                    queue.add(urlStr);
                }
            }
        } catch (MalformedURLException e) {
        }
    }

    private boolean isSameDomain(String host) {

        host = host.toLowerCase();
        return host.equals(domainHost) || host.endsWith("." + domainHost);
    }

    private URL normalizeUrl(String rawUrl) throws MalformedURLException {
        URL url = new URL(domainAddress);
        return new URL(url, rawUrl);
    }

    private void fetchAndSave(String pageUrl) {
        try {
            System.out.println("Going to fetch " + pageUrl + " ...");
            List<String> htmlLines = HtmlFetcher.fetchHtml(pageUrl);

            saveHtmlToFile(pageUrl, htmlLines);
            List<String> imageUrls = HtmlParser.getImageUrlsFromHtmlLines(htmlLines);
            for (String img : imageUrls) {
                imageLinkWriter.println(img);
            }

            List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
            for (String raw : urls) {
                enqueueUrl(raw);
            }

            System.out.println("Fetched & saved: " + pageUrl + " (queue size: " + queue.size() + ")");
        } catch (Exception e) {
            System.out.println("ERROR fetching " + pageUrl + " -> " + e.getMessage());
        }
    }

    private void saveHtmlToFile(String pageUrl, List<String> htmlLines) {
        try {
            URL urlObj = new URL(pageUrl);
            String host = urlObj.getHost().toLowerCase();
            String path = urlObj.getPath();

            String subfolder = "";
            if (!host.equals(domainHost)) {

                String subdomainPart = host.substring(0, host.length() - domainHost.length() - 1);
                subfolder = "_" + subdomainPart;
            }

            String[] segments = path.split("/");
            List<String> pathFolders = new ArrayList<>();
            String fileName = "index.html";
            if (segments.length > 0) {
                for (int i = 1; i < segments.length; i++) {
                    if (i == segments.length - 1) {

                        if (!segments[i].isBlank()) {
                            fileName = segments[i];
                        }
                    } else {

                        if (!segments[i].isBlank()) {
                            pathFolders.add(segments[i]);
                        }
                    }
                }
            }

            Path targetDir = Path.of(saveDirectory);
            if (!subfolder.isBlank()) {
                targetDir = targetDir.resolve(subfolder);
            }
            for (String fld : pathFolders) {
                targetDir = targetDir.resolve(fld);
            }

            Files.createDirectories(targetDir);

            Path targetFile = targetDir.resolve(fileName);

            Files.write(targetFile, htmlLines);
        } catch (Exception e) {
            System.out.println("ERROR saving " + pageUrl + " -> " + e.getMessage());
        }
    }
}


