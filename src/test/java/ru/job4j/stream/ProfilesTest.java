package ru.job4j.stream;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenShowSortedListWithoutDuplicates() {
        Address address1 = new Address("Saint-Petersburg", "Vadima Shefnera", 14, 653);
        Address address2 = new Address("Kudrovo", "English street", 3, 15);
        Address address3 = new Address("Saint-Petersburg", "Johna Rida", 2, 242);
        Address address4 = new Address("Pustoshka", "October street", 19, 1);

        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        Profile profile4 = new Profile(address4);

        List<Profile> profile = Arrays.asList(profile1, profile2, profile3, profile4);
        List<Address> rsl = Profiles.collect(profile);
        List<Address> expected = Arrays.asList(address1, address2, address3, address4);
        assertEquals(rsl, expected);
    }
}