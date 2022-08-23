
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    private ArrayList<String> charName = new ArrayList();
    private ArrayList<Integer> charCount = new ArrayList();
    
    public void update(String person){
        int currIndex = charName.indexOf(person);
        if(currIndex == -1 ){
            charName.add(person);
            charCount.add(1);
        } else {
            int freq = charCount.get(currIndex);
            charCount.set(currIndex,freq+1);
        }
    }
    
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        for(String person : fr.lines()){
            int index = person.indexOf(".");
            if (index != -1){
                update(person);
            }
        }
        int maxFreq = 0;
        int currIndex = 0;
        for(int k = 0; k<charCount.size();k++)
        if (charCount.get(k)>charCount.get(k)){
            maxFreq = charCount.get(k);
            currIndex  = k;
        }
        System.out.println("Most Frequent Name " 
                            + charName.get(currIndex) +"\t" 
                            + charCount.get(currIndex));
        charName.clear();
        charCount.clear();
    }
    
    public void tester(){
        findAllCharacters();
    }

}
