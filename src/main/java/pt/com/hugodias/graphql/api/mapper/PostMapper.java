package pt.com.hugodias.graphql.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import pt.com.hugodias.graphql.api.type.NewPost;
import pt.com.hugodias.graphql.domain.authors.AuthorService;
import pt.com.hugodias.graphql.domain.posts.model.Post;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {AuthorService.class})
public interface PostMapper {

    @Mapping(target="id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target="firstAuthor", source = "author")
    Post toPost(NewPost newPost);
}
