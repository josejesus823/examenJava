
# 🛍️ Sistema de Gestión de Productos (Java CLI)

Este proyecto es una aplicación de consola en Java que permite **agregar, visualizar, modificar, eliminar y verificar la caducidad** de un producto utilizando estructuras de datos como `LinkedHashMap`.

---

## 📦 Estructura del Producto

Cada producto se guarda como un diccionario (`LinkedHashMap<String, Object>`) con los siguientes campos:

- 🆔 `ID` – Identificador único (`UUID`)
- 📝 `Nombre` – Nombre del producto
- 💬 `Descripcion` – Descripción del producto
- 💲 `Precio` – Precio en formato `float`
- 🔢 `Cantidad` – Cantidad disponible
- 🏷️ `Categoria` – Tipo de producto
- ⏳ `Caducidad` – Si tiene o no fecha de vencimiento (`true/false`)
- 📅 `FechaVencimiento` – Fecha automática +3 días desde su creación o modificable
- 🔧 `Nproveedor` – Número del proveedor
- 🖼️ `Fotos` – Lista de 2 nombres de imágenes

---

## ▶️ ¿Cómo funciona?

Al ejecutar el programa, verás el siguiente menú:

```
 **** BIENVENIDO AL PROGRAMA ****
¿Qué desea hacer?
 1. Agregar
 2. Mostrar
 3. Modificar
 4. Eliminar
 5. Ver Producto Vencido
 6. Salir
```

---

## 🧭 Funcionalidades paso a paso

### 1️⃣ Agregar
🔹 Crea un nuevo producto solicitando todos los datos por consola.  
🔹 La `FechaVencimiento` se establece como `hoy + 3 días` automáticamente.

---

### 2️⃣ Mostrar
📋 Muestra todos los datos actuales del producto guardado (`producto2`).

---

### 3️⃣ Modificar
✏️ Permite modificar **uno de los siguientes campos**:

- `Nombre`, `Descripcion`, `Categoria` (string)
- `Precio` (float)
- `Cantidad`, `Nproveedor` (int)
- `Caducidad` (boolean)
- `FechaVencimiento`: se solicita un número entero de días para sumarle a `hoy`.

⚠️ Si ingresás una clave inválida, no se actualiza nada.

---

### 4️⃣ Eliminar
🗑️ Limpia por completo el producto actual después de confirmación `"si"`.

---

### 5️⃣ Ver Producto Vencido
🔍 Compara la fecha de hoy con la `FechaVencimiento`:

- ⛔ Si ya pasó → "Su producto está vencido"
- 📆 Si es hoy → "El producto vence hoy"
- ⏳ Si faltan días → "Su producto todavía le quedan X días"

---

### 6️⃣ Salir
🚪 Finaliza el programa.

---

## 🛠️ Tecnologías usadas

- 💻 Java 17+
- 📦 `LinkedHashMap`, `ArrayList`, `UUID`, `Scanner`, `LocalDate`, `ChronoUnit`

---

## ✅ Estado

✔️ Funcional y probado en consola.  
⚠️ Soporta un solo producto a la vez (`producto2` quemado y/o sobreescrito).

---

## 📌 Notas

- Si modificás `"FechaVencimiento"`, el sistema espera un número entero de días a partir de **hoy**.
- La opción `1. Agregar` crea otro producto en `producto`, pero no se reutiliza en las otras opciones. Por ahora, todo el sistema opera sobre `producto2`.

---

## 🚀 Mejoras sugeridas

- Almacenar múltiples productos (`ArrayList<LinkedHashMap<String, Object>>`)
- Validaciones por tipo y campos obligatorios
- Persistencia en archivo o base de datos

---

Desarrollado con ☕ por José Jesús Vargas
