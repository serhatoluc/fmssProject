package com.hrproject.fmssproject.controller;

import com.hrproject.fmssproject.client.dto.request.CreatePermissionRequestDto;
import com.hrproject.fmssproject.client.dto.request.UpdatePermissionRequestDto;
import com.hrproject.fmssproject.client.dto.response.ResponsePermissionDto;
import com.hrproject.fmssproject.client.dto.response.UpdatePermissionResponseDto;
import com.hrproject.fmssproject.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permission")
@CrossOrigin
@RequiredArgsConstructor
public class PermissionController {
    private final IPermissionService iPermissionService;

    @PostMapping("/{id}")
    public ResponseEntity<ResponsePermissionDto> createPermission(@PathVariable Integer id, @RequestBody CreatePermissionRequestDto createPermissionRequestDto){
        return ResponseEntity.ok(iPermissionService.createPermission(id, createPermissionRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ResponsePermissionDto>> getPermissionByEmployeeId(@PathVariable Integer id){
        return ResponseEntity.ok(iPermissionService.getPermissionByEmployeeId(id));
    }

    // Bu method deneme icin yazildi.
    @DeleteMapping("/all/{id}")
    public void deleteAllPermissionByEmployeeId(@PathVariable Integer id){
        iPermissionService.deleteAllPermissionByEmployeeId(id);
    }

    @DeleteMapping("/{id}")
    public void deletePermissionById(@PathVariable Integer id){
        iPermissionService.deletePermissionById(id);
    }

    @PutMapping("/{permissionId}")
    public ResponseEntity<UpdatePermissionResponseDto> updatePermissionById(@PathVariable Integer permissionId, @RequestBody UpdatePermissionRequestDto updatePermissionRequestDto){
        return ResponseEntity.ok(iPermissionService.updatePermissionByEmployeeId(permissionId, updatePermissionRequestDto));
    }
}
