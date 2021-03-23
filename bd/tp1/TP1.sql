SELECT * FROM dual;

CREATE TABLE matable(
    i int;
);

INSERT INTO matable VALUES (1);

SELECT count(*) FROM matable;

CREATE VIEW max AS
SELECt max(i) AS i 
FROM matable;

INSERT INTO matable (
    SELECT matable.i+max.i FROM matable,
    max
);

explain plan for select * from matable; 
SELECT plan_table_output  FROM TABLE(DBMS_XPLAN.DISPLAY('plan_table',null,'typical')); 

select /*+ gather_plan_statistics */i from matable;
select SQL_TEXT,BUFFER_GETS, PHYSICAL_READ_BYTES from v$sql where SQL_ID=:LIVESQL_LAST_SQL_ID; 

-- Stockage séquentiel 
select i from matable where i=42;
select SQL_TEXT,BUFFER_GETS, PHYSICAL_READ_BYTES from v$sql where SQL_ID=:LIVESQL_LAST_SQL_ID; 
explain plan for select * from matable where i=42; 
SELECT plan_table_output  FROM TABLE(DBMS_XPLAN.DISPLAY('plan_table',null,'typical')); 


select i from matable where i>42 and i<451;
select SQL_TEXT,BUFFER_GETS, PHYSICAL_READ_BYTES from v$sql where SQL_ID=:LIVESQL_LAST_SQL_ID; 
explain plan for * from matable where i> 42 and i<451;
SELECT plan_table_output  FROM TABLE(DBMS_XPLAN.DISPLAY('plan_table',null,'typical'));

--Stockage arbre B+
CREATE UNIQUE INDEX matable_unique_index ON matable(i);

select * from matable where i=42;
select SQL_TEXT,BUFFER_GETS, PHYSICAL_READ_BYTES from v$sql where SQL_ID=:LIVESQL_LAST_SQL_ID; 



-- INDEX DE HACHAGE
CREATE CLUSTER matable_hash_index (i int)   
   SIZE 600
   TABLESPACE LIVESQL_USERS
   STORAGE (INITIAL 200K   
      NEXT 300K   
      MINEXTENTS 2   
      PCTINCREASE 33) 

HASH IS i HASHKEYS 150; 

--creation de la table matableh
CREATE TABLE matableh (i int);
CLUSTER matable_hash_index (i);