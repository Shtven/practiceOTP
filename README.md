# Proyecto: Autenticación Multifactor con OTP

## Descripción del proyecto
Este sistema implementa un mecanismo de autenticación multifactor (MFA) mediante el uso de códigos OTP (One-Time Password) enviados al correo electrónico del usuario.
Está compuesto por un frontend desarrollado en React y un backend en Spring Boot, conectados a una base de datos PostgreSQL.
El objetivo es fortalecer la seguridad del inicio de sesión mediante un segundo factor de verificación.

---

## Tecnologías utilizadas

### Frontend
- React + Vite
- JavaScript / TypeScript
- CSS (form.css personalizado)

### Backend
- Spring Boot 3  
- Java 17  
- Maven  
- PostgreSQL  
- Spring Data JPA  
- Spring Mail (para envío de OTP)  

### Control de versiones
- Git y GitHub  
- Conventional Commits

---

## Instrucciones para ejecutar el sistema

### Backend (Spring Boot)

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Shtven/practiceOTP.git
   cd practiceOTP/back/autentication
   ```

2. Configurar las variables en `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/otp_db
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
   spring.mail.username=tu_correo@gmail.com
   spring.mail.password=tu_contraseña_app
   ```

3. Ejecutar el servidor:
   ```bash
   mvn spring-boot:run
   ```

4. El backend quedará disponible en `http://localhost:8080`

---

### Frontend (React)

1. Ir a la carpeta:
   ```bash
   cd practiceOTP/front/loginReact
   ```

2. Instalar dependencias:
   ```bash
   npm install
   ```

3. Ejecutar el proyecto:
   ```bash
   npm run dev
   ```

4. Acceder desde el navegador a `http://localhost:5173`

---

## Ejemplo del flujo de login + OTP

1. El usuario se registra ingresando su nombre, correo y contraseña.
2. Inicia sesión con sus credenciales.
3. El sistema envía un código OTP temporal al correo del usuario.
4. El usuario introduce el código recibido en el formulario de verificación.
5. Si el código es correcto y no ha expirado, se muestra un mensaje de éxito.
6. Si el OTP es inválido o expira, se muestra un mensaje de error.

---

## Autor
**Gael Domínguez García** 

