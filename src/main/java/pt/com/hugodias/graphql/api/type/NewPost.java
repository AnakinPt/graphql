package pt.com.hugodias.graphql.api.type;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewPost {
    @NotBlank
    private String title;

    @NotBlank
    private String text;

    private String category;

    private String author;
}
