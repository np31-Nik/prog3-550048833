/**
 * @author Nikita Polyanskiy P550048833
 */
package model;

import java.util.Arrays;

public class Coordinate{
	
	private int[] components;
	private int dim;
	
	public Coordinate(int x, int y){
        dim = 2;
        components = new int[dim];
        components[0]=x;
        components[1]=y;
	}
	
	public Coordinate(Coordinate c){
		dim=2;
        components = new int[dim];
	
        for (int i=0;i<dim;i++) {
            components[i]=c.components[i];
        }
	}
	
	protected void set(int component,int value){
        if (component>=0 && component<dim) {
            components[component] = value;
        }
        else {
            System.err.print("Error in Coordinate.get, component ");
            System.err.print(component);
            System.err.println(" is out of range");
        }
	}
	
	public int get(int component){
	   if (component>=0 && component<dim) {
            return components[component];
        }
        else {
            System.err.print("Error in Coordinate.get, component ");
            System.err.print(component);
            System.err.println(" is out of range");
        }

        return -1;
	}
	
	public Coordinate add(Coordinate c){
        Coordinate new_c=c;
        
        for (int i=0; i<dim; i++) {
        new_c.set(i, new_c.get(i) + c.get(i));
        }
        return new_c;
	}
	
	public final Coordinate substract(Coordinate c){
        Coordinate new_c=c;
        
        for (int i=0; i<dim; i++) {
            new_c.set(i, new_c.get(i) - c.get(i));
        }               
        return new_c;
	}
	
	public final String toString() {
		   String concatenation="";
		   concatenation += "(";
		   for (int i = 0;i < dim;i++)
		   {
			  concatenation += components[i];
			  if (i < dim - 1) 
			  {
				 concatenation += ",";
			  }
		   }
		   concatenation += ")";
		   return concatenation;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(components);
		result = prime * result + dim;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (!Arrays.equals(components, other.components))
			return false;
		if (dim != other.dim)
			return false;
		return true;
	}
}





