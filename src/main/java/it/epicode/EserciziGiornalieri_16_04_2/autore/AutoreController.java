package it.epicode.EserciziGiornalieri_16_04_2.autore;


import it.epicode.EserciziGiornalieri_16_04_2.common.CommonResponse;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @GetMapping("/{id}")
    public AutoreResponse findById(@PathVariable Long id) {
        return autoreService.findById(id);
    }

    @GetMapping
    public Page<AutoreResponse> getAutori(@ParameterObject Pageable pageable) {
        return autoreService.getAutori(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse save(@RequestBody @Valid AutoreInsertRequest request) {
        return autoreService.save(request);
    }

    @PutMapping("/{id}")
    public AutoreResponse update(@PathVariable Long id, @RequestBody AutoreInsertRequest request) {
        return autoreService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        autoreService.deleteById(id);
    }
}
