/*
 * TODO:
 *  Парсинг сайта.
 *   На вход подается url и ключевое слово.
 *   На выходе получаем числовое значение обозначающее количество раз встречающихся на заданной странице.
 *  Дополнительный функционал:
 *   Возможность сохранения документа, то есть заданной страницы.
 *   Вывод help.
 *   Вывод aboutMe.
 *  Дополнительные требования:
 *   Использование шаблонов проектирования.
 *   Использовать систему контроля версий.
 *   Использовать пакетный менеджер и сброщик проекта.
 *   Описать readme в которм будет описан процесс сборки запуска и использования.
 * */

package Parser_prog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

/**
 * Represents webpage parser interface
 * @author es.sadovnikov
 * @version 1.0
 */
interface Parser {
    /**
     * Returns a keyword match number
     * @param url – URL of the Website
     * @param keyword – searching value (must be String)
     * @return a keyword match number
     */
    int getKeywordCount(String url, String keyword);
    void savePage(String url);
    void savePage(String url, String path);
    /**
     * Displays list of avaible commands.
     */
    void help();

    /**
     * Displays information about specific command
     * @param command that we interested
     */
    void help(String command);

    /**
     * Displays the information about the program.
     */
    void aboutMe();
}

/**
 * Website description
 * Stores url, title and html code of webpage.
 */
class Website {
    /**
     * Url of page
     */
    protected String url;
    /**
     * html code of page
     */
    protected Document html_code;
    /**
     * title of page
     */
    protected String title;

    /**
     * Set url of the webpage
     * @param url value to set
     */
    void setUrl(String url) {
        if (this.url != null) {
            this.url = url;
            setHtml_code();
        }
        this.url = url;
    }

    /**
     * Read html code of the webpage and stores it.
     * Using Jsoup library. (https://jsoup.org)
     */
    void setHtml_code() {
        try {
            this.html_code = Jsoup.connect(this.url).maxBodySize(0).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.html_code);
    }

    /**
     * Get url of page
     * @return String value of url
     */
    String getUrl() {
        return this.url;
    }

    /**
     * Get html code from page
     * @return html code in String value;
     */
    Document getHtml_code() {
        if (this.html_code == null) {
            setHtml_code();
        }
        return this.html_code;
    }

    String getTitle()  {
        if (this.html_code == null)
            setHtml_code();
        return this.html_code.title();
    }

    /**
     * Get all text from body code in website
     * @return String value of all text in body
     */
    String getBody() {
        if (this.html_code == null)
            setHtml_code();
        return  this.html_code.body().text();
    }

}