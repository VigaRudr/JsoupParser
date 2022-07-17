package jsoupParser;

public class GetKeywordCount implements Command{
    final Webpage webpage = new Webpage();
    final String url;
    final String keyword;

    public GetKeywordCount(String url, String keyword) {
        this.url = url;
        this.keyword = keyword;
    }

    @Override
    public void execute() {
        webpage.getKeywordCount(this.url, this.keyword);
    }
}
