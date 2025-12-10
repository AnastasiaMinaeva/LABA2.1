
public class StringProcessor {
        //3
        public static String replaceNumbers(String input) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                switch (c) {
                    case '1':
                        result.append("один");
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
    }
