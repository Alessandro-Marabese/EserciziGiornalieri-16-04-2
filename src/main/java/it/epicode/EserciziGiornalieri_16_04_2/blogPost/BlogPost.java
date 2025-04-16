package it.epicode.EserciziGiornalieri_16_04_2.blogPost;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.epicode.EserciziGiornalieri_16_04_2.autore.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blog_post")

public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String categoria;

    @Column(nullable = false, length = 100)
    private String titolo;

    @Column(nullable = false)
    private String cover;

    @Column(nullable = false, length = 100)
    private String contenuto;

    @Column(nullable = false)
    private int tempoDiLettura;

    @ManyToOne
    @JsonIgnoreProperties("blogPost")
    private Autore autore;

}
