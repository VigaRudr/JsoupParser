package jsoupParser;

/**
 * Get keyword number on page
 */
public class GetKeywordCount implements Command{
    final ControlWebsite controlWebsite = new ControlWebsite();
    final String url;
    final String keyword;

    /**
     * Class constructor
     * @param url - webpage link
     * @param keyword - keyword we want to search
     */
    public GetKeywordCount(String url, String keyword) {
        this.url = url;
        this.keyword = keyword;
    }

    @Override
    public void execute() {
        controlWebsite.getKeywordCount(this.url, this.keyword);
    }
}
