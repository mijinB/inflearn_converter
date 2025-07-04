package hello.typeconverter.formatter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() {

        try {
            Number result = formatter.parse("1,000", Locale.KOREA);
            assertThat(result).isEqualTo(1000L); // Long 타입 주의

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void print() {
        String result = formatter.print(1000, Locale.KOREA);
        assertThat(result).isEqualTo("1,000");
    }
}