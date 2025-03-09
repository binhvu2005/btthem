import java.util.*;

public class Bai1 {
    private static int[] arr = new int[100];
    private static int n;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("********** MENU **********");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương");
            System.out.println("4. In vị trí các phần tử có giá trị bằng k");
            System.out.println("5. Sắp xếp mảng giảm dần (Bubble Sort)");
            System.out.println("6. Đếm số lượng số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp theo yêu cầu đặc biệt");
            System.out.println("8. Chèn m vào mảng (sắp xếp giảm dần)");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: nhapMang(); break;
                case 2: inMang(); break;
                case 3: tinhTrungBinhDuong(); break;
                case 4: timViTri(); break;
                case 5: bubbleSort(); break;
                case 6: demSoNguyenTo(); break;
                case 7: sapXepDacBiet(); break;
                case 8: chenMang(); break;
                case 9: System.out.println("Thoát chương trình"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
    }

    private static void nhapMang() {
        System.out.print("Nhập số phần tử n: ");
        n = scanner.nextInt();
        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    private static void inMang() {
        System.out.println("Mảng: " + Arrays.toString(Arrays.copyOf(arr, n)));
    }

    private static void tinhTrungBinhDuong() {
        int sum = 0, count = 0;
        for (int num : arr) {
            if (num > 0) {
                sum += num;
                count++;
            }
        }
        System.out.println("Trung bình các số dương: " + (count > 0 ? (double) sum / count : 0));
    }

    private static void timViTri() {
        System.out.print("Nhập giá trị k: ");
        int k = scanner.nextInt();
        System.out.print("Vị trí: ");
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void bubbleSort() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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

    private static void demSoNguyenTo() {
        int count = 0;
        for (int num : arr) {
            if (isPrime(num)) count++;
        }
        System.out.println("Số lượng số nguyên tố: " + count);
    }

    private static void sapXepDacBiet() {
        List<Integer> chan3 = new ArrayList<>();
        List<Integer> le3 = new ArrayList<>();
        List<Integer> conLai = new ArrayList<>();

        for (int num : arr) {
            if (num % 3 == 0 && num % 2 == 0) {
                chan3.add(num);
            } else if (num % 3 == 0 && num % 2 != 0) {
                le3.add(num);
            } else {
                conLai.add(num);
            }
        }

        Collections.sort(chan3);
        Collections.sort(conLai);
        le3.sort(Collections.reverseOrder());

        int index = 0;
        for (int num : chan3) arr[index++] = num;
        for (int num : conLai) arr[index++] = num;
        for (int num : le3) arr[index++] = num;

        inMang();
    }

    private static void chenMang() {
        System.out.print("Nhập giá trị m: ");
        int mValue = scanner.nextInt();

        int[] newArr = Arrays.copyOf(arr, n + 1);
        int i = n - 1;
        while (i >= 0 && newArr[i] < mValue) {
            newArr[i + 1] = newArr[i];
            i--;
        }
        newArr[i + 1] = mValue;
        arr = newArr;
        n++;

        inMang();
    }
}