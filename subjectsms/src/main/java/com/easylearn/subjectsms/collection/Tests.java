package com.easylearn.subjectsms.collection;

import com.easylearn.subjectsms.collection.TypesOfQuestions.FlashCards;
import com.easylearn.subjectsms.collection.TypesOfQuestions.PracticalQuestions;
import com.easylearn.subjectsms.collection.TypesOfQuestions.TextQuestions;
import com.easylearn.subjectsms.collection.TypesOfQuestions.abcQuestions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Document(collection = "Tests" )
@NoArgsConstructor
@AllArgsConstructor
public class Tests {
    @Id
    private String _id;
    private String testName;
    private String testID;
    private String subjectID;
    private List<FlashCards> flashCards;
    private List<TextQuestions> textQuestions;
    private List<PracticalQuestions> practicalQuestions;
    private List<abcQuestions> abcQuestions;

}
