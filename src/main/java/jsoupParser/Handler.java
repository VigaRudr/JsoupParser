package jsoupParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Command invoker
 * Multiple constructors for evade null pointer exception
 */
public class Handler {
    Map<Integer, Command> map = new HashMap<>();

    public Handler(Command getKeywordCount, Command savePage, Command help, Command aboutMe) {
        map.put(getHash("getKeywordCount"), getKeywordCount);
        map.put(getHash("savePage"), savePage);
        map.put(getHash("help"), help);
        map.put(getHash("aboutMe"), aboutMe);
    }

    private int getHash(String command) {
        int hash = command.charAt(0) - 'a';
        return hash % 5;
    }

    public void run(String command) {
        map.get(getHash(command)).execute();
    }

}
