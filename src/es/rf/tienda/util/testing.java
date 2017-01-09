package es.rf.tienda.util;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		if(Validator.isAlfanumeric("HHHaH6")) System.out.println(("TRUE"));
		
		if(Validator.cumplePhoneNumber(" 434 zss54 3")) System.out.println(("TRUE"));				
		
		if(Validator.isEmailValido("texto1@texto2.tld")) System.out.println(("TRUe"));
		
		if(Validator.cumpleDNI("45.868.674-G")) System.out.println(("truee"));
		
		//if(Validator.esFechaValida("03/01/2016")) System.out.println(("truee"));
		
		if(Validator.esPasswordValida("derA123dd@")) System.out.println(("truee"));
	}

}
