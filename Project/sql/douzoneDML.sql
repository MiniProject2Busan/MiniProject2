USE douzone;

-- manager -> instructor -> course -> student
sdfzsdfz
-- manager table insert
INSERT INTO manager(manager_name, manager_phone) VALUES("������","010-0000-0000");
INSERT INTO manager(manager_name, manager_phone) VALUES("���ٰ�","010-1111-1111");
SELECT * FROM manager;

-- instructor table insert
INSERT INTO instructor(instructor_name, instructor_phone) VALUES("�Ӽҿ�", "010-0000-0000");
INSERT INTO instructor(instructor_name, instructor_phone) VALUES("�ſ��", "010-1111-1111");
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
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("�����", 30, "010-0000-0000", "�λ�����", "JKYD01");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("��α�", 28, "010-0000-0000", "����", "JKYD02");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("������", 26, "010-0000-0000", "������", "JKYD03");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("������", 28, "010-0000-0000", "���ϱ�", "JKYD04");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("����ä", 28, "010-0000-0000", "����", "JKYD05");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("�鼺��", 26, "010-0000-0000", "�λ�", "JKYD06");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("������", 27, "010-0000-0000", "������", "JKYD07");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("������", 25, "010-0000-0000", "�ؿ�뱸", "JKYD08");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("������", 26, "010-0000-0000", "�ϱ�", "JKYD09");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("������", 26, "010-0000-0000", "������", "JKYD10");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("������", 26, "010-0000-0000", "������", "JKYD11");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("����ȣ", 26, "010-0000-0000", "�ؿ�뱸", "JKYD12");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("�赵��", 25, "010-0000-0000", "������", "JKYD13");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("������", 30, "010-0000-0000", "�߱�", "JKYD14");
INSERT INTO student(student_name, student_age, student_phone, student_addr, student_seatId) VALUES("������", 28, "010-0000-0000", "����", "JKYD15");

COMMIT;

SELECT * FROM manager;
SELECT * FROM instructor;
SELECT * FROM course;
SELECT * FROM student;