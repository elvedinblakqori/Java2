void main() {
    System.out.println("Sistemi i Parkingut");

    System.out.print("Automjeti (M = motor, A = auto, K = kamion, E = elektrik): ");
    String automjeti = IO.readln().trim().toUpperCase();

    System.out.print("Sa orë? ");
    int ore = Integer.parseInt(IO.readln().trim());

    System.out.print("Fundjavë? (po/jo) ");
    String fundjave = IO.readln().trim().toUpperCase();

    // Kontrollimi i inputeve
    if (!automjeti.equals("M") && !automjeti.equals("A")
            && !automjeti.equals("K") && !automjeti.equals("E")) {

        System.out.println("Lloji i automjetit nuk eshte i sakte!");

    } else if (ore < 1 || ore > 24) {

        System.out.println("Numri i oreve nuk eshte i sakte!");

    } else if (!fundjave.equals("PO") && !fundjave.equals("JO")) {

        System.out.println("Pergjigjja per fundjaven nuk eshte e sakte!");

    } else {

        // Percaktimi i tarifes sipas automjetit
        var tarifa = switch (automjeti) {
            case "M" -> 0.50;
            case "A" -> 1.00;
            case "K" -> 2.00;
            case "E" -> 0.80;
            default -> 0.0;
        };

        double pagesa;

        // If brenda if-it
        if (ore > 0) {
            if (ore >= 8) {
                pagesa = 10.00;
            } else {
                pagesa = tarifa * ore;
            }
        } else {
            pagesa = 0.0;
        }

        // Operatori boolean
        boolean cmimiDitor = ore >= 8;

        // Operatori ternar
        String mesazhi = cmimiDitor
                ? "Cmimi ditor u aplikua."
                : "";

        if (cmimiDitor) {
            System.out.println(mesazhi);
        }

        // Shfaqja e pageses me dy shifra pas presjes
        System.out.printf(java.util.Locale.GERMANY,
                "Për të paguar: %.2f €%n", pagesa);
    }
}
