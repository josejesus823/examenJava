package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean state = false;

        LinkedHashMap <String, Object> producto = new LinkedHashMap<>();
        int count = 0;

        //VARIABLE QUEMADA
        //

        LinkedHashMap<String, Object> producto2 = new LinkedHashMap<>() {{
        put("ID", UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
        put("Nombre", "Laptop Lenovo");
        put("Descripcion", "Laptop con 16GB de RAM y SSD 512GB");
        put("Precio", 3200.50f);
        put("Cantidad", 10);
        put("Categoria", "Electrónica");
        put("Caducidad", false);
        put("FechaVencimiento", LocalDate.now().plusDays(3));
        put("Nproveedor", 12345);
        put("Fotos", new ArrayList<>(List.of("foto1.png", "foto2.png")));
        }};

        System.out.println(producto2.size());
        do {
            System.out.println(" **** BIENVENIDO AL PROGRAMA ****");
            System.out.println("Que desea hacer?");
            System.out.println(" 1. Agregar \n 2. Mostrar \n 3. Modificar \n 4. Eliminar \n 5. Ver Producto Vencido \n 6. Salir ");
            int getUserInput = sc.nextInt();
//ID, NOMBRE, DESCRIPCION, PRECIO, CANTIDAD, CATEGORIA, CADUCIDAD, FCHAVENCIMIENTO, NPROVEEDOR, FOTOGRAFIA 1 Y FOTOGRAFIA2
            switch (getUserInput){
                case 1:
                    UUID ID = UUID.randomUUID();
                    LocalDate nowTime = LocalDate.now();
                    ArrayList<String> photos = new ArrayList<>();

                    System.out.println("Ingrese el nombre del producto :");
                    String getProductName = sc.next();

                    System.out.println("Ingrese su precio: ");
                    float getProductPrice = sc.nextFloat();
                    sc.nextLine();

                    System.out.println("Ingrese la descripcion del producto :");
                    String getProductDescripcion = sc.nextLine();

                    System.out.println("Ingrese la cantidad del producto");
                    int getQuantityProduct = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese la categoria del producto :");
                    String getProductCategory = sc.nextLine();

                    System.out.println("Su producto tiene caducidad?  true / false");
                    boolean isExpiration = sc.nextBoolean();

                    System.out.println("Ingrese el numero del proveedor: ");
                    int nSupplier = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese Fotografia1");
                    String photoOne = sc.nextLine();

                    System.out.println("Ingrese Fotografia2");
                    String photoTwo = sc.nextLine();

                    photos.add(photoOne);
                    photos.add(photoTwo);


                    producto.put("ID", ID);
                    producto.put("Nombre",getProductName);
                    producto.put("Descripcion", getProductDescripcion);
                    producto.put("Precio", getProductPrice);
                    producto.put("Cantidad", getQuantityProduct);
                    producto.put("Categoria", getProductCategory);
                    producto.put("Caducidad", isExpiration);
                    producto.put("FechaVencimiento", nowTime.plusDays(3));
                    producto.put("Nproveedor", nSupplier);
                    producto.put("Fotos", photos);

                    System.out.println("=========== PRODUCTO AÑADIDO EXITOSAMENTE ===========");


                    break;

                case 2:
                    if(producto2.size() == 0){
                        System.out.println("Lo siento no tiene productos agregados agregue uno primero");
                        break;
                    }

                    else {
                        for (Map.Entry<String, Object> dic : producto2.entrySet()){
                            String key = dic.getKey();
                            Object value = dic.getValue();
                            System.out.println(key + ": " + value);
                        }
                    }

                    try{
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e ) {
                        e.printStackTrace();
                    }

                    break;

                case 3:
                    System.out.println("Que desea modificar?");
                    for (Map.Entry<String, Object> dic : producto2.entrySet()){
                        String key = dic.getKey();
                        Object value = dic.getValue();
                        System.out.println("La llave es " + key + " y el valor que guarda es " + value);
                    }

                    System.out.println("Ingrese el nombre de la llave a modificar");
                    String userGetKey = sc.next();

                    if (userGetKey.equalsIgnoreCase("Nproveedor") || userGetKey.equalsIgnoreCase("Cantidad")){
                        System.out.println("Ingrese el nuevo dato");
                        int userGetValue = sc.nextInt();

                        producto2.put(userGetKey, userGetValue);
                        System.out.println("Dato " + userGetKey + " Actualizado Exitosamente!!!!!!");
                    }
                    else if (userGetKey.equalsIgnoreCase("Nombre") || userGetKey.equalsIgnoreCase("Descripcion") || userGetKey.equalsIgnoreCase("Categoria")) {
                        System.out.println("Ingrese el nuevo dato");
                        String userGetValue = sc.nextLine();

                        producto2.put(userGetKey, userGetValue);
                        System.out.println("Dato " + userGetKey + " Actualizado Exitosamente!!!!!!");
                    }
                    else if (userGetKey.equalsIgnoreCase("Precio")) {
                        System.out.println("Ingrese el nuevo dato");
                        Float userGetValue = sc.nextFloat();

                        producto2.put(userGetKey, userGetValue);
                        System.out.println("Dato " + userGetKey + " Actualizado Exitosamente!!!!!!");
                    }
                    else if (userGetKey.equalsIgnoreCase("Caducidad")) {
                        System.out.println("Ingrese el nuevo dato");
                        boolean userGetValue = sc.nextBoolean();

                        producto2.put(userGetKey, userGetValue);
                        System.out.println("Dato " + userGetKey + " Actualizado Exitosamente!!!!!!");
                    }
                    else if (userGetKey.equalsIgnoreCase("FechaVencimiento")) {
                        System.out.println("La fecha de vencimiento esta programada para 3 dias despues de haberse creado el producto, por lo tanto si desea modificar este dato debe ingresar el numero de dias en entero");
                        int userGetValue = sc.nextInt();
                        LocalDate userNewTime = LocalDate.now();

                        producto2.put(userGetKey, userNewTime.plusDays(userGetValue));
                        System.out.println("Dato " + userGetKey + " Actualizado Exitosamente!!!!!!");
                    }

                    break;

                case 4:
                    if (producto2.size() <= 0) {
                        System.out.println("Error debe agregar un producto primero");
                        break;
                    }
                    else {
                        System.out.println("Esta seguro que desea eliminar el producto? SI/ NO");
                        String userAnswer = sc.next().toLowerCase();
                        if(userAnswer.equals("si")){
                            producto2.clear();
                            System.out.println("Producto Eliminado Exitosamente");
                        }
                    }
                    break;

                case 5:
                    LocalDate fechaDiccionario = (LocalDate) producto2.get("FechaVencimiento");
                    LocalDate fechaHoy = LocalDate.now();
                    long diasRestantes = ChronoUnit.DAYS.between(fechaHoy, fechaDiccionario);
                    if(diasRestantes < 0) {
                        System.out.println("Su producto esta vencido");
                    }
                    else if (diasRestantes == 0){
                        System.out.println("El producto vence hoy");
                    }
                    else {
                        System.out.println("Su producto todavia le quedan " + diasRestantes + " Dias para que caduque");
                    }

                    break;


                case 6:
                    System.exit(1);

                default:
                    System.out.println("Usted no ha seleccionado alguna de las opciones validas");
            }
        } while (!state);
    }
}