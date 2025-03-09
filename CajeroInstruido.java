/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.programadornotavo.cajeroinstruido;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Objects;

/**
 * 
 * @author  SIR Santiago Restrepo González
 */
public class CajeroInstruido {
    
    public boolean validarPin(int pinIngresado, int pinCorrecto){
        return pinIngresado == pinCorrecto;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int PIN_CORRECTO=1234;
        double saldo=50000;
        final String CODIGO_NEQUI="435684";
        int intentos = 0;
        boolean cuentaBloqueada = false;
        double valorTransferencia=0;
        
        while (intentos < 3){
            System.out.println("Introducid la cifra oculta");
            try{
                int pin = scanner.nextInt();
                if((pin==PIN_CORRECTO)){
                    System.out.println("Bien hallado en la excelsa SantiLOMBIA");
                    break;
                }else{
                    intentos++;
                    if(intentos<3){
                        System.out.println("Clave errada. Ensayos remanentes "+(3-intentos));
                    }
                }
            }catch (Exception e){
                intentos++;
                if (intentos < 3){
                    System.out.println("Entrada improba. Acordaos que el PIN se compone únicamente de cifras");
                    System.out.println("Ensayos remanentes "+(3-intentos));
                }
                scanner.nextLine();
            }
            
            if(intentos == 3){
                cuentaBloqueada=true;
                System.out.println("Vuestra cuenta se halla vedada");
            }
        }
        if (cuentaBloqueada){
            scanner.close();
            return;
        }
        int opcion;
        do{
            System.out.println("1.Averiguar el haber");
            System.out.println("2.Retirada");
            System.out.println("3.Depositar");
            System.out.println("4.traspasar");
            System.out.println("5.Retirada en el insigne Nequi");
            System.out.println("6.Emprended el dulce retiro del sistema");
            System.out.println("Ecoged la opción idónea");
            try {
                opcion = scanner.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("El haber que os corresponde es: $"+saldo);
                        break;
                    case 2:
                        boolean validacionRetiro = false;
                        while (!validacionRetiro){
                            try {
                                System.out.println("Qué suma de caudales anheláis retirar");
                                double retiro = scanner.nextDouble();
                                
                                if (retiro > 0 && retiro <= saldo){
                                    saldo-=retiro;
                                    System.out.println("vuestro nuevo haber asciende a "+saldo);
                                    break;
                                }else{
                                    System.out.println("Vuestros caudales no son suficientes o yacen inaccesibles.");
                                    break;
                                }
                                
                            } catch (InputMismatchException e) {
                                System.out.println("Yerraís: Solo se admiten cifras.");
                                scanner.nextLine();
                            }
                        }  
                        break;
                    case 3:
                        boolean validacionDeposito=false;
                        while(!validacionDeposito){
                        try {
                            System.out.println("¿Cuál suma deseáis consignar?");
                            double deposito = scanner.nextDouble();
                            
                            if (deposito>0){
                                saldo+=deposito;
                                System.out.println("Consignación culminada con éxito");
                                System.out.println("vuestro nuevo haber asciende a: "+saldo);
                                validacionDeposito = true;
                            }else{
                                System.out.println("");
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("¡Desatino! Solo guarismos son admitidos en esta lid");
                            scanner.nextLine();
                        } 
                    }
                        break;
                    case 4:
                        boolean montoTransferencia=false;
                        while(!montoTransferencia){
                            System.out.println("Digitad la suma que anheláis traspasar");
                            try{
                                valorTransferencia = scanner.nextDouble();
                                if (valorTransferencia <= 0){
                                    System.out.println("¡Desatino! Solo guarismos son admitidos en esta lid ");
                                }else if (valorTransferencia > saldo){
                                    System.out.println("Desventura! Vuestros caudales no bastan para tal menester.");
                                }else{
                                    montoTransferencia = true;
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Debéis introducir un guarismo legítimo y de buen juicio");
                                scanner.next();
                            }
                        }
                        
                        scanner.nextLine();
                        System.out.println("Digitad el número de la cuenta destino para el traspaso de caudales.");
                        String cuentaDeposito = scanner.nextLine();
                        while(cuentaDeposito.length()!=11){
                            System.out.println("Tened presente que el número de cuenta debe constar de once guarismos.");
                            cuentaDeposito = scanner.nextLine(); 
                        }
                        saldo-=valorTransferencia;
                        System.out.println("¡Traspaso consumado con éxito y buen ventura!");
                        System.out.println("Ente de recepción." +cuentaDeposito);
                        System.out.println("Caudal remitido: "+ valorTransferencia);
                        break;
                    case 5:
                        System.out.println("Oh, noble alma de insigne linaje! Tenéos a bien el honor de digitar vuestro número de aldabonazo.");                        
                        String numTelefono = scanner.next();
                        while (numTelefono.length()!=10){
                            System.out.println("¡Ah, desatino! Vuestro número ha de constar de diez guarismos, noble caballero.");
                            numTelefono= scanner.next();
                        }
                        System.out.println("Escoged la suma que anheláis extraer, ilustre caballero.");
                        System.out.println("1.20000");
                        System.out.println("2.50000");
                        System.out.println("3.100000");
                        System.out.println("4.200000");
                        System.out.println("5.300000");
                        System.out.println("6.500000");
                        System.out.println("7.1000000");
                        System.out.println("8.Requerid una suma distinta, buen caballero.");
                        int opcionMonto = scanner.nextInt();
                        int monto = 0;
                        final int MONTO_MAXIMO= 2000000;
                        
                        if (opcionMonto < 1 || opcionMonto > 8){
                            System.out.println("Desacierto! La elección no es de buen tino. ");
                            break;
                        }else if(opcionMonto == 8){
                            boolean montoValido = false;
                            while (!montoValido){
                                System.out.println("Introducid el guarismo que anheláis extraer, noble caballero.");
                                System.out.println("Tened presente que la suma máxima a retirar asciende a 2.000.000 de caudales.");
                                try{
                                    monto=scanner.nextInt();
                                    if (monto < 0){
                                        System.out.println("¡Desatino! La suma ha de ser superior a cero, noble caballero.");
                                    }else if (monto > MONTO_MAXIMO){
                                        System.out.println("¡Ah, desmesura! No os es dado exceder el límite máximo de caudales $"+MONTO_MAXIMO);
                                    }else{
                                        montoValido = true;
                                    }
                                } catch(InputMismatchException e){
                                    System.out.println("Debéis introducir un guarismo de recta valía, noble caballero.");
                                    scanner.nextLine();
                                }
                            }
                        }else{
                            switch(opcionMonto){
                                case 1:
                                    monto=20000;
                                    break;
                                case 2:
                                    monto=50000;
                                    break;
                                case 3:
                                    monto=100000;
                                    break;
                                case 4:
                                    monto=200000;
                                    break;
                                case 5:
                                    monto=300000;
                                    break;
                                case 6:
                                    monto=500000;
                                    break;
                                case 7:
                                    monto=1000000;
                                    break;
                                default:
                                    System.out.println("Opción inválida");
                                    break;
                                    
                            }
                        }
                        
                        System.out.println("Introducid el códice de la ilustre aplicación, noble caballero");
                        scanner.nextLine();
                        String codigoNequi = scanner.nextLine();
                        while(codigoNequi.length()!=6){
                            System.out.println("¡Yerran vuestros dígitos! El códice no es de buen tino.");
                            codigoNequi = scanner.nextLine();
                        }
                        if (Objects.equals (codigoNequi, CODIGO_NEQUI)){
                            System.out.println("Retirada de caudales desde el número vinculado a NEQUI "+numTelefono+ "¡La retirada ha sido consumada con éxito y buen ventura!");
                            System.out.println("Dinero retirado $"+monto);
                            
                        }else{
                            System.out.println("¡Desacierto! El códice ingresado no es acertado");
                        }
                        break;
                    case 6:
                        System.out.println("Que los vientos favorables guíen vuestro camino, noble caballero. ¡Hasta otra justa!");
                        break;
                    default:
                        System.out.println("¡Desatino! La elección no es de buen juicio.");
                        break;
                }
                
                
            } catch (InputMismatchException e) {
                System.out.println("¡Ah, yerro infausto! Algo no ha salido según lo previsto");
                System.out.println("Os ruego que introduzcáis únicamente guarismos, noble caballero");
                scanner.nextLine();
                opcion=0;
            }
        }while(opcion !=6);
        
        scanner.close();
    }
}
