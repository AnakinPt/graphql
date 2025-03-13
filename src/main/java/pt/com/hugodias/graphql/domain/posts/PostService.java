package pt.com.hugodias.graphql.domain.posts;

import org.springframework.stereotype.Service;

import java.util.Collection;
import lombok.RequiredArgsConstructor;
import pt.com.hugodias.graphql.api.types.Post;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post getPost(String id){
        return postRepository.findById(id).orElseThrow();
    }

    public Collection<Post> getPostFromAuthor(String authorId){
        return postRepository.findByAuthorId(authorId);
    }
}
