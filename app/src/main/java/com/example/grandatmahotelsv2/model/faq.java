package com.example.grandatmahotelsv2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class faq {

    private Integer IdFaq;
    private String Question;
    private String Answer;



    public Integer getIdFaq() {
        return IdFaq;
    }

    public void setIdFaq(Integer idFaq) {
        IdFaq = idFaq;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
