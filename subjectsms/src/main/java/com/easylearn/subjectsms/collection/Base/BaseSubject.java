package com.easylearn.subjectsms.collection.Base;



import com.easylearn.subjectsms.collection.TypesOfQuestions.FlashCards;
import com.easylearn.subjectsms.collection.TypesOfQuestions.PracticalQuestions;
import com.easylearn.subjectsms.collection.TypesOfQuestions.TextQuestions;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class BaseSubject {
    @Id
    private String _id;
    private String subject_id;
    private String subject_name;
    private List<FlashCards> flash_cards;
    private List<TextQuestions> text_questions;
    private List<PracticalQuestions> prakticka_uloha;
}
