/*
 * TODO:
 *
 * */

package jsoupParser;

import java.sql.SQLException;

/**
 * Webpage parsing console app.
 */
public class Main {
    public static void main(String[] args) {

        if (args.length == 0)
            throw new IllegalArgumentException("Error: the command is not specified, type help for reference.");

        Handler handler;
        String[] command = new String[4];
        System.arraycopy(args, 0, command, 0, args.length);

        try {
            handler = new Handler(
                    new GetKeywordCount(command[1], command[2]),
                    new SavePage(command[1], command[2]),
                    new dbCreate(command[1], command[2]),
                    new dbRead(command[1], command[2]),
                    new dbUpdate(command[1], command[2]),
                    new dbDelete(command[1]),
                    new Help(),
                    new AboutMe()
            );

            handler.run(command[0]);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
