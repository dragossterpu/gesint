


select sum(locuitori) AS POPULATIE ,code_province from plocality where code_province='AR' 
GROUP BY code_province;
select * from pprovince where code_province='AR';

CREATE TEMP TABLE tabla_temporal as(select sum(locuitori) AS POPULATIE ,code_province from plocality where code_province='VN' GROUP BY code_province ); 
UPDATE pprovince p SET population = t.populatie from tabla_temporal t  where p.code_province='VN' and p.code_province= t.code_province; 
drop table tabla_temporal;



CREATE TEMP TABLE tabla_temporal  AS select ROUND(locuitori-(locuitori*0.15)) as locuitori, name  from plocality  where code_province='VN' ;
UPDATE plocality p SET locuitori = t.locuitori from tabla_temporal t  where code_province='VN' and p.name= t.name; 
drop table tabla_temporal;

--Aumentar 0,5%
select ROUND(locuitori+(locuitori*0.05)) as locuitori, name  from plocality  where code_province='VN'


CREATE TABLE statistica
(
  id numeric NOT NULL,
  tip_statistica character varying(20),
  descripcion character varying(255),
  fecha_alta timestamp without time zone NOT NULL,
  marca character varying(20),
  nume character varying(50),
  code_province character varying(3),
  populatie_totala bigint,
  membrii bigint,
  populatie_vot bigint,
  procentaj real,
  valoare character varying(15),
  CONSTRAINT statistica_pkey PRIMARY KEY (id)
)
--Secventa id
CREATE SEQUENCE SEQ_STATISTICA
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 999999999999999999
    CACHE 1;
	
-- procentaje judete totale
CREATE TEMP TABLE tabla_temporal  AS
select COUNT(*) as loc, p.population, p.code_province,p.name ,
(select ROUND(p.population-(p.population*0.21)) as locuitori) as vot, 
((select COUNT(*) from users u,pprovince p where u.code_province=p.code_province)  *100 /  ROUND(p.population-(p.population*0.15))) AS porcentaje
from users u, pprovince p where u.code_province=p.code_province  GROUP BY p.population,p.code_province;
update tabla_temporal set porcentaje=round( CAST(float8 (loc*100 /vot) as numeric), 2);

--insertamos los datos
INSERT INTO public.statistica(
            id, tip_statistica, descripcion, fecha_alta, marca, 
             nume, code_province, populatie_totala, membrii, 
            populatie_vot, procentaj,isjudet)
 SELECT 
  nextval('SEQ_STATISTICA'), 
'LUNAR',--tip_statistica
 null, --descripcion
 current_date,
 'Ianuarie 2019',--marca
 name, --nume
 code_province,--codul judetului
population, --populatie totala
 loc, --membrii inregistrati
vot, --populatie cu drept de vot 
 porcentaje, --procentaj
 true
from tabla_temporal ;

update statistica set valoare= 'EXCELENT' where procentaj >= 0.40;
update statistica set valoare= 'BUN' where procentaj < 0.40 and procentaj >= 0.25;
update statistica set valoare= 'ACCEPTABIL' where procentaj < 0.25 and procentaj >= 0.10;
update statistica set valoare= 'NECONVINGATOR' where procentaj < 0.10;
update statistica set descripcion= 'Rezultate județe' ;

-- procentaje localitati totale
CREATE TEMP TABLE tabla_temporal  AS
select COUNT(*) as loc, p.locuitori, p.code_province,p.name ,
(select ROUND(p.locuitori-(p.locuitori*0.21)) as locuitori) as vot, 
((select COUNT(*) from users u,plocality p where u.code_province=p.code_province)  *100 /  ROUND(p.locuitori-(p.locuitori*0.15))) AS porcentaje
from users u, plocality p where u.code_province=p.code_province and p.id= u.locality_id 
GROUP BY p.locuitori, p.code_province, p.name order by p.code_province;
update tabla_temporal set porcentaje=round( CAST(float8 (loc*100 /vot) as numeric), 2);

--insertamos los datos
INSERT INTO public.statistica(
            id, tip_statistica, descripcion, fecha_alta, marca, 
             nume, code_province, populatie_totala, membrii, 
            populatie_vot, procentaj,isjudet)
 SELECT 
  nextval('SEQ_STATISTICA'), 
'LUNAR',--tip_statistica
 'Rezultate localități', --descripcion
 current_date,
 'Ianuarie 2019',--marca
 name, --nume
 code_province,--codul judetului
locuitori, --populatie totala
 loc, --membrii inregistrati
vot, --populatie cu drept de vot 
 porcentaje, --procentaj
 false
from tabla_temporal ;

update statistica set valoare= 'EXCELENT' where procentaj >= 0.40;
update statistica set valoare= 'BUN' where procentaj < 0.40 and procentaj >= 0.25;
update statistica set valoare= 'ACCEPTABIL' where procentaj < 0.25 and procentaj >= 0.10;
update statistica set valoare= 'NECONVINGATOR' where procentaj < 0.10;

SELECT * FROM STATISTICA;

select * from tabla_temporal;
drop table tabla_temporal;


select count(*) as numarTotal, 
(select count(*) from users where education= 'LICEU') AS totalcuLiceu,
(select count(*) from users where education= 'STUDIISUPERIOARE') AS totalStudiiSup,
(select count(*) from users where education= 'BAZIC') AS totalBazice,
(select SUM(population)from pprovince)as locuitoriTotal, 
(select count(*) from users where sex= 'MAN') AS totalBarbati,
(select count(*) from users where sex= 'WOMAN') as totalFemei,
(select distinct round((select SUM(population)from pprovince)- ((select SUM(population)from pprovince)*0.21)) as locuitori from pprovince ) as totalVot,
(select count(*)  from users where date_create between date '2019-01-10' and date '2019-02-10') as totalUltimaLuna,
(select count(*)  from users where date_create between date '2018-12-10' and date '2019-02-10') as totalUltimTDouaLuni,
(select count(*)  from users where date_create between date '2018-11-10' and date '2019-02-10') as totalUltimTreiLuni,
(select count(*)  from users where date_create between date '2018-10-10' and date '2019-02-10') as totalUltimPatruLuni,
(select count(*)  from users where date_create between date '2018-09-10' and date '2019-02-10') as totalUltimCinciLuni,
(select count(*)  from users where date_create between date '2018-08-10' and date '2019-02-10') as totalUltimSaseLuni,
(select count(*)  from users where date_create between date '2018-07-10' and date '2019-02-10') as totalUltimSapteLuni,
(select count(*)  from users where date_create between date '2018-06-10' and date '2019-02-10') as totalUltimOptLuni,
(select count(*)  from users where date_create between date '2018-05-10' and date '2019-02-10') as totalUltimNouaLuni,
(select count(*)  from users where date_create between date '2018-04-10' and date '2019-02-10') as totalUltimZeceLuni,
(select count(*)  from users where date_create between date '2018-03-10' and date '2019-02-10') as totalUltimUnspeLuni,
(select count(*)  from users where date_create between date '2018-02-10' and date '2019-02-10') as totalUltimAn,
(select count(*)  from users where date_create between date '2018-01-10' and date '2018-02-10') as totalUltimaLunaAnAtras,
(select count(*)  from users where date_create between date '2017-12-10' and date '2018-02-10') as totalUltimDouaLuniAnAtras,
(select count(*)  from users where date_create between date '2017-11-10' and date '2018-02-10') as totalUltimTreiLuniAnAtras,
(select count(*)  from users where date_create between date '2017-10-10' and date '2018-02-10') as totalUltimPatruLuniAnAtras,
(select count(*)  from users where date_create between date '2017-09-10' and date '2018-02-10') as totalUltimCinciLuniAnAtras,
(select count(*)  from users where date_create between date '2017-08-10' and date '2018-02-10') as totalUltimSaseLuniAnAtras,
(select count(*)  from users where date_create between date '2017-07-10' and date '2018-02-10') as totalUltimSapteLuniAnAtras,
(select count(*)  from users where date_create between date '2017-06-10' and date '2018-02-10') as totalUltimOptLuniAnAtras,
(select count(*)  from users where date_create between date '2017-05-10' and date '2018-02-10') as totalUltimNouaLuniAnAtras,
(select count(*)  from users where date_create between date '2017-04-10' and date '2018-02-10') as totalUltimZeceLuniAnAtras,
(select count(*)  from users where date_create between date '2017-03-10' and date '2018-02-10') as totalUltimUnspeLuniAnAtras,
(select count(*)  from users where date_create between date '2017-02-10' and date '2018-02-10') as totalUltimiDoiAni,
(select count(*)  from users where date_create between date '2016-02-10' and date '2017-02-10') as totalUltimiiTreiAni,
(select count(*)  from users where date_create between date '2015-02-10' and date '2016-02-10') as totalUltimiiPatruAni,
(select count(*)  from users where date_create between date '2014-02-10' and date '2015-02-10') as totalUltimiiCinciAni,
(select count(*) from users u, plocality l where  u.LOCALITY_ID = l.id and l.nivel =3)as mediuRural,
(select count(*) from users u, plocality l where  u.LOCALITY_ID = l.id and l.nivel in(2,3))as mediuUrban,
(select SUM(locuitori) from plocality where nivel =3) as locuitoriTotalRural, 
(select SUM(locuitori) from plocality where nivel in(2,3)) as locuitoriTotalUrban 
from users 