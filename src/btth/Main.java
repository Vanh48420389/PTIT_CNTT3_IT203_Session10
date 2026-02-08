package btth;

public class Main {
    public static void main(String[] args) {
        CreditCard myCard = new CreditCard();
        myCard.validate();
        myCard.pay(500000);

        EWallet myWallet = new EWallet();
        myWallet.validate();
        myWallet.pay(200000);

        System.out.println("\n--- THANH TOÁN BẰNG ĐIỂM THƯỞNG (ANONYMOUS CLASS) ---");

        Payable rewardPointsPayment = new Payable() {
            private final double EXCHANGE_RATE = 1000;

            @Override
            public void pay(double money) {
                double pointsNeeded = money / EXCHANGE_RATE;
                System.out.println("Đang xử lý thanh toán bằng điểm thưởng...");
                System.out.println("Số tiền cần thanh toán: " + money + " VNĐ");
                System.out.println("Số điểm bị trừ: " + pointsNeeded + " điểm");
                System.out.println("=> Giao dịch đổi điểm thành công!");
            }
        };

        rewardPointsPayment.pay(150000);
    }
}