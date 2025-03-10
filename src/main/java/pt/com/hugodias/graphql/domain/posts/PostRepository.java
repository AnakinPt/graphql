package pt.com.hugodias.graphql.domain.posts;

import org.springframework.data.domain.Pageable;
import pt.com.hugodias.graphql.domain.authors.model.Author;
import pt.com.hugodias.graphql.domain.posts.model.Post;

import java.util.Collection;
import java.util.Optional;

public interface PostRepository {
    Collection<Post> findAll();
    Collection<Post> findAll(Pageable pageable);
    Optional<Post> findById(String id);
    Collection<Post> findByAuthor(Author author);
    Post save(Post post);
}
