insert into pcountry (code, name) values ('AR','Argentina');
insert into pcountry (code, name) values ('AU','Australia');
insert into pcountry (code, name) values ('AT','Austria');
insert into pcountry (code, name) values ('BY','Belarus');
insert into pcountry (code, name) values ('BE','Belgium');
insert into pcountry (code, name) values ('BA','Bosnia and Herzegovina');
insert into pcountry (code, name) values ('BR','Brazil');
insert into pcountry (code, name) values ('BG','Bulgaria');
insert into pcountry (code, name) values ('CA','Canada');
insert into pcountry (code, name) values ('CL','Chile');
insert into pcountry (code, name) values ('CN','China');
insert into pcountry (code, name) values ('CO','Colombia');
insert into pcountry (code, name) values ('CR','Costa Rica');
insert into pcountry (code, name) values ('HR','Croatia');
insert into pcountry (code, name) values ('CU','Cuba');
insert into pcountry (code, name) values ('CY','Cyprus');
insert into pcountry (code, name) values ('CZ','Czech Republic');
insert into pcountry (code, name) values ('DK','Denmark');
insert into pcountry (code, name) values ('DO','Dominican Republic');
insert into pcountry (code, name) values ('EG','Egypt');
insert into pcountry (code, name) values ('EE','Estonia');
insert into pcountry (code, name) values ('FI','Finland');
insert into pcountry (code, name) values ('FR','France');
insert into pcountry (code, name) values ('GE','Georgia');
insert into pcountry (code, name) values ('DE','Germany');
insert into pcountry (code, name) values ('GI','Gibraltar');
insert into pcountry (code, name) values ('GR','Greece');
insert into pcountry (code, name) values ('HK','Hong Kong S.A.R., China');
insert into pcountry (code, name) values ('HU','Hungary');
insert into pcountry (code, name) values ('IS','Iceland');
insert into pcountry (code, name) values ('IN','India');
insert into pcountry (code, name) values ('ID','Indonesia');
insert into pcountry (code, name) values ('IR','Iran');
insert into pcountry (code, name) values ('IQ','Iraq');
insert into pcountry (code, name) values ('IE','Ireland');
insert into pcountry (code, name) values ('IL','Israel');
insert into pcountry (code, name) values ('IT','Italy');
insert into pcountry (code, name) values ('JM','Jamaica');
insert into pcountry (code, name) values ('JP','Japan');
insert into pcountry (code, name) values ('KZ','Kazakhstan');
insert into pcountry (code, name) values ('KW','Kuwait');
insert into pcountry (code, name) values ('KG','Kyrgyzstan');
insert into pcountry (code, name) values ('LA','Laos');
insert into pcountry (code, name) values ('LV','Latvia');
insert into pcountry (code, name) values ('LB','Lebanon');
insert into pcountry (code, name) values ('LT','Lithuania');
insert into pcountry (code, name) values ('LU','Luxembourg');
insert into pcountry (code, name) values ('MK','Macedonia');
insert into pcountry (code, name) values ('MY','Malaysia');
insert into pcountry (code, name) values ('MT','Malta');
insert into pcountry (code, name) values ('MX','Mexico');
insert into pcountry (code, name) values ('MD','Moldova');
insert into pcountry (code, name) values ('MC','Monaco');
insert into pcountry (code, name) values ('ME','Montenegro');
insert into pcountry (code, name) values ('MA','Morocco');
insert into pcountry (code, name) values ('NL','Netherlands');
insert into pcountry (code, name) values ('NZ','New Zealand');
insert into pcountry (code, name) values ('NI','Nicaragua');
insert into pcountry (code, name) values ('KP','North Korea');
insert into pcountry (code, name) values ('NO','Norway');
insert into pcountry (code, name) values ('PK','Pakistan');
insert into pcountry (code, name) values ('PS','Palestinian Territory');
insert into pcountry (code, name) values ('PE','Peru');
insert into pcountry (code, name) values ('PH','Philippines');
insert into pcountry (code, name) values ('PL','Poland');
insert into pcountry (code, name) values ('PT','Portugal');
insert into pcountry (code, name) values ('PR','Puerto Rico');
insert into pcountry (code, name) values ('QA','Qatar');
insert into pcountry (code, name) values ('RO','Romania');
insert into pcountry (code, name) values ('RU','Russia');
insert into pcountry (code, name) values ('SA','Saudi Arabia');
insert into pcountry (code, name) values ('RS','Serbia');
insert into pcountry (code, name) values ('SG','Singapore');
insert into pcountry (code, name) values ('SK','Slovakia');
insert into pcountry (code, name) values ('SI','Slovenia');
insert into pcountry (code, name) values ('ZA','South Africa');
insert into pcountry (code, name) values ('KR','South Korea');
insert into pcountry (code, name) values ('ES','Spain');
insert into pcountry (code, name) values ('LK','Sri Lanka');
insert into pcountry (code, name) values ('SE','Sweden');
insert into pcountry (code, name) values ('CH','Switzerland');
insert into pcountry (code, name) values ('TW','Taiwan');
insert into pcountry (code, name) values ('TH','Thailand');
insert into pcountry (code, name) values ('TN','Tunisia');
insert into pcountry (code, name) values ('TR','Turkey');
insert into pcountry (code, name) values ('UA','Ukraine');
insert into pcountry (code, name) values ('AE','United Arab Emirates');
insert into pcountry (code, name) values ('GB','United Kingdom');
insert into pcountry (code, name) values ('US','USA');
insert into pcountry (code, name) values ('UZ','Uzbekistan');
insert into pcountry (code, name) values ('VN','Vietnam');
insert into pcountry (code, name) values ('DS','Diaspora');
insert into pcountry (code, name) values ('ALL','Alta');
COMMIT;

--JudeteNPAI3307

CREATE TABLE public.pprovince_old
(
  id numeric,
  name character varying,
  residence character varying,
  population numeric,
  indicator character varying,
  code character varying
);

INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (1,'Alba', 'Alba Iulia',342376,'AB','RO');	
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (2,'Arad', 'Arad', 430629, 'AR','RO');	
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (3,'Argeș','Pitești',612431,'AG','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (4,'Bacău','Bacău',616168 ,'BC','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (5,'Bihor','Oradea',575398 ,'BH','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (6,'Bistrița-Năsăud','Bistrița',286225 ,'BN','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (7,'Botoșani','Botoșani',412626 ,'BT','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (8,'Brașov','Brașov',549217 ,'BV','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (9,'Brăila','Brăila',321212 ,'BR','RO');	
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (10,'București','București',1883425 ,'B','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (11,'Buzău','Buzău',451069 ,'BZ','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (12,'Caraș-Severin','Reșița',295579 ,'CS','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (13,'Călărași','Călărași',306691 ,'CL','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (14,'Cluj','Cluj-Napoca',691106 ,'CJ','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (15,'Constanța','Constanța',684082 ,'CT','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (16,'Covasna','Sfântu Gheorghe',210177 ,'CV','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (17,'Dâmbovița','Târgoviște',518745 ,'DB','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (18,'Dolj','Craiova',660544 ,'DJ','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (19,'Galați','Galați',536167 ,'GL','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (20,'Giurgiu','Giurgiu',281422 ,'GR','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (21,'Gorj','Târgu Jiu',341594 ,'GJ','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (22,'Hunedoara','Deva',418565 ,'HD','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (23,'Ialomița','Slobozia',274148 ,'IL','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (24,'Iași','Iași',772348 ,'IS','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (25,'Ilfov','Buftea',388738 ,'IF','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (26,'Maramureș','Baia Mare',478659 ,'MM','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (27,'Mehedinți','Drobeta-Turnu Severin',265390 ,'MH','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (28,'Mureș','Târgu Mureș',550846 ,'MS','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (29,'Neamț','Piatra Neamț',470766 ,'NT','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (30,'Olt','Slatina',436400 ,'OT','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (31,'Prahova','Ploiești',762886 ,'PH','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (32,'Satu Mare','Satu Mare',344360 ,'SM','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (33,'Sălaj','Zalău',224384 ,'SJ','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (34,'Sibiu','Sibiu',397322 ,'SB','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (35,'Suceava','Suceava',634810, 'SV','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (36,'Teleorman','Alexandria',380123 ,'TR','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (37,'Timiș','Timișoara',683540 ,'TM','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (38,'Tulcea','Tulcea',213083 ,'TL','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (39,'Vaslui','Vaslui',395499 ,'VS','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (40,'Vâlcea','Râmnicu Vâlcea',371714 ,'VL','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (41,'Vrancea','Focșani',	340310 ,'VN','RO');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (42,'Diaspora','Diaspora',5000000 ,'DS','DS');
INSERT INTO public.pprovince_old(id, name,residence, population, indicator,code) VALUES (43,'Harghita','Miercurea Ciuc',310867 ,'HR','RO');
COMMIT;


INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Alba', 'Alba Iulia', 342376 ,'AB','RO');	
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Arad', 'Arad', 430629, 'AR','RO');	
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Argeș','Pitești',612431,'AG','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Bacău','Bacău',616168 ,'BC','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Bihor','Oradea',575398 ,'BH','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Bistrița-Năsăud','Bistrița',286225 ,'BN','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Botoșani','Botoșani',412626 ,'BT','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Brașov','Brașov',549217 ,'BV','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Brăila','Brăila',321212 ,'BR','RO');	
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('București','București',1883425 ,'B','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Buzău','Buzău',451069 ,'BZ','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Caraș-Severin','Reșița',295579 ,'CS','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Călărași','Călărași',306691 ,'CL','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Cluj','Cluj-Napoca',691106 ,'CJ','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Constanța','Constanța',684082 ,'CT','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Covasna','Sfântu Gheorghe',210177 ,'CV','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Dâmbovița','Târgoviște',518745 ,'DB','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Dolj','Craiova',660544 ,'DJ','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Galați','Galați',536167 ,'GL','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Giurgiu','Giurgiu',281422 ,'GR','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Gorj','Târgu Jiu',341594 ,'GJ','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Hunedoara','Deva',418565 ,'HD','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Ialomița','Slobozia',274148 ,'IL','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Iași','Iași',772348 ,'IS','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Ilfov','Buftea',388738 ,'IF','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Maramureș','Baia Mare',478659 ,'MM','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Mehedinți','Drobeta-Turnu Severin',265390 ,'MH','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Mureș','Târgu Mureș',550846 ,'MS','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Neamț','Piatra Neamț',470766 ,'NT','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Olt','Slatina',436400 ,'OT','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Prahova','Ploiești',762886 ,'PH','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Satu Mare','Satu Mare',344360 ,'SM','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Sălaj','Zalău',224384 ,'SJ','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Sibiu','Sibiu',397322 ,'SB','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Suceava','Suceava',634810, 'SV','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Teleorman','Alexandria',380123 ,'TR','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Timiș','Timișoara',683540 ,'TM','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Tulcea','Tulcea',213083 ,'TL','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Vaslui','Vaslui',395499 ,'VS','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Vâlcea','Râmnicu Vâlcea',371714 ,'VL','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Vrancea','Focșani',	340310 ,'VN','RO');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Diaspora','Diaspora',5000000 ,'DS','DS');
INSERT INTO public.pprovince(name,residence, population, code_province,code) VALUES ('Harghita','Miercurea Ciuc',310867 ,'HR','RO');
COMMIT;

--Localitati

CREATE TABLE public.plocality_old
(
  id numeric,
  name character varying,
  typelocality character varying,
  residence boolean,
  code_province numeric,
  sector character varying,
  nivel numeric,
  locuitori numeric
);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (1,1,28934,'Aiud','MUNICIPALITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (2,1,20765,'Blaj','MUNICIPALITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (3,1,29586,'Sebeș','MUNICIPALITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (4,1,66842,'Alba Iulia','MUNICIPALITY',TRUE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (5,2,6195,'Abrud','CITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (6,2,4300,'Baia de Arieș','CITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (7,2,8080,'Câmpeni','CITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (8,2,26561,'Cugir','CITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (9,2,15063,'Ocna Mureș','CITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (10,2,7458,'Teiuș','CITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (11,2,8164,'Zlatna','CITY',FALSE,1,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (12,1,167238,'Arad','MUNICIPALITY',TRUE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (13,2,8273,'Chișineu-Criș','CITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (14,2,8118,'Curtici','CITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (15,2,10207,'Ineu','CITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (16,2,11236,'Lipova','CITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (17,2,7624,'Pâncota','CITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (18,2,13793,'Pecica','CITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (19,2,13362,'Sântana','CITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (20,2,6327,'Sebiș','CITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (21,2,8035,'Nădlac','CITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (22,1,36539,'Câmpulung','MUNICIPALITY',FALSE,2,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (23,2,10615,'Costești','CITY',FALSE,3,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (24,1,32795,'Curtea de Argeș','MUNICIPALITY',FALSE,3,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (25,2,33999,'Mioveni','CITY',FALSE,3,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (26,1,167017,'Pitești','MUNICIPALITY',TRUE,3,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (27,2,14103,'Stefaneşti','CITY',FALSE,3,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (28,2,10498,'Topoloveni','CITY',FALSE,3,null);
	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (29,1,175867,'Bacău','MUNICIPALITY',TRUE,4,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (30,2,19590,'Buhuşi','CITY',FALSE,4,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (31,2,23458,'Comaneşti','CITY',FALSE,4,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (32,2,14444,'Dărmăneşti','CITY',FALSE,4,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (33,1,23594,'Moinesti','MUNICIPALITY',FALSE,4,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (34,1,49226,'Onești','MUNICIPALITY',FALSE,4,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (35,2,4933,'Slănic-Moldova','CITY',FALSE,4,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (36,2,12905,'Târgu Ocna','CITY',FALSE,4,null);
	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (37,1,10996,'Beiuș','MUNICIPALITY',FALSE,5,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (38,1,17291,'Marghita','MUNICIPALITY',FALSE,5,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (39,1,18389,'Salonta','MUNICIPALITY',FALSE,5,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (40,1,205077,'Oradea','MUNICIPALITY',TRUE,5,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (41,2,10415,'Aleșd','CITY',FALSE,5,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (42,2,2399,'Nucet','CITY',FALSE,5,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (43,2,11665,'Săcueni','CITY',FALSE,5,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (44,2,10324,'Valea lui Mihai','CITY',FALSE,5,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (45,2,2854,'Vașcău','CITY',FALSE,5,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (46,2,8637,'Ștei','CITY',FALSE,5,null);
	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (47,2,11607,'Beclean','CITY',FALSE,6,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (48,1,84630,'Bistrița','MUNICIPALITY',TRUE,6,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (49,2,10993,'Năsăud','CITY',FALSE,6,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (50,2,10915,'Sângeorz Băi','CITY',FALSE,6,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (51,1,29920,'Dorohoi','MUNICIPALITY',FALSE,7,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (52,1,115751,'Botoșani','MUNICIPALITY',TRUE,7,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (53,2,5165,'Bucecea','CITY',FALSE,7,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (54,2,11646,'Darabani','CITY',FALSE,7,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (55,2,11947,'Flămânzi','CITY',FALSE,7,null);	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (56,2,8043,'Săveni','CITY',FALSE,7,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (57,2,14103,'Ștefănești','CITY',FALSE,7,null);
	
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (58,1,24550,'Codlea','MUNICIPALITY',FALSE,8,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (59,1,38921,'Făgăraș','MUNICIPALITY',FALSE,8,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (60,1,31796,'Săcele','MUNICIPALITY',FALSE,8,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (61,1,277945,'Brașov','MUNICIPALITY',TRUE,8,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (62,2,5357,'Ghimbav','CITY',FALSE,8,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (63,2,5174,'Predeal','CITY',FALSE,8,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (64,2,16055,'Râșnov','CITY',FALSE,8,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (65,2,5783,'Rupea','CITY',FALSE,8,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (66,2,9132,'Victoria','CITY',FALSE,8,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (67,2,25832,'Zărnești','CITY',FALSE,8,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (68,1,211161,'Brăila','MUNICIPALITY',TRUE,9,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (69,2,4007,'Făurei','CITY',FALSE,9,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (70,2,11168,'Ianca','CITY',FALSE,9,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (71,2,7336,'Însurăței','CITY',FALSE,9,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (72,1,225400,'București','SECTOR',TRUE,10,'Sector 1');
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (73,1,345400,'București','SECTOR',TRUE,10,'Sector 2');
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (74,1,385400,'București','SECTOR',TRUE,10,'Sector 3');
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (75,1,287800,'București','SECTOR',TRUE,10,'Sector 4');
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (76,1,271600,'București','SECTOR',TRUE,10,'Sector 5');
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (77,1,367800,'București','SECTOR',TRUE,10,'Sector 6');
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (78,1,1836000,'București','MUNICIPALITY',TRUE,10,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (79,1,39426,'Râmnicu Sărat','MUNICIPALITY',FALSE,11,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (80,1,131644,'Buzău','MUNICIPALITY',TRUE,11,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (81,2,11381,'Nehoiu','CITY',FALSE,11,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (82,2,7600,'Pogoanele','CITY',FALSE,11,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (83,2,8290,'Pătârlagele','CITY',FALSE,11,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (84,1,21932,'Caransebeș','MUNICIPALITY',FALSE,12,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (85,1,65509,'Reșița','MUNICIPALITY',TRUE,12,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (86,2,9167,'Anina','CITY',FALSE,12,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (87,2,5966,'Băile Herculane','CITY',FALSE,12,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (88,2,17032,'Bocșa','CITY',FALSE,12,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (89,2,12350,'Moldova Nouă','CITY',FALSE,12,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (90,2,12700,'Oravița','CITY',FALSE,12,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (91,2,11777,'Oțelu Roșu','CITY',FALSE,12,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (92,1,27256,'Oltenița','MUNICIPALITY',FALSE,13,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (93,1,73077,'Călărași','MUNICIPALITY',TRUE,13,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (94,2,7190,'Budești','CITY',FALSE,13,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (95,2,6679,'Fundulea','CITY',FALSE,13,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (96,2,5947,'Lehliu Gară','CITY',FALSE,13,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (97,1,26377,'Câmpia Turzii','MUNICIPALITY',FALSE,14,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (98,1,38610,'Dej','MUNICIPALITY',FALSE,14,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (99,1,22108,'Gherla','MUNICIPALITY',TRUE,14,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (100,1,57381,'Turda','MUNICIPALITY',TRUE,14,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (101,1,310243,'Cluj-Napoca','MUNICIPALITY',TRUE,14,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (102,2,9700,'Huedin','CITY',FALSE,14,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (103,1,40000,'Mangalia','MUNICIPALITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (104,1,44034,'Medgidia','MUNICIPALITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (105,1,301951,'Constanța','MUNICIPALITY',TRUE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (106,2,5521,'Băneasa','CITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (107,2,18443,'Cernavodă','CITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (108,2,10352,'Eforie','CITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (109,2,10487,'Hârșova','CITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (110,2,10836,'Murfatlar','CITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (111,2,35970,'Năvodari','CITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (112,2,5534,'Negru Vodă','CITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (113,2,14324,'Ovidiu','CITY',FALSE,15,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (114,2,7510,'Techirghiol','CITY',FALSE,15,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (115,1,19864,'Târgu Secuiesc','MUNICIPALITY',FALSE,16,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (116,1,61589,'Sfântu Gheorghe','MUNICIPALITY',TRUE,16,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (117,2,9431,'Baraolt','CITY',FALSE,16,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (118,2,11230,'Covasna','CITY',FALSE,16,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (119,2,9019,'Întorsura Buzăului','CITY',FALSE,16,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (120,1,20446,'Moreni','MUNICIPALITY',FALSE,17,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (121,1,88201,'Târgoviște','MUNICIPALITY',TRUE,17,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (122,2,7688,'Fieni','CITY',FALSE,17,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (123,2,14998,'Găești','CITY',FALSE,17,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (124,2,15451,'Pucioasa','CITY',FALSE,17,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (125,2,6578,'Răcari','CITY',FALSE,17,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (126,2,10064,'Titu','CITY',FALSE,17,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (127,1,19591,'Băilești','MUNICIPALITY',FALSE,18,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (128,1,17794,'Calafat','MUNICIPALITY',FALSE,18,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (129,1,299579,'Craiova','MUNICIPALITY',TRUE,18,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (130,2,3892,'Bechet','CITY',FALSE,18,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (131,2,12776,'Dăbuleni','CITY',FALSE,18,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (132,2,18706,'Filiași','CITY',FALSE,18,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (133,2,8172,'Segarcea','CITY',FALSE,18,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (134,1,42438,'Tecuci','MUNICIPALITY',FALSE,19,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (135,1,290467,'Galați','MUNICIPALITY',TRUE,19,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (136,2,2853,'Berești','CITY',FALSE,19,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (137,2,7571,'Târgu Bujor','CITY',FALSE,19,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (138,1,67700,'Giurgiu','MUNICIPALITY',TRUE,20,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (139,2,12467,'Bolintin-Vale','CITY',FALSE,20,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (140,2,7432,'Mihăilești','CITY',FALSE,20,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (141,1,22223,'Motru','MUNICIPALITY',FALSE,21,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (142,1,96235,'Târgu Jiu','MUNICIPALITY',TRUE,21,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (143,2,10436,'Bumbești-Jiu','CITY',FALSE,21,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (144,2,6151,'Novaci','CITY',FALSE,21,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (145,2,13359,'Rovinari','CITY',FALSE,21,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (146,2,8992,'Târgu Cărbunești','CITY',FALSE,21,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (147,2,7744,'Tismana','CITY',FALSE,21,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (148,2,8177,'Turceni','CITY',FALSE,21,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (149,2,4357,'Țicleni','CITY',FALSE,21,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (150,1,15826,'Brad','MUNICIPALITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (151,1,69916,'Hunedoara','MUNICIPALITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (152,1,28972,'Lupeni','MUNICIPALITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (153,1,21326,'Orăștie','MUNICIPALITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (154,1,42699,'Petroșani','MUNICIPALITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (155,1,28352,'Vulcan','MUNICIPALITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (156,1,68830,'Deva','MUNICIPALITY',TRUE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (157,2,4689,'Aninoasa','CITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (158,2,12822,'Călan','CITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (159,2,5684,'Geoagiu','CITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (160,2,10840,'Hațeg','CITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (161,2,24857,'Petrila','CITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (162,2,13495,'Simeria','CITY',FALSE,22,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (163,2,9437,'Uricani','CITY',FALSE,22,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (164,1,34260,'Fetești','MUNICIPALITY',FALSE,23,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (165,1,17164,'Urziceni','MUNICIPALITY',FALSE,23,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (166,1,51989,'Slobozia','MUNICIPALITY',TRUE,23,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (167,2,8032,'Amara','CITY',FALSE,23,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (168,2,3641,'Căzănești','CITY',FALSE,23,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (169,2,5253,'Fierbinți-Târg','CITY',FALSE,23,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (170,2,12791,'Țăndărei','CITY',FALSE,23,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (171,1,42418,'Pașcani','MUNICIPALITY',FALSE,24,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (172,1,308663,'Iași','MUNICIPALITY',TRUE,24,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (173,2,11807,'Hârlău','CITY',FALSE,24,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (174,2,10449,'Podu Iloaiei','CITY',FALSE,24,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (175,2,13418,'Târgu Frumos','CITY',FALSE,24,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (176,2,15329,'Bragadiru','CITY',FALSE,25,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (177,2,21314,'Buftea','CITY',FALSE,25,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (178,2,12643,'Chitila','CITY',FALSE,25,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (179,2,9272,'Măgurele','CITY',FALSE,25,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (180,2,11436,'Otopeni','CITY',FALSE,25,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (181,2,23309,'Pantelimon','CITY',FALSE,25,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (182,2,21895,'Popești-Leordeni','CITY',FALSE,25,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (183,2,42944,'Voluntari','CITY',FALSE,25,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (184,1,41087,'Sighetu Marmației','MUNICIPALITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (185,1,139870,'Baia Mare','MUNICIPALITY',TRUE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (186,2,16580,'Baia Sprie','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (187,2,28330,'Borșa','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (188,2,5172,'Cavnic','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (189,2,3187,'Dragomirești','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (190,2,5061,'Săliștea de Sus','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (191,2,10296,'Seini','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (192,2,8037,'Șomcuta Mare','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (193,2,6713,'Tăuții-Măgherăuș','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (194,2,12953,'Târgu Lăpuș','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (195,2,7470,'Ulmeni','CITY',FALSE,26,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (196,2,16441,'Vișeu de Sus','CITY',FALSE,26,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (197,2,12726,'Orșova','MUNICIPALITY',FALSE,27,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (198,1,106230,'Drobeta-Turnu Severin','MUNICIPALITY',TRUE,27,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (199,2,5765,'Baia de Aramă','CITY',FALSE,27,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (200,2,11540,'Strehaia','CITY',FALSE,27,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (3185,2,6283,'Vânju Mare','CITY',FALSE,27,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (201,1,36510,'Reghin','MUNICIPALITY',FALSE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (202,1,32188,'Sighișoara','MUNICIPALITY',FALSE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (203,1,25667,'Târnăveni','MUNICIPALITY',FALSE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (204,1,145943,'Târgu Mureș','MUNICIPALITY',TRUE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (205,2,9647,'Iernut','CITY',FALSE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (206,2,17563,'Luduș','CITY',FALSE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (207,2,6221,'Miercurea Nirajului','CITY',FALSE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (208,2,9613,'Sovata','CITY',FALSE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (209,2,5591,'Sângeorgiu de Pădure','CITY',FALSE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (210,2,7491,'Sărmașu','CITY',FALSE,28,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (211,2,6930,'Ungheni','CITY',FALSE,28,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (212,1,67097,'Roman','MUNICIPALITY',FALSE,29,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (213,1,107214,'Piatra Neamț','MUNICIPALITY',TRUE,29,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (214,2,8517,'Bicaz','CITY',FALSE,29,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (215,2,9171,'Roznov','CITY',FALSE,29,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (216,2,20766,'Târgu Neamț','CITY',FALSE,29,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (217,1,34846,'Caracal','MUNICIPALITY',FALSE,30,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (218,1,77335,'Slatina','MUNICIPALITY',TRUE,30,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (219,2,20957,'Balș','CITY',FALSE,30,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (220,2,19324,'Corabia','CITY',FALSE,30,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (221,2,12175,'Drăgănești-Olt','CITY',FALSE,30,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (222,2,6299,'Piatra-Olt','CITY',FALSE,30,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (223,2,5886,'Potcoava','CITY',FALSE,30,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (224,2,12426,'Scornicești','CITY',FALSE,30,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (225,1,37054,'Câmpina','MUNICIPALITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (226,1,227981,'Ploiești','MUNICIPALITY',TRUE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (227,2,5028,'Azuga','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (228,2,19637,'Băicoi','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (229,2,11137,'Boldești-Scăeni','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (230,2,17452,'Breaza','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (231,2,10002,'Bușteni','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (232,2,12954,'Comarnic','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (233,2,16121,'Mizil','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (234,2,9354,'Plopeni','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (235,2,11632,'Sinaia','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (236,2,6578,'Slănic','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (237,2,11419,'Urlați','CITY',FALSE,31,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (238,2,13425,'Vălenii de Munte','CITY',FALSE,31,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (239,1,23182,'Carei','MUNICIPALITY',FALSE,32,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (240,1,112705,'Satu Mare','MUNICIPALITY',TRUE,32,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (241,2,7072,'Ardud','CITY',FALSE,32,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (242,2,7010,'Livada','CITY',FALSE,32,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (243,2,14964,'Negrești-Oaș','CITY',FALSE,32,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (244,2,9331,'Tășnad','CITY',FALSE,32,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (245,1,63642,'Zalău','MUNICIPALITY',TRUE,33,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (246,2,8089,'Cehu Silvaniei','CITY',FALSE,33,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (247,2,11281,'Jibou','CITY',FALSE,33,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (248,2,16306,'Șimleu Silvaniei','CITY',FALSE,33,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (249,1,52599,'Mediaș','MUNICIPALITY',FALSE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (250,1,154458,'Sibiu','MUNICIPALITY',TRUE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (251,2,11119,'Agnita','CITY',FALSE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (252,2,14430,'Avrig','CITY',FALSE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (253,2,16180,'Cisnădie','CITY',FALSE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (254,2,5573,'Copșa Mică','CITY',FALSE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (255,2,8270,'Dumbrăveni','CITY',FALSE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (256,2,4286,'Miercurea Sibiului','CITY',FALSE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (257,2,4204,'Ocna Sibiului','CITY',FALSE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (258,2,5839,'Săliște','CITY',FALSE,34,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (259,2,7571,'Tălmaciu','CITY',FALSE,34,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (260,1,19633,'Câmpulung Moldovenesc','MUNICIPALITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (261,1,29793,'Fălticeni','MUNICIPALITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (262,1,29452,'Rădăuți','MUNICIPALITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (263,1,16480,'Vatra Dornei','MUNICIPALITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (264,1,107208,'Suceava','MUNICIPALITY',TRUE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (265,2,6354,'Broșteni','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (266,2,8630,'Cajvana','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (267,2,11359,'Dolhasca','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (268,2,6536,'Frasin','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (269,2,15726,'Gura Humorului','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (270,2,10184,'Liteni','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (271,2,5386,'Milișăuți','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (272,2,9941,'Salcea','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (273,2,9304,'Siret','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (274,2,2623,'Solca','CITY',FALSE,35,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (275,2,14892,'Vicovu de Sus','CITY',FALSE,35,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (276,1,30052,'Roșiorii de Vede','MUNICIPALITY',FALSE,36,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (277,1,28488,'Turnu Măgurele','MUNICIPALITY',FALSE,36,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (278,1,49387,'Alexandria','MUNICIPALITY',TRUE,36,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (279,2,11638,'Videle','CITY',FALSE,36,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (280,2,14995,'Zimnicea','CITY',FALSE,36,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (281,1,37321,'Lugoj','MUNICIPALITY',FALSE,37,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (282,1,303708,'Timișoara','MUNICIPALITY',TRUE,37,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (283,2,6504,'Buziaș','CITY',FALSE,37,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (284,2,5028,'Ciacova','CITY',FALSE,37,nulL);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (285,2,5963,'Deta','CITY',FALSE,37,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (286,2,6571,'Făget','CITY',FALSE,37,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (287,2,5449,'Gătaia','CITY',FALSE,37,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (288,2,10048,'Jimbolia','CITY',FALSE,37,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (289,2,7782,'Recaș','CITY',FALSE,37,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (290,2,11540,'Sânnicolau Mare','CITY',FALSE,37,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (291,1,90809,'Tulcea','MUNICIPALITY',TRUE,38,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (292,2,10173,'Babadag','CITY',FALSE,38,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (293,2,5311,'Isaccea','CITY',FALSE,38,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (294,2,10890,'Măcin','CITY',FALSE,38,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (295,2,4358,'Sulina','CITY',FALSE,38,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (296,1,69049,'Bârlad','MUNICIPALITY',FALSE,39,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (297,1,29334,'Huși','MUNICIPALITY',FALSE,39,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (298,1,70060,'Vaslui','MUNICIPALITY',TRUE,39,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (299,2,7877,'Murgeni','CITY',FALSE,39,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (300,2,10160,'Negrești','CITY',FALSE,39,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (301,1,22948,'Drăgășani','MUNICIPALITY',FALSE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (302,1,110901,'Râmnicu Vâlcea','MUNICIPALITY',TRUE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (303,2,5589,'Berbești','CITY',FALSE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (304,2,6972,'Brezoi','CITY',FALSE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (305,2,9747,'Băbeni','CITY',FALSE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (306,2,2887,'Băile Govora','CITY',FALSE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (307,2,4554,'Băile Olănești','CITY',FALSE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (308,2,5546,'Bălcești','CITY',FALSE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (309,2,8794,'Călimănești','CITY',FALSE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (310,2,6729,'Horezu','CITY',FALSE,40,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (311,2,3516,'Ocnele Mari','CITY',FALSE,40,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (316,1,18505,'Adjud','MUNICIPALITY',FALSE,41,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (317,1,101854,'Focșani','MUNICIPALITY',TRUE,41,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (318,2,13070,'Mărășești','CITY',FALSE,41,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (319,2,8839,'Odobești','CITY',FALSE,41,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (320,2,8659,'Panciu','CITY',FALSE,41,null);

INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (321,1,19734,'Gheorgheni','MUNICIPALITY',FALSE,43,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (322,1,36622,'Odorheiu Secuiesc','MUNICIPALITY',FALSE,43,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (323,1,15471,'Toplița','MUNICIPALITY',FALSE,43,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (324,1,41712,'Miercurea Ciuc','MUNICIPALITY',TRUE,43,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (325,2,1604,'Băile Tușnad','CITY',FALSE,43,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (326,2,7496,'Bălan','CITY',FALSE,43,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (327,2,2744,'Borsec','CITY',FALSE,43,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (328,2,10278,'Cristuru Secuiesc','CITY',FALSE,43,null);
INSERT INTO public.plocality_old(id, nivel,locuitori,name, typelocality, residence,code_province,sector)VALUES (329,2,7075,'Vlăhița','CITY',FALSE,43,null);
COMMIT;		
	
INSERT INTO public.plocality(id, name, typelocality, residence, code_province,sector,nivel,locuitori)
            select l.id,l.name,l.typelocality, l.residence, p.indicator ,l.sector,l.nivel,l.locuitori 
			from plocality_old l, pprovince_old p where 
l.code_province = p.id;
  
  -- iNSERCIÓN CNAE
 DROP TABLE public.plocality_old; 
 DROP TABLE public.pprovince_old; 
COMMIT;	
drop sequence seq_locality;
CREATE SEQUENCE seq_locality
    INCREMENT 1
    START 3186
    MINVALUE 1
    MAXVALUE 999999999999999999
    CACHE 1;
COMMIT;


INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (330,3,'COMMUNE',FALSE,'AB','Albac',2185,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (331,3,'COMMUNE',FALSE,'AB','Almaşu Mare',1487,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (332,3,'COMMUNE',FALSE,'AB','Arieşeni',1838,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (333,3,'COMMUNE',FALSE,'AB','Avram Iancu',1772,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (334,3,'COMMUNE',FALSE,'AB','Berghin',2164,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (335,3,'COMMUNE',FALSE,'AB','Bistra',5079,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (336,3,'COMMUNE',FALSE,'AB','Blandiana',1124,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (337,3,'COMMUNE',FALSE,'AB','Bucerdea Grânoasă',2380,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (338,3,'COMMUNE',FALSE,'AB','Bucium',1668,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (339,3,'COMMUNE',FALSE,'AB','Câlnic',1765,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (340,3,'COMMUNE',FALSE,'AB','Cenade',957,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (341,3,'COMMUNE',FALSE,'AB','Cergău',1598,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (342,3,'COMMUNE',FALSE,'AB','Ceru-Băcăinţi',305,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (343,3,'COMMUNE',FALSE,'AB','Cetatea de Baltă',3108,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (344,3,'COMMUNE',FALSE,'AB','Ciugud',2711,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (345,3,'COMMUNE',FALSE,'AB','Ciuruleasa',1235,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (346,3,'COMMUNE',FALSE,'AB','Crăciunelu de Jos',2147,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (347,3,'COMMUNE',FALSE,'AB','Cricău',2143,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (348,3,'COMMUNE',FALSE,'AB','Cut',1246,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (349,3,'COMMUNE',FALSE,'AB','Daia Română',3103,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (350,3,'COMMUNE',FALSE,'AB','Doştat',1019,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (351,3,'COMMUNE',FALSE,'AB','Fărău',1670,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (352,3,'COMMUNE',FALSE,'AB','Galda de Jos',4530,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (353,3,'COMMUNE',FALSE,'AB','Gârbova',2076,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (354,3,'COMMUNE',FALSE,'AB','Gârda de Sus',1777,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (355,3,'COMMUNE',FALSE,'AB','Hopârta',1257,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (356,3,'COMMUNE',FALSE,'AB','Horea',2281,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (357,3,'COMMUNE',FALSE,'AB','Ighiu',6517,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (358,3,'COMMUNE',FALSE,'AB','Întregalde',743,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (359,3,'COMMUNE',FALSE,'AB','Jidvei',5272,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (360,3,'COMMUNE',FALSE,'AB','Livezile',1383,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (361,3,'COMMUNE',FALSE,'AB','Lopadea Nouă',2909,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (362,3,'COMMUNE',FALSE,'AB','Lunca Mureşului',2558,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (363,3,'COMMUNE',FALSE,'AB','Lupşa',3708,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (364,3,'COMMUNE',FALSE,'AB','Meteş',3001,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (365,3,'COMMUNE',FALSE,'AB','Mihalţ',3464,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (366,3,'COMMUNE',FALSE,'AB','Mirăslău',2222,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (367,3,'COMMUNE',FALSE,'AB','Mogoş',976,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (368,3,'COMMUNE',FALSE,'AB','Noşlac',1887,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (369,3,'COMMUNE',FALSE,'AB','Ocoliş',723,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (370,3,'COMMUNE',FALSE,'AB','Ohaba',820,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (371,3,'COMMUNE',FALSE,'AB','Pianu',3543,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (372,3,'COMMUNE',FALSE,'AB','Poiana Vadului',1247,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (373,3,'COMMUNE',FALSE,'AB','Ponor',584,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (374,3,'COMMUNE',FALSE,'AB','Poşaga',1302,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (375,3,'COMMUNE',FALSE,'AB','Rădeşti',1308,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (376,3,'COMMUNE',FALSE,'AB','Râmeţ',626,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (377,3,'COMMUNE',FALSE,'AB','Rimetea',1121,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (378,3,'COMMUNE',FALSE,'AB','Roşia de Secaş',1619,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (379,3,'COMMUNE',FALSE,'AB','Roşia Montană',3398,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (380,3,'COMMUNE',FALSE,'AB','Sălciua',1672,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (381,3,'COMMUNE',FALSE,'AB','Săliştea',2316,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (382,3,'COMMUNE',FALSE,'AB','Săsciori',5947,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (383,3,'COMMUNE',FALSE,'AB','Sâncel',2647,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (384,3,'COMMUNE',FALSE,'AB','Sântimbru',2913,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (385,3,'COMMUNE',FALSE,'AB','Scărişoara',1720,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (386,3,'COMMUNE',FALSE,'AB','Sohodol',1939,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (387,3,'COMMUNE',FALSE,'AB','Stremţ',2623,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (388,3,'COMMUNE',FALSE,'AB','Şibot',2480,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (389,3,'COMMUNE',FALSE,'AB','Şona',4528,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (390,3,'COMMUNE',FALSE,'AB','Şpring',2418,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (391,3,'COMMUNE',FALSE,'AB','Şugag',2932,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (392,3,'COMMUNE',FALSE,'AB','Unirea',5309,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (393,3,'COMMUNE',FALSE,'AB','Vadu Moţilor',1514,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (394,3,'COMMUNE',FALSE,'AB','Valea Lungă ',3169,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (395,3,'COMMUNE',FALSE,'AB','Vidra',1869,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (396,3,'COMMUNE',FALSE,'AB','Vinţu de Jos',5421,null);
                                
	
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (397,3,'Almaş','COMMUNE',FALSE,'AR',2994,null);			
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (398,3,'Apateu','COMMUNE',FALSE,'AR',3672,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (399,3,'Archiş','COMMUNE',FALSE,'AR',1639,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (400,3,'Bata','COMMUNE',FALSE,'AR',1181,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (401,3,'Bârsa','COMMUNE',FALSE,'AR',1916,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (402,3,'Bârzava','COMMUNE',FALSE,'AR',2892,null);			
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (403,3,'Beliu','COMMUNE',FALSE,'AR',3278,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (404,3,'Birchiş','COMMUNE',FALSE,'AR',2030,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (405,3,'Bocsig','COMMUNE',FALSE,'AR',3595,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (406,3,'Brazii','COMMUNE',FALSE,'AR',1314,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (407,3,'Buteni','COMMUNE',FALSE,'AR',3458,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (408,3,'Cărand','COMMUNE',FALSE,'AR',1222,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (409,3,'Cermei','COMMUNE',FALSE,'AR',2849,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (410,3,'Chisindia','COMMUNE',FALSE,'AR',1520,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (411,3,'Conop','COMMUNE',FALSE,'AR',2404,null);			
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (412,3,'Covăsânţ','COMMUNE',FALSE,'AR',2651,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (413,3,'Craiva','COMMUNE',FALSE,'AR',3018,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (414,3,'Dezna','COMMUNE',FALSE,'AR',1415,null);			
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (415,3,'Dieci','COMMUNE',FALSE,'AR',1644,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (416,3,'Dorobanţi','COMMUNE',FALSE,'AR',1688,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (417,3,'Fântânele','COMMUNE',FALSE,'AR',3444,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (418,3,'Felnac','COMMUNE',FALSE,'AR',3016,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (419,3,'Frumuşeni','COMMUNE',FALSE,'AR',2614,null);			
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (420,3,'Ghioroc','COMMUNE',FALSE,'AR',4187,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (421,3,'Grăniceri','COMMUNE',FALSE,'AR',2527,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (422,3,'Gurahonţ','COMMUNE',FALSE,'AR',4332,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (423,3,'Hălmagiu','COMMUNE',FALSE,'AR',3337,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (424,3,'Hălmăgel','COMMUNE',FALSE,'AR',1443,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (425,3,'Hăşmaş','COMMUNE',FALSE,'AR',1400,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (426,3,'Igneşti','COMMUNE',FALSE,'AR',793,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (427,3,'Iratoşu','COMMUNE',FALSE,'AR',2327,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (428,3,'Livada','COMMUNE',FALSE,'AR',2978,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (429,3,'Macea','COMMUNE',FALSE,'AR',6519,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (430,3,'Mişca','COMMUNE',FALSE,'AR',3652,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (431,3,'Moneasa','COMMUNE',FALSE,'AR',1032,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (432,3,'Olari','COMMUNE',FALSE,'AR',2057,null);			
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (433,3,'Păuliş','COMMUNE',FALSE,'AR',4292,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (434,3,'Peregu Mare','COMMUNE',FALSE,'AR',1771,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (435,3,'Petriş','COMMUNE',FALSE,'AR',1617,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (436,3,'Pilu','COMMUNE',FALSE,'AR',2138,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (437,3,'Pleşcuţa','COMMUNE',FALSE,'AR',1314,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (438,3,'Săvârşin','COMMUNE',FALSE,'AR',3209,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (439,3,'Secusigiu','COMMUNE',FALSE,'AR',6074,null);			
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (440,3,'Seleuş','COMMUNE',FALSE,'AR',3106,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (441,3,'Semlac','COMMUNE',FALSE,'AR',3873,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (442,3,'Sintea Mare','COMMUNE',FALSE,'AR',3714,null);			
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (443,3,'Socodor','COMMUNE',FALSE,'AR',2271,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (444,3,'Şagu','COMMUNE',FALSE,'AR',3907,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (445,3,'Şeitin','COMMUNE',FALSE,'AR',3003,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (446,3,'Şepreuş','COMMUNE',FALSE,'AR',2651,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (447,3,'Şicula','COMMUNE',FALSE,'AR',4505,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (448,3,'Şilindia','COMMUNE',FALSE,'AR',865,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (449,3,'Şimand','COMMUNE',FALSE,'AR',4354,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (450,3,'Şiria','COMMUNE',FALSE,'AR',8595,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (451,3,'Şiştarovăţ','COMMUNE',FALSE,'AR',315,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (452,3,'Şofronea','COMMUNE',FALSE,'AR',2684,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (453,3,'Tauţ','COMMUNE',FALSE,'AR',1970,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (454,3,'Târnova','COMMUNE',FALSE,'AR',6173,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (455,3,'Ususău','COMMUNE',FALSE,'AR',1340,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (456,3,'Vărădia de Mureş','COMMUNE',FALSE,'AR',1926,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (457,3,'Vârfurile','COMMUNE',FALSE,'AR',3044,null);			
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (458,3,'Vinga','COMMUNE',FALSE,'AR',6440,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (459,3,'Vladimirescu','COMMUNE',FALSE,'AR',11294,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (460,3,'Zăbrani','COMMUNE',FALSE,'AR',4587,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (461,3,'Zădăreni','COMMUNE',FALSE,'AR',2468,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (462,3,'Zărand','COMMUNE',FALSE,'AR',2718,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (463,3,'Zerind','COMMUNE',FALSE,'AR',1390,null);				
INSERT INTO public.plocality(id,  nivel,name, typelocality, residence, code_province,locuitori,sector)VALUES (464,3,'Zimandu Nou','COMMUNE',FALSE,'AR',4630,null);




INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (465,3,'COMMUNE',FALSE,'AG','Albeştii de Argeş',5971,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (466,3,'COMMUNE',FALSE,'AG','Albeştii de Muscel',1519,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (467,3,'COMMUNE',FALSE,'AG','Albota',3812,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (468,3,'COMMUNE',FALSE,'AG','Aninoasa',3315,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (469,3,'COMMUNE',FALSE,'AG','Arefu',2629,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (470,3,'COMMUNE',FALSE,'AG','Bascov',9246,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (471,3,'COMMUNE',FALSE,'AG','Băbana',2826,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (472,3,'COMMUNE',FALSE,'AG','Băiculeşti',6251,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (473,3,'COMMUNE',FALSE,'AG','Bălileşti',4316,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (474,3,'COMMUNE',FALSE,'AG','Bârla',5614,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (475,3,'COMMUNE',FALSE,'AG','Beleţi-Negreşti',1863,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (476,3,'COMMUNE',FALSE,'AG','Berevoieşti',3481,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (477,3,'COMMUNE',FALSE,'AG','Bogaţi',4717,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (478,3,'COMMUNE',FALSE,'AG','Boteni',2640,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (479,3,'COMMUNE',FALSE,'AG','Boţeşti',1229,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (480,3,'COMMUNE',FALSE,'AG','Bradu',5631,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (481,3,'COMMUNE',FALSE,'AG','Brăduleţ',1952,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (482,3,'COMMUNE',FALSE,'AG','Budeasa',3895,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (483,3,'COMMUNE',FALSE,'AG','Bughea de Jos',2957,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (484,3,'COMMUNE',FALSE,'AG','Bughea de Sus',3154,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (485,3,'COMMUNE',FALSE,'AG','Buzoeşti',6172,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (486,3,'COMMUNE',FALSE,'AG','Căldăraru',2694,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (487,3,'COMMUNE',FALSE,'AG','Călineşti',10926,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (488,3,'COMMUNE',FALSE,'AG','Căteasca',3839,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (489,3,'COMMUNE',FALSE,'AG','Cepari',2379,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (490,3,'COMMUNE',FALSE,'AG','Cetăţeni',3115,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (491,3,'COMMUNE',FALSE,'AG','Cicăneşti',2199,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (492,3,'COMMUNE',FALSE,'AG','Ciofrângeni',2564,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (493,3,'COMMUNE',FALSE,'AG','Ciomăgeşti',1176,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (494,3,'COMMUNE',FALSE,'AG','Cocu',2366,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (495,3,'COMMUNE',FALSE,'AG','Corbeni',5776,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (496,3,'COMMUNE',FALSE,'AG','Corbi',4240,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (497,3,'COMMUNE',FALSE,'AG','Coşeşti',5502,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (498,3,'COMMUNE',FALSE,'AG','Cotmeana',2076,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (499,3,'COMMUNE',FALSE,'AG','Cuca',2206,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (500,3,'COMMUNE',FALSE,'AG','Davideşti',2950,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (501,3,'COMMUNE',FALSE,'AG','Dâmbovicioara',949,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (502,3,'COMMUNE',FALSE,'AG','Dărmăneşti',3611,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (503,3,'COMMUNE',FALSE,'AG','Dobreşti',1795,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (504,3,'COMMUNE',FALSE,'AG','Domneşti',3229,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (505,3,'COMMUNE',FALSE,'AG','Dragoslavele',2534,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (506,3,'COMMUNE',FALSE,'AG','Drăganu',1843,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (507,3,'COMMUNE',FALSE,'AG','Godeni',3246,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (508,3,'COMMUNE',FALSE,'AG','Hârseşti',2529,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (509,3,'COMMUNE',FALSE,'AG','Hârtieşti',2103,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (510,3,'COMMUNE',FALSE,'AG','Izvoru',2531,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (511,3,'COMMUNE',FALSE,'AG','Leordeni',5861,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (512,3,'COMMUNE',FALSE,'AG','Lereşti',898,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (513,3,'COMMUNE',FALSE,'AG','Lunca Corbului',2928,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (514,3,'COMMUNE',FALSE,'AG','Mălureni',4458,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (515,3,'COMMUNE',FALSE,'AG','Mărăcineni',4927,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (516,3,'COMMUNE',FALSE,'AG','Merişani',4750,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (517,3,'COMMUNE',FALSE,'AG','Miceşti',4377,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (518,3,'COMMUNE',FALSE,'AG','Mihăeşti',5977,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (519,3,'COMMUNE',FALSE,'AG','Mioarele',1695,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (520,3,'COMMUNE',FALSE,'AG','Miroşi',2672,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (521,3,'COMMUNE',FALSE,'AG','Morăreşti',1958,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (522,3,'COMMUNE',FALSE,'AG','Moşoaia',4409,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (523,3,'COMMUNE',FALSE,'AG','Mozăceni',2546,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (524,3,'COMMUNE',FALSE,'AG','Muşăteşti',4022,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (525,3,'COMMUNE',FALSE,'AG','Negraşi',2570,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (526,3,'COMMUNE',FALSE,'AG','Nucşoara',1562,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (527,3,'COMMUNE',FALSE,'AG','Oarja',2892,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (528,3,'COMMUNE',FALSE,'AG','Pietroşani',5967,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (529,3,'COMMUNE',FALSE,'AG','Poiana Lacului',6819,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (530,3,'COMMUNE',FALSE,'AG','Poienarii de Argeş',1140,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (531,3,'COMMUNE',FALSE,'AG','Poienarii de Muscel',3574,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (532,3,'COMMUNE',FALSE,'AG','Popeşti',2326,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (533,3,'COMMUNE',FALSE,'AG','Priboieni',3502,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (534,3,'COMMUNE',FALSE,'AG','Răteşti',3345,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (535,3,'COMMUNE',FALSE,'AG','Râca',1425,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (536,3,'COMMUNE',FALSE,'AG','Recea',3086,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (537,3,'COMMUNE',FALSE,'AG','Rociu',2693,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (538,3,'COMMUNE',FALSE,'AG','Rucăr',6149,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (539,3,'COMMUNE',FALSE,'AG','Sălătrucu',2220,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (540,3,'COMMUNE',FALSE,'AG','Săpata',1902,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (541,3,'COMMUNE',FALSE,'AG','Schitu Goleşti',5041,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (542,3,'COMMUNE',FALSE,'AG','Slobozia',4981,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (543,3,'COMMUNE',FALSE,'AG','Stâlpeni',5018,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (544,3,'COMMUNE',FALSE,'AG','Stoeneşti',4563,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (545,3,'COMMUNE',FALSE,'AG','Stolnici',3623,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (546,3,'COMMUNE',FALSE,'AG','Suseni',3149,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (547,3,'COMMUNE',FALSE,'AG','Ştefan cel Mare',2488,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (548,3,'COMMUNE',FALSE,'AG','Şuici',2724,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (549,3,'COMMUNE',FALSE,'AG','Teiu',1556,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (550,3,'COMMUNE',FALSE,'AG','Tigveni',3424,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (551,3,'COMMUNE',FALSE,'AG','Ţiţeşti',4931,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (552,3,'COMMUNE',FALSE,'AG','Uda',2227,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (553,3,'COMMUNE',FALSE,'AG','Ungheni',3416,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (554,3,'COMMUNE',FALSE,'AG','Valea Danului',3003,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (555,3,'COMMUNE',FALSE,'AG','Valea Iaşului',2765,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (556,3,'COMMUNE',FALSE,'AG','Valea Mare-Pravăţ',4365,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (557,3,'COMMUNE',FALSE,'AG','Vedea',3969,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (558,3,'COMMUNE',FALSE,'AG','Vlădeşti',3185,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (559,3,'COMMUNE',FALSE,'AG','Vultureşti',2892,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (560,3,'COMMUNE',FALSE,'BC','Agăş',7316,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (561,3,'COMMUNE',FALSE,'BC','Ardeoani',2520,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (562,3,'COMMUNE',FALSE,'BC','Asău',6787,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (563,3,'COMMUNE',FALSE,'BC','Balcani',8161,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (564,3,'COMMUNE',FALSE,'BC','Bereşti-Bistriţa',2072,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (565,3,'COMMUNE',FALSE,'BC','Bereşti-Tazlău',5805,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (566,3,'COMMUNE',FALSE,'BC','Berzunţi',5380,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (567,3,'COMMUNE',FALSE,'BC','Bârsăneşti',5199,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (568,3,'COMMUNE',FALSE,'BC','Blăgeşti',7303,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (569,3,'COMMUNE',FALSE,'BC','Bogdăneşti',2757,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (570,3,'COMMUNE',FALSE,'BC','Brusturoasa',3531,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (571,3,'COMMUNE',FALSE,'BC','Buciumi',3163,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (572,3,'COMMUNE',FALSE,'BC','Buhoci',4994,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (573,3,'COMMUNE',FALSE,'BC','Caşin',4073,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (574,3,'COMMUNE',FALSE,'BC','Căiuţi',5437,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (575,3,'COMMUNE',FALSE,'BC','Cleja',7060,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (576,3,'COMMUNE',FALSE,'BC','Coloneşti',2229,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (577,3,'COMMUNE',FALSE,'BC','Corbasca',5792,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (578,3,'COMMUNE',FALSE,'BC','Coţofăneşti',3297,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (579,3,'COMMUNE',FALSE,'BC','Dămieneşti',1921,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (580,3,'COMMUNE',FALSE,'BC','Dealu Morii',2910,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (581,3,'COMMUNE',FALSE,'BC','Dofteana',11201,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (582,3,'COMMUNE',FALSE,'BC','Faraoani',5554,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (583,3,'COMMUNE',FALSE,'BC','Filipeni',2326,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (584,3,'COMMUNE',FALSE,'BC','Filipeşti',4738,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (585,3,'COMMUNE',FALSE,'BC','Găiceana',3007,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (586,3,'COMMUNE',FALSE,'BC','Gârleni',6742,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (587,3,'COMMUNE',FALSE,'BC','Ghimeş-Făget',5156,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (588,3,'COMMUNE',FALSE,'BC','Gioseni',3600,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (589,3,'COMMUNE',FALSE,'BC','Glăvăneşti',3571,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (590,3,'COMMUNE',FALSE,'BC','Gura Văii',6183,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (591,3,'COMMUNE',FALSE,'BC','Helegiu',7238,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (592,3,'COMMUNE',FALSE,'BC','Hemeiuş',4387,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (593,3,'COMMUNE',FALSE,'BC','Horgeşti',4867,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (594,3,'COMMUNE',FALSE,'BC','Huruieşti',2767,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (595,3,'COMMUNE',FALSE,'BC','Iteşti',1509,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (596,3,'COMMUNE',FALSE,'BC','Izvoru Berheciului',1735,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (597,3,'COMMUNE',FALSE,'BC','Letea Veche',5657,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (598,3,'COMMUNE',FALSE,'BC','Lipova',2936,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (599,3,'COMMUNE',FALSE,'BC','Livezi',5350,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (600,3,'COMMUNE',FALSE,'BC','Luizi-Călugăra',5319,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (601,3,'COMMUNE',FALSE,'BC','Măgireşti',4522,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (602,3,'COMMUNE',FALSE,'BC','Măgura',4475,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (603,3,'COMMUNE',FALSE,'BC','Mănăstirea Caşin',5561,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (604,3,'COMMUNE',FALSE,'BC','Mărgineni',9160,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (605,3,'COMMUNE',FALSE,'BC','Motoşeni',3807,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (606,3,'COMMUNE',FALSE,'BC','Negri',2926,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (607,3,'COMMUNE',FALSE,'BC','Nicolae Bălcescu',9388,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (608,3,'COMMUNE',FALSE,'BC','Odobeşti',2431,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (609,3,'COMMUNE',FALSE,'BC','Oituz',9622,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (610,3,'COMMUNE',FALSE,'BC','Onceşti',1781,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (611,3,'COMMUNE',FALSE,'BC','Orbeni',4081,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (612,3,'COMMUNE',FALSE,'BC','Palanca',3613,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (613,3,'COMMUNE',FALSE,'BC','Parava',3464,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (614,3,'COMMUNE',FALSE,'BC','Parincea',3891,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (615,3,'COMMUNE',FALSE,'BC','Pânceşti',4353,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (616,3,'COMMUNE',FALSE,'BC','Pârgăreşti',4889,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (617,3,'COMMUNE',FALSE,'BC','Pârjol',6805,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (618,3,'COMMUNE',FALSE,'BC','Plopana',3438,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (619,3,'COMMUNE',FALSE,'BC','Podu Turcului',5072,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (620,3,'COMMUNE',FALSE,'BC','Poduri',8169,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (621,3,'COMMUNE',FALSE,'BC','Prăjeşti',2617,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (622,3,'COMMUNE',FALSE,'BC','Racova',3466,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (623,3,'COMMUNE',FALSE,'BC','Răcăciuni',8307,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (624,3,'COMMUNE',FALSE,'BC','Răchitoasa',4960,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (625,3,'COMMUNE',FALSE,'BC','Roşiori',2284,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (626,3,'COMMUNE',FALSE,'BC','Sascut',10241,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (627,3,'COMMUNE',FALSE,'BC','Sănduleni',4479,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (628,3,'COMMUNE',FALSE,'BC','Sărata',2304,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (629,3,'COMMUNE',FALSE,'BC','Săuceşti',4780,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (630,3,'COMMUNE',FALSE,'BC','Scorţeni',3146,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (631,3,'COMMUNE',FALSE,'BC','Secuieni',2132,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (632,3,'COMMUNE',FALSE,'BC','Solonţ',3841,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (633,3,'COMMUNE',FALSE,'BC','Stănişeşti',4747,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (634,3,'COMMUNE',FALSE,'BC','Strugari',2565,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (635,3,'COMMUNE',FALSE,'BC','Ştefan cel Mare',4298,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (636,3,'COMMUNE',FALSE,'BC','Tamaşi',3249,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (637,3,'COMMUNE',FALSE,'BC','Tătărăşti',2575,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (638,3,'COMMUNE',FALSE,'BC','Târgu Trotuş',5598,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (639,3,'COMMUNE',FALSE,'BC','Traian',2952,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (640,3,'COMMUNE',FALSE,'BC','Ungureni',3903,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (641,3,'COMMUNE',FALSE,'BC','Urecheşti',3931,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (642,3,'COMMUNE',FALSE,'BC','Valea Seacă',4130,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (643,3,'COMMUNE',FALSE,'BC','Vultureni',2093,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (644,3,'COMMUNE',FALSE,'BC','Zemeş',5119,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (645,3,'COMMUNE',FALSE,'BH','Abram',3252,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (646,3,'COMMUNE',FALSE,'BH','Abrămuţ',3125,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (647,3,'COMMUNE',FALSE,'BH','Aştileu',3814,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (648,3,'COMMUNE',FALSE,'BH','Auşeu',3073,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (649,3,'COMMUNE',FALSE,'BH','Avram Iancu',3373,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (650,3,'COMMUNE',FALSE,'BH','Balc',3571,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (651,3,'COMMUNE',FALSE,'BH','Batăr',5173,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (652,3,'COMMUNE',FALSE,'BH','Biharia',3872,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (653,3,'COMMUNE',FALSE,'BH','Boianu Mare',1404,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (654,3,'COMMUNE',FALSE,'BH','Borod',4048,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (655,3,'COMMUNE',FALSE,'BH','Borş',3483,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (656,3,'COMMUNE',FALSE,'BH','Bratca',5264,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (657,3,'COMMUNE',FALSE,'BH','Brusturi',4064,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (658,3,'COMMUNE',FALSE,'BH','Budureasa',2669,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (659,3,'COMMUNE',FALSE,'BH','Buduslău',1937,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (660,3,'COMMUNE',FALSE,'BH','Bulz',2175,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (661,3,'COMMUNE',FALSE,'BH','Bunteşti',4649,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (662,3,'COMMUNE',FALSE,'BH','Căbeşti',1989,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (663,3,'COMMUNE',FALSE,'BH','Căpâlna',1814,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (664,3,'COMMUNE',FALSE,'BH','Cărpinet',2090,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (665,3,'COMMUNE',FALSE,'BH','Câmpani',2573,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (666,3,'COMMUNE',FALSE,'BH','Cefa',2383,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (667,3,'COMMUNE',FALSE,'BH','Ceica',3904,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (668,3,'COMMUNE',FALSE,'BH','Cetariu',2133,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (669,3,'COMMUNE',FALSE,'BH','Cherechiu',2492,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (670,3,'COMMUNE',FALSE,'BH','Chişlaz',3296,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (671,3,'COMMUNE',FALSE,'BH','Ciuhoi',2213,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (672,3,'COMMUNE',FALSE,'BH','Ciumeghiu',4499,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (673,3,'COMMUNE',FALSE,'BH','Cociuba Mare',3027,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (674,3,'COMMUNE',FALSE,'BH','Copăcel',2220,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (675,3,'COMMUNE',FALSE,'BH','Criştioru de Jos',1470,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (676,3,'COMMUNE',FALSE,'BH','Curăţele',2647,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (677,3,'COMMUNE',FALSE,'BH','Curtuişeni',3814,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (678,3,'COMMUNE',FALSE,'BH','Derna',2812,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (679,3,'COMMUNE',FALSE,'BH','Diosig',6912,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (680,3,'COMMUNE',FALSE,'BH','Dobreşti',5651,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (681,3,'COMMUNE',FALSE,'BH','Drăgăneşti',2937,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (682,3,'COMMUNE',FALSE,'BH','Drăgeşti',2515,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (683,3,'COMMUNE',FALSE,'BH','Finiş',3681,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (684,3,'COMMUNE',FALSE,'BH','Gepiu',1778,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (685,3,'COMMUNE',FALSE,'BH','Girişu de Criş',5690,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (686,3,'COMMUNE',FALSE,'BH','Hidişelu de Sus',3145,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (687,3,'COMMUNE',FALSE,'BH','Holod',3321,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (688,3,'COMMUNE',FALSE,'BH','Husasău de Tinca',2282,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (689,3,'COMMUNE',FALSE,'BH','Ineu',4182,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (690,3,'COMMUNE',FALSE,'BH','Lazuri de Beiuş',1735,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (691,3,'COMMUNE',FALSE,'BH','Lăzăreni',2955,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (692,3,'COMMUNE',FALSE,'BH','Lugaşu de Jos',3351,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (693,3,'COMMUNE',FALSE,'BH','Lunca',2960,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (694,3,'COMMUNE',FALSE,'BH','Mădăras',2829,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (695,3,'COMMUNE',FALSE,'BH','Măgeşti',2784,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (696,3,'COMMUNE',FALSE,'BH','Nojorid',4532,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (697,3,'COMMUNE',FALSE,'BH','Olcea',2786,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (698,3,'COMMUNE',FALSE,'BH','Oşorhei',6151,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (699,3,'COMMUNE',FALSE,'BH','Paleu',1656,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (700,3,'COMMUNE',FALSE,'BH','Pietroasa',3311,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (701,3,'COMMUNE',FALSE,'BH','Pocola',1578,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (702,3,'COMMUNE',FALSE,'BH','Pomezeu',3176,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (703,3,'COMMUNE',FALSE,'BH','Popeşti',8224,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (704,3,'COMMUNE',FALSE,'BH','Răbăgani',2117,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (705,3,'COMMUNE',FALSE,'BH','Remetea',3011,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (706,3,'COMMUNE',FALSE,'BH','Rieni',3111,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (707,3,'COMMUNE',FALSE,'BH','Roşia',2570,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (708,3,'COMMUNE',FALSE,'BH','Roşiori',3145,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (709,3,'COMMUNE',FALSE,'BH','Săcădat',1816,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (710,3,'COMMUNE',FALSE,'BH','Sălacea',3141,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (711,3,'COMMUNE',FALSE,'BH','Sălard',4210,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (712,3,'COMMUNE',FALSE,'BH','Sâmbăta',1522,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (713,3,'COMMUNE',FALSE,'BH','Sânmartin',8390,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (714,3,'COMMUNE',FALSE,'BH','Sânnicolau Român',2082,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (715,3,'COMMUNE',FALSE,'BH','Sântandrei',3978,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (716,3,'COMMUNE',FALSE,'BH','Sârbi',2758,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (717,3,'COMMUNE',FALSE,'BH','Spinuş',1196,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (718,3,'COMMUNE',FALSE,'BH','Suplacu de Barcău',4522,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (719,3,'COMMUNE',FALSE,'BH','Şimian',3845,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (720,3,'COMMUNE',FALSE,'BH','Şinteu',1231,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (721,3,'COMMUNE',FALSE,'BH','Şoimi',2881,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (722,3,'COMMUNE',FALSE,'BH','Şuncuiuş',3370,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (723,3,'COMMUNE',FALSE,'BH','Tarcea',2590,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (724,3,'COMMUNE',FALSE,'BH','Tămăşeu',1946,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (725,3,'COMMUNE',FALSE,'BH','Tărcaia',2025,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (726,3,'COMMUNE',FALSE,'BH','Tăuteu',4494,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (727,3,'COMMUNE',FALSE,'BH','Tileagd',7098,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (728,3,'COMMUNE',FALSE,'BH','Tinca',7682,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (729,3,'COMMUNE',FALSE,'BH','Toboliu',2183,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (730,3,'COMMUNE',FALSE,'BH','Tulca',2876,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (731,3,'COMMUNE',FALSE,'BH','Ţeţchea',3059,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (732,3,'COMMUNE',FALSE,'BH','Uileacu de Beiuş',2336,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (733,3,'COMMUNE',FALSE,'BH','Vadu Crişulu',4276,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (734,3,'COMMUNE',FALSE,'BH','Vârciorog',2236,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (735,3,'COMMUNE',FALSE,'BH','Viişoara',1360,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (736,3,'COMMUNE',FALSE,'BN','Bistriţa Bârgăului',4394,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (737,3,'COMMUNE',FALSE,'BN','Braniştea',3284,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (738,3,'COMMUNE',FALSE,'BN','Budacu de Jos',3135,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (739,3,'COMMUNE',FALSE,'BN','Budeşti',2064,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (740,3,'COMMUNE',FALSE,'BN','Căianu Mic',4045,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (741,3,'COMMUNE',FALSE,'BN','Cetate',2577,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (742,3,'COMMUNE',FALSE,'BN','Chiochiş',3324,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (743,3,'COMMUNE',FALSE,'BN','Chiuza',2288,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (744,3,'COMMUNE',FALSE,'BN','Ciceu-Giurgeşti',1737,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (745,3,'COMMUNE',FALSE,'BN','Ciceu-Mihăieşti',1392,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (746,3,'COMMUNE',FALSE,'BN','Coşbuc',1996,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (747,3,'COMMUNE',FALSE,'BN','Dumitra',4760,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (748,3,'COMMUNE',FALSE,'BN','Dumitriţa',2938,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (749,3,'COMMUNE',FALSE,'BN','Feldru',7712,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (750,3,'COMMUNE',FALSE,'BN','Galaţii Bistriţei',2529,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (751,3,'COMMUNE',FALSE,'BN','Ilva Mare',2593,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (752,3,'COMMUNE',FALSE,'BN','Ilva Mică',3448,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (753,3,'COMMUNE',FALSE,'BN','Josenii Bârgăului',5214,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (754,3,'COMMUNE',FALSE,'BN','Lechinţa',6114,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (755,3,'COMMUNE',FALSE,'BN','Leşu',3019,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (756,3,'COMMUNE',FALSE,'BN','Livezile',4600,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (757,3,'COMMUNE',FALSE,'BN','Lunca Ilvei',3280,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (758,3,'COMMUNE',FALSE,'BN','Maieru',7681,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (759,3,'COMMUNE',FALSE,'BN','Matei',2895,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (760,3,'COMMUNE',FALSE,'BN','Măgura Ilvei',2131,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (761,3,'COMMUNE',FALSE,'BN','Mărişelu',2641,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (762,3,'COMMUNE',FALSE,'BN','Miceştii de Câmpie',1207,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (763,3,'COMMUNE',FALSE,'BN','Milaş',1494,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (764,3,'COMMUNE',FALSE,'BN','Monor',1531,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (765,3,'COMMUNE',FALSE,'BN','Negrileşti',2510,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (766,3,'COMMUNE',FALSE,'BN','Nimigea',5324,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (767,3,'COMMUNE',FALSE,'BN','Nuşeni',3111,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (768,3,'COMMUNE',FALSE,'BN','Parva',2747,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (769,3,'COMMUNE',FALSE,'BN','Petru Rareş',3710,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (770,3,'COMMUNE',FALSE,'BN','Poiana Ilvei',1620,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (771,3,'COMMUNE',FALSE,'BN','Prundu Bârgăului',6565,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (772,3,'COMMUNE',FALSE,'BN','Rebra',3067,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (773,3,'COMMUNE',FALSE,'BN','Rebrişoara',4883,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (774,3,'COMMUNE',FALSE,'BN','Rodna',6378,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (775,3,'COMMUNE',FALSE,'BN','Romuli',1729,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (776,3,'COMMUNE',FALSE,'BN','Runcu Salvei',1423,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (777,3,'COMMUNE',FALSE,'BN','Salva',2893,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (778,3,'COMMUNE',FALSE,'BN','Sânmihaiu de Câmpie',1563,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (779,3,'COMMUNE',FALSE,'BN','Silivaşu de Câmpie',1173,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (780,3,'COMMUNE',FALSE,'BN','Spermezeu',3958,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (781,3,'COMMUNE',FALSE,'BN','Şanţ',3429,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (782,3,'COMMUNE',FALSE,'BN','Şieu',3186,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (783,3,'COMMUNE',FALSE,'BN','Şieu-Măgheruş',4129,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (784,3,'COMMUNE',FALSE,'BN','Şieu-Odorhei',2609,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (785,3,'COMMUNE',FALSE,'BN','Şieuţ',2779,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (786,3,'COMMUNE',FALSE,'BN','Şintereag',3855,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (787,3,'COMMUNE',FALSE,'BN','Târlişua',3643,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (788,3,'COMMUNE',FALSE,'BN','Teaca',6015,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (789,3,'COMMUNE',FALSE,'BN','Telciu',6269,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (790,3,'COMMUNE',FALSE,'BN','Tiha Bârgăului',6390,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (791,3,'COMMUNE',FALSE,'BN','Uriu',3688,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (792,3,'COMMUNE',FALSE,'BN','Urmeniş',2178,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (793,3,'COMMUNE',FALSE,'BN','Zagra',3703,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (794,3,'COMMUNE',FALSE,'BT','Adăşeni',1556,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (795,3,'COMMUNE',FALSE,'BT','Albeşti',6871,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (796,3,'COMMUNE',FALSE,'BT','Avrămeni',3841,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (797,3,'COMMUNE',FALSE,'BT','Băluşeni',5055,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (798,3,'COMMUNE',FALSE,'BT','Blândeşti',2412,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (799,3,'COMMUNE',FALSE,'BT','Brăeşti',2144,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (800,3,'COMMUNE',FALSE,'BT','Broscăuţi',3476,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (801,3,'COMMUNE',FALSE,'BT','Călăraşi',3757,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (802,3,'COMMUNE',FALSE,'BT','Cândeşti',2223,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (803,3,'COMMUNE',FALSE,'BT','Conceşti',2013,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (804,3,'COMMUNE',FALSE,'BT','Copălău',4253,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (805,3,'COMMUNE',FALSE,'BT','Cordăreni',2062,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (806,3,'COMMUNE',FALSE,'BT','Corlăteni',2443,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (807,3,'COMMUNE',FALSE,'BT','Corni',6695,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (808,3,'COMMUNE',FALSE,'BT','Coşula',3009,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (809,3,'COMMUNE',FALSE,'BT','Coţuşca',5127,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (810,3,'COMMUNE',FALSE,'BT','Cristeşti',4843,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (811,3,'COMMUNE',FALSE,'BT','Cristineşti',3796,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (812,3,'COMMUNE',FALSE,'BT','Curteşti',4613,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (813,3,'COMMUNE',FALSE,'BT','Dersca',3216,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (814,3,'COMMUNE',FALSE,'BT','Dângeni',3115,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (815,3,'COMMUNE',FALSE,'BT','Dimăcheni',1452,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (816,3,'COMMUNE',FALSE,'BT','Dobârceni',2867,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (817,3,'COMMUNE',FALSE,'BT','Drăguşeni',2769,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (818,3,'COMMUNE',FALSE,'BT','Durneşti',4158,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (819,3,'COMMUNE',FALSE,'BT','Frumuşica',6170,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (820,3,'COMMUNE',FALSE,'BT','George Enescu',3605,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (821,3,'COMMUNE',FALSE,'BT','Gorbăneşti',3551,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (822,3,'COMMUNE',FALSE,'BT','Havârna',4943,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (823,3,'COMMUNE',FALSE,'BT','Hăneşti',2255,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (824,3,'COMMUNE',FALSE,'BT','Hilişeu-Horia',3659,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (825,3,'COMMUNE',FALSE,'BT','Hlipiceni',3828,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (826,3,'COMMUNE',FALSE,'BT','Hudeşti',6384,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (827,3,'COMMUNE',FALSE,'BT','Ibăneşti',4150,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (828,3,'COMMUNE',FALSE,'BT','Leorda',2736,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (829,3,'COMMUNE',FALSE,'BT','Lozna',2220,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (830,3,'COMMUNE',FALSE,'BT','Lunca',4773,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (831,3,'COMMUNE',FALSE,'BT','Manoleasa',3669,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (832,3,'COMMUNE',FALSE,'BT','Mihai Eminescu',6807,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (833,3,'COMMUNE',FALSE,'BT','Mihăileni',2752,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (834,3,'COMMUNE',FALSE,'BT','Mihălăşeni',2394,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (835,3,'COMMUNE',FALSE,'BT','Mileanca',2900,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (836,3,'COMMUNE',FALSE,'BT','Mitoc',1997,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (837,3,'COMMUNE',FALSE,'BT','Nicşeni',2860,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (838,3,'COMMUNE',FALSE,'BT','Păltiniş',3240,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (839,3,'COMMUNE',FALSE,'BT','Pomârla',2860,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (840,3,'COMMUNE',FALSE,'BT','Prăjeni',3393,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (841,3,'COMMUNE',FALSE,'BT','Răchiţi',4740,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (842,3,'COMMUNE',FALSE,'BT','Rădăuţi-Prut',3801,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (843,3,'COMMUNE',FALSE,'BT','Răuseni',3091,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (844,3,'COMMUNE',FALSE,'BT','Ripiceni',2301,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (845,3,'COMMUNE',FALSE,'BT','Roma',3355,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (846,3,'COMMUNE',FALSE,'BT','Româneşti',2138,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (847,3,'COMMUNE',FALSE,'BT','Santa Mare',3104,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (848,3,'COMMUNE',FALSE,'BT','Stăuceni',3431,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (849,3,'COMMUNE',FALSE,'BT','Suharău',5239,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (850,3,'COMMUNE',FALSE,'BT','Suliţa',3183,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (851,3,'COMMUNE',FALSE,'BT','Şendriceni',4423,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (852,3,'COMMUNE',FALSE,'BT','Ştiubieni',2906,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (853,3,'COMMUNE',FALSE,'BT','Todireni',3655,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (854,3,'COMMUNE',FALSE,'BT','Truşeşti',5810,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (855,3,'COMMUNE',FALSE,'BT','Tudora',5292,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (856,3,'COMMUNE',FALSE,'BT','Ungureni',7123,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (857,3,'COMMUNE',FALSE,'BT','Unţeni',2936,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (858,3,'COMMUNE',FALSE,'BT','Văculeşti',2222,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (859,3,'COMMUNE',FALSE,'BT','Vârfu Câmpului',3926,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (860,3,'COMMUNE',FALSE,'BT','Viişoara',2222,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (861,3,'COMMUNE',FALSE,'BT','Vlădeni',5018,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (862,3,'COMMUNE',FALSE,'BT','Vlăsineşti',3353,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (863,3,'COMMUNE',FALSE,'BT','Vorniceni',4500,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (864,3,'COMMUNE',FALSE,'BT','Vorona',8097,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (865,3,'COMMUNE',FALSE,'BV','Apaţa',3168,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (866,3,'COMMUNE',FALSE,'BV','Augustin',1662,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (867,3,'COMMUNE',FALSE,'BV','Beclean',1642,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (868,3,'COMMUNE',FALSE,'BV','Bod',4173,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (869,3,'COMMUNE',FALSE,'BV','Bran',5334,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (870,3,'COMMUNE',FALSE,'BV','Budila',3931,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (871,3,'COMMUNE',FALSE,'BV','Buneşti',2521,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (872,3,'COMMUNE',FALSE,'BV','Caţa',2678,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (873,3,'COMMUNE',FALSE,'BV','Cincu',1829,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (874,3,'COMMUNE',FALSE,'BV','Comăna',2702,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (875,3,'COMMUNE',FALSE,'BV','Cristian',4300,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (876,3,'COMMUNE',FALSE,'BV','Crizbav',2252,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (877,3,'COMMUNE',FALSE,'BV','Drăguş',1183,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (878,3,'COMMUNE',FALSE,'BV','Dumbrăviţa',4888,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (879,3,'COMMUNE',FALSE,'BV','Feldioara',6858,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (880,3,'COMMUNE',FALSE,'BV','Fundata',879,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (881,3,'COMMUNE',FALSE,'BV','Hălchiu',4560,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (882,3,'COMMUNE',FALSE,'BV','Hărman',4775,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (883,3,'COMMUNE',FALSE,'BV','Hârseni',2215,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (884,3,'COMMUNE',FALSE,'BV','Hoghiz',5172,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (885,3,'COMMUNE',FALSE,'BV','Holbav',1287,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (886,3,'COMMUNE',FALSE,'BV','Homorod',2304,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (887,3,'COMMUNE',FALSE,'BV','Jibert',2455,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (888,3,'COMMUNE',FALSE,'BV','Lisa',1613,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (889,3,'COMMUNE',FALSE,'BV','Măieruş',2680,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (890,3,'COMMUNE',FALSE,'BV','Mândra',2961,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (891,3,'COMMUNE',FALSE,'BV','Moieciu',4689,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (892,3,'COMMUNE',FALSE,'BV','Ormeniş',2065,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (893,3,'COMMUNE',FALSE,'BV','Părău',2111,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (894,3,'COMMUNE',FALSE,'BV','Poiana Mărului',3300,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (895,3,'COMMUNE',FALSE,'BV','Prejmer',8876,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (896,3,'COMMUNE',FALSE,'BV','Racoş',3414,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (897,3,'COMMUNE',FALSE,'BV','Recea',3183,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (898,3,'COMMUNE',FALSE,'BV','Sâmbăta de Sus',1437,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (899,3,'COMMUNE',FALSE,'BV','Sânpetru',3759,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (900,3,'COMMUNE',FALSE,'BV','Şercaia',3116,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (901,3,'COMMUNE',FALSE,'BV','Şinca',3689,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (902,3,'COMMUNE',FALSE,'BV','Şinca Nouă',1677,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (903,3,'COMMUNE',FALSE,'BV','Şoarş',1860,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (904,3,'COMMUNE',FALSE,'BV','Tărlungeni',7996,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (905,3,'COMMUNE',FALSE,'BV','Teliu',3960,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (906,3,'COMMUNE',FALSE,'BV','Ticuş',919,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (907,3,'COMMUNE',FALSE,'BV','Ucea',2216,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (908,3,'COMMUNE',FALSE,'BV','Ungra',2144,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (909,3,'COMMUNE',FALSE,'BV','Vama Buzăului',3321,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (910,3,'COMMUNE',FALSE,'BV','Viştea',2082,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (911,3,'COMMUNE',FALSE,'BV','Voila',2996,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (912,3,'COMMUNE',FALSE,'BV','Comuna Vulcan',4551,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (913,3,'COMMUNE',FALSE,'BR','Bărăganul',3430,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (914,3,'COMMUNE',FALSE,'BR','Berteştii de Jos',3165,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (915,3,'COMMUNE',FALSE,'BR','Bordei Verde',2828,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (916,3,'COMMUNE',FALSE,'BR','Cazasu',3145,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (917,3,'COMMUNE',FALSE,'BR','Chişcani',5612,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (918,3,'COMMUNE',FALSE,'BR','Ciocile',2959,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (919,3,'COMMUNE',FALSE,'BR','Cireşu',3370,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (920,3,'COMMUNE',FALSE,'BR','Dudeşti',3869,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (921,3,'COMMUNE',FALSE,'BR','Frecăţei',1607,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (922,3,'COMMUNE',FALSE,'BR','Galbenu',3366,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (923,3,'COMMUNE',FALSE,'BR','Gemenele',1848,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (924,3,'COMMUNE',FALSE,'BR','Grădiştea',2398,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (925,3,'COMMUNE',FALSE,'BR','Gropeni',3356,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (926,3,'COMMUNE',FALSE,'BR','Jirlău',3337,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (927,3,'COMMUNE',FALSE,'BR','Măraşu',3288,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (928,3,'COMMUNE',FALSE,'BR','Măxineni',3539,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (929,3,'COMMUNE',FALSE,'BR','Mircea Vodă',3498,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (930,3,'COMMUNE',FALSE,'BR','Movila Miresii',4350,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (931,3,'COMMUNE',FALSE,'BR','Racoviţa',1277,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (932,3,'COMMUNE',FALSE,'BR','Râmnicelu',2216,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (933,3,'COMMUNE',FALSE,'BR','Romanu',1949,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (934,3,'COMMUNE',FALSE,'BR','Roşiori',2940,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (935,3,'COMMUNE',FALSE,'BR','Salcia Tudor',2777,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (936,3,'COMMUNE',FALSE,'BR','Scorţaru Nou',1369,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (937,3,'COMMUNE',FALSE,'BR','Siliştea',1864,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (938,3,'COMMUNE',FALSE,'BR','Stăncuţa',3696,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (939,3,'COMMUNE',FALSE,'BR','Surdila-Găiseanca',2648,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (940,3,'COMMUNE',FALSE,'BR','Surdila-Greci',1550,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (941,3,'COMMUNE',FALSE,'BR','Şuţeşti',4561,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (942,3,'COMMUNE',FALSE,'BR','Tichileşti',3813,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (943,3,'COMMUNE',FALSE,'BR','Traian',3636,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (944,3,'COMMUNE',FALSE,'BR','Tudor Vladimirescu',2124,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (945,3,'COMMUNE',FALSE,'BR','Tufeşti',5774,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (946,3,'COMMUNE',FALSE,'BR','Ulmu',4118,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (947,3,'COMMUNE',FALSE,'BR','Unirea',2591,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (948,3,'COMMUNE',FALSE,'BR','Vădeni',3755,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (949,3,'COMMUNE',FALSE,'BR','Victoria',3965,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (950,3,'COMMUNE',FALSE,'BR','Vişani',2676,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (951,3,'COMMUNE',FALSE,'BR','Viziru',6090,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (952,3,'COMMUNE',FALSE,'BR','Zăvoaia',3352,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (953,3,'COMMUNE',FALSE,'BZ','Amaru',2503,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (954,3,'COMMUNE',FALSE,'BZ','Balta Albă',2835,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (955,3,'COMMUNE',FALSE,'BZ','Bălăceanu',1806,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (956,3,'COMMUNE',FALSE,'BZ','Beceni',4720,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (957,3,'COMMUNE',FALSE,'BZ','Berca',9197,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (958,3,'COMMUNE',FALSE,'BZ','Bisoca',2870,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (959,3,'COMMUNE',FALSE,'BZ','Blăjani',1112,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (960,3,'COMMUNE',FALSE,'BZ','Boldu',2453,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (961,3,'COMMUNE',FALSE,'BZ','Bozioru',1250,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (962,3,'COMMUNE',FALSE,'BZ','Brădeanu',2626,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (963,3,'COMMUNE',FALSE,'BZ','Brăeşti',2491,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (964,3,'COMMUNE',FALSE,'BZ','Breaza',2874,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (965,3,'COMMUNE',FALSE,'BZ','Buda',3133,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (966,3,'COMMUNE',FALSE,'BZ','C.A. Rosetti',3962,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (967,3,'COMMUNE',FALSE,'BZ','Calvini',444,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (968,3,'COMMUNE',FALSE,'BZ','Căneşti',975,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (969,3,'COMMUNE',FALSE,'BZ','Cătina',2582,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (970,3,'COMMUNE',FALSE,'BZ','Cernăteşti',3903,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (971,3,'COMMUNE',FALSE,'BZ','Chiliile',698,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (972,3,'COMMUNE',FALSE,'BZ','Chiojdu',3661,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (973,3,'COMMUNE',FALSE,'BZ','Cilibia',1912,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (974,3,'COMMUNE',FALSE,'BZ','Cislău',5131,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (975,3,'COMMUNE',FALSE,'BZ','Cochirleanca',5789,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (976,3,'COMMUNE',FALSE,'BZ','Colţi',1249,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (977,3,'COMMUNE',FALSE,'BZ','Costeşti',4698,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (978,3,'COMMUNE',FALSE,'BZ','Cozieni',2247,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (979,3,'COMMUNE',FALSE,'BZ','Florica',1619,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (980,3,'COMMUNE',FALSE,'BZ','Gălbinaşi',4106,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (981,3,'COMMUNE',FALSE,'BZ','Gherăseni',3663,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (982,3,'COMMUNE',FALSE,'BZ','Ghergheasa',2521,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (983,3,'COMMUNE',FALSE,'BZ','Glodeanu Sărat',4412,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (984,3,'COMMUNE',FALSE,'BZ','Glodeanu-Siliştea',4161,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (985,3,'COMMUNE',FALSE,'BZ','Grebănu',5484,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (986,3,'COMMUNE',FALSE,'BZ','Gura Teghii',3687,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (987,3,'COMMUNE',FALSE,'BZ','Largu',1719,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (988,3,'COMMUNE',FALSE,'BZ','Lopătari',4227,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (989,3,'COMMUNE',FALSE,'BZ','Luciu',2951,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (990,3,'COMMUNE',FALSE,'BZ','Măgura',2226,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (991,3,'COMMUNE',FALSE,'BZ','Mărăcineni',7901,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (992,3,'COMMUNE',FALSE,'BZ','Mărgăriteşti',790,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (993,3,'COMMUNE',FALSE,'BZ','Mânzăleşti',2911,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (994,3,'COMMUNE',FALSE,'BZ','Merei',6986,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (995,3,'COMMUNE',FALSE,'BZ','Mihăileşti',2102,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (996,3,'COMMUNE',FALSE,'BZ','Movila Banului',2677,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (997,3,'COMMUNE',FALSE,'BZ','Murgeşti',1096,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (998,3,'COMMUNE',FALSE,'BZ','Năeni',1891,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (999,3,'COMMUNE',FALSE,'BZ','Odăile',1005,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1000,3,'COMMUNE',FALSE,'BZ','Padina',4533,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1001,3,'COMMUNE',FALSE,'BZ','Pardoşi',515	,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1002,3,'COMMUNE',FALSE,'BZ','Pănătău',2754,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1003,3,'COMMUNE',FALSE,'BZ','Pârscov',6098,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1004,3,'COMMUNE',FALSE,'BZ','Pietroasele',3458,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1005,3,'COMMUNE',FALSE,'BZ','Podgoria',3269,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1006,3,'COMMUNE',FALSE,'BZ','Poşta Câlnău',5918,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1007,3,'COMMUNE',FALSE,'BZ','Puieşti',4390,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1008,3,'COMMUNE',FALSE,'BZ','Racoviţeni',1434,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1009,3,'COMMUNE',FALSE,'BZ','Râmnicelu',4363,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1010,3,'COMMUNE',FALSE,'BZ','Robeasca',1209,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1011,3,'COMMUNE',FALSE,'BZ','Ruşeţu',4080,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1012,3,'COMMUNE',FALSE,'BZ','Săgeata',5203,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1013,3,'COMMUNE',FALSE,'BZ','Săhăteni',3408,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1014,3,'COMMUNE',FALSE,'BZ','Săpoca',3219,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1015,3,'COMMUNE',FALSE,'BZ','Săruleşti',1448,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1016,3,'COMMUNE',FALSE,'BZ','Scorţoasa',3175,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1017,3,'COMMUNE',FALSE,'BZ','Scutelnici',2478,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1018,3,'COMMUNE',FALSE,'BZ','Siriu',3153,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1019,3,'COMMUNE',FALSE,'BZ','Smeeni',6893,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1020,3,'COMMUNE',FALSE,'BZ','Stâlpu',3092,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1021,3,'COMMUNE',FALSE,'BZ','Tisău',4976,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1022,3,'COMMUNE',FALSE,'BZ','Topliceni',4439,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1023,3,'COMMUNE',FALSE,'BZ','Ţinteşti',4553,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1024,3,'COMMUNE',FALSE,'BZ','Ulmeni',3209,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1025,3,'COMMUNE',FALSE,'BZ','Unguriu',2436,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1026,3,'COMMUNE',FALSE,'BZ','Vadu Paşii',9472,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1027,3,'COMMUNE',FALSE,'BZ','Valea Râmnicului',5912,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1028,3,'COMMUNE',FALSE,'BZ','Valea Salciei',845,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1029,3,'COMMUNE',FALSE,'BZ','Vâlcelele',1627,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1030,3,'COMMUNE',FALSE,'BZ','Verneşti',8880,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1031,3,'COMMUNE',FALSE,'BZ','Vintilă Vodă',3233,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1032,3,'COMMUNE',FALSE,'BZ','Vipereşti',3706,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1033,3,'COMMUNE',FALSE,'BZ','Zărneşti',5309,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1034,3,'COMMUNE',FALSE,'BZ','Ziduri',4730,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1035,3,'COMMUNE',FALSE,'CS','Armeniş',2514,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1036,3,'COMMUNE',FALSE,'CS','Bănia',2046,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1037,3,'COMMUNE',FALSE,'CS','Băuţar',2713,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1038,3,'COMMUNE',FALSE,'CS','Berlişte',1178,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1039,3,'COMMUNE',FALSE,'CS','Berzasca',3022,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1040,3,'COMMUNE',FALSE,'CS','Berzovia',4037,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1041,3,'COMMUNE',FALSE,'CS','Bolvaşniţa',1490,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1042,3,'COMMUNE',FALSE,'CS','Bozovici',3423,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1043,3,'COMMUNE',FALSE,'CS','Brebu',1049,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1044,3,'COMMUNE',FALSE,'CS','Brebu Nou',96,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1045,3,'COMMUNE',FALSE,'CS','Buchin',2138,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1046,3,'COMMUNE',FALSE,'CS','Bucoşniţa',3026,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1047,3,'COMMUNE',FALSE,'CS','Caraşova',3169,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1048,3,'COMMUNE',FALSE,'CS','Cărbunari',1141,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1049,3,'COMMUNE',FALSE,'CS','Ciclova Română',1600,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1050,3,'COMMUNE',FALSE,'CS','Ciuchici',1057,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1051,3,'COMMUNE',FALSE,'CS','Ciudanoviţa',675,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1052,3,'COMMUNE',FALSE,'CS','Constantin Daicoviciuv',2955,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1053,3,'COMMUNE',FALSE,'CS','Copăcele',1184,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1054,3,'COMMUNE',FALSE,'CS','Cornea',2019,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1055,3,'COMMUNE',FALSE,'CS','Cornereva',3137,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1056,3,'COMMUNE',FALSE,'CS','Coronini',1922,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1057,3,'COMMUNE',FALSE,'CS','Dalboşeţ',1772,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1058,3,'COMMUNE',FALSE,'CS','Doclin',2043,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1059,3,'COMMUNE',FALSE,'CS','Dognecea',2013,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1060,3,'COMMUNE',FALSE,'CS','Domaşnea',1399,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1061,3,'COMMUNE',FALSE,'CS','Eftimie Murgu',1719,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1062,3,'COMMUNE',FALSE,'CS','Ezeriş',1347,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1063,3,'COMMUNE',FALSE,'CS','Fârliug',1886,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1064,3,'COMMUNE',FALSE,'CS','Forotic',1827,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1065,3,'COMMUNE',FALSE,'CS','Gârnic',1425,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1066,3,'COMMUNE',FALSE,'CS','Glimboca',1866,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1067,3,'COMMUNE',FALSE,'CS','Goruia',901	,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1068,3,'COMMUNE',FALSE,'CS','Grădinari',2161,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1069,3,'COMMUNE',FALSE,'CS','Iablaniţa',2416,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1070,3,'COMMUNE',FALSE,'CS','Lăpuşnicel',1300,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1071,3,'COMMUNE',FALSE,'CS','Lăpuşnicu Mare',1844,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1072,3,'COMMUNE',FALSE,'CS','Luncaviţa',2810,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1073,3,'COMMUNE',FALSE,'CS','Lupac',2975,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1074,3,'COMMUNE',FALSE,'CS','Marga',1254,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1075,3,'COMMUNE',FALSE,'CS','Măureni',2677,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1076,3,'COMMUNE',FALSE,'CS','Mehadia',4220,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1077,3,'COMMUNE',FALSE,'CS','Mehadica',774	,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1078,3,'COMMUNE',FALSE,'CS','Naidăş',1178,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1079,3,'COMMUNE',FALSE,'CS','Obreja',3454,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1080,3,'COMMUNE',FALSE,'CS','Ocna de Fier',748	,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1081,3,'COMMUNE',FALSE,'CS','Păltiniş',2561,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1082,3,'COMMUNE',FALSE,'CS','Pojejena',3172,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1083,3,'COMMUNE',FALSE,'CS','Prigor',2746,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1084,3,'COMMUNE',FALSE,'CS','Răcăşdia',2053,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1085,3,'COMMUNE',FALSE,'CS','Ramna',1630,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1086,3,'COMMUNE',FALSE,'CS','Rusca Montană',2116,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1087,3,'COMMUNE',FALSE,'CS','Sacu',1608,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1088,3,'COMMUNE',FALSE,'CS','Sasca Montană',1646,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1089,3,'COMMUNE',FALSE,'CS','Sicheviţa',2602,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1090,3,'COMMUNE',FALSE,'CS','Slatina-Timiş',3105,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1091,3,'COMMUNE',FALSE,'CS','Socol',2043,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1092,3,'COMMUNE',FALSE,'CS','Şopotu Nou',1324,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1093,3,'COMMUNE',FALSE,'CS','Târnova',1821,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1094,3,'COMMUNE',FALSE,'CS','Teregova',4238,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1095,3,'COMMUNE',FALSE,'CS','Ticvaniu Mare',2002,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1096,3,'COMMUNE',FALSE,'CS','Topleţ',2675,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1097,3,'COMMUNE',FALSE,'CS','Turnu Ruieni',3581,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1098,3,'COMMUNE',FALSE,'CS','Văliug',970	,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1099,3,'COMMUNE',FALSE,'CS','Vărădia',1618,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1100,3,'COMMUNE',FALSE,'CS','Vermeş',1728,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1101,3,'COMMUNE',FALSE,'CS','Vrani',1171,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1102,3,'COMMUNE',FALSE,'CS','Zăvoi',3948,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1103,3,'COMMUNE',FALSE,'CS','Zorlenţu Mare',927,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1104,3,'COMMUNE',FALSE,'CL','Alexandru Odobescu',2699,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1105,3,'COMMUNE',FALSE,'CL','Belciugatele',2366,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1106,3,'COMMUNE',FALSE,'CL','Borcea',7321,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1107,3,'COMMUNE',FALSE,'CL','Căscioarele',1878,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1108,3,'COMMUNE',FALSE,'CL','Chirnogi',7148,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1109,3,'COMMUNE',FALSE,'CL','Chiselet',3245,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1110,3,'COMMUNE',FALSE,'CL','Ciocăneşti',4105,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1111,3,'COMMUNE',FALSE,'CL','Crivăţ',2161,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1112,3,'COMMUNE',FALSE,'CL','Curcani',5093,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1113,3,'COMMUNE',FALSE,'CL','Cuza Vodă',3836,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1114,3,'COMMUNE',FALSE,'CL','Dichiseni',1691,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1115,3,'COMMUNE',FALSE,'CL','Dor Mărunt',6349,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1116,3,'COMMUNE',FALSE,'CL','Dorobanţu',2982,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1117,3,'COMMUNE',FALSE,'CL','Dragalina',8131,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1118,3,'COMMUNE',FALSE,'CL','Dragoş Vodă',2724,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1119,3,'COMMUNE',FALSE,'CL','Frăsinet',1747,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1120,3,'COMMUNE',FALSE,'CL','Frumuşani',5449,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1121,3,'COMMUNE',FALSE,'CL','Fundeni',5378,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1122,3,'COMMUNE',FALSE,'CL','Gălbinaşi',3487,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1123,3,'COMMUNE',FALSE,'CL','Grădiştea',4697,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1124,3,'COMMUNE',FALSE,'CL','Gurbăneşti',1267,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1125,3,'COMMUNE',FALSE,'CL','Ileana',3541,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1126,3,'COMMUNE',FALSE,'CL','Independenţa',3282,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1127,3,'COMMUNE',FALSE,'CL','Jegălia',4075,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1128,3,'COMMUNE',FALSE,'CL','Lehliu',2632,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1129,3,'COMMUNE',FALSE,'CL','Luica',2145,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1130,3,'COMMUNE',FALSE,'CL','Lupşanu',3371,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1131,3,'COMMUNE',FALSE,'CL','Mânăstirea',5404,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1132,3,'COMMUNE',FALSE,'CL','Mitreni',4187,null); 									
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1133,3,'COMMUNE',FALSE,'CL','Modelu',9098,null); 				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1134,3,'COMMUNE',FALSE,'CL','Nana',2493,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1135,3,'COMMUNE',FALSE,'CL','Nicolae Bălcescu',1695,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1136,3,'COMMUNE',FALSE,'CL','Perişoru',4902,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1137,3,'COMMUNE',FALSE,'CL','Plătăreşti',3907,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1138,3,'COMMUNE',FALSE,'CL','Radovanu',4185,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1139,3,'COMMUNE',FALSE,'CL','Roseţi',5805,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1140,3,'COMMUNE',FALSE,'CL','Săruleşti',3131,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1141,3,'COMMUNE',FALSE,'CL','Sohatu',3064,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1142,3,'COMMUNE',FALSE,'CL','Spanţov',4412,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1143,3,'COMMUNE',FALSE,'CL','Şoldanu',3373,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1144,3,'COMMUNE',FALSE,'CL','Ştefan cel Mare',3176,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1145,3,'COMMUNE',FALSE,'CL','Ştefan Vodă',2166,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1146,3,'COMMUNE',FALSE,'CL','Tămădău Mare',2536,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1147,3,'COMMUNE',FALSE,'CL','Ulmeni',4793,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1148,3,'COMMUNE',FALSE,'CL','Ulmu',1501,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1149,3,'COMMUNE',FALSE,'CL','Unirea',2513,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1150,3,'COMMUNE',FALSE,'CL','Valea Argovei',2448,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1151,3,'COMMUNE',FALSE,'CL','Vasilaţi',4054,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1152,3,'COMMUNE',FALSE,'CL','Vâlcelele',1808,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1153,3,'COMMUNE',FALSE,'CL','Vlad Ţepeş',2185,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1154,3,'COMMUNE',FALSE,'CJ','Aghireşu',7190,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1155,3,'COMMUNE',FALSE,'CJ','Aiton',1214,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1156,3,'COMMUNE',FALSE,'CJ','Aluniş',1296,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1157,3,'COMMUNE',FALSE,'CJ','Apahida',9827,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1158,3,'COMMUNE',FALSE,'CJ','Aşchileu',1732,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1159,3,'COMMUNE',FALSE,'CJ','Baciu',8743,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1160,3,'COMMUNE',FALSE,'CJ','Băişoara',2315,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1161,3,'COMMUNE',FALSE,'CJ','Beliş',1330,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1162,3,'COMMUNE',FALSE,'CJ','Bobâlna',1693,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1163,3,'COMMUNE',FALSE,'CJ','Bonţida',5093,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1164,3,'COMMUNE',FALSE,'CJ','Borşa',1539,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1165,3,'COMMUNE',FALSE,'CJ','Buza',1336,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1166,3,'COMMUNE',FALSE,'CJ','Căianu',2461,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1167,3,'COMMUNE',FALSE,'CJ','Călăraşi',2549,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1168,3,'COMMUNE',FALSE,'CJ','Călăţele',2546,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1169,3,'COMMUNE',FALSE,'CJ','Cămăraşu',2811,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1170,3,'COMMUNE',FALSE,'CJ','Căpuşu Mare',3450,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1171,3,'COMMUNE',FALSE,'CJ','Căşeiu',4976,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1172,3,'COMMUNE',FALSE,'CJ','Cătina',2045,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1173,3,'COMMUNE',FALSE,'CJ','Câţcău',2477,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1174,3,'COMMUNE',FALSE,'CJ','Ceanu Mare',4152,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1175,3,'COMMUNE',FALSE,'CJ','Chinteni',2784,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1176,3,'COMMUNE',FALSE,'CJ','Chiuieşti',2655,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1177,3,'COMMUNE',FALSE,'CJ','Ciucea',1692,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1178,3,'COMMUNE',FALSE,'CJ','Ciurila',1546,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1179,3,'COMMUNE',FALSE,'CJ','Cojocna',4438,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1180,3,'COMMUNE',FALSE,'CJ','Corneşti',1658,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1181,3,'COMMUNE',FALSE,'CJ','Cuzdrioara',3043,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1182,3,'COMMUNE',FALSE,'CJ','Dăbâca',1668,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1183,3,'COMMUNE',FALSE,'CJ','Feleacu',3639,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1184,3,'COMMUNE',FALSE,'CJ','Fizeşu Gherlii',2631,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1185,3,'COMMUNE',FALSE,'CJ','Floreşti',10595,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1186,3,'COMMUNE',FALSE,'CJ','Frata',4228,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1187,3,'COMMUNE',FALSE,'CJ','Gârbău',2619,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1188,3,'COMMUNE',FALSE,'CJ','Geaca',1685,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1189,3,'COMMUNE',FALSE,'CJ','Gilău',8384,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1190,3,'COMMUNE',FALSE,'CJ','Iara',4481,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1191,3,'COMMUNE',FALSE,'CJ','Iclod',4441,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1192,3,'COMMUNE',FALSE,'CJ','Izvoru Crişului',1615,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1193,3,'COMMUNE',FALSE,'CJ','Jichişu de Jos',1248,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1194,3,'COMMUNE',FALSE,'CJ','Jucu',4168,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1195,3,'COMMUNE',FALSE,'CJ','Luna',4760,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1196,3,'COMMUNE',FALSE,'CJ','Măguri-Răcătău',2300,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1197,3,'COMMUNE',FALSE,'CJ','Mănăstireni',1666,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1198,3,'COMMUNE',FALSE,'CJ','Mărgău',1631,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1199,3,'COMMUNE',FALSE,'CJ','Mărişel',1503,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1200,3,'COMMUNE',FALSE,'CJ','Mica',3877,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1201,3,'COMMUNE',FALSE,'CJ','Mihai Viteazu',5817,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1202,3,'COMMUNE',FALSE,'CJ','Mintiu Gherlii',3963,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1203,3,'COMMUNE',FALSE,'CJ','Mociu',3544,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1204,3,'COMMUNE',FALSE,'CJ','Moldoveneşti',3541,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1205,3,'COMMUNE',FALSE,'CJ','Negreni',2550,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1206,3,'COMMUNE',FALSE,'CJ','Pălatca',1216,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1207,3,'COMMUNE',FALSE,'CJ','Panticeu',1876,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1208,3,'COMMUNE',FALSE,'CJ','Petreştii de Jos',1710,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1209,3,'COMMUNE',FALSE,'CJ','Ploscoş',695,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1210,3,'COMMUNE',FALSE,'CJ','Poieni',5419,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1211,3,'COMMUNE',FALSE,'CJ','Râşca',1616,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1212,3,'COMMUNE',FALSE,'CJ','Recea-Cristur',1594,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1213,3,'COMMUNE',FALSE,'CJ','Săcuieu',1521,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1214,3,'COMMUNE',FALSE,'CJ','Sănduleşti',1952,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1215,3,'COMMUNE',FALSE,'CJ','Săvădisla',4396,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1216,3,'COMMUNE',FALSE,'CJ','Sâncraiu',1695,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1217,3,'COMMUNE',FALSE,'CJ','Sânmărtin',1581,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1218,3,'COMMUNE',FALSE,'CJ','Sânpaul',2548,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1219,3,'COMMUNE',FALSE,'CJ','Sic',2539,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1220,3,'COMMUNE',FALSE,'CJ','Suatu',1832,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1221,3,'COMMUNE',FALSE,'CJ','Tritenii de Jos',4885,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1222,3,'COMMUNE',FALSE,'CJ','Tureni',2500,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1223,3,'COMMUNE',FALSE,'CJ','Ţaga',2059,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1224,3,'COMMUNE',FALSE,'CJ','Unguraş',2931,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1225,3,'COMMUNE',FALSE,'CJ','Vad',2044,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1226,3,'COMMUNE',FALSE,'CJ','Valea Ierii',929,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1227,3,'COMMUNE',FALSE,'CJ','Viişoara',5986,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1228,3,'COMMUNE',FALSE,'CJ','Vultureni',1447,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1229,3,'COMMUNE',FALSE,'CT','23 August',5327,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1230,3,'COMMUNE',FALSE,'CT','Adamclisi',2290,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1231,3,'COMMUNE',FALSE,'CT','Agigea',6291,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1232,3,'COMMUNE',FALSE,'CT','Albeşti',3369,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1233,3,'COMMUNE',FALSE,'CT','Aliman',2961,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1234,3,'COMMUNE',FALSE,'CT','Amzacea',2631,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1235,3,'COMMUNE',FALSE,'CT','Bărăganu',1949,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1236,3,'COMMUNE',FALSE,'CT','Castelu',7892,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1237,3,'COMMUNE',FALSE,'CT','Cerchezu',1532,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1238,3,'COMMUNE',FALSE,'CT','Chirnogeni',3439,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1239,3,'COMMUNE',FALSE,'CT','Ciobanu',3479,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1240,3,'COMMUNE',FALSE,'CT','Ciocârlia',2953,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1241,3,'COMMUNE',FALSE,'CT','Cobadin',8893,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1242,3,'COMMUNE',FALSE,'CT','Cogealac',5533,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1243,3,'COMMUNE',FALSE,'CT','Comana',1844,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1244,3,'COMMUNE',FALSE,'CT','Corbu',5781,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1245,3,'COMMUNE',FALSE,'CT','Crucea',3258,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1246,3,'COMMUNE',FALSE,'CT','Cumpăna',10588,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1247,3,'COMMUNE',FALSE,'CT','Cuza Vodă',3486,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1248,3,'COMMUNE',FALSE,'CT','Deleni',2428,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1249,3,'COMMUNE',FALSE,'CT','Dobromir',2933,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1250,3,'COMMUNE',FALSE,'CT','Dumbrăveni',594,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1251,3,'COMMUNE',FALSE,'CT','Fântânele',1696,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1252,3,'COMMUNE',FALSE,'CT','Gârliciu',1813,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1253,3,'COMMUNE',FALSE,'CT','Ghindăreşti',2747,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1254,3,'COMMUNE',FALSE,'CT','Grădina',1173,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1255,3,'COMMUNE',FALSE,'CT','Horia',1601,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1256,3,'COMMUNE',FALSE,'CT','Independenţa',3112,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1257,3,'COMMUNE',FALSE,'CT','Ion Corvin',2112,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1258,3,'COMMUNE',FALSE,'CT','Istria',2641,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1259,3,'COMMUNE',FALSE,'CT','Limanu',5274,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1260,3,'COMMUNE',FALSE,'CT','Lipniţa',3365,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1261,3,'COMMUNE',FALSE,'CT','Lumina',8701,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1262,3,'COMMUNE',FALSE,'CT','Mereni',2302,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1263,3,'COMMUNE',FALSE,'CT','Mihai Viteazu',3466,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1264,3,'COMMUNE',FALSE,'CT','Mihail Kogălniceanu',10109,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1265,3,'COMMUNE',FALSE,'CT','Mircea Vodă',4829,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1266,3,'COMMUNE',FALSE,'CT','Nicolae Bălcescu',5046,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1267,3,'COMMUNE',FALSE,'CT','Oltina',2950,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1268,3,'COMMUNE',FALSE,'CT','Ostrov',5537,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1269,3,'COMMUNE',FALSE,'CT','Pantelimon',1884,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1270,3,'COMMUNE',FALSE,'CT','Pecineaga',3184,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1271,3,'COMMUNE',FALSE,'CT','Peştera',3436,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1272,3,'COMMUNE',FALSE,'CT','Poarta Albă',4756,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1273,3,'COMMUNE',FALSE,'CT','Rasova',3910,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1274,3,'COMMUNE',FALSE,'CT','Săcele',2195,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1275,3,'COMMUNE',FALSE,'CT','Saligny',2415,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1276,3,'COMMUNE',FALSE,'CT','Saraiu',1394,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1277,3,'COMMUNE',FALSE,'CT','Seimeni',2115,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1278,3,'COMMUNE',FALSE,'CT','Siliştea',1422,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1279,3,'COMMUNE',FALSE,'CT','Târguşor',1683,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1280,3,'COMMUNE',FALSE,'CT','Topalu',1831,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1281,3,'COMMUNE',FALSE,'CT','Topraisar',5524,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1282,3,'COMMUNE',FALSE,'CT','Tortoman',1756,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1283,3,'COMMUNE',FALSE,'CT','Tuzla',6571,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1284,3,'COMMUNE',FALSE,'CT','Valu lui Traian',10139,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1285,3,'COMMUNE',FALSE,'CT','Vulturu',746,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1286,3,'COMMUNE',FALSE,'CV','Aita Mare',1750,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1287,3,'COMMUNE',FALSE,'CV','Arcuş',1316,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1288,3,'COMMUNE',FALSE,'CV','Barcani',3987,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1289,3,'COMMUNE',FALSE,'CV','Băţani',4604,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1290,3,'COMMUNE',FALSE,'CV','Belin',2723,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1291,3,'COMMUNE',FALSE,'CV','Bixad',1929,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1292,3,'COMMUNE',FALSE,'CV','Bodoc',2439,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1293,3,'COMMUNE',FALSE,'CV','Boroşneu Mare',3274,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1294,3,'COMMUNE',FALSE,'CV','Brăduţ',4801,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1295,3,'COMMUNE',FALSE,'CV','Brateş',1524,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1296,3,'COMMUNE',FALSE,'CV','Breţcu',3865,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1297,3,'COMMUNE',FALSE,'CV','Catalina',3523,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1298,3,'COMMUNE',FALSE,'CV','Cernat',4000,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1299,3,'COMMUNE',FALSE,'CV','Chichiş',1615,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1300,3,'COMMUNE',FALSE,'CV','Comandău',1035,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1301,3,'COMMUNE',FALSE,'CV','Dalnic',952,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1302,3,'COMMUNE',FALSE,'CV','Dobârlău',2243,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1303,3,'COMMUNE',FALSE,'CV','Estelnic',1162,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1304,3,'COMMUNE',FALSE,'CV','Ghelinţa',4857,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1305,3,'COMMUNE',FALSE,'CV','Ghidfalău',2665,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1306,3,'COMMUNE',FALSE,'CV','Hăghig',2211,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1307,3,'COMMUNE',FALSE,'CV','Ilieni',1977,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1308,3,'COMMUNE',FALSE,'CV','Lemnia',1989,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1309,3,'COMMUNE',FALSE,'CV','Malnaş',1143,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1310,3,'COMMUNE',FALSE,'CV','Mereni',1330,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1311,3,'COMMUNE',FALSE,'CV','Micfalău',1891,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1312,3,'COMMUNE',FALSE,'CV','Moacşa',1219,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1313,3,'COMMUNE',FALSE,'CV','Ojdula',3526,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1314,3,'COMMUNE',FALSE,'CV','Ozun',4599,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1315,3,'COMMUNE',FALSE,'CV','Poian',1850,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1316,3,'COMMUNE',FALSE,'CV','Reci',2239,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1317,3,'COMMUNE',FALSE,'CV','Sânzieni',4650,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1318,3,'COMMUNE',FALSE,'CV','Sita Buzăului',4827,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1319,3,'COMMUNE',FALSE,'CV','Turia',3799,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1320,3,'COMMUNE',FALSE,'CV','Vâlcele',4084,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1321,3,'COMMUNE',FALSE,'CV','Valea Crişului',2324,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1322,3,'COMMUNE',FALSE,'CV','Valea Mare',1159,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1323,3,'COMMUNE',FALSE,'CV','Vârghiş',1851,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1324,3,'COMMUNE',FALSE,'CV','Zăbala',4941,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1325,3,'COMMUNE',FALSE,'CV','Zagon',5524,null);				                                                                                             
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1326,3,'COMMUNE',FALSE,'DB','Aninoasa',6192,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1327,3,'COMMUNE',FALSE,'DB','Băleni',8121,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1328,3,'COMMUNE',FALSE,'DB','Bărbuleţu',2326,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1329,3,'COMMUNE',FALSE,'DB','Bezdead',4555,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1330,3,'COMMUNE',FALSE,'DB','Bilciureşti',1845,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1331,3,'COMMUNE',FALSE,'DB','Braniştea',4265,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1332,3,'COMMUNE',FALSE,'DB','Brăneşti',4013,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1333,3,'COMMUNE',FALSE,'DB','Brezoaele',3967,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1334,3,'COMMUNE',FALSE,'DB','Buciumeni',4512,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1335,3,'COMMUNE',FALSE,'DB','Bucşani',6738,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1336,3,'COMMUNE',FALSE,'DB','Butimanu',2372,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1337,3,'COMMUNE',FALSE,'DB','Cândeşti',2857,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1338,3,'COMMUNE',FALSE,'DB','Ciocăneşti',5312,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1339,3,'COMMUNE',FALSE,'DB','Cobia',3139,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1340,3,'COMMUNE',FALSE,'DB','Cojasca',7574,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1341,3,'COMMUNE',FALSE,'DB','Comişani',5323,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1342,3,'COMMUNE',FALSE,'DB','Conţeşti',5042,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1343,3,'COMMUNE',FALSE,'DB','Corbii Mari',8085,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1344,3,'COMMUNE',FALSE,'DB','Cornăţelu',1636,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1345,3,'COMMUNE',FALSE,'DB','Corneşti',7040,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1346,3,'COMMUNE',FALSE,'DB','Costeştii din Vale',3393,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1347,3,'COMMUNE',FALSE,'DB','Crângurile',3274,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1348,3,'COMMUNE',FALSE,'DB','Crevedia',7552,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1349,3,'COMMUNE',FALSE,'DB','Dărmăneşti',4750,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1350,3,'COMMUNE',FALSE,'DB','Dobra',3612,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1351,3,'COMMUNE',FALSE,'DB','Doiceşti',4510,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1352,3,'COMMUNE',FALSE,'DB','Dragodana',6623,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1353,3,'COMMUNE',FALSE,'DB','Dragomireşti',8690,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1354,3,'COMMUNE',FALSE,'DB','Finta',4160,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1355,3,'COMMUNE',FALSE,'DB','Glodeni',4150,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1356,3,'COMMUNE',FALSE,'DB','Gura Foii',2084,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1357,3,'COMMUNE',FALSE,'DB','Gura Ocniţei',7075,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1358,3,'COMMUNE',FALSE,'DB','Gura Şuţii',5308,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1359,3,'COMMUNE',FALSE,'DB','Hulubeşti',3030,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1360,3,'COMMUNE',FALSE,'DB','I. L. Caragiale',7495,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1361,3,'COMMUNE',FALSE,'DB','Iedera',4000,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1362,3,'COMMUNE',FALSE,'DB','Lucieni',3071,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1363,3,'COMMUNE',FALSE,'DB','Ludeşti',5011,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1364,3,'COMMUNE',FALSE,'DB','Lunguleţu',5437,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1365,3,'COMMUNE',FALSE,'DB','Malu cu Flori',2452,null);  					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1366,3,'COMMUNE',FALSE,'DB','Măneşti',5004,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1367,3,'COMMUNE',FALSE,'DB','Mătăsaru',5353,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1368,3,'COMMUNE',FALSE,'DB','Mogoşani',4373,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1369,3,'COMMUNE',FALSE,'DB','Moroeni',5066,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1370,3,'COMMUNE',FALSE,'DB','Morteni',3028,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1371,3,'COMMUNE',FALSE,'DB','Moţăieni',2030,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1372,3,'COMMUNE',FALSE,'DB','Niculeşti',4827,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1373,3,'COMMUNE',FALSE,'DB','Nucet',3927,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1374,3,'COMMUNE',FALSE,'DB','Ocniţa',4273,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1375,3,'COMMUNE',FALSE,'DB','Odobeşti',5090,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1376,3,'COMMUNE',FALSE,'DB','Petreşti',5708,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1377,3,'COMMUNE',FALSE,'DB','Perşinari',2702,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1378,3,'COMMUNE',FALSE,'DB','Pietrari',2498,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1379,3,'COMMUNE',FALSE,'DB','Pietroşiţa',3116,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1380,3,'COMMUNE',FALSE,'DB','Poiana',3660,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1381,3,'COMMUNE',FALSE,'DB','Potlogi',8496,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1382,3,'COMMUNE',FALSE,'DB','Produleşti',3344,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1383,3,'COMMUNE',FALSE,'DB','Pucheni',1843,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1384,3,'COMMUNE',FALSE,'DB','Raciu',3443,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1385,3,'COMMUNE',FALSE,'DB','Răscăeţi',2224,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1386,3,'COMMUNE',FALSE,'DB','Răzvad',8345,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1387,3,'COMMUNE',FALSE,'DB','Râu Alb',1532,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1388,3,'COMMUNE',FALSE,'DB','Runcu',4185,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1389,3,'COMMUNE',FALSE,'DB','Sălcioara',4006,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1390,3,'COMMUNE',FALSE,'DB','Slobozia Moară',2102,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1391,3,'COMMUNE',FALSE,'DB','Şelaru',3425,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1392,3,'COMMUNE',FALSE,'DB','Şotânga',7028,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1393,3,'COMMUNE',FALSE,'DB','Tărtăşeşti',5702,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1394,3,'COMMUNE',FALSE,'DB','Tătărani',5113,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1395,3,'COMMUNE',FALSE,'DB','Ulieşti',4313,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1396,3,'COMMUNE',FALSE,'DB','Ulmi',4226,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1397,3,'COMMUNE',FALSE,'DB','Valea Lungă',4745,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1398,3,'COMMUNE',FALSE,'DB','Valea Mare',2373,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1399,3,'COMMUNE',FALSE,'DB','Văcăreşti',5075,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1400,3,'COMMUNE',FALSE,'DB','Văleni-Dâmboviţa',2719,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1401,3,'COMMUNE',FALSE,'DB','Vârfuri',1815,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1402,3,'COMMUNE',FALSE,'DB','Vişina',4004,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1403,3,'COMMUNE',FALSE,'DB','Vişineşti',1965,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1404,3,'COMMUNE',FALSE,'DB','Vlădeni',2769 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1405,3,'COMMUNE',FALSE,'DB','Voineşti',6081,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1406,3,'COMMUNE',FALSE,'DB','Vulcana-Băi',3025,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1407,3,'COMMUNE',FALSE,'DB','Vulcana-Pandele',5013,null);					

INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1408,3,'COMMUNE',FALSE,'DJ','Afumaţi',2505,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1409,3,'COMMUNE',FALSE,'DJ','Almăj',1944,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1410,3,'COMMUNE',FALSE,'DJ','Amărăştii de Jos',5318,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1411,3,'COMMUNE',FALSE,'DJ','Amărăştii de Sus',1654,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1412,3,'COMMUNE',FALSE,'DJ','Apele Vii',2011,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1413,3,'COMMUNE',FALSE,'DJ','Argetoaia',4312,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1414,3,'COMMUNE',FALSE,'DJ','Bârca',3478,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1415,3,'COMMUNE',FALSE,'DJ','Bistreţ',4186,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1416,3,'COMMUNE',FALSE,'DJ','Botoşeşti-Paia',792,null); 					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1417,3,'COMMUNE',FALSE,'DJ','Brabova',1515,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1418,3,'COMMUNE',FALSE,'DJ','Brădeşti',4337,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1419,3,'COMMUNE',FALSE,'DJ','Braloştiţa',3609,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1420,3,'COMMUNE',FALSE,'DJ','Bratovoeşti',3221,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1421,3,'COMMUNE',FALSE,'DJ','Breasta',3577,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1422,3,'COMMUNE',FALSE,'DJ','Bucovăţ',4005,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1423,3,'COMMUNE',FALSE,'DJ','Bulzeşti',1564,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1424,3,'COMMUNE',FALSE,'DJ','Calopăr',3503,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1425,3,'COMMUNE',FALSE,'DJ','Caraula',2298,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1426,3,'COMMUNE',FALSE,'DJ','Carpen',2264,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1427,3,'COMMUNE',FALSE,'DJ','Castranova',3279,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1428,3,'COMMUNE',FALSE,'DJ','Catane',1741,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1429,3,'COMMUNE',FALSE,'DJ','Călăraşi',5845,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1430,3,'COMMUNE',FALSE,'DJ','Cârcea',3396,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1431,3,'COMMUNE',FALSE,'DJ','Cârna',1304,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1432,3,'COMMUNE',FALSE,'DJ','Celaru',5371,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1433,3,'COMMUNE',FALSE,'DJ','Cerăt',4046,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1434,3,'COMMUNE',FALSE,'DJ','Cernăteşti',1890,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1435,3,'COMMUNE',FALSE,'DJ','Cetate',5176,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1436,3,'COMMUNE',FALSE,'DJ','Cioroiaşi',1541,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1437,3,'COMMUNE',FALSE,'DJ','Ciupercenii Noi',5184,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1438,3,'COMMUNE',FALSE,'DJ','Coşoveni',3054,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1439,3,'COMMUNE',FALSE,'DJ','Coţofenii din Dos',2272,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1440,3,'COMMUNE',FALSE,'DJ','Coţofenii din Faţă',1803,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1441,3,'COMMUNE',FALSE,'DJ','Daneţi',6096,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1442,3,'COMMUNE',FALSE,'DJ','Desa',4582,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1443,3,'COMMUNE',FALSE,'DJ','Dioşti',3000,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1444,3,'COMMUNE',FALSE,'DJ','Dobreşti',2392,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1445,3,'COMMUNE',FALSE,'DJ','Dobroteşti',1717,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1446,3,'COMMUNE',FALSE,'DJ','Drăgoteşti',2109,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1447,3,'COMMUNE',FALSE,'DJ','Drănic',2630,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1448,3,'COMMUNE',FALSE,'DJ','Fărcaş',1878,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1449,3,'COMMUNE',FALSE,'DJ','Galicea Mare',4172,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1450,3,'COMMUNE',FALSE,'DJ','Galiciuica',1517,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1451,3,'COMMUNE',FALSE,'DJ','Gângiova',2284,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1452,3,'COMMUNE',FALSE,'DJ','Gherceşti',1645,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1453,3,'COMMUNE',FALSE,'DJ','Ghidici',2331,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1454,3,'COMMUNE',FALSE,'DJ','Ghindeni',1909,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1455,3,'COMMUNE',FALSE,'DJ','Gighera',3003,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1456,3,'COMMUNE',FALSE,'DJ','Giubega',2004,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1457,3,'COMMUNE',FALSE,'DJ','Giurgiţa',2768,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1458,3,'COMMUNE',FALSE,'DJ','Gogoşu',635,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1459,3,'COMMUNE',FALSE,'DJ','Goicea',2689,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1460,3,'COMMUNE',FALSE,'DJ','Goieşti',3030,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1461,3,'COMMUNE',FALSE,'DJ','Greceşti',1641,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1462,3,'COMMUNE',FALSE,'DJ','Işalniţa',3657,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1463,3,'COMMUNE',FALSE,'DJ','Izvoare',1573,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1464,3,'COMMUNE',FALSE,'DJ','Întorsura',1427,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1465,3,'COMMUNE',FALSE,'DJ','Leu',4831,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1466,3,'COMMUNE',FALSE,'DJ','Lipovu',3154,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1467,3,'COMMUNE',FALSE,'DJ','Măceşu de Jos',1294,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1468,3,'COMMUNE',FALSE,'DJ','Măceşu de Sus',1309,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1469,3,'COMMUNE',FALSE,'DJ','Maglavit',4631,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1470,3,'COMMUNE',FALSE,'DJ','Malu Mare',3578,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1471,3,'COMMUNE',FALSE,'DJ','Mârşani',4628,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1472,3,'COMMUNE',FALSE,'DJ','Melineşti',3758,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1473,3,'COMMUNE',FALSE,'DJ','Mischii',1696,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1474,3,'COMMUNE',FALSE,'DJ','Moţăţei',6758,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1475,3,'COMMUNE',FALSE,'DJ','Murgaşi',2409,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1476,3,'COMMUNE',FALSE,'DJ','Negoi',1853,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1477,3,'COMMUNE',FALSE,'DJ','Orodel',2637,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1478,3,'COMMUNE',FALSE,'DJ','Ostroveni',4767,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1479,3,'COMMUNE',FALSE,'DJ','Perişor',1668,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1480,3,'COMMUNE',FALSE,'DJ','Pieleşti',3513,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1481,3,'COMMUNE',FALSE,'DJ','Piscu Vechi',2383,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1482,3,'COMMUNE',FALSE,'DJ','Pleniţa',4467,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1483,3,'COMMUNE',FALSE,'DJ','Pleşoi',1337,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1484,3,'COMMUNE',FALSE,'DJ','Podari',6656,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1485,3,'COMMUNE',FALSE,'DJ','Poiana Mare',10381,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1486,3,'COMMUNE',FALSE,'DJ','Predeşti',1803,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1487,3,'COMMUNE',FALSE,'DJ','Radovan',1360,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1488,3,'COMMUNE',FALSE,'DJ','Rast',3232,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1489,3,'COMMUNE',FALSE,'DJ','Robăneşti',2307,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1490,3,'COMMUNE',FALSE,'DJ','Rojişte',2364,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1491,3,'COMMUNE',FALSE,'DJ','Sadova',6516,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1492,3,'COMMUNE',FALSE,'DJ','Sălcuţa',2231,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1493,3,'COMMUNE',FALSE,'DJ','Scăeşti',2023,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1494,3,'COMMUNE',FALSE,'DJ','Seaca de Câmp',1905,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1495,3,'COMMUNE',FALSE,'DJ','Seaca de Pădure',1012,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1496,3,'COMMUNE',FALSE,'DJ','Secu',1082,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1497,3,'COMMUNE',FALSE,'DJ','Siliştea Crucii',1563,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1498,3,'COMMUNE',FALSE,'DJ','Sopot',1765,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1499,3,'COMMUNE',FALSE,'DJ','Şimnicu de Sus',4424,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1500,3,'COMMUNE',FALSE,'DJ','Tălpaş',1236,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1501,3,'COMMUNE',FALSE,'DJ','Teasc',3187,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1502,3,'COMMUNE',FALSE,'DJ','Terpeziţa',1575,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1503,3,'COMMUNE',FALSE,'DJ','Teslui',2340,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1504,3,'COMMUNE',FALSE,'DJ','Ţuglui',2759,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1505,3,'COMMUNE',FALSE,'DJ','Unirea',3740,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1506,3,'COMMUNE',FALSE,'DJ','Urzicuţa',3085,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1507,3,'COMMUNE',FALSE,'DJ','Valea Stanciului',5360,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1508,3,'COMMUNE',FALSE,'DJ','Vârtop',1564,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1509,3,'COMMUNE',FALSE,'DJ','Vârvoru de Jos',2811,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1510,3,'COMMUNE',FALSE,'DJ','Vela',1821,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1511,3,'COMMUNE',FALSE,'DJ','Verbiţa',1314,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1512,3,'COMMUNE',FALSE,'GL','Bălăbăneşti',2042,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1513,3,'COMMUNE',FALSE,'GL','Bălăşeşti',2252,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1514,3,'COMMUNE',FALSE,'GL','Băleni',2244,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1515,3,'COMMUNE',FALSE,'GL','Băneasa',1762,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1516,3,'COMMUNE',FALSE,'GL','Barcea',4680,null);									
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1517,3,'COMMUNE',FALSE,'GL','Bereşti-Meria',3617,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1518,3,'COMMUNE',FALSE,'GL','Brăhăşeşti',7692,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1519,3,'COMMUNE',FALSE,'GL','Braniştea',3876,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1520,3,'COMMUNE',FALSE,'GL','Buciumeni',2274,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1521,3,'COMMUNE',FALSE,'GL','Cavadineşti',3077,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1522,3,'COMMUNE',FALSE,'GL','Cerţeşti',2163,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1523,3,'COMMUNE',FALSE,'GL','Corni',2048,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1524,3,'COMMUNE',FALSE,'GL','Corod',7197,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1525,3,'COMMUNE',FALSE,'GL','Cosmeşti',5013,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1526,3,'COMMUNE',FALSE,'GL','Costache Negri',2267,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1527,3,'COMMUNE',FALSE,'GL','Cuca',2087,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1528,3,'COMMUNE',FALSE,'GL','Cudalbi',6206,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1529,3,'COMMUNE',FALSE,'GL','Cuza Vodă',2586,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1530,3,'COMMUNE',FALSE,'GL','Drăgăneşti',4682,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1531,3,'COMMUNE',FALSE,'GL','Drăguşeni',4781,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1532,3,'COMMUNE',FALSE,'GL','Fârţăneşti',5169,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1533,3,'COMMUNE',FALSE,'GL','Folteşti',2976,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1534,3,'COMMUNE',FALSE,'GL','Frumuşiţa',4659,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1535,3,'COMMUNE',FALSE,'GL','Fundeni',3570,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1536,3,'COMMUNE',FALSE,'GL','Ghidigeni',5558,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1537,3,'COMMUNE',FALSE,'GL','Gohor',3135,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1538,3,'COMMUNE',FALSE,'GL','Griviţa',2899,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1539,3,'COMMUNE',FALSE,'GL','Independenţa',4274,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1540,3,'COMMUNE',FALSE,'GL','Iveşti',8091,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1541,3,'COMMUNE',FALSE,'GL','Jorăşti',1774,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1542,3,'COMMUNE',FALSE,'GL','Lieşti',8753,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1543,3,'COMMUNE',FALSE,'GL','Măstăcani',4535,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1544,3,'COMMUNE',FALSE,'GL','Matca',11450,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1545,3,'COMMUNE',FALSE,'GL','Movileni',3243,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1546,3,'COMMUNE',FALSE,'GL','Munteni',6520,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1547,3,'COMMUNE',FALSE,'GL','Nămoloasa',2163,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1548,3,'COMMUNE',FALSE,'GL','Negrileşti',2321,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1549,3,'COMMUNE',FALSE,'GL','Nicoreşti',3506,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1550,3,'COMMUNE',FALSE,'GL','Oancea',1433,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1551,3,'COMMUNE',FALSE,'GL','Pechea',9889,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1552,3,'COMMUNE',FALSE,'GL','Piscu',4706,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1553,3,'COMMUNE',FALSE,'GL','Poiana',1651,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1554,3,'COMMUNE',FALSE,'GL','Priponeşti',2163,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1555,3,'COMMUNE',FALSE,'GL','Rădeşti',1474,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1556,3,'COMMUNE',FALSE,'GL','Rediu',1850,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1557,3,'COMMUNE',FALSE,'GL','Scânteieşti',2428,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1558,3,'COMMUNE',FALSE,'GL','Schela',3649,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1559,3,'COMMUNE',FALSE,'GL','Şendreni',3455,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1560,3,'COMMUNE',FALSE,'GL','Slobozia Conachi',3978,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1561,3,'COMMUNE',FALSE,'GL','Smârdan',4608,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1562,3,'COMMUNE',FALSE,'GL','Smulţi',1321,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1563,3,'COMMUNE',FALSE,'GL','Suceveni',1809,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1564,3,'COMMUNE',FALSE,'GL','Ţepu',2395,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1565,3,'COMMUNE',FALSE,'GL','Tudor Vladimirescu',4780,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1566,3,'COMMUNE',FALSE,'GL','Tuluceşti',7093,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1567,3,'COMMUNE',FALSE,'GL','Umbrăreşti',6504,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1568,3,'COMMUNE',FALSE,'GL','Valea Mărului',3947,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1569,3,'COMMUNE',FALSE,'GL','Vânători',4760,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1570,3,'COMMUNE',FALSE,'GL','Vârlezi',1931,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1571,3,'COMMUNE',FALSE,'GL','Vlădeşti',1929,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1572,3,'COMMUNE',FALSE,'GR','Adunaţii-Copăceni',6247,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1573,3,'COMMUNE',FALSE,'GR','Băneasa',5000,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1574,3,'COMMUNE',FALSE,'GR','Bolintin-Deal',5707,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1575,3,'COMMUNE',FALSE,'GR','Bucşani',3821,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1576,3,'COMMUNE',FALSE,'GR','Bulbucata',1533,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1577,3,'COMMUNE',FALSE,'GR','Buturugeni',3904,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1578,3,'COMMUNE',FALSE,'GR','Călugăreni',5788,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1579,3,'COMMUNE',FALSE,'GR','Clejani',3629,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1580,3,'COMMUNE',FALSE,'GR','Colibaşi',3430,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1581,3,'COMMUNE',FALSE,'GR','Comana',7001,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1582,3,'COMMUNE',FALSE,'GR','Cosoba',2536,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1583,3,'COMMUNE',FALSE,'GR','Crevedia Mare',5127,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1584,3,'COMMUNE',FALSE,'GR','Daia',2726,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1585,3,'COMMUNE',FALSE,'GR','Floreşti-Stoeneşti',9028,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1586,3,'COMMUNE',FALSE,'GR','Frăteşti',5054,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1587,3,'COMMUNE',FALSE,'GR','Găiseni',5258,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1588,3,'COMMUNE',FALSE,'GR','Găujani',2430,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1589,3,'COMMUNE',FALSE,'GR','Ghimpaţi',5596,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1590,3,'COMMUNE',FALSE,'GR','Gogoşari',1905,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1591,3,'COMMUNE',FALSE,'GR','Gostinari',2567,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1592,3,'COMMUNE',FALSE,'GR','Gostinu',1964,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1593,3,'COMMUNE',FALSE,'GR','Grădinari',3501,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1594,3,'COMMUNE',FALSE,'GR','Greaca',2514,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1595,3,'COMMUNE',FALSE,'GR','Herăşti',2286,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1596,3,'COMMUNE',FALSE,'GR','Hotarele',3781,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1597,3,'COMMUNE',FALSE,'GR','Iepureşti',2140,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1598,3,'COMMUNE',FALSE,'GR','Izvoarele',1680,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1599,3,'COMMUNE',FALSE,'GR','Joiţa',3809,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1600,3,'COMMUNE',FALSE,'GR','Letca Nouă',3591,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1601,3,'COMMUNE',FALSE,'GR','Malu',2310,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1602,3,'COMMUNE',FALSE,'GR','Mârşa',2627,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1603,3,'COMMUNE',FALSE,'GR','Mihai Bravu',2476,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1604,3,'COMMUNE',FALSE,'GR','Ogrezeni',4751,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1605,3,'COMMUNE',FALSE,'GR','Oinacu',3238,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1606,3,'COMMUNE',FALSE,'GR','Prundu',4159,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1607,3,'COMMUNE',FALSE,'GR','Putineiu',2407,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1608,3,'COMMUNE',FALSE,'GR','Răsuceni',2473,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1609,3,'COMMUNE',FALSE,'GR','Roata de Jos',7839,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1610,3,'COMMUNE',FALSE,'GR','Săbăreni',2754,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1611,3,'COMMUNE',FALSE,'GR','Schitu',1889,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1612,3,'COMMUNE',FALSE,'GR','Singureni',3007,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1613,3,'COMMUNE',FALSE,'GR','Slobozia',2320,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1614,3,'COMMUNE',FALSE,'GR','Stăneşti',2885,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1615,3,'COMMUNE',FALSE,'GR','Stoeneşti',2189,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1616,3,'COMMUNE',FALSE,'GR','Toporu',2203,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1617,3,'COMMUNE',FALSE,'GR','Ulmi',7667,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1618,3,'COMMUNE',FALSE,'GR','Valea Dragului',3074,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1619,3,'COMMUNE',FALSE,'GR','Vărăşti',6074,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1620,3,'COMMUNE',FALSE,'GR','Vânătorii Mici',4850,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1621,3,'COMMUNE',FALSE,'GR','Vedea',2978,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1622,3,'COMMUNE',FALSE,'GJ','Albeni',2568,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1623,3,'COMMUNE',FALSE,'GJ','Alimpeşti',1857,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1624,3,'COMMUNE',FALSE,'GJ','Aninoasa',3897,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1625,3,'COMMUNE',FALSE,'GJ','Arcani',1321,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1626,3,'COMMUNE',FALSE,'GJ','Baia de Fier',3941,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1627,3,'COMMUNE',FALSE,'GJ','Bălăneşti',2102,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1628,3,'COMMUNE',FALSE,'GJ','Băleşti',7262,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1629,3,'COMMUNE',FALSE,'GJ','Bărbăteşti',1659 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1630,3,'COMMUNE',FALSE,'GJ','Bengeşti-Ciocadia',3083 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1631,3,'COMMUNE',FALSE,'GJ','Berleşti',2113 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1632,3,'COMMUNE',FALSE,'GJ','Bâlteni',6929 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1633,3,'COMMUNE',FALSE,'GJ','Bolboşi',2966 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1634,3,'COMMUNE',FALSE,'GJ','Borăscu',3480 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1635,3,'COMMUNE',FALSE,'GJ','Brăneşti',2430 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1636,3,'COMMUNE',FALSE,'GJ','Bumbeşti-Piţic',2093 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1637,3,'COMMUNE',FALSE,'GJ','Bustuchin',3366,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1638,3,'COMMUNE',FALSE,'GJ','Câlnic',2125 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1639,3,'COMMUNE',FALSE,'GJ','Căpreni',2153 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1640,3,'COMMUNE',FALSE,'GJ','Cătunele',2491 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1641,3,'COMMUNE',FALSE,'GJ','Ciuperceni',1604 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1642,3,'COMMUNE',FALSE,'GJ','Crasna',5178 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1643,3,'COMMUNE',FALSE,'GJ','Cruşeţ',3307 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1644,3,'COMMUNE',FALSE,'GJ','Dănciuleşti',2270 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1645,3,'COMMUNE',FALSE,'GJ','Dăneşti',3882 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1646,3,'COMMUNE',FALSE,'GJ','Drăgoteşti',2509 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1647,3,'COMMUNE',FALSE,'GJ','Drăguţeşti',4934 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1648,3,'COMMUNE',FALSE,'GJ','Fărcăşeşti',3273 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1649,3,'COMMUNE',FALSE,'GJ','Glogova',1881 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1650,3,'COMMUNE',FALSE,'GJ','Godineşti',2044 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1651,3,'COMMUNE',FALSE,'GJ','Hurezani',1688 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1652,3,'COMMUNE',FALSE,'GJ','Ioneşti',2228 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1653,3,'COMMUNE',FALSE,'GJ','Jupâneşti',2069 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1654,3,'COMMUNE',FALSE,'GJ','Leleşti',1870 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1655,3,'COMMUNE',FALSE,'GJ','Licurici',2252 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1656,3,'COMMUNE',FALSE,'GJ','Logreşti',2719 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1657,3,'COMMUNE',FALSE,'GJ','Mătăsari',5051,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1658,3,'COMMUNE',FALSE,'GJ','Muşeteşti',1985 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1659,3,'COMMUNE',FALSE,'GJ','Negomir',3524 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1660,3,'COMMUNE',FALSE,'GJ','Padeş',4780 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1661,3,'COMMUNE',FALSE,'GJ','Peştişani',3664 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1662,3,'COMMUNE',FALSE,'GJ','Plopşoru',6136 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1663,3,'COMMUNE',FALSE,'GJ','Polovragi',2830 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1664,3,'COMMUNE',FALSE,'GJ','Prigoria',3148 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1665,3,'COMMUNE',FALSE,'GJ','Roşia de Amaradia',3112,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1666,3,'COMMUNE',FALSE,'GJ','Runcu',5242,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1667,3,'COMMUNE',FALSE,'GJ','Săcelu',1535 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1668,3,'COMMUNE',FALSE,'GJ','Samarineşti',1731,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1669,3,'COMMUNE',FALSE,'GJ','Săuleşti',2086 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1670,3,'COMMUNE',FALSE,'GJ','Schela',1676 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1671,3,'COMMUNE',FALSE,'GJ','Scoarţa',4747 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1672,3,'COMMUNE',FALSE,'GJ','Slivileşti',3195 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1673,3,'COMMUNE',FALSE,'GJ','Stăneşti',2297,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1674,3,'COMMUNE',FALSE,'GJ','Stejari',2552 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1675,3,'COMMUNE',FALSE,'GJ','Stoina',2317 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1676,3,'COMMUNE',FALSE,'GJ','Ţânţăreni',5222 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1677,3,'COMMUNE',FALSE,'GJ','Teleşti',2392 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1678,3,'COMMUNE',FALSE,'GJ','Turburea',4039,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1679,3,'COMMUNE',FALSE,'GJ','Turcineşti',2213 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1680,3,'COMMUNE',FALSE,'GJ','Urdari',3012 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1681,3,'COMMUNE',FALSE,'GJ','Văgiuleşti',2660 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1682,3,'COMMUNE',FALSE,'GJ','Vladimir',2816 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1683,3,'COMMUNE',FALSE,'HR','Atid',2827,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1684,3,'COMMUNE',FALSE,'HR','Avrămeşti',2572,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1685,3,'COMMUNE',FALSE,'HR','Bilbor',2750,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1686,3,'COMMUNE',FALSE,'HR','Brădeşti',1626,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1687,3,'COMMUNE',FALSE,'HR','Căpâlniţa',2014,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1688,3,'COMMUNE',FALSE,'HR','Cârţa',2708,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1689,3,'COMMUNE',FALSE,'HR','Ciceu',2710,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1690,3,'COMMUNE',FALSE,'HR','Ciucsângeorgiu',4784,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1691,3,'COMMUNE',FALSE,'HR','Ciumani',4460,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1692,3,'COMMUNE',FALSE,'HR','Corbu',1571,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1693,3,'COMMUNE',FALSE,'HR','Corund',6266,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1694,3,'COMMUNE',FALSE,'HR','Cozmeni',2071,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1695,3,'COMMUNE',FALSE,'HR','Dăneşti',2425,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1696,3,'COMMUNE',FALSE,'HR','Dârjiu',1096,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1697,3,'COMMUNE',FALSE,'HR','Dealu',3920,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1698,3,'COMMUNE',FALSE,'HR','Ditrău',5806,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1699,3,'COMMUNE',FALSE,'HR','Feliceni',3216,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1700,3,'COMMUNE',FALSE,'HR','Frumoasa',3550,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1701,3,'COMMUNE',FALSE,'HR','Gălăuţaş',2729,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1702,3,'COMMUNE',FALSE,'HR','Joseni',5631,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1703,3,'COMMUNE',FALSE,'HR','Lăzarea',3556,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1704,3,'COMMUNE',FALSE,'HR','Leliceni',1814,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1705,3,'COMMUNE',FALSE,'HR','Lueta',3595,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1706,3,'COMMUNE',FALSE,'HR','Lunca de Jos',5309,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1707,3,'COMMUNE',FALSE,'HR','Lunca de Sus',3508,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1708,3,'COMMUNE',FALSE,'HR','Lupeni',4486,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1709,3,'COMMUNE',FALSE,'HR','Mădăraş',2192,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1710,3,'COMMUNE',FALSE,'HR','Mărtiniş',3132,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1711,3,'COMMUNE',FALSE,'HR','Mereşti',1340,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1712,3,'COMMUNE',FALSE,'HR','Mihăileni',2655,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1713,3,'COMMUNE',FALSE,'HR','Mugeni',3693,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1714,3,'COMMUNE',FALSE,'HR','Ocland',1286,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1715,3,'COMMUNE',FALSE,'HR','Păuleni-Ciuc',1767,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1716,3,'COMMUNE',FALSE,'HR','Plăieşii de Jos',2991,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1717,3,'COMMUNE',FALSE,'HR','Porumbenii Mari',1778,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1718,3,'COMMUNE',FALSE,'HR','Praid',6698,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1719,3,'COMMUNE',FALSE,'HR','Racu',1539,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1720,3,'COMMUNE',FALSE,'HR','Remetea',6261,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1721,3,'COMMUNE',FALSE,'HR','Săcel',1347,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1722,3,'COMMUNE',FALSE,'HR','Sâncrăieni',2609,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1723,3,'COMMUNE',FALSE,'HR','Sândominic',6478,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1724,3,'COMMUNE',FALSE,'HR','Sânmartin',2356,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1725,3,'COMMUNE',FALSE,'HR','Sânsimion',3528,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1726,3,'COMMUNE',FALSE,'HR','Sântimbru',2055,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1727,3,'COMMUNE',FALSE,'HR','Sărmaş',4120,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1728,3,'COMMUNE',FALSE,'HR','Satu Mare',1951,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1729,3,'COMMUNE',FALSE,'HR','Secuieni',2788,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1730,3,'COMMUNE',FALSE,'HR','Siculeni',2817,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1731,3,'COMMUNE',FALSE,'HR','Şimoneşti',3850,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1732,3,'COMMUNE',FALSE,'HR','Subcetate',2025,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1733,3,'COMMUNE',FALSE,'HR','Suseni',5116,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1734,3,'COMMUNE',FALSE,'HR','Tomeşti',2624,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1735,3,'COMMUNE',FALSE,'HR','Tulgheş',3315,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1736,3,'COMMUNE',FALSE,'HR','Tuşnad',2146,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1737,3,'COMMUNE',FALSE,'HR','Ulieş',1267,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1738,3,'COMMUNE',FALSE,'HR','Vărşag',1539,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1739,3,'COMMUNE',FALSE,'HR','Voşlăbeni',1978,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1740,3,'COMMUNE',FALSE,'HR','Zetea',5853,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1741,3,'COMMUNE',FALSE,'HD','Baia de Criş',2871,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1742,3,'COMMUNE',FALSE,'HD','Balşa',1022,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1743,3,'COMMUNE',FALSE,'HD','Băniţa',1304,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1744,3,'COMMUNE',FALSE,'HD','Baru',2926,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1745,3,'COMMUNE',FALSE,'HD','Băcia',1832,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1746,3,'COMMUNE',FALSE,'HD','Băiţa',3917,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1747,3,'COMMUNE',FALSE,'HD','Bătrâna',161,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1748,3,'COMMUNE',FALSE,'HD','Beriu',2926,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1749,3,'COMMUNE',FALSE,'HD','Blăjeni',1331,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1750,3,'COMMUNE',FALSE,'HD','Boşorod',2053,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1751,3,'COMMUNE',FALSE,'HD','Brănişca',1754,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1752,3,'COMMUNE',FALSE,'HD','Bretea Română',2929,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1753,3,'COMMUNE',FALSE,'HD','Buceş',2161,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1754,3,'COMMUNE',FALSE,'HD','Bucureşci',1748,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1755,3,'COMMUNE',FALSE,'HD','Bulzeştii de Sus',323,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1756,3,'COMMUNE',FALSE,'HD','Bunila',368,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1757,3,'COMMUNE',FALSE,'HD','Burjuc',916,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1758,3,'COMMUNE',FALSE,'HD','Cerbăl',557,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1759,3,'COMMUNE',FALSE,'HD','Certeju de Sus',3327,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1760,3,'COMMUNE',FALSE,'HD','Cârjiţi',699,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1761,3,'COMMUNE',FALSE,'HD','Crişcior',4189,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1762,3,'COMMUNE',FALSE,'HD','Densuş',1624,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1763,3,'COMMUNE',FALSE,'HD','Dobra',3406,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1764,3,'COMMUNE',FALSE,'HD','General Berthelot',987,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1765,3,'COMMUNE',FALSE,'HD','Ghelari',2218,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1766,3,'COMMUNE',FALSE,'HD','Gurasada',1622,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1767,3,'COMMUNE',FALSE,'HD','Hărău',2027,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1768,3,'COMMUNE',FALSE,'HD','Ilia',3789,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1769,3,'COMMUNE',FALSE,'HD','Lăpugiu de Jos',1609,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1770,3,'COMMUNE',FALSE,'HD','Leleşe',427,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1771,3,'COMMUNE',FALSE,'HD','Lunca Cernii de Jos',931,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1772,3,'COMMUNE',FALSE,'HD','Luncoiu de Jos',1956,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1773,3,'COMMUNE',FALSE,'HD','Mărtineşti',982,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1774,3,'COMMUNE',FALSE,'HD','Orăştioara de Sus',2322,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1775,3,'COMMUNE',FALSE,'HD','Pestişu Mic',1205,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1776,3,'COMMUNE',FALSE,'HD','Pui',4475,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1777,3,'COMMUNE',FALSE,'HD','Rapoltu Mare',1913,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1778,3,'COMMUNE',FALSE,'HD','Răchitova',1360,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1779,3,'COMMUNE',FALSE,'HD','Ribiţa',1504,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1780,3,'COMMUNE',FALSE,'HD','Râu de Mori',3264,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1781,3,'COMMUNE',FALSE,'HD','Romos',2855,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1782,3,'COMMUNE',FALSE,'HD','Sarmizegetusa',1324,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1783,3,'COMMUNE',FALSE,'HD','Sălaşu de Sus',2494,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1784,3,'COMMUNE',FALSE,'HD','Sântămăria-Orlea',3346,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1785,3,'COMMUNE',FALSE,'HD','Şoimuş',3334,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1786,3,'COMMUNE',FALSE,'HD','Teliucu Inferior',2479,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1787,3,'COMMUNE',FALSE,'HD','Tomeşti',1191,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1788,3,'COMMUNE',FALSE,'HD','Topliţa',806,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1789,3,'COMMUNE',FALSE,'HD','Toteşti',1932,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1790,3,'COMMUNE',FALSE,'HD','Turdaş',1952,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1791,3,'COMMUNE',FALSE,'HD','Vaţa de Jos',3965,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1792,3,'COMMUNE',FALSE,'HD','Vălişoara',1351,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1793,3,'COMMUNE',FALSE,'HD','Veţel',2529,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1794,3,'COMMUNE',FALSE,'HD','Vorţa',1002,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1795,3,'COMMUNE',FALSE,'HD','Zam',1787,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1796,3,'COMMUNE',FALSE,'IL','Adâncata',2700 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1797,3,'COMMUNE',FALSE,'IL','Albeşti',1273 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1798,3,'COMMUNE',FALSE,'IL','Alexeni',2362 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1799,3,'COMMUNE',FALSE,'IL','Andrăşeşti',2131,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1800,3,'COMMUNE',FALSE,'IL','Armăşeşti',2244 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1801,3,'COMMUNE',FALSE,'IL','Axintele',2559 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1802,3,'COMMUNE',FALSE,'IL','Balaciu',1797 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1803,3,'COMMUNE',FALSE,'IL','Bărcăneşti',3680 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1804,3,'COMMUNE',FALSE,'IL','Borăneşti',2385 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1805,3,'COMMUNE',FALSE,'IL','Borduşani',4471,null);									
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1806,3,'COMMUNE',FALSE,'IL','Bucu',2263 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1807,3,'COMMUNE',FALSE,'IL','Bueşti',1057 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1808,3,'COMMUNE',FALSE,'IL','Ciocârlia',764 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1809,3,'COMMUNE',FALSE,'IL','Ciochina',3106 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1810,3,'COMMUNE',FALSE,'IL','Ciulniţa',2326,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1811,3,'COMMUNE',FALSE,'IL','Cocora',1994 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1812,3,'COMMUNE',FALSE,'IL','Cosâmbeşti',1868 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1813,3,'COMMUNE',FALSE,'IL','Coşereni',4491 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1814,3,'COMMUNE',FALSE,'IL','Drăgoeşti',1067 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1815,3,'COMMUNE',FALSE,'IL','Dridu',3428 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1816,3,'COMMUNE',FALSE,'IL','Făcăeni',5244 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1817,3,'COMMUNE',FALSE,'IL','Gârbovi',3806,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1818,3,'COMMUNE',FALSE,'IL','Gheorghe Doja',2513 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1819,3,'COMMUNE',FALSE,'IL','Gheorghe Lazăr',2255,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1820,3,'COMMUNE',FALSE,'IL','Giurgeni',1509,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1821,3,'COMMUNE',FALSE,'IL','Grindu',2163 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1822,3,'COMMUNE',FALSE,'IL','Griviţa',3263,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1823,3,'COMMUNE',FALSE,'IL','Gura Ialomiţei',2594 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1824,3,'COMMUNE',FALSE,'IL','Ion Roată',3663 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1825,3,'COMMUNE',FALSE,'IL','Jilavele',3409 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1826,3,'COMMUNE',FALSE,'IL','Maia',1822 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1827,3,'COMMUNE',FALSE,'IL','Manasia',4194,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1828,3,'COMMUNE',FALSE,'IL','Mărculeşti',1480 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1829,3,'COMMUNE',FALSE,'IL','Mihail Kogălniceanu',2920 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1830,3,'COMMUNE',FALSE,'IL','Miloşeşti',2664 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1831,3,'COMMUNE',FALSE,'IL','Moldoveni',1235 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1832,3,'COMMUNE',FALSE,'IL','Movila',1787 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1833,3,'COMMUNE',FALSE,'IL','Moviliţa',2662 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1834,3,'COMMUNE',FALSE,'IL','Munteni-Buzău',3326  ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1835,3,'COMMUNE',FALSE,'IL','Ograda',2764 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1836,3,'COMMUNE',FALSE,'IL','Perieţi',3515,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1837,3,'COMMUNE',FALSE,'IL','Platoneşti',1766,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1838,3,'COMMUNE',FALSE,'IL','Răduleşti ',1325 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1839,3,'COMMUNE',FALSE,'IL','Reviga',2700,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1840,3,'COMMUNE',FALSE,'IL','Roşiori',2146 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1841,3,'COMMUNE',FALSE,'IL','Sălcioara',2289 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1842,3,'COMMUNE',FALSE,'IL','Sărăţeni',1292 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1843,3,'COMMUNE',FALSE,'IL','Săveni',3175 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1844,3,'COMMUNE',FALSE,'IL','Scânteia',3819 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1845,3,'COMMUNE',FALSE,'IL','Sfântu Gheorghe',2002 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1846,3,'COMMUNE',FALSE,'IL','Sineşti',2843 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1847,3,'COMMUNE',FALSE,'IL','Stelnica',1714,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1848,3,'COMMUNE',FALSE,'IL','Sudiţi',1993 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1849,3,'COMMUNE',FALSE,'IL','Traian',3130 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1850,3,'COMMUNE',FALSE,'IL','Valea Ciorii',1835 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1851,3,'COMMUNE',FALSE,'IL','Valea Măcrişului',1876,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1852,3,'COMMUNE',FALSE,'IL','Vlădeni',2152,null);

INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1853,3,'COMMUNE',FALSE,'IS','Alexandru Ioan Cuza',2996,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1854,3,'COMMUNE',FALSE,'IS','Andrieşeni',4420,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1855,3,'COMMUNE',FALSE,'IS','Aroneanu',3012,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1856,3,'COMMUNE',FALSE,'IS','Balş',3339,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1857,3,'COMMUNE',FALSE,'IS','Bălţaţi',5220,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1858,3,'COMMUNE',FALSE,'IS','Bârnova',4405,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1859,3,'COMMUNE',FALSE,'IS','Belceşti',11428,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1860,3,'COMMUNE',FALSE,'IS','Bivolari',4485,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1861,3,'COMMUNE',FALSE,'IS','Brăeşti',3210,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1862,3,'COMMUNE',FALSE,'IS','Butea',4262,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1863,3,'COMMUNE',FALSE,'IS','Cepleniţa',4530,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1864,3,'COMMUNE',FALSE,'IS','Ciohorăni',2100,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1865,3,'COMMUNE',FALSE,'IS','Ciorteşti',4227,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1866,3,'COMMUNE',FALSE,'IS','Ciurea',10769,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1867,3,'COMMUNE',FALSE,'IS','Coarnele Caprei',3103,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1868,3,'COMMUNE',FALSE,'IS','Comarna',4678,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1869,3,'COMMUNE',FALSE,'IS','Costeşti',1916,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1870,3,'COMMUNE',FALSE,'IS','Costuleni',4871,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1871,3,'COMMUNE',FALSE,'IS','Cotnari',7874,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1872,3,'COMMUNE',FALSE,'IS','Cozmeşti',2992,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1873,3,'COMMUNE',FALSE,'IS','Cristeşti',4339,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1874,3,'COMMUNE',FALSE,'IS','Cucuteni',1353,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1875,3,'COMMUNE',FALSE,'IS','Dagâţa',4887,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1876,3,'COMMUNE',FALSE,'IS','Deleni',10376,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1877,3,'COMMUNE',FALSE,'IS','Dobrovăţ',2499,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1878,3,'COMMUNE',FALSE,'IS','Dolheşti',2944,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1879,3,'COMMUNE',FALSE,'IS','Drăguşeni',1577,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1880,3,'COMMUNE',FALSE,'IS','Dumeşti',4741,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1881,3,'COMMUNE',FALSE,'IS','Erbiceni',5743,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1882,3,'COMMUNE',FALSE,'IS','Fântânele',2154,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1883,3,'COMMUNE',FALSE,'IS','Focuri',3914,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1884,3,'COMMUNE',FALSE,'IS','Golăieşti',3987,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1885,3,'COMMUNE',FALSE,'IS','Gorban',2910,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1886,3,'COMMUNE',FALSE,'IS','Grajduri',3182,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1887,3,'COMMUNE',FALSE,'IS','Gropniţa',3327,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1888,3,'COMMUNE',FALSE,'IS','Grozeşti',1851,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1889,3,'COMMUNE',FALSE,'IS','Hălăuceşti',5829,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1890,3,'COMMUNE',FALSE,'IS','Hărmăneşti',2370,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1891,3,'COMMUNE',FALSE,'IS','Heleşteni',2677,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1892,3,'COMMUNE',FALSE,'IS','Holboca',12538,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1893,3,'COMMUNE',FALSE,'IS','Horleşti',2958,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1894,3,'COMMUNE',FALSE,'IS','Ion Neculce',5637,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1895,3,'COMMUNE',FALSE,'IS','Ipatele',2060,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1896,3,'COMMUNE',FALSE,'IS','Lespezi',5980,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1897,3,'COMMUNE',FALSE,'IS','Leţcani',6805,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1898,3,'COMMUNE',FALSE,'IS','Lungani',5556,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1899,3,'COMMUNE',FALSE,'IS','Mădârjac',1532,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1900,3,'COMMUNE',FALSE,'IS','Mirceşti',3739,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1901,3,'COMMUNE',FALSE,'IS','Mironeasa',4727,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1902,3,'COMMUNE',FALSE,'IS','Miroslava',9243,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1903,3,'COMMUNE',FALSE,'IS','Mirosloveşti',4848,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1904,3,'COMMUNE',FALSE,'IS','Mogoşeşti',5323,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1905,3,'COMMUNE',FALSE,'IS','Mogoşeşti-Siret',4049,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1906,3,'COMMUNE',FALSE,'IS','Moşna',1935,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1907,3,'COMMUNE',FALSE,'IS','Moţca',5185,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1908,3,'COMMUNE',FALSE,'IS','Movileni',3190,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1909,3,'COMMUNE',FALSE,'IS','Oţeleni',3773,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1910,3,'COMMUNE',FALSE,'IS','Plugari',3568,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1911,3,'COMMUNE',FALSE,'IS','Popeşti',4222,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1912,3,'COMMUNE',FALSE,'IS','Popricani',7566,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1913,3,'COMMUNE',FALSE,'IS','Prisăcani',3505,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1914,3,'COMMUNE',FALSE,'IS','Probot',3692,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1915,3,'COMMUNE',FALSE,'IS','Răchiteni',3430,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1916,3,'COMMUNE',FALSE,'IS','Răducăneni',8091,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1917,3,'COMMUNE',FALSE,'IS','Rediu',3921,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1918,3,'COMMUNE',FALSE,'IS','Româneşti',1852,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1919,3,'COMMUNE',FALSE,'IS','Roşcani',1629,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1920,3,'COMMUNE',FALSE,'IS','Ruginoasa',6339,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1921,3,'COMMUNE',FALSE,'IS','Scânteia',4539,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1922,3,'COMMUNE',FALSE,'IS','Schitu Duca',4476,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1923,3,'COMMUNE',FALSE,'IS','Scobinţi',7490,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1924,3,'COMMUNE',FALSE,'IS','Sineşti',4401,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1925,3,'COMMUNE',FALSE,'IS','Sireţel',4150,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1926,3,'COMMUNE',FALSE,'IS','Stolniceni-Prăjescu',5547,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1927,3,'COMMUNE',FALSE,'IS','Strunga',4418,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1928,3,'COMMUNE',FALSE,'IS','Şcheia',3359,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1929,3,'COMMUNE',FALSE,'IS','Şipote',5459,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1930,3,'COMMUNE',FALSE,'IS','Tansa',2916,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1931,3,'COMMUNE',FALSE,'IS','Tătăruşi',5645,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1932,3,'COMMUNE',FALSE,'IS','Todireşti',4888,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1933,3,'COMMUNE',FALSE,'IS','Tomeşti',12337,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1934,3,'COMMUNE',FALSE,'IS','Trifeşti',3777,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1935,3,'COMMUNE',FALSE,'IS','Ţibana',7649,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1936,3,'COMMUNE',FALSE,'IS','Ţibăneşti',8003,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1937,3,'COMMUNE',FALSE,'IS','Ţigănaşi',4423,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1938,3,'COMMUNE',FALSE,'IS','Ţuţora',2066,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1939,3,'COMMUNE',FALSE,'IS','Ungheni',4242,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1940,3,'COMMUNE',FALSE,'IS','Valea Lupului',3859,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1941,3,'COMMUNE',FALSE,'IS','Valea Seacă',6122,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1942,3,'COMMUNE',FALSE,'IS','Vânători',4656,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1943,3,'COMMUNE',FALSE,'IS','Victoria',4399,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1944,3,'COMMUNE',FALSE,'IS','Vlădeni',4593,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1945,3,'COMMUNE',FALSE,'IS','Voineşti',6907,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1946,3,'COMMUNE',FALSE,'IF','1 Decembrie',6378,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1947,3,'COMMUNE',FALSE,'IF','Afumaţi',6448,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1948,3,'COMMUNE',FALSE,'IF','Baloteşti',6476,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1949,3,'COMMUNE',FALSE,'IF','Berceni',3665,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1950,3,'COMMUNE',FALSE,'IF','Brăneşti',8167,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1951,3,'COMMUNE',FALSE,'IF','Cernica',9559,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1952,3,'COMMUNE',FALSE,'IF','Chiajna',8162,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1953,3,'COMMUNE',FALSE,'IF','Ciolpani',4255,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1954,3,'COMMUNE',FALSE,'IF','Ciorogârla',4888,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1955,3,'COMMUNE',FALSE,'IF','Clinceni',4432,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1956,3,'COMMUNE',FALSE,'IF','Copăceni',2861,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1957,3,'COMMUNE',FALSE,'IF','Corbeanca',3860,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1958,3,'COMMUNE',FALSE,'IF','Cornetu',4629,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1959,3,'COMMUNE',FALSE,'IF','Dărăşti-Ilfov',2567,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1960,3,'COMMUNE',FALSE,'IF','Dascălu',2443,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1961,3,'COMMUNE',FALSE,'IF','Dobroeşti',6493,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1962,3,'COMMUNE',FALSE,'IF','Domneşti',5910,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1963,3,'COMMUNE',FALSE,'IF','Dragomireşti-Vale',4145,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1964,3,'COMMUNE',FALSE,'IF','Găneasa',4408,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1965,3,'COMMUNE',FALSE,'IF','Glina',6746,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1966,3,'COMMUNE',FALSE,'IF','Grădiştea',2784,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1967,3,'COMMUNE',FALSE,'IF','Gruiu',6585,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1968,3,'COMMUNE',FALSE,'IF','Jilava',6970,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1969,3,'COMMUNE',FALSE,'IF','Moara Vlăsiei',5717,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1970,3,'COMMUNE',FALSE,'IF','Mogoşoaia',5483,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1971,3,'COMMUNE',FALSE,'IF','Nuci',2836,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1972,3,'COMMUNE',FALSE,'IF','Periş',6923,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1973,3,'COMMUNE',FALSE,'IF','Petrăchioaia',2552,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1974,3,'COMMUNE',FALSE,'IF','Snagov',5941,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1975,3,'COMMUNE',FALSE,'IF','Ştefăneştii de Jos',4277,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1976,3,'COMMUNE',FALSE,'IF','Tunari',3746,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1977,3,'COMMUNE',FALSE,'IF','Vidra',7803,null);	
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1978,3,'COMMUNE',FALSE,'MM','Ardusat',2751,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1979,3,'COMMUNE',FALSE,'MM','Ariniş',1051,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1980,3,'COMMUNE',FALSE,'MM','Asuaju de Sus',1581,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1981,3,'COMMUNE',FALSE,'MM','Băiţa de sub Codru',1852,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1982,3,'COMMUNE',FALSE,'MM','Băiuţ',2539,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1983,3,'COMMUNE',FALSE,'MM','Bârsana',4864,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1984,3,'COMMUNE',FALSE,'MM','Băseşti',1559,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1985,3,'COMMUNE',FALSE,'MM','Bicaz',1174,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1986,3,'COMMUNE',FALSE,'MM','Bistra',4269,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1987,3,'COMMUNE',FALSE,'MM','Bocicoiu Mare',4461,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1988,3,'COMMUNE',FALSE,'MM','Bogdan Vodă',3290,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1989,3,'COMMUNE',FALSE,'MM','Boiu Mare',1195,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1990,3,'COMMUNE',FALSE,'MM','Botiza',2861,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1991,3,'COMMUNE',FALSE,'MM','Budeşti',3350,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1992,3,'COMMUNE',FALSE,'MM','Călineşti',3305,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1993,3,'COMMUNE',FALSE,'MM','Câmpulung la Tisa',2468,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1994,3,'COMMUNE',FALSE,'MM','Cerneşti',3716,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1995,3,'COMMUNE',FALSE,'MM','Cicârlău',4025,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1996,3,'COMMUNE',FALSE,'MM','Coaş',1393,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1997,3,'COMMUNE',FALSE,'MM','Coltău',2176,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1998,3,'COMMUNE',FALSE,'MM','Copalnic-Mănăştur',5808,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (1999,3,'COMMUNE',FALSE,'MM','Coroieni',2284,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2000,3,'COMMUNE',FALSE,'MM','Cupşeni',3656,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2001,3,'COMMUNE',FALSE,'MM','Deseşti',2532,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2002,3,'COMMUNE',FALSE,'MM','Dumbrăviţa',4378,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2003,3,'COMMUNE',FALSE,'MM','Fărcaşa',3968,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2004,3,'COMMUNE',FALSE,'MM','Gârdani',1624,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2005,3,'COMMUNE',FALSE,'MM','Giuleşti',3245,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2006,3,'COMMUNE',FALSE,'MM','Groşi',2474,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2007,3,'COMMUNE',FALSE,'MM','Groşii Ţibleşului',2146,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2008,3,'COMMUNE',FALSE,'MM','Ieud',4217,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2009,3,'COMMUNE',FALSE,'MM','Lăpuş',3899,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2010,3,'COMMUNE',FALSE,'MM','Leordina',2532,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2011,3,'COMMUNE',FALSE,'MM','Mireşu Mare',5110,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2012,3,'COMMUNE',FALSE,'MM','Moisei',9258,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2013,3,'COMMUNE',FALSE,'MM','Oarţa de Jos',1345,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2014,3,'COMMUNE',FALSE,'MM','Ocna Şugatag',4185,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2015,3,'COMMUNE',FALSE,'MM','Onceşti',1540,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2016,3,'COMMUNE',FALSE,'MM','Petrova',2540,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2017,3,'COMMUNE',FALSE,'MM','Poienile de sub Munte',10282,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2018,3,'COMMUNE',FALSE,'MM','Poienile Izei',1001,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2019,3,'COMMUNE',FALSE,'MM','Recea',5580,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2020,3,'COMMUNE',FALSE,'MM','Remetea Chioarului',2872,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2021,3,'COMMUNE',FALSE,'MM','Remeţi',3116,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2022,3,'COMMUNE',FALSE,'MM','Repedea',4904,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2023,3,'COMMUNE',FALSE,'MM','Rona de Jos',2055,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2024,3,'COMMUNE',FALSE,'MM','Rona de Sus',4640,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2025,3,'COMMUNE',FALSE,'MM','Rozavlea',3508,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2026,3,'COMMUNE',FALSE,'MM','Ruscova',5190,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2027,3,'COMMUNE',FALSE,'MM','Săcălăşeni',2448,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2028,3,'COMMUNE',FALSE,'MM','Săcel',3641,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2029,3,'COMMUNE',FALSE,'MM','Sălsig',1518,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2030,3,'COMMUNE',FALSE,'MM','Săpânţa',3336,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2031,3,'COMMUNE',FALSE,'MM','Sarasău',2514,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2032,3,'COMMUNE',FALSE,'MM','Satulung',5690,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2033,3,'COMMUNE',FALSE,'MM','Şieu',2575,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2034,3,'COMMUNE',FALSE,'MM','Şişeşti',5473,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2035,3,'COMMUNE',FALSE,'MM','Strâmtura',4033,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2036,3,'COMMUNE',FALSE,'MM','Suciu de Sus',4048,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2037,3,'COMMUNE',FALSE,'MM','Vadu Izei',2923,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2038,3,'COMMUNE',FALSE,'MM','Valea Chioarului',2275,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2039,3,'COMMUNE',FALSE,'MM','Vima Mică',1499,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2040,3,'COMMUNE',FALSE,'MM','Vişeu de Jos',5509,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2041,3,'COMMUNE',FALSE,'MH','Bala',3870,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2042,3,'COMMUNE',FALSE,'MH','Balta',1106,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2043,3,'COMMUNE',FALSE,'MH','Bălăciţa',2727 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2044,3,'COMMUNE',FALSE,'MH','Bâcleş',2026 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2045,3,'COMMUNE',FALSE,'MH','Bâlvăneşti',986 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2046,3,'COMMUNE',FALSE,'MH','Braniştea',1739,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2047,3,'COMMUNE',FALSE,'MH','Brezniţa-Motru',1501 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2048,3,'COMMUNE',FALSE,'MH','Brezniţa-Ocol',3803 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2049,3,'COMMUNE',FALSE,'MH','Broşteni',2851 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2050,3,'COMMUNE',FALSE,'MH','Burila Mare',2233,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2051,3,'COMMUNE',FALSE,'MH','Butoieşti',327,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2052,3,'COMMUNE',FALSE,'MH','Căzăneşti',2314 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2053,3,'COMMUNE',FALSE,'MH','Cireşu',636,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2054,3,'COMMUNE',FALSE,'MH','Corcova',5252,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2055,3,'COMMUNE',FALSE,'MH','Corlăţel',1335 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2056,3,'COMMUNE',FALSE,'MH','Cujmir',3120 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2057,3,'COMMUNE',FALSE,'MH','Dârvari',2424 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2058,3,'COMMUNE',FALSE,'MH','Devesel',3299 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2059,3,'COMMUNE',FALSE,'MH','Dubova',768,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2060,3,'COMMUNE',FALSE,'MH','Dumbrava',1531 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2061,3,'COMMUNE',FALSE,'MH','Eşelniţa',2501 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2062,3,'COMMUNE',FALSE,'MH','Floreşti',2595 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2063,3,'COMMUNE',FALSE,'MH','Gârla Mare',3118,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2064,3,'COMMUNE',FALSE,'MH','Godeanu',648 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2065,3,'COMMUNE',FALSE,'MH','Gogoşu',3515 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2066,3,'COMMUNE',FALSE,'MH','Greci',1265 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2067,3,'COMMUNE',FALSE,'MH','Grozeşti',1938,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2068,3,'COMMUNE',FALSE,'MH','Gruia',3028,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2069,3,'COMMUNE',FALSE,'MH','Hinova',2829 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2070,3,'COMMUNE',FALSE,'MH','Husnicioara',1385 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2071,3,'COMMUNE',FALSE,'MH','Ilovăţ',1290 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2072,3,'COMMUNE',FALSE,'MH','Iloviţa',1299 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2073,3,'COMMUNE',FALSE,'MH','Isverna',2122 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2074,3,'COMMUNE',FALSE,'MH','Izvoru Bârzii',2671 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2075,3,'COMMUNE',FALSE,'MH','Jiana',4550 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2076,3,'COMMUNE',FALSE,'MH','Livezile',1691,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2077,3,'COMMUNE',FALSE,'MH','Malovăţ',3072 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2078,3,'COMMUNE',FALSE,'MH','Obârşia de Câmp',1699,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2079,3,'COMMUNE',FALSE,'MH','Obârşia-Cloşani',936 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2080,3,'COMMUNE',FALSE,'MH','Oprişor',2257,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2081,3,'COMMUNE',FALSE,'MH','Pădina Mare',1472 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2082,3,'COMMUNE',FALSE,'MH','Pătulele',3611 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2083,3,'COMMUNE',FALSE,'MH','Podeni',849 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2084,3,'COMMUNE',FALSE,'MH','Ponoarele',2420,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2085,3,'COMMUNE',FALSE,'MH','Poroina Mare',1035 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2086,3,'COMMUNE',FALSE,'MH','Pristol',1415,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2087,3,'COMMUNE',FALSE,'MH','Prunişor',1952 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2088,3,'COMMUNE',FALSE,'MH','Punghina',2592,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2089,3,'COMMUNE',FALSE,'MH','Rogova',1323 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2090,3,'COMMUNE',FALSE,'MH','Salcia',2787 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2091,3,'COMMUNE',FALSE,'MH','Siseşti',3038,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2092,3,'COMMUNE',FALSE,'MH','Stângăceaua',1331 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2093,3,'COMMUNE',FALSE,'MH','Sviniţa',928 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2094,3,'COMMUNE',FALSE,'MH','Şimian',9116 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2095,3,'COMMUNE',FALSE,'MH','Şovarna',1328 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2096,3,'COMMUNE',FALSE,'MH','Tâmna',3126 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2097,3,'COMMUNE',FALSE,'MH','Vânători',1932 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2098,3,'COMMUNE',FALSE,'MH','Vânjuleţ',1860 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2099,3,'COMMUNE',FALSE,'MH','Vlădaia',1705 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2100,3,'COMMUNE',FALSE,'MH','Voloiac',1662 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2101,3,'COMMUNE',FALSE,'MH','Vrata',1551 ,null);					                           
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2102,3,'COMMUNE',FALSE,'MS','Acăţari',4883,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2103,3,'COMMUNE',FALSE,'MS','Adămuş',6036,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2104,3,'COMMUNE',FALSE,'MS','Albeşti',5696,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2105,3,'COMMUNE',FALSE,'MS','Aluniş',3251,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2106,3,'COMMUNE',FALSE,'MS','Apold',3086,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2107,3,'COMMUNE',FALSE,'MS','Aţintiş',1675,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2108,3,'COMMUNE',FALSE,'MS','Bahnea',3831,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2109,3,'COMMUNE',FALSE,'MS','Band',6532,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2110,3,'COMMUNE',FALSE,'MS','Batoş',4194,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2111,3,'COMMUNE',FALSE,'MS','Băgaciu',2686,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2112,3,'COMMUNE',FALSE,'MS','Băla',833	,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2113,3,'COMMUNE',FALSE,'MS','Bălăuşeri',5027,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2114,3,'COMMUNE',FALSE,'MS','Beica de Jos',2237,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2115,3,'COMMUNE',FALSE,'MS','Bereni',1224,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2116,3,'COMMUNE',FALSE,'MS','Bichiş',980,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2117,3,'COMMUNE',FALSE,'MS','Bogata',2022,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2118,3,'COMMUNE',FALSE,'MS','Brâncoveneşti',4121,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2119,3,'COMMUNE',FALSE,'MS','Breaza',2542,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2120,3,'COMMUNE',FALSE,'MS','Ceuaşu de Câmpie',5651,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2121,3,'COMMUNE',FALSE,'MS','Cheţani',2794,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2122,3,'COMMUNE',FALSE,'MS','Chibed',1721,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2123,3,'COMMUNE',FALSE,'MS','Chiheru de Jos',1605,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2124,3,'COMMUNE',FALSE,'MS','Coroisânmărtin',1484,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2125,3,'COMMUNE',FALSE,'MS','Corunca',1889,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2126,3,'COMMUNE',FALSE,'MS','Cozma',595,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2127,3,'COMMUNE',FALSE,'MS','Crăciuneşti',4291,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2128,3,'COMMUNE',FALSE,'MS','Crăieşti',994,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2129,3,'COMMUNE',FALSE,'MS','Cristeşti',5762,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2130,3,'COMMUNE',FALSE,'MS','Cucerdea',1638,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2131,3,'COMMUNE',FALSE,'MS','Cuci',2117,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2132,3,'COMMUNE',FALSE,'MS','Daneş',4947,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2133,3,'COMMUNE',FALSE,'MS','Deda',4437,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2134,3,'COMMUNE',FALSE,'MS','Eremitu',3984,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2135,3,'COMMUNE',FALSE,'MS','Ernei',5467,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2136,3,'COMMUNE',FALSE,'MS','Fărăgău',1680,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2137,3,'COMMUNE',FALSE,'MS','Fântânele',5011,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2138,3,'COMMUNE',FALSE,'MS','Găleşti',2871,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2139,3,'COMMUNE',FALSE,'MS','Găneşti',3987,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2140,3,'COMMUNE',FALSE,'MS','Gheorghe Doja',2889,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2141,3,'COMMUNE',FALSE,'MS','Ghindari',3262,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2142,3,'COMMUNE',FALSE,'MS','Glodeni',3808,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2143,3,'COMMUNE',FALSE,'MS','Gorneşti',5757,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2144,3,'COMMUNE',FALSE,'MS','Grebenişu de Câmpie',1637,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2145,3,'COMMUNE',FALSE,'MS','Gurghiu',6230,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2146,3,'COMMUNE',FALSE,'MS','Hodac',5049,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2147,3,'COMMUNE',FALSE,'MS','Hodoşa',1368,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2148,3,'COMMUNE',FALSE,'MS','Ibăneşti',4441,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2149,3,'COMMUNE',FALSE,'MS','Iclănzel',2248,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2150,3,'COMMUNE',FALSE,'MS','Ideciu de Jos',2108,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2151,3,'COMMUNE',FALSE,'MS','Livezeni',2255,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2152,3,'COMMUNE',FALSE,'MS','Lunca',2721,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2153,3,'COMMUNE',FALSE,'MS','Lunca Bradului',2141,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2154,3,'COMMUNE',FALSE,'MS','Mădăraş',1265,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2155,3,'COMMUNE',FALSE,'MS','Măgherani',1415,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2156,3,'COMMUNE',FALSE,'MS','Mica',4776,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2157,3,'COMMUNE',FALSE,'MS','Miheşu de Câmpie',2597,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2158,3,'COMMUNE',FALSE,'MS','Nadeş',2504,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2159,3,'COMMUNE',FALSE,'MS','Neaua',1456,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2160,3,'COMMUNE',FALSE,'MS','Ogra',2499,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2161,3,'COMMUNE',FALSE,'MS','Papiu Ilarian',999	,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2162,3,'COMMUNE',FALSE,'MS','Pănet',6132,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2163,3,'COMMUNE',FALSE,'MS','Păsăreni',1763,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2164,3,'COMMUNE',FALSE,'MS','Petelea',2924,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2165,3,'COMMUNE',FALSE,'MS','Pogăceaua',2030,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2166,3,'COMMUNE',FALSE,'MS','Râciu',3647,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2167,3,'COMMUNE',FALSE,'MS','Răstoliţa',2131,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2168,3,'COMMUNE',FALSE,'MS','Ruşii-Munţi',2287,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2169,3,'COMMUNE',FALSE,'MS','Saschiz',2080,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2170,3,'COMMUNE',FALSE,'MS','Sărăţeni',2090,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2171,3,'COMMUNE',FALSE,'MS','Sâncraiu de Mureş',6861,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2172,3,'COMMUNE',FALSE,'MS','Sângeorgiu de Mureş',8592,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2173,3,'COMMUNE',FALSE,'MS','Sânger',2474,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2174,3,'COMMUNE',FALSE,'MS','Sânpaul',4246,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2175,3,'COMMUNE',FALSE,'MS','Sânpetru de Câmpie',3068,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2176,3,'COMMUNE',FALSE,'MS','Sântana de Mureş',4676,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2177,3,'COMMUNE',FALSE,'MS','Solovăstru',2951,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2178,3,'COMMUNE',FALSE,'MS','Stânceni',1540,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2179,3,'COMMUNE',FALSE,'MS','Suplac',2205,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2180,3,'COMMUNE',FALSE,'MS','Suseni',2422,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2181,3,'COMMUNE',FALSE,'MS','Şăulia',2197,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2182,3,'COMMUNE',FALSE,'MS','Şincai',1601,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2183,3,'COMMUNE',FALSE,'MS','Tăureni',1017,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2184,3,'COMMUNE',FALSE,'MS','Valea Largă',3256,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2185,3,'COMMUNE',FALSE,'MS','Vărgata',2001,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2186,3,'COMMUNE',FALSE,'MS','Vânători',3993,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2187,3,'COMMUNE',FALSE,'MS','Vătava',2027,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2188,3,'COMMUNE',FALSE,'MS','Veţca',808	,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2189,3,'COMMUNE',FALSE,'MS','Viişoara',1702,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2190,3,'COMMUNE',FALSE,'MS','Voivodeni',1832,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2191,3,'COMMUNE',FALSE,'MS','Zagăr',1235,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2192,3,'COMMUNE',FALSE,'MS','Zau de Câmpie',3447,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2193,3,'COMMUNE',FALSE,'NT','Agapia',3852 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2194,3,'COMMUNE',FALSE,'NT','Alexandru cel Bun',4744 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2195,3,'COMMUNE',FALSE,'NT','Bahna',3071 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2196,3,'COMMUNE',FALSE,'NT','Bălţăteşti',4090 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2197,3,'COMMUNE',FALSE,'NT','Bâra',1639 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2198,3,'COMMUNE',FALSE,'NT','Bârgăuani',3437 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2199,3,'COMMUNE',FALSE,'NT','Bicaz-Chei',4136 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2200,3,'COMMUNE',FALSE,'NT','Bicazu Ardelean',4064,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2201,3,'COMMUNE',FALSE,'NT','Bodeşti',4442 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2202,3,'COMMUNE',FALSE,'NT','Boghicea',2261 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2203,3,'COMMUNE',FALSE,'NT','Borca',6055 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2204,3,'COMMUNE',FALSE,'NT','Borleşti',6763 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2205,3,'COMMUNE',FALSE,'NT','Boteşti',4906 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2206,3,'COMMUNE',FALSE,'NT','Bozieni',2725 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2207,3,'COMMUNE',FALSE,'NT','Brusturi',3812 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2208,3,'COMMUNE',FALSE,'NT','Cândeşti',3158 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2209,3,'COMMUNE',FALSE,'NT','Ceahlău',2127 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2210,3,'COMMUNE',FALSE,'NT','Cordun',6254 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2211,3,'COMMUNE',FALSE,'NT','Costişa',2827 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2212,3,'COMMUNE',FALSE,'NT','Crăcăoani',3849 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2213,3,'COMMUNE',FALSE,'NT','Dămuc',2750 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2214,3,'COMMUNE',FALSE,'NT','Dobreni',1840 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2215,3,'COMMUNE',FALSE,'NT','Dochia',2135 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2216,3,'COMMUNE',FALSE,'NT','Doljeşti',7117 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2217,3,'COMMUNE',FALSE,'NT','Dragomireşti',1382 ,NULL);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2218,3,'COMMUNE',FALSE,'NT','Drăgăneşti',1382 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2219,3,'COMMUNE',FALSE,'NT','Dulceşti',2231 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2220,3,'COMMUNE',FALSE,'NT','Dumbrava Roşie',6553 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2221,3,'COMMUNE',FALSE,'NT','Farcaşa',2868 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2222,3,'COMMUNE',FALSE,'NT','Făurei',1905 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2223,3,'COMMUNE',FALSE,'NT','Gâdinţi',1901 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2224,3,'COMMUNE',FALSE,'NT','Gârcina',4263 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2225,3,'COMMUNE',FALSE,'NT','Gherăeşti',4725,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2226,3,'COMMUNE',FALSE,'NT','Ghindăoani',1807 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2227,3,'COMMUNE',FALSE,'NT','Girov',4537 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2228,3,'COMMUNE',FALSE,'NT','Grinţieş',2199 ,NULL);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2229,3,'COMMUNE',FALSE,'NT','Grumăzeşti',5129 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2230,3,'COMMUNE',FALSE,'NT','Hangu',3619 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2231,3,'COMMUNE',FALSE,'NT','Horia',5757 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2232,3,'COMMUNE',FALSE,'NT','Icuşeşti',3764 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2233,3,'COMMUNE',FALSE,'NT','Ion Creangă',4939 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2234,3,'COMMUNE',FALSE,'NT','Mărgineni',3168 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2235,3,'COMMUNE',FALSE,'NT','Moldoveni',2217 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2236,3,'COMMUNE',FALSE,'NT','Negreşti',1623 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2237,3,'COMMUNE',FALSE,'NT','Oniceni',3296,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2238,3,'COMMUNE',FALSE,'NT','Păstrăveni',3514 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2239,3,'COMMUNE',FALSE,'NT','Pânceşti',1337 ,NULL);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2240,3,'COMMUNE',FALSE,'NT','Pângăraţi',4544 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2241,3,'COMMUNE',FALSE,'NT','Petricani',5104 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2242,3,'COMMUNE',FALSE,'NT','Piatra Şoimului',5466,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2243,3,'COMMUNE',FALSE,'NT','Pipirig',8268 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2244,3,'COMMUNE',FALSE,'NT','Podoleni',4079 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2245,3,'COMMUNE',FALSE,'NT','Poiana Teiului',4344 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2246,3,'COMMUNE',FALSE,'NT','Poienari',1445 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2247,3,'COMMUNE',FALSE,'NT','Răuceşti',7761 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2248,3,'COMMUNE',FALSE,'NT','Războieni',2279 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2249,3,'COMMUNE',FALSE,'NT','Rediu',4131 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2250,3,'COMMUNE',FALSE,'NT','Români',3873 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2251,3,'COMMUNE',FALSE,'NT','Ruginoasa',1726 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2252,3,'COMMUNE',FALSE,'NT','Sagna',3800 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2253,3,'COMMUNE',FALSE,'NT','Săbăoani',9618 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2254,3,'COMMUNE',FALSE,'NT','Săvineşti',6092 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2255,3,'COMMUNE',FALSE,'NT','Secuieni',2895 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2256,3,'COMMUNE',FALSE,'NT','Stăniţa',1917 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2257,3,'COMMUNE',FALSE,'NT','Ştefan cel Mare',2961 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2258,3,'COMMUNE',FALSE,'NT','Tarcău',3032,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2259,3,'COMMUNE',FALSE,'NT','Taşca',2225 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2260,3,'COMMUNE',FALSE,'NT','Tazlău',2226 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2261,3,'COMMUNE',FALSE,'NT','Tămăşeni',6196 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2262,3,'COMMUNE',FALSE,'NT','Timişeşti',3462 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2263,3,'COMMUNE',FALSE,'NT','Trifeşti',4462 ,NULL);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2264,3,'COMMUNE',FALSE,'NT','Tupilaţi',2127 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2265,3,'COMMUNE',FALSE,'NT','Ţibucani',3853,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2266,3,'COMMUNE',FALSE,'NT','Urecheni',3270 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2267,3,'COMMUNE',FALSE,'NT','Valea Ursului',3692 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2268,3,'COMMUNE',FALSE,'NT','Văleni',1337 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2269,3,'COMMUNE',FALSE,'NT','Vânători-Neamţ',7594 ,NULL);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2270,3,'COMMUNE',FALSE,'NT','Zăneşti',4769 ,NULL);					

INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2271,3,'COMMUNE',FALSE,'OT','Baldovineşti',1087 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2272,3,'COMMUNE',FALSE,'OT','Băbiciu',1994 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2273,3,'COMMUNE',FALSE,'OT','Bălteni',1669 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2274,3,'COMMUNE',FALSE,'OT','Bărăşti',1782 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2275,3,'COMMUNE',FALSE,'OT','Bârza',2478,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2276,3,'COMMUNE',FALSE,'OT','Bobiceşti',3243 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2277,3,'COMMUNE',FALSE,'OT','Brastavăţu',4786,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2278,3,'COMMUNE',FALSE,'OT','Brâncoveni',2662,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2279,3,'COMMUNE',FALSE,'OT','Brebeni',3080 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2280,3,'COMMUNE',FALSE,'OT','Bucinişu',2087 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2281,3,'COMMUNE',FALSE,'OT','Călui',1488 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2282,3,'COMMUNE',FALSE,'OT','Cârlogani',2283 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2283,3,'COMMUNE',FALSE,'OT','Cezieni',1793,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2284,3,'COMMUNE',FALSE,'OT','Cilieni',3170 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2285,3,'COMMUNE',FALSE,'OT','Coloneşti',2060 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2286,3,'COMMUNE',FALSE,'OT','Corbu',2408 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2287,3,'COMMUNE',FALSE,'OT','Coteana',2437 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2288,3,'COMMUNE',FALSE,'OT','Crâmpoia',3519,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2289,3,'COMMUNE',FALSE,'OT','Cungrea',2131 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2290,3,'COMMUNE',FALSE,'OT','Curtişoara',4111 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2291,3,'COMMUNE',FALSE,'OT','Dăneasa',3789 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2292,3,'COMMUNE',FALSE,'OT','Deveselu',3050,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2293,3,'COMMUNE',FALSE,'OT','Dobreţu',1160 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2294,3,'COMMUNE',FALSE,'OT','Dobrosloveni',3711 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2295,3,'COMMUNE',FALSE,'OT','Dobroteasa',1782 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2296,3,'COMMUNE',FALSE,'OT','Dobrun',1516,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2297,3,'COMMUNE',FALSE,'OT','Drăghiceni',1767,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2298,3,'COMMUNE',FALSE,'OT','Făgeţelu',1218 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2299,3,'COMMUNE',FALSE,'OT','Fălcoiu',3855 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2300,3,'COMMUNE',FALSE,'OT','Fărcaşele',4614 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2301,3,'COMMUNE',FALSE,'OT','Găneasa',3686 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2302,3,'COMMUNE',FALSE,'OT','Găvăneşti',2027,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2303,3,'COMMUNE',FALSE,'OT','Gârcov',2238,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2304,3,'COMMUNE',FALSE,'OT','Ghimpeţeni',1506,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2305,3,'COMMUNE',FALSE,'OT','Giuvărăşti',2361 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2306,3,'COMMUNE',FALSE,'OT','Gostavăţu',2837 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2307,3,'COMMUNE',FALSE,'OT','Grădinari',2133 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2308,3,'COMMUNE',FALSE,'OT','Grădinile',1471 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2309,3,'COMMUNE',FALSE,'OT','Grojdibodu',2804 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2310,3,'COMMUNE',FALSE,'OT','Gura Padinii',1634 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2311,3,'COMMUNE',FALSE,'OT','Ianca',3505 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2312,3,'COMMUNE',FALSE,'OT','Iancu Jianu',3947 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2313,3,'COMMUNE',FALSE,'OT','Icoana',1832 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2314,3,'COMMUNE',FALSE,'OT','Ipoteşti',1428 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2315,3,'COMMUNE',FALSE,'OT','Izbiceni',4663 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2316,3,'COMMUNE',FALSE,'OT','Izvoarele',3380 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2317,3,'COMMUNE',FALSE,'OT','Leleasca',1597 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2318,3,'COMMUNE',FALSE,'OT','Mărunţei',4089,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2319,3,'COMMUNE',FALSE,'OT','Mihăeşti',1629 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2320,3,'COMMUNE',FALSE,'OT','Milcov',1493 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2321,3,'COMMUNE',FALSE,'OT','Morunglav',2473 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2322,3,'COMMUNE',FALSE,'OT','Movileni',3287 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2323,3,'COMMUNE',FALSE,'OT','Nicolae Titulescu',1230 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2324,3,'COMMUNE',FALSE,'OT','Obârşia',2855 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2325,3,'COMMUNE',FALSE,'OT','Oboga',1723 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2326,3,'COMMUNE',FALSE,'OT','Oporelu',1259 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2327,3,'COMMUNE',FALSE,'OT','Optaşi-Măgura',1230 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2328,3,'COMMUNE',FALSE,'OT','Orlea',2292,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2329,3,'COMMUNE',FALSE,'OT','Osica de Jos',1558 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2330,3,'COMMUNE',FALSE,'OT','Osica de Sus',5113 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2331,3,'COMMUNE',FALSE,'OT','Pârşcoveni',3047 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2332,3,'COMMUNE',FALSE,'OT','Perieţi',2206 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2333,3,'COMMUNE',FALSE,'OT','Pleşoiu',3035,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2334,3,'COMMUNE',FALSE,'OT','Poboru',1976 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2335,3,'COMMUNE',FALSE,'OT','Priseaca',1459 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2336,3,'COMMUNE',FALSE,'OT','Radomireşti',3232,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2337,3,'COMMUNE',FALSE,'OT','Redea',2946 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2338,3,'COMMUNE',FALSE,'OT','Rotunda',2791,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2339,3,'COMMUNE',FALSE,'OT','Rusăneşti',4207 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2340,3,'COMMUNE',FALSE,'OT','Sâmbureşti',1167 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2341,3,'COMMUNE',FALSE,'OT','Sârbii-Măgura',2005 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2342,3,'COMMUNE',FALSE,'OT','Scărişoara',2920 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2343,3,'COMMUNE',FALSE,'OT','Schitu',2519,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2344,3,'COMMUNE',FALSE,'OT','Seaca',2021 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2345,3,'COMMUNE',FALSE,'OT','Slătioara',2477,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2346,3,'COMMUNE',FALSE,'OT','Spineni',2033 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2347,3,'COMMUNE',FALSE,'OT','Sprâncenata',2607 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2348,3,'COMMUNE',FALSE,'OT','Stoeneşti',2358 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2349,3,'COMMUNE',FALSE,'OT','Stoicăneşti',2548 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2350,3,'COMMUNE',FALSE,'OT','Strejeşti',3318 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2351,3,'COMMUNE',FALSE,'OT','Studina',3014 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2352,3,'COMMUNE',FALSE,'OT','Şerbăneşti',2884,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2353,3,'COMMUNE',FALSE,'OT','Şopârliţa',1268,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2354,3,'COMMUNE',FALSE,'OT','Ştefan cel Mare',1753 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2355,3,'COMMUNE',FALSE,'OT','Tătuleşti',1072 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2356,3,'COMMUNE',FALSE,'OT','Teslui',2629 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2357,3,'COMMUNE',FALSE,'OT','Tia Mare',4430 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2358,3,'COMMUNE',FALSE,'OT','Topana',961 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2359,3,'COMMUNE',FALSE,'OT','Traian',3162 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2360,3,'COMMUNE',FALSE,'OT','Tufeni',2963 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2361,3,'COMMUNE',FALSE,'OT','Urzica',2236 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2362,3,'COMMUNE',FALSE,'OT','Valea Mare',3524 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2363,3,'COMMUNE',FALSE,'OT','Vădastra',1413 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2364,3,'COMMUNE',FALSE,'OT','Vădăstriţa',3361 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2365,3,'COMMUNE',FALSE,'OT','Văleni',2684 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2366,3,'COMMUNE',FALSE,'OT','Vâlcele',2460 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2367,3,'COMMUNE',FALSE,'OT','Verguleasa',3004 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2368,3,'COMMUNE',FALSE,'OT','Vişina',2940 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2369,3,'COMMUNE',FALSE,'OT','Vişina Nouă',1739 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2370,3,'COMMUNE',FALSE,'OT','Vitomireşti',2212 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2371,3,'COMMUNE',FALSE,'OT','Vlădila',1918 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2372,3,'COMMUNE',FALSE,'OT','Voineasa',2119 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2373,3,'COMMUNE',FALSE,'OT','Vulpeni',2162 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2374,3,'COMMUNE',FALSE,'OT','Vultureşti',2443,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2375,3,'COMMUNE',FALSE,'PH','Adunaţi',2190,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2376,3,'COMMUNE',FALSE,'PH','Albeşti-Paleologu',5918,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2377,3,'COMMUNE',FALSE,'PH','Aluniş',3713,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2378,3,'COMMUNE',FALSE,'PH','Apostolache',2312,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2379,3,'COMMUNE',FALSE,'PH','Ariceştii Rahtivani',8334,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2380,3,'COMMUNE',FALSE,'PH','Ariceştii Zeletin',1361,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2381,3,'COMMUNE',FALSE,'PH','Baba Ana',4325,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2382,3,'COMMUNE',FALSE,'PH','Balta Doamnei',2694,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2383,3,'COMMUNE',FALSE,'PH','Bălţeşti',3582,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2384,3,'COMMUNE',FALSE,'PH','Băneşti',5604,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2385,3,'COMMUNE',FALSE,'PH','Bărcăneşti',9464,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2386,3,'COMMUNE',FALSE,'PH','Bătrâni',2154,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2387,3,'COMMUNE',FALSE,'PH','Berceni',6105,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2388,3,'COMMUNE',FALSE,'PH','Bertea',3415,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2389,3,'COMMUNE',FALSE,'PH','Blejoi',8130,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2390,3,'COMMUNE',FALSE,'PH','Boldeşti-Gradiştea',1980,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2391,3,'COMMUNE',FALSE,'PH','Brazi',8293,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2392,3,'COMMUNE',FALSE,'PH','Brebu',7602,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2393,3,'COMMUNE',FALSE,'PH','Bucov',10755,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2394,3,'COMMUNE',FALSE,'PH','Călugăreni',1395,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2395,3,'COMMUNE',FALSE,'PH','Cărbuneşti',1890,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2396,3,'COMMUNE',FALSE,'PH','Ceptura',5100,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2397,3,'COMMUNE',FALSE,'PH','Ceraşu',5187,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2398,3,'COMMUNE',FALSE,'PH','Chiojdeanca',1840,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2399,3,'COMMUNE',FALSE,'PH','Ciorani',7103,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2400,3,'COMMUNE',FALSE,'PH','Cocorăştii Mislii',3457,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2401,3,'COMMUNE',FALSE,'PH','Cocorăştii Colţ',3152,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2402,3,'COMMUNE',FALSE,'PH','Colceag',5309,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2403,3,'COMMUNE',FALSE,'PH','Cornu',4469,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2404,3,'COMMUNE',FALSE,'PH','Cosminele',1179,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2405,3,'COMMUNE',FALSE,'PH','Drăgăneşti',5068,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2406,3,'COMMUNE',FALSE,'PH','Drajna',5686,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2407,3,'COMMUNE',FALSE,'PH','Dumbrava',4499,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2408,3,'COMMUNE',FALSE,'PH','Dumbrăveşti',3737,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2409,3,'COMMUNE',FALSE,'PH','Filipeştii de Pădure',10302,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2410,3,'COMMUNE',FALSE,'PH','Filipeştii de Târg',8146,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2411,3,'COMMUNE',FALSE,'PH','Fântânele',2294,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2412,3,'COMMUNE',FALSE,'PH','Floreşti',7610,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2413,3,'COMMUNE',FALSE,'PH','Fulga',3736,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2414,3,'COMMUNE',FALSE,'PH','Gherghiţa',1926,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2415,3,'COMMUNE',FALSE,'PH','Gorgota',5414,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2416,3,'COMMUNE',FALSE,'PH','Gornet',3125,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2417,3,'COMMUNE',FALSE,'PH','Gornet-Cricov',2536,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2418,3,'COMMUNE',FALSE,'PH','Gura Vadului',2469,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2419,3,'COMMUNE',FALSE,'PH','Gura Vitioarei',6131,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2420,3,'COMMUNE',FALSE,'PH','Iordăcheanu',5410,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2421,3,'COMMUNE',FALSE,'PH','Izvoarele',6866,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2422,3,'COMMUNE',FALSE,'PH','Jugureni',636,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2423,3,'COMMUNE',FALSE,'PH','Lapoş',1404,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2424,3,'COMMUNE',FALSE,'PH','Lipăneşti',5227,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2425,3,'COMMUNE',FALSE,'PH','Măgurele',4877,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2426,3,'COMMUNE',FALSE,'PH','Măgureni',6598,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2427,3,'COMMUNE',FALSE,'PH','Măneciu',11158,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2428,3,'COMMUNE',FALSE,'PH','Măneşti',4098,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2429,3,'COMMUNE',FALSE,'PH','Olari',2129,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2430,3,'COMMUNE',FALSE,'PH','Păcureţi',2346,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2431,3,'COMMUNE',FALSE,'PH','Păuleşti',5233,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2432,3,'COMMUNE',FALSE,'PH','Plopu',2381,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2433,3,'COMMUNE',FALSE,'PH','Podenii Noi',4715,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2434,3,'COMMUNE',FALSE,'PH','Poiana Câmpina',5286,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2435,3,'COMMUNE',FALSE,'PH','Poienarii Burchii',5431,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2436,3,'COMMUNE',FALSE,'PH','Poseşti',4103,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2437,3,'COMMUNE',FALSE,'PH','Predeal-Sărari',2597,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2438,3,'COMMUNE',FALSE,'PH','Proviţa de Jos',2454,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2439,3,'COMMUNE',FALSE,'PH','Proviţa de Sus',2184,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2440,3,'COMMUNE',FALSE,'PH','Puchenii Mari',8834,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2441,3,'COMMUNE',FALSE,'PH','Râfov',5526,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2442,3,'COMMUNE',FALSE,'PH','Salcia',1198,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2443,3,'COMMUNE',FALSE,'PH','Sălciile',2082,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2444,3,'COMMUNE',FALSE,'PH','Scorţeni',6195,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2445,3,'COMMUNE',FALSE,'PH','Secăria',1310,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2446,3,'COMMUNE',FALSE,'PH','Sângeru',5507,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2447,3,'COMMUNE',FALSE,'PH','Şirna',5198,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2448,3,'COMMUNE',FALSE,'PH','Şoimari',3240,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2449,3,'COMMUNE',FALSE,'PH','Şotrile',3475,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2450,3,'COMMUNE',FALSE,'PH','Starchiojd',4484,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2451,3,'COMMUNE',FALSE,'PH','Ştefeşti',2478,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2452,3,'COMMUNE',FALSE,'PH','Surani',1850,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2453,3,'COMMUNE',FALSE,'PH','Talea',1152,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2454,3,'COMMUNE',FALSE,'PH','Tătaru',1170,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2455,3,'COMMUNE',FALSE,'PH','Teişani',3938,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2456,3,'COMMUNE',FALSE,'PH','Telega',6010,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2457,3,'COMMUNE',FALSE,'PH','Tinosu',2417,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2458,3,'COMMUNE',FALSE,'PH','Târgşoru Vechi',9137,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2459,3,'COMMUNE',FALSE,'PH','Tomşani',4635,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2460,3,'COMMUNE',FALSE,'PH','Vadu Săpat',1678,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2461,3,'COMMUNE',FALSE,'PH','Valea Călugărească',10467,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2462,3,'COMMUNE',FALSE,'PH','Valea Doftanei',6850,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2463,3,'COMMUNE',FALSE,'PH','Vărbilău',7301,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2464,3,'COMMUNE',FALSE,'PH','Vâlcăneşti',4037,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2465,3,'COMMUNE',FALSE,'SM','Acâş',2792 ,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2466,3,'COMMUNE',FALSE,'SM','Agriş',1975,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2467,3,'COMMUNE',FALSE,'SM','Andrid',2451,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2468,3,'COMMUNE',FALSE,'SM','Apa',2575 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2469,3,'COMMUNE',FALSE,'SM','Bătarci',3612 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2470,3,'COMMUNE',FALSE,'SM','Beltiug',3147,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2471,3,'COMMUNE',FALSE,'SM','Berveni',3331 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2472,3,'COMMUNE',FALSE,'SM','Bixad',6340 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2473,3,'COMMUNE',FALSE,'SM','Bârsău',2424 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2474,3,'COMMUNE',FALSE,'SM','Bogdand',2865 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2475,3,'COMMUNE',FALSE,'SM','Botiz',3526 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2476,3,'COMMUNE',FALSE,'SM','Călineşti-Oaş',4686,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2477,3,'COMMUNE',FALSE,'SM','Cămărzana',2304 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2478,3,'COMMUNE',FALSE,'SM','Cămin',1406,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2479,3,'COMMUNE',FALSE,'SM','Căpleni',3027 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2480,3,'COMMUNE',FALSE,'SM','Căuaş',2350 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2481,3,'COMMUNE',FALSE,'SM','Cehal',1573,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2482,3,'COMMUNE',FALSE,'SM','Certeze',5560,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2483,3,'COMMUNE',FALSE,'SM','Craidorolţ',2150,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2484,3,'COMMUNE',FALSE,'SM','Crucişor',2513 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2485,3,'COMMUNE',FALSE,'SM','Culciu',3751,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2486,3,'COMMUNE',FALSE,'SM','Doba',2697 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2487,3,'COMMUNE',FALSE,'SM','Dorolţ',3760 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2488,3,'COMMUNE',FALSE,'SM','Foieni',1836 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2489,3,'COMMUNE',FALSE,'SM','Gherţa Mică',3299 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2490,3,'COMMUNE',FALSE,'SM','Halmeu',4845 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2491,3,'COMMUNE',FALSE,'SM','Hodod',3047 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2492,3,'COMMUNE',FALSE,'SM','Homoroade',1735 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2493,3,'COMMUNE',FALSE,'SM','Lazuri',5373 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2494,3,'COMMUNE',FALSE,'SM','Medieşu Aurit',6526 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2495,3,'COMMUNE',FALSE,'SM','Micula',3424 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2496,3,'COMMUNE',FALSE,'SM','Moftin',4205 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2497,3,'COMMUNE',FALSE,'SM','Odoreu',4817 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2498,3,'COMMUNE',FALSE,'SM','Oraşu Nou',3754 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2499,3,'COMMUNE',FALSE,'SM','Păuleşti',4739,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2500,3,'COMMUNE',FALSE,'SM','Petreşti',1572 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2501,3,'COMMUNE',FALSE,'SM','Pir',1610 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2502,3,'COMMUNE',FALSE,'SM','Pişcolt',3099 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2503,3,'COMMUNE',FALSE,'SM','Pomi',2126 ,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2504,3,'COMMUNE',FALSE,'SM','Porumbeşti',2516,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2505,3,'COMMUNE',FALSE,'SM','Racşa',3013 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2506,3,'COMMUNE',FALSE,'SM','Sanislău',3456,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2507,3,'COMMUNE',FALSE,'SM','Santău',2353,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2508,3,'COMMUNE',FALSE,'SM','Săcăşeni',1161 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2509,3,'COMMUNE',FALSE,'SM','Săuca',1342 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2510,3,'COMMUNE',FALSE,'SM','Socond',2543 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2511,3,'COMMUNE',FALSE,'SM','Supur',4187 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2512,3,'COMMUNE',FALSE,'SM','Tarna Mare',3679 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2513,3,'COMMUNE',FALSE,'SM','Terebeşti',1713,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2514,3,'COMMUNE',FALSE,'SM','Tiream',2144 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2515,3,'COMMUNE',FALSE,'SM','Târşolţ',3027 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2516,3,'COMMUNE',FALSE,'SM','Turţ	',5307 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2517,3,'COMMUNE',FALSE,'SM','Turulung',3587,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2518,3,'COMMUNE',FALSE,'SM','Urziceni',1450 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2519,3,'COMMUNE',FALSE,'SM','Valea Vinului',2029 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2520,3,'COMMUNE',FALSE,'SM','Vama',3358 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2521,3,'COMMUNE',FALSE,'SM','Vetiş',4637 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2522,3,'COMMUNE',FALSE,'SM','Viile Satu Mare',3405 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2523,3,'COMMUNE',FALSE,'SJ','Agrij',1410,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2524,3,'COMMUNE',FALSE,'SJ','Almaşu',2451,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2525,3,'COMMUNE',FALSE,'SJ','Băbeni',1892,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2526,3,'COMMUNE',FALSE,'SJ','Bălan',3978,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2527,3,'COMMUNE',FALSE,'SJ','Bănişor',2315,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2528,3,'COMMUNE',FALSE,'SJ','Benesat',1626,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2529,3,'COMMUNE',FALSE,'SJ','Bobota',3940,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2530,3,'COMMUNE',FALSE,'SJ','Bocşa',3492,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2531,3,'COMMUNE',FALSE,'SJ','Boghiş',1892,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2532,3,'COMMUNE',FALSE,'SJ','Buciumi',2630,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2533,3,'COMMUNE',FALSE,'SJ','Camăr',1761,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2534,3,'COMMUNE',FALSE,'SJ','Carastelec',1061,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2535,3,'COMMUNE',FALSE,'SJ','Chieşd',2597,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2536,3,'COMMUNE',FALSE,'SJ','Cizer',2441,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2537,3,'COMMUNE',FALSE,'SJ','Coşeiu',1266,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2538,3,'COMMUNE',FALSE,'SJ','Crasna',6433,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2539,3,'COMMUNE',FALSE,'SJ','Creaca',2890,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2540,3,'COMMUNE',FALSE,'SJ','Crişeni',2527,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2541,3,'COMMUNE',FALSE,'SJ','Cristolţ',1458,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2542,3,'COMMUNE',FALSE,'SJ','Cuzăplac',1851,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2543,3,'COMMUNE',FALSE,'SJ','Dobrin',1733,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2544,3,'COMMUNE',FALSE,'SJ','Dragu',1373,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2545,3,'COMMUNE',FALSE,'SJ','Fildu de Jos',1353,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2546,3,'COMMUNE',FALSE,'SJ','Gâlgău',2567,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2547,3,'COMMUNE',FALSE,'SJ','Gârbou',2264,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2548,3,'COMMUNE',FALSE,'SJ','Halmăşd',2488,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2549,3,'COMMUNE',FALSE,'SJ','Hereclean',3596,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2550,3,'COMMUNE',FALSE,'SJ','Hida',2966,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2551,3,'COMMUNE',FALSE,'SJ','Horoatu Crasnei',2735,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2552,3,'COMMUNE',FALSE,'SJ','Ileanda',2391,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2553,3,'COMMUNE',FALSE,'SJ','Ip',3847,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2554,3,'COMMUNE',FALSE,'SJ','Letca',2103,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2555,3,'COMMUNE',FALSE,'SJ','Lozna',1060,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2556,3,'COMMUNE',FALSE,'SJ','Măerişte',3225,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2557,3,'COMMUNE',FALSE,'SJ','Marca',2772,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2558,3,'COMMUNE',FALSE,'SJ','Meseşenii de Jos',130,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2559,3,'COMMUNE',FALSE,'SJ','Mirşid',2242,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2560,3,'COMMUNE',FALSE,'SJ','Năpradea',2934,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2561,3,'COMMUNE',FALSE,'SJ','Nuşfalău',3757,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2562,3,'COMMUNE',FALSE,'SJ','Pericei',3979,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2563,3,'COMMUNE',FALSE,'SJ','Plopiş',2585,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2564,3,'COMMUNE',FALSE,'SJ','Poiana Blenchii',1266,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2565,3,'COMMUNE',FALSE,'SJ','Românaşi',2958,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2566,3,'COMMUNE',FALSE,'SJ','Rus',1142,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2567,3,'COMMUNE',FALSE,'SJ','Sălăţig',3038,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2568,3,'COMMUNE',FALSE,'SJ','Sâg',3462,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2569,3,'COMMUNE',FALSE,'SJ','Sânmihaiu Almaşului',1777,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2570,3,'COMMUNE',FALSE,'SJ','Someş-Odorhei',2937,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2571,3,'COMMUNE',FALSE,'SJ','Surduc',3835,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2572,3,'COMMUNE',FALSE,'SJ','Şamşud',1795,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2573,3,'COMMUNE',FALSE,'SJ','Sărmăşag',6502,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2574,3,'COMMUNE',FALSE,'SJ','Şimişna',1305,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2575,3,'COMMUNE',FALSE,'SJ','Treznea',993,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2576,3,'COMMUNE',FALSE,'SJ','Valcău de Jos',3283,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2577,3,'COMMUNE',FALSE,'SJ','Vârşolţ',2390,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2578,3,'COMMUNE',FALSE,'SJ','Zalha',1011,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2579,3,'COMMUNE',FALSE,'SJ','Zimbor',1135,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2580,3,'COMMUNE',FALSE,'SB','Alma',2050,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2581,3,'COMMUNE',FALSE,'SB','Alţâna',1677,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2582,3,'COMMUNE',FALSE,'SB','Apoldu de Jos',1499,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2583,3,'COMMUNE',FALSE,'SB','Arpaşu de Jos',2753,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2584,3,'COMMUNE',FALSE,'SB','Aţel',1560,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2585,3,'COMMUNE',FALSE,'SB','Axente Sever',4095,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2586,3,'COMMUNE',FALSE,'SB','Bazna',4058,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2587,3,'COMMUNE',FALSE,'SB','Bârghiş',2130,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2588,3,'COMMUNE',FALSE,'SB','Biertan',2898,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2589,3,'COMMUNE',FALSE,'SB','Blăjel',2363,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2590,3,'COMMUNE',FALSE,'SB','Boiţa',1683,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2591,3,'COMMUNE',FALSE,'SB','Brateiu',3602,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2592,3,'COMMUNE',FALSE,'SB','Brădeni',1419,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2593,3,'COMMUNE',FALSE,'SB','Bruiu',736,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2594,3,'COMMUNE',FALSE,'SB','Chirpăr',1533,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2595,3,'COMMUNE',FALSE,'SB','Cârţa',884,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2596,3,'COMMUNE',FALSE,'SB','Cârţişoara',1201,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2597,3,'COMMUNE',FALSE,'SB','Cristian',3955,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2598,3,'COMMUNE',FALSE,'SB','Dârlos',3423,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2599,3,'COMMUNE',FALSE,'SB','Gura Râului',3641,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2600,3,'COMMUNE',FALSE,'SB','Hoghilag',2353,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2601,3,'COMMUNE',FALSE,'SB','Iacobeni',2616,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2602,3,'COMMUNE',FALSE,'SB','Jina',4159,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2603,3,'COMMUNE',FALSE,'SB','Laslea',3241,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2604,3,'COMMUNE',FALSE,'SB','Loamneş',3145,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2605,3,'COMMUNE',FALSE,'SB','Ludoş',775,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2606,3,'COMMUNE',FALSE,'SB','Marpod',851,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2607,3,'COMMUNE',FALSE,'SB','Merghindeal',1277,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2608,3,'COMMUNE',FALSE,'SB','Micăsasa',2270,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2609,3,'COMMUNE',FALSE,'SB','Mihăileni',932,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2610,3,'COMMUNE',FALSE,'SB','Moşna',3419,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2611,3,'COMMUNE',FALSE,'SB','Nocrich',2822,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2612,3,'COMMUNE',FALSE,'SB','Orlat',3153,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2613,3,'COMMUNE',FALSE,'SB','Păuca',2011,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2614,3,'COMMUNE',FALSE,'SB','Poiana Sibiului',2661,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2615,3,'COMMUNE',FALSE,'SB','Poplaca',1729,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2616,3,'COMMUNE',FALSE,'SB','Porumbacu de Jos',3118,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2617,3,'COMMUNE',FALSE,'SB','Racoviţa',2974,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2618,3,'COMMUNE',FALSE,'SB','Răşinari',5648,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2619,3,'COMMUNE',FALSE,'SB','Râu Sadului',620,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2620,3,'COMMUNE',FALSE,'SB','Roşia',5035,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2621,3,'COMMUNE',FALSE,'SB','Sadu',2431,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2622,3,'COMMUNE',FALSE,'SB','Slimnic',3656,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2623,3,'COMMUNE',FALSE,'SB','Şeica Mare',4914,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2624,3,'COMMUNE',FALSE,'SB','Şeica Mică',1726,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2625,3,'COMMUNE',FALSE,'SB','Şelimbăr',5399,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2626,3,'COMMUNE',FALSE,'SB','Şura Mare',3616,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2627,3,'COMMUNE',FALSE,'SB','Şura Mică',2456,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2628,3,'COMMUNE',FALSE,'SB','Târnava',3187,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2629,3,'COMMUNE',FALSE,'SB','Tilişca',1584,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2630,3,'COMMUNE',FALSE,'SB','Turnu Roşu',2670,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2631,3,'COMMUNE',FALSE,'SB','Valea Viilor',2127,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2632,3,'COMMUNE',FALSE,'SB','Vurpăr',2447,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2633,3,'COMMUNE',FALSE,'SV','Adâncata',3938 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2634,3,'COMMUNE',FALSE,'SV','Arbore',6609 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2635,3,'COMMUNE',FALSE,'SV','Baia',6179 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2636,3,'COMMUNE',FALSE,'SV','Bălăceana',1507,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2637,3,'COMMUNE',FALSE,'SV','Bălcăuţi',3044 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2638,3,'COMMUNE',FALSE,'SV','Berchişeşti',2827 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2639,3,'COMMUNE',FALSE,'SV','Bilca',3550 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2640,3,'COMMUNE',FALSE,'SV','Bogdăneşti',3850,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2641,3,'COMMUNE',FALSE,'SV','Boroaia',4525 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2642,3,'COMMUNE',FALSE,'SV','Bosanci',6486 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2643,3,'COMMUNE',FALSE,'SV','Botoşana',2127 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2644,3,'COMMUNE',FALSE,'SV','Breaza',1500 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2645,3,'COMMUNE',FALSE,'SV','Brodina',3273 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2646,3,'COMMUNE',FALSE,'SV','Buneşti',2302,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2647,3,'COMMUNE',FALSE,'SV','Burla',2084 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2648,3,'COMMUNE',FALSE,'SV','Cacica',3672 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2649,3,'COMMUNE',FALSE,'SV','Calafindeşti',2541 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2650,3,'COMMUNE',FALSE,'SV','Capu Câmpului',2177,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2651,3,'COMMUNE',FALSE,'SV','Cârlibaba',1701 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2652,3,'COMMUNE',FALSE,'SV','Ciocăneşti',1373 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2653,3,'COMMUNE',FALSE,'SV','Ciprian Porumbescu',1784 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2654,3,'COMMUNE',FALSE,'SV','Comăneşti',2063 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2655,3,'COMMUNE',FALSE,'SV','Cornu Luncii',6481 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2656,3,'COMMUNE',FALSE,'SV','Coşna',1447 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2657,3,'COMMUNE',FALSE,'SV','Crucea',1788,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2658,3,'COMMUNE',FALSE,'SV','Dărmăneşti',5067 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2659,3,'COMMUNE',FALSE,'SV','Dolheşti',3453 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2660,3,'COMMUNE',FALSE,'SV','Dorna-Arini',2817 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2661,3,'COMMUNE',FALSE,'SV','Dorna Candrenilor',2810,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2662,3,'COMMUNE',FALSE,'SV','Dorneşti',3791 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2663,3,'COMMUNE',FALSE,'SV','Drăgoieşti',2299 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2664,3,'COMMUNE',FALSE,'SV','Drăguşeni',2383 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2665,3,'COMMUNE',FALSE,'SV','Dumbrăveni',7170 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2666,3,'COMMUNE',FALSE,'SV','Fântâna Mare',2178,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2667,3,'COMMUNE',FALSE,'SV','Fântânele',4790 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2668,3,'COMMUNE',FALSE,'SV','Forăşti',4356 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2669,3,'COMMUNE',FALSE,'SV','Frătăuţii Noi',5572 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2670,3,'COMMUNE',FALSE,'SV','Frătăuţii Vechi',4315 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2671,3,'COMMUNE',FALSE,'SV','Frumosu',3207 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2672,3,'COMMUNE',FALSE,'SV','Fundu Moldovei',3547 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2673,3,'COMMUNE',FALSE,'SV','Gălăneşti',2535 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2674,3,'COMMUNE',FALSE,'SV','Grămeşti',3010,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2675,3,'COMMUNE',FALSE,'SV','Grăniceşti',4335 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2676,3,'COMMUNE',FALSE,'SV','Hănţeşti',3544 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2677,3,'COMMUNE',FALSE,'SV','Hârtop',2234 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2678,3,'COMMUNE',FALSE,'SV','Horodnic de Jos',1979 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2679,3,'COMMUNE',FALSE,'SV','Horodnic de Sus',5029 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2680,3,'COMMUNE',FALSE,'SV','Horodniceni',3183 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2681,3,'COMMUNE',FALSE,'SV','Iacobeni',1807 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2682,3,'COMMUNE',FALSE,'SV','Iaslovăţ',3105 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2683,3,'COMMUNE',FALSE,'SV','Ilişeşti',2711 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2684,3,'COMMUNE',FALSE,'SV','Ipoteşti',5503,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2685,3,'COMMUNE',FALSE,'SV','Izvoarele Sucevei',2036 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2686,3,'COMMUNE',FALSE,'SV','Mălini',6147 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2687,3,'COMMUNE',FALSE,'SV','Mănăstirea Humorului',3198 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2688,3,'COMMUNE',FALSE,'SV','Marginea',8376 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2689,3,'COMMUNE',FALSE,'SV','Mitocu Dragomirnei',4179 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2690,3,'COMMUNE',FALSE,'SV','Moara',4229 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2691,3,'COMMUNE',FALSE,'SV','Moldova-Suliţa',1837 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2692,3,'COMMUNE',FALSE,'SV','Moldoviţa',4894 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2693,3,'COMMUNE',FALSE,'SV','Muşeniţa',1847 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2694,3,'COMMUNE',FALSE,'SV','Ostra',2965 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2695,3,'COMMUNE',FALSE,'SV','Păltinoasa',4820 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2696,3,'COMMUNE',FALSE,'SV','Panaci',2149 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2697,3,'COMMUNE',FALSE,'SV','Pârteştii de Jos',2749 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2698,3,'COMMUNE',FALSE,'SV','Pătrăuţi',4414 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2699,3,'COMMUNE',FALSE,'SV','Poiana Stampei',2036 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2700,3,'COMMUNE',FALSE,'SV','Poieni-Solca',1616 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2701,3,'COMMUNE',FALSE,'SV','Pojorâta',2879 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2702,3,'COMMUNE',FALSE,'SV','Preuteşti',6553,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2703,3,'COMMUNE',FALSE,'SV','Putna',3511 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2704,3,'COMMUNE',FALSE,'SV','Rădăşeni',3524 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2705,3,'COMMUNE',FALSE,'SV','Râşca',5006 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2706,3,'COMMUNE',FALSE,'SV','Sadova',2267 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2707,3,'COMMUNE',FALSE,'SV','Şaru Dornei',3910 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2708,3,'COMMUNE',FALSE,'SV','Satu Mare',3544 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2709,3,'COMMUNE',FALSE,'SV','Scheia',9203 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2710,3,'COMMUNE',FALSE,'SV','Serbăuţi',2793 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2711,3,'COMMUNE',FALSE,'SV','Siminicea',2673 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2712,3,'COMMUNE',FALSE,'SV','Slatina',4677 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2713,3,'COMMUNE',FALSE,'SV','Straja',5029 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2714,3,'COMMUNE',FALSE,'SV','Stroieşti',3262 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2715,3,'COMMUNE',FALSE,'SV','Stulpicani',5845 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2716,3,'COMMUNE',FALSE,'SV','Suceviţa',2659 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2717,3,'COMMUNE',FALSE,'SV','Todireşti',5180 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2718,3,'COMMUNE',FALSE,'SV','Udeşti',7404 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2719,3,'COMMUNE',FALSE,'SV','Ulma',1986 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2720,3,'COMMUNE',FALSE,'SV','Vadu Moldovei',3922 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2721,3,'COMMUNE',FALSE,'SV','Valea Moldovei',3727 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2722,3,'COMMUNE',FALSE,'SV','Vama',5307 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2723,3,'COMMUNE',FALSE,'SV','Vatra Moldoviţei',4057 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2724,3,'COMMUNE',FALSE,'SV','Vereşti',6126,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2725,3,'COMMUNE',FALSE,'SV','Vicovu de Jos',5853 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2726,3,'COMMUNE',FALSE,'SV','Voitinel',4239 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2727,3,'COMMUNE',FALSE,'SV','Volovăţ',4858 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2728,3,'COMMUNE',FALSE,'SV','Vultureşti',3309,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2729,3,'COMMUNE',FALSE,'SV','Zamostea',2804 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2730,3,'COMMUNE',FALSE,'SB','Zvoriştea',6018 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2731,3,'COMMUNE',FALSE,'TR','Băbăiţa',2957 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2732,3,'COMMUNE',FALSE,'TR','Balaci',1974 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2733,3,'COMMUNE',FALSE,'TR','Beciu',1580 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2734,3,'COMMUNE',FALSE,'TR','Beuca',1342 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2735,3,'COMMUNE',FALSE,'TR','Blejeşti',3809 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2736,3,'COMMUNE',FALSE,'TR','Bogdana',2440,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2737,3,'COMMUNE',FALSE,'TR','Botoroaga',5734 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2738,3,'COMMUNE',FALSE,'TR','Bragadiru',3845,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2739,3,'COMMUNE',FALSE,'TR','Brânceni',2822 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2740,3,'COMMUNE',FALSE,'TR','Bujoreni',1048 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2741,3,'COMMUNE',FALSE,'TR','Bujoru',1936 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2742,3,'COMMUNE',FALSE,'TR','Buzescu',3746 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2743,3,'COMMUNE',FALSE,'TR','Călineşti',3362 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2744,3,'COMMUNE',FALSE,'TR','Călmăţuiu',2128 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2745,3,'COMMUNE',FALSE,'TR','Călmăţuiu de Sus',2282,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2746,3,'COMMUNE',FALSE,'TR','Cervenia',2203 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2747,3,'COMMUNE',FALSE,'TR','Ciolăneşti',3091,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2748,3,'COMMUNE',FALSE,'TR','Ciuperceni',1510,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2749,3,'COMMUNE',FALSE,'TR','Conţeşti',3353 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2750,3,'COMMUNE',FALSE,'TR','Cosmeşti',2309 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2751,3,'COMMUNE',FALSE,'TR','Crângu',1390 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2752,3,'COMMUNE',FALSE,'TR','Crevenicu',1552 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2753,3,'COMMUNE',FALSE,'TR','Crângeni',2709 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2754,3,'COMMUNE',FALSE,'TR','Dideşti',1281 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2755,3,'COMMUNE',FALSE,'TR','Dobroteşti',4437 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2756,3,'COMMUNE',FALSE,'TR','Dracea',1265 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2757,3,'COMMUNE',FALSE,'TR','Drăcşenei',1769 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2758,3,'COMMUNE',FALSE,'TR','Drăgăneşti de Vede',2069 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2759,3,'COMMUNE',FALSE,'TR','Drăgăneşti-Vlaşca',4086 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2760,3,'COMMUNE',FALSE,'TR','Fântânele',1684 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2761,3,'COMMUNE',FALSE,'TR','Frăsinet',2551 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2762,3,'COMMUNE',FALSE,'TR','Frumoasa',2165 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2763,3,'COMMUNE',FALSE,'TR','Furculeşti',2898 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2764,3,'COMMUNE',FALSE,'TR','Gălăteni',2856 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2765,3,'COMMUNE',FALSE,'TR','Gratia',2963 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2766,3,'COMMUNE',FALSE,'TR','Islaz',5127 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2767,3,'COMMUNE',FALSE,'TR','Izvoarele',2530 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2768,3,'COMMUNE',FALSE,'TR','Lisa',1971 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2769,3,'COMMUNE',FALSE,'TR','Liţa',2468,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2770,3,'COMMUNE',FALSE,'TR','Lunca',3146 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2771,3,'COMMUNE',FALSE,'TR','Măgura',2711 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2772,3,'COMMUNE',FALSE,'TR','Măldăeni',4036 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2773,3,'COMMUNE',FALSE,'TR','Mârzăneşti',3703 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2774,3,'COMMUNE',FALSE,'TR','Mavrodin',2670 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2775,3,'COMMUNE',FALSE,'TR','Mereni',2942 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2776,3,'COMMUNE',FALSE,'TR','Moşteni',1604,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2777,3,'COMMUNE',FALSE,'TR','Nanov',3442 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2778,3,'COMMUNE',FALSE,'TR','Năsturelu',2501 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2779,3,'COMMUNE',FALSE,'TR','Necşeşti',1255 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2780,3,'COMMUNE',FALSE,'TR','Nenciuleşti',2431 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2781,3,'COMMUNE',FALSE,'TR','Olteni',3059 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2782,3,'COMMUNE',FALSE,'TR','Orbeasca',7274 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2783,3,'COMMUNE',FALSE,'TR','Peretu',6196,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2784,3,'COMMUNE',FALSE,'TR','Piatra',3268 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2785,3,'COMMUNE',FALSE,'TR','Pietroşani',2756 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2786,3,'COMMUNE',FALSE,'TR','Plopii-Slăviteşti',2446 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2787,3,'COMMUNE',FALSE,'TR','Plosca',5675 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2788,3,'COMMUNE',FALSE,'TR','Poeni',3100 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2789,3,'COMMUNE',FALSE,'TR','Poroschia',4026 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2790,3,'COMMUNE',FALSE,'TR','Purani',1502 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2791,3,'COMMUNE',FALSE,'TR','Putineiu',2293 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2792,3,'COMMUNE',FALSE,'TR','Rădoieşti',2130 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2793,3,'COMMUNE',FALSE,'TR','Răsmireşti',968 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2794,3,'COMMUNE',FALSE,'TR','Săceni',1314,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2795,3,'COMMUNE',FALSE,'TR','Saelele',2228 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2796,3,'COMMUNE',FALSE,'TR','Salcia',2495 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2797,3,'COMMUNE',FALSE,'TR','Sârbeni',1593 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2798,3,'COMMUNE',FALSE,'TR','Scrioaştea',3584 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2799,3,'COMMUNE',FALSE,'TR','Scurtu Mare',1755,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2800,3,'COMMUNE',FALSE,'TR','Seaca',2138 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2801,3,'COMMUNE',FALSE,'TR','Segarcea-Vale',3060 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2802,3,'COMMUNE',FALSE,'TR','Sfinţeşti',1119 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2803,3,'COMMUNE',FALSE,'TR','Siliştea',2485 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2804,3,'COMMUNE',FALSE,'TR','Siliştea Gumeşti',2590 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2805,3,'COMMUNE',FALSE,'TR','Slobozia Mândra',1778 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2806,3,'COMMUNE',FALSE,'TR','Smârdioasa',2177 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2807,3,'COMMUNE',FALSE,'TR','Stejaru',1895,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2808,3,'COMMUNE',FALSE,'TR','Ştorobăneasa',3015 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2809,3,'COMMUNE',FALSE,'TR','Suhaia',2244 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2810,3,'COMMUNE',FALSE,'TR','Talpa',1884 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2811,3,'COMMUNE',FALSE,'TR','Tătărăştii de Jos',3638 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2812,3,'COMMUNE',FALSE,'TR','Tătărăştii de Sus',3095 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2813,3,'COMMUNE',FALSE,'TR','Ţigăneşti',4167,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2814,3,'COMMUNE',FALSE,'TR','Traian',1825 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2815,3,'COMMUNE',FALSE,'TR','Trivalea-Moşteni',2814 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2816,3,'COMMUNE',FALSE,'TR','Troianul',2984 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2817,3,'COMMUNE',FALSE,'TR','Uda-Clocociov',1506 ,null);												
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2818,3,'COMMUNE',FALSE,'TR','Vârtoape',3094 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2819,3,'COMMUNE',FALSE,'TR','Vedea',3620 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2820,3,'COMMUNE',FALSE,'TR','Viişoara',1880 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2821,3,'COMMUNE',FALSE,'TR','Vităneşti',2817 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2822,3,'COMMUNE',FALSE,'TR','Zâmbreasca',1493 ,null);						
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2823,3,'COMMUNE',FALSE,'TM','Balinţ',1538,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2824,3,'COMMUNE',FALSE,'TM','Banloc',2520,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2825,3,'COMMUNE',FALSE,'TM','Bara',392,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2826,3,'COMMUNE',FALSE,'TM','Bârna',1604,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2827,3,'COMMUNE',FALSE,'TM','Beba Veche',1500,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2828,3,'COMMUNE',FALSE,'TM','Becicherecu Mic',2651,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2829,3,'COMMUNE',FALSE,'TM','Belinţ',2725,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2830,3,'COMMUNE',FALSE,'TM','Bethausen',3007,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2831,3,'COMMUNE',FALSE,'TM','Biled',3101,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2832,3,'COMMUNE',FALSE,'TM','Birda',1757,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2833,3,'COMMUNE',FALSE,'TM','Bogda',446,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2834,3,'COMMUNE',FALSE,'TM','Boldur',2350,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2835,3,'COMMUNE',FALSE,'TM','Brestovăţ',652,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2836,3,'COMMUNE',FALSE,'TM','Bucovăţ',1511,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2837,3,'COMMUNE',FALSE,'TM','Cărpiniş',4140,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2838,3,'COMMUNE',FALSE,'TM','Cenad',4042,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2839,3,'COMMUNE',FALSE,'TM','Cenei',2537,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2840,3,'COMMUNE',FALSE,'TM','Checea',1736,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2841,3,'COMMUNE',FALSE,'TM','Chevereşu Mare',2133,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2842,3,'COMMUNE',FALSE,'TM','Comloşu Mare',4572,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2843,3,'COMMUNE',FALSE,'TM','Coşteiu',3422,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2844,3,'COMMUNE',FALSE,'TM','Criciova',1511,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2845,3,'COMMUNE',FALSE,'TM','Curtea',1177,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2846,3,'COMMUNE',FALSE,'TM','Darova',2953,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2847,3,'COMMUNE',FALSE,'TM','Denta',2870,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2848,3,'COMMUNE',FALSE,'TM','Dudeştii Noi',3048,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2849,3,'COMMUNE',FALSE,'TM','Dudeştii Vechi',4009,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2850,3,'COMMUNE',FALSE,'TM','Dumbrava',2581,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2851,3,'COMMUNE',FALSE,'TM','Dumbrăviţa',7241,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2852,3,'COMMUNE',FALSE,'TM','Fârdea',1697,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2853,3,'COMMUNE',FALSE,'TM','Fibiş',1542,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2854,3,'COMMUNE',FALSE,'TM','Foeni',1676,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2855,3,'COMMUNE',FALSE,'TM','Gavojdia',2948,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2856,3,'COMMUNE',FALSE,'TM','Ghilad',2020,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2857,3,'COMMUNE',FALSE,'TM','Ghiroda',5968,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2858,3,'COMMUNE',FALSE,'TM','Ghizela',1117,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2859,3,'COMMUNE',FALSE,'TM','Giarmata',6009,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2860,3,'COMMUNE',FALSE,'TM','Giera',1203,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2861,3,'COMMUNE',FALSE,'TM','Giroc',8122,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2862,3,'COMMUNE',FALSE,'TM','Giulvăz',2925,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2863,3,'COMMUNE',FALSE,'TM','Gottlob',1983,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2864,3,'COMMUNE',FALSE,'TM','Iecea Mare',2036,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2865,3,'COMMUNE',FALSE,'TM','Jamu Mare',2881,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2866,3,'COMMUNE',FALSE,'TM','Jebel',3468,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2867,3,'COMMUNE',FALSE,'TM','Lenauheim',4787,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2868,3,'COMMUNE',FALSE,'TM','Liebling	',3586,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2869,3,'COMMUNE',FALSE,'TM','Livezile',1525,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2870,3,'COMMUNE',FALSE,'TM','Lovrin', 3119,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2871,3,'COMMUNE',FALSE,'TM','Margina',2135,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2872,3,'COMMUNE',FALSE,'TM','Maşloc', 2151,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2873,3,'COMMUNE',FALSE,'TM','Mănăştiur',1573,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2874,3,'COMMUNE',FALSE,'TM','Moraviţa',2192,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2875,3,'COMMUNE',FALSE,'TM','Moşniţa Nouă',5810,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2876,3,'COMMUNE',FALSE,'TM','Nădrag',2760,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2877,3,'COMMUNE',FALSE,'TM','Niţchidorf',1453,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2878,3,'COMMUNE',FALSE,'TM','Ohaba Lungă',1049,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2879,3,'COMMUNE',FALSE,'TM','Orţişoara',3994,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2880,3,'COMMUNE',FALSE,'TM','Otelec',1441,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2881,3,'COMMUNE',FALSE,'TM','Parţa',2129,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2882,3,'COMMUNE',FALSE,'TM','Pădureni',1886,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2883,3,'COMMUNE',FALSE,'TM','Peciu Nou',4807,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2884,3,'COMMUNE',FALSE,'TM','Periam',4346,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2885,3,'COMMUNE',FALSE,'TM','Pesac',1918,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2886,3,'COMMUNE',FALSE,'TM','Pietroasa',1099,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2887,3,'COMMUNE',FALSE,'TM','Pişchia',2958,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2888,3,'COMMUNE',FALSE,'TM','Racoviţa', 3047,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2889,3,'COMMUNE',FALSE,'TM','Remetea Mare',2168,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2890,3,'COMMUNE',FALSE,'TM','Sacoşu Turcesc',3065,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2891,3,'COMMUNE',FALSE,'TM','Saravale',2479,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2892,3,'COMMUNE',FALSE,'TM','Satchinez',4500,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2893,3,'COMMUNE',FALSE,'TM','Săcălaz',6731,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2894,3,'COMMUNE',FALSE,'TM','Sânandrei',5279,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2895,3,'COMMUNE',FALSE,'TM','Sânmihaiu Român',5695,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2896,3,'COMMUNE',FALSE,'TM','Sânpetru Mare',3012,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2897,3,'COMMUNE',FALSE,'TM','Secaş',293,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2898,3,'COMMUNE',FALSE,'TM','Şag',2923,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2899,3,'COMMUNE',FALSE,'TM','Şandra',2805,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2900,3,'COMMUNE',FALSE,'TM','Ştiuca',1789,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2901,3,'COMMUNE',FALSE,'TM','Teremia Mare',3783,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2902,3,'COMMUNE',FALSE,'TM','Tomeşti', 2061,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2903,3,'COMMUNE',FALSE,'TM','Tomnatic',3011,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2904,3,'COMMUNE',FALSE,'TM','Topolovăţu Mare',2497,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2905,3,'COMMUNE',FALSE,'TM','Tormac',2603,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2906,3,'COMMUNE',FALSE,'TM','Traian Vuia',2009,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2907,3,'COMMUNE',FALSE,'TM','Uivar',2362,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2908,3,'COMMUNE',FALSE,'TM','Valcani',1321,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2909,3,'COMMUNE',FALSE,'TM','Variaş',5458,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2910,3,'COMMUNE',FALSE,'TM','Victor Vlad Delamarina',2521,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2911,3,'COMMUNE',FALSE,'TM','Voiteg',2412,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2912,3,'COMMUNE',FALSE,'TL','Baia',4813,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2913,3,'COMMUNE',FALSE,'TL','Beidaud',1624,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2914,3,'COMMUNE',FALSE,'TL','Beştepe',1991,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2915,3,'COMMUNE',FALSE,'TL','C.A. Rosetti',978,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2916,3,'COMMUNE',FALSE,'TL','Carcaliu',3191,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2917,3,'COMMUNE',FALSE,'TL','Casimcea',3063,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2918,3,'COMMUNE',FALSE,'TL','Ceamurlia de Jos',2485,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2919,3,'COMMUNE',FALSE,'TL','Ceatalchioi',759,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2920,3,'COMMUNE',FALSE,'TL','Cerna',4094,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2921,3,'COMMUNE',FALSE,'TL','Chilia Veche',2496,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2922,3,'COMMUNE',FALSE,'TL','Ciucurova',2209,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2923,3,'COMMUNE',FALSE,'TL','Crişan',1321,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2924,3,'COMMUNE',FALSE,'TL','Dăeni',2267,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2925,3,'COMMUNE',FALSE,'TL','Dorobanţu',1596,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2926,3,'COMMUNE',FALSE,'TL','Frecăţei',3600,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2927,3,'COMMUNE',FALSE,'TL','Greci',5476,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2928,3,'COMMUNE',FALSE,'TL','Grindu',1544,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2929,3,'COMMUNE',FALSE,'TL','Hamcearca',1501,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2930,3,'COMMUNE',FALSE,'TL','Horia',1510,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2931,3,'COMMUNE',FALSE,'TL','I.C. Brătianu',1224,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2932,3,'COMMUNE',FALSE,'TL','Izvoarele',2136,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2933,3,'COMMUNE',FALSE,'TL','Jijila',5808,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2934,3,'COMMUNE',FALSE,'TL','Jurilovca',4976,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2935,3,'COMMUNE',FALSE,'TL','Luncaviţa',4612,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2936,3,'COMMUNE',FALSE,'TL','Mahmudia',2814,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2937,3,'COMMUNE',FALSE,'TL','Maliuc',1005,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2938,3,'COMMUNE',FALSE,'TL','Mihai Bravu',2538,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2939,3,'COMMUNE',FALSE,'TL','Mihail Kogălniceanu',3277,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2940,3,'COMMUNE',FALSE,'TL','Murighiol',3508,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2941,3,'COMMUNE',FALSE,'TL','Nalban',2814,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2942,3,'COMMUNE',FALSE,'TL','Niculiţel',4515,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2943,3,'COMMUNE',FALSE,'TL','Nufăru',2440,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2944,3,'COMMUNE',FALSE,'TL','Ostrov',2064,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2945,3,'COMMUNE',FALSE,'TL','Pardina',624,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2946,3,'COMMUNE',FALSE,'TL','Peceneaga',1960,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2947,3,'COMMUNE',FALSE,'TL','Sarichioi',7213,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2948,3,'COMMUNE',FALSE,'TL','Sfântu Gheorghe',867,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2949,3,'COMMUNE',FALSE,'TL','Slava Cercheză',2560,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2950,3,'COMMUNE',FALSE,'TL','Smârdan',1108,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2951,3,'COMMUNE',FALSE,'TL','Somova',4523,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2952,3,'COMMUNE',FALSE,'TL','Stejaru',1946,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2953,3,'COMMUNE',FALSE,'TL','Topolog',4918,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2954,3,'COMMUNE',FALSE,'TL','Turcoaia',3574,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2955,3,'COMMUNE',FALSE,'TL','Valea Nucarilor',3750,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2956,3,'COMMUNE',FALSE,'TL','Valea Teilor',1517,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2957,3,'COMMUNE',FALSE,'TL','Văcăreni',2362,null);
				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2958,3,'COMMUNE',FALSE,'VS','Albeşti',3303,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2959,3,'COMMUNE',FALSE,'VS','Alexandru Vlahuţă',1502,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2960,3,'COMMUNE',FALSE,'VS','Arsura',1878,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2961,3,'COMMUNE',FALSE,'VS','Băcani',2884,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2962,3,'COMMUNE',FALSE,'VS','Băceşti',4281,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2963,3,'COMMUNE',FALSE,'VS','Bălteni',1584,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2964,3,'COMMUNE',FALSE,'VS','Banca',5577,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2965,3,'COMMUNE',FALSE,'VS','Berezeni',5435,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2966,3,'COMMUNE',FALSE,'VS','Blăgeşti',1629,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2967,3,'COMMUNE',FALSE,'VS','Bogdana',1818,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2968,3,'COMMUNE',FALSE,'VS','Bogdăneşti',3480,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2969,3,'COMMUNE',FALSE,'VS','Bogdăniţa',1561,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2970,3,'COMMUNE',FALSE,'VS','Boţeşti',2188,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2971,3,'COMMUNE',FALSE,'VS','Buneşti-Avereşti',2863,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2972,3,'COMMUNE',FALSE,'VS','Ciocani',1784,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2973,3,'COMMUNE',FALSE,'VS','Codăeşti',4800,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2974,3,'COMMUNE',FALSE,'VS','Coroieşti',2286,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2975,3,'COMMUNE',FALSE,'VS','Costeşti',3235,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2976,3,'COMMUNE',FALSE,'VS','Cozmeşti',2484,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2977,3,'COMMUNE',FALSE,'VS','Creţeşti',1842,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2978,3,'COMMUNE',FALSE,'VS','Dăneşti',2312,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2979,3,'COMMUNE',FALSE,'VS','Deleni',2514,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2980,3,'COMMUNE',FALSE,'VS','Deleşti',2586,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2981,3,'COMMUNE',FALSE,'VS','Dimitrie Cantemir',2937,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2982,3,'COMMUNE',FALSE,'VS','Dodeşti',1855,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2983,3,'COMMUNE',FALSE,'VS','Dragomireşti',5057,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2984,3,'COMMUNE',FALSE,'VS','Drânceni',4686,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2985,3,'COMMUNE',FALSE,'VS','Duda-Epureni',4927,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2986,3,'COMMUNE',FALSE,'VS','Dumeşti',3649,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2987,3,'COMMUNE',FALSE,'VS','Epureni',3216,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2988,3,'COMMUNE',FALSE,'VS','Fălciu',6050,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2989,3,'COMMUNE',FALSE,'VS','Fereşti',2183,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2990,3,'COMMUNE',FALSE,'VS','Fruntişeni',1876,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2991,3,'COMMUNE',FALSE,'VS','Găgeşti',2248,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2992,3,'COMMUNE',FALSE,'VS','Gârceni',2578,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2993,3,'COMMUNE',FALSE,'VS','Ghergheşti',2859,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2994,3,'COMMUNE',FALSE,'VS','Griviţa',3693,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2995,3,'COMMUNE',FALSE,'VS','Hoceni',3068,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2996,3,'COMMUNE',FALSE,'VS','Iana',4197,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2997,3,'COMMUNE',FALSE,'VS','Ibăneşti',1574,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2998,3,'COMMUNE',FALSE,'VS','Ivăneşti',4901,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (2999,3,'COMMUNE',FALSE,'VS','Iveşti',2869,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3000,3,'COMMUNE',FALSE,'VS','Laza',3319,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3001,3,'COMMUNE',FALSE,'VS','Lipovăţ',4348,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3002,3,'COMMUNE',FALSE,'VS','Lunca Banului',3959,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3003,3,'COMMUNE',FALSE,'VS','Măluşteni',2907,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3004,3,'COMMUNE',FALSE,'VS','Micleşti',2951,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3005,3,'COMMUNE',FALSE,'VS','Muntenii de Jos',3939,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3006,3,'COMMUNE',FALSE,'VS','Muntenii de Sus',3909,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3007,3,'COMMUNE',FALSE,'VS','Olteneşti',2905,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3008,3,'COMMUNE',FALSE,'VS','Oşeşti',3284,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3009,3,'COMMUNE',FALSE,'VS','Pădureni',4298,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3010,3,'COMMUNE',FALSE,'VS','Perieni',3733,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3011,3,'COMMUNE',FALSE,'VS','Pochidia',1854,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3012,3,'COMMUNE',FALSE,'VS','Pogana',3296,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3013,3,'COMMUNE',FALSE,'VS','Pogoneşti',1782,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3014,3,'COMMUNE',FALSE,'VS','Poieneşti',3211,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3015,3,'COMMUNE',FALSE,'VS','Puieşti',4911,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3016,3,'COMMUNE',FALSE,'VS','Pungeşti',3472,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3017,3,'COMMUNE',FALSE,'VS','Puşcaşi',3602,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3018,3,'COMMUNE',FALSE,'VS','Rafaila',1974,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3019,3,'COMMUNE',FALSE,'VS','Rebricea',3790,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3020,3,'COMMUNE',FALSE,'VS','Roşieşti',3645,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3021,3,'COMMUNE',FALSE,'VS','Soleşti',3942,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3022,3,'COMMUNE',FALSE,'VS','Stănileşti',5670,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3023,3,'COMMUNE',FALSE,'VS','Ştefan cel Mare',3467,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3024,3,'COMMUNE',FALSE,'VS','Şuletea',2531,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3025,3,'COMMUNE',FALSE,'VS','Tăcuta',3412,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3026,3,'COMMUNE',FALSE,'VS','Tanacu',2337,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3027,3,'COMMUNE',FALSE,'VS','Tătărăni',2473,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3028,3,'COMMUNE',FALSE,'VS','Todireşti',3584,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3029,3,'COMMUNE',FALSE,'VS','Tutova',3716,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3030,3,'COMMUNE',FALSE,'VS','Văleni',4715,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3031,3,'COMMUNE',FALSE,'VS','Vetrişoaia',3440,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3032,3,'COMMUNE',FALSE,'VS','Viişoara',2051,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3033,3,'COMMUNE',FALSE,'VS','Vinderei',4648,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3034,3,'COMMUNE',FALSE,'VS','Voineşti',3963,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3035,3,'COMMUNE',FALSE,'VS','Vultureşti',2426,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3036,3,'COMMUNE',FALSE,'VS','Vutcani',2270,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3037,3,'COMMUNE',FALSE,'VS','Zăpodeni',4120,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3038,3,'COMMUNE',FALSE,'VS','Zorleni',9699,null);
				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3039,3,'COMMUNE',FALSE,'VL','Alunu',4550,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3040,3,'COMMUNE',FALSE,'VL','Amărăşti',2010,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3041,3,'COMMUNE',FALSE,'VL','Bărbăteşti',3766,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3042,3,'COMMUNE',FALSE,'VL','Berislăveşti',3000,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3043,3,'COMMUNE',FALSE,'VL','Boişoara',1484,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3044,3,'COMMUNE',FALSE,'VL','Budeşti',5707,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3045,3,'COMMUNE',FALSE,'VL','Bujoreni',4236,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3046,3,'COMMUNE',FALSE,'VL','Buneşti',2740,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3047,3,'COMMUNE',FALSE,'VL','Câineni',2502,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3048,3,'COMMUNE',FALSE,'VL','Cernişoara',3957,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3049,3,'COMMUNE',FALSE,'VL','Copăceni',2964,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3050,3,'COMMUNE',FALSE,'VL','Costeşti',3447,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3051,3,'COMMUNE',FALSE,'VL','Creţeni',3447,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3052,3,'COMMUNE',FALSE,'VL','Dăeşti',2944,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3053,3,'COMMUNE',FALSE,'VL','Dănicei',2338,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3054,3,'COMMUNE',FALSE,'VL','Diculeşti',2105,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3055,3,'COMMUNE',FALSE,'VL','Drăgoeşti',2235,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3056,3,'COMMUNE',FALSE,'VL','Fârtăţeşti',4372,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3057,3,'COMMUNE',FALSE,'VL','Făureşti',1607,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3058,3,'COMMUNE',FALSE,'VL','Frânceşti',5655,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3059,3,'COMMUNE',FALSE,'VL','Galicea',4084,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3060,3,'COMMUNE',FALSE,'VL','Ghioroiu',1913,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3061,3,'COMMUNE',FALSE,'VL','Glăvile',2483,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3062,3,'COMMUNE',FALSE,'VL','Goleşti',2709,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3063,3,'COMMUNE',FALSE,'VL','Grădiştea',2994,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3064,3,'COMMUNE',FALSE,'VL','Guşoeni',1743,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3065,3,'COMMUNE',FALSE,'VL','Ioneşti',4466,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3066,3,'COMMUNE',FALSE,'VL','Lăcusteni',1481,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3067,3,'COMMUNE',FALSE,'VL','Lădeşti',2046,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3068,3,'COMMUNE',FALSE,'VL','Laloşu',2633,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3069,3,'COMMUNE',FALSE,'VL','Lăpuşata',2427,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3070,3,'COMMUNE',FALSE,'VL','Livezi',2516,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3071,3,'COMMUNE',FALSE,'VL','Lungeşti',3484,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3072,3,'COMMUNE',FALSE,'VL','Măciuca',2024,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3073,3,'COMMUNE',FALSE,'VL','Mădulari',1658,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3074,3,'COMMUNE',FALSE,'VL','Malaia',1924,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3075,3,'COMMUNE',FALSE,'VL','Măldăreşti',2021,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3076,3,'COMMUNE',FALSE,'VL','Mateeşti',3219,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3077,3,'COMMUNE',FALSE,'VL','Mihăeşti',6471,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3078,3,'COMMUNE',FALSE,'VL','Milcoiu',1333,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3079,3,'COMMUNE',FALSE,'VL','Mitrofani',1246,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3080,3,'COMMUNE',FALSE,'VL','Muereasca',2713,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3081,3,'COMMUNE',FALSE,'VL','Nicolae Bălcescu',3685,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3082,3,'COMMUNE',FALSE,'VL','Olanu',3367,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3083,3,'COMMUNE',FALSE,'VL','Orleşti',3298,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3084,3,'COMMUNE',FALSE,'VL','Oteşani',2891,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3085,3,'COMMUNE',FALSE,'VL','Păuşeşti',2924,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3086,3,'COMMUNE',FALSE,'VL','Păuşeşti-Măglaşi',4020,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3087,3,'COMMUNE',FALSE,'VL','Perişani',2490,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3088,3,'COMMUNE',FALSE,'VL','Pesceana',1969,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3089,3,'COMMUNE',FALSE,'VL','Pietrari',3239,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3090,3,'COMMUNE',FALSE,'VL','Popeşti',3177,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3091,3,'COMMUNE',FALSE,'VL','Prundeni',4589,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3092,3,'COMMUNE',FALSE,'VL','Racoviţa',1878,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3093,3,'COMMUNE',FALSE,'VL','Roeşti',2302,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3094,3,'COMMUNE',FALSE,'VL','Roşiile',2823,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3095,3,'COMMUNE',FALSE,'VL','Runcu',1103,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3096,3,'COMMUNE',FALSE,'VL','Sălătrucel',2155,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3097,3,'COMMUNE',FALSE,'VL','Scundu',2181,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3098,3,'COMMUNE',FALSE,'VL','Sineşti',2562,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3099,3,'COMMUNE',FALSE,'VL','Şirineasa',2597,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3100,3,'COMMUNE',FALSE,'VL','Slătioara',3496,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3101,3,'COMMUNE',FALSE,'VL','Stăneşti',1442,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3102,3,'COMMUNE',FALSE,'VL','Ştefăneşti',3645,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3103,3,'COMMUNE',FALSE,'VL','Stoeneşti',3828,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3104,3,'COMMUNE',FALSE,'VL','Stoileşti',4243,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3105,3,'COMMUNE',FALSE,'VL','Stroeşti',3080,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3106,3,'COMMUNE',FALSE,'VL','Şuşani',3688,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3107,3,'COMMUNE',FALSE,'VL','Suteşti',2211,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3108,3,'COMMUNE',FALSE,'VL','Tetoiu',2806,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3109,3,'COMMUNE',FALSE,'VL','Titeşti',1144,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3110,3,'COMMUNE',FALSE,'VL','Tomşani',4087,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3111,3,'COMMUNE',FALSE,'VL','Vaideeni',4185,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3112,3,'COMMUNE',FALSE,'VL','Valea Mare',3156,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3113,3,'COMMUNE',FALSE,'VL','Vlădeşti',2689,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3114,3,'COMMUNE',FALSE,'VL','Voiceşti',1735,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3115,3,'COMMUNE',FALSE,'VL','Voineasa',1661,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3116,3,'COMMUNE',FALSE,'VL','Zătreni',2696,null);					

INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3117,3,'COMMUNE',FALSE,'VN','Andreiaşu de Jos',1591 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3118,3,'COMMUNE',FALSE,'VN','Băleşti',1823,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3119,3,'COMMUNE',FALSE,'VN','Bârseşti',1268,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3120,3,'COMMUNE',FALSE,'VN','Bilieşti',1777,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3121,3,'COMMUNE',FALSE,'VN','Bogheşti',1618 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3122,3,'COMMUNE',FALSE,'VN','Boloteşti',4067 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3123,3,'COMMUNE',FALSE,'VN','Bordeşti',1609 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3124,3,'COMMUNE',FALSE,'VN','Broşteni',2011,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3125,3,'COMMUNE',FALSE,'VN','Câmpineanca',3335,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3126,3,'COMMUNE',FALSE,'VN','Câmpuri',3378 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3127,3,'COMMUNE',FALSE,'VN','Cârligele',3054 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3128,3,'COMMUNE',FALSE,'VN','Chiojdeni',2209 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3129,3,'COMMUNE',FALSE,'VN','Ciorăşti',3005 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3130,3,'COMMUNE',FALSE,'VN','Corbiţa',1715 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3131,3,'COMMUNE',FALSE,'VN','Coteşti',4778,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3132,3,'COMMUNE',FALSE,'VN','Dumbrăveni',4165 ,null);			
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3133,3,'COMMUNE',FALSE,'VN','Dumitreşti',4467 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3134,3,'COMMUNE',FALSE,'VN','Fitioneşti',2244 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3135,3,'COMMUNE',FALSE,'VN','Garoafa',3885 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3136,3,'COMMUNE',FALSE,'VN','Goleşti',3988 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3137,3,'COMMUNE',FALSE,'VN','Gologanu',3010 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3138,3,'COMMUNE',FALSE,'VN','Gugeşti',5788 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3139,3,'COMMUNE',FALSE,'VN','Gura Caliţei',2400 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3140,3,'COMMUNE',FALSE,'VN','Homocea',6007 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3141,3,'COMMUNE',FALSE,'VN','Jariştea',4091 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3142,3,'COMMUNE',FALSE,'VN','Jitia',1564 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3143,3,'COMMUNE',FALSE,'VN','Măicăneşti',4403 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3144,3,'COMMUNE',FALSE,'VN','Mera',3274,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3145,3,'COMMUNE',FALSE,'VN','Milcovul',2916 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3146,3,'COMMUNE',FALSE,'VN','Moviliţa',3088 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3147,3,'COMMUNE',FALSE,'VN','Năneşti',1960 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3148,3,'COMMUNE',FALSE,'VN','Năruja',1604 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3149,3,'COMMUNE',FALSE,'VN','Negrileştii',1827 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3150,3,'COMMUNE',FALSE,'VN','Nistoreşti',1855,null);
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3151,3,'COMMUNE',FALSE,'VN','Nereju',4052 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3152,3,'COMMUNE',FALSE,'VN','Obrejiţa',1543 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3153,3,'COMMUNE',FALSE,'VN','Paltin',1796 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3154,3,'COMMUNE',FALSE,'VN','Păuleşti',1806 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3155,3,'COMMUNE',FALSE,'VN','Păuneşti',5511,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3156,3,'COMMUNE',FALSE,'VN','Ploscuţeni',3048,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3157,3,'COMMUNE',FALSE,'VN','Poiana Cristei',2581 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3158,3,'COMMUNE',FALSE,'VN','Popeşti',2642 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3159,3,'COMMUNE',FALSE,'VN','Pufeşti',3486 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3160,3,'COMMUNE',FALSE,'VN','Răcoasa',3074 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3161,3,'COMMUNE',FALSE,'VN','Răstoaca',1769 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3162,3,'COMMUNE',FALSE,'VN','Reghiu',2087 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3163,3,'COMMUNE',FALSE,'VN','Rugineşti',3350 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3164,3,'COMMUNE',FALSE,'VN','Sihlea',4844 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3165,3,'COMMUNE',FALSE,'VN','Slobozia Bradului',6447 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3166,3,'COMMUNE',FALSE,'VN','Slobozia Ciorăşti',1611,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3167,3,'COMMUNE',FALSE,'VN','Soveja',2090 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3168,3,'COMMUNE',FALSE,'VN','Spulber',1259 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3169,3,'COMMUNE',FALSE,'VN','Străoane',3139 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3170,3,'COMMUNE',FALSE,'VN','Suraia',4379,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3171,3,'COMMUNE',FALSE,'VN','Tâmboeşti',2794 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3172,3,'COMMUNE',FALSE,'VN','Tănăsoaia',1935,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3173,3,'COMMUNE',FALSE,'VN','Tătăranu',3780 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3174,3,'COMMUNE',FALSE,'VN','Tulnici',3197,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3175,3,'COMMUNE',FALSE,'VN','Ţifeşti',5015,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3176,3,'COMMUNE',FALSE,'VN','Urecheşti',2459,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3177,3,'COMMUNE',FALSE,'VN','Valea Sării',1563 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3178,3,'COMMUNE',FALSE,'VN','Vânători',4956 ,null);				
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3179,3,'COMMUNE',FALSE,'VN','Vârteşcoiu',3019,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3180,3,'COMMUNE',FALSE,'VN','Vidra',6058 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3181,3,'COMMUNE',FALSE,'VN','Vintileasca',1924 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3182,3,'COMMUNE',FALSE,'VN','Vizantea-Livezi',3741 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3183,3,'COMMUNE',FALSE,'VN','Vrâncioaia',2508 ,null);					
INSERT INTO public.plocality(id, nivel,typelocality, residence, code_province,name,locuitori,sector)VALUES (3184,3,'COMMUNE',FALSE,'VN','Vulturu',5976 ,null);					
commit;

--Carga date echipa
	INSERT INTO public.pteam(id,name,description, organization) VALUES (1, 'Președinte',NULL, 'Conducerea Centrală');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (2, 'Prim-Vicepreședinte',NULL, 'Conducerea Centrală');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (3, 'Secretar General', NULL, 'Conducerea Centrală');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (4, 'Secretar General Adjunct',NULL, 'Conducerea Centrală');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (5, 'Vicepreședinte',NULL, 'Conducerea Centrală');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (6, 'Secretar Executiv',NULL, 'Conducerea Centrală');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (7, 'Trezorier',NULL, 'Conducerea Centrală');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (8, 'Președinte comisie', NULL, 'Comisia Națională De Arbitraj și Integritate');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (9, 'Membru comisie', NULL, 'Comisie');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (10,'Purtător de cuvant', NULL ,'Conducerea Centrală');
	INSERT INTO public.pteam(id,name,description, organization) VALUES (11,'Președinte OTER', NULL ,'Conducerea Centrală');
	COMMIT;	
	
--Utilizatori

	
INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('danut.pop@per.ro', current_date, null, null, 'system', null, null, 'danut.pop@per.ro', 'POP', 'Dănuț', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('14/04/58', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 73,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Profesor la Facultatea de drept', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;		

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('mircia.gutau@per.ro', current_date, null, null, 'system', null, null, 'mircia.gutau@per.ro', 'GUTĂU', 'Mircia', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('14/04/58', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 302,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Primar Râmnicu Vâlcea', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('cristian.anghel@per.ro', current_date, null, null, 'system', null, null, 'cristian.anghel@per.ro', 'ANGHEL', 'Cristian', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 185,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('radu.cristescu@per.ro', current_date, null, null, 'system', null, null, 'radu.cristescu@per.ro', 'CRISTESCU', 'Radu', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('bob.vasile@per.ro', current_date, null, null, 'system', null, null, 'bob.vasile@per.ro', 'BOB', 'Vasile', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('cristinel.deaconescu@per.ro', current_date, null, null, 'system', null, null, 'cristinel.deaconescu@per.ro', 'DEACONESCU', 'Cristinel', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('viorel.dobre@per.ro', current_date, null, null, 'system', null, null, 'viorel.dobre@per.ro', 'DOBRE', 'Viorel', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('mirica.dimitrescu@per.ro', current_date, null, null, 'system', null, null, 'mirica.dimitrescu@per.ro', 'DIMITRESCU', 'Mirică', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('bianca.vasile@per.ro', current_date, null, null, 'system', null, null, 'bianca.vasile@per.ro', 'VASILE', 'Bianca', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('daniel.diaconu@per.ro', current_date, null, null, 'system', null, null, 'daniel.diaconu@per.ro', 'DIACONU', 'Daniel', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('ovidiu.zara@per.ro', current_date, null, null, 'system', null, null, 'ovidiu.zara@per.ro', 'ZARĂ', 'Ovidiu', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;	

INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('danut.frunza@per.ro', current_date, null, null, 'system', null, null, 'danut.frunza@per.ro', 'FRUNZĂ', 'Dănuț', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;
 
 INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('dragos.sterpu@per.ro', current_date, null, null, 'system', null, null, 'dragos.sterpu@per.ro', 'STERPU', 'Dragoş', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;
 
  INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('costica.popsor@per.ro', current_date, null, null, 'system', null, null, 'costica.popsor@per.ro', 'POPȘOR', 'Costică', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;
 
INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('danut.frangu@per.ro', current_date, null, null, 'system', null, null, 'danut.frangu@per.ro', 'FRANGU', 'Dănuț', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;
 
INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('eugen.vizitiu@per.ro', current_date, null, null, 'system', null, null, 'eugen.vizitiu@per.ro', 'VIZITIU', 'Eugen', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;
 
 INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('tineret@per.ro', current_date, null, null, 'system', null, null, 'tineret@per.ro', 'POP', 'Dănuț', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;
 
 INSERT INTO public.users(username, date_create, date_deleted, date_updated, user_create, user_deleted, user_updated, email,   name,last_name,
password, address, birth_date, civil_status, education, id_card, locality_id, number_card, personal_email, phone, code_province, sex, workplace, role, photo,validated,alert_channel,destinatar_extern)
	
VALUES ('admin', current_date, null, null, 'system', null, null, 'admin@per.ro', 'ADMIN', 'ADMIN', 
'$2a$10$tDGyXBpEASeXlAUCdKsZ9u3MBBvT48xjA.v0lrDuRWlSZ6yfNsLve', 'Calea Victoriei nr 91-93', to_date('24/08/14', 'DD/MM/YY'),'MARRIED', 'STUDIISUPERIOARE', '1580414632611', 74,'RG.2881', 'proba@hotmail.com', 
'0723452223', 'B', 'MAN', 'Doctor inginer în specializarea Mecanică Tehnică', 'ROLE_ADMIN',null,true,'EMAIL',false);
COMMIT;

--Team	
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (1, 1, 1, 'danut.pop@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (2, 2, 2, 'mircia.gutau@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (3, 3, 2, 'cristian.anghel@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (4, 4, 2, 'radu.cristescu@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (5, 5, 3, 'bob.vasile@per.ro');	
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (6, 6, 4, 'cristinel.deaconescu@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (7, 8, 5, 'viorel.dobre@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (8, 9, 5, 'mirica.dimitrescu@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (9, 10, 5, 'bianca.vasile@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (10, 11, 5, 'daniel.diaconu@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (11, 12, 5, 'ovidiu.zara@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (12, 13, 5, 'danut.frunza@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (14, 14, 5, 'dragos.sterpu@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (15, 15, 5, 'costica.popsor@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (16, 16, 5, 'danut.frangu@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (17, 17, 5, 'eugen.vizitiu@per.ro');
INSERT INTO public.team(id, rank, team_id, user_username)VALUES (13, 7, 11, 'tineret@per.ro');
COMMIT;	

--Date de conexiune al servidor de mail
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('1','MAIL','mail.smtp.host','smtp.gmail.com');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('2','MAIL','mail.smtp.port','587');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('3','MAIL','mail.smtp.ssl.trust','smtp.gmail.com');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('4','MAIL','mail.smtp.starttls.enable','true');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('5','MAIL','mail.smtp.user','elypseinfo@gmail.com');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('6','MAIL','mail.smtp.auth','true');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('7','MAIL','mail.smtp.password','elypse18');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('8','extensiones','DOC','application/msword');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('9','extensiones','DOCX','application/vnd.openxmlformats-officedocument.wordprocessingml.document');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('10','extensiones','ODT','application/vnd.oasis.opendocument.text');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('11','extensiones','PPT','application/vnd.ms-powerpoint');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('12','extensiones','PPTX','application/vnd.openxmlformats-officedocument.presentationml.presentation');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('13','extensiones','ODP','application/vnd.oasis.opendocument.presentation');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('14','extensiones','XLS','application/vnd.ms-excel');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('15','extensiones','XLSX','application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('16','extensiones','ODS','application/vnd.oasis.opendocument.spreadsheet');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('17','extensiones','JPEG','image/jpeg');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('18','extensiones','PNG','image/png');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('19','extensiones','BMP','image/bmp');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('20','extensiones','PUB','application/x-mspublisher');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('21','extensiones','PDF','application/pdf');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('22','extensiones','ZIP','application/x-zip-compressed');
INSERT into public.PROPERTIES (ID,FILENAME,NAME,VALUE) values ('23','HOME','TIMP_ISTORIC_STATISTIC','30');
COMMIT;	
	
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (1,'ANEXE LA RAPORT');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (2,'COMUNICARE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (3,'ALERTĂ ADMINISTRATIVĂ ');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (4,'AUDIO');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (5,'CONTROL DE ACTIVITATE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (6,'RAPORT');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (7,'DATE STATISTICE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (8,'DOCUMENTE DE INTRARE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (9,'DOCUMENTE DE IEȘIRE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (10,'FIȘIER DE MONITORIZARE ȘI CONTROL');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (11,'RAPOARTE ISTORICE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (12,'IMAGINE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (13,'NORMĂ INTERNĂ');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (14,'ALTELE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (15,'RECLAMAȚII');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (16,'RESURSE UMANE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (17,'RESURSE MATERIALE');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (18,'VIDEO');
INSERT into public.TIPO_DOCUMENTO (ID,NOMBRE) values (19,'TEMPLATE');
COMMIT;		

INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (1,'AB','JUDET','Alba','155,165,159,153,171,153,176,161,182,157,184,159,195,154,200,159,207,159,209,167,211,167,213,162,229,163,234,171,245,180,240,187,237,188,231,199,226,194,221,199,221,205,214,214,209,215,205,224,208,229,208,237,212,242,207,244,195,230,195,228,196,226,195,224,194,221,195,220,186,196,180,195,178,191,178,183,173,181,169,170,160,170');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (2,'AR','JUDET','Arad','85,140,90,146,97,141,108,141,113,145,118,143,125,147,125,153,134,155,141,166,154,166,159,171,153,171,151,178,141,178,138,190,139,197,128,204,112,197,101,202,101,199,99,197,95,203,81,189,80,190,80,194,77,196,65,193,62,195,60,190,52,189,41,181,42,177,46,175,49,176,53,178,61,178,67,173,69,165,71,165,76,160,71,155,75,151,75,150,74,147,76,146,81,145');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (3,'AG','JUDET','Argeş','261,235,261,245,260,246,259,267,261,273,258,297,262,294,265,303,267,306,273,305,274,334,284,336,301,330,302,333,305,331,305,322,300,317,298,307,300,306,297,288,299,283,295,273,298,266,301,270,303,270,304,259,307,251,301,242,295,236,287,237,280,235,267,235');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (4,'BC','JUDET','Bacău','346,143,349,141,351,146,359,146,361,143,366,147,381,143,387,137,392,140,398,132,401,137,418,136,419,139,422,141,422,143,419,146,425,155,429,166,433,185,421,182,412,187,413,191,403,190,403,193,381,192,381,195,382,197,380,197,376,195,375,195,374,197,368,183,364,179,363,170,362,170,356,173,356,169,355,167,346,166,349,161,351,158,346,151');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (5,'BH','JUDET','Bihor','124,63,133,66,138,79,149,81,151,88,145,99,149,104,148,107,157,114,154,119,161,124,154,132,162,145,162,152,158,152,154,165,141,164,135,154,127,153,127,147,118,142,113,144,109,140,96,140,90,144,86,139,87,137,85,134,85,133,91,125,96,114,93,110,101,102,105,95,109,87,110,85,116,80,114,71,119,67');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (6,'BN','JUDET','Bistrița-Năsăud','240,76,246,76,254,67,271,71,273,69,287,68,293,74,291,81,289,83,292,87,292,91,290,93,291,107,281,107,274,118,273,123,271,124,269,123,268,120,257,130,257,135,249,137,243,132,245,124,241,122,240,109,233,101,230,101,228,96,228,95,229,91,234,91,234,85,238,79');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (7,'BT','JUDET','Botoşani','346,31,349,36,357,42,363,45,367,53,375,61,377,73,383,82,385,72,397,73,402,74,403,77,409,68,411,71,416,71,418,66,425,66,417,58,417,50,411,40,411,35,407,30,405,26,397,16,391,11,387,9,385,10,381,12,378,13,372,15,367,17,363,19,359,26,356,31');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (8,'BR','JUDET','Brăila','439,242,443,244,448,243,457,250,467,249,467,259,473,261,471,266,477,269,475,279,473,291,471,297,468,301,459,301,456,297,455,297,449,301,427,299,424,303,420,300,424,285,417,269,414,269,419,262,427,266,428,259,431,259,432,250');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (9,'BV','JUDET','Braşov','289,191,308,187,313,193,318,197,321,198,321,201,319,205,320,209,322,214,328,221,334,221,344,226,349,233,352,240,341,240,340,247,336,244,331,243,326,242,321,244,314,247,311,251,308,251,305,246,303,241,295,235,287,235,280,233,275,234,272,233,269,219,275,213,274,207,285,197,287,193');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (10,'BZ','JUDET','Buzău','349,241,356,244,358,253,363,257,360,261,363,266,367,265,369,265,369,269,375,267,375,278,384,287,381,290,387,298,403,298,415,301,415,304,419,304,420,295,423,284,415,270,411,271,412,268,418,261,425,264,427,258,429,258,431,251,423,251,422,245,415,249,405,239,399,241,379,231,371,218,365,235,363,235,360,232,354,241');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (11,'CL','JUDET','Călăraşi','370,325,370,327,375,331,375,333,365,341,365,345,374,352,375,355,376,358,373,361,390,358,394,358,403,353,414,353,424,355,436,356,441,352,447,349,454,348,458,345,466,343,469,337,461,335,458,339,448,329,441,332,440,328,433,330,433,327,426,328,409,327,403,325,401,326,389,320,386,327,376,321,376,326,372,326,372,325,371,325');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (12,'CS','JUDET','Caraş-Severin','83,266,87,254,81,246,81,244,83,239,94,232,105,237,108,234,115,239,119,237,119,232,125,230,127,233,133,226,139,226,141,230,144,233,151,239,153,245,153,249,150,251,153,260,144,270,149,276,133,302,125,296,118,311,119,315,114,315,113,313,110,311,107,310,100,310,91,309,91,304,89,301,86,300,77,299,76,297,75,295,75,293,76,291,84,291,86,291,87,288,84,285,82,284,78,283,76,281,79,277,84,271,84,268');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (13,'CJ','JUDET','Cluj','223,86,233,86,232,90,229,90,227,93,226,97,228,101,229,103,233,103,239,109,239,122,241,124,243,125,242,132,234,139,237,142,237,143,235,145,232,146,232,148,234,150,233,154,231,155,228,155,229,162,220,161,213,161,210,164,209,158,201,157,195,153,184,157,182,155,176,159,171,152,163,152,163,144,155,132,162,124,156,119,159,115,162,118,168,116,168,121,179,125,179,128,187,125,187,122,191,124,195,123,203,111,201,108,205,103,210,103,213,96,222,93,222,89');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (14,'CV','JUDET','Covasna','330,178,320,184,315,193,317,196,323,197,323,202,320,205,323,213,328,219,334,219,346,225,351,233,353,239,361,230,363,233,369,219,369,202,373,198,367,183,363,180,354,187,338,191,334,185');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (15,'CT','JUDET','Constanța','462,302,469,302,472,299,477,299,482,305,489,309,495,312,495,308,513,308,517,311,525,304,529,307,524,311,521,319,515,327,511,333,511,335,508,337,506,338,507,343,509,346,510,348,507,352,509,357,510,364,510,367,509,371,505,379,507,381,503,385,491,386,484,385,478,384,470,379,465,376,464,369,463,365,451,369,447,361,430,363,424,356,437,357,441,353,451,350,455,349,459,346,466,346,476,329,472,321,471,313,462,306');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (16,'DB','JUDET','Dâmbovița','307,252,312,252,315,247,316,255,315,255,315,257,319,261,319,270,328,279,329,289,335,290,337,297,334,300,341,300,346,307,346,319,343,323,320,323,317,327,311,323,309,330,305,335,303,333,306,331,306,321,301,316,300,307,301,304,299,287,301,283,297,273,299,269,301,272,304,271,306,258');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (17,'DJ','JUDET','Dolj','163,365,168,365,170,363,171,357,170,357,171,354,175,354,176,355,174,346,183,336,181,333,187,323,195,324,201,318,212,318,213,309,215,309,218,316,223,316,224,323,220,329,226,334,226,337,231,338,235,345,241,351,240,359,244,361,239,363,239,368,245,369,245,371,242,373,241,379,238,386,234,391,229,388,221,387,214,383,210,382,205,383,196,378,187,377,178,381,166,381,161,379,158,374');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (18,'GL','JUDET','Galați','434,189,438,199,441,198,441,189,449,189,451,192,453,191,455,189,456,187,462,191,468,190,467,192,467,199,470,208,469,211,469,214,473,227,470,231,475,240,478,243,476,245,471,243,467,248,456,249,448,241,443,243,439,241,437,232,429,223,421,211,420,196');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (19,'GR','JUDET','Giurgiu','343,324,321,324,317,328,315,336,320,342,330,345,331,346,331,350,330,353,330,354,331,356,332,359,332,360,325,366,327,375,328,384,331,391,335,387,341,385,345,379,350,375,353,373,353,370,355,367,363,365,371,361,374,357,373,355,373,352,364,345,361,349,356,349,342,339,339,336,339,333,343,329');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (20,'GJ','JUDET','Gorj','153,261,191,259,193,257,219,256,219,259,217,263,218,265,219,278,215,283,215,308,212,308,211,317,199,317,198,319,195,319,194,315,181,309,175,309,164,296,165,284,155,275,150,275,146,270');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (21,'HR','JUDET','Harghita','303,111,313,102,321,112,331,112,337,121,332,129,339,148,345,144,345,152,350,158,345,165,345,167,354,168,355,175,362,171,362,180,353,186,338,190,331,176,318,184,313,192,309,186,298,187,294,180,286,180,282,173,282,171,283,170,286,169,286,167,289,163,289,158,297,153,306,145,306,143,304,140,306,138,306,115,303,113');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (22,'HD','JUDET','Hunedoara','143,180,140,188,141,197,137,200,137,209,146,216,140,225,143,231,153,238,155,249,152,251,154,259,190,257,193,255,206,255,206,245,193,229,195,226,192,221,194,219,185,197,179,197,176,190,176,183,172,181,168,171,155,172,153,180');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (23,'IL','JUDET','Ialomița','367,304,372,308,372,319,371,323,375,325,375,320,377,320,385,325,388,318,401,324,403,323,408,325,427,327,433,325,434,325,435,328,441,326,442,330,449,327,458,337,461,334,470,337,474,329,470,320,470,314,461,307,460,303,456,299,450,302,427,301,423,305,420,302,420,305,415,306,413,302,402,300,386,300,384,297,371,303,369,302');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (24,'IS','JUDET','Iaşi','386,74,384,87,380,87,375,84,375,87,378,90,376,93,382,100,382,108,390,108,394,112,405,112,409,107,414,110,417,115,417,117,412,121,417,125,425,124,433,125,440,121,438,118,438,116,441,117,448,123,449,120,450,121,451,126,453,125,454,127,456,127,458,124,461,127,463,127,467,125,467,123,463,113,455,108,448,102,447,97,445,93,443,91,438,89,435,84,433,78,430,75,427,69,425,67,418,67,417,72,412,72,409,70,405,79,403,79,400,75,386,73');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (25,'IF','JUDET','Ilfov','347,307,348,319,344,323,344,330,341,335,341,336,356,348,359,348,363,345,364,340,373,332,369,327,371,317,371,309,367,305,354,307');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (26,'MM','JUDET','Maramureş','201,31,214,43,202,52,191,49,189,54,199,58,189,70,183,65,179,69,178,75,175,76,176,79,180,77,187,79,196,80,203,85,212,83,216,87,223,84,233,84,239,75,245,74,253,66,271,69,273,67,286,67,290,62,291,53,284,54,281,48,279,46,271,42,265,34,255,34,246,37,239,37,230,33,211,31,206,31');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (27,'MH','JUDET','Mehedinți','114,316,121,316,120,309,125,298,134,304,150,276,155,277,164,284,163,297,175,310,181,310,189,314,193,316,194,320,197,320,194,323,186,321,180,334,181,336,181,337,173,346,175,353,170,353,167,357,164,357,158,353,150,345,150,342,143,340,137,329,137,327,137,326,142,326,143,323,144,320,147,319,149,321,150,323,153,323,155,321,155,319,152,314,145,314,140,308,137,306,135,306,130,310,128,311,121,325,119,325,114,321');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (28,'MS','JUDET','Mureş','282,108,300,108,302,110,301,112,305,116,305,137,303,140,304,143,305,145,297,151,288,158,288,163,285,165,285,168,282,168,280,172,285,181,293,181,296,188,287,190,285,195,281,192,272,194,270,193,271,177,245,179,235,171,230,163,230,156,233,156,236,150,233,147,238,145,239,142,236,139,242,133,248,139,259,135,259,131,267,122,270,126,275,123,275,118');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (29,'NT','JUDET','Neamț','327,111,329,103,331,99,335,95,334,92,340,96,357,92,360,94,370,88,381,101,381,109,389,109,394,113,405,113,409,108,413,111,416,116,410,120,416,126,417,135,402,135,399,131,397,130,392,139,387,134,380,141,378,142,366,145,361,141,358,145,351,145,349,140,348,140,339,146,334,129,338,121,332,111');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (30,'OT','JUDET','Olt','261,297,263,303,266,307,271,307,273,335,280,337,278,339,277,357,279,360,264,369,267,376,273,385,270,387,271,391,259,387,250,391,240,393,236,392,241,383,243,373,246,372,246,368,240,367,240,363,246,362,245,361,242,359,242,350,236,345,232,337,227,336,227,333,222,328,225,324,235,327,238,322,243,322,245,319,249,322,247,308,250,296,253,294,254,296,256,301,257,301');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (31,'PH','JUDET','Prahova','317,247,327,243,335,245,340,249,341,249,342,241,347,242,355,245,357,253,361,257,358,261,363,268,368,267,369,271,374,269,373,278,382,287,379,291,384,296,371,302,368,300,366,303,347,306,342,299,337,299,339,296,336,289,334,289,329,288,329,279,320,269,321,260,316,256,317,255,317,251');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (32,'SJ','JUDET','Sălaj','153,88,163,81,170,81,173,85,181,85,183,79,195,81,203,87,212,84,215,89,221,87,221,93,218,94,212,96,210,101,205,101,199,109,201,112,196,120,192,122,190,123,187,120,185,124,180,126,180,124,169,120,168,115,166,115,163,117,162,115,150,107,149,105,151,103,147,99,151,90');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (33,'SM','JUDET','Satu Mare','125,62,134,65,140,78,150,79,152,86,162,79,171,80,173,84,180,84,181,79,179,79,177,81,174,79,173,77,173,75,177,73,177,69,183,63,189,68,197,58,187,55,191,47,201,51,212,43,199,30,193,29,188,23,181,22,177,29,159,38,159,41,151,49,142,47,139,51,134,53,131,53,126,60');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (34,'SB','JUDET','Sibiu','246,180,269,179,269,193,271,195,281,193,284,196,277,203,272,207,274,213,268,218,270,234,252,234,242,240,223,240,222,239,213,242,209,236,209,229,207,224,210,216,215,215,222,204,222,200,226,196,231,201,239,189,241,189,244,184');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (35,'SV','JUDET','Suceava','292,52,296,51,306,39,308,37,314,36,337,36,345,31,346,34,348,37,356,43,362,46,364,50,367,55,374,61,376,74,383,83,383,86,381,86,374,82,373,82,373,88,376,90,374,92,369,87,359,92,356,91,340,94,334,89,333,89,332,91,334,94,330,98,326,111,321,110,312,100,303,109,301,106,292,106,291,93,293,91,293,86,291,83,294,81,294,73,288,67,291,63,292,54');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (36,'TL','JUDET','Teleorman','280,340,278,357,281,362,267,369,268,374,270,378,275,385,272,388,272,391,282,391,285,390,290,391,294,393,300,392,313,399,318,397,326,396,330,391,327,381,324,366,331,359,328,355,329,350,329,346,325,345,318,343,313,336,316,328,312,325,309,332,304,336,300,332,282,338');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (37,'TM','JUDET','Timiş','41,183,52,191,59,192,61,197,65,195,76,198,81,195,82,191,95,205,99,199,100,204,113,198,128,205,136,200,136,209,145,216,139,224,133,224,128,231,125,229,123,229,116,231,118,236,115,238,108,232,105,235,94,231,83,238,80,246,85,255,82,265,78,263,73,262,55,254,43,243,40,230,42,227,42,217,37,217,31,208,24,202,17,199,15,194,12,188,17,186,19,186,24,189,28,183,35,188,39,186');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (38,'TL','JUDET','Tulcea','479,243,483,245,483,249,487,255,495,258,505,262,515,262,522,255,530,250,541,245,547,245,556,247,564,253,566,264,566,269,564,279,563,291,551,293,541,295,533,299,529,306,525,303,517,309,514,307,493,306,493,310,488,307,482,304,479,299,478,297,473,297,475,291,476,280,479,269,473,266,475,260,468,258,468,248,471,245,475,247,478,247');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (39,'VL','JUDET','Vâlcea','207,245,207,255,221,255,221,259,219,262,221,278,217,284,217,308,218,314,223,314,225,323,234,325,237,321,242,321,245,317,248,319,245,307,249,295,253,293,257,297,260,273,257,267,258,247,260,244,260,235,253,235,242,241,224,241,222,240,209,244');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (40,'VS','JUDET','Vaslui','417,127,419,138,423,140,423,144,421,146,428,157,432,167,435,187,438,198,439,198,440,198,440,188,449,188,452,190,454,190,456,185,462,189,469,189,469,179,467,177,472,171,473,162,473,138,469,132,467,127,465,127,461,129,459,126,456,129,455,129,453,127,451,128,450,127,449,123,447,125,443,121,440,118,441,121,441,123,438,125,433,126,426,125,419,126');
INSERT into public.MAPA (ID,COD_JUDET,INDICATIV,NUME,COORDONATE) values (41,'VN','JUDET','Vrancea','376,197,383,199,382,193,404,194,404,191,415,192,414,187,422,183,433,186,433,187,418,196,420,213,425,219,437,233,438,242,431,249,425,250,423,245,422,244,415,247,405,238,399,240,379,229,370,215,370,203');
COMMIT;	

--/**
--PSD LEGISLATIVE 1990
INSERT INTO public.rezultate(id, data_alegerilor, procentajtotalmandate, procentajtotalvoturipartid, procentajtotalvoturi, 
procentajtotalvoturiconsjud, procentajtotalvoturiconslocal, procentajtotalvoturideputat, procentajtotalvoturieuro, 
procentajtotalvoturiprimar, procentajtotalvoturiprimarcap, procentajtotalvoturisenat, tip_alegeri, totalmandate, totalvoturi, 
totalvoturiconsjud, totalvoturiconslocal, totalvoturideputat, totalvoturieuro, totalvoturipartid, totalvoturiprimar, 
totalvoturiprimarcap, totalvoturisenat, turulalegerilor)
VALUES (1, to_date('20/05/1990', 'DDD/MM/YYYY'), 76.47 , 67.02, 94.13, null,null, 66.41, null,null, null, 76.47, 'GENERALE', 354, 13956180, null, null
, 9089659, null, null, null, null,  9353006,1);
INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (1, 'NOT','PSD','Partidul Social Democrat','Frontul Salvării Naționale', 1);
INSERT INTO public.alegeri_partid(id_alegeri, id_partid)VALUES (1, 1);
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (1, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 87.15, 'GENERALE', null, 'TR');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (2, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 86.79, 'GENERALE', null, 'BT');	
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (3, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 86.10, 'GENERALE', null, 'VS');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (4, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 86.54, 'GENERALE', null, 'OT');	
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (5, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 85.91, 'GENERALE', null, 'IL');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (6, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 85.00, 'GENERALE', null, 'CL');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (7, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 11.04, 'GENERALE', null, 'HR');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (8, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 16.63, 'GENERALE', null, 'CV');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (9, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 14.27, 'GENERALE', null, 'MS');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (10, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 41.73, 'GENERALE', null, 'SM');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (11, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 41.31, 'GENERALE', null, 'CJ');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (12, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 45.42, 'GENERALE', null, 'BH');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (13, to_date('20/05/1990', 'DD/MM/YYYY'), 1, 45.63, 'GENERALE', null, 'TM');	
	
--UDMR	LEGISLATIVE 1990	
INSERT INTO public.rezultate(id, data_alegerilor, procentajtotalmandate, procentajtotalvoturipartid, procentajtotalvoturi, 
procentajtotalvoturiconsjud, procentajtotalvoturiconslocal, procentajtotalvoturideputat, procentajtotalvoturieuro, 
procentajtotalvoturiprimar, procentajtotalvoturiprimarcap, procentajtotalvoturisenat, tip_alegeri, totalmandate, totalvoturi, 
totalvoturiconsjud, totalvoturiconslocal, totalvoturideputat, totalvoturieuro, totalvoturipartid, totalvoturiprimar, 
totalvoturiprimarcap, totalvoturisenat, turulalegerilor)
VALUES (2, to_date('20/05/90', 'DD/MM/YY'), 10.08 , 7.02, 94.13, null,null, 7.23, null,null, null, 10.08, 'GENERALE', 41, 13956180, null, null
, 991601, null, null, null, null,  1004353,1 );
INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (2, 'NOT','UDMR','Uniunea Democrată a Maghiarilor din România','Uniunea Democrată a Maghiarilor din România', 1);
INSERT INTO public.alegeri_partid(id_alegeri, id_partid)VALUES (1, 2);
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (14, to_date('20/05/1990', 'DD/MM/YYYY'), 2, 85.23, 'GENERALE', null, 'HR');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (15, to_date('20/05/1990', 'DD/MM/YYYY'), 2, 77.10, 'GENERALE', null, 'CV');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (16, to_date('20/05/1990', 'DD/MM/YYYY'), 2, 41.96, 'GENERALE', null, 'MS');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (17, to_date('20/05/1990', 'DD/MM/YYYY'), 2, 38.16, 'GENERALE', null, 'SM');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (18, to_date('20/05/1990', 'DD/MM/YYYY'), 2, 28.28, 'GENERALE', null, 'BH');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (19, to_date('20/05/1990', 'DD/MM/YYYY'), 2, 23.68, 'GENERALE', null, 'SJ');
COMMIT;

--PNL	LEGISLATIVE 1990	
INSERT INTO public.rezultate(id, data_alegerilor, procentajtotalmandate, procentajtotalvoturipartid, procentajtotalvoturi, 
procentajtotalvoturiconsjud, procentajtotalvoturiconslocal, procentajtotalvoturideputat, procentajtotalvoturieuro, 
procentajtotalvoturiprimar, procentajtotalvoturiprimarcap, procentajtotalvoturisenat, tip_alegeri, totalmandate, totalvoturi, 
totalvoturiconsjud, totalvoturiconslocal, totalvoturideputat, totalvoturieuro, totalvoturipartid, totalvoturiprimar, 
totalvoturiprimarcap, totalvoturisenat, turulalegerilor)
VALUES (3, to_date('20/05/90', 'DD/MM/YY'), 7.06 , 7.02, 94.13, null,null, 6.41, null,null, null, 8.4, 'GENERALE', 39, 13956180, null, null
, 879290, null, null, null, null,  985094,1 );
INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (3, 'NOT','PNL','Partidul Național Liberal','Partidul Național Liberal', 1);
INSERT INTO public.alegeri_partid(id_alegeri, id_partid)VALUES (1, 3);
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (20, to_date('20/05/1990', 'DD/MM/YYYY'), 3, 17.94, 'GENERALE', null, 'TM');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (21, to_date('20/05/1990', 'DD/MM/YYYY'), 3, 11.70, 'GENERALE', null, 'B');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (22, to_date('20/05/1990', 'DD/MM/YYYY'), 3, 10.14, 'GENERALE', null, 'AR');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (23, to_date('20/05/1990', 'DD/MM/YYYY'), 3, 9.65, 'GENERALE', null, 'CS');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (24, to_date('20/05/1990', 'DD/MM/YYYY'), 3, 9.65, 'GENERALE', null, 'BV');
INSERT INTO public.partid_rezultat_judet(id, data_alegerilor, partid, procentajtotalvoturi, tip_alegeri, totalvoturi, id_judet)
	VALUES (25, to_date('20/05/1990', 'DD/MM/YYYY'), 3, 8.83, 'GENERALE', null, 'SB');
COMMIT;

--PER	LEGISLATIVE 1990	
INSERT INTO public.rezultate(id, data_alegerilor, procentajtotalmandate, procentajtotalvoturipartid, procentajtotalvoturi, 
procentajtotalvoturiconsjud, procentajtotalvoturiconslocal, procentajtotalvoturideputat, procentajtotalvoturieuro, 
procentajtotalvoturiprimar, procentajtotalvoturiprimarcap, procentajtotalvoturisenat, tip_alegeri, totalmandate, totalvoturi, 
totalvoturiconsjud, totalvoturiconslocal, totalvoturideputat, totalvoturieuro, totalvoturipartid, totalvoturiprimar, 
totalvoturiprimarcap, totalvoturisenat, turulalegerilor)
VALUES (4, to_date('20/05/90', 'DD/MM/YY'), 2.45 , 7.02, 94.13, null,null, 2.62, null,null, null, 0.84, 'GENERALE', 13, 13956180, null, null
, 358864, null, null, null, null,  348637,1 );
INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (4, 'NOT','PER','Partidul Ecologist din România','Mișcarea Ecologistă din România', 1);
INSERT INTO public.alegeri_partid(id_alegeri, id_partid)VALUES (1, 4);
COMMIT;

--PNȚCD	LEGISLATIVE 1990	
--INSERT INTO public.rezultate(id, data_alegerilor, procentajtotalmandate, procentajtotalvoturipartid, procentajtotalvoturi, 
--procentajtotalvoturiconsjud, procentajtotalvoturiconslocal, procentajtotalvoturideputat, procentajtotalvoturieuro, 
--procentajtotalvoturiprimar, procentajtotalvoturiprimarcap, procentajtotalvoturisenat, tip_alegeri, totalmandate, totalvoturi, 
--totalvoturiconsjud, totalvoturiconslocal, totalvoturideputat, totalvoturieuro, totalvoturipartid, totalvoturiprimar, 
--totalvoturiprimarcap, totalvoturisenat, turulalegerilor)
--VALUES (5, to_date('20/05/90', 'DD/MM/YY'), 2.5 , 7.02, 94.13, null,null, 2.56, null,null, null, 0,84, 'GENERALE', 13, 13956180, null, null
--, 351357, null, null, null, null,  341478,1 );
--INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (5, 'NOT','PNȚCD','Partidul Național Țărănesc Creștin Democrat','Partidul Național Țărănesc Creștin Democrat', 1);
--INSERT INTO public.alegeri_partid(id_alegeri, id_partid)VALUES (1, 5);
--COMMIT;

--AUR	LEGISLATIVE 1990	
--INSERT INTO public.rezultate(id, data_alegerilor, procentajtotalmandate, procentajtotalvoturipartid, procentajtotalvoturi, 
--procentajtotalvoturiconsjud, procentajtotalvoturiconslocal, procentajtotalvoturideputat, procentajtotalvoturieuro, 
--procentajtotalvoturiprimar, procentajtotalvoturiprimarcap, procentajtotalvoturisenat, tip_alegeri, totalmandate, totalvoturi, 
--totalvoturiconsjud, totalvoturiconslocal, totalvoturideputat, totalvoturieuro, totalvoturipartid, totalvoturiprimar, 
--totalvoturiprimarcap, totalvoturisenat, turulalegerilor)
--VALUES (6, to_date('20/05/90', 'DD/MM/YY'), 2.5 , 7.02, 94.13, null,null, 2.56, null,null, null, 0,84, 'GENERALE', 13, 13956180, null, null
--, 351357, null, null, null, null,  300473,1 );
--INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (6, 'NOT','AUR','Alianța pentru Unitatea Românilor','Alianța pentru Unitatea Românilor', 1);
--INSERT INTO public.alegeri_partid(id_alegeri, id_partid)VALUES (1, 6);
COMMIT;

--*/

	
	
	
	
	
	
	
	
	
	
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
		
		
		
		
	
	
	
	
	
		

	
	
	
	
	

	
	
	
	
		
		
		


	
	
	
	

	
	
	

	
	


	
	
	
		
	
	

	
	
	
	
	

	
	

	
	
	
	




