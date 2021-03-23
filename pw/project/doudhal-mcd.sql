DROP TABLE IF EXISTS courses ;
CREATE TABLE courses (course_id_Courses INT AUTO_INCREMENT NOT NULL,
course_title_Courses VARCHAR(255),
price_Courses DOUBLE,
creation_date_courses DATE,
duration_courses TIME,
category_id_categories **NOT FOUND**,
user_id_users **NOT FOUND**,
PRIMARY KEY (course_id_Courses)) ENGINE=InnoDB;

DROP TABLE IF EXISTS users ;
CREATE TABLE users (user_id_users INT AUTO_INCREMENT NOT NULL,
first_name_users VARCHAR(100),
last_name_users VARCHAR(150),
login_users VARCHAR(50),
password_users VARCHAR(20),
mail_users VARCHAR(100),
tel_users VARCHAR(50),
address_users VARCHAR(255),
avatar_users VARCHAR(255),
PRIMARY KEY (user_id_users)) ENGINE=InnoDB;

DROP TABLE IF EXISTS sections ;
CREATE TABLE sections (section_id_sections INT AUTO_INCREMENT NOT NULL,
section_title_sections VARCHAR(255),
section_description_sections TEXT,
course_id_Courses **NOT FOUND**,
PRIMARY KEY (section_id_sections)) ENGINE=InnoDB;

DROP TABLE IF EXISTS lessons ;
CREATE TABLE lessons (lesson_id_lessons INT AUTO_INCREMENT NOT NULL,
lesson_title_lessons VARCHAR(255),
content_lessons TEXT,
section_id_sections **NOT FOUND**,
PRIMARY KEY (lesson_id_lessons)) ENGINE=InnoDB;

DROP TABLE IF EXISTS quizzes ;
CREATE TABLE quizzes (quiz_id_quizzes INT AUTO_INCREMENT NOT NULL,
quiz_title_quizzes VARCHAR(100),
quiz_description_quizzes TEXT,
section_id_sections **NOT FOUND**,
PRIMARY KEY (quiz_id_quizzes)) ENGINE=InnoDB;

DROP TABLE IF EXISTS questions ;
CREATE TABLE questions (question_id_questions INT AUTO_INCREMENT NOT NULL,
question_title_questions VARCHAR(255),
question_description_questions TEXT,
quiz_id_quizzes **NOT FOUND**,
PRIMARY KEY (question_id_questions)) ENGINE=InnoDB;

DROP TABLE IF EXISTS answers ;
CREATE TABLE answers (answer_id_answers INT AUTO_INCREMENT NOT NULL,
answer_content_answers TEXT,
answer_status_answers BOOLEAN,
question_id_questions **NOT FOUND**,
PRIMARY KEY (answer_id_answers)) ENGINE=InnoDB;

DROP TABLE IF EXISTS categories ;
CREATE TABLE categories (category_id_categories INT AUTO_INCREMENT NOT NULL,
category_title_categories VARCHAR(255),
category_description_categories TEXT,
PRIMARY KEY (category_id_categories)) ENGINE=InnoDB;

DROP TABLE IF EXISTS medias ;
CREATE TABLE medias (media_id_medias INT AUTO_INCREMENT NOT NULL,
media_name_medias VARCHAR(100),
media_type_medias VARCHAR(100),
media_location_medias VARCHAR(255),
PRIMARY KEY (media_id_medias)) ENGINE=InnoDB;

DROP TABLE IF EXISTS orders ;
CREATE TABLE orders (course_id_Courses **NOT FOUND** AUTO_INCREMENT NOT NULL,
user_id_users **NOT FOUND** NOT NULL,
order_id_orders INT,
order_date_orders DATETIME,
order_amount_orders DOUBLE,
order_status_orders VARCHAR(100),
PRIMARY KEY (course_id_Courses,
 user_id_users)) ENGINE=InnoDB;

DROP TABLE IF EXISTS media_lessons ;
CREATE TABLE media_lessons (lesson_id_lessons **NOT FOUND** AUTO_INCREMENT NOT NULL,
media_id_medias **NOT FOUND** NOT NULL,
PRIMARY KEY (lesson_id_lessons,
 media_id_medias)) ENGINE=InnoDB;

DROP TABLE IF EXISTS to_perform ;
CREATE TABLE to_perform (quiz_id_quizzes **NOT FOUND** AUTO_INCREMENT NOT NULL,
user_id_users **NOT FOUND** NOT NULL,
PRIMARY KEY (quiz_id_quizzes,
 user_id_users)) ENGINE=InnoDB;

ALTER TABLE courses ADD CONSTRAINT FK_courses_category_id_categories FOREIGN KEY (category_id_categories) REFERENCES categories (category_id_categories);

ALTER TABLE courses ADD CONSTRAINT FK_courses_user_id_users FOREIGN KEY (user_id_users) REFERENCES users (user_id_users);
ALTER TABLE sections ADD CONSTRAINT FK_sections_course_id_Courses FOREIGN KEY (course_id_Courses) REFERENCES courses (course_id_Courses);
ALTER TABLE lessons ADD CONSTRAINT FK_lessons_section_id_sections FOREIGN KEY (section_id_sections) REFERENCES sections (section_id_sections);
ALTER TABLE quizzes ADD CONSTRAINT FK_quizzes_section_id_sections FOREIGN KEY (section_id_sections) REFERENCES sections (section_id_sections);
ALTER TABLE questions ADD CONSTRAINT FK_questions_quiz_id_quizzes FOREIGN KEY (quiz_id_quizzes) REFERENCES quizzes (quiz_id_quizzes);
ALTER TABLE answers ADD CONSTRAINT FK_answers_question_id_questions FOREIGN KEY (question_id_questions) REFERENCES questions (question_id_questions);
ALTER TABLE orders ADD CONSTRAINT FK_orders_course_id_Courses FOREIGN KEY (course_id_Courses) REFERENCES courses (course_id_Courses);
ALTER TABLE orders ADD CONSTRAINT FK_orders_user_id_users FOREIGN KEY (user_id_users) REFERENCES users (user_id_users);
ALTER TABLE media_lessons ADD CONSTRAINT FK_media_lessons_lesson_id_lessons FOREIGN KEY (lesson_id_lessons) REFERENCES lessons (lesson_id_lessons);
ALTER TABLE media_lessons ADD CONSTRAINT FK_media_lessons_media_id_medias FOREIGN KEY (media_id_medias) REFERENCES medias (media_id_medias);
ALTER TABLE to_perform ADD CONSTRAINT FK_to_perform_quiz_id_quizzes FOREIGN KEY (quiz_id_quizzes) REFERENCES quizzes (quiz_id_quizzes);
ALTER TABLE to_perform ADD CONSTRAINT FK_to_perform_user_id_users FOREIGN KEY (user_id_users) REFERENCES users (user_id_users);
