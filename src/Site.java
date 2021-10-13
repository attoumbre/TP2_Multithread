
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

public void Emprunter() {
	currentNbVelo--;
}

public int getNumSite() {
	return numSite;
}

public void setNumSite(int numSite) {
	this.numSite = numSite;
}

public void Deposer() {

	currentNbVelo++;
}


}
