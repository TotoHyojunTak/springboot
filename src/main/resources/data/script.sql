-- public.tb_users definition

-- Drop table

-- DROP TABLE public.tb_users;

CREATE TABLE public.tb_users (
                                 user_id varchar(255) NOT NULL,
                                 created_date timestamp NOT NULL,
                                 email varchar(50) NOT NULL,
                                 encrypted_pwd varchar(255) NOT NULL,
                                 "name" varchar(50) NOT NULL,
                                 CONSTRAINT tb_users_pkey PRIMARY KEY (user_id)
);