package com.hrproject.fmssproject.client.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrproject.fmssproject.model.enums.Department;
import com.hrproject.fmssproject.model.enums.Title;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateEmployeeRequestDto {

    @NotNull(message = "Isim Alani Bos Birakilamaz!")
    private String name;

    @NotNull(message = "Soy Isim Alani Bos Birakilamaz!")
    private String lastName;

    @NotNull(message = "Mail Alani Bos Birakilamaz!")
    private String email;

    @NotNull(message = "T.C. Kimlik Numarasi Alani Bos Birakilamaz!")
    private Long identificationNumber;

    @NotNull(message = "Maas Alani Bos Birakilamaz!")
    private BigDecimal salary;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @NotNull(message = "Katilim Tarihi Alani Bos Birakilamaz!")
    private LocalDate dateOfParticipation;


    @NotNull(message = "Title Alani Bos Birakilamaz!")
    private Title title;


    @NotNull(message = "Departman Alani Bos Birakilamaz!")
    private Department department;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @NotNull(message = "Dogum Tarihi Alani Bos Birakilamaz!")
    private LocalDate birthDate;

    @NotNull(message = "Adres Alani Bos Birakilamaz!")
    private String addressLine;

    @NotNull(message = "Sehir Alani Bos Birakilamaz!")
    private String city;

    @NotNull(message = "Telefon Alani Bos Birakilamaz!")
    private Long phoneNumber;

    @NotNull(message = "Ulke Alani Bos Birakilamaz!")
    private String country;

    private String postalCode;

}
