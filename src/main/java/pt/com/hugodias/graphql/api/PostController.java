package pt.com.hugodias.graphql.api;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import pt.com.hugodias.graphql.api.mapper.PostMapper;
import pt.com.hugodias.graphql.api.types.Author;
import pt.com.hugodias.graphql.api.types.NewPost;
import pt.com.hugodias.graphql.api.types.Post;
import pt.com.hugodias.graphql.domain.authors.AuthorService;
import pt.com.hugodias.graphql.domain.posts.PostRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final AuthorService authorService;

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
        return postRepository.findAll().stream().toList();
    }

    @MutationMapping
    public Post createPost(@Argument(name="post") NewPost newPost){
        Post post = postMapper.toPost(newPost);
        return postRepository.save(post);
    }

    @SchemaMapping
    public Author author(Post post) {
        return authorService.getAuthor(post.getAuthor().getId());
    }

    @SchemaMapping(typeName="Post", field="firstAuthor")
    public Author getFirstAuthor(Post post) {
        return authorService.getAuthor(post.getAuthor().getId());
    }

}
