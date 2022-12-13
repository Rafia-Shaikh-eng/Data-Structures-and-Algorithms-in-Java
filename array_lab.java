package com.mycompany.app.DSA_Labs;
import java.util.Arrays;
import java.util.Scanner;

public class array_lab {
    //creating oject of scanner class
    Scanner sc=new Scanner(System.in);
    //size
    int size=0;
    int[] arrayNum;
    int[] newArray;
    //constructor
    array_lab(int[] arrayNum, int size){
        this.arrayNum=arrayNum;
        this.size=size;
    }
    //menu
    int menu(){
        System.out.println("----------------------");
        System.out.println("1. Create");
        System.out.println("2. Display");
        System.out.println("3. Size/length");
        System.out.println("4. Update");
        System.out.println("5. Search");
        System.out.println("6. Delete");
        System.out.println("7. Insert");
        System.out.println("8. Exit");
        System.out.println("----------------------");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        return choice;
    }
    //array operations
    //1. Create
    int[] Create(){
        arrayNum=new int[size];
        // newArray=new int[size];
        //0,1,2,3,4->5
        for(int i=0; i<size; i++){
            System.out.print("Enter element "+(i+1)+" : ");
            arrayNum[i]=sc.nextInt(); //0, 1,2,3,4<5
            // newArray[i]=arrayNum[i];
        }
       return arrayNum;
    }
    //2. Display
    void Display(int[] arrayNum){
        if(size==0)
            System.out.println("Array is empty");
        else{

            System.out.print("[");
            //for 
            for(int i=0; i<size-1; i++){
                System.out.print(arrayNum[i]+",");
            }
            System.out.print(arrayNum[size-1]+"]\n");
        }
        
    }
    //3. Length
    void Length(){
        System.out.println("Array size is : "+size);
    }
    //4. Update
    //[11,22,33] ->11 =-99
    int[] Update(int[] arrayNum){
        System.out.print("Enter element you want to replace : ");
        int pre_element=sc.nextInt(); //11
        System.out.print("Enter new element you want to insert : ");
        int new_element=sc.nextInt();//-99
        //search the previous element 
        int found_index=Search2(pre_element,arrayNum);
        if(found_index==-1)
            System.out.println("Sorry! element does not exist");
        else{
            for(int i=0; i<size; i++){ 
                if(arrayNum[i]==pre_element)
                    arrayNum[i]=new_element;
            }
            System.out.println(pre_element+" is replaced by "+new_element);
        }
        
        return arrayNum;
    }
    //5. Search
    void Search1(int[] arrayNum){
        System.out.print("Enter search element : ");
        int element=sc.nextInt();
        boolean found=false;
        for(int i : arrayNum){
            if(i==element){
                found=true;
                break;
            }
            else
                found=false;
        }
        if(found)
            System.out.println(element+" found");
        else
            System.out.println(element+" not found");
    }
    //index
    //[11,22,33]
    int Search2(int element, int[] arrayNum){
        // System.out.print("Enter search element : ");
        // int element=sc.nextInt();
        for(int i=0; i<size; i++){
            if(this.arrayNum[i]==element)
                return i; //2
        }
        return -1;
    }
    //6. Delete
    int[] Delete(int[] arrayNum){
        Length();
        System.out.print("Enter elemenet you want to delete : ");
        int elemenet=sc.nextInt();
        int index=Search2(elemenet, arrayNum);
        System.out.println(index);
        if(index==-1){
            System.out.println("Sorry! element not found");
            return arrayNum;
        }
        else{
            size--;
            newArray=new int[size];
            for(int i=0; i<index; i++)
               newArray[i]= arrayNum[i];
            for(int i=index; i<size; i++)
                newArray[i]=arrayNum[i+1];

            System.out.println(elemenet+" deleted");
            return newArray; 
        }
       
    }
    //7. Insert
    int[] Insert(int[] arrayNum){
        size++;
        System.out.print("Enter the element you want to insert : ");
        int element=sc.nextInt();
        System.out.print("Enter the position : ");
        int pos=sc.nextInt();
        newArray=new int[size];
        for(int i=0; i<pos; i++)
            newArray[i]=arrayNum[i]; //0,1

       newArray[pos]=element;

        for(int i=pos; i<arrayNum.length; i++)
            newArray[i+1]=arrayNum[i]; //2+1=3

        System.out.println(element+" is inserted at position "+pos);
        return newArray;

    }
}

 class main {
    public static void main(String[] args) {
        //creating oject of scanner class
        Scanner sc=new Scanner(System.in);
        //size of array
        System.out.print("Enter size of array : ");
        int size=sc.nextInt(); 
        //array
        int[] arrayTest=new int[size];
        //creating object of arraylab class
        array_lab array1=new array_lab(arrayTest, size);        
        while(true){
            switch(array1.menu()){
                case 1:
                    arrayTest=array1.Create();
                    break;
                case 2:
                    array1.Display(arrayTest);
                    break;
                case 3:
                    array1.Length(); 
                    break;
                case 4:
                    arrayTest=array1.Update(arrayTest);
                    break;
                case 5:
                    array1.Search1(arrayTest);
                    break;
                case 6:
                    arrayTest=array1.Delete(arrayTest);
                    break;
                case 7:
                    arrayTest=array1.Insert(arrayTest);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                
            }
        }

      
        
       
        
    }

}
