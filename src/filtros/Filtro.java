package filtros;

import java.util.LinkedList;
import java.util.List;

public class Filtro <E>{
	
	public final List<E> filtrar(List<E> unaListaDeElementos, Criterio<E> unCriterio){
		List<E> elementosFiltrados = new LinkedList<E>();
		for(E elemento : unaListaDeElementos){
			if(unCriterio.cumpleCriterioDeFiltro(elemento))
				elementosFiltrados.add(elemento);
		}
		return elementosFiltrados;
	}
}
