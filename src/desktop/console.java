package desktop;

import java.util.ArrayList;

import business.entities.Persona;
import business.logic.CtrlPersonaLogic;

public class console {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		CtrlPersonaLogic ctrPer = new CtrlPersonaLogic();
		
		//ArrayList<Persona> pers = ctrPer.getAll();
		
		Persona p=new Persona();
		
		String dni="37831713";
		
		p.setDni(dni);
		p= ctrPer.getByDni(p);
		
		System.out.println("la persona ess"+ p.getCategoriaPersona().getDescripcion());
	}

}
