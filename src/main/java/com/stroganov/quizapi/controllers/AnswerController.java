package com.stroganov.quizapi.controllers;

import com.stroganov.quizapi.exceptions.AnswerServiceException;
import com.stroganov.quizapi.models.dto.AnswerDto;
import com.stroganov.quizapi.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @DeleteMapping("/answer/{id}")
    public ResponseEntity<String> findAnswer(@PathVariable Long id) throws AnswerServiceException {
        answerService.delete(id);
        return ResponseEntity.ok("questionType deleted");
    }

    @PostMapping("/answer")
    public ResponseEntity<String> addAnswer(@RequestBody AnswerDto answerDto) throws AnswerServiceException {
        answerService.save(answerDto);
        return ResponseEntity.ok("Question saved");
    }

    @GetMapping("/answer")  // gey list of answers by user id and quiz id
    public List<AnswerDto> findAllUsersAnswer(@RequestParam String quizId,@RequestParam String userId ) throws AnswerServiceException {
        return answerService.findAllByUserAndQuiz(quizId,userId);

    }
}
