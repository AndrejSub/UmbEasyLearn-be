package com.easylearn.subjectsms.dtos;

import com.easylearn.subjectsms.dtos.Base.BaseSubjectDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alg2Dto extends BaseSubjectDto {
}
