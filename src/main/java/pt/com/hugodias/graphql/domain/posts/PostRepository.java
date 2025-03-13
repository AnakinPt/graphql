package pt.com.hugodias.graphql.domain.posts;

import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;
import pt.com.hugodias.graphql.api.types.Author;
import pt.com.hugodias.graphql.api.types.Post;

public interface PostRepository {
    Collection<Post> findAll();
    Collection<Post> findAll(Pageable pageable);
    Optional<Post> findById(String id);
    Collection<Post> findByAuthor(Author author);
    Post save(Post post);
    Collection<Post> findByAuthorId(String authorId);
}
