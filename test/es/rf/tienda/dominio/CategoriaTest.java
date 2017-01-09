package es.rf.tienda.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoriaTest {

	Categoria cat;
	
	@Before
	public void iniciar(){
		cat=new Categoria();
	}
	
	@Test
	public void testIsValid() {
		assertFalse(cat.isValid());
	}

	@Test
	public void testSetId_categoria() {
		cat.setId_categoria(69);
		assertEquals("setId_categoria", 69,cat.getId_categoria());
	}

	@Test
	public void testSetCat_nombre() {
		cat.setCat_nombre("categoria 1");
		assertEquals("setId_nombre", "categoria 1",cat.getCat_nombre());
	}

	@Test
	public void testSetCat_descripcion() {
		cat.setCat_descripcion("descripcion producto");
		assertEquals("setId_descri`pcion", "descripcion producto",cat.getCat_descripcion());
	}

}
