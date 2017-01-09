package es.rf.tienda.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.rf.tienda.exception.DomainException;

public class UsuarioTest {

	Usuario usu;
	
	@Before
	public void iniciar(){
		usu=new Usuario();
	}
	
	@Test (expected=DomainException.class)
	public void setUser_nombre()throws DomainException{
		usu.setUser_nombre("sd");
	}
	@Test 
	public void setUser_nombre2()throws DomainException{
		usu.setUser_nombre("sdsdsdsdsdsds dsdsddsdsd");
	}
	@Test (expected=DomainException.class)
	public void setUser_nombre3()throws DomainException{
		usu.setUser_nombre("sdsdsdsdsdsds dsdsddsdsddfdfdfdfdfdfdfdfdf"
				+ "dfdfddddddddddddddfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfd"
				+ "dfdfdfdfdfdfdfdfdfdfdfdfdfsdfsdfsdfsdfsdfsdfsdfssdfs"
				+ "dfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsf"
				+ "sdfsdfsdfsdfsdfsdfsdfsdf");
	}
	@Test 
	public void setUser_email()throws DomainException{
		usu.setUser_email("texto1@texto2.tld");
		System.out.println( usu.getUser_email());
		assertEquals("texto1@texto2.tld", usu.getUser_email());
	}
	@Test (expected=DomainException.class)
	public void setUser_email2()throws DomainException{
		usu.setUser_email("texto1texto2.tld");
	}
	
	@Test (expected=DomainException.class)
	public void setUser_email3()throws DomainException{
		usu.setUser_email("t.tld");
	}
	
	@Test (expected=DomainException.class)
	public void setUser_email4()throws DomainException{
		usu.setUser_email("sdsdsdsdsdsds dsdsddsdsddfdfdfdfdfdfdfdfdf"
				+ "dfdfddddddddddddddfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfd"
				+ "dfdfdfdfdfdfdfdfdfdfdfdfdfsdfsdfsdfsdfsdfsdfsdfssdfs"
				+ "dfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsdfsf"
				+ "sdfsdfsdfsdfsdfsdfsdfsdf");
	}
	
	@Test (expected=DomainException.class)
	public void setUser_pass()throws DomainException{
		usu.setUser_pass("1234r");
	}
	@Test 
	public void setUser_pass2()throws DomainException{
		usu.setUser_pass("1234r#@Masd");
	}
	@Test (expected=DomainException.class)
	public void setUser_pass3()throws DomainException{
		usu.setUser_pass("1234rfheurhyww@#fowqiMAOAUWHU2173GB#@");
	}
	
	@Test (expected=DomainException.class)
	public void setUser_dni()throws DomainException{
		usu.setUser_dni("45.868.674-p");
	}
	
	@Test 
	public void setUser_dni2()throws DomainException{
		usu.setUser_dni("45.868.674-G");
	}
	
	
	
}
