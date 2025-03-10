package pt.com.hugodias.graphql.domain.authors.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import pt.com.hugodias.graphql.domain.posts.model.Post;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Author {
    @NotBlank
    private String id;

    @NotBlank
    private String name;

    private String thumbnail;

    @Builder.Default private List<Post> posts = new ArrayList<>();
}