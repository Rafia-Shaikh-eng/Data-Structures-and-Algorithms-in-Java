package Collections;
//Generic class
class anyPair<F,S>{
    F first;
    S second;
    //constructor; initialize the data members during the creation of object
    anyPair(F first, S second){
        this.first=first;
        this.second=second;
    }
    public F getFirst() {
        return first;
    }
    public S getSecond() {
        return second;
    }
}
//testGeneric class
public class testGeneric{
    //An enumeration (enum for short) in Java is a special data type which contains a set of predefined constants.
    enum Month{
        JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEPT,OCT,NOV,DEC;
    }
    public static void main(String[] args) {
    //creating object of generic class 
    anyPair<Month,Integer> quaidDay=new anyPair<Month,Integer>(Month.DEC, 25);
    System.out.println(quaidDay.getFirst()+" "+quaidDay.getSecond());
    }
}