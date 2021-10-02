package Ejercicios;

public class ExamenFinal{
	String materia;
	int nota;
	//add fecha d,m,a
	ExamenFinal(String m, int n){
		materia = m;
		nota=n;
	}
	
	public void setMateria(String m) {materia=m;}
	
	public void setNota(int n) {nota = n;}
	
	public String getMateria() {return materia;}
	
	public int getNota() {return nota;}
}
