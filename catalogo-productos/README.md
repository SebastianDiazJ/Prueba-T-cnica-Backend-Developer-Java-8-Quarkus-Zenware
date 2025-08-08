## ✅ 5.1 Java Core – Clase Producto

Se implementó la clase `Producto` con los siguientes atributos:

- `id: Long`
- `nombre: String`
- `precio: double`

### Método `aplicarImpuesto(double porcentaje)`
Aplica un impuesto al precio, validando que el porcentaje esté entre 0% y 50%. Si no, lanza una excepción:

### java
if (porcentaje < 0 || porcentaje > 50) {
    throw new IllegalArgumentException("Porcentaje incorrecto, el porcentaje debe estar entre 0% y 50%");
}
this.precio += this.precio * (porcentaje / 100);

### ✔️ Pruebas Unitarias (JUnit 5)
Se realizaron dos pruebas:

✅ aplicarImpuesto_valido(): valida que el cálculo sea correcto.

✅ aplicarImpuesto_fueraDeRango(): valida que la excepción se lance correctamente si el porcentaje no está en rango.

## 📦 Funcionalidades Implementadas

### ✅ API de Productos

| Método | Endpoint              | Descripción                           |
|--------|------------------------|----------------------------------------|
| GET    | `/productos`           | Listar todos los productos             |
| POST   | `/productos`           | Crear un producto                      |
| GET    | `/productos/{id}`      | Obtener un producto por su ID          |
| DELETE | `/productos/{id}`      | Eliminar un producto por su ID         |

---

## 📘 Modelo

### Método `aplicarImpuesto(double porcentaje)`

Aplica un impuesto al precio, validando que el porcentaje esté entre 0% y 50%. Si no, lanza una excepción:

### java
if (porcentaje < 0 || porcentaje > 50) {
    throw new IllegalArgumentException("Porcentaje incorrecto, el porcentaje debe estar entre 0% y 50%");
}
this.precio += this.precio * (porcentaje / 100); 


## 📦 Funcionalidades Implementadas
✅ API de Productos
Método	Endpoint	Descripción
GET	/productos	Listar todos los productos
POST	/productos	Crear un producto
GET	/productos/{id}	Obtener un producto por su ID
DELETE	/productos/{id}	Eliminar un producto por su ID

## 📘 Modelo

public class Producto {
private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Min(value = 0, message = "El precio debe ser mayor o igual a cero")
    private double precio;
}
### 🖊️ 5.3 Análisis de logs/diagnostico.log
1. Causa raíz de la excepción
   415 Unsupported Media Type: El error ocurre porque el cliente no está enviando el Content-Type: application/json en las solicitudes POST.

2. Estrategia para prevenirlo
   Agregar validaciones de cabecera con filtros JAX-RS o documentar correctamente el uso esperado del API.

Verificar desde frontend o Postman que se incluya Content-Type: application/json en todas las solicitudes con cuerpo.

3. Nivel de log adecuado
   WARN: Este error es recuperable y está relacionado con el uso incorrecto del API. No requiere nivel ERROR salvo que se vuelva persistente.

### 🌐 5.4 Preguntas AWS
EC2 vs Lambda
Usaría EC2 cuando se necesita control total sobre el entorno, aunque no la manejo muy bien pero se puede ahcer ya que permite  ejecución continua o mantener procesos de larga duración.

Servicios de observabilidad
CloudWatch: Monitoreo de logs, métricas y alarmas.

AWS X-Ray: Trazabilidad de peticiones entre microservicios.

AWS CloudTrail: Auditoría de acciones realizadas en los servicios AWS.

### 📊 5.5 Ejercicio SQL
1. Consulta:

   SELECT * FROM productos
   WHERE precio > 100000
   ORDER BY precio DESC
   LIMIT 5;
2. Cuándo usar INDEX(nombre)
   Cuando uno realiza muchas búsquedas por nombre exacto o parcial, el índice acelera la recuperación de registros.

📅 Estado actual
Modelo Producto implementado y validado.

Repositorio en memoria funcional.

API REST documentada.

Pruebas unitarias completadas.

Problemas en POST diagnosticados y parcialmente resueltos.


