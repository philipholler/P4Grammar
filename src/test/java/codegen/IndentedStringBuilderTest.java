package codegen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndentedStringBuilderTest {

    IndentedStringBuilder indentedSB;

    private static final String sampleString = "123456789!.XYZxyz:{}()";

    private static final String TAB = IndentedStringBuilder.TAB;
    private static final String NEW_LINE = IndentedStringBuilder.NEW_LINE;

    @BeforeEach
    void setUp() {
        indentedSB = new IndentedStringBuilder();
    }

    @Test
    void append() {
        indentedSB.append(sampleString);
        assertEquals(sampleString, indentedSB.toString());
    }

    @Test
    void appendIndented() {
        indentedSB = new IndentedStringBuilder(1);
        indentedSB.append(sampleString);

        assertTrue(indentedSB.toString().startsWith(TAB));
    }

    @Test
    void appendTwoLines() {
        indentedSB = new IndentedStringBuilder(1);
        indentedSB.append(sampleString).newLine();
        indentedSB.append(sampleString).newLine();

        String expectedString = TAB + sampleString + NEW_LINE +
                TAB + sampleString + NEW_LINE;

        assertEquals(expectedString, indentedSB.toString());
    }

    @Test // Append a string with multiple lines and assert that indentation has been added to each individual line
    void multipleLineIndentation() {
        indentedSB.setIndentation(1);

        String appendedString = sampleString + NEW_LINE + sampleString;
        String expectedString = TAB + sampleString + NEW_LINE + TAB + sampleString;

        indentedSB.append(appendedString);

        assertEquals(expectedString, indentedSB.toString());
    }
}