package ap.exercises.EX6.scraper;

import ap.exercises.EX6.scraper.utils.DirectoryTools;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DirectoryTools.createAllDirectory();
        String domainAddress = Conf.DOMAIN_ADDRESS;
        String savePath = Conf.SAVE_DIRECTORY;

        DomainHtmlScraper domainHtmlScraper = new DomainHtmlScraper(domainAddress,savePath);

        domainHtmlScraper.start();
    }
}
