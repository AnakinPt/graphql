package pt.com.hugodias.graphql.domain.authors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pt.com.hugodias.graphql.domain.authors.model.Author;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author getAuthor(String id){
        return authorRepository.findById(id).orElseThrow();
    }
}
