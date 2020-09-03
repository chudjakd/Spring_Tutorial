package sk.dejvo.springtutorial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import sk.dejvo.springtutorial.services.implementacia.PrintService;

@Configuration
@PropertySource("classpath:nove.properties")
public class novyConfig {
    @Value("${david.meno}")
    String meno;
    @Value("${david.priezvisko}")
    String priezvisko;

    @Bean
    @Primary
    public PrintService printMenoAPriezvisko(){
        PrintService printService= new PrintService();
        printService.setData(meno+ ","+ priezvisko);
        return printService;
    }

//    @Bean
//    public PrintService printMeno(){
//        PrintService printService= new PrintService();
//        printService.setData(meno);
//        return printService;
//    }
}
