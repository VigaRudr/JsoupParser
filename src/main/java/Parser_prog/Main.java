package Parser_prog;

import java.util.Scanner;

/**
 * Webpage parsing console app.
 */
public class Main {
    /**
     * States of program
     */
    enum State {
        /** Reading state */
        reading,
        /** Executing state */
        writing,
        /** Exit state */
        exit
    }

    /**
     * A class for managing states
     */
    static class Program_State {
        /**
         * Current state of app
         */
        private State state;

        /**
         * Constructor for state class
         *
         * @param state - initial value
         */
        Program_State(State state) {
            setState(state);
        }

        /**
         * Get current state of app
         *
         * @return current state
         */
        State getState() {
            return state;
        }

        /**
         * Set current state of app
         *
         * @param state - state that we want
         */
        void setState(State state) {
            this.state = state;
        }
    }

    /**
     * Main function of app
     * @param args - Input parameters (Doesn't count)
     */
    public static void main(String[] args) {
        Webpage parser = new Webpage();

        Scanner in = new Scanner(System.in);
        Program_State state = new Program_State(State.reading);
        String input = "";
        String[] command;
        int keyword_count;

        while ((state.getState()) != State.exit) {
            switch (state.getState()) {
                case reading -> {
                    System.out.println("Type your command (Type \"exit\" to leave program)...");
                    input = in.nextLine();
                    state.setState(State.writing);
                }
                case writing -> {
                    command = input.replaceAll("[\n\t]", "")
                            .replaceAll("[()]", " ").split("[ ,]");
                    switch (command[0]) {
                        case "getKeywordCount" -> {
                            keyword_count = parser.getKeywordCount(command[1], command[2]);
                            System.out.println("Keyword (" + command[2] + ") found " + keyword_count + " times!");
                        }
                        case "savePage" -> {
                            if (command.length == 2) {
                                parser.savePage(command[1]);
                                break;
                            }
                            parser.savePage(command[1], command[2]);
                        }
                        case "help" -> {
                            if (command.length == 1) {
                                parser.help();
                                break;
                            }
                            parser.help(command[1]);
                        }
                        case "aboutMe" -> parser.aboutMe();
                        case "exit" -> state.setState(State.exit);
                        default -> System.out.println("Sadly, but the application does not have this command " +
                                "or you just misprinted. Try \"help\"\n" +
                                "if you want to see this command in the application, send your feedback by e-mail " +
                                "(company@email.com )");
                    }
                    if ((state.getState()) != State.exit)
                        state.setState(State.reading);
                }
            }
        }

    }
}
