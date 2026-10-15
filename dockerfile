# ---------- Etapa 1: Compilar la aplicación ----------
# Utiliza una imagen de Eclipse Temurin con JDK 25 para compilar el proyecto Java.
# Se asigna el nombre "build" a esta etapa para reutilizar sus archivos posteriormente.
FROM eclipse-temurin:25-jdk AS build

# Define el directorio de trabajo dentro del contenedor.
# A partir de aquí, los comandos se ejecutarán dentro de /app.
WORKDIR /app

# Copia el ejecutable de Gradle Wrapper al contenedor.
COPY gradlew .

# Copia los archivos y la configuración necesarios para ejecutar Gradle Wrapper.
COPY gradle gradle

# Copia los archivos de configuración del proyecto Gradle.
# build.gradle contiene las dependencias y tareas del proyecto.
# settings.gradle define la configuración general y los módulos del proyecto.
COPY build.gradle settings.gradle ./

# Otorga permisos de ejecución al Gradle Wrapper.
# Descarga o prepara las dependencias del proyecto para aprovechar la caché de Docker.
# --no-daemon evita iniciar un proceso Gradle persistente.
# La redirección oculta la salida del comando.
# "|| true" permite continuar incluso si falla la descarga de dependencias.
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon > /dev/null 2>&1 || true

# Copia el código fuente de la aplicación al contenedor.
COPY src src

# Compila la aplicación y genera el archivo JAR ejecutable de Spring Boot.
# -x test omite la ejecución de las pruebas automatizadas.
# --no-daemon evita iniciar un proceso Gradle persistente.
# Elimina los JAR terminados en "-plain.jar", que no son el paquete ejecutable
# principal de Spring Boot.
RUN ./gradlew bootJar -x test --no-daemon && rm -f build/libs/*-plain.jar


# ---------- Etapa 2: Ejecutar la aplicación ----------
# Utiliza una imagen de Eclipse Temurin con JRE 25.
# No incluye las herramientas de desarrollo del JDK, reduciendo el tamaño de la imagen.
FROM eclipse-temurin:25-jre

# Define el directorio de trabajo para la aplicación en ejecución.
WORKDIR /app

# Copia el JAR generado en la etapa "build" al contenedor final.
# Lo renombra como app.jar para simplificar el comando de inicio.
COPY --from=build /app/build/libs/*.jar app.jar

# Documenta que la aplicación utiliza el puerto 8081.
# Esta instrucción no publica el puerto automáticamente en el equipo anfitrión.
EXPOSE 8081

# Define el comando que se ejecuta al iniciar el contenedor.
# Ejecuta la aplicación Spring Boot utilizando Java y el archivo app.jar.
ENTRYPOINT ["java", "-jar", "app.jar"]