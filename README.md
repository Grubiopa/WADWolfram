# WADWolfram


## Fase 1

## Integrantes

<ol>
  <li>Parés Ponce, Juan Antonio - ja.pares@alumnos.urjc.es - JuanAntonioPares </li>
  <li>Príncipe Aguirre, Karen  - k.principe@alumnos.urjc.es - karenPAPP</li>
  <li>Rubio Palacios, Gabriel - g.rubiopa@alumnos.urjc.es - GRubiopa</li>
  <li>Timón Mayo, Sandra - s.timonm@alumnos.urjc.es - stimonm</li>
</ol>

## Temática

Recaudación de fondos para proyectos medicinales de esta enfermedad rara para la Asociación Española para la Investigación y Ayuda al Síndrome de Wolfram.

## Idea del proyecto

La idea del proyecto surge de la necesidad de la creación de un sistema de crowfunding para la financiación del tratamiento para los pacientes de dicha asociación.
La página estará compuesta por 3 partes diferenciadas. 

La primera de ellas es la parte pública, visible para todos los usuarios, donde aparecerá información de la asociación, las noticias más relevantes y recientes y, finalmente, un carrusel de imágenes con mini-descripciones de los diversos proyectos en curso.

Seguidamente, la parte privada de cada usuario que se hubiera logueado previamente. Se le mostrará, por un lado, los proyectos en los que ya ha colaborado y su estado, por otro lado, estarán todos los proyectos que se están desarrollando.
En la parte de los proyectos se verá la información de los mismos, cómo realizar una colaboración, y el número de personas que han participado hasta el momento.

En último lugar, el administrador, tendrá su parte privada en la que podrá realizar modificaciones en toda la página, proyectos, blog, usuarios, gestionar los mensajes y/o comentarios privados de los usuarios, étc.

## Entidades

Por lo tanto, las entidades del proyecto son las siguientes:
<ol>
    <ul>
    Blog -> Esta entidad contendrá la fecha, el título, imagen y descripción por cada artículo.
    </ul>
    <ul>
    Donación -> Contendrá el nickname del usuario, la cantidad aportada por el mismo, el proyecto al que se dona y la fecha en la que se hace.
    </ul>
    <ul>
    Usuario -> Contendrá el tipo de usuario (admin o visitante), nombre y apellidos del usuario, nickname, correo electrónico, contraseña e imagen (avatar).
    </ul>
    <ul>
    Proyecto -> Contendrá el título del proyecto, fecha de inicio, una imagen, una pequeña descripción, una más amplia, cantidad ya aportada, lo que falta por aportar, número de usuarios que han participado y el estado del proyecto (terminado o en curso). 
    </ul>
</ol>

## Fase 2

Descripción de las páginas

Común a todas las páginas web de la parte pública:

Hay una barra de navegación (Inicio, Proyectos, Noticias, Contacto, Sobre sus desarrolladores y Cuenta) que se mantiene a lo largo de toda la parte pública en la parte superior de las páginas. Otra parte común a todas estas páginas es el cierre de página, que indica los datos de la asociación (nombre, dirección, teléfono...), información sobre términos y condiciones, política de privacidad, etc y una lista de páginas relacionadas. Así mismo, da la posibilidad de elegir el idioma de la aplicación.
 
<b>Inicio (index.html)</b>

Contiene un carrusel de fotos de los proyectos, las cuales incluyen el título y una breve descripción del mismo. Al pinchar una foto, nos redirige a una página con la información detallada del proyecto. También incluye una breve descripción de la finalidad de la app (encabezado Sobre nuestra asociación) y barras de progreso que muestran el estado de cada proyecto (encabezado Colabora con nuestros proyectos). Por último, posee una sección de noticias, de las que se muestra el título y una imagen de las mismas. Al seleccionar una noticia, el enlace lleva el foco a la noticia en concreto en la página Noticias.

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Indice1.png)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Indice2.png) 


<b>Proyectos (projects.html)</b>

Posee una lista fija de los proyectos (con la posibilidad de cargar más) y la posibilidad de poder filtrarlos (recientes, años o ver los que ya han concluido), el título, fecha de lanzamiento y una imagen que al pasar el ratón por encima ofrece la opción de "Leer más", la cual reenvía a la página del proyecto correspondiente con la información detallada de éste. La página de cada proyecto contiene una fotografía, una tabla con datos concretos del presupuesto total y condecido, financiación pendiente,... (solo el proyecto bio-psicosocial no proporciona esta tabla) e información ampliada del mismo.

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Proyectos1.png)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Proyectos2.png)


<b>Pagina proyecto(oneProject.html)</b>

Esta página sera la encargada de mostrar la descripción extensa del proyecto, una foto, las caracticas del proyecto (fecha, aportaciones...) y el botón más importante, "Participa", para animar a la gente a colaborar en el proyecto.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/proyectoEjemplo1.PNG)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/proyectoEjemplo2.PNG)

<b>Noticias (blog.html)</b>

Incluye una lista con las noticias (título, imagen, información del cuerpo de la noticia, fecha de publicación y número de comentarios realizados por los usuarios, enlace que redirige al foro con los comentarios pertinentes). Por otra parte, proporciona un formulario que se debe rellenar para poder dejar un comentario relacionado con una noticia (la cual selecciona el usuario en dicho formulario). Por último, dispone de una lista de enlaces referentes a las categorías en las que se organizan las noticias, cuya selección lleva a la sección correspondiente dentro de la lista de noticias. 
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Noticias1.png)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Noticias2.png)


<b>Contacto (contact.html)</b>

Muestra, tres columnas. En la primera, un texto que invita a los usuarios a resolver sus dudas y, por debajo, un área de texto (con etiqueta “Chat”), para poder consultar sus dudas al administrador de la aplicación manteniendo una comunicación directa, y un botón enviar (con un icono de mensaje). En la segunda, se hace más visible toda la información referente al perfil de la asociación, mostrando la dirección, el teléfono, fax... Finalmente, se muestra un mapa de su ubicación.

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Contacto.png)


<b>Sobre sus desarrolladores (about.html)</b>

Ofrece un texto centrado explicando el origen de la aplicación, por qué y cómo surgió, y los integrantes del grupo de desarrolladores de la aplicación web con sus respectivas titulaciones. Además, incluirá próximamente una fotografía con los miembros del grupo.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/About.png)

<b>Registro (register.html)</b>

Proporciona un formulario para registrarse como usuario con campos de texto para introducir nombre, apellidos, nombre de usuario, correo electrónico, contraseña y confirmación de contraseña y un botón "Regístrate". Además, ofrece un enlace a la página de inicio de sesión para aquellos que ya están registrados.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Registrarse.png)


<b>Login (login.html)</b>

Proporciona un formulario para loguearte como usuario y contraseña. También tiene 2 botones: "Se me ha olvidado la contraseña" y "Entrar". Asimismo, esta página también dispone de un enlace para aquellos que aún no están registrados, invitándoles a hacerlo.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/IniciarSesion.png)
 
 
<b>Cuenta (users.html)</b>

Hay una barra de navegación con "Mis proyectos", "Mis movimientos" y "Mis datos" y el botón de cerrar sesión.
En "Mis proyectos" se podrá ver una tabla resumen con los proyectos en los que ha colaborado el usuario y otra con el resto de proyectos que hay a su disposición.
En "Mis movimientos" se observa una tabla con el proyecto al que has colaborado y la cantidad aportada al mismo.
Finalmente esta la página de mis datos donde el usuario podra modificar su avatar, sus datos personales, correo y contraseña.

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/User1.PNG)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/User2.PNG)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/user3.PNG)

## Diagramas de actividad

A continuación se mostraran los diferentes diagrama de actividad de las diferentes paginas html.

Inicio (index.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/Index.png)

Proyectos (projects.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/Proyectos1.png)

Pagina proyecto(oneProject.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/oneProject.png)

Noticias (blog.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/Blog.png)


Contacto (contact.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/Contacto.png)


Sobre sus desarrolladores (about.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/About.png)

Registro (register.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/Register.png)


Login (login.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/Login.png)
 
 
Cuenta (users.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/Users.png)


Administrador (Bootstrap-Admin-Theme)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/Admin.png)



## Cambios generales sobre las plantillas

La plantilla que cogimos para la mayoría de la aplicación era una muy genérica ya que cada link nos llevaba, básicamente, a otra página sino igual, muy similar: https://bootstrapmade.com/demo/themes/Sailor/ . 
La otra plantilla utilizada ha sido dedicada, exclusivamente, a la parte del admin: https://github.com/VinceG/Bootstrap-Admin-Theme .
Los cambios que hemos aplicado han sido abundantes y, en función de lo que íbamos a necesitar, íbamos adaptando la aplicación, ya que como se ha podido observar, la página de índice no tiene nada que ver con la página privada del usuario, por ejemplo.

Cambios genéricos que se han realizado a la plantilla de la página (NO ADMIN):
<ol>
<li> Background</li>
<li> Logo</li>
<li> Footer</li>
<li> Barra de menús</li>
<li> Titles en los html </li>
<li> Toda la parte de contenido, ya que de cada página html que se tenía se ha ido cogiendo los elementos que se necesitaban,
intercambiandolos de una a otra en función de nuestras necesidades y, añadiendo algunos nuevos.</li>
</ol>

Cambios genéricos que se han realizado a la plantilla del admin:
<ol>
<li>Solo se han conservado el menú superior, el footer y la navegación lateral.</li>
<li>Se han eliminado la barra de búsqueda y todos los html que venían por defecto.</li>
<li>Se han utilizado elementos como tablas, gráficas o formularios para modelar el contenido de las páginas web.</li>
<li>Se ha modelado cada página desde cero, ateniéndose a las necesidades de cada una de ellas.</li>
<li>Se ha cambiado los títulos "title", la información del footer, el nombre de los elementos de navegación y de la página en el header, y el botón superior de la misma para todas las páginas del administrador.</li>
</ol>

## Cambios específicos en la plantilla del admin

<b>Header</b> <br>
Se ha eliminado la barra de búsqueda, se ha cambiado el nombre del título h1 a Admin Wolfram, se ha colocado un botón desplegable llamado "mi cuenta" con las opciones de cerrar sesión y perfil.

<b>Página de inicio</b> <br>
Se ha eliminado todo el contenido y se han colocado dos gráficas para ver las visitas de las noticias en el tiempo y la evolución de donaciones de los proyectos.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Index-admin1.png)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Index-admin2.png)

<b>Añadir proyectos</b> <br>
Se ha colocado un formulario para añadir un proyecto con todos los datos necesarios, y una tabla con todos los proyectos activos, para poder eliminarlos o editarlos en cualquier momento.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/NewProject-Admin1.png)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/NewProject-Admin2.png)

<b>Añadir noticias</b> <br>
Se ha colocado de nuevo un formulario para añadir una noticia, al igual que para los proyectos.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/NewBlog-admin.png)

<b>Donaciones</b> <br>
Se incluye una tabla con las personas que han donado, a que proyecto, y cuánto dinero, así como la fecha en la que se donó.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Donaciones-admin.png)

<b>Mensajes</b> <br>
Contiene una lista a la izquierda de los usuarios a quienes se puede enviar un mensaje, así como un cuadro de texto a la derecha para redactarlo y enviarlo al pulsar el correspondiente botón.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Mensajes-admin.png)

<b>Perfil</b> <br>
Permite cambiar los datos de la cuenta del administrador, así como crear otro administrador.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Capturas/Perfil-admin.png)


## Fase 3

Los cambios más relevantes a destacar con respecto a la fase anterior (fase 2), han sido los dos siguientes.
Por un lado, hemos creado la entidad "donación", la cual no había sido tenida en cuenta en un primer momento. Al valorar si incluir este dato en la entidad usuario o en la entidad proyecto, nos dimos cuenta de que, en verdad, un usuario determinado realiza una donación para un proyecto en concreto y que una donación tiene dos características propias: la cuantía y la fecha. Así que decidimos que el dato donación sería una entidad en sí misma con una relación 1-1 (o, más concretamente, n-1, ya que tanto un usuario como un proyecto pueden tener varias donaciones asociadas) con las entidades usuario y proyecto.
Por otra parte, inicialmente, habíamos incluido el cuerpo de las noticias en la página correspondiente al blog sin la posibilidad de visualizar el contenido de cada noticia por separado. En esta fase, hemos creado una plantilla para generar una página específica para cada noticia con sus correspondientes comentarios realizados por los usuarios de la aplicación. Por tanto, como consecuencia del cambio anterior, ya no aparece en la página del blog el formulario para dejar un comentario, teniendo que seleccionar la noticia a comentar, sino que éste se encuentra dentro de la página propia de cada noticia facilitando así su contextualización.

## Navegación

La navegación por las pantallas no ha cambiado mucho respecto a la fase 2, por eso se muestran las pantallas donde ha habido cambios significativos.

## Entidades de la Base de Datos

En este diagrama se muestran las entidades de la base de datos y sus relaciones entre sí.

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/Relacion_de_entidades.png)


## Diagrama de clases y templates

A continuación se muestra un diagrama de clases con las relaciones entre los @Controller y los Repository, así como los templates que los usan.

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/diagrama_clases.png)


## Fase 4

A continuación exponemos las operaciones que ofrece la API REST para cada recurso, junto con el formato de la URL, información de entrada y salida y códigos de estado asociados a cada petición.
Se destaca que, en caso de que la petición no se resuelva con éxito, se devolverá el código de error 404 NOT FOUND y, en caso de que sísea llevada a cabo con éxito, el código de estado 201 CREATED para la petición POST y 200 OK para el resto. Además, las peticiones de tipo POST y PUT llevan asociada la cabecera {"Content-type":"application/json"}.


## Diagrama de clases WEB/REST

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/imagenes/Diagramas/diagrama_clases_rest_web.png)



## Proyectos

| URL | Método | Info. entrada | Info. salida | Cód. estado |
| ----- | ----- | ----- | ----- | ----- |
| /api/project | POST | {</br>"title":"Titulo",</br>"shortDescription":"Breve Descripcion",</br>"description":"Description",</br>"totalBudget":500000.0,</br>"parcialBudget":150.0,</br>"restBudget":499850.0,</br>"time":36.0,</br>"opened":true,</br>"releaseDate":,</br>"startYear":2017,</br></br>"image":"image"</br>} | {</br>"id":1,</br>"title":"Titulo",</br>"shortDescription":"Breve Descripcion",</br>"description":"Description",</br>"totalBudget":500000.0,</br>"parcialBudget":150.0,</br>"restBudget":499850.0,</br>"time":36.0,</br>"opened":true,</br>"releaseDate":,</br>"startYear":2017,</br>"image":"image","</br>} | 201 (CREATED) |
| /api/project/1 | GET | ... | {"id":1,</br>"title":"Titulo",</br>"shortDescription":"Breve Descripcion",</br>"description":"Description",</br>"totalBudget":500000.0,</br>"parcialBudget":150.0,</br>"restBudget":499850.0,</br>"time":36.0,</br>"opened":true,</br>"releaseDate":,</br>"startYear":2017,</br>"image":"image"</br>} | 200 (OK) |
| /api/projects | GET | ... | [</br>{</br>"id":1,</br>"title":"Titulo",</br>"shortDescription":"Breve Descripcion",</br>"description":"Description",</br>"totalBudget":500000.0,</br>"parcialBudget":150.0,</br>"restBudget":499850.0,</br>"time":36.0,</br>"opened":true,</br>"releaseDate":,</br>"startYear":2017,</br>"image":"image"</br>},</br>{"id":2,"title":"Titulo2","shortDescription":"Breve Descripcion2",</br>"description":"Description2",</br>"totalBudget":600.0,</br>"parcialBudget":10.0,</br>"restBudget":590.0,</br>"time":36.0,</br>"opened":true,</br>"releaseDate":,</br>"startYear":2017,</br>"image":"image"</br>}</br>] | 200 (OK) |
| /api/project/1 | PUT | {"money":50.0} | {</br>"id":1,</br>"title":"Titulo",</br>"shortDescription":"Breve Descripcion",</br>"description":"description",</br>"totalBudget":500000.0,</br>"parcialBudget":4150.0,</br>"restBudget":495850.0,</br>"time":36.0,</br>"opened":true,</br>"releaseDate":1491041583000,</br>"startYear":2017,</br>"image":"image",</br>"donations":[</br>{</br>"id":1,</br>"money":50.0,</br>"date":"01-04-2017"</br>}</br>]</br>} | 201 (CREATED)
| /api/project/1 | DELETE | ... | {</br>"id":1,</br>"title":"Titulo",</br>"shortDescription":"Breve Descripcion",</br>"description":"Description",</br>"totalBudget":500000.0,</br>"parcialBudget":150.0,</br>"restBudget":499850.0,</br>"time":36.0,</br>"opened":true,</br>"releaseDate":,</br>"startYear":2017,</br>"image":"image",</br>"donations":[</br>{</br>"id":1,</br>"money":50.0,</br>"date":01-04-17</br>}</br>]</br>} | 200 (OK) |


## Noticias

| URL | Método | Info. entrada | Info. salida | Cód. estado |
| ----- | ----- | ----- | ----- | ----- |
| /api/new | POST | {</br>"title":"Noticia1",</br>"cuerpo":""cuerpo",</br>"categoria":"enfermedad",</br>"comentarios":[],</br>"date:02-04-17</br>} |  {</br>"id":1,</br>"title":"Noticia1",</br>"cuerpo":""cuerpo",</br>"categoria":"enfermedad",</br>"comentarios":[],</br>"date":02-0-17,</br>"numComentarios":0</br>} | 201 (CREATED) |
| /api/new/1 | GET | ... | {</br>"id":1,</br>"title":"Noticia1",</br>"cuerpo":""cuerpo",</br>"categoria":"enfermedad",</br>"comentarios":[],</br>"date":02-04-17,</br>"numComentarios":0</br>} | 200 (OK) |
| /api/new?category=enfermedad | GET | ... | [{</br>"id":1,</br>"title":"Noticia1",</br>"cuerpo":""cuerpo",</br>"categoria":"enfermedad",</br>"date":02-04-17,</br>"numComentarios":0</br>}</br>] | 200 (OK) |
| /api/news | GET | ... | [</br>{</br>"id":1,</br>"title":"Noticia1",</br>"cuerpo":""cuerpo",</br>"categoria":"enfermedad",</br>"date":02-04-17,</br>"numComentarios":0</br>},</br>{</br>"id":2,</br>"title":"Noticia2",</br>"cuerpo":"cuerpo2",</br>"categoria":"eventos",</br>"date":01-04-17,</br>"numComentarios":0</br>}</br>] | 200 (OK) |
| /api/new/1 | PUT | {</br>"message":"hola" |  {</br>"id":1,</br>"title":"Noticia1",</br>"cuerpo":""cuerpo",</br>"categoria":"enfermedad",</br>"comentarios":[</br>{</br>"id":1,</br>"comentario":"hola",</br>"user":{</br>"name":"e@e.es"}</br>}</br>],</br>"date":02-04-17,</br>"numComentarios":1</br>} | 200 (OK) |
| /api/new/1 | DELETE | ... | {</br>"id":1,</br>"title":"Noticia1",</br>"cuerpo":""cuerpo",</br>"categoria":"enfermedad",</br>"comentarios":[</br>{</br>"id":1,</br>"comentario":"hola",</br>"user":{</br>"name":"e@e.es"</br>}</br>}</br>],</br>"date":02-04-17,</br>"numComentarios":1</br>} | 200 (OK) |

## Users

| URL | Método | Info. entrada | Info. salida | Cód. estado |
| ----- | ----- | ----- | ----- | ----- |
| /api/users/login | GET | authentication (email y pass) |{</br>"colaborateProjects":[</br>{</br>"projectId":1,</br>"title":"Titulo",</br>"shortDescription":"Breve Descripcion",</br>"money":150.0</br>},</br>{</br>"projectId":2,</br>"title":"Titulo2",</br>"shortDescription":"Breve Descripcion2",</br>"money":10.0</br>}</br>],</br>"otherProjects":[],</br>"donations":[</br>{</br>"projectTitle":"Titulo",</br>"money":50.0,</br>"date":1491040847000</br>},</br>{</br>"projectTitle":"Titulo",</br>"money":60.0,</br>"date":1491040847000</br>},</br>{</br>"projectTitle":"Titulo",</br>"money":40.0,</br>"date":1491040847000</br>},</br>{</br>"projectTitle":"Titulo2",</br>"money":10.0,</br>"date":1491040847000</br>}</br>],</br>"user":{</br>"id":2,</br>"name":"Elnombre",</br>"lastname":"Elapellido",</br>"surname":"Elapellido",</br>"email":"e@e.es",</br>"userName":"e",</br>"photo2":"icon.png",</br>"passwordHash":"$2a$10$SAmZWSk8TwRB</br>PGzYxRo8/.UrS</br>lUTEialtcK20v/vu5E40smPFgyOG",</br>"roles":["ROLE_USER"]</br>}</br>}|200 (OK)
| /api/users/register/create |POST|	"name":"Gabi",</br>"lastname":"Elapellido",</br>"surname":"Elapellido",</br>"email":"e@e.es",</br>"userName":"e",</br>"photo2":"icon.png",</br>"passwordHash":"$2a$10$uetOA</br>9NXy6ZI4cXeCwb</br>w6OQFViEy5Daaiyfm</br>3eq92Kvnh.8pOMX.G"| {</br>"name": "Gabi",</br> "lastname": "Elapellido",</br> "surname": "Elapellido",</br> "email": "e@e.es",</br> "userName": "e",</br> "photo2": "icon.png",</br> "passwordHash":"aaaa",</br> "roles": ["ROLE_USER"]</br>}|201 (Created)|
| /api/users/update/{id}| PUT|{</br>"email": "t@t.t",</br>"userName": "gasdsdsdsw",</br>"oldPassword":"e",</br>"newPassword":"b"</br>}|{</br>"id":2,</br>"name":"Elnombre",</br>"lastname":"Elapellido",</br>"email":"t@t.t",</br>"userName":"e",</br>"passwordHash":"$2a$10$HWb</br>gVEZAWBmmV0Gq.nxlHeCKb26</br>DAkKJWZe6ZxC</br>qh0N65TMCCDvTa",</br>"roles":["ROLE_USER"]</br>}|200 (OK)|

## Admin

| URL | Método | Info. entrada | Info. salida | Cód. estado |
| ----- | ----- | ----- | ----- | ----- |
| /api/admin/Profile/create | POST | {</br>"name": "tono",</br>"lastname": "P",</br>"email": "a@a.a",</br>"userName": "tono94",</br>"passwordHash": "wwww",</br>"roles": ["ROLE_ADMIN"]</br>} | {</br>"id":3,</br>"name":"tono",</br>"lastname":"P",</br>"email":"a@a.a",</br>"userName":"tono94",</br>"passwordHash":"$2a$10$5jG</br>yhL0M1U.LOmpz.Sqe</br>ou5qyFCWjt1/PTeS</br>7S6z0xSqLlLKEiWgK",</br>"roles":["ROLE_ADMIN"]</br>} | 200 (OK)| 
| /api/admin/Profile/update/{id} |PUT|{</br>"email":"g.tu@gabon.g",</br>"oldPassword":"aaaa",</br>"newPassword":"bbbb"</br>}|{</br>"id":1,</br>"name":"Gabi",</br>"lastname":"R",</br>"email":"g.tu@yg.gru",</br>"userName":"gabi0794",</br>"passwordHash":"$2a$10$bjUn</br>e4ReImNBzo7w1D.tD.uab</br>an9XkwrsMxOMDrt</br>Z8TEK2PjkmewC",</br>"roles":["ROLE_ADMIN"]</br>} |200 (OK)| 

