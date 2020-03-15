ALTER TABLE conceptos DROP FOREIGN KEY FK_conceptos_foliotrabajo
ALTER TABLE tareas DROP FOREIGN KEY FK_tareas_foliotrabajo
ALTER TABLE tareas DROP FOREIGN KEY FK_tareas_idUsuario
ALTER TABLE trabajos DROP FOREIGN KEY FK_trabajos_idCliente
ALTER TABLE trabajos DROP FOREIGN KEY FK_trabajos_idUsuario
DROP TABLE usuarios
DROP TABLE clientes
DROP TABLE conceptos
DROP TABLE tareas
DROP TABLE trabajos
