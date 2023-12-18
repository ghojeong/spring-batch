URL='-h localhost -P 12345 --protocol=tcp'
USER=root
PW=rootPassword
DB=dfdb
SCHEMA_SQL='./schema.sql'

mysql $URL -u $USER -p$PW $DB < $SCHEMA_SQL

