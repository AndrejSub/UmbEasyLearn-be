package com.easylearn.subjectsms.collection.Base;



import com.easylearn.subjectsms.collection.TypesOfQuestions.Flash_cards;
import com.easylearn.subjectsms.collection.TypesOfQuestions.Practical_question;
import com.easylearn.subjectsms.collection.TypesOfQuestions.Text_questions;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class BaseSubject {
    @Id
    private String _id;
    private String subject_id;
    private String subject_name;
    private List<Flash_cards> flash_cards;
    private List<Text_questions> text_questions;
    private List<Practical_question> prakticka_uloha;
}
