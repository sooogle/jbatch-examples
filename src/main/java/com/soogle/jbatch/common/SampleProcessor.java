package com.soogle.jbatch.common;

import javax.batch.api.chunk.ItemProcessor;

public class SampleProcessor implements ItemProcessor {

	/**
	 * この例のように、processItemの処理が何もない場合、
	 * JSLでProcessorを省略することも可能。
	 */
	@Override
	public Object processItem(Object arg0) throws Exception {
		System.out.println("[Processor] processItem: " + String.valueOf(arg0));
		return arg0;
	}

}
