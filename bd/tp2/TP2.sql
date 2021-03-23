--Q2)
explain plan for SELECT * FROM film WHERE titre='Vertigo'; 
SELECT plan_table_output  FROM TABLE(DBMS_XPLAN.DISPLAY('plan_table',null,'typical')); 

--Q3)
explain plan for SELECT nom,prenom FROM film f,artiste a WHERE f.annee=a.annee_naissance and titre='Vertigo'; 
SELECT plan_table_output  FROM TABLE(DBMS_XPLAN.DISPLAY('plan_table',null,'typical')); 

--Q5)
explain plan for SELECT nom,prenom FROM film f,artiste a WHERE f.annee=a.annee_naissance and titre='Vertigo'; 
SELECT plan_table_output  FROM TABLE(DBMS_XPLAN.DISPLAY('plan_table',null,'typical'));

--Q7)
explain plan for SELECT nom,prenom FROM film f,artiste a WHERE f.annee=a.annee_naissance and titre='Vertigo'; 
SELECT plan_table_output  FROM TABLE(DBMS_XPLAN.DISPLAY('plan_table',null,'typical'));

--)Q9
--a) Boucles imbriqués
explain plan for SELECT titre
FROM film f, role r, artiste a 
WHERE a.nom = 'Stewart' AND a.prenom='James' 
AND f.id = r.id_film AND r.id_acteur = a.id AND f.annee = 1958;
SELECT plan_table_output  FROM TABLE(DBMS_XPLAN.DISPLAY('plan_table',null,'typical'));

--b)
explain plan for SELECT titre FROM film f, role r WHERE f.id = r.id_film AND f.annee = 1958 AND r.id_acteur 
IN (
    SELECT id FROM Artiste WHERE nom=’Stewart’ AND prenom= ’James’ 
);
SELECT plan_table_output  FROM TABLE(DBMS_XPLAN.DISPLAY('plan_table',null,'typical'));