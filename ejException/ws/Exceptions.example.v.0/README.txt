Esta es una versi�n inicial de un programa que calcula los gastos totales 
de una cuenta bancaria cuyos movientos est�n reflejados en un fichero de texto
(una l�nea por movimiento)
 
	Cada l�nea tiene tres partes (campos) <fecha> <descripcion> <cantidad>. Cada campo est� separado  
del siguiente por un tabulador ('\t').

	Que puede suceder en en este contexto:

	- El fichero no exista
	- El fichero est� vac�o
	- El fichero tenga l�neas en blanco
	- Algunas l�neas tienen menos campos de los esperados
	- Algunos campos tienen errores de formato. Por ejemplo un campo num�rico con letras, 
		fechas equivocadas, etc.
	- El programa se queda sin memoria
	- Se produce un error de hardware: memoria, procesador, etc.
	- Alguien desenchufa el USB mientras se est� leyendo un fichero
	
	Hay diversas situaciones en la que la ejecuci�n se rompe. El objetivo 
	de las excepciones es dejar la aplicaci�n en un estado estable para que continue la ejecuci�n y que se pare la ejecuci�n
	pero no bruscamente. 
	