CREATE TABLE "user"(
      id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
    , email TEXT NOT NULL UNIQUE
    , first_name VARCHAR(50)
    , last_name VARCHAR(50)
    , created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);