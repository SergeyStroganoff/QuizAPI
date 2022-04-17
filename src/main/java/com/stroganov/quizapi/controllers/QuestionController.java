package com.stroganov.quizapi.controllers;

import com.stroganov.quizapi.exceptions.QuestionServiceException;
import com.stroganov.quizapi.models.dto.QuestionDto;
import com.stroganov.quizapi.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/question/{id}")
    public QuestionDto findQuestion(@PathVariable Long id) throws QuestionServiceException {
        return questionService.findQuestion(id);
    }

    @PostMapping("/question")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionDto questionDto) throws QuestionServiceException {
        questionService.save(questionDto);
        return ResponseEntity.ok("Question saved");
    }

    @DeleteMapping("/question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) throws QuestionServiceException {
        questionService.delete(id);
        return ResponseEntity.ok("questionType deleted");
    }
}
