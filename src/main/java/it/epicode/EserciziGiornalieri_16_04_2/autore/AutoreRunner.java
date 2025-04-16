package it.epicode.EserciziGiornalieri_16_04_2.autore;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AutoreRunner implements CommandLineRunner {
    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private Faker faker;

    @Override
    public void run(String... args) throws Exception {
        if(autoreRepository.count() == 0) {
            for(int i = 0; i < 10; i++) {
                Autore autore = new Autore();
                autore.setNome(faker.name().name());
                autore.setCognome(faker.name().lastName());
                autore.setEmail(faker.internet().emailAddress());
                autore.setDataDiNascita(faker.date().birthday().toString());
                autore.setAvatar("https://ui-avatars.com/api/?name=Mario+Rossi");
                autoreRepository.save(autore);
            }
        }
    }
}
