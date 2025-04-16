package it.epicode.EserciziGiornalieri_16_04_2.blogPost;

import it.epicode.EserciziGiornalieri_16_04_2.autore.Autore;
import it.epicode.EserciziGiornalieri_16_04_2.autore.AutoreRepository;
import it.epicode.EserciziGiornalieri_16_04_2.common.CommonResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    public CommonResponse save(BlogPostInsertRequest request) {
        BlogPost blogPost = new BlogPost();

        BeanUtils.copyProperties(request, blogPost);

        Autore autore = autoreRepository.findById(request.getAutoreId())
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
        blogPost.setAutore(autore);

        blogPostRepository.save(blogPost);

        return new CommonResponse(blogPost.getId());
    }

    public BlogPostResponse update(Long id, BlogPostInsertRequest request) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BlogPost non trovato"));

        BeanUtils.copyProperties(request, blogPost);

        Autore autore = autoreRepository.findById(request.getAutoreId())
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
        blogPost.setAutore(autore);

        blogPostRepository.save(blogPost);

        BlogPostResponse response = new BlogPostResponse();
        BeanUtils.copyProperties(blogPost, response);

        return response;
    }

    public void deleteById(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BlogPost non trovato"));

        blogPostRepository.delete(blogPost);
    }

    public BlogPostResponse findById(Long id) {

        BlogPost blogPost = blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BlogPost non trovato"));

        BlogPostResponse response = new BlogPostResponse();
        BeanUtils.copyProperties(blogPost, response);

        return response;
    }

    public List<BlogPost> findFull() {
        return blogPostRepository.findAll();
    }
}
