package com.easylearn.subjectsms.collection.subjects;




import com.easylearn.subjectsms.collection.Base.BasePredmet;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Document(collection = "Matika" )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Matika extends BasePredmet {
}