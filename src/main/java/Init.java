import java.util.Scanner;

public class Init {
    public static String getInput() {
        System.out.println("Введите выражение. (Например, 5+5 или V-II)");
        Scanner scanner = new Scanner(System.in);

        //Приводим строку в порядок, делаем все буквы заглавными, убираем все пробелы
        String userInput = scanner.nextLine().toUpperCase().replaceAll("\\s", "");

         if (userInput.matches("[0-9]+\\+[0-9]+") || userInput.matches("[0-9]+\\-[0-9]+") || userInput.matches("[0-9]+\\*[0-9]+") || userInput.matches("[0-9]+\\/[0-9]+")
                || userInput.matches("[VXI]+\\+[VXI]+")  || userInput.matches("[VXI]+\\-[VXI]+")  || userInput.matches("[VXI]+\\*[VXI]+")  || userInput.matches("[VXI]+\\/[VXI]+")) {

            //System.out.println("Input is correct");

        } else if (userInput.matches("[0-9]+\\+[VXI]+") || userInput.matches("[0-9]+\\-[VXI]+") || userInput.matches("[0-9]+\\*[VXI]+") || userInput.matches("[0-9]+\\/[VXI]+")
                || userInput.matches("[VXI]+\\+[0-9]+") || userInput.matches("[VXI]+\\-[0-9]+") || userInput.matches("[VXI]+\\*[0-9]+") || userInput.matches("[VXI]+\\/[0-9]+")) {

            System.err.println("Input is incorrect");
            //System.out.println("Допускаются только одинаковые операнды - либо арабские цифры, либо римские.\nНельзя использовать в одном выражении арабские цифры вместе с римскими! То есть, '5+V' или 'VII-4' - недопустимые выражения. " + "\uD83D\uDEA8");

        } else if (userInput.matches("[^VXI^0-9]+\\+[^VXI^0-9]+") || userInput.matches("[^VXI^0-9]+\\-[^VXI^0-9]+") || userInput.matches("[^VXI^0-9]+\\*[^VXI^0-9]+") || userInput.matches("[^VXI^0-9]+\\/[^VXI^0-9]+")) {

            System.err.println("Almost right");
            System.out.println("Римские цифры это не весь алфавит. Для выражений нельзя использовать числа больше 10 или меньше 0, поэтому ограничьте себя комбинацией трех символов - 'V', 'X', 'I'.");

        } else if (userInput.matches("[^VXI^0-9]+\\+[^VXI]+") || userInput.matches("[^VXI^0-9]+\\-[^VXI]+") || userInput.matches("[^VXI^0-9]+\\*[^VXI]+") || userInput.matches("[^VXI^0-9]+\\/[^VXI]+")
                || userInput.matches("[^VXI]+\\+[^VXI^0-9]+") || userInput.matches("[^VXI]+\\-[^VXI^0-9]+") || userInput.matches("[^VXI]+\\*[^VXI^0-9]+") || userInput.matches("[^VXI]+\\/[^VXI^0-9]+")) {

            System.err.println("Not quite right");
            System.out.println("Во-первых, римские цифры это не весь алфавит. Ограничьте себя комбинацией трех символов - 'V', 'X', 'I',\nпоскольку для выражений нельзя использовать числа больше 10 или меньше 0.\nВо-вторых, Нельзя использовать в одном выражении арабские цифры вместе с римскими!\nТакже проверьте раскладку клавиатуры.");

        }
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};

        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (userInput.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        //Если не нашли арифметического действия, завершаем программу
        if (actionIndex == -1) {
            throw new RuntimeException("Количество операндов должно быть два");
        }
        //Делим строчку по найденному арифметическому знаку

        String[] arr = userInput.split("[+\\-*/]");
        if (arr.length != 2) {
            throw new RuntimeException("Количество операндов должно быть два");
        }
        //String[] data = userInput.split(regexActions[actionIndex]);
        try {

            if (userInput.matches("(\\+) \\d*(\\+) \\d*(\\+*)") || userInput.matches("(\\+*)\\d*(\\+)\\d*(\\+)\\d*")) {
                throw new UnsupportedOperationException("Допускается только один оператор " + "\uD83D\uDEA8");
            } /*else if (userInput.matches("(\\-) \\d*(\\-) \\d*(\\-*)") || userInput.matches("(\\-*)(\\+*)(\\**)(\\/*)\\d*\\w*(\\-*)(\\+*)(\\**)(\\/*)\\d*\\w*(\\-*)(\\+*)(\\**)(\\/*)\\d*\\w*(\\-*)(\\+*)(\\**)(\\/*)")) {
                System.out.println("Check");
                throw new UnsupportedOperationException("Допускается только один оператор - \"\uD83D\uDEA8");
            }*/
            else if (userInput.matches("(\\-) \\d(\\-) \\d(\\-)") || userInput.matches("(\\-)(\\+)(\\*)(\\/)\\d\\w(\\-)(\\+)(\\*)(\\/)\\d\\w(\\-)(\\+)(\\*)(\\/)\\d\\w(\\-)(\\+)(\\*)(\\/)")) {
                System.out.println("Check");
                throw new UnsupportedOperationException("Допускается только один оператор - \"\uD83D\uDEA8");
            }
            else if (userInput.matches("(\\*) \\d*(\\*) \\d*(\\(*)*") || userInput.matches("(\\(*)*\\d*(\\*)\\d*(\\*)\\d*")) {
                throw new UnsupportedOperationException("Допускается только один оператор * \"\uD83D\uDEA8");
            }else if (userInput.matches("(\\/) \\d*(\\/) \\d*(\\/*)") || userInput.matches("(\\/*)\\d*(\\/)\\d*(\\/)\\d*")) {
                throw new UnsupportedOperationException("Допускается только один оператор / \"\uD83D\uDEA8");
            }else if (userInput.matches("(\\+) \\w*(\\+) \\w*(\\+*)") || userInput.matches("(\\+*)\\w*(\\+)\\w*(\\+)\\w*")) {
                throw new UnsupportedOperationException("Допускается только один оператор " + "\uD83D\uDEA8");
            } else if (userInput.matches("(\\-) \\w*(\\-) \\w*(\\-*)") || userInput.matches("(\\-*)\\w*(\\-)\\w*(\\-)\\w*")) {
                throw new UnsupportedOperationException("Допускается только один оператор - \"\uD83D\uDEA8");
            }else if (userInput.matches("(\\*) \\w*(\\*) \\w*(\\(*)*") || userInput.matches("(\\(*)*\\w*(\\*)\\w*(\\*)\\w*")) {
                throw new UnsupportedOperationException("Допускается только один оператор * \"\uD83D\uDEA8");
            }else if (userInput.matches("(\\/) \\w*(\\/) \\w*(\\/*)") || userInput.matches("(\\/*)\\w*(\\/)\\w*(\\/)\\w*")) {
                throw new UnsupportedOperationException("Допускается только один оператор / \"\uD83D\uDEA8");
            }
        } catch (UnsupportedOperationException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        //System.out.println(userInput);
        return userInput;

    }// end of method getInput

    public static String[] splitUserInput(String userInput) {
        String[] expression = new String[3];
        //Опредялем оператор действия, добавляем к нему пробелы для удобства разделения строки
        try {
            if (userInput.contains(Character.toString('+'))) {
                expression = userInput.replace("+", " + ").split("\\s");
            } else if (userInput.contains(Character.toString('-'))) {
                expression = userInput.replace("-", " - ").split("\\s");
            } else if (userInput.contains(Character.toString('*'))) {
                expression = userInput.replace("*", " * ").split("\\s");
            } else if (userInput.contains(Character.toString('/'))) {
                expression = userInput.replace("/", " / ").split("\\s");
            } else {
                throw new UnsupportedOperationException("Неверный или отсутствующий знак оператора " + "\uD83D\uDEA8");
            }
        } catch (UnsupportedOperationException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        //System.out.println(expression[0] + expression[1] + expression[2]);
        return expression;
    }// end of method splitUserInput
}
// end of class Init
