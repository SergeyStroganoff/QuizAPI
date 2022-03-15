package com.stroganov.quizapi.controllers;

import com.stroganov.quizapi.exceptions.QuestionTypeServiceException;
import com.stroganov.quizapi.models.dto.QuestionTypeDto;
import com.stroganov.quizapi.service.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok("questionType saved");
    }

    @DeleteMapping("/quiztype/{id}")
    //@JWTTokenNeeded
    public ResponseEntity<String> addQuestionType(@PathVariable Long id) throws QuestionTypeServiceException {
        questionTypeService.delete(id);
        return ResponseEntity.ok("questionType deleted");
    }
}
