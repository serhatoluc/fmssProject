package com.hrproject.fmssproject.repository;

import com.hrproject.fmssproject.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    List<Permission> deletePermissionByEmployeeId(Integer id);
}
