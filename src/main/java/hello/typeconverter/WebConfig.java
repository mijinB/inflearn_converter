package hello.typeconverter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 스프링이 내부에서 수 많은 기본 컨버터들을 제공하기 때문에 String ↔ Integer 컨버터는 추가하지 않아도 잘 동작한다.
        // 컨버터를 추가하면 추가한 컨버터가 기본 컨버터 보다 높은 우선순위를 가진다.

        /* 우선순위때문에 주석처리
           주석한 두개도, 추가한 MyNumberFormatter 도 숫자↔문자 똑같은 건데 컨버터가 더 우선순위가 높아서 포매터가 적용되지 않기 때문.
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter()); */
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        // 추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
