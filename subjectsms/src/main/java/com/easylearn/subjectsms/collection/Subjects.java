package com.easylearn.subjectsms.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Builder
@Document(collection = "Subjects" )
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {
    @Id
    private String _id;
    private String subjectID;
    private String subjectName;
    private String description;
}
