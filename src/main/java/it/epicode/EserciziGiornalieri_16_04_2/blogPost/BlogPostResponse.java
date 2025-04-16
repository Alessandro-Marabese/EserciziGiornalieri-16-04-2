package it.epicode.EserciziGiornalieri_16_04_2.blogPost;

import it.epicode.EserciziGiornalieri_16_04_2.autore.Autore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostResponse {
    private Long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

}
