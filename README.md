Integrantes: Leandro Wladimir Placencia Alvarez, Simón Pablo Serrano Luarte.
Cambios en el UML:
   Sobre Reunion:
     Cambio de Date por localDate que es de java.time, así usamos el mismo paquete para los tipos de datos temporales.
     duracionPrevista ahora es del tipo float y expresa tiempo en horas, es más entendible este tipo de dato que Duration.
     Como todas las reuniones deben tener un organizador, este será necesario como parametro para el constructor de reunion y será un 
     atributo.
   Sobre la Asistencia y Retrasos:
     La clase asistencia se encargará de manejar quien llega tarde con su metodo LLegada(Instant horaLLegada), como esta clase se crea en 
     reunion, toma como parametro la hora de inicio y la almacena como atributo y así clasifica quiénes llegan tarde. Eliminando así la 
     clase Retraso.
     Creamos una interfaz asistible que implementa empleado e InvitadoExterno, esto les da la capacidad de asistir a una reunion a una 
     hora en particular.
   Sobre la invitación:
     Añadimos como atributos  de Invitacion algunos atributos de reunion, los cuales se les pasa en el constructor de reunion a 
      invitacion.
     Esto debido a que, al momento de hacer ToString a invitacion, encontramos que una invitacion debería señalar estos aspectos de una r 
     eunion.
     Creamos Invitacion virtual e Invitacion Presencial que heredan de invitacion para que tengan en su ToString el lugar, link y sala 
     respectivamente.
   Sobre organizador:
      Creamos una nueva clase organizador que hereda de empleado y tiene la capacidad, a diferencia de los otros asistentes, de escribir 
      una nota.
   Sobre invitado Externo y Persona:
     para poder invitar a externos, es decir, no empleados, creamos una clase persona de la cual hereda empleado e invitado externo y así 
       los arraylist que almacenan asistentes, ausentes e invitados son del tipo Persona.
     
    

