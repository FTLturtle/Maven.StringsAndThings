package io.zipcoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        String lowerCaseString = input.toLowerCase();
        String[] arrayOfWords = lowerCaseString.split("\\W+");
        Integer countEndInYZ = 0;

        for (String s : arrayOfWords){
            if (s.charAt(s.length()-1) == 'y'){
                countEndInYZ++;
            } else if (s.charAt(s.length()-1) == 'z') {
                countEndInYZ++;
            }
        }

        return countEndInYZ;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        return base.replaceAll(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int index = 0;
        int countOfNot = 0;
        int countOfIs = 0;

        while (index != -1){
            index = input.indexOf("is", index);
            if (index != -1){
                countOfIs++;
                index = index + 2;;
            }
        }

        index = 0;

        while (index != -1){
            index = input.indexOf("not", index);
            if (index != -1){
                countOfNot++;
                index = index + 3;
            }
        }

        return countOfIs == countOfNot;
    }


    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        Pattern pattern = Pattern.compile("(?<!g)g(?!g)");
        Matcher matcher = pattern.matcher(input);
        return !matcher.find();
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int startIndex = 0;
        int tripleCount = 0;
        Pattern triplePattern = Pattern.compile("(\\w)\\1{2}"); // () denotes a group, '\w' refers to any word character, '\n' matches whatever was in the nth group, {n} says find the preceding term repeated n times


        Matcher matcher = triplePattern.matcher(input);

        while(matcher.find(startIndex)) {
            tripleCount++;
            startIndex = matcher.start() + 1;
        }

        return tripleCount;
    }
}
