package com.easylearn.subjectsms.dtos;

import com.easylearn.subjectsms.collection.TypesOfQuestions.FlashCards;
import com.easylearn.subjectsms.collection.TypesOfQuestions.PracticalQuestions;
import com.easylearn.subjectsms.collection.TypesOfQuestions.TextQuestions;
import com.easylearn.subjectsms.collection.TypesOfQuestions.abcQuestions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestsDto {
    private String _id;
    private String testName;
    private String testID;
    private String subjectID;
    private List<FlashCards> flashCards;
    private List<TextQuestions> textQuestions;
    private List<PracticalQuestions> practicalQuestions;
    private List<abcQuestions> abcQuestions;
}
