package util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CicloVidaListener implements PhaseListener {
	public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    public void beforePhase(PhaseEvent event) {
        System.out.println("\nINICIANDO FASE: " + event.getPhaseId() + " - " + getFase(event.getPhaseId().getOrdinal()));
    }

    public void afterPhase(PhaseEvent event) {
       // System.out.println("\nFINALIZANDO FASE: " + event.getPhaseId()  + " - " + getFase(event.getPhaseId().getOrdinal()));
    }
    private String getFase(int id) {
    	switch (id) {
		case 1:
			return "RESTAURAR VISÃO";
		case 2:
			return "APLICAR VALORES DA REQUISIÇÃO";
		case 3:
			return "PROCESSAR VALIDAÇÕES";
		case 4:
			return "ATUALIZAR VALORES DO MODELO";
		case 5:
			return "INVOCAR APLICAÇÃO";
		case 6:
			return "APRESENTAR RESPOSTA";
		default:
			return "FASE NÃO IDENTIFICACA";
		}
    }
}
