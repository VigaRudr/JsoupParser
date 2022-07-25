package jsoupParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Command invoker
 */
public class Handler {
    Map<String, Command> map = new HashMap<>();

    public Handler(
            Command getKeywordCount,
            Command savePage,
            Command dbCreate,
            Command dbRead,
            Command dbUpdate,
            Command dbDelete,
            Command help,
            Command aboutMe) {

        map.put("getKeywordCount", getKeywordCount);
        map.put("savePage", savePage);
        map.put("dbCreate", dbCreate);
        map.put("dbRead", dbRead);
        map.put("dbUpdate", dbUpdate);
        map.put("dbDelete", dbDelete);
        map.put("help", help);
        map.put("aboutMe", aboutMe);
    }

    public void run(String command) {
        map.get(command).execute();
    }

}
