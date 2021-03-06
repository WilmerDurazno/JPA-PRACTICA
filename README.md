1.	Crear un repositorio en GitHub con el nombre “Práctica de laboratorio 02: Servlets, JSP y JPA” 

![1](https://user-images.githubusercontent.com/34029478/102230391-d139d700-3eba-11eb-84f7-c43b3c21a2ba.png)

https://github.com/WilmerDurazno/JPA-PRACTICA.git


2.	Desarrollar una aplicación con tecnología JEE para gestionar una venta de productos en la web.



El respectivo diagrama que se creo al momento de crear la base de datos mediante la persistencia.

![2](https://user-images.githubusercontent.com/34029478/102230396-d26b0400-3eba-11eb-9e4b-0b647e6d4803.png)

Para iniciar tenemos que crear una base de datos llamada jee que al momento de registrar un usuario nos crearan las debidas tablas de mysql.

![3](https://user-images.githubusercontent.com/34029478/102230587-12ca8200-3ebb-11eb-889b-f372cf9a7553.png)
Primero iniciamos registrándonos o se registra el usuario
![4](https://user-images.githubusercontent.com/34029478/102230408-d4cd5e00-3eba-11eb-92ea-2193f93fd533.png)
![5](https://user-images.githubusercontent.com/34029478/102230415-d6972180-3eba-11eb-93a3-e2ea4c828487.png)

Después de habernos registrado se revisa en la base de datos y podemos ver que las tablas están creadas correctamente.
![6](https://user-images.githubusercontent.com/34029478/102230418-d7c84e80-3eba-11eb-8f62-2e9118d1f058.png)
![Imagen7](https://user-images.githubusercontent.com/34029478/102230351-c5e6ab80-3eba-11eb-8a48-914a34c5040e.png)


La pagina web tiene dos roles donde que el usuario puede inicar sesión y hace sus pedisdos y compras y por lo cual tiene diferentes interfaces.
Pagina inicial de USUARI
![8](https://user-images.githubusercontent.com/34029478/102230346-c4b57e80-3eba-11eb-9cbb-cd2a3a007e28.png)

paginina Inicial Admininistrador

![Imagen9](https://user-images.githubusercontent.com/34029478/102230355-c717d880-3eba-11eb-863f-b3d2b5b03fa7.png)
![Imagen10](https://user-images.githubusercontent.com/34029478/102230361-c97a3280-3eba-11eb-965a-d810d7c5e776.png)
![Imagen11](https://user-images.githubusercontent.com/34029478/102230363-ca12c900-3eba-11eb-8caa-a2d457a26553.png)


USUARIO

Una vez iniciado sesión el usuario puede hacer sus respectivos pedidos.
![Imagen12](https://user-images.githubusercontent.com/34029478/102230366-caab5f80-3eba-11eb-9eb3-1fe62a3b23c3.png)
![Imagen13](https://user-images.githubusercontent.com/34029478/102230368-cbdc8c80-3eba-11eb-8a85-71e108eb063f.png)


Al mismo tiempo el Usuario puede lista de requerimientos de compra.

![Imagen14](https://user-images.githubusercontent.com/34029478/102230370-cc752300-3eba-11eb-8be3-4b01bfc054ea.png)


ADMINISTRADOR

Una vez el administrador inicie sesión podrá hacer Registrar los productos.

![Imagen15](https://user-images.githubusercontent.com/34029478/102230371-cc752300-3eba-11eb-9ff3-96db11807011.png)
![Imagen16](https://user-images.githubusercontent.com/34029478/102230378-cda65000-3eba-11eb-8a09-78a141cc025f.png)



Así mismo el Administrador puede modificar los productos por lo cual se va a modificar a continuación el producto lámparas.

![Imagen17](https://user-images.githubusercontent.com/34029478/102230382-cf701380-3eba-11eb-98be-a1c64bf89242.png)
![Imagen18](https://user-images.githubusercontent.com/34029478/102230386-d008aa00-3eba-11eb-9871-95f0bc04941b.png)

![Imagen19](https://user-images.githubusercontent.com/34029478/102230390-d0a14080-3eba-11eb-85fe-c5a5d3641e17.png)


El Administrador también puede hacer una búsqueda de los productos.

![Imagen20](https://user-images.githubusercontent.com/34029478/102232167-ca13c880-3ebc-11eb-927a-96a8c6ffe1f9.png)
![Imagen21](https://user-images.githubusercontent.com/34029478/102232171-caac5f00-3ebc-11eb-8027-ae201b61f084.png)


También el Administrador puede eliminar todos los productos que desee.

![Imagen22](https://user-images.githubusercontent.com/34029478/102232257-e1eb4c80-3ebc-11eb-994e-1fccd2c46801.png)

![Imagen23](https://user-images.githubusercontent.com/34029478/102232263-e3b51000-3ebc-11eb-9228-80e5de198b6d.png)
![Imagen24](https://user-images.githubusercontent.com/34029478/102232274-e7489700-3ebc-11eb-85da-76b62f6f20c0.png)

Y por ultimo el Administrador puede Listar todos los productos de la Empresa.

![Imagen25](https://user-images.githubusercontent.com/34029478/102232281-e7e12d80-3ebc-11eb-97fd-81e0319a0d95.png)


Cuando el Usuario o cliente realiza su compra el Administrador puede Aprobar o Rechazar la compra del cliente.

![Imagen26](https://user-images.githubusercontent.com/34029478/102232285-e9125a80-3ebc-11eb-8efa-c401898d7c25.png)

![Imagen27](https://user-images.githubusercontent.com/34029478/102232297-eadc1e00-3ebc-11eb-8b1b-1de1f9bb9787.png)

También el Administrador puede visualizar los pedidos de los clientes.


![Imagen28](https://user-images.githubusercontent.com/34029478/102232301-ec0d4b00-3ebc-11eb-81b3-6d897adc4e14.png)


Asimos se utilizo los debidos filtros para que inicien sesión los clientes y los Usuarios.

                                     Filtro SesionActiva.java
![Imagen29](https://user-images.githubusercontent.com/34029478/102232220-d861e480-3ebc-11eb-849f-878e70fb37bc.png)

                                     Filtro SesionAdmin.java
![Imagen30](https://user-images.githubusercontent.com/34029478/102232226-da2ba800-3ebc-11eb-9606-5e8e780917d9.png)                                


Para la creación de la base de datos utilizamos lo siguiente:

La persistencia.

![Imagen31](https://user-images.githubusercontent.com/34029478/102232231-db5cd500-3ebc-11eb-985b-bc938cbb5ea9.png)


Las respectivos paquetes llamo jpa.

![Imagen32](https://user-images.githubusercontent.com/34029478/102232237-dd269880-3ebc-11eb-9d02-78f81e68217b.png)

La clase jpa JPAGenericDAO.java

![Imagen33](https://user-images.githubusercontent.com/34029478/102232244-def05c00-3ebc-11eb-8759-2e5a59cb1876.png)

También creamos el paquete de los servelets.

![Imagen34](https://user-images.githubusercontent.com/34029478/102232250-e0218900-3ebc-11eb-8243-9bb32ea9f64c.png)

















RESULTADO(S) OBTENIDO(S):
•	En esta practica pudimos aprender el debido funcionamiento del JPA y los servelets en las paginas web y como es su funcionamiento par poder crear los debidos productos y también utilizar los debidos filtros para poder iniciar sesión, también la programación se vuelve más fácil.

CONCLUSIONES:
•	En la practica pudimos aprender mucho sobre JPA y la persistencia donde esto interactúa con la base de datos se reduce la programación significativamente mediante el uso de JPA.
•	Como una conclusión de esto podemos decir que se debe de tomar mas en cuenta el uso de lo que son las paginas jps y servlets por parte nuestra ya que si hubo un poco de dificultad al momento de realizar la practica.
RECOMENDACIONES:
•	Aplicar conceptos de interacción humano máquina para el desarrollo de la GUI.

                    Nombre de estudiantes: Jorge Yela, Issac Chavez, Wilmer Durazno

Firma de estudiante:

![Imagen36](https://user-images.githubusercontent.com/34029478/102233568-6be7e500-3ebe-11eb-9fee-6da78b74440f.png)
![Imagen37](https://user-images.githubusercontent.com/34029478/102233574-6d191200-3ebe-11eb-96f2-36fb366a4032.png)
![Imagen38](https://user-images.githubusercontent.com/34029478/102233560-69858b00-3ebe-11eb-8b75-f5bb06c710b8.jpg)




