package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)) {
            List<String> newNum = phonebook.get(name);
            newNum.add(phoneNumber);
            phonebook.replace(name, newNum);
        } else {
            this.phonebook.put(name, Collections.singletonList(phoneNumber));

        }
    }
    public void addAll(String name, String... phoneNumbers) {
        if(phonebook.containsKey(name)){
            List<String> newNumbers = phonebook.get(name);
            newNumbers.addAll(Arrays.asList(phoneNumbers));
            phonebook.replace(name, newNumbers);
        }else{
            this.phonebook.put(name, Arrays.asList(phoneNumbers));
        }

    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        //To see if the phonebook as a name

        if(phonebook.containsKey(name)){
            return phonebook.get(name);
        }else{
            return null;
        }
    }


    public String reverseLookup(String phoneNumber) {
        String wantedName = "";
        Set<String> allNums = phonebook.keySet();
        for (String i : allNums) {
            List<String> nums =  phonebook.get(i);
            if (nums.contains(phoneNumber)) {
                wantedName = i;

            } else {
                return "";
            }
        }
            return wantedName;
        }


    public List<String> getAllContactNames() {
        ArrayList<String> ContactList = new ArrayList<>();

        for(String key: phonebook.keySet()){
            ContactList.add(key);
        }
        return ContactList;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
