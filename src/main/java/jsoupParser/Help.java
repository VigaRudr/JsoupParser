package jsoupParser;

public class Help implements Command{
    final Webpage webpage = new Webpage();
    @Override
    public void execute() {
        webpage.help();
    }
}
