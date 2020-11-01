package model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nikita Polyanskiy P550048833
 */

/**
 * Clase coordenada.
 */
public abstract class Coordinate{
	/**
	 * Componentes de la coordenada.
	 */
	private int[] components;
	
	/**
	 * Dimensión de la coordenada.
	 */
	private int dim;	
	
	/**
	 * Constructor con dimension
	 * @param dim la dimension
	 */
	protected Coordinate(int dim) {
		this.dim=dim;		
	}
	/**
	 * Constructor
	 * @param x columna
	 * @param y fila
	 */
	protected Coordinate(int x, int y){
        dim = 2;
        components = new int[dim];
        components[0]=x;
        components[1]=y;
	}
	/**
	 * Constructor con 3 dimensiones
	 * @param x dimension x
	 * @param y dimension y
	 * @param z dimension z
	 */
	protected Coordinate(int x, int y,int z){
        dim = 3;
        components = new int[dim];
        components[0]=x;
        components[1]=y;
        components[2]=z;
	}
	
	/**
	 * Constructor.
	 * @param c Coordenada
	 */
	protected Coordinate(Coordinate c){
		this.dim=c.getDim();
		if(c.getDim()==2) {
			 dim = 2;
		        components = new int[dim];
		        components[0]=c.components[0];
		        components[1]=c.components[1];
		}else {
			   dim = 3;
		        components = new int[dim];
		        components[0]=c.components[0];
		        components[1]=c.components[1];
		        components[2]=c.components[2];	
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
            throw new IllegalArgumentException("Componente fuera de rango");
        }
	}
	
	/**
	 * Método get.
	 * @param component la componente
	 * @return componente si tiene exito.
	 */
	public int get(int component){
	   if (component>=0 && component<dim) {
            return components[component];
        }
        else {
            throw new IllegalArgumentException("Componente fuera de rango");
        }
	}
	/**
	 * Método adjacentCoordinates.
	 * @return el conjunto de coordenadas
	 */
	public abstract Set<Coordinate> adjacentCoordinates();
	
	/**
	 * Método copy.
	 * @return la coordenada copia
	 */
	public abstract Coordinate copy();
	
	
	/**
	 * Método add.
	 * @param c la coordenada.
	 * @return la nueva coordenada.
	 */
	public Coordinate add(Coordinate c){
        Coordinate new_c=this.copy();
        if(c!=null) {
        for (int i=0; i<dim; i++) {
        	if(i==2 && c.dim<this.dim) {
        		new_c.set(i, new_c.get(i));
        	}else if(i==2 && c.dim>this.dim) {
        		new_c.set(i, c.get(i));
        	}else {
        		new_c.set(i, new_c.get(i) + c.get(i));
        	}
        }
        }else {
        	throw new NullPointerException("Coordenada nula");
        }
        return new_c;
	}
	
	/**
	 * Método substract.
	 * @param c la coordenada.
	 * @return la nueva coordenada.
	 */
	public final Coordinate subtract(Coordinate c){
        Coordinate new_c=this.copy();
        
        for (int i=0; i<dim; i++) {
        	if(i==2 && c.dim<this.dim) {
        		new_c.set(i, new_c.get(i));
        	}else if(i==2 && c.dim>this.dim) {
        		new_c.set(i, c.get(i));
        	}else {
        		new_c.set(i, new_c.get(i) - c.get(i));
        	}    
        }
        return new_c;
	}
	
	/**
	 * Método toString.
	 * @return la cadena.
	 */
	public abstract String toString();
	
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
	/**
	 * Getter de components
	 * @return las componentes
	 */
	public int[] getComponents() {
		return components;
	}
	/**
	 * Setter de components
	 * @param components las componentes nuevas
	 */
	public void setComponents(int[] components) {
		this.components = components;
	}
	/**
	 * Getter de dim
	 * @return la dimension
	 */
	public int getDim() {
		return dim;
	}
	/**
	 * Setter de dim
	 * @param dim la dimension
	 */
	public void setDim(int dim) {
		this.dim = dim;
	}
	
}





