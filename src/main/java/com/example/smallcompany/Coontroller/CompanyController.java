package com.example.smallcompany.Coontroller;

import com.example.smallcompany.entity.Company;
import com.example.smallcompany.payload.ApiResponse;
import com.example.smallcompany.payload.CompanyDto;
import com.example.smallcompany.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/Company")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public HttpEntity<?> addCompany(@Valid @RequestBody CompanyDto companyDto) {
        ApiResponse apiResponse = companyService.addCompany(companyDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(apiResponse);
    }
    @GetMapping
    private HttpEntity<?> getCompanies(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size){
     List<Company> companyList=  companyService.getCompanies(page, size);
     return ResponseEntity.ok(companyList);


    }



}
