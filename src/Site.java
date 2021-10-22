
class Site {

/* Constantes communes à tous les sites */

static final int STOCK_INIT = 5;
static final int STOCK_MAX = 10;
static final int BORNE_SUP = 8;
static final int BORNE_INF = 2;

private int numSite;
private int currentNbVelo= STOCK_INIT;

public Site(int numSite) {
	this.numSite= numSite;
	
}

public synchronized void Emprunter() {
	while (currentNbVelo==0 ) {
		try {
			//endormir l'atelier 
			wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	currentNbVelo--;
    
	System.out.println("nom Thread :"+Thread.currentThread().getName()+" le site "+numSite+ " le stock  contient "+currentNbVelo);
    notify();
	
}

public int getNumSite() {
	return numSite;
}

public void setNumSite(int numSite) {
	this.numSite = numSite;
}

public synchronized void Deposer() {
	while (currentNbVelo==STOCK_MAX) {
		try {
			//endormir l'atelier 
			wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	currentNbVelo++;
    System.out.println("nom Thread :"+Thread.currentThread().getName()+" le site "+numSite+ " le stock  contient "+currentNbVelo);
    //reveille le thread endormi 
    notify();
	
}

public void equilibrage( int nbVelo) {
	int cpt=0;
	numSite=0;
	if(currentNbVelo<=BORNE_INF ) {
		
		cpt+= STOCK_INIT -currentNbVelo;
		if(cpt<= nbVelo) {
			//currentNbVelo+=cpt;
			for(int i=1;i<=cpt;i++) {
				Deposer();
			}
			//deposer
			nbVelo=nbVelo-cpt;
			numSite++;
			
		}else {
			//currentNbVelo+=NbVelo;
			//deposer
			for(int i=1;i<=cpt;i++) {
				Deposer();
			}
			nbVelo=0;
			numSite++;
			
		}
	}else if(currentNbVelo>= BORNE_SUP ) {
		cpt+=currentNbVelo - STOCK_INIT;
		 {
			 for(int j=1;j<=cpt;j++) {
				 Emprunter();;
			 }
			 nbVelo=nbVelo+cpt;
			 numSite++;
			
		}
		
	}
}

}
