import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Triangle> listTriangles = new ArrayList<>();
        String lineFile;
        int[] coordinates = new int[6];
        try {
            String fileInput = args[0];
            String fileOutput = args[1];
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileInput));
            while ((lineFile = bufferedReader.readLine()) != null) {
                String[] line = lineFile.split(" ");
                if (isRightAmount(line) && isNumbers(line)) {
                    for (int i = 0; i < line.length; i++) {
                        coordinates[i] = Integer.parseInt(line[i]);
                    }
                    if (isItTriangle(coordinates)) {
                        Triangle triangle = new Triangle(coordinates);
                        if (triangle.isIsoscelesTriangle()) {
                            listTriangles.add(triangle);
                        } else {
                            System.out.println("Ошибка! Треугольник не является равнобедренным.");
                        }
                    }
                }
            }

            TriangleComparator areaComparator = new TriangleComparator();
            listTriangles.sort(areaComparator);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutput));
            bufferedWriter.write(listTriangles.get(listTriangles.size()-1).toString());

            bufferedReader.close();
            bufferedWriter.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Передайте в аргументах командной строки название файлов для чтения и записи.");
            return;
        } catch (IOException e) {
            System.out.println("Введите верное название файлов.");
            return;
        }
    }

    // isRightAmount() - проверка на количество элементов между пробелами
    public static boolean isRightAmount(String[] line) {
        if (line.length == 6) {
            return true;
        } else {
            System.out.println("Ошибка, строка не соответсвует условиям! Должно быть 6 значений.");
            return false;
        }
    }

    // isNumbers() - проверка, что в строке находятся только числа
    public static boolean isNumbers(String[] line) {
        try {
            for (String n : line) {
                Integer.parseInt(n);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка, строка не соответсвует условиям! Присутсвуют нечисловые символы.");
            return false;
        }
        return true;
    }

    // isItTriangle() - проверка, что координаты соответсвуют координатам треугольника
    public static boolean isItTriangle(int[] coordinates) {
        int coord_x1 = coordinates[0];
        int coord_y1 = coordinates[1];
        int coord_x2 = coordinates[2];
        int coord_y2 = coordinates[3];
        int coord_x3 = coordinates[4];
        int coord_y3 = coordinates[5];

        double sideFirst = Math.sqrt((coord_x1 - coord_x2) * (coord_x1 - coord_x2) + (coord_y1 - coord_y2) * (coord_y1 - coord_y2));
        double sideSecond = Math.sqrt((coord_x1 - coord_x3) * (coord_x1 - coord_x3) + (coord_y1 - coord_y3) * (coord_y1 - coord_y3));
        double sideThird = Math.sqrt((coord_x2 - coord_x3) * (coord_x2 - coord_x3) + (coord_y2 - coord_y3) * (coord_y2 - coord_y3));

        if ((sideFirst + sideSecond > sideThird) && (sideFirst + sideThird > sideSecond) && (sideSecond + sideThird > sideFirst)) {
            return true;
        } else {
            System.out.println("Ошибка, представлены координаты не треугольника.");
            return false;
        }

    }


}
