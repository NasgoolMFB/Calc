public class Calculator {
    public static void start(){
        // Получаем результат вида:   String[] expressionSplit = {"5", "+", "6"};
        String[] expressionSplit = Init.splitUserInput(Init.getInput());

        char operator = expressionSplit[1].charAt(0);
        boolean isRoman0 = InputCheck.romCheck0(expressionSplit);
        boolean isRoman2 = InputCheck.romCheck2(expressionSplit);

        InputCheck.isBothRoman(expressionSplit);
        Calculator.printResult(expressionSplit,operator, isRoman0, isRoman2);
    }// end of method start
    public static int calculate(int num0, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+': result = num0 + num2; break;
            case '-': result = num0 - num2; break;
            case '*': result = num0 * num2; break;
            case '/': result = num0 / num2; break;
            default: throw new IllegalArgumentException("Неверный знак операции");
        }return result;
    }// end of method calculate
    public static void printResult(String[] expression, char operator, boolean isRoman0, boolean isRoman2) {
        int num0 = 0, num2 = 0;
        boolean parse0, parse2;
                                                      // Если оба символа римские
        if (isRoman0 && isRoman2) {
            InputCheck.romNeg(expression);
            num0 = Converter.romToInt(expression[0]);
            num2 = Converter.romToInt(expression[2]);
            System.out.println(Converter.intToRom(Calculator.calculate(num0, num2, operator)));
        } else {
                                                      //Ловим исключение, когда невозможно парсить в Int
            try {
                parse0 = InputCheck.isParsable(expression[0]);
                parse2 = InputCheck.isParsable(expression[2]);
                if (parse0 && parse2) {
                    num0 = Integer.parseInt(expression[0]);
                    num2 = Integer.parseInt(expression[2]);
                }
                                                      //Ловим исключение, когда цифра больше 10 или меньше 0
                if ((num0 > 10) || (num0 < 0) || (num2 > 10) || (num2 < 0)) {
                    throw new IllegalArgumentException("Числа не должны быть больше 10 и меньше 0");
                }
                System.out.println(Calculator.calculate(num0, num2, operator));
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }
    }// end of method printResult
}// end of class Calculator


