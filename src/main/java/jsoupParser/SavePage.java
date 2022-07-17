package jsoupParser;

/**
 * Save current page from url
 */
public class SavePage implements Command{
    final ControlWebsite controlWebsite = new ControlWebsite();
    final String url;

    public SavePage(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
        controlWebsite.savePage(this.url);
    }
}
