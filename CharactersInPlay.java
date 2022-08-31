
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    private ArrayList<String> charName;
    private ArrayList<Integer> charCount;

    public CharactersInPlay() {
        this.charName = new ArrayList<String>();
        this.charCount = new ArrayList<Integer>();
    }

    public void update(String person){
        String lowerPerson = person.toLowerCase();
        int currIndex = charName.indexOf(lowerPerson);
        if(currIndex == -1 ){
            charName.add(lowerPerson);
            charCount.add(1);
        } else {
            int freq = charCount.get(currIndex);
            charCount.set(currIndex,freq+1);
        }
    }
    
    public void findAllCharacters(){
        charName.clear();
        charCount.clear();
        FileResource fr = new FileResource();
        for(String person : fr.lines()){
            int index = person.indexOf(".");
            if (index != -1){
                String name = person.substring(0,index);
                update(name);
            }
        }
        
    }
    
    public void tester(){
        findAllCharacters();

        int maxFreq = 0;
        int maxIndex = 0;
        for(int k=0;k<charName.size();k++){
            if(charCount.get(k)>maxFreq){
                maxFreq = charCount.get(k);
                maxIndex = k;
            }
        }
        
        System.out.println("Most Frequent Name"+ "\t" + charName.get(maxIndex)
                            + "\t" + charCount.get(maxIndex));
        charactersWithNumParts(10,15);
    }
    
    void charactersWithNumParts(int num1, int num2){
        for(int k=0;k<charName.size();k++){
            if(charCount.get(k)>= num1 && charCount.get(k) <= num2){
                System.out.println("exactly number speaking characters" + "\t"
                                    + charName.get(k) + " " +  charCount.get(k));
            }
    }
  }

}
