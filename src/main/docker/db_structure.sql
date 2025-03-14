
DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA IF NOT EXISTS public;

--
--
 CREATE TABLE public.role
 (
     id INT primary key GENERATED ALWAYS AS IDENTITY,
     name character varying(50) NOT NULL,
     PRIMARY KEY (name)

     CONSTRAINT role_name_key UNIQUE (name),
     CONSTRAINT role_pkey PRIMARY KEY (id)
 );


--
 INSERT INTO public.role(id, name)
 VALUES (1,'ROLE_ADMIN');
--
 INSERT INTO public.role(name)
 VALUES ('ROLE_USER');
--
--
 CREATE TABLE public.user (
         id INT primary key GENERATED ALWAYS AS IDENTITY,
         username varchar(250) UNIQUE NOT NULL,
         id_role integer NOT NULL,
         CONSTRAINT fk_id_role FOREIGN KEY (id_role)
             REFERENCES public.role (id),
         email varchar(250) UNIQUE NOT NULL,
         token varchar(250),
         password character varying(60) NOT NULL
 );




-- INSERT INTO aubay.user (id, username, id_role, email, token, password) VALUES (1,'dtrump', 1, 'dtrump@gmail.com', null, '$2a$12$RkcdJn2kLrAS9fmvDv/CWehqID8nB3XBWXOtazhQ2PY1ZFwDB3L76');
-- INSERT INTO aubay.user (id,username, id_role, email, token, password) VALUES (2,'emusk', 1, 'emusk@gmail.com', null, '$2a$12$RkcdJn2kLrAS9fmvDv/CWehqID8nB3XBWXOtazhQ2PY1ZFwDB3L76');
-- INSERT INTO aubay.user (id,username, id_role, email, token, password) VALUES (3,'aeinstein', 1, 'aeinstein@gmail.com', null, '$2a$12$RkcdJn2kLrAS9fmvDv/CWehqID8nB3XBWXOtazhQ2PY1ZFwDB3L76');
--

 CREATE TYPE "test_status" AS ENUM (
   'draft',
   'ready_to_use',
   'archived'
 );

-- CREATE TABLE "test" (
--   "id" SERIAL PRIMARY KEY,
--   "title" varchar(250) UNIQUE NOT NULL,
--   "description" TEXT,
--   "max_time" integer,
--   "status" test_status,
--   "created_at" timestamp NOT NULL,
--   "updated_at" timestamp,
--   "created_by" integer NOT NULL,
--   "updated_by" integer
-- );


CREATE TABLE public.subject (
    id INT primary key GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(250) NOT NULL UNIQUE
);

CREATE TABLE public.quizz (
                              id INT primary key GENERATED ALWAYS AS IDENTITY,
                              id_subject INTEGER REFERENCES public.subject (id),
                              name varchar(250) UNIQUE NOT NULL,
                              description TEXT
);

--
 CREATE TABLE "quizz_test" (
   id INT primary key GENERATED ALWAYS AS IDENTITY,
   id_quiz int NOT NULL,
   id_test int NOT NULL
 );



CREATE TABLE public.question (
     id INT primary key GENERATED ALWAYS AS IDENTITY,
     id_quizz INTEGER REFERENCES public.quizz (id),
     content TEXT
);


CREATE TABLE public.answer (
   id INT GENERATED ALWAYS AS IDENTITY,
   id_question integer,
   content TEXT,
   weighting integer,
   is_correct bool NOT NULL
);

 CREATE TABLE public.user_answer (
   id INT GENERATED ALWAYS AS IDENTITY,
   id_user integer,
   id_quiz_test integer,
   id_answer integer
 );





 CREATE TABLE public.user_test (
   id INT GENERATED ALWAYS AS IDENTITY,
   id_test integer NOT NULL,
   id_user integer NOT NULL,
   date_submission timestamp,
   date_started timestamp,
   date_finished timestamp,
   date_abandonned timestamp
 );

  CREATE TABLE public.notification (
    id INT GENERATED ALWAYS AS IDENTITY,
    id_user integer NOT NULL,
    id_quiz integer NOT NULL,
    message varchar(250) NOT NULL,
    type varchar(250) NOT NULL,
    status varchar(250) NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    is_sent bool NOT NULL
  );






-- CREATE TABLE "notification" (
--   "id" INT GENERATED ALWAYS AS IDENTITY,
--   "id_user" integer NOT NULL,
--   "id_quiz" integer NOT NULL,
--   "message" varchar(250) NOT NULL,
--   "type" varchar(250) NOT NULL,
--   "status" varchar(250) NOT NULL,
--   "created_at" timestamp NOT NULL,
--   "updated_at" timestamp NOT NULL,
--   "is_sent" bool NOT NULL
-- );
--
-- ALTER TABLE "test" ADD FOREIGN KEY ("created_by") REFERENCES "user" ("id");
--
-- ALTER TABLE "test" ADD FOREIGN KEY ("updated_by") REFERENCES "user" ("id");
--
-- ALTER TABLE "quiz" ADD FOREIGN KEY ("created_by") REFERENCES "user" ("id");
--
-- ALTER TABLE "quiz" ADD FOREIGN KEY ("updated_by") REFERENCES "user" ("id");
--
-- ALTER TABLE "quiz_test" ADD CONSTRAINT "quiz_to_quiz_test" FOREIGN KEY ("id_quiz") REFERENCES "quiz" ("id");
--
-- ALTER TABLE "quiz_test" ADD CONSTRAINT "test_to_quiz_test" FOREIGN KEY ("id_test") REFERENCES "test" ("id");
--
-- ALTER TABLE aubay.quizz ADD CONSTRAINT "quiz_to_subject" FOREIGN KEY ("id_subject") REFERENCES aubay.subject ("id");
--
-- ALTER TABLE "question" ADD CONSTRAINT "question_to_quiz" FOREIGN KEY ("id_quiz") REFERENCES "quiz" ("id");
--
-- ALTER TABLE "answer" ADD CONSTRAINT "answer_to_question" FOREIGN KEY ("id_question") REFERENCES "question" ("id");
--
-- ALTER TABLE "user_answer" ADD CONSTRAINT "user_to_answer" FOREIGN KEY ("id_user") REFERENCES "user" ("id");
--
-- ALTER TABLE "user_answer" ADD CONSTRAINT "user_to_answer" FOREIGN KEY ("id_quiz_test") REFERENCES "quiz_test" ("id");
--
-- ALTER TABLE "user_answer" ADD CONSTRAINT "user_to_answer" FOREIGN KEY ("id_answer") REFERENCES "answer" ("id");
--
-- ALTER TABLE "user_test" ADD CONSTRAINT "user_to_user_test" FOREIGN KEY ("id_user") REFERENCES "user" ("id");
--
-- ALTER TABLE "user_test" ADD CONSTRAINT "test_to_user_test" FOREIGN KEY ("id_test") REFERENCES "test" ("id");
--
-- ALTER TABLE "user" ADD CONSTRAINT "role_to_user" FOREIGN KEY ("id_role") REFERENCES "role" ("id");
--
-- ALTER TABLE "notification" ADD FOREIGN KEY ("id_user") REFERENCES "user" ("id");
--
-- ALTER TABLE "notification" ADD FOREIGN KEY ("id_quiz") REFERENCES "quiz" ("id");