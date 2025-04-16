package it.epicode.EserciziGiornalieri_16_04_2.autore;

import it.epicode.EserciziGiornalieri_16_04_2.blogPost.BlogPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autore")
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String cognome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String dataDiNascita;

    @Column(nullable = false, length = 100)
    private String avatar;

    @OneToMany(mappedBy = "autore")
    private List<BlogPost> blogPost = new ArrayList<>();


}
