package HashListaEnlazada;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class test {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
		ObjectOutputStream write=new ObjectOutputStream(new FileOutputStream("/Users/anthonyjhon/Documents/CODIGODEJAVA/Borrar/Escri.txt"));
		write.writeObject(new Empleado(2014,"anth",20) ); 
		write.writeObject(new Empleado(2015,"anth",20) );
		write.writeObject(new Empleado(2016,"anth",20) );
		write.writeObject(new Empleado(2017,"anth",20) );
		write.writeObject(new Empleado(2018,"anth",20) );
		write.writeObject(new Empleado(2019,"anth",20) ); 
		write.writeObject(new Empleado(2020,"anth",20) );
		write.writeObject(new Empleado(2021,"anth",20) );
		write.writeObject(new Empleado(2022,"anth",20) );
		write.writeObject(new Empleado(2023,"anth",20) );
		write.writeObject(new Empleado(2024,"anth",20) ); 
		write.writeObject(new Empleado(2025,"anth",20) );
		write.writeObject(new Empleado(2026,"anth",20) );
		write.writeObject(new Empleado(2027,"anth",20) );
		write.writeObject(new Empleado(2028,"anth",20) );
		write.writeObject(new Empleado(2029,"anth",20) ); 
		write.writeObject(new Empleado(2030,"anth",20) );
		write.writeObject(new Empleado(2031,"anth",20) );
		write.writeObject(new Empleado(2032,"anth",20) );
		write.writeObject(new Empleado(2033,"anth",20) );
		write.close();
		}catch(Exception E){
			
		}
		ObjectInputStream read = null;
		ArrayList<Empleado> list=new ArrayList<Empleado>();
		int i=0;
		try {
			read=new ObjectInputStream(new FileInputStream("/Users/anthonyjhon/Documents/CODIGODEJAVA/Borrar/Escri.txt"));
			while (true){
				Empleado e1=(Empleado)read.readObject();
				list.add(e1);
				System.out.println(e1);
				i++;
			}
		}catch(Exception E){
			
		}finally {read.close();}
		System.out.println("---------------------"+i);
		Hash<Empleado> j=new Hash<Empleado>(i);
		for (Empleado item:list) {
			j.insert(item);
		}
		System.out.println(j);
	}

}