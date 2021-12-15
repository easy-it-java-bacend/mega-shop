package kg.itschool.megashop.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Random;

@Configuration
public class Utils {

    @Bean
    @Primary
    public CodeGenerator getDigitsGenerator() {
        return new CodeGenerator(20, new Random(), CodeGenerator.DIGITS);
    }


    @Qualifier("passwordGenerator")
    @Bean
    public CodeGenerator passwordGenerator() {
        return new CodeGenerator(10, new Random(), CodeGenerator.ALPHANUM);
    }

}
