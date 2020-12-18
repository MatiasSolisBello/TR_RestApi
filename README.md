# Rest Api with Spring Boot

## You need instaled
+ Spring ide from [here](https://spring.io/tools)

## This project include:

+ User

 Metodo | Ruta | Funcion |
 ------ | ------ | ------| 
 GET |  /user | Listar Todo |
 GET |  /user/{id} | Listar  segun id |
 POST |  /user | Agregar  |
 PUT |  /user | Actualizar|
 DELETE | /user/{id}  | Eliminar |
 
 
 + Servicio

 Metodo | Ruta | Funcion |
 ------ | ------ | ------| 
 GET |  /servicio | Listar Todo |
 GET |  /servicio/{id} | Listar  segun id |
 POST |  /servicio | Agregar  |
 PUT |  /servicio | Actualizar|
 DELETE | /servicio/{id}  | Eliminar |
 
  + Depart

 Metodo | Ruta | Funcion |
 ------ | ------ | ------| 
 GET |  /depart | Listar Todo |
 GET |  /depart/{id} | Listar  segun id |
 POST |  /depart | Agregar  |
 PUT |  /depart | Actualizar|
 DELETE | /depart/{id}  | Eliminar |

  + Reserva

 Metodo | Ruta | Funcion |
 ------ | ------ | ------| 
 GET |  /reserva | Listar Todo |
 GET |  /reserva/{id} | Listar  segun id |
 GET | /servicio/{servicioId}/reserva | Listar reserva x id servicio |
 GET | /depart/{departId}/reserva | Listar reserva x id depart |
 PUT | /reserva | Actualizar excepto FK
 DELETE | /depart/{id}  | Eliminar |
 POST | servicio/{servicioId}/depart/{departId}/user/{userId}/reserva | Agregar reserva con FK servicio, depart u user |
 
   + Checkin

 Metodo | Ruta | Funcion |
 ------ | ------ | ------| 
 GET |  /checkin | Listar Todo |
 GET |  /checkin/{id} | Listar  segun id checkin|
 GET | /reserva/{reservaId}/checkin | Listar por id reserva
 POST |  /reserva/{reservaId}/checkin | Agregar checkin a reserva |

   + Checkout

 Metodo | Ruta | Funcion |
 ------ | ------ | ------| 
 GET |  /checkout | Listar Todo |
 GET |  /checkout/{id} | Listar  segun id checkout |
 GET | /reserva/{reservaId}/checkout | Listar por id reserva
 POST |  /reserva/{reservaId}/checkout | Agregar checkout a reserva |

## Guides:

+ Create API DESDE CERO. [Look video](https://www.youtube.com/watch?v=jO-o3qQZDuU&list=LL&index=2)
+ For learning postman [Look video](https://www.youtube.com/watch?v=wGh6t5J9JZg&list=LL&index=4)
+ One-to-Many Association [Read blog](https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/)
+ CRUD MultiTable. [Read blog](https://codigochido.com/post/2018-07-09-acervo-api/)
