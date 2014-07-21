package parsegarb;

/**
 * @author Watson
 * 
 * Still Under Heavy Construction. 
 *
 */
public class ConnectionHolder implements Comparable<ConnectionHolder>{
	private String proto;
	private String locadd;
	private String locprt;
	private String foradd;
	private String forprt;
	private String stt;
	private String ppid;

	public ConnectionHolder() {
		this(" " , " ", " ", " ", " ", " ", " ");
	}

	public ConnectionHolder(String protocol) {
		
		this(protocol, " ", " ", " ", " ", " ", " ");
	}
	
	public ConnectionHolder(String protocol, String localaddress, String localport, String foreignaddress, String foreignport,
			String state, String pid) {
		setProtocol(protocol);
		setLocalAddress(localaddress);
		setLocalPort(localport);
		setForeignAddress(foreignaddress);
		setForeignPort(foreignport);
		setState(state);
		setPID(pid);
		
	}

	public String getProtocol() {
		return proto;
	}

	public void setProtocol(String protocol) {
		this.proto = protocol;
	}

	public String getLocalAddress() {
		return locadd;
	}

	public void setLocalAddress(String localaddress) {
		this.locadd = localaddress;
	}

	public String getLocalPort() {
		return locprt;
	}

	public void setLocalPort(String localport) {
		this.locprt = localport;
	}

	public String getForeignaddress() {
		return foradd;
	}

	public void setForeignAddress(String foreignaddress) {
		this.foradd = foreignaddress;
	}

	public String getForeignport() {
		return forprt;
	}

	public void setForeignPort(String foreignport) {
		this.forprt = foreignport;
	}

	public String getState() {
		return stt;
	}

	public void setState(String state) {
		this.stt = state;
	}

	public String getPID() {
		return ppid;
	}

	public void setPID(String pid) {
		this.ppid = pid;
	}

	@Override
	public String toString() {
		return "Connections [getProtocol()=" + getProtocol()
				+ ", getLocalAddress()=" + getLocalAddress()
				+ ", getLocalPort()=" + getLocalPort()
				+ ", getForeignaddress()=" + getForeignaddress()
				+ ", getForeignport()=" + getForeignport() + ", getState()="
				+ getState() + ", getPID()=" + getPID() + "]";
	}

	@Override
	public int compareTo(ConnectionHolder arg0) {
		int i = -1;
		
		if(arg0.toString().equals(this.toString())) i=0;
		
		return i;
	}
	
	public boolean equals(ConnectionHolder arg0){
		if (this.compareTo(arg0)==0) return true;
		else return false;
	}
	
	
	
}
