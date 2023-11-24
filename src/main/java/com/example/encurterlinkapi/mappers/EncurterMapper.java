package com.example.encurterlinkapi.mappers;

import com.example.encurterlinkapi.dtos.EncurterDto;
import com.example.encurterlinkapi.models.EncurterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EncurterMapper {
    @Mapping(target = "encurter_id", ignore = true)
    EncurterModel toEncurterModel(EncurterDto encurterDto);
}
