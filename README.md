# Tipo cambio API


### Autorización

Usuario por defecto
```
{
    "username" : "root",
    "password": "root"
}
```

### Endpoints

```
Autorización

POST /api/auth/token - Token request

Tipo cambio

POST /api/tipo-cambio - Resuleve tipo cambio
PUT  /api/tipo-cambio - Actualiza tipo cambio

```


### Uso en contenedor

```sh
 docker-compose up -d --build
```

### Uso Local

```sh
.\mvnw spring-boot:run
```
