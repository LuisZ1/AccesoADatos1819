USE Db_Primitiva

--Implementa un procedimiento almacenado GrabaSencilla que grabe un boleto con una sola apuesta simple. Datos de entrada: El sorteo y los seis números

/*
El procedimiento almacenado insertará la apuesta realizada
ENTRADA: La fecha del sorteo al que se quiere apostar y los seis numeros de la apuesta
*/
GO
CREATE PROCEDURE GrabaSencilla 
	@sorteo date, @n1 tinyint, @n2 tinyint, @n3 tinyint, @n4 tinyint, @n5 tinyint, @n6 tinyint
AS
	BEGIN
		INSERT INTO [dbo].[Apuestas]([FechaSorteo],[FechaApuesta],[HoraApuesta],[Precio],[n1],[n2],[n3],[n4],[n5],[n6])
			VALUES (@sorteo, CAST(GETDATE() AS date), CAST(GETDATE() AS time), 1, @n1, @n2, @n3, @n4, @n5, @n6)
	END
GO
--DROP PROCEDURE GrabaSencilla

--Genera un numero aleatorio del 1 al 49 y lo devuelve
CREATE PROCEDURE GeneraNumeroAleatorioParaBoleto @Aleatorio int OUTPUT AS
BEGIN
	DECLARE @Random int
	DECLARE @Upper int
	DECLARE @Lower int

	SET @Lower = 1 
	SET @Upper = 49
	SELECT @Random = FLOOR (((@Upper - @Lower + 1 ) * RAND() + @Lower))
	SET @Aleatorio = @Random
	RETURN @Aleatorio
END
GO
--DROP PROCEDURE GeneraNumeroAleatorioParaBoleto

--DROP PROCEDURE GrabaSencillaAleatoria

--Implementa un procedimiento GrabaSencillaAleatoria que genere un boleto con n apuestas sencillas, cuyos números se generarán de forma aleatoria.
CREATE PROCEDURE GrabaSencillaAleatoria 
	@sorteo date, @numero int
AS
	BEGIN

	DECLARE @count int
	SET @count = 0

	DECLARE @n1 int
	DECLARE @n2 int
	DECLARE @n3 int
	DECLARE @n4 int
	DECLARE @n5 int
	DECLARE @n6 int

	WHILE @count < @numero
		BEGIN
			DECLARE @RandomNumber1 int
			DECLARE @RandomNumber2 int 
			DECLARE @RandomNumber3 int
			DECLARE @RandomNumber4 int
			DECLARE @RandomNumber5 int
			DECLARE @RandomNumber6 int
			EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber1 OUTPUT
			EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber2 OUTPUT
				IF @RandomNumber1 IN (@RandomNumber2)
					BEGIN 
					EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber2 OUTPUT
					END
			EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber3 OUTPUT
				IF @RandomNumber3 IN (@RandomNumber1, @RandomNumber2 )
					BEGIN 
					EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber3 OUTPUT
					END
			EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber4 OUTPUT
				IF @RandomNumber4 IN (@RandomNumber1, @RandomNumber2, @RandomNumber3)
					BEGIN 
					EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber4 OUTPUT
					END
			EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber5 OUTPUT
				IF @RandomNumber5 IN (@RandomNumber1, @RandomNumber2, @RandomNumber3, @RandomNumber4)
					BEGIN 
					EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber5 OUTPUT
					END
			EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber6 OUTPUT
				IF @RandomNumber6 IN (@RandomNumber1, @RandomNumber2, @RandomNumber3, @RandomNumber4, @RandomNumber5)
					BEGIN 
					EXECUTE GeneraNumeroAleatorioParaBoleto @RandomNumber6 OUTPUT
					END

			INSERT INTO [dbo].[Apuestas]([FechaSorteo],[FechaApuesta],[HoraApuesta],[Precio],[n1],[n2],[n3],[n4],[n5],[n6])
				VALUES (@sorteo, CAST(GETDATE() AS date), CAST(GETDATE() AS time), 1, @RandomNumber1, @RandomNumber2, 
					@RandomNumber3, @RandomNumber4, @RandomNumber5, @RandomNumber6)
		SET @count = @count + 1
		END
	END
GO

--Pruebas
/*
DECLARE @sorteo date
	SET @sorteo = GETDATE()

DECLARE @n1 int
	SET @n1 = 99999

	EXECUTE GrabaSencillaAleatoria @sorteo, @n1

DELETE FROM Apuestas
*/

--DROP PROCEDURE GeneraNumeroAleatorioParaBoleto
--Implementa un procedimiento GrabaMuchasSencillas que genere n boletos con una sola apuesta sencilla utilizando el procedimiento GrabaSencillaAleatoria. 
--Datos de entrada: El sorteo y el valor de n

CREATE PROCEDURE GrabaMuchasSencillas

--Implementa un procedimiento almacenado GrabaMultiple que grabe una apuesta múltiple. Datos de entrada: El sorteo y entre 5 y 11 números