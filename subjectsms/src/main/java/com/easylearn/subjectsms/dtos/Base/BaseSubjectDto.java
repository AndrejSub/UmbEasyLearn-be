package com.easylearn.subjectsms.dtos.Base;

import com.easylearn.subjectsms.collection.TypesOfQuestions.Flash_cards;
import com.easylearn.subjectsms.collection.TypesOfQuestions.Practical_question;
import com.easylearn.subjectsms.collection.TypesOfQuestions.Text_questions;
import lombok.Data;


import java.util.List;

@Data
public class BaseSubjectDto {
    private String _id;
    private String subject_id;
    private String subject_name;
    private List<Flash_cards> flash_cards;
    private List<Text_questions> text_questions;
    private List<Practical_question> prakticka_uloha;
}
