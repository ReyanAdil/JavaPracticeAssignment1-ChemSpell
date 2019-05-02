# chemSpell
A Java code to respell input word using periodic table elements
Assignment

Let’s do something fun for your assignment.
 
In this assignment, you will use abbreviations of the elements in the chemistry periodic table to spell English words. We will provide you with the abbreviations in the assignment starter code.
 
Specifically, your program will prompt the user to enter an English word and respell the word using abbreviations of the elements.
 
For example, if you enter the word phone, the program will respell the word using abbreviations of the elements (with correct punctuations) as PHoNe.
 
Or more specifically, your program will spell the word 'phone' with the following elements:
Phosphorous (P)
Ho (Holmium)
Ne (Neon)
 
If you cannot spell the given word with the elements of the periodic table, your program should output “cannot spell word”.
 
Here are a few additional test cases for you to test your program.
If the inputs are —
ten
conference
onomatopoeia
The outputs should be —
TeN
CoNFeReNCe
cannot spell word

You can copy the following code snippet to begin your code with.
public class test {
    public static void main(String args[]) {
        String[] elements = { "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl",
                "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr",
                "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs",
                "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W",
                "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np",
                "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg",
                "Cn", "Uut", "Uuq", "Uup", "Uuh", "Uus", "Uuo" };

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String inputWord = myScanner.next();
        String chemWord = spellWord(inputWord, elements);

        System.out.println(chemWord);

        myScanner.close();
    }

    /**
     * @param word - the word that we want to re-spell using abbreviations of elements in the periodic table
     * @param elements - an array that contains the abbreviations of elements in the periodic table
     *
     * @return word re-spelled using abbreviations of elements in the periodic table
     *
     * The spellWord function will take in two parameters, word and elements.
     * 1. The parameter 'word' represents the word that we want to re-spell using an abbreviation of the elements from
     * the periodic table.
     * 2. The parameter 'elements' represents possible element abbreviations that you can use to re-spell the word.
     *
     * The function needs to return a String representing the word that you have re-spelled
     * using abbreviations of the elements in the periodic table.
     *
     */
    public static String spellWord(String word, String[] elements) {
        // your logic
    }

              
             
to start your code with.
