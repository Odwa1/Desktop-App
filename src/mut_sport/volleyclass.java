/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mut_sport;

/**
 *
 * @author cash
 */
public class volleyclass {
 
    private int id;
    private  String team;
    private String matchPlayed;
    private String wins;
    private String draws;
   private  String losses;
   private  String points;
    
    
    
    public volleyclass(int ID, String Team, String MatchPlayed, String Wins, String Draws,String Losses,String Points ){
        
        this.id = ID;
        this.team= Team;
        this.matchPlayed = MatchPlayed;
        this.wins = Wins;
        this.draws = Draws;
        this.losses = Losses;
        this.points = Points;

    
    }
   public int getID()
    {
    return id;
    }
    public String getTeam(){
        
        return team;
    }
    public String getMatchPlayed(){
        
        return matchPlayed;
    }
      public String  getWins(){
        
        return wins;
    }
      
        public String getDraws(){
        
        return draws;
    }
       public String getLosses(){
        
        return losses;
    }
       public String getPoints(){
        
        return points;
    }
}
