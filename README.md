# Polaflix

## REST API
##### /series
	GET: Obtiene la lista de todas las series
##### /series/{$name}
	GET: Obtiene una serie cuyo nombre es $name
##### /usuarios/{$username}
	GET: Obtiene un usuario cuyo username es $username
##### /usuarios/{$username}/pendientes/{$id}
	POST: Añade la serie cuyo id es $id a la lista de series pendientes del usuario
##### /usuarios/{$username}/empezadas/{$id}
	GET: Obtiene los capitulos visualizados por el usuario cuyo username es $username de la serie cuyo id es $id 
	PUT: Añade la serie cuyo id es $id a la lista de series empezadas del usuario y registra
	el episodio de la temporada recibida como visualizado. En caso de estar ya empezada, simplemente
	registra el episodio como visualizado.
		QueryParams:
			- temporada: Número de la temporada del episodio visualizado
			- episodio: Número del episodio visualizado
##### /usuarios/{$username}/facturas
	GET: Obtiene las facturas del usuario cuyo username es $username
