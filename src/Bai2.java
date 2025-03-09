import java.util.*;

public class Bai2 {
    private static int[][] matrix;
    private static int n, m;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("********** MENU **********");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In mảng theo ma trận");
            System.out.println("3. Đếm số lượng phần tử chia hết cho 2 và 3");
            System.out.println("4. In và tính tổng đường biên, đường chéo");
            System.out.println("5. Sắp xếp tăng dần theo cột");
            System.out.println("6. In các số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp đường chéo chính giảm dần (Insertion Sort)");
            System.out.println("8. Chèn mảng 1 chiều vào mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: nhapMang(); break;
                case 2: inMang(); break;
                case 3: demSoChiaHet2Va3(); break;
                case 4: inVaTinhTong(); break;
                case 5: sapXepTheoCot(); break;
                case 6: inSoNguyenTo(); break;
                case 7: sapXepCheoChinh(); break;
                case 8: chenMang(); break;
                case 9: System.out.println("Thoát chương trình"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
    }

    private static void nhapMang() {
        System.out.print("Nhập số hàng n: ");
        n = scanner.nextInt();
        System.out.print("Nhập số cột m: ");
        m = scanner.nextInt();
        matrix = new int[n][m];
        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void inMang() {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void demSoChiaHet2Va3() {
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num % 2 == 0 && num % 3 == 0) count++;
            }
        }
        System.out.println("Số lượng phần tử chia hết cho 2 và 3: " + count);
    }

    private static void inVaTinhTong() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1 || i == j || i + j == m - 1) {
                    System.out.print(matrix[i][j] + " ");
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println("\nTổng các phần tử trên biên và đường chéo: " + sum);
    }

    private static void sapXepTheoCot() {
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int k = i + 1; k < n; k++) {
                    if (matrix[k][j] < matrix[minIdx][j]) minIdx = k;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[minIdx][j];
                matrix[minIdx][j] = temp;
            }
        }
        inMang();
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static void inSoNguyenTo() {
        for (int[] row : matrix) {
            for (int num : row) {
                if (isPrime(num)) System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    private static void sapXepCheoChinh() {
        List<Integer> diagonal = new ArrayList<>();
        for (int i = 0; i < Math.min(n, m); i++) {
            diagonal.add(matrix[i][i]);
        }
        diagonal.sort(Collections.reverseOrder());
        for (int i = 0; i < diagonal.size(); i++) {
            matrix[i][i] = diagonal.get(i);
        }
        inMang();
    }

    private static void chenMang() {
        System.out.print("Nhập số phần tử của mảng 1 chiều: ");
        int[] newRow = new int[m];
        for (int i = 0; i < m; i++) newRow[i] = scanner.nextInt();
        System.out.print("Nhập chỉ số dòng cần chèn: ");
        int rowIndex = scanner.nextInt();
        int[][] newMatrix = new int[n + 1][m];
        for (int i = 0, k = 0; i <= n; i++) {
            if (i == rowIndex) {
                newMatrix[i] = newRow;
            } else {
                newMatrix[i] = matrix[k++];
            }
        }
        matrix = newMatrix;
        n++;
        inMang();
    }
}