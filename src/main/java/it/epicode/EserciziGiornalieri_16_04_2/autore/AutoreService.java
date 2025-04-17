package it.epicode.EserciziGiornalieri_16_04_2.autore;

import it.epicode.EserciziGiornalieri_16_04_2.common.CommonResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public CommonResponse save(@Valid AutoreInsertRequest request) {
        Autore autore = new Autore();
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);
        return new CommonResponse(autore.getId());
    }

    public void deleteById(Long id) {
        Autore autore = autoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
        autoreRepository.delete(autore);
    }

    public AutoreResponse findById(Long id) {
        Autore autore = autoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
        AutoreResponse response = new AutoreResponse();
        BeanUtils.copyProperties(autore, response);
        return response;
    }

    public List<Autore> findFull() { return autoreRepository.findAll(); }

    public AutoreResponse update(Long id, AutoreInsertRequest request) {
        Autore autore = autoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);
        AutoreResponse response = new AutoreResponse();
        BeanUtils.copyProperties(autore, response);
        return response;
    }

    public Page<AutoreResponse> getAutori(Pageable pageable) {
        return autoreRepository.findAll(pageable).map(this::fromEntity);
    }

    public AutoreResponse fromEntity(Autore autore) {
        AutoreResponse response = new AutoreResponse();
        BeanUtils.copyProperties(autore, response);
        return response;
    }
}
