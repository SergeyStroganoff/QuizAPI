package com.stroganov.quizapi.controllers;


import com.stroganov.quizapi.exceptions.QuestionTypeServiceException;
import com.stroganov.quizapi.exceptions.QuizServiceException;
import com.stroganov.quizapi.models.dto.QuestionTypeDto;
import com.stroganov.quizapi.service.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionTypeController {

    @Autowired
    private QuestionTypeService questionTypeService;

    @PostMapping("/quiztype")
    //@JWTTokenNeeded
    public ResponseEntity<String> addQuestionType(@RequestBody QuestionTypeDto questionTypeDto) throws QuestionTypeServiceException {
        questionTypeService.save(questionTypeDto);
        return ResponseEntity.ok("Quiz saved");
    }
}
