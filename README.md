# WADWolfram

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
 
Inicio (index.html)

Contiene un carrusel de fotos de los proyectos, las cuales incluyen el título y una breve descripción del mismo. Al pinchar una foto, nos redirige a una página con la información detallada del proyecto. También incluye una breve descripción de la finalidad de la app (encabezado Sobre nuestra asociación) y barras de progreso que muestran el estado de cada proyecto (encabezado Colabora con nuestros proyectos). Por último, posee una sección de noticias, de las que se muestra el título y una imagen de las mismas. Al seleccionar una noticia, el enlace lleva el fco oa la noticia en concreto en la página Noticias.

![Imagen 1][1]  ![Imagen 2][2]

 [1]: https://github.com/Grubiopa/WADWolfram/blob/master/Indice1.png "Inicio 1"
 [2]: Indice2.png "Inicio 2"


Proyectos (projects.html)

Posee una lista fija de los proyectos (con la posibilidad de cargar más), con el título, fecha de lanzamiento y una imagen que al pasar el ratón por encima ofrece la opción de "Leer más", la cual reenvía a la página del proyecto correspondiente con la información detallada de éste. La página de cada proyecto contiene una fotografía, una tabla con datos concretos del presupuesto total y condecido, financiación pendiente,... (solo el proyecto bio-psicosocial no proporciona esta tabla) e información ampliada del mismo.

![Imagen 1][1]  ![Imagen 2][2]

 [1]: Proyectos1.png "Proyectos 1"
 [2]: Proyectos2.png "Proyectos 2"

Pagina proyecto(oneProject.html)

Esta página sera la encargada de mostrar la descripción extensa del proyecto, una foto, las caracticas del proyecto (fecha, aportaciones...) y el botón más importante Participa para animar a la gente a colaborar en el proyecto.

![Imagen 1][1]  ![Imagen 2][2]

 [1]: proyectoEjemplo1.png "Ejemplo 1"
 [2]: proyectoEjemplo2.png "Ejemplo 2"

Noticias (blog.html)

Incluye una lista con las nooticias (título, imagen, información del cuerpo de la noticia, fecha de publicación y número de comentarios realizados por los usuarios, enlace que redirige al foro con los comentarios pertinentes). Por otra parte, proporciona un formulario que se debe rellenar para poder dejar un comentario relacionado con una noticia (la cual selecciona el usuario en dicho formulario). Por último, dispone de una lista de enlaces referentes a las categorías en las que se organizan las noticias, cuya selección lleva a la sección correspondiente dentro de la lista de noticias. 

![Imagen 1][1]  ![Imagen 2][2]

 [1]: Noticias1.png "Noticias 1"
 [2]: Noticias2.png "Noticias 2"


Contacto (contact.html)

Muestra, centrados, un texto que invita a los usuarios a resolver sus dudas y, por debajo, un área de texto (con etiqueta “Chat”), para poder consultar sus dudas al administrador de la aplicación manteniendo una comunicación directa, y un botón enviar (con un icono de mensaje). 

![Imagen 1][1]  

 [1]: Contacto.png "Contacto"


Sobre sus desarrolladores (about.html)

Ofrece un texto centrado explicando el origen de la aplicación, por qué y cómo srgió, y los integrantes del grupo de desarrolladores de la aplicación web con sus respectivas titulaciones. Además, incluirá próximamente una fotografía con los miembros del grupo.

![Imagen 1][1]  

 [1]: Abaout.png "Inicio 1"

Registro (register.html)

Proporciona un formulario para registrarse como usuario con campos de texto para introducir nombre, apellidos, nombre de usuario, correo electrónico, contraseña y confirmación de contraseña y un botón "Regístrate". Además, ofrece un enlace a la página de inicio de sesión para aquellos que ya están registrados.

![Imagen 1][1]  

 [1]: Registrarse.png "Registrarse"


Login (login.html)

Proporciona un formulario para loguearte como usuario y contraseña. También tiene 2 botones: "Se me ha olvidado la contraseña" y "Entrar". Asimismo, esta página también dispone de un enlace para aquellos que aún no están registrados, invitándoles a hacerlo.

![Imagen 1][1]  ![Imagen 2][2]

 [1]: IniciarSesion.png "Inicio 1"
 
 
Cuenta (users.html)

Hay una barra de navegación con Mis proyectos, Mis movimientos y Mis datos y el boton de cerrar sesión.
En mis proyectos se podra ver una tabla resumen con los proyectos en los que ha colaborado el usuario y otra con el resto de proyectos que hay a su disposición.
En mis movimientos se observa una tabla con el proyecto al que has colaborado y la cantidad aportada al mismo.
Finalmente esta la página de mis datos donde el usuario podra modificar su avatar, sus datos personales, correo y contraseña.

![Imagen 1][1]  ![Imagen 2][2]

 [1]: pictures/Indice1.png "Inicio 1"
 [2]: pictures/Indice2.png "Inicio 2"
