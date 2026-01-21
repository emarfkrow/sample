/*
SELECT CONCAT ('DROP TABLE ', table_name, ' CASCADE;') AS '--' FROM information_schema.tables WHERE table_schema = 'emarf' AND table_type = 'BASE TABLE'
UNION
SELECT CONCAT ('DROP VIEW ', table_name, ';') AS '--' FROM information_schema.views WHERE table_schema = 'emarf' 
*/
--
