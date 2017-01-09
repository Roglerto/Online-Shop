package es.rf.tienda.dominio;

import javax.persistence.Entity;

import es.rf.tienda.interfaces.daos.Validable;
@Entity
public class Cliente  implements Validable{

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
