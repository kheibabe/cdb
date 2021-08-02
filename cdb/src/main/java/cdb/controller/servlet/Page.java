package cdb.controller.servlet;

public class Page {

	private int nbrElemPage = 10;
	private int numPage = 1;
	private int nbrElemDb;
	
	public Page() {
	}
	
	
	public Page(int nbrElemPage, int numPage, int nbrElemDb) {
		this.nbrElemPage = nbrElemPage;
		this.numPage = numPage;
		this.nbrElemDb = nbrElemDb;
	}
	
	public int getNbrePageMax() {
		if(nbrElemDb%nbrElemPage != 0) {
			return nbrElemDb/nbrElemPage + 1;
		}
		else {
			return nbrElemDb/nbrElemPage;
		}
		
	}
	
	public int getNbrElemDb() {
		return nbrElemDb;
	}
	public void setNbrElemDb(int nbrElemDb) {
		this.nbrElemDb = nbrElemDb;
	}
	public int getNumPage() {
		return numPage;
	}
	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}
	public int getNbrElemPage() {
		return nbrElemPage;
	}
	public void setNbrElemPage(int nbrElemPage) {
		this.nbrElemPage = nbrElemPage;
	}
	
	@Override
	public String toString() {
		return "Page [nbrElemPage=" + nbrElemPage + ", numPage=" + numPage + ", nbrElemDb=" + nbrElemDb + "]";
	}

	
}
