package com.javiezcobar;

import com.javiezcobar.domain.*;
import com.javiezcobar.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final LoanRepository loanRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public DataInitializer(ClientRepository clientRepository, AddressRepository addressRepository, LoanRepository loanRepository, TransactionRepository transactionRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.loanRepository = loanRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
/*
        // Crear instancias de Client y Address
        Client client = new Client();

        // Asignar la dirección, nombre y telefono al cliente
        client.getAddress().setAddress("123 Street", "Apt 4B", "Next to Park", "City", "12345");
        client.setName("John Doe");
        client.setTelephone("123456789");
        client.creditLoan(50000, "S");

        // Crear instancia de un ingreso y un egreso
        Transaction t1 = new Transaction(LocalDate.now(),2500,true, "pago de un diseño");
        Transaction t2 = new Transaction(LocalDate.now(),3500,false, "compra en el chino");

        // Guardar el cliente y las transacciones
        clientRepository.save(client);
        transactionRepository.save(t1);
        transactionRepository.save(t2);
*/
        // Consultar los datos guardados
        System.out.println("Clientes en la base de datos:");
        for (Client c : clientRepository.findAll()) {
            System.out.println("id: "+ c.getId() +", nombre: "+ c.getName());
        }

        System.out.println("Direcciones en la base de datos:");
        for (Address a : addressRepository.findAll()) {
            System.out.println("id: "+ a.getId()+", calle: "+a.getStreet()+", numero: "+a.getNumber());
        }

        System.out.println("Creditos en la base de datos:");
        for (Loan l : loanRepository.findAll()){
            System.out.println("id: "+l.getId()+", valor: "+l.getAmount()+", # cuotas: "+ l.getInstallments().length);
        }

        if (clientRepository.findById(1L).isPresent()) {
            Client c = clientRepository.findById(1L).get();
            System.out.println("Creditos de " + c.getName());
            for (Loan l : c.getLoans()) {
                System.out.println("id: "+l.getId()+", valor: "+l.getAmount()+", # cuotas: "+ l.getInstallments().length);
            }
            System.out.println("cuotas del credito con id: " + c.getLoanById(1).getId() + " buscado en el cliente: " + c.getName());
            for (Installment i : c.getLoanById(1).getInstallments()) {
                System.out.println("id: "+ i.getId() +", #cuota: "+i.getNumber()+", fecha: "+i.getDate()+", valor: "+i.getAmount());
            }
        } else {
            System.out.println("No se encontro un cliente en el id: 1");
        }

        System.out.println("Transacciones en la base de datos:");
        List<Transaction> transactions = transactionRepository.findAll();
        for (Transaction transaction : transactions) {
            if (transaction instanceof Installment i) {
                System.out.println("id: "+ i.getId() +", #cuota: "+i.getNumber()+", fecha: "+i.getDate()+", valor: "+i.getAmount());
            } else {
                System.out.println("id: "+ transaction.getId() +", fecha: "+transaction.getDate()+", valor: "+transaction.getAmount());
            }
        }
    }
}