package pt.com.hugodias.graphql.domain.authors;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import pt.com.hugodias.graphql.api.types.Author;

@RequiredArgsConstructor
public class AuthorValidator implements ConstraintValidator<ValidAuthor, Author> {
    private final AuthorRepository authorRepository;

    @Override
    public boolean isValid(Author author, ConstraintValidatorContext constraintValidatorContext) {
        return author != null && authorRepository.findById(author.getId()).isPresent();
    }
}
