package it.epicode.EserciziGiornalieri_16_04_2.blogPost;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostInsertRequest {
    @NotBlank(message = "Categoria is mandatory")
    private String categoria;
    @NotBlank(message = "Titolo is mandatory")
    private String titolo;
    @NotBlank(message = "Cover is mandatory")
    private String cover;
    @NotBlank(message = "Contenuto is mandatory")
    private String contenuto;
    @Min(value = 0, message = "Tempo di lettura must be greater than 0")
    @Max(value = 10, message = "Tempo di lettura must be less than 10")
    private int tempoDiLettura;
    private Long autoreId;
}
