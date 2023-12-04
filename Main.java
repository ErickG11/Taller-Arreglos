import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Parqueadero a1=new Parqueadero();
        int op;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("---------Ingresar una opcion------");
            System.out.println("1. ------Ingresar un carro al parqueadero.-----");
            System.out.println("2.-------Dar salida a un carro del parqueadero.----");
            System.out.println("3. ------Informar los ingresos del parqueadero.----");
            System.out.println("4. ------Consultar la cantidad de puestos disponibles.----");
            System.out.println("5. ------Avanzar el reloj del parqueadero.----");
            System.out.println("6. ------Cambiar la tarifa del parqueadero.----");
            System.out.println("7. ------El tiempo promedio es----");
            System.out.println("8. ------Lista de carros con mas de 8 horas----");
            System.out.println("9. ------Lista de carros con mas de 3 horas----");
            System.out.println("10. -----Carros con la misma placa----");
            System.out.println("11. -----Carros que comienzan con PB-----");
            System.out.println("12. -----Carros con mas de 24h----");
            System.out.println("13. -----Cantidad de carros con placa PB con mas de 24h----");
            System.out.println("14. -----Desocupar el parqueadero-----");
            System.out.println("15. -----Cantidad de carros sacados-----");
            System.out.println("16. -----Salir---");
            op = Integer.parseInt(sc.next());
            switch (op) {
                case 1: {
                    System.out.print("Ingrese la placa del carro: ");
                    String placa = sc.next();
                    int resultado = a1.entrarCarro(placa);
                    if (resultado == Parqueadero.NO_HAY_PUESTO) {
                        System.out.println("El parqueadero está lleno");
                    } else if (resultado == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado");
                    } else if (resultado == Parqueadero.CARRO_YA_EXISTE) {
                        System.out.println("Ya hay un carro con esa placa en el parqueadero");
                    } else {
                        System.out.println("Carro ingresado correctamente. Puesto asignado: " + resultado);
                    }
                }
                break;
                case 2: {
                    System.out.print("Por favor ingresar la placa del carro a sacar: ");
                    String placaSacar = sc.next();
                    int valorPagar = a1.sacarCarro(placaSacar);
                    if (valorPagar == Parqueadero.CARRO_NO_EXISTE) {
                        System.out.println("El carro no se encuentra en el parqueadero");
                    } else if (valorPagar == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado");
                    } else {
                        System.out.println("Carro sacado del parqueadero. Valor a pagar: " + valorPagar);
                    }
                }
                break;
                case 3:{
                    int montoCaja = a1.darMontoCaja();
                    System.out.println("Los ingresos del parqueadero: " + montoCaja);
                }
                break;
                case 4:{
                    int puestosLibres = a1.calcularPuestosLibres();
                    System.out.println("Puestos disponibles: " + puestosLibres);
                }
                break;
                case 5: {
                    a1.avanzarHora();
                    System.out.println("Reloj avanzado correctamente 1h");
                }
                break;
                case 6: {
                    System.out.print("Ingrese la nueva tarifa: ");
                    int nuevaTarifa = sc.nextInt();
                    a1.cambiarTarifa(nuevaTarifa);
                    System.out.println("La tarifa ha sido cambiada correctamente");
                }
                break;
                case 7:{
                    float tiempoPromedio=a1.darTiempoPromedio();
                    System.out.println("El tiempo promedio es: "+tiempoPromedio);
                }
                break;
                case 8:{
                    // boolean ArrayList<Carro> carros8H = a1.hayCarroMasDeOchoHoras();
                    boolean mensaje= a1.hayCarroMasDeOchoHoras();
                    System.out.println("Los carros con mas de 8h: "+mensaje);
                }
                break;
                case 9:{
                    ArrayList<Carro> carros3H = a1.darCarrosMasDeTresHorasParqueados();
                    System.out.println("Los carros con mas de 3h: "+carros3H);
                }
                break;
                case 10:{
                    boolean mensajero= a1.hayCarrosPlacaIgual();
                    System.out.printf("Los carros con la misma placa"+mensajero);

                }
                break;
                case 11:{
                    int carrosPB = a1.contarCarrosQueComienzanConPlacaPB();
                    System.out.println("Carros que comienzan con placa PB:"+carrosPB);
                }
            }
        }while (op != 16) ;

    }

}