package it.epicode.EserciziGiornalieri_16_04_2.cloudinary;

import com.cloudinary.Cloudinary;
import it.epicode.EserciziGiornalieri_16_04_2.email.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class CloudinaryController {
    private final Cloudinary cloudinary;
    private final EmailService emailService;

    @PostMapping(path="/uploadme", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(
            @RequestPart("file")
            MultipartFile file) {

        try {
            Map result = cloudinary.uploader()
                    .upload(file.getBytes(),  Cloudinary.asMap("folder", "FS1024", "public_id", file.getOriginalFilename()));

            String url = result.get("secure_url").toString();

            emailService.sendEmail(
                    "manuelcasanuova@gmail.com",
                    "salvataggio immagine" ,
                    "<h3>Immagine salvata</h3> <p>Abbiamo salvato questa immagine: <img src='" + url + "' /> </p>"
            );

            System.out.println(url);
        } catch (IOException | MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
