package model;

import java.util.Arrays;

public class Coordinate
{
	int components[];
	int dim;
	
	public Coordinate(int x, int y){
        dim = 2;
        components = new int[dim];
        components[0]=x;
        components[1]=y;
	}
	
	public Coordinate(Coordinate c){
		dim=2;
        components = new int[2];
	
        for (int i=0;i<dim;i++)
            components[i]=c.components[i];
	}
	
	public final int get(int component){
	   if (component>=0 && component<dim) {
            return components[component];
        }
        else
            System.err.print("Error in Coordinate.get, component ");
            System.err.print(component);
            System.err.println(" is out of range");
            

        return -1;
	}
	
	public final boolean equals(Coordinate c){
        for (int i=0;i<dim;i++)
            if (components[i] != c.components[i]) return false;
        return true;
	}
	
	
	@Override
	public String toString() {
		return "Coordinate [components=" + Arrays.toString(components) + ", dim=" + dim + ", operator=" + operator
				+ "]";
	}
	
	
	public final Coordinate operator+(Coordinate c){
        Coordinate new_c;
        
        for (int i=0; i<dim; i++)
        new_c.set(i, new_c.get(i) + c.get(i));
                
        return new_c;
	}
	
	public Coordinate operator-(final Coordinate& c) final{
        Coordinate new_c(*this); 
        
        for (int i=0; i<dim; i++)
            new_c.set(i, new_c.get(i) - c.get(i));
                
        return new_c;
	}
	
	private void set(int component,int value){
        if (component>=0 && component<dim) {
            components[component] = value;
        }
        else
            System.err.print("Error in Coordinate.get, component ");
            System.err.print(component);
            System.err.println(" is out of range");
        }      
        
}





