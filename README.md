# RestoApp

Aplicación web para gestionar un restaurante pequeño con roles de administrador, mesero y despachador. Incluye backend en Spring Boot con MongoDB y frontend en Angular responsivo usando Bootstrap. El proyecto está preparado para ejecutarse en contenedores Docker.

## Arquitectura
- **Backend**: Spring Boot 3 + Spring Data MongoDB (`backend/`).
- **Frontend**: Angular 17 + Bootstrap (`frontend/`).
- **Base de datos**: MongoDB.
- **Orquestación**: `docker-compose` levanta los tres servicios.

## Características principales
- Gestión de usuarios por rol.
- Catálogo de menú (entradas, fuertes, postres, bebidas) con disponibilidad.
- Administración de mesas con capacidad y ocupación actual.
- Flujo de órdenes con estados: tomada, recibida por despachador, despachada.
- Datos de demo se cargan automáticamente al iniciar el backend.

## Ejecución con Docker
Asegúrate de tener Docker y Docker Compose instalados.

```bash
# Construir y levantar todos los servicios
docker-compose up --build
```

- Frontend: http://localhost:4200
- Backend API: http://localhost:8080/api
- MongoDB: puerto 27017

## Estructura de carpetas
- `backend/`: aplicación Spring Boot.
- `frontend/`: aplicación Angular.
- `docker-compose.yml`: orquestación de servicios.

## Próximos pasos sugeridos
- Panel en cocina/despacho con ordenes en tiempo real.
- Inventario y desglose de recetas.
- Generación de tickets y envío de correos.
- Autenticación y permisos granulares.
