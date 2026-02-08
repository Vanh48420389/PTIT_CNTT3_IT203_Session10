package btth;

import java.util.Scanner;

public class EWallet extends PaymentMethod implements Payable {
    private String phoneNumber;
    private double balance;

    public EWallet() {
    }

    public EWallet(String accountName, String paymentId, String phoneNumber, double balance) {
        super(accountName, paymentId);
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public void pay(double money) {
        System.out.println("=== THANH TOÁN VÍ ĐIỆN TỬ ===");
        if (money < 0) {
            System.err.println("Số tiền thanh toán không hợp lệ");
            return;
        }
        if (balance - money < 0) {
            System.err.println("Giao dịch thất bại: Không đủ số dư!");
            return;
        }

        this.balance -= money;
        System.out.println("Thanh toán thành công " + money + " VNĐ. Số dư mới: " + this.balance);
    }

    @Override
    public void validate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- NHẬP THÔNG TIN VÍ ĐIỆN TỬ ---");
        super.setAccountName(inputName(sc));
        super.setPaymentId("EW-" + System.currentTimeMillis());
        this.phoneNumber = inputPhoneNumber(sc);
        this.balance = inputBalance(sc);
    }

    public double inputBalance(Scanner sc) {
        while (true) {
            try {
                System.out.print("Nhập số dư ban đầu: ");
                double bal = Double.parseDouble(sc.nextLine());
                if (bal >= 0) return bal;
                System.err.println("Số dư không thể âm!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!");
            }
        }
    }

    public String inputPhoneNumber(Scanner sc) {
        while (true) {
            System.out.print("Nhập số điện thoại (10 số, bắt đầu bằng 0): ");
            String phone = sc.nextLine();
            if (phone.matches("^0\\d{9}$")) {
                return phone;
            }
            System.err.println("Số điện thoại không đúng định dạng VN!");
        }
    }

    public String inputName(Scanner sc) {
        while (true) {
            System.out.print("Nhập tên chủ ví: ");
            String name = sc.nextLine();
            if (!name.isBlank()) return name;
            System.err.println("Không được bỏ trống tên!");
        }
    }
}