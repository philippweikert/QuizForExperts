package de.neuefische.quiz.kennerquiz;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor
class KennerQuizApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        Question question = new Question();
        question.setAsked("How shall I get off the bus?");

        ResponseEntity<Question> postResponse = restTemplate.postForEntity("/api/asked", question, Question.class);
        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse.getBody().getId()).isNotNull();
        assertThat(postResponse.getBody().getAsked()).isEqualTo("How shall I get off the bus?");

        ResponseEntity<Question> getResponse = restTemplate.getForEntity("/api/asked/" + postResponse.getBody().getId(), Question.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse.getBody().getId()).isNotNull();
        assertThat(getResponse.getBody().getAsked()).isEqualTo("How shall I get off the bus?");

    }

}
