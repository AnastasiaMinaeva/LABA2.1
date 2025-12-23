import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringProcessor {
        //3
        public static String replaceNumbers(String input) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                switch (c) {
                    case '1':
                        result.append("один"); //
                        break;
                    case '2':
                        result.append("два");
                        break;
                    case '3':
                        result.append("три");
                        break;
                    default:
                        result.append(c);
                }
            }
            return result.toString();
        }

        //4
        public static void removeEverySecondChar(StringBuilder sb) {
            int index = 1;
            while (index < sb.length()) {
                sb.deleteCharAt(index);
                index++;
            }
        }

        //5
        public static String reverseWordsComplete(String input) {
            if (input == null || input.isEmpty()) {
                return input;
            }
            String[] words = input.trim().split("\\s+");
            String[] spaces = input.split("\\S+");

            StringBuilder result = new StringBuilder();

            if (spaces.length > 0 && input.substring(0, 1).matches("\\s")) {
                result.append(spaces[0]);
            }

            for (int i = words.length - 1; i >= 0; i--) {
                result.append(words[i]);
                if (i > 0) {
                    result.append(spaces[i]);
                }
            }

            if (spaces.length > 1 && input.substring(input.length() - 1).matches("\\s")) {
                result.append(spaces[spaces.length - 1]);
            }

            return result.toString();
        }
        //Задание 6

            public static String replaceHex(String input) {
                if (input == null) {
                    return null;
                }
                StringBuilder result = new StringBuilder();
                int i = 0;
                int n = input.length();

                while (i < n) {
                    if (i + 9 < n &&
                            input.charAt(i) == '0' &&
                            (input.charAt(i + 1) == 'x' || input.charAt(i + 1) == 'X')) {

                        String c = input.substring(i + 2, i + 10);
                        if (isHex8(c)) {
                            long value = Long.parseLong(c, 16);
                            result.append(value);
                            i += 10;
                            continue;
                        }
                    }
                    result.append(input.charAt(i));
                    i++;
                }
                return result.toString();
            }

            private static boolean isHex8(String s) {
                if (s.length() != 8) return false;
                for (char c : s.toCharArray()) {
                    if (!isHexDigit(c)) {
                        return false;
                    }
                }
                return true;
            }

            private static boolean isHexDigit(char c) {
                return (c >= '0' && c <= '9') ||
                        (c >= 'A' && c <= 'F') ||
                        (c >= 'a' && c <= 'f');
            }
        }
