package com.easylearn.subjectsms.collection.TypesOfQuestions;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class abcQuestions {
    private String questionID;
    private String a;
    private String b;
    private String c;
    private String question;
}
