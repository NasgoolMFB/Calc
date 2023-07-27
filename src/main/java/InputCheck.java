public class InputCheck {
    static String[] romanInput = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
    public static boolean romCheck0(String[] expression) {
        boolean isRoman0 = false;
        for (int i = 0; i < romanInput.length; i++) {
            if (romanInput[i].equals(expression[0])) {
                isRoman0 = true;
            }
        } return isRoman0;
    }
    public static boolean romCheck2(String[] expression){
        boolean isRoman2 = false;
        for (int i = 0; i < romanInput.length; i++) {
            if (romanInput[i].equals(expression[2])) {
                isRoman2 = true;
            }
        } return isRoman2;
    }
public static void isBothRoman(String[] expression){
    boolean isRoman0 = InputCheck.romCheck0(expression);
    boolean isRoman2 = InputCheck.romCheck2(expression);
                                                            //Ловим исключение, когда имеется только одна римская цифра
    try {
        if ((isRoman0 && !isRoman2) || (!isRoman0 && isRoman2)) {
            throw new IllegalArgumentException("Введите только римские или только арабские цифры "+"\uD83D\uDEA8");
        }
    } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
        System.exit(0);
    }
}
                                                            //Проверяем возможность парсить в Int
    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            //System.err.println("Римские цифры - это не весь алфавит!"+"\uD83E\uDD26");
            return false;
        }
    }
    public static void romNeg(String[] expression) {

        int num0 = Converter.romToInt(expression[0]);
        int num2 = Converter.romToInt(expression[2]);
        char operator = expression[1].charAt(0);

        if (operator == '-' && num0 <= num2 || operator == '/' && num0 <= num2) {
            System.err.println("Incorrect input");
            throw new RuntimeException("No negative or zero roman result allowed");
        }
    }
}