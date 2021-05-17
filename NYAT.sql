--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: USER; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."USER" (
    "PRODUCTNUMBER" integer NOT NULL,
    "USERNAME" character(15) NOT NULL,
    "PASSWORD" character(15) NOT NULL,
    "NAME" character(15),
    "SURNAME" character(15),
    "LOCATION" text,
    "ISLOCKED" boolean NOT NULL
);


ALTER TABLE public."USER" OWNER TO postgres;

--
-- Name: USER_PRODUCTNUMBER_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."USER_PRODUCTNUMBER_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."USER_PRODUCTNUMBER_seq" OWNER TO postgres;

--
-- Name: USER_PRODUCTNUMBER_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."USER_PRODUCTNUMBER_seq" OWNED BY public."USER"."PRODUCTNUMBER";


--
-- Name: USER PRODUCTNUMBER; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."USER" ALTER COLUMN "PRODUCTNUMBER" SET DEFAULT nextval('public."USER_PRODUCTNUMBER_seq"'::regclass);


--
-- Data for Name: USER; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."USER" VALUES
	(2, 'Seko           ', '123456         ', 'Serkan         ', 'Kuruoglu       ', 'Eskişehir', false),
	(3, 'otomurcuk      ', '123456         ', 'ömer faruk     ', 'tomurcuk       ', 'Sakarya', false),
	(4, 'fersoy         ', '123456         ', 'Fatih Melih    ', 'Ersoy          ', 'izmir', false),
	(8, 'skuruogl       ', '123456         ', 'serkan         ', 'kuruogl        ', 'eskişehir', false);


--
-- Name: USER_PRODUCTNUMBER_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."USER_PRODUCTNUMBER_seq"', 8, true);


--
-- Name: USER USERPK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."USER"
    ADD CONSTRAINT "USERPK" PRIMARY KEY ("PRODUCTNUMBER");


--
-- Name: USER USERUNIQUE; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."USER"
    ADD CONSTRAINT "USERUNIQUE" UNIQUE ("USERNAME");


--
-- PostgreSQL database dump complete
--

