CREATE TABLE "employee" (
        "id" serial NOT NULL,
        "name" VARCHAR(30) NOT NULL,
        "account_id" int NOT NULL,
        PRIMARY KEY("id"),
        CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES account (id)
);