package Listeners;

import org.testng.ITestResult;
import org.testng.util.RetryAnalyzerCount;








public class Rerun extends RetryAnalyzerCount{
int count=0;
	@Override
	public boolean retryMethod(ITestResult result) {
		
		if(count<2) {
			count++;
			return true;
		}
		return false;
		
		
		
		
	}

}
