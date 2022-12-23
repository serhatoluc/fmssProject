package com.hrproject.fmssproject.mapper;

import com.hrproject.fmssproject.client.dto.request.CreateEmployeeRequestDto;
import com.hrproject.fmssproject.model.Address;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(implementationName = "AddressMapperImpl" , componentModel = "spring")
public interface AddressMapper {

    Address toAddressFromCreateEmployeeRequestDto(CreateEmployeeRequestDto createEmployeeRequestDto);
}
