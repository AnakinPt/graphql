package pt.com.hugodias.graphql.domain.authors;


import pt.com.hugodias.graphql.domain.authors.model.Author;

import java.util.Collection;
import java.util.Optional;

public interface AuthorRepository {
    Collection<Author> findAll();
    Optional<Author> findById(String id);
    Author save(Author author);
}
