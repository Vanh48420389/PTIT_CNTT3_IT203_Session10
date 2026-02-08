package btth;

import java.util.Scanner;

public class CreditCard extends PaymentMethod implements Payable {
    private String cardNumber;
    private String cvv;
    private double creditLimit;

    public CreditCard() {
    }

    public CreditCard(String accountName, String paymentId, String cardNumber, String cvv, double creditLimit) {
        super(accountName, paymentId);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
    }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }
    public double getCreditLimit() { return creditLimit; }
    public void setCreditLimit(double creditLimit) { this.creditLimit = creditLimit; }

    @Override
    public void pay(double money) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== THANH TOÁN THẺ TÍN DỤNG ===");
        System.out.print("Nhập mã bảo mật (CVV) để xác nhận: ");
        String inputCvv = sc.nextLine();

        if (money > creditLimit) {
            System.err.println("Giao dịch thất bại: Vượt quá hạn mức tín dụng!");
            return;
        }
        if (inputCvv.equals(this.cvv)) {
            System.out.println("Thanh toán thành công " + money + " VNĐ. Hạn mức còn lại: " + (creditLimit - money));
            this.creditLimit -= money;
        } else {
            System.err.println("Giao dịch thất bại: Mã CVV không đúng!");
        }
    }

    @Override
    public void validate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- NHẬP THÔNG TIN THẺ TÍN DỤNG ---");
        super.setAccountName(inputName(sc));
        super.setPaymentId("CC-" + System.currentTimeMillis());
        this.cardNumber = inputCardNumber(sc);
        this.cvv = inputCVV(sc);
        this.creditLimit = inputCreditLimit(sc);
    }

    public String inputName(Scanner sc) {
        while (true) {
            System.out.print("Nhập tên chủ thẻ: ");
            String name = sc.nextLine();
            if (!name.isBlank()) return name;
            System.err.println("Tên không được bỏ trống!");
        }
    }

    public double inputCreditLimit(Scanner sc) {
        while (true) {
            try {
                System.out.print("Nhập hạn mức tín dụng: ");
                double limit = Double.parseDouble(sc.nextLine());
                if (limit > 0) return limit;
                System.err.println("Hạn mức phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public String inputCardNumber(Scanner sc) {
        while (true) {
            System.out.print("Nhập số thẻ (16 chữ số): ");
            String card = sc.nextLine();
            if (card.matches("\\d{16}")) {
                return card;
            }
            System.err.println("Số thẻ không hợp lệ Phải bao gồm đúng 16 chữ số.");
        }
    }

    public String inputCVV(Scanner sc) {
        while(true){
            System.out.print("Tạo mã CVV (3 chữ số): ");
            String cvv = sc.nextLine();
            if(cvv.matches("\\d{3}")){
                return cvv;
            }
            System.err.println("CVV phải là 3 chữ số.");
        }
    }
}