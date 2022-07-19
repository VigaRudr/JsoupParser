package jsoupParser;

/**
 * Save current page from url
 */
public class SavePage implements Command{
    final ControlWebsite controlWebsite = new ControlWebsite();
    final String url;
    final String path;

    public SavePage(String url, String path) {
        this.url = url;
        this.path = path;
    }

    @Override
    public void execute() {
        controlWebsite.savePage(this.url, this.path);
    }
}
