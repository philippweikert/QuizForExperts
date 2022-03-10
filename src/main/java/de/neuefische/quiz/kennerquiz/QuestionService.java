package de.neuefische.quiz.kennerquiz;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepo questionRepo;

    public Question createNewQuestion (Question asked){
        return questionRepo.save(asked);
    }

    public Optional<Question> findById(String id) {
        return questionRepo.findById(id);
    }

    public void deleteQuestion(String id) {
        questionRepo.deleteById(id);
    }

    public Question changeQuestion(Question question) {
        return questionRepo.save(question);
    }

    public Optional<Question> patchQuestion(String id, Question question) {
        return questionRepo.findById(id)
                .map(question1 -> question1.patch(question))
                .map(questionRepo::save);
    }
}
