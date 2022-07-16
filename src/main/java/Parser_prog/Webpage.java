package Parser_prog;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class for interacting with a web page using the available commands.
 */
public class Webpage implements Parser {
    Website website = new Website();

    @Override
    public int getKeywordCount(String url, String keyword) {
        int keyword_count = 0;
        website.setUrl(url);

        Pattern p = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(website.getBody());

        while (m.find()) {
            keyword_count++;
        }

        return keyword_count;
    }

    @Override
    public void savePage(String url) {
        website.setUrl(url);
        String path = ".\\"+ website.getTitle().replaceAll("[:?<>]","") + ".html";
        try {
            FileWriter fw = new FileWriter(path, StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(website.getHtml_code().outerHtml());
            System.out.println("Saved page stores in: " + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void savePage(String url, String path) {
        website.setUrl(url);
        path += website.getTitle() + ".html";
        try {
            FileWriter fw = new FileWriter(path, StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(website.getHtml_code().outerHtml());
            System.out.println("Saved page stores in: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void help() {
        System.out.println(
                   """
                   Here the list of available commands:
                   - getKeywordCount;
                   - savePage;
                   - help;
                   - aboutMe.
                   To see more about specific command type help(command)
                   Type "exit" for exit application.
                   """);
    }

    @Override
    public void help(String command) {
        switch (command) {
            case "getKeywordCount" -> System.out.println(
                   """
                   keyword_count(String url, String keyword):
                   Input data:
                   - String url (Link to a web page)
                   - String keyword (Keyword you wand to count on this page (except title), case insensitive)
                   Collects data on the page and displays the number of keywords.
                   Example:
                   - getKeywordCount(https://en.wikipedia.org/wiki/Game, Game)
                   """);
            case "savePage" -> System.out.println(
                   """
                   savePage() or savePage(String path)
                   Input data:
                   - String path value defining storage directory for saved webpage
                   Save webpage to the specified folder. " +
                   If the folder is not specified, it saves it to the default location
                   Example:
                   savePage(https://en.wikipedia.org/wiki/Game) or
                   savePage(https://en.wikipedia.org/wiki/Game, C:\\\\)
                   """);
            case "help" -> System.out.println(
                   """
                   help(String command)
                   Input data:
                   - String command (you can got the name of command by typing help())
                   Shows information about specific command.
                   Example:
                   - help(keyword_count))
                   """);
            case "aboutMe" -> System.out.println(
                   """
                   aboutMe()
                   Shows the information about the program.
                   """);
         }

     }

     @Override
     public void aboutMe() {
         System.out.println(
                 """                         
                 Keyword counting parser.
                 Version: 1.0
                 Author: es.sadovnikov
                 """);
     }
 }
