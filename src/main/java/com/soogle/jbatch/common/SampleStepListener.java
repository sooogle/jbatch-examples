package com.soogle.jbatch.common;

import javax.batch.api.listener.StepListener;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;

public class SampleStepListener implements StepListener {
	
	@Inject
	private StepContext context;

	@Override
	public void afterStep() throws Exception {
		Exception ex = context.getException();
		ex.printStackTrace();
	}

	@Override
	public void beforeStep() throws Exception {
		
	}

}
