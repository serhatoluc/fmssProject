package com.hrproject.fmssproject.exception.permission;

public class PermissionNotFoundException extends RuntimeException{
    public PermissionNotFoundException (String messege){
        super(messege);
    }
}