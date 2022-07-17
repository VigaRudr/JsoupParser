package jsoupParser;

/**
 * Shows app info
 */
public class AboutMe implements Command{
    final Webpage webpage = new Webpage();

    @Override
    public void execute() {
        webpage.aboutMe();
    }
}
