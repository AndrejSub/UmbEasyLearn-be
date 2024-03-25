package com.easylearn.usermicroservice.persistence;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "database_sequences")
public class DatabaseSequence {
    private String id;
    private Long seq;
}
