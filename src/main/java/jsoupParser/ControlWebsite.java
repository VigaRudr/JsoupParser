package jsoupParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A receiver class for interacting with a web page using the available commands.
 */
public class ControlWebsite {
    /**
     * Get keyword number from webpage url
     * @param url - webpage link
     * @param keyword - searched keyword
     */
    public void getKeywordCount(String url, String keyword) {
        Website website = new Website(url);

        int keyword_count = 0;

        Pattern p = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(website.getBody());

        while (m.find()) {
            keyword_count++;
        }

        System.out.println("Keyword (" + keyword + ") found " + keyword_count + " times!");
    }

    /**
     * Save html-code of page in default folder
     * @param url - link of webpage
     */
    public void savePage(String url) {
        Website website = new Website(url);

        String path = website.getTitle() + ".html";
        try {
            FileWriter fw = new FileWriter(path, StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(website.getHtml_code().outerHtml());
            System.out.println("Saved page stores in: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show list of available commands
     */
    public void help() {
        System.out.println(
                   """
                   Here the list of available commands:
                   - getKeywordCount(String url, String keyword);
                   - savePage(String url);
                   - help;
                   - aboutMe.
                   To see more about specific command type help(command)
                   Type "exit" for exit application.
                   """);
    }

    /**
     * Print app information
     */
     public void aboutMe() {
         System.out.println(
                 """                         
                 Keyword counting parser.
                 Version: 1.1-SNAPSHOT
                 Author: es.sadovnikov
                 """);
     }

    /**
     * Website description
     * Stores url, title and html code of webpage.
     */
    static class Website {
        /**
         * Url of page
         */
        final protected String url;
        /**
         * html code of page
         */
        protected Document html_code;
        /**
         * title of page
         */
        protected String title;

        public Website(String url) {
            this.url = url;
        }

        /**
         * Read html code of the webpage and stores it.
         */
        public void setHtmlCode() {
            try {
                this.html_code = Jsoup.connect(this.url).maxBodySize(0).get();
            } catch (Exception e) {
                System.out.println("error");
            }
        }

        /**
         * Get html code from page
         * @return html code in String value;
         */
        public Document getHtml_code() {
            if (this.html_code == null) {
                setHtmlCode();
            }
            return this.html_code;
        }

        public String getTitle()  {
            if (this.html_code == null)
                setHtmlCode();
            return this.html_code.title();
        }

        /**
         * Get all text from body code in website
         * @return String value of all text in body
         */
        public String getBody() {
            if (this.html_code == null)
                setHtmlCode();
            return  this.html_code.body().text();
        }
    }
}
