package com.hrproject.fmssproject.client.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreatePermissionRequestDto {

    private String typeOfPermission;
    private Long totalPermission;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate startPermission;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate finishPermission;
    private String explanation;
}
