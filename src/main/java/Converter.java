public class Converter {
    public static byte romToInt(String romanInts){
                                                        //Конвертируем римские символы в арабские числа(int)
        switch (romanInts) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return -1;
        }
    }// end of method romToInt
    public static StringBuilder intToRom(int num) {
                                                       //Перевод из арабских цифр в римские символы для вывода результата операции
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman;
    }// end of method intToRom
}// end of class Converter
