package com.example.autocompeleteapi.service;

import java.util.List;

public interface AutoCompleteApiService {
    List<String> getWords(String str) throws Exception;
}
