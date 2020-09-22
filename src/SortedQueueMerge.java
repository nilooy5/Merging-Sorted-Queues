public class SortedQueueMerge {

    // This class should not be instantiated.
    private SortedQueueMerge() {}

    public static void merge_queues(Queue<Comparable> a, Queue<Comparable> b){

        if ( a.isEmpty() || b.isEmpty()){ throw new IllegalArgumentException("Empty Queue"); }

        Comparable v =  a.dequeue();
        Comparable w = b.dequeue();

        Boolean empty_a = false;
        Boolean empty_b = false;

        int size = a.size();
        int i = 0;

        while ( true ){

            if( empty_b ){
                a.enqueue( v );
                if (i < size) { v =  a.dequeue(); i++ ; }
                else{ break; }
            }
            else if( empty_a ){
                a.enqueue( w ) ;
                if ( b.isEmpty() ) { w = b.dequeue(); }
                else{ break; }
            }
            else if( ! less(v , w) ){
                a.enqueue(w);
                if( !b.isEmpty() ) { w = b.dequeue(); }
                else{ empty_b = true; }
            }else{
                a.enqueue(v);
                if( i < size ) { v = a.dequeue(); i++; }
                else{ empty_a = true; }
            }
        }
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    /**
     * Test function
     */
    public static void main(String[] args) {

        Queue a = new Queue();
        a.enqueue("a");
        a.enqueue("c");
        a.enqueue("f");
        a.enqueue("g");
        a.enqueue("v");

        Queue b = new Queue();
        b.enqueue("b");
        b.enqueue("d");
        b.enqueue("e");
        b.enqueue("h");
        b.enqueue("l");

        merge_queues(a, b);

        //Print Queue
        while ( !a.isEmpty() ){
            System.out.println(a.dequeue());
        }
    }
}