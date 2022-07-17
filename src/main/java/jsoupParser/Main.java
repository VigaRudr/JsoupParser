/*
 * TODO:
 *  Парсинг сайта.
 *   На вход подается url и ключевое слово.
 *   На выходе получаем числовое значение обозначающее количество раз встречающихся на заданной странице.
 *  Дополнительный функционал:
 *   Возможность сохранения документа, то есть заданной страницы.
 *   Вывод help.
 *   Вывод aboutMe.
 *  Дополнительные требования:
 *   Использование шаблонов проектирования.
 *   Использовать систему контроля версий.
 *   Использовать пакетный менеджер и сброщик проекта.
 *   Описать readme в которм будет описан процесс сборки запуска и использования.
 * */

package jsoupParser;

/**
 * Webpage parsing console app.
 */
public class Main {
    public static void main(String[] args) {
        Handler handler;

        if (args.length == 3) {
            handler = new Handler(
                    new GetKeywordCount(args[1], args[2]),
                    new SavePage(args[1]),
                    new Help(),
                    new AboutMe()
            );
        } else if (args.length == 2) {
            handler = new Handler(
                    new SavePage(args[1]),
                    new Help(),
                    new AboutMe()
            );
        } else {
            handler = new Handler(
                    new Help(),
                    new AboutMe()
            );
        }

        System.out.println("Command:");
        for (String arg : args)
            System.out.println(arg);

        switch (args[0]) {
            case "getKeywordCount" -> handler.getKeywordCount();
            case "savePage" -> handler.savePage();
            case "help" -> handler.help();
            case "aboutMe" -> handler.aboutMe();
            default -> System.out.println("Wrong command");
        }

    }
}
