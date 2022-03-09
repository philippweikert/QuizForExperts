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
}
