
// BinarySearchTree class   
//   
// ******************PUBLIC OPERATIONS*********************   
// void insert( x )       --> Insert x   
// boolean contains( x )  --> Return true if x is present   
  
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>   
{   
    /**  
     * Construct the tree.  
     */   
    public BinarySearchTree( )   
    {   
        root = null;   
    }   
   
    /**  
     * Insert into the tree; duplicates are ignored.  
     * @param x the item to insert.  
     */   
    public void insert( AnyType x )   
    {   
        root = insert( x, root );   
    }   

    /**  
     * Find an item in the tree.  
     * @param x the item to search for.  
     * @return true if not found.  
     */   
    public boolean contains( AnyType x )   
    {   
        return contains( x, root );   
    }   

    /**  
     * Internal method to insert into a subtree.  
     * @param x the item to insert.  
     * @param t the node that roots the subtree.  
     * @return the new root of the subtree.  
     */   
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )   
    {   
        if( t == null )   
            return new BinaryNode<AnyType>( x, null, null );   
           
        int compareResult = x.compareTo( t.element );   
               
        if( compareResult < 0 )   
            t.left = insert( x, t.left );   
        else if( compareResult > 0 )   
            t.right = insert( x, t.right );   
        else   
            ;  // Duplicate; do nothing   
        return t;   
    }   

    /**  
     * Internal method to find an item in a subtree.  
     * @param x is item to search for.  
     * @param t the node that roots the subtree.  
     * @return node containing the matched item.  
     */   
    private boolean contains( AnyType x, BinaryNode<AnyType> t )   
    {   
        if( t == null )   
            return false;   
               
        int compareResult = x.compareTo( t.element );   
               
        if( compareResult < 0 )   
            return contains( x, t.left );   
        else if( compareResult > 0 )   
            return contains( x, t.right );   
        else   
            return true;    // Match   
    }    
       
    // Basic node stored in unbalanced binary search trees   
    private static class BinaryNode<AnyType>   
    {   
        // Constructors   
        BinaryNode( AnyType theElement )   
        {   
            this( theElement, null, null );   
        }   
   
        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, 
                                        BinaryNode<AnyType> rt )   
        {   
            element  = theElement;   
            left     = lt;   
            right    = rt;   
        }   
   
        AnyType element;            // The data in the node   
        BinaryNode<AnyType> left;   // Left child   
        BinaryNode<AnyType> right;  // Right child   
    }   
   
   
      /** The tree root. */   
    private BinaryNode<AnyType> root;   
}