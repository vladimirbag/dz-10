package org.example;

import org.example.exceptions.WrongAccountException;
import org.example.exceptions.WrongCurrencyException;
import org.example.exceptions.WrongOperationException;

public class Main {
    public static void main(String[] args) {
        BankApplication bankApp = new BankApplication();

        processWrapper(bankApp, "accountId000", 50, "USD");
        processWrapper(bankApp, "accountId003", 250, "HRV");
        processWrapper(bankApp, "accountId001", 50, "EUR");
        processWrapper(bankApp, "accountId001", 50, "USD");
        processWrapper(bankApp, "accountId001", 2000, "USD");
    }

    public static void processWrapper(BankApplication bankApp, String id, int amount, String currency) {
        try {
            bankApp.process(id, amount, currency);
        } catch (WrongAccountException e) {
            System.out.println("Такого акаунту не існує");
        } catch (WrongCurrencyException e) {
            System.out.println("Акаунт має рахунок в іншій валюті");
        } catch (WrongOperationException e) {
            System.out.println("Акаунт не має достатньо коштів");
        } catch (Exception e) {
            System.out.println("Сталася помилка при процесінгу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
        }
    }
}
