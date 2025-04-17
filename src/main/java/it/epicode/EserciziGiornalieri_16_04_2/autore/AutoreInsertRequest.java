package it.epicode.EserciziGiornalieri_16_04_2.autore;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoreInsertRequest {
    @NotBlank(message = "Nome is mandatory")
    private String nome;
    @NotBlank(message = "Cognome is mandatory")
    private String cognome;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Data di nascita is mandatory")
    private String dataDiNascita;
    @NotBlank(message = "Avatar is mandatory")
    private String avatar;
}
