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
