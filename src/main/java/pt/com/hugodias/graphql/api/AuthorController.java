package pt.com.hugodias.graphql.api;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pt.com.hugodias.graphql.domain.authors.AuthorRepository;
import pt.com.hugodias.graphql.domain.authors.model.Author;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;

    @MutationMapping
    public Author createAuthor(@Argument String name,@Argument String thumbnail){
        Author author = Author.builder()
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

}
