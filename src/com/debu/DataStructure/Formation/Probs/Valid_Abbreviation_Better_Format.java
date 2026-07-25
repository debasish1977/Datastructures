package com.debu.DataStructure.Formation.Probs;

public class Valid_Abbreviation_Better_Format {
    public boolean isValidAbbreviation(String word,String abbr)
    {
        if(word == null || word.length()==0)
        {
            return false;
        }
        if(abbr == null || abbr.length() ==0)
        {
            return false;
        }
        int i =0;
        int j = 0;
        while(i < word.length() && j < abbr.length())
        {
            if(Character.isLetter(abbr.charAt(j)))
            {
                if(word.charAt(i) != abbr.charAt(j))
                {
                    return false;
                }
                i++;
                j++;
            }
            else
            {
                //Must be a number
                if(abbr.charAt(j)=='0')
                {
                    return false;  //Leading zeros are not allowed
                }
                int num = 0;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j)))
                {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i+=num;
            }

        }

        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args)
    {
        Valid_Abbreviation_Better_Format solution = new Valid_Abbreviation_Better_Format();
        String word = "integer";
        String abbr = "int";
        System.out.println(solution.isValidAbbreviation(word,abbr));
    }
}
