# 🗂️ Control de Clientes

Aplicación web desarrollada con **Spring Boot 3**, **Thymeleaf** y **Spring Security** para administrar un catálogo de clientes.  
Permite realizar operaciones CRUD (alta, edición y baja), visualizar métricas simples de la cartera y proteger el acceso mediante usuarios con distintos roles.

> Proyecto de práctica basado en un curso de Spring Boot, adaptado y personalizado con interfaz responsiva, selector de idioma y validaciones visuales.

---

## ✨ Características principales

- ✅ **Gestión de clientes**: crear, editar y eliminar clientes (nombre, apellido, email, teléfono, saldo).  
- ✅ **Dashboard con métricas**: muestra el **saldo total** y la **cantidad total de clientes**.  
- ✅ **Autenticación y roles**:
  - `ROLE_USER`: puede consultar el listado.
  - `ROLE_ADMIN`: puede agregar, editar y eliminar.  
- ✅ **Internacionalización (i18n)**: selector de idioma **ES / EN** en el pie de página.  
- ✅ **Validación de formularios**: campos obligatorios marcados en rojo si están vacíos.  
- ✅ **Diseño moderno con Bootstrap + Font Awesome** integrados mediante WebJars.  

---

## 🛠️ Tecnologías usadas

- **Lenguaje:** Java 17  
- **Frameworks:** Spring Boot 3, Spring MVC, Spring Security, Spring Data JPA  
- **Front-end:** Thymeleaf + Bootstrap  
- **Base de datos:** MySQL  
- **Herramientas:** Maven, DevTools, Lombok  

---

## ⚙️ Configuración de base de datos

En `src/main/resources/application.properties` (o `application.yml`) configurá tus credenciales:

```properties
server.port=9090

spring.datasource.url=jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🚀 Ejecucion
Compilar y ejecutar con Maven: mvn spring-boot:run

Luego abrí en tu navegador:
👉 http://localhost:9090

Al iniciar se muestra la pantalla de login.
Solo los usuarios con rol ROLE_ADMIN pueden editar, eliminar o agregar clientes.

🔐 Roles de ejemplo

| Rol            | Permisos                  | Descripción                     |
| -------------- | ------------------------- | ------------------------------- |
| **ROLE_USER**  | Ver listado y métricas    | Usuario estándar                |
| **ROLE_ADMIN** | Agregar, editar, eliminar | Administrador con control total |

📂 Estructura del proyecto

## 🗂️ Estructura del proyecto

```text
src/
 ├─ main/
 │   ├─ java/mx/com/gm/
 │   │   ├─ domain/        # Entidades: Persona, Usuario, Rol
 │   │   ├─ dao/           # Repositorios Spring Data
 │   │   ├─ servicio/      # Lógica de negocio
 │   │   └─ web/           # Controladores MVC, seguridad, i18n
 │   └─ resources/
 │       ├─ templates/     # Vistas Thymeleaf (index, login, layout, errores)
 │       ├─ static/        # CSS/JS si hubiera
 │       └─ messages_*.properties  # Textos ES / EN
 └─ test/

```

## 🖼️ Capturas de pantalla

1️⃣ Login
<img width="1586" height="759" alt="login" src="https://github.com/user-attachments/assets/e33a4922-8ef4-4af8-9192-70ade172a070" />

2️⃣ Panel de usuario (ROLE_USER)
<img width="1583" height="761" alt="User" src="https://github.com/user-attachments/assets/aa65238c-b391-44eb-942c-b9e5c17b54e1" />

3️⃣ Panel de administrador (ROLE_ADMIN)
<img width="1601" height="728" alt="admin" src="https://github.com/user-attachments/assets/d545ce63-a4c4-492e-8d5c-952ea4fcde7d" />

4️⃣ Modal “Agregar Cliente”
<img width="1595" height="723" alt="admin-agregar" src="https://github.com/user-attachments/assets/6c696f16-8bdb-489b-b95e-322d4aa8fed6" />


## 🧩 Internacionalización (i18n)

El proyecto incluye archivos de idioma en src/main/resources/:

messages_es.properties
messages_en.properties

El selector ubicado en el pie de página permite alternar entre español e inglés sin recargar la app.

## 🧪 Comandos útiles

# Compilar y generar el .jar
mvn clean package

# Ejecutar tests
mvn test

# Ejecutar desde el jar generado
java -jar target/control-clientes-0.0.1-SNAPSHOT.jar

