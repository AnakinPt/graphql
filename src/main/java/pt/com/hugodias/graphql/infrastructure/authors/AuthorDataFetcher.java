package pt.com.hugodias.graphql.infrastructure.authors;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import pt.com.hugodias.graphql.api.types.Author;
import pt.com.hugodias.graphql.domain.authors.AuthorRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthorDataFetcher implements AuthorRepository {

    private final Map<String, Author> authors = new HashMap<>();

    @PostConstruct
    public void init(){
        authors.put("hugo", Author.newBuilder().id("hugo").name("Hugo Dias").build());
    }

    @Override
    public Collection<Author> findAll() {
        return authors.values();
    }

    @Override
    public Optional<Author> findById(String id) {
        return Optional.ofNullable(authors.get(id));
    }

    @Override
    public Author save(Author author) {
        authors.put(author.getId(), author);
        return author;
    }
}
