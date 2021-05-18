CREATE TABLE jugador(
                        id serial PRIMARY KEY,
                        nombre varchar(255) not NULL,
                        goles integer,
                        equipo varchar(100) not null
);