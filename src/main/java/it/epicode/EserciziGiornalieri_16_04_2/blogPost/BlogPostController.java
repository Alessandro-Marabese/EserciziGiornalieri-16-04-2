package it.epicode.EserciziGiornalieri_16_04_2.blogPost;

import it.epicode.EserciziGiornalieri_16_04_2.common.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPost")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/{id}")
    public BlogPostResponse findById(@PathVariable Long id) {
        return blogPostService.findById(id);
    }

    @GetMapping
    public List<BlogPost> findAll() {
        return blogPostService.findFull();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommonResponse save(@RequestBody  BlogPostInsertRequest request) {
        return blogPostService.save(request);
    }

    @PutMapping("/{id}")
    public BlogPostResponse update(@PathVariable Long id, @RequestBody BlogPostInsertRequest request) {
        return blogPostService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        blogPostService.deleteById(id);
    }
}
