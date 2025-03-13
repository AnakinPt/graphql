package pt.com.hugodias.graphql.domain.authors;


import java.util.Collection;
import java.util.Optional;
import pt.com.hugodias.graphql.api.types.Author;

public interface AuthorRepository {
    Collection<Author> findAll();
    Optional<Author> findById(String id);
    Author save(Author author);
}
