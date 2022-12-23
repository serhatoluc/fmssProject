package com.hrproject.fmssproject.service;

import com.hrproject.fmssproject.client.dto.request.CreatePermissionRequestDto;
import com.hrproject.fmssproject.client.dto.request.UpdatePermissionRequestDto;
import com.hrproject.fmssproject.client.dto.response.ResponsePermissionDto;
import com.hrproject.fmssproject.client.dto.response.UpdatePermissionResponseDto;

import java.util.List;


public interface IPermissionService {
    ResponsePermissionDto createPermission(Integer id, CreatePermissionRequestDto createPermissionRequestDto);

    List<ResponsePermissionDto> getPermissionByEmployeeId(Integer id);


    void deleteAllPermissionByEmployeeId(Integer id);

    void deletePermissionById(Integer id);

    UpdatePermissionResponseDto updatePermissionByEmployeeId(Integer permissionId, UpdatePermissionRequestDto updatePermissionRequestDto);
}
