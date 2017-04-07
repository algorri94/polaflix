# Polaflix

## REST API
##### /series
	GET: Obtiene la lista de todas las series
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
##### /usuarios/{$username}/series
	GET: Obtiene las series del usuario cuyo username es $username
	PUT: Añade una serie a la lista de series del usuario
##### /usuarios/{$username}/series/{$name}
	GET: Obtiene una serie cuyo nombre es $name del usuario cuyo username es $username
	PUT: Modifica la serie
	DELETE: Borra la serie
##### /usuarios/{$username}/facturas
	GET: Obtiene las facturas del usuario cuyo username es $username
##### /usuarios/{$username}/facturas/{$year}
	GET: Obtiene las facturas del año $year del usuario cuyo username es $username
##### /usuarios/{$username}/facturas/${month}
	GET: Obtiene las facturas del mes $month del año $year del usuario cuyo username es $username