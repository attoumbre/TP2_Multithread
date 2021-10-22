
public class Camion extends Thread{

	private Site[] site;
	private int nbVelo;
	
	//contructeur
	public Camion(Site[] site) {
		this.site= site;
		this.nbVelo=0;
	}
	
	public void voyager() {
		
		int i =0;
		
		while(i < site.length) {
			site[i].equilibrage(nbVelo);
			if(i==(site.length-1)) {
				try {
					Thread.sleep(100*(site[i].getNumSite()));
				} catch (Exception e) {
					
				}
			}else {
				try {
					Thread.sleep(100*(Math.abs(site[i].getNumSite()-site[i+1].getNumSite())));
				} catch (Exception e) {
					
				}
			}
			
			
			i++;
		}
		
	}
	
	public void run() {
		voyager();
	}

	

}
