package jsoupParser;

/**
 * Command invoker
 * Multiple constructors for evade null pointer exception
 */
public class Handler {
    Command getKeywordCount;
    Command savePage;
    final Command help;
    final Command aboutMe;

    public Handler(Command getKeywordCount, Command savePage, Command help, Command aboutMe) {
        this.getKeywordCount = getKeywordCount;
        this.savePage = savePage;
        this.help = help;
        this.aboutMe = aboutMe;
    }

    public Handler(Command savePage, Command help, Command aboutMe) {
        this.savePage = savePage;
        this.help = help;
        this.aboutMe = aboutMe;
    }

    public Handler(Command help, Command aboutMe) {
        this.help = help;
        this.aboutMe = aboutMe;
    }

    public void getKeywordCount() {
        getKeywordCount.execute();
    }
    public void savePage() {
        savePage.execute();
    }
    public void help() {
        help.execute();
    }
    public void aboutMe() {
        aboutMe.execute();
    }

}
