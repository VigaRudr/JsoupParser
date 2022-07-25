package jsoupParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A receiver class for interacting with a web page using the available commands.
 */
public class ControlWebsite {
    public void getKeywordCount(String url, String keyword) {
        Website website = new Website(url);

        int keyword_count = 0;

        Pattern p = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(website.getBody());

        while (m.find()) {
            keyword_count++;
        }

        System.out.println("Keyword (" + keyword + ") found " + keyword_count + " times!");

        try {
            DatabaseControl databaseControl = new DatabaseControl();
            databaseControl.create("URL, Keyword",
                    "'" + url + "' , '" + keyword + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void savePage(String url, String path) {
        Website website = new Website(url);

        File directory = new File(path);
        File savedPage = new File(directory.getPath() + "\\" + website.getTitle() + ".html");

        if (!directory.exists()) {
            directory.mkdir();
        }
        if (!savedPage.exists()) {
            try {
                savedPage.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            FileWriter fw = new FileWriter(savedPage, StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(website.getHtml_code().outerHtml());
            System.out.println("Saved page stores in: " + path);

            DatabaseControl databaseControl = new DatabaseControl();
            if (databaseControl.db.recordCount > 0) {
                databaseControl.update(
                        "SavePath = '" + path + "'",
                        "URL = '" + url + "'");
            } else {
                databaseControl.create(
                        "URL, SavePath",
                        "'" + url + "', " + "'" + path + "'");
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void help() {
        System.out.println(
                   """
                   Here the list of available commands:
                   - getKeywordCount(String url, String keyword);
                   - savePage(String url, String path);
                   - dbUpdate(String tableName, String setParameter, String condition)
                   - dbRead(String tableName, String readParameter, String condition)
                   - dbDelete(String tableName, String condition)
                   - help;
                   - aboutMe.
                   To see more about specific command type help(command)
                   Type "exit" for exit application.
                   """);
    }

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
        final protected String url;
        protected Document html_code;

        public Website(String url) {
            this.url = url;
        }

        public void setHtmlCode() {
            try {
                this.html_code = Jsoup.connect(this.url).maxBodySize(0).get();
            } catch (Exception e) {
                System.out.println("error");
            }
        }

        public Document getHtml_code() {
            if (this.html_code == null) {
                setHtmlCode();
            }
            return this.html_code;
        }

        public String getTitle()  {
            if (this.html_code == null) {
                setHtmlCode();
            }
            return this.html_code.title();
        }

        public String getBody() {
            if (this.html_code == null) {
                setHtmlCode();
            }
            return this.html_code.body().text();
        }
    }
}
