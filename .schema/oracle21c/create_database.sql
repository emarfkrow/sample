/*
sqlplus / AS sysdba

show pdbs

    CON_ID CON_NAME                       OPEN MODE  RESTRICTED
---------- ------------------------------ ---------- ----------
         2 PDB$SEED                       READ ONLY  NO
         3 ORCLPDB                        MOUNTED

ALTER PLUGGABLE DATABASE ALL OPEN;

ALTER SESSION SET container = orclpdb;

ALTER PROFILE DEFAULT LIMIT password_life_time unlimited;

SELECT * FROM all_users WHERE common = 'NO' ORDER BY username;

DROP USER emarf CASCADE;
*/

CREATE USER emarf IDENTIFIED BY emarf;

GRANT CREATE SESSION TO emarf;

GRANT CREATE TABLE TO emarf;

GRANT CREATE VIEW TO emarf;

GRANT UNLIMITED TABLESPACE TO emarf;
