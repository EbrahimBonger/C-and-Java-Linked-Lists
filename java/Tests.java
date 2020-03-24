public class Tests {

  // Testing intellij version control
  public static void addTestSimple() {
    LList list = new LList();
    int i;
    System.out.printf("Add Test #1\n-------------\n");
    System.out.printf("creaing first entry...\n");
    LNode office = new LNode("My office", 38.9005, -77.049318);
    list.head = office;
    office.next = null;
    list.head = office;
    System.out.printf("now adding more with function...\n");
    list.addNode("Washington Monument", 38.889404, -77.035194);
    i = list.addNode("Melbourne", -37.84232, 144.989318);
    if(i != 2){
      System.out.printf("ERROR: Not returning correct index in add!\n");
    }
    System.out.printf("Shold print list with 3 locations: My Office, Washington Monument, and Melbourne.\n");
    list.printList();
    System.out.printf("\n-------------\n\n");
  }
  
  public static void main (String[] argv) {
   
    addTestSimple();
  }
}