package com.easylearn.subjectsms.helpers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BaseMapper<Entity ,DTO > {
    private final ModelMapper modelMapper;

    public BaseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }



    public DTO mapEntityToDto(Entity entity, Class<DTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public Entity mapDtoToEntity(DTO dto, Class<Entity> entityClass) {
        try {
            Entity t = modelMapper.map(dto, entityClass);
            return t;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<Entity> mapListDtoToListEntity(List<DTO> dtoList, Class<Entity> entityClass) {
        return dtoList.stream()
                .map(dto -> mapDtoToEntity(dto, entityClass))
                .collect(Collectors.toList());
    }

    public List<DTO> mapListEntityToListDto(List<Entity> entityList, Class<DTO> dtoClass) {
        return entityList.stream()
                .map(entity -> mapEntityToDto(entity, dtoClass))
                .collect(Collectors.toList());

    }




}
