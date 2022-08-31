
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
        
        for (int k=0; k<charName.size(); k++){
            System.out.println("Most Frequent Name " 
                                + charName.get(k) +"\t" 
                                + charCount.get(k));
        }
        
    }

}
