package TicTacToeProject;

public class TresEnRaya {
    public static void main(String[] args) {
        int[][] tablero = inicializarTablero(3,3);
        String[] nombres = new String[2];
        boolean comprobar = false;
        boolean ganador=false,empate=false;
        int turnos = 0,x,y;
        System.out.println("Bienvenido al Tres en Raya");
        System.out.println("--------------------------");
        nombres = pedirNombres();
        mostrarTablero(tablero);
        while (!ganador && !empate){
            if (turnos%2!=0){
                System.out.println("Te toca "+nombres[0]);
                do {
                    x = GetData.getInt("Ingrese la fila: ",0,2);
                    y = GetData.getInt("Ingrese la columna: ",0,2);
                    comprobar = colocarFicha(tablero,1,x,y);
                } while (!comprobar);
            } else {
                System.out.println("Te toca "+nombres[1]);
                do {
                    x = GetData.getInt("Ingrese la fila: ",0,2);
                    y = GetData.getInt("Ingrese la columna: ",0,2);
                    comprobar = colocarFicha(tablero,2,x,y);
                } while (!comprobar);
            }
            ganador = hayGanador(tablero);
            empate = juegoTerminado(tablero);
            mostrarTablero(tablero);
            if (!ganador && !empate){
                turnos++;
            }
        }
        System.out.println(" ");
        if (empate){
            System.out.println("Empate");
        } else {
            if (turnos%2!=0){
                System.out.println("Has ganado"+nombres[0]);
            } else {
                System.out.println("Has ganado"+nombres[1]);
            }
        }


    }

    static int[][] inicializarTablero(int x,int y){
        if (x<=0 || y<= 0){
            throw new IllegalArgumentException("La longitud del array debe de ser mayor");
        }
        int[][] tablero = new int[x][y];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = 0;
            }
        }
        return tablero;
    }

    public static void mostrarTablero (int[][] tablero){
        int indice = 0;
        System.out.println("  0   1   2");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i==0){
                    if (j==0){
                        System.out.print(indice+" ");
                        indice++;
                    }
                    if (j==tablero[0].length-1){
                        switch (tablero[i][j]){
                            case 0 -> System.out.print(" ");
                            case 1 -> System.out.print("0");
                            case 2 -> System.out.print("X");
                        }
                    } else {
                        switch (tablero[i][j]){
                            case 0 -> System.out.print("  | ");
                            case 1 -> System.out.print("0 | ");
                            case 2 -> System.out.print("X | ");
                        }
                    }
                }
                if (i==1){
                    if (j==0){
                        System.out.println(" ");
                        System.out.println("------------");
                        System.out.print(indice+" ");
                        indice++;
                    }
                    if (j==tablero[0].length-1){
                        switch (tablero[i][j]){
                            case 0 -> System.out.print(" ");
                            case 1 -> System.out.print("0");
                            case 2 -> System.out.print("X");
                        }
                    } else {
                        switch (tablero[i][j]){
                            case 0 -> System.out.print("  | ");
                            case 1 -> System.out.print("0 | ");
                            case 2 -> System.out.print("X | ");
                        }
                    }
                }
                if (i==2){
                    if (j==0){
                        System.out.println(" ");
                        System.out.println("------------");
                        System.out.print(indice+" ");
                    }
                    if (j==tablero[0].length-1){
                        switch (tablero[i][j]){
                            case 0 -> System.out.print(" ");
                            case 1 -> System.out.print("0");
                            case 2 -> System.out.print("X");
                        }
                    } else {
                        switch (tablero[i][j]){
                            case 0 -> System.out.print("  | ");
                            case 1 -> System.out.print("0 | ");
                            case 2 -> System.out.print("X | ");
                        }
                    }
                }

            }
        }
        System.out.println(" ");
    }

    static String[] pedirNombres (){
        String[] nombres = new String[2];
        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = GetData.getString("Ingrese tu nombre Jugador "+i+": ");
        }
        return nombres;
    }

    public static boolean colocarFicha(int [][] tablero, int ficha, int x, int y){
        boolean ocupado = tablero[x][y] == 0;
        if (ocupado){
            tablero[x][y] = ficha;
        }
        return ocupado;
    }

    public static boolean hayGanador(int [][] tablero){
        boolean ganador = false;
        int repeticiones;
        int ficha,columna;

        // Comprueba las Filas
        for (int i = 0; i < tablero.length && !ganador; i++) {
            repeticiones = 0;
            ficha = tablero[i][0];
            if (ficha != 0){
                for (int j = 0; j < tablero[0].length && !ganador; j++) {
                    if (tablero[i][j] == ficha){
                        repeticiones++;
                    }
                    if (repeticiones == 3){
                        ganador = true;
                        System.out.println("Fila");
                    }
                }
            }
        }

        // Comprobar columnas
        for (int i = 0; i < tablero.length && !ganador; i++) {
            repeticiones = 0;
            ficha = tablero[i][0];
            if (ficha != 0){
                for (int j = 0; j < tablero[0].length && !ganador; j++) {
                    if (tablero[j][i] == ficha){
                        repeticiones++;
                    }
                    if (repeticiones == 3){
                        ganador = true;
                        System.out.println("Columna");
                    }
                }
            }
        }

        // Comprobar diagonal derecha
        repeticiones = 0;
        ficha = tablero[0][0];
        if (ficha!=0){
            for (int i = 0; i < tablero.length && !ganador; i++) {
                if (tablero[i][i] == ficha){
                    repeticiones++;
                }
                if (repeticiones == 3){
                    ganador = true;
                    System.out.println("Derecha");

                }
            }
        }
        // Comprobar diagonal izquierda;
        repeticiones = 0;
        ficha = tablero[0][2];
        columna = 2;
        if (ficha!=0){
            for (int i = 0; i < tablero.length && !ganador; i++) {
                if (tablero[i][columna] == ficha){
                    repeticiones++;
                }
                if (repeticiones == 3){
                    ganador = true;
                    System.out.println("Izquierda");
                }
                columna--;
            }
        }
        return ganador;
    }

    public static boolean juegoTerminado(int [][] tablero){
        boolean empate = true;
        for (int i = 0; i < tablero.length && empate; i++) {
            for (int j = 0; j < tablero[0].length && empate; j++) {
                if (tablero[i][j] == 0){
                    empate = false;
                }
            }
        }
        return empate;
    }
}
