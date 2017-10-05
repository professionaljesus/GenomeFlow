package edu.missouri.chenglab.swingutilities;

import javax.swing.SwingWorker;

import edu.missouri.chenglab.hicdata.PreProcessingHiC;
import juicebox.tools.utils.original.NormalizationVectorUpdater;

public class ConvertToHiCWorker extends SwingWorker<String,Void> {
	
	private PreProcessingHiC preprocess;
	
	
	public ConvertToHiCWorker(PreProcessingHiC preprocess){
		this.preprocess = preprocess;		
	}
	@Override
	protected String doInBackground() throws Exception {
		
		preprocess.getPreprocessor().preprocess(preprocess.getInputFile());
        
        NormalizationVectorUpdater.updateHicFile(preprocess.getOutputFile()); 
        
		return "Convert to HiC done!";
	}
}