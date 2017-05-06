package random;
import java.util.Stack ;

class TowerOfHanoi {
	
    @SuppressWarnings("unchecked")
	Stack<Integer>[] stacks = new Stack[3] ;
    
    public static void main(String[] args) {
        TowerOfHanoi obj = new TowerOfHanoi() ;
        //int disks = Integer.parseInt(args[0]) ;
        int disks = 5 ;
        for(int i=0 ; i<obj.stacks.length ; i++) {
            obj.stacks[i] = new Stack<>() ;
        }
        for(int i=disks ; i>0 ; i--) {
            obj.stacks[0].push(i) ;
        }
        obj.move(0, 1, 2, disks) ;
    }
    
    void move(final int first, final int second, final int third, final int disks) {
        if(disks == 2) {
            stacks[second].push( stacks[first].pop() ) ;
            System.out.println("moving disk " + stacks[second].peek() + " from pole " + first + " to pole " + second) ;
            stacks[third].push( stacks[first].pop() ) ;
            System.out.println("moving disk " + stacks[third].peek() + " from pole " + first + " to pole " + third) ;
            stacks[third].push( stacks[second].pop() ) ;
            System.out.println("moving disk " + stacks[third].peek() + " from pole " + second + " to pole " + third) ;
        }
        else {
            move(first, third, second, disks-1) ;
            stacks[third].push( stacks[first].pop() ) ;
            System.out.println("moving disk " + stacks[third].peek() + " from pole " + first + " to pole " + third) ;
            move(second, first, third, disks-1) ;
        }
    }
}