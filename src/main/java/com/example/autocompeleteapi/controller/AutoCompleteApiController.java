package com.example.autocompeleteapi.controller;

import com.example.autocompeleteapi.service.AutoCompleteApiService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class AutoCompleteApiController {

    @Autowired
    AutoCompleteApiService autoCompleteApiService;


    @GetMapping("/words")
    @ApiOperation(value = "Reads words from file and filter according to the request parameter string if provided or returns all words")
    public ResponseEntity<List<String>> getWords(@RequestParam(required = false) String str){
        List<String> strList = new ArrayList<>();
        try{
            strList = autoCompleteApiService.getWords(str);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(strList, HttpStatus.OK);
    }
}
