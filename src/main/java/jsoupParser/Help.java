package jsoupParser;

/**
 * Show list of available commands
 */
public class Help implements Command{
    final ControlWebsite controlWebsite = new ControlWebsite();
    @Override
    public void execute() {
        controlWebsite.help();
    }
}
