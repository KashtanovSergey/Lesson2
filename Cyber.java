public class Cyber {
    public static void main(String[] args) {
        Cyber main = new Cyber();
        String[][] correct = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect2 = {
                {"1", "2", "3", "4"},
                {"1", "2", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            System.out.println(sumOfMatrix(correct));
            System.out.println(sumOfMatrix(incorrect));
//          main.stringExceptionTest(correct);
//          main.stringExceptionTest(incorrect);
//          main.stringExceptionTest(incorrect2);
        }
//          catch (MyArraySizeException e) {
//          e.printStackTrace();
//        }
        catch (MyArrayDataException ex){
            ex.printStackTrace();
        }
    }

    private static int sumOfMatrix(String[][] matrix) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    public void stringExceptionTest(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4) throw new MyArraySizeException("Неверное количество строк");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException(String.format("Неверное количество столбцов в %d-й" +
                                                                                         " строке", i));
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}
