package com.company;
import java.util.*;

public class ChemicalLocha {
    public static void main(String[] args) {
        String[] elements = { "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl",
                "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr",
                "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs",
                "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W",
                "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np",
                "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg",
                "Cn", "Uut", "Uuq", "Uup", "Uuh", "Uus", "Uuo", " " };
        String input; //will take input as 'y' or 'n' to continue program in a loop till user doesn't want to continue and says 'n'
        Scanner myScanner = new Scanner(System.in);
        try{
            punctuateWord(elements); //function call to pass argument elements[] array from main() to punctuateWord()

        } catch(Exception e){
            do{
                System.out.println("\n \n Oops!! This is embarrassing. The app crashed. Looks like I'm not as good as I thought I was :( \n\n Try Again?(y/n) ");System.out.println(e);
                input = myScanner.next();
                if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes"))
                    punctuateWord(elements);
                else break;
            }while(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Yes"));
        }
    }

    public static void punctuateWord(String[] elements){
        Scanner myScanner = new Scanner(System.in);
        // String word takes in the word from user to process, String userInput takes 'y' or 'n' to continue running the program in a loop
        String word, userInput;
        // start of nested do-while loop which will run until user inputs 'n' or 'no'(case insensitive)
        top:
        do{
            System.out.print(" Enter a word: ");
            word = myScanner.nextLine();

            /* function call to pass String word and String[] elements from punctuateWord() to respell(). respell() wll process
             the word and return the respelled word into String newWord or will return "Cannot be spelled" if it cannot be spelled */
            String newWord = respell(word,elements);

            System.out.println("\n newWord: " + newWord);

            // this second nested do-while will keep running and asking "Try Again" if user provides an invalid input
            do{System.out.print("\n Try Again? (y/n): ");
                userInput = myScanner.nextLine();
                if(userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("no")){
                    System.out.println("\n Thanks! Until next time, Ciao!!");
                    break;
                }
                else if(userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes"))
                    continue top;
                else { System.out.println(" Invalid Input");
                }
            }while(!userInput.equalsIgnoreCase("n") && !userInput.equalsIgnoreCase("no") && !userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("yes"));

        }while(userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes"));
    }





    public static String respell(String word, String[] elements){

        boolean canBeSpelled=false; //ill use it to store true/false corresponding to whether word can be spelled or not
        String newWord = word; //newWord is a copy of word to make spelling changes to it. It will contain the final respelled word.

        /* Creating three lists to sort and store chemical elements from elements[] array into three groups of one lettered elements,
        two lettered elements and three lettered elements
         Lists are like arrays, the difference is that arrays have fixed length and list can expand or shrink if we add or remove an entry
         */

        ArrayList<String> threeWordElements, twoWordElements, oneWordElements;
        threeWordElements = new ArrayList<>();
        twoWordElements = new  ArrayList<>();
        oneWordElements = new ArrayList<>();

        /* Creating three list which will store the start index, endIndex and the position of matched phrase in elements[] array
        for example: if the word is 'conference', then if the phrase 'fe' matches the element[] = "Fe", the index of 'f' in the word
        'conference'(where index starts with 0(first letter 'c') is 3(startIndex) and index of 'e' is 4(endIndex). and "Fe" is stored at
        position 25 in elements[] array(elements[25] = "Fe". So when I call the 0 element of all three lists then I get 3,4,25. This is
        how I will keep track of which part of the input word is matched with which element.
         */
        ArrayList<Integer> startIndex, endIndex, matchedElementPosition;
        startIndex = new ArrayList<>();
        endIndex = new ArrayList<>();
        matchedElementPosition = new ArrayList<>();

        ArrayList<String> letterElementsString;
        letterElementsString = new ArrayList<>();



        /* sorting elements in elements array based on number of letters. If the element is one lettered I add it to the oneWordElements
        list, if the element is two lettered then I add it to twoWordElements list and same for three lettered elements.

        NOTE: The process to add values to array is anyExampleArray[n] = "whatever value";
        whereas the process to add values to a list is: anyExampleList.add("whatever value");
        you dont have to provide index number 'n', the list keeps appending to the last value it has
         */
        for(int l = 0;l < elements.length; l++ ){
            if(elements[l].length() == 1) {
                oneWordElements.add(elements[l]);
            }   else if(elements[l].length() == 2) {
                twoWordElements.add(elements[l]);
            }  else { threeWordElements.add(elements[l]);
            }
        }


        /*   FINDING ALPHABETS IN WORD THAT MATCH WITH ONE LETTERED ELEMENTS IN ELEMENTS[] ARRAY

        NOTE: The process to get a value at index n from an int array[] is: int nIndexValue = anyExampleArray[n];
        whereas the process to get a value at index n from an int list is: int nIndexValue = anyExampleList.get(n);

        I have also used functions of String class here mentioned below.
        1. equalsIgnoreCase(String): This function compares two strings ignoring case of the strings.
            so "EXAMPLE".equalsIgnoreCase("example") is TRUE
            Syntax: anyExampleList.get(n).equalsIgnoreCase("Another String");
        2. substring(int, int): If we provide two integers to substring function then these integers act as startIndex and endIndex. Which
            lets me extract a part of the word and use it. Index starts with 0.
            For example if my word is: String word = "phone";
            then String partOfWord = word.substring(0,3); = "pho". It includes 'p' at index 0 and excludes 'n' at index 3 and extracts "pho"
            from "phone".
            We have to keep that in mind. It extracts a part of the word which includes startIndex and excludes endIndex.

        I will run two for loops which will extract substrings(i,j)(where 0<i<word.Length() and 1<j<word.length() from the user input word
         and compare it with all the one lettered elements from the list oneWordElements.get(m)(where m goes from 0 to size
         of the list found by oneWordElements.size().
         If it finds a match it will store the startIndex, endIndex and matchedElementPosition
         of the extracted substring.
         For Example: if the input word is "cloud". then the for loop will take "cloud".substring(0,1) which is 'c'(not 'cl' because
         substring excludes end index) and compare it with all the one lettered elements from the list oneWordElements.get(m)(where m goes
         from 0 to size of the list).
         When it finds a match 'c' to 'C' then I will find the position of 'C' in the original elements[] array and store values as below:
         startIndex.add(0);
         endIndex.add(0);
         matchedElementsPosition.add(5);
         */

        //One lettered
        for(int i = 0, j = i + 1; i < word.length(); i++, j++){
            for(int m = 0; m < oneWordElements.size(); m++) {
                if (oneWordElements.get(m).equalsIgnoreCase(word.substring(i,j))) {
                    startIndex.add(i);
                    endIndex.add(j-1);
                    matchedElementPosition.add(getElementPosition(oneWordElements.get(m),elements));
                    letterElementsString.add(elements[getElementPosition(oneWordElements.get(m),elements)]);
                    break;
                }else if(oneWordElements.get(m).equals(32)){// if the user inputs two or more words with spaces(ASCII 32) Then store that space as well
                    startIndex.add(i);
                    endIndex.add(j-1);
                    matchedElementPosition.add(elements.length - 1);
                }
            }
        }

        //    finding alphabets in word that match with two lettered elements in elements[] array
        for(int i = 0, j = i + 2; i < word.length() - 1; i++, j++){
            for(int m = 0; m < twoWordElements.size(); m++) {
                if (twoWordElements.get(m).equalsIgnoreCase(word.substring(i,j))) {
                    startIndex.add(i);
                    endIndex.add(j-1);
                    matchedElementPosition.add(getElementPosition(twoWordElements.get(m),elements));
                    letterElementsString.add(elements[getElementPosition(twoWordElements.get(m),elements)]);
                    break;
                }
            }
        }

        //    finding alphabets in word that match with three lettered elements in elements array
        for(int i = 0, j = i + 3; i < word.length() - 2; i++, j++){
            for(int m = 0; m < threeWordElements.size(); m++) {
                if (threeWordElements.get(m).equalsIgnoreCase(word.substring(i,j))) {
                    startIndex.add(i);
                    endIndex.add(j-1);
                    matchedElementPosition.add(getElementPosition(threeWordElements.get(m),elements));
                    letterElementsString.add(elements[getElementPosition(threeWordElements.get(m),elements)]);
                    break;
                }
            }
        }




        /* Printing startIndex and endIndex on screen for better understanding of the algorithm
            These are paired vertically. which means first value of startIndex List is paired with first value of endIndex
         */

        System.out.println("\n Start Index:                                         " + startIndex);
        System.out.println("\n End Index:                                           " + endIndex);

        // Printing matched substring words from String word
        System.out.print("\n Matched element words in " + word + ":                  ");
        for(int i = 0; i < startIndex.size(); i++){
            System.out.print(word.substring(startIndex.get(i),endIndex.get(i) + 1) + " ");
        }

        // Printing corresponding element abbreviations to matched substring words from String word
        System.out.print("\n\n Corresponding Element Abbreviations to matched word: ");
        for(int i = 0; i < matchedElementPosition.size(); i++)
            System.out.print(elements[matchedElementPosition.get(i)] + " ");

        // Printing matched positions
        System.out.println("\n\n Matched ElementsIndex In Elements Array:             " + matchedElementPosition);

        /*calling checkIfWordCanBeSpelled() function which returns true of false to boolean canBeSpelled. To check if the word can be
        spelled I need to send the word, startIndex and endIndex from respell() to checkIfWordCanBeSpelled(). More info on the algorithm
        in the function body.
         */
        canBeSpelled = checkIfWordCanBeSpelled(word, startIndex, endIndex);

        /* if the word can be spelled then the following algorithm will extract values from startIndex, endIndex and matcheeElementPosition
        the algorithm will:
        1. First replace all the one lettered elements in the word. for example if the word is word = newWord = "canvases" then after the
            replacement algo newWord = CaNVaSeS
        2. Next it will start replacing and overwriting all two lettered elements. so in newWord = "CaNVaSeS' after the algo the chages made
            are "CaNVAsEs".
        3. Replace and overwrite all three lettered elements.
         */
        if(canBeSpelled)
        { for (int i = 0,j = 0, k = 0; i < startIndex.size(); i++) {
            newWord = newWord.replaceFirst(newWord.substring(startIndex.get(i), endIndex.get(i) + 1), elements[matchedElementPosition.get(i)]);
            if(i < startIndex.size() - 1)
                if(endIndex.get(i) == startIndex.get(i+1) && j == 0){
                    j = 1;
                    i++;
                    continue;
                }else j = 0;
            if(i<(startIndex.size() - 2) && k == 0){
                if((endIndex.get(i) == startIndex.get(i + 2)) && (letterElementsString.get(i).length() == 3)){
                    k = 1;
                    i++;
                } else k = 0;
            }
          }
          return newWord;

        } else newWord = "Cannot be spelled";

        return newWord;
    }


    private static int getElementPosition(String elementName, String[] elements){
        int i;
        for(i = 0; i < elements.length; i++) {
            if (elements[i].equalsIgnoreCase(elementName)) {
                return i;
            }
        }
        return i;
    }

    public static boolean checkIfWordCanBeSpelled(String word, List startIndex, List endIndex){
        boolean canBeSpelled = false;
        /* This section contains the algorithm to check if the word can be spelled using the periodic table elements or not.
            We stored the startIndexes and the endIndexes of all the replaceable sections of the input word. So if the input word
            can really and completely be spelled then the startIndex and endIndex lists combined will have all the index numbers from
            0 to the length of the word-1.
            For example if the word is "access". Then the startIndex list of this word will be: [1, 2, 4, 5, 0, 2, 3]
            endIndex will be: [1, 2, 4, 5, 1, 3, 4]
            if we combine the two list somehow, remove the duplicates and sort them in increasing order the new list should look like:
            [0, 1, 2, 3, 4, 5]. The length of the word "access" is 6 which is the same as the length of the combined list.

            To remove the dublicates we will use something called Hash Sets. Hash Sets are similar to Lists and all the operation that
            can be done on Lists can also be done on Hash Sets except that when we store something in a hash set then it automatically
            removes all duplicates from the entries
         */

        ArrayList<Integer> sortIndexes = new ArrayList<>(); //Creating new list sortIndexes to combine and store startIndex and endIndex
        Set<Integer> removeDuplicates = new HashSet<>(); /* Creating new hash set of integer type to copy info from combined list
        sortIndexes into removeDuplicates hash set, so it removes duplicates */
        sortIndexes.addAll(endIndex); //copying list endIndex to list sortIndexes
        sortIndexes.addAll(startIndex); //adding data from startIndex to list sortIndexes. Hence combining both lists startIndex and endIndex
        removeDuplicates.addAll(sortIndexes); //copying data from list sortIndexes to Hash Set removeDuplicates. Hence removing duplicates
        sortIndexes.clear(); // deleting everything from list sortIndexes. Hence preparing it for new entry.
        sortIndexes.addAll(removeDuplicates); // Copying all the new clean data from hash set removeDuplicates to sortIndexes
        Collections.sort(sortIndexes); // sorting list sortIndexex in increasing order


        // Printing out the new cleaned list sortIndexes on screen for better visualisation and understanding
        System.out.println("\n If '" + word + "' can be spelled confirmation:          " + sortIndexes);

        if(word.length()>sortIndexes.size()) // if the list sortIndexes has entries less than tha word itself then the word was not spellable anyways.
            return canBeSpelled = false;
        else {
            for (int i = 0; i < word.length(); i++) { // Checking integrity of the list sortIndexes, if any number is missing the loop will return: false, hence word cant be spelled
                for (int j = 0; j < word.length(); j++) {
                    if (i == sortIndexes.get(j)) {
                        canBeSpelled = true;
                        break;
                    } else canBeSpelled = false;
                }
                if (!canBeSpelled)
                    break;
            }
        }
        return canBeSpelled;
    }
}
