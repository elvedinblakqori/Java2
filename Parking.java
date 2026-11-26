void main() {
    System.out.println("Sistemi i Parkingut");
    System.out.print("Automjeti (M = motor, A = auto, K = kamion): ");
    String automjeti = IO.readln().trim().toUpperCase();
    System.out.print("Sa orë? ");
    int ore = Integer.parseInt(IO.readln().trim());
    System.out.print("Fundjavë? (po/jo) ");
    String fundjave = IO.readln().trim().toUpperCase();
    if (!automjeti.equals("M") && !automjeti.equals("A")
            && !automjeti.equals("K")) {
        System.out.println("Lloji i automjetit nuk eshte i sakte!");
    } else if (ore < 1 || ore > 24) {
        System.out.println("Numri i oreve nuk eshte i sakte!");
    } else if (!fundjave.equals("PO") && !fundjave.equals("JO")) {
        System.out.println("Pergjigjja per fundjaven nuk eshte e sakte!");
    } else {
        var tarifa = switch (automjeti) {
            case "M" -> 0.50;
            case "A" -> 1.00;
            case "K" -> 2.00;
            default -> 0.0;
        };
        double pagesa;
        if (ore > 0) {
            if (ore >= 8) {
                pagesa = 10.00;
            } else {
                pagesa = tarifa * ore;
            }
        } else {
            pagesa = 0.0;
        }
        boolean cmimiDitor = ore >= 8;
        String mesazhi = cmimiDitor
                ? "Çmimi ditor u aplikua."
                : "";
        if (cmimiDitor) {
            System.out.println(mesazhi);
        }
        System.out.printf("Për të paguar: %.2f €%n", pagesa);
    }
}