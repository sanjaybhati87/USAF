/**
 * 
 */
package TestRunnerController;

/**
 * @author ssi248
 *
 */
public class Suite {
	
	private String suiteName;
	private String runFlag;
	/**
	 * @return the suiteName
	 */
	public String getSuiteName() {
		return suiteName;
	}
	/**
	 * @param suiteName the suiteName to set
	 */
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}
	/**
	 * @return the runFlag
	 */
	public String getRunFlag() {
		return runFlag;
	}
	/**
	 * @param runFlag the runFlag to set
	 */
	public void setRunFlag(String runFlag) {
		this.runFlag = runFlag;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Suite [suiteName=" + suiteName + ", runFlag=" + runFlag + "]";
	}
	
	

	
}
	

