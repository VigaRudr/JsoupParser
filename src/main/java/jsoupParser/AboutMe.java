package jsoupParser;

/**
 * Shows app info
 */
public class AboutMe implements Command{
    final ControlWebsite controlWebsite = new ControlWebsite();

    @Override
    public void execute() {
        controlWebsite.aboutMe();
    }
}
