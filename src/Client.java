
public class Client extends Thread {
	
	private Site siteA;
	private Site siteB;
	
	public Client(Site siteA,Site siteB) {
		this.siteA=siteA;
		this.siteB=siteB;
	}
 
	public void emprunt() {
		//dormir s'il n'y a pas de velo cela se fera dans emprunter
		siteA.Emprunter();
		try {
			Thread.sleep(100*(siteB.getNumSite()-siteA.getNumSite()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		//dormir s'il peut pas deposer (dans deposer)
		siteB.Deposer();
	}
}
