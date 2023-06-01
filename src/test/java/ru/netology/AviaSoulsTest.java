package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class AviaSoulsTest {
    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "DXB", 30_000, 9, 14);
        Ticket ticket2 = new Ticket("MSK", "PRG", 20_000, 10, 17); // 2
        Ticket ticket3 = new Ticket("MSK", "PRG", 35_000, 10, 16); // 3
        Ticket ticket4 = new Ticket("MSK", "CMB", 60_000, 9, 23);
        Ticket ticket5 = new Ticket("MSK", "MLE", 70_000, 9, 12);
        Ticket ticket6 = new Ticket("MSK", "PRG", 40_000, 14, 17); // 5
        Ticket ticket7 = new Ticket("MSK", "BCN", 40_000, 15, 19);
        Ticket ticket8 = new Ticket("MSK", "PRG", 39_000, 16, 20); // 4
        Ticket ticket9 = new Ticket("MSK", "DPS", 50_000, 12, 23);
        Ticket ticket10 = new Ticket("MSK", "PRG", 15_000, 18, 20); // 1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket10, ticket2, ticket3, ticket8, ticket6};
        Ticket[] actual = manager.search("MSK", "PRG");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTickets1() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "DXB", 30_000, 9, 14);
        Ticket ticket2 = new Ticket("MSK", "PRG", 20_000, 10, 17);
        Ticket ticket3 = new Ticket("MSK", "PRG", 35_000, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "CMB", 60_000, 9, 23);
        Ticket ticket5 = new Ticket("MSK", "MLE", 70_000, 9, 12);
        Ticket ticket6 = new Ticket("MSK", "PRG", 40_000, 14, 17);
        Ticket ticket7 = new Ticket("MSK", "BCN", 40_000, 15, 19);
        Ticket ticket8 = new Ticket("MSK", "PRG", 39_000, 16, 20);
        Ticket ticket9 = new Ticket("MSK", "DPS", 50_000, 12, 23);
        Ticket ticket10 = new Ticket("MSK", "PRG", 15_000, 18, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket9};
        Ticket[] actual = manager.search("MSK", "DPS");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWhenNotFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "DXB", 30_000, 9, 14);
        Ticket ticket2 = new Ticket("MSK", "PRG", 20_000, 10, 17);
        Ticket ticket3 = new Ticket("MSK", "PRG", 35_000, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "CMB", 60_000, 9, 23);
        Ticket ticket5 = new Ticket("MSK", "MLE", 70_000, 9, 12);
        Ticket ticket6 = new Ticket("MSK", "PRG", 40_000, 14, 17);
        Ticket ticket7 = new Ticket("MSK", "BCN", 40_000, 15, 19);
        Ticket ticket8 = new Ticket("MSK", "PRG", 39_000, 16, 20);
        Ticket ticket9 = new Ticket("MSK", "DPS", 50_000, 12, 23);
        Ticket ticket10 = new Ticket("MSK", "PRG", 15_000, 18, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "MIL");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "DXB", 30_000, 9, 14);
        Ticket ticket2 = new Ticket("MSK", "PRG", 20_000, 10, 17); // 7 часов
        Ticket ticket3 = new Ticket("MSK", "PRG", 35_000, 10, 16); // 6 часов
        Ticket ticket4 = new Ticket("MSK", "CMB", 60_000, 9, 23);
        Ticket ticket5 = new Ticket("MSK", "MLE", 70_000, 9, 12);
        Ticket ticket6 = new Ticket("MSK", "PRG", 40_000, 14, 17); // 3 часов
        Ticket ticket7 = new Ticket("MSK", "BCN", 40_000, 15, 19);
        Ticket ticket8 = new Ticket("MSK", "PRG", 39_000, 16, 20); // 4 часов
        Ticket ticket9 = new Ticket("MSK", "DPS", 50_000, 12, 23);
        Ticket ticket10 = new Ticket("MSK", "PRG", 15_000, 18, 20); // 2 часов
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket10, ticket6, ticket8, ticket3, ticket2};
        Ticket[] actual = manager.search("MSK", "PRG", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator1() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "DXB", 30_000, 9, 14);
        Ticket ticket2 = new Ticket("MSK", "PRG", 20_000, 10, 17);
        Ticket ticket3 = new Ticket("MSK", "PRG", 35_000, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "CMB", 60_000, 9, 23);
        Ticket ticket5 = new Ticket("MSK", "MLE", 70_000, 9, 12);
        Ticket ticket6 = new Ticket("MSK", "PRG", 40_000, 14, 17);
        Ticket ticket7 = new Ticket("MSK", "BCN", 40_000, 15, 19);
        Ticket ticket8 = new Ticket("MSK", "PRG", 39_000, 16, 20);
        Ticket ticket9 = new Ticket("MSK", "DPS", 50_000, 12, 23);
        Ticket ticket10 = new Ticket("MSK", "PRG", 15_000, 18, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("MSK", "MLE", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorWhenNotFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "DXB", 30_000, 9, 14);
        Ticket ticket2 = new Ticket("MSK", "PRG", 20_000, 10, 17);
        Ticket ticket3 = new Ticket("MSK", "PRG", 35_000, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "CMB", 60_000, 9, 23);
        Ticket ticket5 = new Ticket("MSK", "MLE", 70_000, 9, 12);
        Ticket ticket6 = new Ticket("MSK", "PRG", 40_000, 14, 17);
        Ticket ticket7 = new Ticket("MSK", "BCN", 40_000, 15, 19);
        Ticket ticket8 = new Ticket("MSK", "PRG", 39_000, 16, 20);
        Ticket ticket9 = new Ticket("MSK", "DPS", 50_000, 12, 23);
        Ticket ticket10 = new Ticket("MSK", "PRG", 15_000, 18, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "SAB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}