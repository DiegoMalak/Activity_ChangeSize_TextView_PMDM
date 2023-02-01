# Actividad UF4_2
# Activity_ChangeSize_TextView_PMDM
## Actividad de Android Studio para la asignatura Programación Multimedia y Dispositivos Móviles.


Aplicación que contiene un menú en el action bar formado por dos opciones de menú no visibles (Java y Python) y una visible (Salir).  
La actividad principal, MainActivity, tiene un botón para cambiar el tamaño de letra y un FrameLayout para contener fragmentos dinámicos.  

Al cargarse la actividad principal, se añade el fragmento InicioFragment al FrameLayout, cuyo layout tiene un TextView  
centrado con el texto "¡Hola Mundo!". La actividad también tiene un atributo llamado tam, inicializado a 24, que se usa  
para especificar el tamaño de letra en los fragmentos Java y Python.  

Si se pulsa el botón Cambiar Tamaño, se abre un DialogFragment llamado SizeDialog con un EditText para introducir un  
nuevo tamaño de letra y dos botones (Aceptar y Cancelar). Si se pulsa Aceptar, se almacena el nuevo tamaño en el atributo  
tam de MainActivity.  

Si se selecciona la opción de menú Java, se reemplaza el fragmento actual con JavaFragment, que muestra un TextView 
centrado con el siguiente código en Java:  

```java
public class HelloWorld {
  public static void main(String args[]) {
    System.out.println("¡Hola Mundo!");
  }
}
```

El tamaño de letra en este fragmento se establece con el valor de tam. Similarmente, si se selecciona la opción de menú Python,  
se reemplaza el fragmento actual con PythonFragment, que muestra el siguiente código en Python:  

```python
#!/usr/bin/env python\n# -*- coding: utf-8 -*-\n print("¡Hola mundo!")
```

El tamaño de letra en este fragmento también se establece con el valor de tam. Si se vuelve a pulsar el botón Cambiar Tamaño y se cambia el tamaño, el cambio se verá reflejado en los fragmentos Java y Python.

Si se selecciona la opción Salir, se muestra un Dialog de confirmación para salir de la aplicación. Todas las cadenas de texto se almacenan en strings.xml.

## Requisitos:
- Android Studio.
- Java para el código de funcionamiento.
- XML para la interfaz gráfica.

## Pautas para ejecutar:
1. Abrir Android Studio
2. Importar el proyecto Actividad UF3_5
3. Ejecutar la aplicación en un emulador o dispositivo real

## Resumen de clases y layouts:
- MainActivity –> activity_main.xml
- SizeDialog (DialogFragment) –> dialog_size.xml
- InicioFragment –> fragment_inicio.xml
- JavaFragment –> fragment_java.xml
- PythonFragment –> fragment_Python.xml
- onDatosListener (Interfaz)
- menu_main.xml
