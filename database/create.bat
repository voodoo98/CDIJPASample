psql -d postgres -h localhost -p 5432 -U postgres -f create-database.sql
psql -d cdisample -h localhost -p 5432 -U postgres -f create-schema.sql
