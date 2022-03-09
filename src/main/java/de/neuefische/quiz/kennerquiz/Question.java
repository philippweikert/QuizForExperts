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
}
