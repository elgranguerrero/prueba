package HashListaEnlazada;

import java.io.Serializable;

public class Empleado implements Comparable<Empleado>,Serializable{
	public int cod;
	public String nom;
	public int catEmpleados;
	
	public Empleado(int cod,String nom,int cantEmpleado){
		this.cod=cod;
		this.nom=nom;
		this.catEmpleados=cantEmpleado;
	}
	public int hashCode() {
		return cod;
	}
	@Override
	public int compareTo(Empleado o) {
		if (this.cod==o.cod) {return 0;}
		else {
			if (this.cod>o.cod) return 1;
			else return -1;
		}
	}
	public String toString() {
		String m=cod+": "+nom;
		return m;
	}
}
