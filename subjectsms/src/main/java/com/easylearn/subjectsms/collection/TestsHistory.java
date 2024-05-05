package com.easylearn.subjectsms.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "TestsHistory" )
@NoArgsConstructor
@AllArgsConstructor
public class TestsHistory {
    String _id;
    String email;
    String testID;
    String subjectId;
    String testName;
    String subjectName;
    String creationTime;
    String correctAnswers;
}
