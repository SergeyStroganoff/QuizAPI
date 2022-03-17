package com.stroganov.quizapi.controllers;

import com.stroganov.quizapi.exceptions.QuizServiceException;
import com.stroganov.quizapi.models.dto.QuizDto;
import com.stroganov.quizapi.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/quiz")
    public ResponseEntity<String> addQuiz(@RequestBody QuizDto quizDto) throws QuizServiceException {
        quizService.save(quizDto);
        return ResponseEntity.ok("Quiz saved");
    }

    @PutMapping("/quiz/{id}")
    public ResponseEntity<String> changeQuiz(@RequestBody QuizDto quizDto, @PathVariable String id) throws QuizServiceException {
        quizService.change(quizDto, id);
        return ResponseEntity.ok("Quiz changed");
    }

    @DeleteMapping("/quiz/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Long id) throws QuizServiceException {
        quizService.delete(id);
        return ResponseEntity.ok("Quiz deleted");
    }

    @GetMapping("/quiz/{status}")
    public List<QuizDto> findQuizByStatus(@PathVariable boolean status) throws QuizServiceException {
        return quizService.findQuizByStatus(status);
    }
}
