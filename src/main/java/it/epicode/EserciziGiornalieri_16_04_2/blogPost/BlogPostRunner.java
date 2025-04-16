package it.epicode.EserciziGiornalieri_16_04_2.blogPost;

import com.github.javafaker.Faker;
import it.epicode.EserciziGiornalieri_16_04_2.autore.Autore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BlogPostRunner implements CommandLineRunner {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private Faker faker;

    @Override
    public void run(String... args) throws Exception {

        if (blogPostRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                BlogPost blogPost = new BlogPost();
                blogPost.setCategoria(faker.book().genre());
                blogPost.setTitolo(faker.book().title());
                blogPost.setCover("https://picsum.photos/200/300");
                blogPost.setContenuto(faker.book().title());
                blogPost.setTempoDiLettura(faker.number().numberBetween(1, 10));

                blogPostRepository.save(blogPost);
            }
        }
    }
}
