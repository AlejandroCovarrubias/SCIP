ALTER TABLE conceptos DROP FOREIGN KEY FK_conceptos_idConcepto
ALTER TABLE tareas DROP FOREIGN KEY FK_tareas_idUsuario
ALTER TABLE tareas DROP FOREIGN KEY FK_tareas_idTarea
ALTER TABLE trabajos DROP FOREIGN KEY FK_trabajos_RFC
ALTER TABLE trabajos DROP FOREIGN KEY FK_trabajos_idUsuario
DROP TABLE usuarios
DROP TABLE clientes
DROP TABLE conceptos
DROP TABLE tareas
DROP TABLE trabajos
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'assigned'
