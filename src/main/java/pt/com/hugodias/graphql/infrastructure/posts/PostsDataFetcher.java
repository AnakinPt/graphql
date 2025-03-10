package pt.com.hugodias.graphql.infrastructure.posts;

import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pt.com.hugodias.graphql.domain.authors.model.Author;
import pt.com.hugodias.graphql.domain.posts.PostRepository;
import pt.com.hugodias.graphql.domain.posts.model.Post;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PostsDataFetcher implements PostRepository {

    private final Map<String, Post> posts = new HashMap<>();

    @PostConstruct
    public void init() {
        posts.put("id1", Post.builder().id("id1").title("Spring Data to manage data").author(Author.builder().id("hugo").build()).build());
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    @Override
    public Collection<Post> findAll(Pageable pageable) {
        int start = (pageable.getPageNumber() - 1) * pageable.getPageSize();
        int end = pageable.getPageNumber()  * pageable.getPageSize();
        return posts.values().stream().toList().subList(start, end);
    }

    public Optional<Post> findById(String id) {
        return Optional.ofNullable(posts.get(id));
    }

    public Collection<Post> findByAuthor(Author author) {
        return posts.values().stream().filter(post -> post.getAuthor().equals(author)).toList();
    }

    public Post save(Post post) {
        posts.put(post.getId(), post);
        return post;
    }

}
