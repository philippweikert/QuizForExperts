package de.neuefische.quiz.kennerquiz;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asked")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public Question createNewQuestion(@RequestBody Question asked) {
        return questionService.createNewQuestion(asked);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findQuestionById(@PathVariable String id) {
        return ResponseEntity.of(questionService.findById(id));
    }

   /* @PutMapping("/{id)")
    public Question changeQuestions(@PathVariable String id, @RequestBody String asked){
        return questionService.changeQuestion(id, asked);

    } */

    @DeleteMapping("/{id}")
    public void deleteQuestionById(@PathVariable String id) {
        questionService.deleteQuestion(id);
    }
}
