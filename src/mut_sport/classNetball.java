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
public class classNetball {
     private int id;
    private  String team;
    private String matchPlayed;
    private String wins;
   private  String losses;
   private String  goalFor;
    private String goalAgainst;
   private  String goalDifference;
   private  String points;
    
    
    
    public classNetball(int ID, String Team, String MatchPlayed, String Wins, String Losses,String GoalFor,  String GoalAgainst, String GoalDifference,String Points ){
        
        this.id = ID;
        this.team= Team;
        this.matchPlayed = MatchPlayed;
        this.wins = Wins;
        this.losses = Losses;
        this.goalFor = GoalFor;
        this.goalAgainst = GoalAgainst;
        this.goalDifference = GoalDifference;
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
      
  
       public String getLosses(){
        
        return losses;
    }
       
     public String getGoalFor(){
        
        return goalFor;
    }
      public String  getGoalAgainst(){
        
        return goalAgainst;
    }
      
        public String getGoalDifference(){
        
        return goalDifference;
    }
       public String getPoints(){
        
        return points;
    }
}
