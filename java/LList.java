/* 
   Student information:
   Author: Ebrahim Bonger
   GWID: G35344397
   GWNetID: Ebrahim5@gwu.edu
   Project1 java version
*/

import java.lang.*;
public class LList {

  public LNode head;
  /* You may not add more data members to this class. */
  
  public void printList(){
    LNode entry = head;
    System.out.println("List Contents:");
    while (entry != null) {
      System.out.printf("  %s is at %f, %f\n", entry.name, entry.latitude, entry.longitude);
      entry = entry.next;
    }
  }

  public int entryCount = 0;
  public int clearCount = 0;
  public int removeCount = 0;
  public double smallerLon = 0.0;
  public double biggerLon = 0.0;
  
  public int addNode(String name, double lat, double lon){
    
    LNode node = new LNode(name, lat, lon);
    
    if (head == null) 
    { 
        head = new LNode(name, lat, lon);
        entryCount = 0;
        return entryCount; 
    } 
  
    node.next = null; 
  
    LNode nodePtr = head;
    while (nodePtr.next != null) {
        nodePtr = nodePtr.next; 
    }

    nodePtr.next = node; 
    entryCount++;
    
    return entryCount;
     
  }

  public int remNode(String name){
    
    
    if(head == null){
     
     System.out.println("R1");
     return -1;
    }
    
   
   if(head.name.equals(name) == true){
      head = head.next;
      entryCount--;
      System.out.println("R2");
      return 0;
   }
      
   LNode ptr = head;
   LNode follower = head;
      
   while(ptr.next != null){
      
      ptr = ptr.next;
      
      // if(ptr.next == null) {
//          int i = 0;
//          follower = head;
//          
//          while(i != entryCount -1){
//             i++;
//             //System.out.println("E");
//             
//             follower = follower.next;
//          }
//          follower.next = ptr.next;
//          ptr = follower;
//          removeCount++;
//          entryCount--;
//          System.out.println("R3");
//          return removeCount;
//          
//       }
      if(ptr.name.equals(name) == true){
         
         follower.next = follower.next.next;
         
         ptr = follower;
         removeCount++;
         entryCount--;
         System.out.println("R4");
         return removeCount;
      
      }
      
      follower = follower.next;
   }
    System.out.println("-1");
    return -1; 
      
  }

  public int addSortedNode(String name, double lat, double lon){
    
    LNode node = new LNode(name, lat, lon);
    
    LNode ptr = head;
    LNode follower = head;
    LNode res;
    
    // Null case
    if(head == null){
      head = node;
      head.next = null;
      entryCount = 0;
      smallerLon = node.longitude;
      biggerLon = node.longitude;
      
      //System.out.println("first node case");
      return entryCount;
    }
    
    // updating the big and smaller lon
    if(lon >= biggerLon){
      biggerLon = lon;
      
    }
    else if(lon <= smallerLon ){
      smallerLon = lon;
    }
    // taking care of the firs and last node edge cases
    if(lon <= smallerLon){
         smallerLon = lon;
         
         
            node.next = head;
            head = node;
            entryCount++;
            //System.out.println("firstEdge case " + node.name + "  longitude " + node.longitude + " smallerLon " + smallerLon + " biggerLon " + biggerLon + " lon " + lon);
            return entryCount;

    }
    else if(lon >= biggerLon){
            while(ptr.next != null){
               ptr = ptr.next;
            }
            ptr.next = node;
            node.next = null;
            entryCount++;
            //System.out.println("lastEdge Case " + node.name + "  longitude " + node.longitude);
            return entryCount;
     } 
    
    // single node cases
     while(head.next == null){
      // if the coming node less than the head lon
         if(head.longitude > lon){
         
            smallerLon = lon;
            biggerLon = node.longitude;
         
            node.next = head;
            head = node;
            head.next.next = null;
         
            entryCount++;
            //System.out.println("singleNode case " + node.name + "  longitude " + node.longitude);
            return entryCount;
         }
    }
    
    if(head != null){
      
      if(smallerLon > lon){
         smallerLon = lon;
         node.next = head;
         head = node;
         entryCount++;
         //System.out.println("E5");
         return entryCount;
      }
      else if(biggerLon < lon){
            biggerLon = lon; 
            
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = node;
            node.next = null;
            entryCount++;
            //System.out.println("E7");
            return entryCount;
      
      }
      else if(biggerLon == lon){
         biggerLon = lon;
         while(ptr.next != null){
                ptr = ptr.next;
         }
         ptr.next = node;
         node.next = null;
         entryCount++;
         //System.out.println("E7");
         return entryCount;
      }
    }
       
    follower = head;
    ptr = head;
    
    while(ptr.next != null){
      ptr = ptr.next;
      
      if(follower.longitude < lon && ptr.longitude > lon){
         follower.next = node;
         node.next = ptr;
         entryCount++;
         //System.out.println("single Middle case " + node.name + "****  longitude " + node.longitude);
         return entryCount;
      }
      
      follower = follower.next;
      if (ptr.longitude == follower.longitude && lon > ptr.longitude){
          
         while(ptr.next.longitude < lon){
            ptr = ptr.next;
         }
         res = ptr.next;
         ptr.next = node;
         node.next = res;
         entryCount++;
         //System.out.println("double Middle case " + node.name + "  longitude " + node.longitude);
         return entryCount;
      }
      
    }
    
    if(ptr.next == null){
      ptr.next = node;
      node.next = null;
      entryCount++;
      return entryCount;
    }
    
    
    System.out.println(-1);
    return -1;
   
  }

  public int clearList(){
    
    if(head == null){
     return -1;
    }
    
    LNode ptrFollower = head;
    LNode ptr = head;
    
    while(ptr != null){
      
      ptr = ptr.next;
      ptrFollower = null;
      clearCount++;
      
      ptrFollower = ptr;
      
    }
    
    head = null;
    return clearCount;
    
  }

}