package com.example.smallcompany.Coontroller;

import com.example.smallcompany.payload.ApiResponce;
import com.example.smallcompany.payload.CompanyDto;
import com.example.smallcompany.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Company")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public HttpEntity<?> addCompany(@Valid @RequestBody CompanyDto companyDto) {
        ApiResponce apiResponce = companyService.addCompany(companyDto);
        return ResponseEntity.status(apiResponce.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(apiResponce);
    }


}
