package coreservlets;

import java.util.*;

/** A shopping cart data structure used to track orders.
 *  The OrderPage servlet associates one of these carts
 *  with each user session.
 */
 
public class ShoppingCart {
  private Vector itemsOrdered;

  /** Builds an empty shopping cart. */
  
  public ShoppingCart() {
    itemsOrdered = new Vector();
  }

  /** Returns Vector of ItemOrder entries giving
   *  Item and number ordered.
   */
  
  public Vector getItemsOrdered() {
    return(itemsOrdered);
  }

  /** Looks through cart to see if it already contains
   *  an order entry corresponding to item ID. If it does,
   *  increments the number ordered. If not, looks up
   *  Item in catalog and adds an order entry for it.
   */
  
  public synchronized void addItem(String itemID) {
    ItemOrder order;
    for(int i=0; i<itemsOrdered.size(); i++) {
      order = (ItemOrder)itemsOrdered.elementAt(i);
      
      //如果已經存在採購車中，則增加數量1
      if (order.getItemID().equals(itemID)) {  
        order.incrementNumItems();
        return;
      }
    }
    
    //如果不在採購車中，則加入採購車中
    ItemOrder newOrder = new ItemOrder(Catalog.getItem(itemID));
    itemsOrdered.addElement(newOrder);
  }

  /** Looks through cart to find order entry corresponding
   *  to item ID listed. If the designated number
   *  is positive, sets it. If designated number is 0
   *  (or, negative due to a user input error), deletes
   *  item from cart.
   */
  
  public synchronized void setNumOrdered(String itemID,
                                         int numOrdered) {
    ItemOrder order;
    for(int i=0; i<itemsOrdered.size(); i++) {
      order = (ItemOrder)itemsOrdered.elementAt(i);
      if (order.getItemID().equals(itemID)) {
        if (numOrdered <= 0) {
          itemsOrdered.removeElementAt(i);
        } else {
          order.setNumItems(numOrdered);
        }
        return;
      }
    }
    ItemOrder newOrder =
      new ItemOrder(Catalog.getItem(itemID));
    itemsOrdered.addElement(newOrder);
  }
}
    
