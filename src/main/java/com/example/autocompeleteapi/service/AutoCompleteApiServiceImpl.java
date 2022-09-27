package com.example.autocompeleteapi.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoCompleteApiServiceImpl implements AutoCompleteApiService{

    @Override
    public List<String> getWords(String str) throws Exception {
        List<String> strList = new ArrayList<>();
        File file = ResourceUtils.getFile("D:/Java/AutoCompeleteApi/src/main/resources/words.txt");
        if(file.exists()) {
            byte[] fileData = Files.readAllBytes(file.toPath());
            String fileContent = new String(fileData);

            strList = List.of(fileContent.split("\n"));
        }

        if(strList.size() != 0 && str != null){
            strList = strList.stream().filter(s -> s.toLowerCase().startsWith(str.toLowerCase())).collect(Collectors.toList());
        }
        return strList;
    }

}
