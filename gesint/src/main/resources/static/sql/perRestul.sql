
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
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('8','extensiones','DOC','application/msword');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('9','extensiones','DOCX','application/vnd.openxmlformats-officedocument.wordprocessingml.document');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('10','extensiones','ODT','application/vnd.oasis.opendocument.text');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('11','extensiones','PPT','application/vnd.ms-powerpoint');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('12','extensiones','PPTX','application/vnd.openxmlformats-officedocument.presentationml.presentation');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('13','extensiones','ODP','application/vnd.oasis.opendocument.presentation');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('14','extensiones','XLS','application/vnd.ms-excel');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('15','extensiones','XLSX','application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('16','extensiones','ODS','application/vnd.oasis.opendocument.spreadsheet');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('17','extensiones','JPEG','image/jpeg');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('18','extensiones','PNG','image/png');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('19','extensiones','BMP','image/bmp');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('20','extensiones','PUB','application/x-mspublisher');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('21','extensiones','PDF','application/pdf');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('22','extensiones','ZIP','application/x-zip-compressed');
INSERT INTO public.PROPERTIES (ID,FILENAME,NAME,VALUE) VALUES ('23','HOME','TIMP_ISTORIC_STATISTIC','30');
COMMIT;	
	
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (1,'ANEXE LA RAPORT');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (2,'COMUNICARE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (3,'ALERTA ADMINISTRATIVA ');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (4,'AUDIO');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (5,'CONTROL DE ACTIVITATE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (6,'RAPORT');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (7,'DATE STATISTICE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (8,'DOCUMENTE DE INTRARE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (9,'DOCUMENTE DE IE?IRE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (10,'FI?IER DE MONITORIZARE ?I CONTROL');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (11,'RAPOARTE ISTORICE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (12,'IMAGINE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (13,'NORMA INTERNA');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (14,'ALTELE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (15,'RECLAMA?II');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (16,'RESURSE UMANE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (17,'RESURSE MATERIALE');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (18,'VIDEO');
INSERT INTO public.TIPO_DOCUMENTO (ID,NOMBRE) VALUES (19,'TEMPLATE');
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
INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (1, 'NOT','PSD','Partidul Social Democrat','Frontul Salvarii Na?ionale', 1);
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
INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (2, 'NOT','UDMR','Uniunea Democrata a Maghiarilor din România','Uniunea Democrata a Maghiarilor din România', 1);
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
INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (3, 'NOT','PNL','Partidul Na?ional Liberal','Partidul Na?ional Liberal', 1);
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
INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (4, 'NOT','PER','Partidul Ecologist din România','Mi?carea Ecologista din România', 1);
INSERT INTO public.alegeri_partid(id_alegeri, id_partid)VALUES (1, 4);
COMMIT;

--PN?CD	LEGISLATIVE 1990	
--INSERT INTO public.rezultate(id, data_alegerilor, procentajtotalmandate, procentajtotalvoturipartid, procentajtotalvoturi, 
--procentajtotalvoturiconsjud, procentajtotalvoturiconslocal, procentajtotalvoturideputat, procentajtotalvoturieuro, 
--procentajtotalvoturiprimar, procentajtotalvoturiprimarcap, procentajtotalvoturisenat, tip_alegeri, totalmandate, totalvoturi, 
--totalvoturiconsjud, totalvoturiconslocal, totalvoturideputat, totalvoturieuro, totalvoturipartid, totalvoturiprimar, 
--totalvoturiprimarcap, totalvoturisenat, turulalegerilor)
--VALUES (5, to_date('20/05/90', 'DD/MM/YY'), 2.5 , 7.02, 94.13, null,null, 2.56, null,null, null, 0,84, 'GENERALE', 13, 13956180, null, null
--, 351357, null, null, null, null,  341478,1 );
--INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (5, 'NOT','PN?CD','Partidul Na?ional ??r?nesc Cre?tin Democrat','Partidul Na?ional ??r?nesc Cre?tin Democrat', 1);
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
--INSERT INTO public.partid(id, independent, sigla, nume, old_nume, rezultate) VALUES (6, 'NOT','AUR','Alian?a pentru Unitatea Rom?nilor','Alian?a pentru Unitatea Rom?nilor', 1);
--INSERT INTO public.alegeri_partid(id_alegeri, id_partid)VALUES (1, 6);
COMMIT;

--*/
DROP SEQUENCE public.seq_locality;
DROP SEQUENCE public.seq_pteam;
CREATE SEQUENCE public.seq_locality
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 3188
  CACHE 1;
  
  CREATE SEQUENCE public.seq_pteam
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 18
  CACHE 1;

