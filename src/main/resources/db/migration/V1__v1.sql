create TABLE answer
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    user_id BIGINT                NULL,
    CONSTRAINT pk_answer PRIMARY KEY (id)
);

create TABLE question
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    type_id BIGINT                NULL,
    text    VARCHAR(255)          NULL,
    CONSTRAINT pk_question PRIMARY KEY (id)
);

create TABLE quiz
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    startdate     datetime              NULL,
    enddate       datetime              NULL,
    `description` VARCHAR(255)          NULL,
    status        BIT(1)                NULL,
    CONSTRAINT pk_quiz PRIMARY KEY (id)
);

create TABLE qustion_type
(
    type_id BIGINT AUTO_INCREMENT NOT NULL,
    string  VARCHAR(255)          NULL,
    CONSTRAINT pk_qustion_type PRIMARY KEY (type_id)
);

create TABLE user
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    alias VARCHAR(255)          NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

alter table answer
    add CONSTRAINT FK_ANSWER_ON_ID FOREIGN KEY (id) REFERENCES question (id);

alter table answer
    add CONSTRAINT FK_ANSWER_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

alter table question
    add CONSTRAINT FK_QUESTION_ON_ID FOREIGN KEY (id) REFERENCES quiz (id);

alter table question
    add CONSTRAINT FK_QUESTION_ON_TYPE FOREIGN KEY (type_id) REFERENCES qustion_type (type_id);