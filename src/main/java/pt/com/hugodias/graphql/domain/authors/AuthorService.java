package pt.com.hugodias.graphql.domain.authors;

import lombok.RequiredArgsConstructor;
import pt.com.hugodias.graphql.api.types.Author;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author getAuthor(String id){
        return authorRepository.findById(id).orElseThrow();
    }
}
