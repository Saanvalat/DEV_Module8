CREATE TABLE IF NOT EXISTS worker
(
	id 			BIGINT		PRIMARY KEY,
	name 		VARCHAR(1000) 	NOT NULL CHECK (Length (name) BETWEEN 2 AND 1000),
	birthday	DATE 			CHECK (EXTRACT(YEAR FROM birthday) > 1900),
	level 		VARCHAR(50) 	NOT NULL CHECK(level IN('Trainee', 'Junior', 'Middle', 'Senior')),
	salary 		INT				NOT NULL CHECK(salary BETWEEN 100 AND 100000)
);

CREATE TABLE IF NOT EXISTS client
(
	id 			BIGINT 		PRIMARY KEY,
	name 		VARCHAR(1000) 	NOT NULL CHECK (Length (name) BETWEEN 2 AND 1000)
);
CREATE TABLE IF NOT EXISTS project
(
	id          BIGINT       PRIMARY KEY,
    client_id   BIGINT,
    start_date  DATE,
    finish_date DATE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id)
);
CREATE TABLE IF NOT EXISTS project_worker
(
	project_id	INT REFERENCES project(id),
	worker_id		INT REFERENCES worker(id),
	PRIMARY KEY (project_id, worker_id)
);
CREATE TABLE IF NOT EXISTS project_name (
    project_id          BIGINT NOT NULL,
    name        VARCHAR(1000) NOT NULL,
    CHECK (LENGTH(name) >= 2),
    FOREIGN KEY(project_id) REFERENCES project(id)
);


