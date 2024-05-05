package com.easylearn.subjectsms.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestsHistoryDto {
    String _id;
    String email;
    String testID;
    String subjectId;
    String testName;
    String subjectName;
    String correctAnswers;
    String questionsCount;
}
