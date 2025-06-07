package ap.exercises.EX6.scraper.parser;



import ap.exercises.EX6.scraper.Conf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HtmlParser {

    public static String getFirstUrl(String htmlLine) {
        String url = null;
        int startIndex = htmlLine.indexOf("href=\"");
        if (startIndex >= 0) {
            try {
                int hrefLength = "href=\"".length();
                int endIndex = htmlLine.indexOf("\"", startIndex + hrefLength + 1);
                url = htmlLine.substring(startIndex + hrefLength + 1, endIndex);
            } catch (Exception e) {
            }
        }
        return url;
    }

    private static List<String> getAllUrlsFromHtmlLinesStream(Stream<String> htmlLinesStream) throws IOException {
        List<String> urls = htmlLinesStream
                .map(line -> getFirstUrl(line))
                .filter(s -> s != null)
                .collect(Collectors.toList());
        return urls;
    }

    public static List<String> getAllUrlsFromFile(String filePath) throws IOException {
        return getAllUrlsFromHtmlLinesStream(Files.lines(Path.of(filePath)));
    }

    public static List<String> getAllUrlsFromList(List<String> htmlLines) throws IOException {
        return getAllUrlsFromHtmlLinesStream(htmlLines.stream());
    }

    public static List<String> getImageUrlsFromHtmlLines(List<String> htmlLines) {
        return htmlLines.stream()
                .filter(line -> line.contains("<img"))
                .map(HtmlParser::getImageUrlFromLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static String getImageUrlFromLine(String line) {
        int startIndex = line.indexOf("src=\"");
        if (startIndex >= 0) {
            try {
                int endIndex = line.indexOf("\"", startIndex + 5);
                String imageUrl = line.substring(startIndex + 5, endIndex);
                if (!imageUrl.startsWith("http://") && !imageUrl.startsWith("https://")) {
                    return Conf.DOMAIN_ADDRESS + (imageUrl.startsWith("/") ? "" : "/") + imageUrl;
                }
                return imageUrl;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
    public static List<String> getAudioUrlsFromHtmlLines(List<String> htmlLines) {
        return htmlLines.stream()
                .filter(line -> line.toLowerCase().contains(".mp3"))
                .map(HtmlParser::getAudioUrlFromLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static String getAudioUrlFromLine(String line) {
        int startIndex = line.indexOf("href=\"");
        if (startIndex >= 0) {
            try {
                int hrefLength = "href=\"".length();
                int endIndex = line.indexOf("\"", startIndex + hrefLength);
                String audioUrl = line.substring(startIndex + hrefLength, endIndex);
                if (audioUrl.toLowerCase().endsWith(".mp3")) {
                    if (!audioUrl.startsWith("http://") && !audioUrl.startsWith("https://")) {
                        return Conf.DOMAIN_ADDRESS + (audioUrl.startsWith("http://") ? "" : "/") + audioUrl;
                    }
                    return audioUrl;
                }

            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

}