package jsoupParser;

public class AboutMe implements Command{
    final Webpage webpage = new Webpage();
    @Override
    public void execute() {
        webpage.aboutMe();
    }
}
