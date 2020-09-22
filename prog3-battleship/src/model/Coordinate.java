package model;
public class Coordinate
{
	int components;
	int dim;
	
	public Coordinate(int x, int y){
        dim = 2;
        components = new int[dim];
        components[0]=x;
        components[1]=y;
	}
	
	public Coordinate(final Coordinate&){
        dim = 2;
        components = new int[dim];
	
        for (int i=0;i<dim;i++)
            components[i]=c.components[i];
	}
	
	public ~Coordinate(){
     
	}
	
	public int get(int component) final{
	   if (component>=0 && component<dim) {
            return components[component];
        }
        else
            System.err.print("Error in Coordinate.get, component ");
            System.err.print(component);
            System.err.println(" is out of range");
            

        return -1;
	}
	
	public bool operator==(final Coordinate&) final{
        for (int i=0;i<dim;i++)
            if (components[i] != c.components[i]) return false;
        return true;
	}
	
	
	public string to_string() final{
        stringstream concatenation;
        concatenation << "(";
        for (int i=0;i<dim;i++)
        {
            concatenation << components[i];
            if (i<dim-1) // no es la última
                concatenation << ",";
        }
        concatenation << ")";
        return concatenation.str();
	}
	
	public Coordinate operator+(final Coordinate& c) final{
        Coordinate new_c(*this);
        
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





