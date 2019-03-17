--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.20
-- Dumped by pg_dump version 9.4.20
-- Started on 2019-03-08 12:59:49

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2119 (class 0 OID 26731)
-- Dependencies: 206
-- Data for Name: pteam; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO pteam (id, description, name, organization) VALUES (20, 'Persoană care conduce secretariatul , lucrând pe lângă conducerea locală a partidului.', 'Secretar Executiv Regional', 'Conducerea Locală');
INSERT INTO pteam (id, description, name, organization) VALUES (4, 'Persoană care conduce secretariatul , lucrând pe lângă conducerea centrală a partidului.', 'Secretar General Adjunct', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (6, 'Persoană esponsabilă cu întocmirea, păstrarea, înregistrarea și comunicarea corespondenței, minutelor (rezumatelor) întâlnirilor și a oricăror alte documente sau probleme.', 'Secretar Executiv', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (5, 'Persoană care ține locul președintelui și care răspunde de o anumită zonă sau activitate.', 'Vicepreședinte', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (7, 'Persoană însărcinată cu administrarea fondurilor partidului.', 'Trezorier', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (21, 'Persoană care conduce organizația județeană a partidului.', 'Preşedinte Filială Judeţeană', 'Conducerea Locală');
INSERT INTO pteam (id, description, name, organization) VALUES (22, 'Persoană care conduce organizația Bucureşti a partidului.', 'Preşedintele Filialei Bucureşti', 'Conducerea Locală');
INSERT INTO pteam (id, description, name, organization) VALUES (23, 'Persoană care conduce organizația unui Sector al Municipiului Bucureşti a partidului.', 'Preşedinte Filială de Sector a Municipiului Bucureşti', 'Conducerea Locală');
INSERT INTO pteam (id, description, name, organization) VALUES (24, 'Preşedinta Organizaţiei de  Femei', 'Preşedinta Organizaţiei de  Femei – OFER', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (11, 'Preşedintele Organizaţiei de Tineret', 'Preşedintele Organizaţiei de Tineret -OTER', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (25, 'Preşedintele Organizaţiei de Pensionari', 'Preşedintele Organizaţiei de Pensionari-OPER', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (26, 'Preşedintele Organizaţiei  Oamenilor de Afaceri', 'Preşedintele Organizaţiei  Oamenilor de Afaceri- OOAER', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (27, 'Liga alesilor locali', 'Preşedintele LAL a P.E.R.', 'Conducerea Locală');
INSERT INTO pteam (id, description, name, organization) VALUES (3, 'Persoană care conduce secretariatul , lucrând pe lângă conducerea centrală a partidului.', 'Secretar General', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (2, 'Persoană care ține locul președintelui și care răspunde de o anumită zonă sau activitate.', 'Prim-Vicepreședinte', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (10, 'Persoană împuternicită să difuzeze în țară și în străinătate știri și textele documentelor oficiale ale partidului.', 'Purtător de cuvant', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (1, 'Persoană care conduce partidul.', 'Președinte', 'Conducerea Centrală');
INSERT INTO pteam (id, description, name, organization) VALUES (9, 'Membru colectivului organizat care are sarcina de a face propuneri, de a lua hotărâri sau de a executa mandate în cazuri speciale.', 'Membru comisie', 'Comisie');
INSERT INTO pteam (id, description, name, organization) VALUES (8, 'Preşedintele colectivului organizat care are sarcina de a face propuneri, de a lua hotărâri sau de a executa mandate în cazuri speciale.', 'Președinte comisie', 'Comisia Națională De Arbitraj și Integritate');


SET default_tablespace = '';

--
-- TOC entry 2009 (class 2606 OID 26738)
-- Name: pteam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pteam
    ADD CONSTRAINT pteam_pkey PRIMARY KEY (id);


-- Completed on 2019-03-08 12:59:50

--
-- PostgreSQL database dump complete
--

