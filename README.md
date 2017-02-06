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

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Indice1.png)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Indice2.png) 


<b>Proyectos (projects.html)</b>

Posee una lista fija de los proyectos (con la posibilidad de cargar más) y la posibilidad de poder filtrarlos (recientes, años o ver los que ya han concluido), el título, fecha de lanzamiento y una imagen que al pasar el ratón por encima ofrece la opción de "Leer más", la cual reenvía a la página del proyecto correspondiente con la información detallada de éste. La página de cada proyecto contiene una fotografía, una tabla con datos concretos del presupuesto total y condecido, financiación pendiente,... (solo el proyecto bio-psicosocial no proporciona esta tabla) e información ampliada del mismo.

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Proyectos1.png)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Proyectos2.png)


<b>Pagina proyecto(oneProject.html)</b>

Esta página sera la encargada de mostrar la descripción extensa del proyecto, una foto, las caracticas del proyecto (fecha, aportaciones...) y el botón más importante, "Participa", para animar a la gente a colaborar en el proyecto.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/proyectoEjemplo1.PNG)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/proyectoEjemplo2.PNG)

<b>Noticias (blog.html)</b>

Incluye una lista con las noticias (título, imagen, información del cuerpo de la noticia, fecha de publicación y número de comentarios realizados por los usuarios, enlace que redirige al foro con los comentarios pertinentes). Por otra parte, proporciona un formulario que se debe rellenar para poder dejar un comentario relacionado con una noticia (la cual selecciona el usuario en dicho formulario). Por último, dispone de una lista de enlaces referentes a las categorías en las que se organizan las noticias, cuya selección lleva a la sección correspondiente dentro de la lista de noticias. 
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Noticias1.png)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Noticias2.png)


<b>Contacto (contact.html)</b>

Muestra, tres columnas. En la primera, un texto que invita a los usuarios a resolver sus dudas y, por debajo, un área de texto (con etiqueta “Chat”), para poder consultar sus dudas al administrador de la aplicación manteniendo una comunicación directa, y un botón enviar (con un icono de mensaje). En la segunda, se hace más visible toda la información referente al perfil de la asociación, mostrando la dirección, el teléfono, fax... Finalmente, se muestra un mapa de su ubicación.

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Contacto.png)


<b>Sobre sus desarrolladores (about.html)</b>

Ofrece un texto centrado explicando el origen de la aplicación, por qué y cómo surgió, y los integrantes del grupo de desarrolladores de la aplicación web con sus respectivas titulaciones. Además, incluirá próximamente una fotografía con los miembros del grupo.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/About.png)

<b>Registro (register.html)</b>

Proporciona un formulario para registrarse como usuario con campos de texto para introducir nombre, apellidos, nombre de usuario, correo electrónico, contraseña y confirmación de contraseña y un botón "Regístrate". Además, ofrece un enlace a la página de inicio de sesión para aquellos que ya están registrados.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Registrarse.png)


<b>Login (login.html)</b>

Proporciona un formulario para loguearte como usuario y contraseña. También tiene 2 botones: "Se me ha olvidado la contraseña" y "Entrar". Asimismo, esta página también dispone de un enlace para aquellos que aún no están registrados, invitándoles a hacerlo.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/IniciarSesion.png)
 
 
<b>Cuenta (users.html)</b>

Hay una barra de navegación con "Mis proyectos", "Mis movimientos" y "Mis datos" y el botón de cerrar sesión.
En "Mis proyectos" se podrá ver una tabla resumen con los proyectos en los que ha colaborado el usuario y otra con el resto de proyectos que hay a su disposición.
En "Mis movimientos" se observa una tabla con el proyecto al que has colaborado y la cantidad aportada al mismo.
Finalmente esta la página de mis datos donde el usuario podra modificar su avatar, sus datos personales, correo y contraseña.

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/User1.PNG)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/User2.PNG)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/user3.PNG)

## Diagramas de actividad

A continuación se mostraran los diferentes diagrama de actividad de las diferentes paginas html.

Inicio (index.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/Index.png)

Proyectos (projects.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/Proyectos1.png)

Pagina proyecto(oneProject.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/oneProject.png)

Noticias (blog.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/Blog.png)


Contacto (contact.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/Contacto.png)


Sobre sus desarrolladores (about.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/About.png)

Registro (register.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/Register.png)


Login (login.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/Login.png)
 
 
Cuenta (users.html)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/Users.png)


Administrador (Bootstrap-Admin-Theme)

![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Diagramas/Admin.png)



## Cambios sobre las plantillas

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

## Cambios en la plantilla del admin

<b>Header</b>
Se ha eliminado la barra de búsqueda, se ha cambiado el nombre del título h1 a Admin Wolfram, se ha colocado un botón desplegable llamado "mi cuenta" con las opciones de cerrar sesión y perfil.

<b>Página de inicio</b>
Se ha eliminado todo el contenido y se han colocado dos gráficas para ver las visitas de las noticias en el tiempo y la evolución de donaciones de los proyectos.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Index-admin1.PNG)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Index-admin2.PNG)

<b>Añadir proyectos</b>
Se ha colocado un formulario para añadir un proyecto con todos los datos necesarios, y una tabla con todos los proyectos activos, para poder eliminarlos o editarlos en cualquier momento.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/NewProject-Admin1.PNG)
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/NewProject-Admin2.PNG)

<b>Añadir noticias</b>
Se ha colocado de nuevo un formulario para añadir una noticia, al igual que para los proyectos.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/NewBlog-admin.PNG)

<b>Donaciones</b>
Se incluye una tabla con las personas que han donado, a que proyecto, y cuánto dinero, así como la fecha en la que se donó.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Donaciones-admin.PNG)

<b>Mensajes</b>
Contiene una lista a la izquierda de los usuarios a quienes se puede enviar un mensaje, así como un cuadro de texto a la derecha para redactarlo y enviarlo al pulsar el correspondiente botón.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Mensajes-admin.PNG)

<b>Perfil</b>
Permite cambiar los datos de la cuenta del administrador, así como crear otro administrador.
![alt tag](https://github.com/Grubiopa/WADWolfram/blob/master/img/Capturas/Perfil-admin.PNG)





