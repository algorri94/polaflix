# Polaflix

## REST API
##### /series
	GET: Obtiene la lista de todas las series
		QueryParams:
			- name: Obtiene las series que contengan el string recibido en su nombre
			- initial: Obtiene las series que contengan la letra inicial recibida
	PUT: Añade una serie
##### /series/{$name}
	GET: Obtiene una serie cuyo nombre es $name
	PUT: Modifica la serie
	DELETE: Borra la serie
##### /usuarios
	PUT: Crea un usuario
##### /usuarios/{$username}
	GET: Obtiene un usuario cuyo username es $username
	PUT: Modifica el usuario
	DELETE: Borra el usuario
##### /usuarios/{$username}/pendientes/{$id}
	PUT: Añade la serie cuyo id es $id a la lista de series pendientes del usuario
	DELETE: Borra una serie de la lista de series pendientes del usuario
##### /usuarios/{$username}/empezadas/{$id}
	PUT: Añade la serie cuyo id es $id a la lista de series empezadas del usuario y registra
	el episodio de la temporada recibida como visualizado. En caso de estar ya empezada, simplemente
	registra el episodio como visualizado.
		QueryParams:
			- temporada: Número de la temporada del episodio visualizado
			- episodio: Número del episodio visualizado
##### /usuarios/{$username}/facturas
	GET: Obtiene las facturas del usuario cuyo username es $username
##### /usuarios/{$username}/facturas/{$year}
	GET: Obtiene las facturas del año $year del usuario cuyo username es $username
##### /usuarios/{$username}/facturas/${month}
	GET: Obtiene las facturas del mes $month del año $year del usuario cuyo username es $username
