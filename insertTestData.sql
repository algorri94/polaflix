INSERT INTO tipo_serie(id, precio, tipo) VALUES (1, 0.5,'STANDARD');
INSERT INTO tipo_serie(id, precio, tipo) VALUES (2, 0.75,'SILVER');
INSERT INTO tipo_serie(id, precio, tipo) VALUES (3, 1.5,'GOLD');

INSERT INTO serie(id, descripcion, titulo, tipo_serie_id) VALUES (1, 'Un hacker que quiere acabar con el corporativismo', 'Mr. Robot', 1);
INSERT INTO serie(id, descripcion, titulo, tipo_serie_id) VALUES (2, 'La vida de una tribu vikinga con mucha ambición', 'Vikings', 3);
INSERT INTO serie(id, descripcion, titulo, tipo_serie_id) VALUES (3, 'Un chaval que combate el mal corriendo muy rápido', 'The Flash', 2);
INSERT INTO serie(id, descripcion, titulo, tipo_serie_id) VALUES (4, 'Un médico que cura pacientes con la ironía', 'House', 3);
INSERT INTO serie(id, descripcion, titulo, tipo_serie_id) VALUES (5, 'Unos moteros que se creen muy guays', 'Sons of Anarchy', 1);
INSERT INTO serie(id, descripcion, titulo, tipo_serie_id) VALUES (6, 'Un hombre que viaja en el tiempo', 'Dr. Who', 2);

#Mr. Robot
#Temporadas
INSERT INTO temporada(id, num_temporada, serie_id) VALUES (1, 1, 1);
#Episodios
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (1, 'Elliot Alderson trabaja en Allsafe, una empresa de seguridad informática. Por la noche, se dedica a hackear las cuentas de redes sociales y bancarias de sus amigos y conocidos, además de utilizar sus habilidades para perseguir y entregar a la policía a criminales. ', 1, 'eps1.0_hellofriend.mov',1);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (2, 'Elliott rechaza una bien remunerada oferta de trabajo ofrecida por Tyrell Wellick, el nuevo CTO provisional de E Corp. En un vídeo público, fsociety pide la liberación de Terry Colby, junto con la disolución de Evil Corp (E Corp).', 2, 'eps1.1_ones-and-zer0es.mpeg', 1);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (3, 'Tyrell pega una paliza a un mendigo para liberar estrés. Seguidamente, tiene relaciones con un hombre para conseguir instalar un rootkit en su teléfono. Cisco, un supuesto cantante de rap que consigue hackear a Ollie a través de su CD, le chantajea con su affair con una tal Stella para que comprometa la seguridad de AllSafe. ', 3, 'eps1.2_d3bug.mkv', 1);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (4, 'En vez de hacer volar los gasoductos, Elliot planea destruir las cintas de backup en Steel Mountain hackeando el sistema de control de clima, pero esto requiere acceso físico, para lo que una parte del grupo viaja al norte de New York. Sin morfina ni suboxe, Elliot sufre un ataque de abstinencia, y el grupo tienen que esperar a que pasen los síntomas en un hotel.', 4, 'eps1.3_da3m0ns.mp4', 1);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (5, 'Con la ayuda de fsociety, Elliot se infiltra en Steel Mountain. Las cosas no van muy bien hasta que accidentalmente se encuentra con Tyrell, al final consigue plantar el dispositivo para realizar el ataque. Darlene se entera que Dark Army ha cambiado de opinión acerca de atacar simultáneamente las copias de resguardo en China, lo que pone todo el plan en peligro', 5, 'eps1.4_3xpl0its.wmv', 1);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (6, 'Isaac, hermano de Fernando, y su amigo DJ le dan unos minutos a Elliot para que pueda hablar en un restaurante con Shayla. Fernando le avisa a Elliot que para recuperar a Shayla tendrá que hackear la cárcel para que las puertas se abran y pueda escapar. De vuelta en su departamento Elliot es vigilado por Isaac mientras trabaja para hackear el sistema de seguridad de la cárcel.', 6, 'eps1.5_br4ve-trave1er.asf', 1);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (7, 'El episodio transcurre un mes luego de los incidentes en la prisión, Elliot terminó de cumplir el año de terapia que la justicia le había ordenado. Krista se despide de él pero lo incentiva para que continúe yendo. Unos días después de la última sesión regresa y le confiesa que es un hacker y que ha estado interviniendo sus cuentas.', 7, 'eps1.6_v1ew-s0urce.flv', 1);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (8, 'Allsafe, la empresa de seguridad cibernética en la que Elliot trabaja, ha sido hackeada. Ollie, el ex novio de Angela, le pide a Elliot que lleve unos discos rígidos infectados a un local donde los van a blanquear. Al llegar al lugar Elliot se da cuenta de que todo forma parte de un plan que lo lleva a conocer a whiterose.', 8, 'eps1.7_wh1ter0se.m4v', 1);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (9, 'Elliot exige saber por qué Mr. Robot no le dijo que estaba vivo durante esos últimos veinte años. Mr. Robot promete llevarlo a un lugar donde Elliot podrá entenderlo todo. De regreso en la casa de su infancia, Elliot y Mr. Robot discuten acerca del incidente de la ventana y Elliot termina empujándolo por la ventana.', 9, 'eps1.8_m1rr0r1ng.qt', 1);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (10, 'Elliot despierta en el auto de Tyrell Wellick sin conocimiento de por qué está ahí o que ha sucedido. Al continuar el episodio se confirma que la destrucción de datos de E Corp realizada por fsociety en conjunto con Dark Army ha sido exitosa y se pueden ver las repercusiones que esta decisión toma en la sociedad.', 10, 'eps1.9_zer0-day.avi', 1);

#Vikings
#Temporadas
INSERT INTO temporada(id, num_temporada, serie_id) VALUES (2, 1, 2);
INSERT INTO temporada(id, num_temporada, serie_id) VALUES (3, 2, 2);
#Episodios
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (11, 'En plena batalla, Ragnar tiene visiones del dios Odín y sus valquirias. De regreso a casa, y contra la opinión de su mujer, Ladgerda, decide llevar a su hijo Bjorn a Kattegat donde el joven realizará su rito de iniciación. Mientras, Ladgertha, sola en casa junto a sus dos hijos menores, tiene que enfrentarse a dos violadores, de los que se deshace con facilidad. En Kattegat, Ragnar se encuentra con su hermano Rollo, a quien expone su obsesión: es posible navegar hacia el oeste, donde esperan otras tierras y nuevas riquezas.', 1, 'Ritos iniciáticos', 2);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (12, 'Tras reunir un grupo de voluntarios, Ragnar, Rollo y Floki se echan a la mar hacia las tierras del oeste. Lagerda también quería participar en la expedición, pero Ragnar se niega violentamente a ello. Un espía informa de todo ello al conde Haraldson, que ordena matar de forma ejemplar al herrero que ha fabricado el ancla de la nueva embarcación. El espía no correrá mejor suerte cuando Siggy, la mujer de Haraldson pone a prueba su fidelidad al conde.', 2, 'La ira de los nórdicos', 2);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (13, 'La expedición de Ragnar regresa triunfal a Kattegat, pero allí las fuerzas del conde les despojan del botín, permitiéndoles sólo escoger una pieza por cada hombre. Ragnar elige a Athelstan y regresa a casa. La fe del monje y su voto de castidad le dejan perplejo, pero logra que Athelstan le dé mucha información sobre el reino de Norteumbría.', 3, 'Despojados', 2);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (14, 'Los vikingos asaltan un pueblo de Norteumbría causando pocas víctimas, dado que los lugareños están en misa, pero Ladgerda mata a Knut cuando este trata de violarla. Al regresar a la playa, los guerreros derrotan a un amplio número de fuerzas británicas, lideradas por lord Wigea por orden del rey Aelle. De vuelta a Kattegat, Ragnar se inculpa de la muerte de Knut, por lo que el conde Haraldson ordena su detención para ser juzgado por la Thing.', 4, 'Juicio', 2);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (15, 'Los hombres del conde Haraldson atacan la granja de Ragnar, matando a todo el que se les pone a tiro. Ragnar, Ladgerda, Athelstan y los niños logran escapar en un barco, pero el cabeza de familia está gravemente herido. La familia se refugia en casa de Floki donde Ragnar se recupera poco a poco.', 5, 'La batida', 2);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (16, 'El conde acepta el desafío de Ragnar. Como resultado del combate, Ragnar mata a Haraldson, Rollo mata a Svein, y Siggy mata a su desafortunado yerno. Ragnar es aclamado como nuevo conde y ofrece a su antecesor un funeral de honor en el mar.', 6, 'El funeral', 2);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (17, 'Los vikingos levantan un campamento fortificado, asaltan a las fuerzas de Northumbría por la noche y capturan al hermano del rey, Aethelwulf. En un encuentro con el monarca, Ragnar pide 2.000 libras de oro y plata a cambio de su marcha. Aelle acepta pero exige que uno de los vikingos sea bautizado como cristiano.', 7, 'El rescate de un rey', 2);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (18, 'Como Ladgerda ya no puede tener más hijos, Ragnar se lleva a su familia y seguidores al templo de Upsala para asistir a un gran rito que se celebra cada nueve años. Allí, jura fidelidad al rey Horik de Dinamarca, quien designa a Ragnar embajador ante el Jarl Borg de Gotaland, un rival que quiere usurpar las tierras de Horik.', 8, 'Sacrificio', 2);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (19, 'La embajada de Ragnar ante el conde Jarl Borg en Gotaland falla cuando el rey Horik de Dinamarca rechaza un compromiso acerca de la tierra en disputa. Conducido por la ambición y la envidia, Rollo decide apoyar a Borg en contra de Ragnar en el enfretamiento que se avecina como resultado del desacuerdo.', 9, 'Todo cambia', 2);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (20, 'Comienza la batalla entre Ragnar y las fuerzas del rey Horik contra Jarl Borg.', 1, 'Guerra de hermanos',3);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (21, 'Han pasado cuatro años de paz desde que Ragnar se convirtió en Earl. Ha llegado el momento de que se produzca una alianza insólita para un objetivo en común: una nueva incursión a Inglaterra.', 2, 'Invasión',3);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (22, 'La incursión vikinga a Wessex está en pleno apogeo y el rey Ecbert se encuentra enfrentado a un enemigo diferente.', 3, 'Traición',3);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (23, 'La reunión de dos grandes hombres podría allanar el camino para un pacto futuro cuando Ragnar y Ecbert se encuentran cara a cara.', 4, 'Ojo por ojo',3);
#Creador
INSERT INTO persona(dtype, id, apellido, nombre) VALUES ('CREADOR',1, 'Hirst', 'Michael');
INSERT INTO serie_artistas(serie_id, artistas_id) VALUES (2,1);
#Actores
INSERT INTO persona(dtype, id, apellido, nombre) VALUES ('ACTOR', 2, 'Fimmel', 'Travis');
INSERT INTO serie_artistas(serie_id, artistas_id) VALUES (2,2);
INSERT INTO persona(dtype, id, apellido, nombre) VALUES ('ACTOR', 3, 'Byrne', 'Gabriel');
INSERT INTO serie_artistas(serie_id, artistas_id) VALUES (2,3);
INSERT INTO persona(dtype, id, apellido, nombre) VALUES ('ACTOR', 4, 'Winnick', 'Katheryn');
INSERT INTO serie_artistas(serie_id, artistas_id) VALUES (2,4);
INSERT INTO persona(dtype, id, apellido, nombre) VALUES ('ACTOR', 5, 'Standen', 'Clive');
INSERT INTO serie_artistas(serie_id, artistas_id) VALUES (2,5);


#The Flash
#Temporadas
INSERT INTO temporada(id, num_temporada, serie_id) VALUES (4, 1, 3);
#Episodios
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (24, 'Después de que su madre fuera asesinada y su padre acusado por tal crimen y enviado a prisión, cuando tenía once años, Barry Allen fue criado por Joe West, el padre de su mejor amiga Iris. Ahora, convertido en un brillante investigador forense, quien está determinado a descubrir la verdad sobre la extraña muerte de su madre le lleva a seguir todas las leyendas urbanas sin explicación y los avances científicos que surjan.', 1, 'Pilot', 4);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (25, 'Barry acompaña a Iris a una gala en honor de Simon Stagg. Cuando seis hombres armados irrumpen en el lugar, Flash aparece e intenta detenerlos pero se desmaya antes de poder hacerlo. Mientras el Dr.Harrison Wells, Caitlin y Cisco intentan averiguar qué está mal con Barry, Joe se preocupa porque Barry puso su vida en peligro.', 2, 'Fastest Man Alive', 4);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (26, 'Mientras Barry y el equipo de S.T.A.R. Labs trabajan para detener a Kyle Nimbus/Niebla, un nuevo y peligroso metahumano con el poder de producir y transformarse en gas tóxico, deben revivir la noche de la explosión del acelerador de partículas que mató a Ronnie, el prometido de Caitlin.', 3, 'Things You Can\'t Outrun', 4);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (27, 'Flash detiene un robo pero los ladrones logran escapar después de dispararle a un guardia. Barry identifica a Leonard Snart como el líder de los asaltantes y mientras investiga el caso, recibe la visita de Felicity Smoak, quien se ha enterado de sus nuevas habilidad ha llegado a la ciudad para comprobarlas por sí misma. Felicity se une al equipo para tratar de detener a Snart, quien posee una arma de frío que podría asesinar a Flash.', 4, 'Going Rogue', 4);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (28, 'Después de que una bomba explotara en el centro de la ciudad, el ejército, liderado por el General Eiling aparece y se hace cargo del caso, para sorpresa de Joe. Con la sospecha de que algo anda mal, Joe le pide a Barry y al equipo de S.T.A.R. Labs que investigue el caso. El Dr.Wells revela que el general Eiling estuvo experimentando con sus hombres para convertirlos en súper soldados. Cisco confirma que uno de los hombres de Eiling, Bette Sans Suci/Plastique estuvo en el lugar de la explosión.', 5, 'Plastique', 4);
INSERT INTO episodio(id, descripcion, num_episodio, titulo, temporada_id) VALUES (29, 'Barry Allen/ The Flash enfrenta a un nuevo metahumano llamado Tony Woodward/Girder, quien puede transformarse en una viga de acero a voluntad. Mientras el Dr.Wells y Caitlin están preocupados por la seguridad de Barry, Cisco idea un plan para derrotar a Tony. Por otra parte, los reportajes de Iris sobre Flash la meten en problemas y Eddie presencia la habilidad de Tony y comienza a hacer preguntas que Joe no desea responder.', 6, 'The Flash is Born', 4);


INSERT INTO usuario(tipo_usuario, id, isban, password, username, cuota) VALUES ('CUOTA', 1, 'ES0737483746583927364857', 'lokillo', 'bartolo', 20);
INSERT INTO usuario(tipo_usuario, id, isban, password, username, cuota) VALUES ('NORMAL', 2, 'ES0538475629329229382938', 'tobi56', 'zubi', 0);
INSERT INTO usuario(tipo_usuario, id, isban, password, username, cuota) VALUES ('NORMAL', 3, 'ES0746282828283776462738', 'harambe', 'grefusa', 0);