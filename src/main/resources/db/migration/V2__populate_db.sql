-- db/migration/V2__populate_db.sql


CREATE TABLE IF NOT EXISTS worker (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    birthday DATE,
    level VARCHAR(255),
    salary DECIMAL(10, 2)
);


INSERT INTO worker (id, name, birthday, level, salary) VALUES
    (11, 'John', '1995-02-15', 'Trainee', 800),
    (12, 'Ivan', '1990-07-10', 'Junior', 1200),
    (13, 'Bob', '1985-11-25', 'Middle', 3000),
    (14, 'Lilia', '1980-03-20', 'Senior', 6000),
    (15, 'Mike', '1998-08-05', 'Trainee', 900),
    (16, 'Emily', '1992-04-12', 'Junior', 1400),
    (17, 'David', '1987-09-18', 'Middle', 3500),
    (18, 'Sophia', '1983-12-30', 'Senior', 7000),
    (19, 'Alex ', '1996-06-22', 'Trainee', 950),
    (20, 'Herman', '1993-01-08', 'Junior', 1600);
