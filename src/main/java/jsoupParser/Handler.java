package jsoupParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Command invoker
 * Multiple constructors for evade null pointer exception
 */
public class Handler {
    Map<String, Command> map = new HashMap<>();

    public Handler(Command getKeywordCount, Command savePage, Command help, Command aboutMe) {
        map.put("getKeywordCount", getKeywordCount);
        map.put("savePage", savePage);
        map.put("help", help);
        map.put("aboutMe", aboutMe);
    }

    public void run(String command) {
        map.get(command).execute();
    }

}
