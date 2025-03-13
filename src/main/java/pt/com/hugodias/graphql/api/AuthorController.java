package pt.com.hugodias.graphql.api;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import pt.com.hugodias.graphql.api.types.Author;
import pt.com.hugodias.graphql.api.types.Post;
import pt.com.hugodias.graphql.domain.authors.AuthorRepository;

import java.util.List;
import java.util.UUID;
import pt.com.hugodias.graphql.domain.authors.AuthorService;
import pt.com.hugodias.graphql.domain.posts.PostService;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final PostService postService;

    @MutationMapping
    public Author createAuthor(@Argument String name, @Argument String thumbnail){
        Author author = Author.newBuilder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .thumbnail(thumbnail)
                .build();

        return authorRepository.save(author);
    }

    @QueryMapping
    public List<Author> authorsList(@Argument String name){
        return authorRepository.findAll().stream().toList();
    }

    @SchemaMapping
    public List<Post> posts(Author author){
        return postService.getPostFromAuthor(author.getId()).stream().toList();
    }
}
