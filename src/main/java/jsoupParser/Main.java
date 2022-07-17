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

import java.util.Scanner;

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
                new SavePage(command[1]),
                new Help(),
                new AboutMe()
        );

        handler.run(command[0]);
    }
}
