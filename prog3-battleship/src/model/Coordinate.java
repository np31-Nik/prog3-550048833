package model;

import java.util.Arrays;
/**
 * @author Nikita Polyanskiy P550048833
 */

/**
 * Clase coordenada.
 */
public class Coordinate{
	/**
	 * Componentes de la coordenada.
	 */
	private int[] components;
	
	/**
	 * Dimensión de la coordenada.
	 */
	private int dim;
	
	/**
	 * Constructor
	 * @param x columna
	 * @param y fila
	 */
	public Coordinate(int x, int y){
        dim = 2;
        components = new int[dim];
        components[0]=x;
        components[1]=y;
	}
	
	/**
	 * Constructor.
	 * @param c Coordenada
	 */
	public Coordinate(Coordinate c){
		dim=2;
        components = new int[dim];
	
        for (int i=0;i<dim;i++) {
            components[i]=c.components[i];
        }
	}
	/**
	 * Método set.
	 * @param component la componente
	 * @param value el valor entero
	 */
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
	
	/**
	 * Método get.
	 * @param component
	 * @return componente si tiene exito.
	 */
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
	
	/**
	 * Método add.
	 * @param c la coordenada.
	 * @return la nueva coordenada.
	 */
	public Coordinate add(Coordinate c){
        Coordinate new_c= new Coordinate(this);
        
        for (int i=0; i<dim; i++) {
        new_c.set(i, new_c.get(i) + c.get(i));
        }
        return new_c;
	}
	
	/**
	 * Método substract.
	 * @param c la coordenada.
	 * @return la nueva coordenada.
	 */
	public final Coordinate subtract(Coordinate c){
        Coordinate new_c= new Coordinate(this);
        
        for (int i=0; i<dim; i++) {
            new_c.set(i, new_c.get(i) - c.get(i));
        }               
        return new_c;
	}
	
	/**
	 * Método toString.
	 * @return la cadena.
	 */
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
	
	/**
	 * Método hashCode.
	 * @return el entero.
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(components);
		result = prime * result + dim;
		return result;
	}

	/**
	 * Método equals.
	 * @param obj el objeto.
	 * @return true si tiene exito.
	 */
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





