/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos_predict;

/**
 *
 * @author user
 */

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class BetToday {
    long id;
    String country;
    LocalDateTime time;
    String teamOwner;
    String teamGuest;
    int resultMatchOwner=-1;
    int resultMatchGuest=-1;
    String betPrediction;
    double keff;
    StatePredict state;
    static final ArrayList<BetToday> testSpisok = new ArrayList<>();

    static {
        new BetToday("Ukraine", LocalDateTime.now(), "Dinamo", "Dnepr",
                 "Dnepr WIN", 2.95);
        new BetToday("England", LocalDateTime.now(), "Arsenal", "Bernny",
                 "OVER 2.5", 1.54);
        new BetToday("Germany", LocalDateTime.now(), "Bayeren M.", "Schalke 04",
                 "Bayeren M. WIN", 1.48);
        new BetToday("Germany", LocalDateTime.now(), "Hertha", "Wolfsburg",
                 "BOTH TEAMS SCORE", 1.87);
 BetToday temp=new BetToday("Germany", LocalDateTime.now(), "Hertha", "Wolfsburg",
                 "BOTH TEAMS SCORE", 1.87);
 temp.resultMatchGuest=2;
 temp.resultMatchOwner=3;
 temp.state=StatePredict.Sbylos;
    }

    public BetToday(String country, LocalDateTime time, String teamOwner, String teamGuest,
                    String betPrediction, double keff) {
        this.country = country;
        this.time = time;
        this.teamOwner = teamOwner;
        this.teamGuest = teamGuest;
          this.betPrediction = betPrediction;
        this.keff = keff;
        this.id=createNewId();
        testSpisok.add(this);
    }

    

    private long createNewId() {
       long id=0;
        for(BetToday temp:testSpisok){
           if(id<temp.id){
               id=temp.id;
           }
       }     
      return id+1; 
    }
    public static void main(String[] args) {
        System.out.println(testSpisok);
    }
    @Override
    public String toString() {
        return "BetToday{" + "id=" + id + ", country=" + country + ", time=" + time + ", teamOwner=" + teamOwner + ", teamGuest=" + teamGuest + ", resultMatchOwner=" + resultMatchOwner + ", resultMatchGuest=" + resultMatchGuest + ", betPrediction=" + betPrediction + ", keff=" + keff + "\n";
    }

   enum StatePredict{
       Sbylos(Color.GREEN),NeSbylos(Color.RED),Drugoe(Color.ORANGE);
       Color color;

        private StatePredict(Color color1) {
            color=color1;
        }
       
   }
}