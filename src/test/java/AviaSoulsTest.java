import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 5_000, 9, 10);
    Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 6_000, 12, 14);
    Ticket ticket3 = new Ticket("Москва", "Санкт-Петербург", 10_000, 15, 18);
    Ticket ticket4 = new Ticket("Москва", "Санкт-Петербург", 20_000, 8, 12);
    Ticket ticket5 = new Ticket("Москва", "Санкт-Петербург", 20_000, 13, 17);
    Ticket ticket6 = new Ticket("Москва", "Милан", 30_000, 13, 17);

    @Test
    public void priceNegative() {

        int expended = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expended, actual);
    }

    @Test
    public void pricePositive() {

        int expended = 1;
        int actual = ticket3.compareTo(ticket2);

        Assertions.assertEquals(expended, actual);
    }

    @Test
    public void priceEqual() {

        int expended = 0;
        int actual = ticket4.compareTo(ticket5);

        Assertions.assertEquals(expended, actual);

    }

    @Test
    public void searchTest() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = aviaSouls.search("Москва", "Санкт-Петербург");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void flightTimeNegative() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expended = -1;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expended, actual);
    }


    @Test
    public void flightTimePositive() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expended = 1;
        int actual = timeComparator.compare(ticket3, ticket2);

        Assertions.assertEquals(expended, actual);
    }


    @Test
    public void flightTimeEqual() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expended = 0;
        int actual = timeComparator.compare(ticket4, ticket5);

        Assertions.assertEquals(expended, actual);
    }

    @Test
    public void searchAndSortByTest() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Санкт-Петербург", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchForMultipleTickets() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = aviaSouls.search("Москва", "Санкт-Петербург");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForOneTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket6};
        Ticket[] actual = aviaSouls.search("Москва", "Милан");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notInTheSearch() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Assertions.assertArrayEquals(new Ticket[]{}, aviaSouls.search("Москва", "Лондон"));
    }

}

