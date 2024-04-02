package com.easylearn.subjectsms.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectsDto {
    private String _id;
    private String subjectID;
    private String subjectName;
    private String description;
}
