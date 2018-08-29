/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		List<Point> pts = new ArrayList<Point>();
		pts.add(new Point(-2,4));
		pts.add(new Point(0,-2));
		pts.add(new Point(-1,0));
		pts.add(new Point(2,5));
		pts.add(new Point(-2,-3));
		pts.add(new Point(3,2));
                        for(Point p :nearestKPoint_1(pts, new Point(0,0), 3)){
                        	System.out.println(p.toString());
                        }
		
	}
	
	static List<Point> nearestKPoint_1(List<Point> list, final Point center, int k) {
    List<Point> ans = new ArrayList<>();
    PriorityQueue<Point> maxHeap = new PriorityQueue<>(k , new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return distance(center, o2) - distance(center, o1);
        }
    });
    
    for (Point p : list) {
        maxHeap.offer(p);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }
    
    Iterator<Point> i = maxHeap.iterator();
    while (i.hasNext()) {
        ans.add(i.next());
    }
    return ans;
}

public static int distance(Point p1, Point p2) {
    return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
}

static class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
    
    @Override
    public String toString(){
    	return "x = "+x+" y = "+y;
    }
}

}
