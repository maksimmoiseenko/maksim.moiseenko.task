--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-10-16 09:48:51

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
-- TOC entry 203 (class 1259 OID 32687)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    id bigint NOT NULL,
    login character varying(255),
    password character varying(255),
    role character varying(255)
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32685)
-- Name: account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_id_seq OWNER TO postgres;

--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 202
-- Name: account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.account_id_seq OWNED BY public.account.id;


--
-- TOC entry 205 (class 1259 OID 32698)
-- Name: sensor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sensor (
    id integer NOT NULL,
    description character varying(255),
    location character varying(255),
    model character varying(255),
    name character varying(255),
    range_from integer NOT NULL,
    range_to integer NOT NULL,
    type character varying(255),
    unit character varying(255)
);


ALTER TABLE public.sensor OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 32696)
-- Name: sensor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sensor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sensor_id_seq OWNER TO postgres;

--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 204
-- Name: sensor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sensor_id_seq OWNED BY public.sensor.id;


--
-- TOC entry 206 (class 1259 OID 32707)
-- Name: type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type (
    type character varying(255) NOT NULL
);


ALTER TABLE public.type OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 32712)
-- Name: unit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.unit (
    unit character varying(255) NOT NULL
);


ALTER TABLE public.unit OWNER TO postgres;

--
-- TOC entry 2703 (class 2604 OID 32690)
-- Name: account id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account ALTER COLUMN id SET DEFAULT nextval('public.account_id_seq'::regclass);


--
-- TOC entry 2704 (class 2604 OID 32701)
-- Name: sensor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sensor ALTER COLUMN id SET DEFAULT nextval('public.sensor_id_seq'::regclass);


--
-- TOC entry 2840 (class 0 OID 32687)
-- Dependencies: 203
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account (id, login, password, role) FROM stdin;
1	admin	$2a$10$7/MfykCzvSrG6P2C9u17AezuV1dZkSYDFgpclLtRxf.tVqxI4mGsW	admin
2	user	$2a$10$s5tMc.ZqJn0uuCKzz6BRYujl1ncOJfMYfwA9ZN1BB47aBwN9MWKjq	user
\.


--
-- TOC entry 2842 (class 0 OID 32698)
-- Dependencies: 205
-- Data for Name: sensor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sensor (id, description, location, model, name, range_from, range_to, type, unit) FROM stdin;
2	the most cheapest	USA	t60	microlife	0	60	Temperature	*C
1	made in belarus	mogilev	m100	zenit	0	100	humidity	%
3	cheap sensor	china	electro	humidity sensor	1	100	humidity	%
4	high quality	japan	multimetr	sony	0	100000	voltage	voltage
5	\N	germany	green	bosch	0	10	pressure	bar
\.


--
-- TOC entry 2843 (class 0 OID 32707)
-- Dependencies: 206
-- Data for Name: type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.type (type) FROM stdin;
pressure
voltage
Temperature
humidity
\.


--
-- TOC entry 2844 (class 0 OID 32712)
-- Dependencies: 207
-- Data for Name: unit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.unit (unit) FROM stdin;
bar
voltage
*C
%
\.


--
-- TOC entry 2852 (class 0 OID 0)
-- Dependencies: 202
-- Name: account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_id_seq', 1, false);


--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 204
-- Name: sensor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sensor_id_seq', 5, true);


--
-- TOC entry 2706 (class 2606 OID 32695)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- TOC entry 2708 (class 2606 OID 32706)
-- Name: sensor sensor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sensor
    ADD CONSTRAINT sensor_pkey PRIMARY KEY (id);


--
-- TOC entry 2710 (class 2606 OID 32711)
-- Name: type type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_pkey PRIMARY KEY (type);


--
-- TOC entry 2712 (class 2606 OID 32716)
-- Name: unit unit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.unit
    ADD CONSTRAINT unit_pkey PRIMARY KEY (unit);


-- Completed on 2020-10-16 09:48:58

--
-- PostgreSQL database dump complete
--

