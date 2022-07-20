/*
 * TODO:
 *
 * */

package jsoupParser;

/**
 * Webpage parsing console app.
 */
public class Main {
    public static void main(String[] args) {

        if (args.length == 0)
            throw new IllegalArgumentException("Error: the command is not specified, type help for reference.");

        Handler handler;
        String[] command = new String[3];
        System.arraycopy(args, 0, command, 0, args.length);

        handler = new Handler(
                new GetKeywordCount(command[1], command[2]),
                new SavePage(command[1], command[2]),
                new Help(),
                new AboutMe()
        );

        handler.run(command[0]);



    }
}
