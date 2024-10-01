package homework;

import java.util.Arrays;
import java.util.List;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

/*        toFindTransactionsAndSort(transactions);*/

/*        printCityDistinct(transactions);*/

/*        toFindTradersAndSort(transactions);*/

/*        System.out.println(toReturnStringWithAllTheTraders(transactions));*/

/*        System.out.println(traderFromMilan(transactions));*/

/*        printTransactionsOfTradersFromCamp(transactions);*/

/*        System.out.println(maxSum(transactions));*/

/*        System.out.println(minSum(transactions));*/
    }

    /* 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
            к большей).
    */

    public static void toFindTransactionsAndSort(List<Transaction> transactions) {
        transactions
                .stream()
                .filter( transaction -> transaction.getYear() == 2011 )
                .sorted( (trans1, trans2) -> trans1.getValue() - trans2.getValue() )
                .forEach(System.out::println);
    }

/*    2. Вывести список неповторяющихся городов, в которых работают трейдеры.*/

    public static void printCityDistinct(List<Transaction> transactions) {
        transactions
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct().forEach(System.out::println);
    }

/*    3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.*/

    public static void toFindTradersAndSort(List<Transaction> transactions) {
        transactions
                .stream()
                .map(Transaction::getTrader)
                .filter( trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted( (trader1, trader2) -> trader1.getName().compareTo(trader2.getName()) )
                .forEach(System.out::println);
    }

/*    4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
    порядке.*/

    public static String toReturnStringWithAllTheTraders(List<Transaction> transactions) {
        List<String> names = transactions
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .toList();

        return names.toString();
    }

/*    5. Выяснить, существует ли хоть один трейдер из Милана.*/

    public static boolean traderFromMilan(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(Transaction::getTrader)
                .anyMatch( trader -> trader.getCity().equals("Milan"));
    }

/* 6. Вывести суммы всех транзакций трейдеров из Кембриджа.*/

    public static void printTransactionsOfTradersFromCamp(List<Transaction> transactions) {
        transactions
                .stream()
                .filter( transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

/*    7. Какова максимальная сумма среди всех транзакций?*/

    public static int maxSum(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(Transaction::getValue)
                .max( (value1, value2) -> value1 - value2 )
                .get();
    }

/*    8. Найти транзакцию с минимальной суммой.*/

    public static int minSum(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(Transaction::getValue)
                .min( (obj1, obj2) -> obj1 - obj2 )
                .get();
    }
}