package hash;

import common.PhoneBook;

import java.util.ArrayList;
import java.util.List;


public class PhoneBookVer1 implements PhoneBook {
    public boolean solution(String[] phone_book) {
        List<String> list = new ArrayList<>();
        for(String a: phone_book){
            for(String l: list){
                if(l.startsWith(a) || a.startsWith(l)){
                    return false;
                }
            }
            list.add(a);
        }
        return true;
    }
}
