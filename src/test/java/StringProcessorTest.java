import org.junit.Test;

import static org.junit.Assert.*;

public class StringProcessorTest {

    // Тесты для задания 3: replaceNumbers
    @Test
    public void testReplaceNumbersBasic() {
        assertEquals("одиндватри", StringProcessor.replaceNumbers("123"));
        assertEquals("aодинbдваcтриd", StringProcessor.replaceNumbers("a1b2c3d"));
        assertEquals("один два три", StringProcessor.replaceNumbers("1 2 3"));
    }

    @Test
    public void testReplaceNumbersNoDigits() {
        assertEquals("hello", StringProcessor.replaceNumbers("hello"));
        assertEquals("456789", StringProcessor.replaceNumbers("456789"));
        assertEquals("", StringProcessor.replaceNumbers(""));
    }

    @Test
    public void testReplaceNumbersMultipleSameDigits() {
        assertEquals("одинодиндвадватритри", StringProcessor.replaceNumbers("112233"));
        assertEquals("одинодин", StringProcessor.replaceNumbers("11"));
    }

    @Test
    public void testReplaceNumbersMixedContent() {
        assertEquals("Тест: один пример два случая три",
                StringProcessor.replaceNumbers("Тест: 1 пример 2 случая 3"));
    }

    @Test
    public void testReplaceNumbersWithNewLines() {
        assertEquals("один\nдва\nтри", StringProcessor.replaceNumbers("1\n2\n3"));
    }

    //Тесты для задания 4 removeEverySecondChar
    @Test
    public void testRemoveEverySecondCharBasic() {
        StringBuilder sb1 = new StringBuilder("abcdef");
        StringProcessor.removeEverySecondChar(sb1);
        assertEquals("ace", sb1.toString());

        StringBuilder sb2 = new StringBuilder("abcdefgh");
        StringProcessor.removeEverySecondChar(sb2);
        assertEquals("aceg", sb2.toString());
    }

    @Test
    public void testRemoveEverySecondCharShortStrings() {
        StringBuilder sb1 = new StringBuilder("a");
        StringProcessor.removeEverySecondChar(sb1);
        assertEquals("a", sb1.toString());

        StringBuilder sb2 = new StringBuilder("ab");
        StringProcessor.removeEverySecondChar(sb2);
        assertEquals("a", sb2.toString());

        StringBuilder sb3 = new StringBuilder("abc");
        StringProcessor.removeEverySecondChar(sb3);
        assertEquals("ac", sb3.toString());
    }

    @Test
    public void testRemoveEverySecondCharEmpty() {
        StringBuilder sb = new StringBuilder("");
        StringProcessor.removeEverySecondChar(sb);
        assertEquals("", sb.toString());
    }

    @Test
    public void testRemoveEverySecondCharWithNumbers() {
        StringBuilder sb = new StringBuilder("123456");
        StringProcessor.removeEverySecondChar(sb);
        assertEquals("135", sb.toString());
    }

    @Test
    public void testRemoveEverySecondCharWithSpaces() {
        StringBuilder sb = new StringBuilder("a b c d");
        StringProcessor.removeEverySecondChar(sb);
        assertEquals("abcd", sb.toString());
    }

    // Тесты для задания 5: reverseWordsComplete
    @Test
    public void testReverseWordsCompleteBasic() {
        assertEquals("world hello", StringProcessor.reverseWordsComplete("hello world"));
        assertEquals("three two one", StringProcessor.reverseWordsComplete("one two three"));
    }

    @Test
    public void testReverseWordsCompleteWithLeadingSpaces() {
        assertEquals("  world hello", StringProcessor.reverseWordsComplete("  hello world"));
        assertEquals("   three two one", StringProcessor.reverseWordsComplete("   one two three"));
    }

    @Test
    public void testReverseWordsCompleteWithTrailingSpaces() {
        assertEquals("world hello   ", StringProcessor.reverseWordsComplete("hello world   "));
        assertEquals("three two one ", StringProcessor.reverseWordsComplete("one two three "));
    }

    @Test
    public void testReverseWordsCompleteWithMultipleSpaces() {
        assertEquals("    world   hello", StringProcessor.reverseWordsComplete("    hello   world"));
        assertEquals("  three  two   one  ", StringProcessor.reverseWordsComplete("  one   two  three  "));
    }

    @Test
    public void testReverseWordsCompleteEmptyAndNull() {
        assertEquals("", StringProcessor.reverseWordsComplete(""));
        assertEquals(null, StringProcessor.reverseWordsComplete(null));
    }

    @Test
    public void testReverseWordsCompleteOnlySpaces() {
        assertEquals("   ", StringProcessor.reverseWordsComplete("   "));
    }

}