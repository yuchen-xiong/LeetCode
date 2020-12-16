package com.leetcode.bear;

import java.util.*;

class Point
{
    //status: up = 0, down = 1;
    int idx, status, height;
    
    public Point(int i, int s, int h)
    {
        idx = i;
        status = s;
        height = h;
    }
}

class PointComparator implements Comparator<Point>
{
    public int compare(Point a, Point b)
    {
        if(a.idx == b.idx)
        {
            if(a.status == b.status)
            {
                return a.height - b.height;
            }
            return a.status - b.status;
        }
        return a.idx - b.idx;
    }
}


public class TheSkylineProblem {
	int up = 0, down = 1;
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if(buildings.length == 0 || buildings[0].length == 0)
        {
            return result;
        }
        
        List<Point> points = getPoints(buildings);
        Collections.sort(points, new PointComparator());
        
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        int preH = 0, preIdx = 0;
        List<Integer> preKeyPoint = null;
        for(Point point : points)
        {
            if(point.status == up)
            {
                heightMap.put(point.height, heightMap.getOrDefault(point.height, 0) + 1);
            }
            else if(point.status == down)
            {
                heightMap.put(point.height, heightMap.get(point.height) - 1);
                if(heightMap.get(point.height) == 0)
                {
                    heightMap.remove(point.height);
                }
            }
            
            int curH = heightMap.size() == 0 ? 0 : heightMap.lastKey(); //max height changes add the key point
            int curIdx = point.idx;
            if(curH != preH)
            {
                if(preKeyPoint == null || curIdx != preIdx)
                {
                    List<Integer> keyPoint = getKeyPoint(point.idx, curH);
                    result.add(keyPoint);
                    preKeyPoint = keyPoint;
                }
                else
                {
                    preKeyPoint.set(1, curH);
                }
                
                preH = curH;
                preIdx = curIdx;
            }
        }
        return result;
    }
    
    private List<Integer> getKeyPoint(int x, int y)
    {
        List<Integer> keyPoint = new ArrayList<>();
        keyPoint.add(x);
        keyPoint.add(y);
        return keyPoint;
    }
    
    private List<Point> getPoints(int[][] buildings)
    {
        List<Point> points = new ArrayList<>();
        int n = buildings.length;
        
        for(int i = 0; i < n; i++)
        {
            int height = buildings[i][2];   
            Point start = new Point(buildings[i][0], up, height);
            Point end = new Point(buildings[i][1], down, height);
            points.add(start);
            points.add(end);
        }
        return points;
    }
}
