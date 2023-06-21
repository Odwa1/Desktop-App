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
public class atte {
     
    private int id;
    private  String name;
    private String surname;
    private String phone;
    private String email;
   private int group_id;
    
    
    
    public atte(int ID, String Name,String Surname, String Email,String Phone,int Group_id ){
        
        this.id = ID;
        this.name = Name;
        this.surname = Surname;
        this.phone = Phone;
        this.email = Email;
        this.group_id = Group_id ;

    
    }
    public int getID()
    {
    return id;
    }
    
    public String getFirstName(){
        
        return name;
    }
      public String getLastName(){
        
        return surname;
    }
      
        public String getEmail(){
        
        return email;
    }
       public String getPhone(){
        
        return phone;
    }
      public int getGroup_ID(){
        
        return group_id;
    }
      
   
   
    
}
