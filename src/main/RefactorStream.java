package main;

import model.Customer;
import model.Invoice;

import java.util.*;
import java.util.stream.Collectors;

public class RefactorStream {
    public static void main(String[] args) {
        // Before Refactor
        List<Invoice> invoices = initInvoice();
        List<Invoice> oracleAndTrainingInvoices = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        List<Integer> firstFiveIds = new ArrayList<>();

        for(Invoice inv : invoices) {
            if(inv.getCustomer() == Customer.ORACLE) {
                if(inv.getTitle().contains("Training")) {
                    oracleAndTrainingInvoices.add(inv);
                }
            }
        }
        System.out.println(oracleAndTrainingInvoices.toString());

        Collections.sort(oracleAndTrainingInvoices, new Comparator<Invoice>() {
            @Override
            public int compare(Invoice inv1, Invoice inv2) {
                return Double.compare(inv1.getAmount(), inv2.getAmount());
            }
        });
        System.out.println(oracleAndTrainingInvoices);

        for(Invoice inv : oracleAndTrainingInvoices) {
            ids.add(inv.getId());
        }
        System.out.println(ids.toString());

        for (int i = 0; i < 5; i++) {
            firstFiveIds.add(ids.get(i));
        }
        System.out.println(firstFiveIds.toString());

        // After Stream Refactor
        List<Invoice> invoicesStream = initInvoice();
        List<Invoice> oracleAndTrainingInvoicesStream = new ArrayList<>();
        List<Integer> idsStream = new ArrayList<>();
        List<Integer> firstFiveIdsStream = new ArrayList<>();

        invoicesStream.stream()
                .filter(invoice -> invoice.getCustomer() == Customer.ORACLE)
                .filter(invoice -> invoice.getTitle().contains("Training"))
                .forEach(oracleAndTrainingInvoicesStream::add);
        System.out.println(oracleAndTrainingInvoicesStream.toString());

        oracleAndTrainingInvoicesStream = oracleAndTrainingInvoicesStream.stream()
                .sorted((inv1, inv2) -> Double.compare(inv1.getAmount(), inv2.getAmount()))
                .collect(Collectors.toList());
        System.out.println(oracleAndTrainingInvoicesStream.toString());

        oracleAndTrainingInvoicesStream.stream()
                .map(invoice -> invoice.getId())
                .forEach(idsStream::add);
        System.out.println(idsStream.toString());

        ids.stream()
                .limit(5)
                .forEach(firstFiveIdsStream::add);
        System.out.println(firstFiveIdsStream.toString());
    }

    public static List<Invoice> initInvoice() {
        return Arrays.asList(
                new Invoice(1, Customer.ORACLE, "Training", 100),
                new Invoice(2, Customer.FACEBOOK, "Training", 200),
                new Invoice(3, Customer.MICROSOFT, "Training", 300),
                new Invoice(4, Customer.ORACLE, "Training", 130),
                new Invoice(5, Customer.ORACLE, "Training", 170),
                new Invoice(6, Customer.ORACLE, "Training", 150),
                new Invoice(7, Customer.ORACLE, "Training", 120),
                new Invoice(8, Customer.ORACLE, "Training", 185)
        );
    }
}
