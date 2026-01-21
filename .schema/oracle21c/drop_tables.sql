/*
SELECT 'DROP TABLE ' || table_name || ' PURGE;' AS "--" FROM user_tables 
UNION
SELECT 'DROP VIEW ' || view_name || ';' AS "--" FROM user_views 
*/
--
