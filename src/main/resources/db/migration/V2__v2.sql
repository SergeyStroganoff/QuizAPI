alter table answer
    add value VARCHAR(255) NULL;

alter table answer
    drop FOREIGN KEY FK_ANSWER_ON_ID;

alter table question
    drop FOREIGN KEY FK_QUESTION_ON_ID;

alter table user_quiz
    drop FOREIGN KEY fk_user_quiz_on_quiz;

alter table user_quiz
    drop FOREIGN KEY fk_user_quiz_on_user;

drop table user_quiz;