FROM postgres:16.1

COPY schema.sql /docker-entrypoint-initdb.d/

EXPOSE 5432

CMD ["postgres"]