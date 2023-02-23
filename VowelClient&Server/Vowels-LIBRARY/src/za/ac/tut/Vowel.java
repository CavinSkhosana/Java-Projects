// Student no : 220452980
// CS SKHOSANA

package za.ac.tut;

import java.sql.Timestamp;

/**
 *
 * @author Cavin
 */
public class Vowel {

   
    private String word;
    private int As;
    private int Es;
    private int Is;
    private int Os;
    private int Us;
    private Timestamp ts;
 
    public Vowel() {
    }

    public Vowel(String word, int As, int Es, int Is, int Os, int Us, Timestamp ts) {
        this.word = word;
        this.As = As;
        this.Es = Es;
        this.Is = Is;
        this.Os = Os;
        this.Us = Us;
        this.ts = ts;
    }

    public Vowel(String word, int As, int Es, int Is, int Os, int Us) {
        this.word = word;
        this.As = As;
        this.Es = Es;
        this.Is = Is;
        this.Os = Os;
        this.Us = Us;
    }

    

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getAs() {
        return As;
    }

    public void setAs(int As) {
        this.As = As;
    }

    public int getEs() {
        return Es;
    }

    public void setEs(int Es) {
        this.Es = Es;
    }

    public int getIs() {
        return Is;
    }

    public void setIs(int Is) {
        this.Is = Is;
    }

    public int getOs() {
        return Os;
    }

    public void setOs(int Os) {
        this.Os = Os;
    }

    public int getUs() {
        return Us;
    }

    public void setUs(int Us) {
        this.Us = Us;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "Vowel{" + "word=" + word + ", As=" + As + ", Es=" + Es + ", Is=" + Is + ", Os=" + Os + ", Us=" + Us + ", ts=" + ts + '}';
    }
    
    
    
    

}
