package com.debu.DataStructure.Formation.Probs;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ValidAbbreviation {
    public boolean validAbbreviation(String word, String abbrev)
    {
        boolean matches = false;
        if(word == null || word.length()==0)
        {
            return false;
        }

        if(abbrev ==null || abbrev.length() ==0)
        {
            return false;
        }

        HashMap<Character,Integer> elementsMap = new LinkedHashMap<Character,Integer>();
        for(int i=0;i<word.length();i++)
        {
            elementsMap.put(word.charAt(i),elementsMap.getOrDefault(word.charAt(i),0)+ 1);
        }

        for(int i=0;i<abbrev.length();i++)
        {
            if(elementsMap.containsKey(abbrev.charAt(i)))
            {
                matches = true;
            }
            else {
                matches = false;
                break;
            }
        }
        return matches;

    }

    public static void main(String[] args)
    {
        ValidAbbreviation validAbbreviation = new ValidAbbreviation();
        boolean output = validAbbreviation.validAbbreviation("word","wod");
        System.out.println(output);
    }
}
