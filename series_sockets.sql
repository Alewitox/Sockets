
drop database if exists series_sockets;
create database series_sockets;
use series_sockets;

CREATE TABLE `series` (
  `id` int(5) NOT NULL,
  `nombre` varchar(256) NOT NULL,
  `sinopsis` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

insert into series values (1, 'Breaking Bad', 'Un profesor de química de un instituto de Albuquerque, se entera de que tiene un cáncer de pulmón incurable. Decide, con la ayuda de un antiguo alumno, fabricar anfetaminas y ponerlas a la venta.');
insert into series values (2, 'Prison Break', 'Lincoln es sentenciado a muerte. Michael Scofield, el hermano menor de Lincoln, está convencido de la inocencia de su hermano y elabora un plan de escape de la prisión.');
insert into series values (3, 'Lost', 'Historia de un variopinto grupo de supervivientes de un accidente de aviación en una isla del Pacífico aparentemente desierta, una isla en la que suceden cosas muy extrañas.');
insert into series values (4, 'Friday Night Lights', 'Los habitantes de una pequeña ciudad tejana viven el deporte como si fuera una religión. Para ellos no hay nada más importante que los Dillon Panthers, el equipo de fútbol americano del instituto de la ciudad.');
insert into series values (5, 'Dark', 'Tras la desaparición de un joven, cuatro familias desesperadas tratan de entender lo ocurrido a medida que van desvelando un retorcido misterio que abarca tres décadas.');