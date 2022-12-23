package com.hrproject.fmssproject.mapper;

import com.hrproject.fmssproject.client.dto.request.CreatePermissionRequestDto;
import com.hrproject.fmssproject.client.dto.request.UpdatePermissionRequestDto;
import com.hrproject.fmssproject.client.dto.response.ResponsePermissionDto;
import com.hrproject.fmssproject.client.dto.response.UpdatePermissionResponseDto;
import com.hrproject.fmssproject.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(implementationName = "PermissionMapperImpl", componentModel = "spring")
public interface PermissionMapper {

    List<ResponsePermissionDto> toListResponsePermissionFromListPermission(List<Permission> permissionsList);
    Permission toPermissionFromCreatePermissionRequest(CreatePermissionRequestDto createPermissionRequestDto);
    ResponsePermissionDto toResponsePermissionDtoFromCreatePermissionRequestDto(CreatePermissionRequestDto createPermissionRequestDto);
    UpdatePermissionResponseDto toUpdatePermissionResponseDtoFromUpdatePermissionRequestDto(UpdatePermissionRequestDto updatePermissionRequestDto);

    Permission toPermissionFromUpdatePermissionRequestDto(@MappingTarget Permission permission, UpdatePermissionRequestDto updatePermissionRequestDto);
}
