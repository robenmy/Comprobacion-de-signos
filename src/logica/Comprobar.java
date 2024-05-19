package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Comprobar {

	 Stack<Integer> s = new Stack<Integer>();
	
	
	
	public void parseSigns(String address){
		
		int i=0;
		int aux = 0;
		String cadena;
		
		System.out.println("Procesando, Por Favor espere.......");
		System.out.println("");
		try {
			FileReader f1 = new FileReader(address);
			BufferedReader b = new BufferedReader(f1);
			while((cadena = b.readLine())!=null) {
			  // System.out.println(cadena);
			   //////////////////////////////
		
		
		int z = cadena.length();
		for(i=0; i<z;i++){
			
			
			if(cadena.charAt(i) == '{'){
				
				s.push( (int)cadena.charAt(i));
				
				
			}else if(cadena.charAt(i) == '('){
				
				s.push( (int)cadena.charAt(i));
				
				
			}else if(cadena.charAt(i) == '['){
				
				s.push( (int)cadena.charAt(i));
				
			
				/////////////////////////////////////////////////////////////////////////////////////////
			}else if(cadena.charAt(i) == '}'){
				
				if(!s.isEmpty()){
				aux = s.pop( );
				
				if(aux != 123){
				System.out.println("Error de sintaxis: El signo de cierre '}' no corresponde con:'"+(char)aux+"'");
				System.out.println("Error en caracter: "+(i+1));
				s.clear();
				}
				}else{
					System.out.println("El signo de cierre '}' no tiene su signo de agrupacion correspondiente a cerrar");
				}
				
			}else if(cadena.charAt(i) == ']'){
				
				if(!s.isEmpty()){
				aux = s.pop( );
				if(aux != 91){
				System.out.println("Error de sintaxis:  El signo de cierre ']' no corresponde con:'"+(char)aux+"'");
				System.out.println("Error en caracter: "+(i+1));
				s.clear();
				}
				}else{
					System.out.println("El signo de cierre ']' no tiene su signo de agrupacion correspondiente a cerrar");
				}
				
			}else if(cadena.charAt(i) == ')'){
				
				if(!s.isEmpty()){
				aux = s.pop( );
				if(aux != 40){
				System.out.println("Error de sintaxis:  El signo de cierre ')' no corresponde con:'"+(char)aux+"'");
				System.out.println("Error en caracter: "+(i+1));
				s.clear();
				}
				}else{
					System.out.println("El signo de cierre ')' no tiene su signo de agrupacion correspondiente a cerrar");
				}
				
			}
			
		
		}
		

		
			}
			int p=0;
			
			if(!s.isEmpty()){
				 p=s.pop();
			System.out.println("");
				System.out.println("+++++Existe un signo abierto: '"+(char)p+"'  +++++");
			}
			System.out.println("");
			System.out.println("*******Analisis Finalizado********");
			
			b.close();
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
	
	

	

