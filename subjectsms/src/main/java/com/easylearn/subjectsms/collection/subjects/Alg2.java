package com.easylearn.subjectsms.collection.subjects;




import com.easylearn.subjectsms.collection.Base.BaseSubject;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Document(collection = "Alg2" )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alg2 extends BaseSubject {
}
