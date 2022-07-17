package jsoupParser;

/**
 * Save current page from url
 */
public class SavePage implements Command{
    final Webpage webpage = new Webpage();
    final String url;

    public SavePage(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
        webpage.savePage(this.url);
    }
}
