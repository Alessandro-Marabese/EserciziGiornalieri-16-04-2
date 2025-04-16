package it.epicode.EserciziGiornalieri_16_04_2.autore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoreResponse {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String dataDiNascita;
    private String avatar;
}
