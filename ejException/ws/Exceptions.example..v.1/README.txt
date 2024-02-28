Esta es una versión inicial de un programa que calcula los gastos totales 
de una cuenta bancaria cuyos movientos están reflejados en un fichero de texto
(una línea por movimiento)
 
	Cada línea tiene tres partes (campos) <fecha> <descripcion> <cantidad>. Cada campo está separado  
del siguiente por un tabulador ('\t').

	Que puede suceder en en este contexto:

	- El fichero no exista
	- El fichero esté vacío
	- El fichero tenga líneas en blanco
	- Algunas líneas tienen menos campos de los esperados
	- Algunos campos tienen errores de formato. Por ejemplo un campo numérico con letras, 
		fechas equivocadas, etc.
	- El programa se queda sin memoria
	- Se produce un error de hardware: memoria, procesador, etc.
	- Alguien desenchufa el USB mientras se está leyendo un fichero
	
	Hay diversas situaciones en la que la ejecución se rompe. El objetivo 
	de las excepciones es dejar la aplicación en un estado estable para que continue la ejecución y que se pare la ejecución
	pero no bruscamente. 
	