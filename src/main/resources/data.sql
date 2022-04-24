create table student
(
    id          integer not null,
    first_name  varchar(50),
    last_name   varchar(50),
    create_date DATE,
    update_date date,
    primary key (id)
);

create table course
(
    id          integer not null,
    course_name varchar(250),
    course_fee  double,
    create_date DATE,
    update_date date,
    primary key (id)
);
create table enrolment
(
    id         integer not null,
    student_id integer,
    course_id  integer,
    foreign key (student_id) references student (id)
)