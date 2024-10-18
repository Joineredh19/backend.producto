# API REST de Productos con Spring Boot

Este proyecto es una API REST desarrollada con Spring Boot para la gestión de productos. Proporciona operaciones CRUD (Crear, Leer, Actualizar y Eliminar) para la entidad Producto.

## 🛠 Tecnologías Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Maven

## 📋 Prerequisitos

- Java JDK 17 o superior
- Maven 3.6.x o superior
- Tu IDE favorito (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Instalación y Configuración

1. Clona el repositorio:
```bash
https://github.com/Joineredh19/backend.producto.git
```

2. Navega al directorio del proyecto:
```bash
cd backend.producto
```

3. Compila el proyecto:
```bash
mvn clean install
```

4. Ejecuta la aplicación:
```bash
mvn spring-boot:run
```

## 📁 Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/hypersoft/productos/
│   │       ├── controller/
│   │       │   └── ProductoController.java
│   │       ├── entities/
│   │       │   └── Producto.java
│   │       ├── repositories/
│   │       │   └── ProductoRepository.java
│   │       ├── services/
│   │       │   └── ProductoService.java
│   │       └── ProductosApplication.java
│   └── resources/
│       └── application.properties
└── 
```

## 🔄 Endpoints de la API

### Producto Controller

| Método HTTP | Endpoint | Descripción |
|------------|----------|-------------|
| GET | `/productos` | Obtiene todos los productos |
| GET | `/productos/{id}` | Obtiene un producto por ID |
| POST | `/productos` | Crea un nuevo producto |
| PUT | `/productos` | Actualiza un producto existente |
| DELETE | `/productos/{id}` | Elimina un producto por ID |

### Ejemplos de Uso

#### Obtener todos los productos
```bash
GET http://localhost:8080/productos
```

#### Obtener producto por ID
```bash
GET http://localhost:8080/productos/1
```

#### Crear nuevo producto
```bash
POST http://localhost:8080/productos
Content-Type: application/json

{
    "nombre": "Producto Ejemplo",
    "precio": 99.99,
    "cantidad": 1
}
```

#### Actualizar producto
```bash
PUT http://localhost:8080/productos
Content-Type: application/json

{
    "id": 1,
    "nombre": "Producto Actualizado",
    "precio": 149.99,
    "cantidad": 2
}
```

#### Eliminar producto
```bash
DELETE http://localhost:8080/productos/1
```


## 🚦 Estado de los Códigos de Respuesta

| Código | Descripción |
|--------|-------------|
| 200 | Operación exitosa |
| 201 | Recurso creado exitosamente |
| 400 | Solicitud incorrecta |
| 404 | Recurso no encontrado |
| 500 | Error interno del servidor |
