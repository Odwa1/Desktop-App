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
public class company {
      private int id;
    private  String team;
    private int matchPlayed;
    private int wins;
    private int draws;
   private  int losses;
   private int  goalFor;
    private int goalAgainst;
   private  int goalDifference;
   private  int points;
    
    
    
    public company(int ID, String Team, int MatchPlayed, int Wins, int Draws,int Losses,int GoalFor, int GoalAgainst, int GoalDifference,int Points ){
        
        this.id = ID;
        this.team= Team;
        this.matchPlayed = MatchPlayed;
        this.wins = Wins;
        this.draws = Draws;
        this.losses = Losses;
        this.goalFor = GoalFor;
        this.goalAgainst = GoalAgainst;
        this.goalDifference = GoalDifference;
        this.points = Points;

    
    }
   public int ID()
    {
    return id;
    }
    public String Team(){
        
        return team;
    }
    public int MatchPlayed(){
        
        return matchPlayed;
    }
      public int  Wins(){
        
        return wins;
    }
      
        public int Draws(){
        
        return draws;
    }
       public int Losses(){
        
        return losses;
    }
       
     public int GoalFor(){
        
        return goalFor;
    }
      public int  GoalAgainst(){
        
        return goalAgainst;
    }
      
        public int GoalDifference(){
        
        return goalDifference;
    }
       public int Points(){
        
        return points;
    }
}
