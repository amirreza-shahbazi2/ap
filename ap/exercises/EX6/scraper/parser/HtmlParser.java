package ap.exercises.EX6.scraper.parser;



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
                int hrefLength = "href\"".length();
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
                return line.substring(startIndex + 5, endIndex);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

}