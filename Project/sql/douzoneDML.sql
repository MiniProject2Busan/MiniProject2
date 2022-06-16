USE douzone;

-- manager -> instructor -> course -> student

-- manager table insert
INSERT INTO manager(manager_name, manager_phone) VALUES("양은정","010-0000-0000");
INSERT INTO manager(manager_name, manager_phone) VALUES("윤다경","010-1111-1111");
SELECT * FROM manager;

-- instructor table insert
INSERT INTO instructor(instructor_name, instructor_phone) VALUES("임소영", "010-0000-0000");
INSERT INTO instructor(instructor_name, instructor_phone) VALUES("신용기", "010-1111-1111");
SELECT * FROM instructor;

-- course table insert
INSERT INTO course(course_name, start_date, end_date) VALUES("Network", "2022-04-11", "2022-04-15");
INSERT INTO course(course_name, start_date, end_date) VALUES("Linux", "2022-04-18", "2022-04-22");
INSERT INTO course(course_name, start_date, end_date) VALUES("Html/CSS", "2022-04-25", "2022-05-13");
INSERT INTO course(course_name, start_date, end_date) VALUES("JavaScript", "2022-05-16", "2022-05-27");
INSERT INTO course(course_name, start_date, end_date) VALUES("React", "2022-05-30", "2022-06-03");
INSERT INTO course(course_name, start_date, end_date) VALUES("Java", "2022-06-07", "2022-06-17");
SELECT * FROM course;

-- student table insert
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("김용주", 30, "010-0000-0000", "부산진구", "JKYD01");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("김민규", 28, "010-0000-0000", "서구", "JKYD02");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("곽예영", 26, "010-0000-0000", "동래구", "JKYD03");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("박한주", 28, "010-0000-0000", "사하구", "JKYD04");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("신현채", 28, "010-0000-0000", "남구", "JKYD05");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("백성준", 26, "010-0000-0000", "부사", "JKYD06");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("박정인", 27, "010-0000-0000", "연제구", "JKYD07");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("서의진", 25, "010-0000-0000", "해운대구", "JKYD08");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("정영광", 26, "010-0000-0000", "북구", "JKYD09");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("정영훈", 26, "010-0000-0000", "영도구", "JKYD10");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("성종헌", 26, "010-0000-0000", "강서구", "JKYD11");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("김윤호", 26, "010-0000-0000", "해운대구", "JKYD12");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("김도헌", 25, "010-0000-0000", "수영구", "JKYD13");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("조명윤", 30, "010-0000-0000", "중구", "JKYD14");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("강동현", 28, "010-0000-0000", "동구", "JKYD15");

COMMIT;

SELECT * FROM manager;
SELECT * FROM instructor;
SELECT * FROM course;
SELECT * FROM student;