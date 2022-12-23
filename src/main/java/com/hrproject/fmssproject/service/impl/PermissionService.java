package com.hrproject.fmssproject.service.impl;

import com.hrproject.fmssproject.client.dto.request.CreatePermissionRequestDto;
import com.hrproject.fmssproject.client.dto.request.UpdatePermissionRequestDto;
import com.hrproject.fmssproject.client.dto.response.ResponsePermissionDto;
import com.hrproject.fmssproject.client.dto.response.UpdatePermissionResponseDto;
import com.hrproject.fmssproject.exception.employee.EmployeeNotFoundException;
import com.hrproject.fmssproject.exception.permission.PermissionNotFoundException;
import com.hrproject.fmssproject.mapper.PermissionMapper;
import com.hrproject.fmssproject.model.Employee;
import com.hrproject.fmssproject.model.Permission;
import com.hrproject.fmssproject.repository.EmployeeRepository;
import com.hrproject.fmssproject.repository.PermissionRepository;
import com.hrproject.fmssproject.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService implements IPermissionService {
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public ResponsePermissionDto createPermission(Integer id, CreatePermissionRequestDto createPermissionRequestDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow( () -> new EmployeeNotFoundException("Boyle Bir Kullanici Olmadigi Icin Izin Olusturamazsiniz!"));
        Permission permission = permissionMapper.toPermissionFromCreatePermissionRequest(createPermissionRequestDto);
        List<Permission> permissionList = new ArrayList<>();
        permissionList.add(permission);
        permission.setEmployee(employee);
        employee.setPermissionList(permissionList);
        permissionRepository.save(permission);
        return permissionMapper.toResponsePermissionDtoFromCreatePermissionRequestDto(createPermissionRequestDto);
    }

    @Override
    public List<ResponsePermissionDto> getPermissionByEmployeeId(Integer id) {
        return permissionMapper.toListResponsePermissionFromListPermission(employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Aradiginiz Izne Ait Kullanici Bulunamadi")
        ).getPermissionList());
    }

    @Override
    public void deleteAllPermissionByEmployeeId(Integer id) {
        permissionRepository.deletePermissionByEmployeeId(id);
    }

    @Override
    public void deletePermissionById(Integer id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public UpdatePermissionResponseDto updatePermissionByEmployeeId(Integer permissionId, UpdatePermissionRequestDto updatePermissionRequestDto) {
        Permission permission = permissionRepository.findById(permissionId).orElseThrow(() -> new PermissionNotFoundException("Duzenlemek Istediginiz Izine Ulasilamiyor."));

        if(LocalDate.now().isBefore(permission.getStartPermission())){
            permissionRepository.save(permissionMapper.toPermissionFromUpdatePermissionRequestDto(permission, updatePermissionRequestDto));
            return permissionMapper.toUpdatePermissionResponseDtoFromUpdatePermissionRequestDto(updatePermissionRequestDto);
        }else
            throw new PermissionNotFoundException("Tarihi Gecmis Izinleri Duzenleyemezsiniz!");
    }
}
