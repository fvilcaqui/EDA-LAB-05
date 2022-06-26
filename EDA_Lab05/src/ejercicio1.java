import java.util.*;
public class ejercicio1 {
	public static void main(String[] args) {
		String cadena="[[[}]]";
		ArrayList<String> entrada = new ArrayList<String>();
		Convertir(cadena,entrada);
        System.out.println("La cadena esta balanceada: " + isBalanced(entrada));    
	}
	public static void Convertir(String a,ArrayList<String> Array) {
		for(int i=0;i<a.length();i++) {
			char letra = a.charAt(i);
			String nuevo = String.valueOf(letra);
			Array.add(nuevo);
		}
	}
	public static String isBalanced(ArrayList<String> Array) {
		String a="";
		String b="";
		String resp = "";
		if(Array.size()%2 != 0) {
			return "no";
		}
		for(int i=0,j=Array.size()-1;i<Array.size()/2;i++,j--) {
			a = Array.get(i);
			b = Array.get(j);
			if((a.equals("(")&&b.equals(")"))||(a.equals("[")&&b.equals("]"))||(a.equals("{")&&b.equals("}"))) {
				resp = "si";
			}else {
				resp = "no";
				break;
			}
		}
		return resp;
	}

}
