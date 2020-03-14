
public class LListUnitTests{


  public static void main(String[] args){
  
  
   LList list = new LList();
      
      list.addSortedNode("9",4.0,4.0);
      list.addSortedNode("3",1.0,1.0);
      list.addSortedNode("6",2.0,2.0);
      
      list.addSortedNode("7",4.0,4.0);
      list.addSortedNode("6",5.0,3.0);
      list.addSortedNode("6",5.0,3.0);
      
      list.addSortedNode("12",6.0,6.0);
      list.addSortedNode("8",4.0,4.0);
      list.addSortedNode("2",3.0,1.0);
      
      list.addSortedNode("11",4.0,4.5);
      list.addSortedNode("6",3.0,4.0);
      list.addSortedNode("10",4.0,4.0);
      
      list.addSortedNode("1",5.0,1.0);
      list.addSortedNode("5",2.0,2.5);
      list.addSortedNode("13",2.0,12.5);
      
      //int i = list.clearList();
 //     System.out.println("Number of nodes: " + j);
//         list.remNode("name1");
        // list.remNode("name2");
         //list.remNode("name3");
         //list.remNode("name4");
         //list.remNode("3 ");
        list.remNode("1");
         list.remNode("2");
//         list.remNode("3");
//         list.remNode("4");
//         list.remNode("5");
//         list.remNode("6");
//         list.remNode("7");
//         list.remNode("8");
//         list.remNode("9");
//System.out.println("Number of nodes: " + j);
      list.printList();
  
  }



}