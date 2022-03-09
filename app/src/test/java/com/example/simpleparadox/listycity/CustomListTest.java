package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize =  list.getCount();
        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(listSize + 1, list.getCount());
    }

    @Test
    public void hasCityTest() {
        City edmonton = new City("Edmonton","Alberta");
        list.addCity(edmonton);
        assertTrue(list.hasCity(edmonton));

    }

    @Test
    public void deleteCityTest() {
        City edmonton = new City("Edmonton", "Alberta");

        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(edmonton);
        });

        list.addCity(edmonton);
        list.deleteCity(edmonton);

        assertFalse(list.hasCity(edmonton));

    }

    @Test
    public void countCityTest() {
        assertEquals(0, list.getCount());
        City edmonton = new City("Edmonton", "Alberta");
        City vancouver = new City("Vancouver", "British Columbia");
        list.addCity(edmonton);
        assertEquals(1, list.getCount());
        list.addCity(vancouver);
        assertEquals(2,list.getCount());

    }
}
