INSERT INTO tb_usuario (username, password) VALUES ('root', '$2a$10$/tBumoq6gOi1swsRVzefPemn9bgvSI9P5t3BjGtLcSrdl7v2rq4SS');

INSERT INTO tb_rol (id_usuario, nombre) VALUES (1, 'ROLE_ADMIN');

INSERT INTO tb_moneda (descripcion) VALUES ('PEN');
INSERT INTO tb_moneda (descripcion) VALUES ('USD');
INSERT INTO tb_moneda (descripcion) VALUES ('EUR');

INSERT INTO tb_tipo_cambio (tipo_cambio, id_moneda_origen, id_moneda_destino) VALUES (3.90, 1, 2);
INSERT INTO tb_tipo_cambio (tipo_cambio, id_moneda_origen, id_moneda_destino) VALUES (4.00, 1, 3);

INSERT INTO tb_tipo_cambio (tipo_cambio, id_moneda_origen, id_moneda_destino) VALUES (3.90, 2, 1);
INSERT INTO tb_tipo_cambio (tipo_cambio, id_moneda_origen, id_moneda_destino) VALUES (1.05, 2, 3);

INSERT INTO tb_tipo_cambio (tipo_cambio, id_moneda_origen, id_moneda_destino) VALUES (4.00, 3, 1);
INSERT INTO tb_tipo_cambio (tipo_cambio, id_moneda_origen, id_moneda_destino) VALUES (1.05, 3, 2);


