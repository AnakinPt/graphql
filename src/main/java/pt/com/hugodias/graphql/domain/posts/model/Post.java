package pt.com.hugodias.graphql.domain.posts.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import pt.com.hugodias.graphql.domain.authors.ValidAuthor;
import pt.com.hugodias.graphql.domain.authors.model.Author;

@Data
@Builder
public class Post {
    @NotBlank
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String text;

    private String category;

    @ValidAuthor
    private Author author;

    private Author firstAuthor;
}
