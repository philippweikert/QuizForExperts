package de.neuefische.quiz.kennerquiz;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "questions")
@Data
public class Question {

    @Id
    public String id;
    public String asked;


public Question patch(Question question) {
    if (question.getAsked() != null) {
    setAsked(question.getAsked());
    }

    return this;
}

public Question update (Question question){
    setAsked(question.getAsked());
    return this;
}
}
